package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private final Map<User, List<Account>> userAccounts = new HashMap<>();

    public void addUser(User user) {
        userAccounts.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        userAccounts.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        List<Account> accounts = getUserAccounts(passport);
        if (accounts.indexOf(account) == -1) {
            accounts.add(account);
            userAccounts.put(getUserByPassport(passport), accounts);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        List<Account> accounts = getUserAccounts(passport);
        if (accounts.indexOf(account) != -1) {
            accounts.remove(account);
            userAccounts.put(getUserByPassport(passport), accounts);
        }
    }

    public List<Account> getUserAccounts(String passport) {
        return userAccounts.get(getUserByPassport(passport));
    }

    private User getUserByPassport(String passport) {
        User found = null;
        for (Map.Entry<User, List<Account>> entry : userAccounts.entrySet()) {
            if (entry.getKey().getPassport().equals(passport)) {
                found = entry.getKey();
                break;
            }
        }
        return found;
    }

    private Account getAccountByRequisite(String requisite, List<Account> accounts) {
        Account found = null;
        for (Account account : accounts) {
            if (account.getRequisites().equals(requisite)) {
                found = account;
                break;
            }
        }
        return found;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean transferSuccess = false;
        Account srcAccount = getAccountByRequisite(srcRequisite, getUserAccounts(srcPassport));
        Account destAccount = getAccountByRequisite(destRequisite, getUserAccounts(destPassport));
        if ( srcAccount != null && destAccount != null && srcAccount.getValue() >= amount) {
            srcAccount.setValue(srcAccount.getValue() - amount);
            destAccount.setValue(destAccount.getValue() + amount);
            transferSuccess = true;
        }
        return transferSuccess;
    }
}
