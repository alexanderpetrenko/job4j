package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The {@code Bank} class provides banking operations.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 07.05.2019
 */
public class Bank {
    private final Map<User, List<Account>> userAccounts = new HashMap<>();

    /**
     * The method adds a new user to the database.
     *
     * @param user A user object.
     */
    public void addUser(User user) {
        this.userAccounts.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * The method deletes an existing user from the database.
     *
     * @param user A user object.
     */
    public void deleteUser(User user) {
        this.userAccounts.remove(user);
    }

    /**
     * The method opens a new banking account using Passport Data of User.
     *
     * @param passport Passport Data of User.
     * @param account  Object of a new User's account.
     */
    public void addAccountToUser(String passport, Account account) {
//        this.userAccounts.entrySet().stream()
//                .filter(userListEntry -> userListEntry.getKey().getPassport().equals(passport))
//                .findFirst()
//                .map(user -> user.getValue().add(account));
        List<Account> accounts = getUserAccounts(passport);
        if (accounts.indexOf(account) == -1) {
            accounts.add(account);
            this.userAccounts.put(getUserByPassport(passport), accounts);
        }
    }

    /**
     * The method closes an existing banking account using Passport Data of User.
     *
     * @param passport Passport Data of User.
     * @param account  Object of a existing User's account.
     */
    public void deleteAccountFromUser(String passport, Account account) {
        this.userAccounts.entrySet().stream()
                .filter(userListEntry -> userListEntry.getKey().getPassport().equals(passport))
                .forEach(user -> user.getValue().remove(account));
    }

    /**
     * The method returns all User's Accounts.
     *
     * @param passport Passport Data of User.
     * @return List of all banking accounts of the User.
     */
    public List<Account> getUserAccounts(String passport) {
        User user = getUserByPassport(passport);
        List<Account> accounts = new ArrayList<>();
        if (user != null) {
            accounts = this.userAccounts.get(user);
        }
        return accounts;
    }

    /**
     * The method searches a user using his Passport Data.
     *
     * @param passport Passport Data of User.
     * @return Object of User.
     */
    private User getUserByPassport(String passport) {
        return this.userAccounts.entrySet().stream()
                .filter(userListEntry -> userListEntry.getKey().getPassport().equals(passport))
                .findFirst().map(Map.Entry::getKey).orElse(null);
    }

    /**
     * The method searches a User's Account using Account's Requisite.
     *
     * @param requisite Requisite of banking Account.
     * @param accounts  List of User's Accounts.
     * @return An Object of User's banking Account.
     */
    private Account getAccountByRequisite(String requisite, List<Account> accounts) {
        return accounts.stream()
                .filter(account -> account.getRequisites().equals(requisite))
                .findFirst().orElse(null);
    }

    /**
     * The method provides banking transfer opertion.
     *
     * @param srcPassport   Passport Data of Sender.
     * @param srcRequisite  Sender's Account Requisite.
     * @param destPassport  Passport Data of recipient.
     * @param destRequisite Recipient's Account Requisite.
     * @param amount        Amount of money for sending.
     * @return {@code true}, if operation is successful; otherwise - {@code false}.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        Account srcAccount = getAccountByRequisite(srcRequisite, getUserAccounts(srcPassport));
        Account destAccount = getAccountByRequisite(destRequisite, getUserAccounts(destPassport));
        return (srcAccount != null) && srcAccount.transfer(destAccount, amount);
    }

    /**
     * The method returns all user's accounts.
     *
     * @return List of all users and their accounts.
     */
    public Map<User, List<Account>> getAllAccounts() {
        return this.userAccounts;
    }
}
