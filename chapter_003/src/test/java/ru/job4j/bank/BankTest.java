package ru.job4j.bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * The Testing class for the {@code Bank} class.
 *
 * @author Alexander Petrenko (Lexer8@gmail.com)
 * @version 1.0
 * @since 23.03.2019
 */
public class BankTest {
    @Test
    public void whenAddNewUserThenUserAccountsContainsUser() {
        Bank bank = new Bank();
        User user = new User("Bond", "SA007");
        bank.addUser(user);
        assertThat(bank.getAllAccounts().containsKey(user), is(true));
    }

    @Test
    public void whenDeleteUserThenUserAccountsNOTContainsUser() {
        Bank bank = new Bank();
        User user = new User("Bond", "SA007");
        bank.addUser(user);
        assertThat(bank.getAllAccounts().containsKey(user), is(true));
        bank.deleteUser(user);
        assertThat(bank.getAllAccounts().containsKey(user), is(false));
    }

    @Test
    public void whenAddOneAccountToUserThenFoundAccount() {
        Bank bank = new Bank();
        User user = new User("Bond", "SA007");
        bank.addUser(user);
        Account userAccount = new Account(1000000D, "MI6");
        bank.addAccountToUser("SA007", userAccount);
        assertThat(bank.getUserAccounts("SA007").get(0), is(userAccount));
    }

    @Test
    public void whenAddFewAccountsToUserThenFoundAccounts() {
        Bank bank = new Bank();
        User user = new User("Bond", "SA007");
        bank.addUser(user);
        Account userAccount1 = new Account(1000000D, "MI6");
        Account userAccount2 = new Account(500D, "MyMoney");
        Account userAccount3 = new Account(2000D, "MoscowCalling");
        bank.addAccountToUser(user.getPassport(), userAccount1);
        bank.addAccountToUser(user.getPassport(), userAccount1);
        bank.addAccountToUser(user.getPassport(), userAccount2);
        bank.addAccountToUser(user.getPassport(), userAccount3);
        List<Account> expected = new ArrayList<>(
                Arrays.asList(userAccount1, userAccount2, userAccount3)
        );
        assertThat(bank.getUserAccounts(user.getPassport()), is(expected));
    }

    @Test
    public void whenDeleteAccountFromUserThenAccountNotExists() {
        Bank bank = new Bank();
        User user = new User("Bond", "SA007");
        bank.addUser(user);
        Account userAccount1 = new Account(1000000D, "MI6");
        Account userAccount2 = new Account(500D, "MyMoney");
        Account userAccount3 = new Account(2000D, "MoscowCalling");
        bank.addAccountToUser(user.getPassport(), userAccount1);
        bank.addAccountToUser(user.getPassport(), userAccount2);
        bank.addAccountToUser(user.getPassport(), userAccount3);
        List<Account> expected1 = new ArrayList<>(
                Arrays.asList(userAccount1, userAccount2, userAccount3)
        );
        assertThat(bank.getUserAccounts(user.getPassport()), is(expected1));
        bank.deleteAccountFromUser(user.getPassport(), userAccount2);
        List<Account> expected2 = new ArrayList<>(
                Arrays.asList(userAccount1, userAccount3)
        );
        assertThat(bank.getUserAccounts(user.getPassport()), is(expected2));
    }

    @Test
    public void whenUserTransferMoneyToExistingAccountThenSuccess() {
        Bank bank = new Bank();
        User bond = new User("Bond", "SUPERAGENT");
        User will = new User("Will", "FG12345678");
        Account bondAccount = new Account(1000D, "MI6");
        Account willAccount = new Account(0D, "MyMoney");
        bank.addUser(bond);
        bank.addUser(will);
        bank.addAccountToUser(bond.getPassport(), bondAccount);
        bank.addAccountToUser(will.getPassport(), willAccount);
        bank.transferMoney(bond.getPassport(), bondAccount.getRequisites(),
                will.getPassport(), willAccount.getRequisites(), 500D);
        assertThat(bank.getUserAccounts(bond.getPassport()).get(0).getValue(), is(500D));
        assertThat(bank.getUserAccounts(will.getPassport()).get(0).getValue(), is(500D));
    }

    @Test
    public void whenSenderHasNoMoneyThenFail() {
        Bank bank = new Bank();
        User bond = new User("Bond", "SUPERAGENT");
        User will = new User("Will", "FG12345678");
        Account bondAccount = new Account(1000D, "MI6");
        Account willAccount = new Account(0D, "MyMoney");
        bank.addUser(bond);
        bank.addUser(will);
        bank.addAccountToUser(bond.getPassport(), bondAccount);
        bank.addAccountToUser(will.getPassport(), willAccount);
        bank.transferMoney(bond.getPassport(), bondAccount.getRequisites(),
                will.getPassport(), willAccount.getRequisites(), 1500D);
        assertThat(bank.getUserAccounts(bond.getPassport()).get(0).getValue(), is(1000D));
        assertThat(bank.getUserAccounts(will.getPassport()).get(0).getValue(), is(0D));
    }

    @Test
    public void whenSenderTransferMoneyFromWrongAccountThenFail() {
        Bank bank = new Bank();
        User bond = new User("Bond", "SUPERAGENT");
        User will = new User("Will", "FG12345678");
        Account bondAccount = new Account(1000D, "MI6");
        Account willAccount = new Account(1000D, "MyMoney");
        bank.addUser(bond);
        bank.addUser(will);
        bank.addAccountToUser(bond.getPassport(), bondAccount);
        bank.addAccountToUser(will.getPassport(), willAccount);
        bank.transferMoney(bond.getPassport(), willAccount.getRequisites(),
                will.getPassport(), bondAccount.getRequisites(), 500D);
        assertThat(bank.getUserAccounts(bond.getPassport()).get(0).getValue(), is(1000D));
        assertThat(bank.getUserAccounts(will.getPassport()).get(0).getValue(), is(1000D));
    }
}
