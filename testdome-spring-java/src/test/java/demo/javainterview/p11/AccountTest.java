package demo.javainterview.p11;

import org.junit.Assert;
import org.junit.Test;

public class AccountTest {
    private double epsilon = 1e-6;

    @Test
    public void accountCannotHaveNegativeOverdraftLimit() {
        Account account = new Account(-20);

        Assert.assertEquals(0d, account.getOverdraftLimit(), epsilon);
    }

    @Test
    public void accountCannotOverstepItsOverdraftLimit() {
        final double overdraftLimit = 100;
        Account account = new Account(overdraftLimit);

        Assert.assertFalse(account.withdraw(overdraftLimit + 10));
    }

    @Test
    public void accountDepositWithdrawCorrectAmount() {
        Account account = new Account(100);

        double deposit = 10;
        Assert.assertTrue(account.deposit(deposit));
        Assert.assertEquals(deposit, account.getBalance(), epsilon);

        double withdraw = 5;
        Assert.assertTrue(account.withdraw(withdraw));
        Assert.assertEquals(deposit - withdraw, account.getBalance(), epsilon);
    }

    @Test
    public void accountDepositWithdrawWillReturnCorrect() {
        Account account = new Account(100);

        Assert.assertTrue(account.deposit(10));
        Assert.assertFalse(account.deposit(-10));

        Assert.assertTrue(account.withdraw(5));
        Assert.assertFalse(account.withdraw(-5));
    }
}