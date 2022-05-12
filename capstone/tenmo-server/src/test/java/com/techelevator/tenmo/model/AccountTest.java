package com.techelevator.tenmo.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AccountTest {

    private Account account = new Account();

    @Test
    public void SetAccountIDTest() {
        long expected = 100;
        account.setAccountId(100);
        long actual = account.getAccountId();
        assertEquals(expected, actual);
    }

    @Test
    public void GetUserIdTest() {
        long expected = 100;
        account.setAccountId(100);
        long actual = account.getAccountId();
        assertEquals(expected, actual);
    }

    @Test
    public void SetUserIdTest() {
        account.setUserId(100);
        long expected = 100;
        Assert.assertEquals(expected, account.getUserId());
    }

    @Test
    public void getUserIdTest() {
        account.setUserId(100);
        long expected = 100;
        Assert.assertEquals(expected, account.getUserId());
    }

    @Test
    public void SetBalanceTest() {
        BigDecimal expected = new BigDecimal(100);
        account.setBalance(expected);
        assertEquals(expected, account.getBalance());
    }

    @Test
    public void GetBalanceTest() {
        BigDecimal expected = new BigDecimal(100);
        account.setBalance(expected);
        assertEquals(expected, account.getBalance());
    }

    @Test
    public void ToStringTest() {
        String expected = "AccountDTO{" +
                "accountId=" + 1 +
                ", userId=" + 2 +
                ", balance=" + BigDecimal.valueOf(3) +
                '}';
        account.setAccountId(1);
        account.setUserId(2);
        account.setBalance(BigDecimal.valueOf(3));

        Assert.assertEquals(expected,account.toString());

    }
}
