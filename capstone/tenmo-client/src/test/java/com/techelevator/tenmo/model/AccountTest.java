package com.techelevator.tenmo.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AccountTest {

 private Account account;

    @Before
    public void setUp() {
    this.account = new Account();
    }

    Account test = new Account();

    @Test
    public void get_Balance_Test() {
        test.setBalance(new BigDecimal("10"));

        BigDecimal expectedResult = new BigDecimal("10");
        BigDecimal actualResult = test.getBalance();

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void set_Balance_Test () {
        test.setBalance(new BigDecimal("20"));

        BigDecimal expectedResult = new BigDecimal("20");
        BigDecimal actualResult = test.getBalance();

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void get_Account_Id_Test() {
        test.setAccountId(12L);

        long expectedResult = 12L;
        long actualResult = test.getAccountId();

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void set_Account_Id_Test() {
        long newAccountID = 22L;
        test.setAccountId(newAccountID);

        long expectedResult = 22L;
        long actualResult = test.getAccountId();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void get_User_Id_Test() {
        test.setUserId(25L);

        long expectedResult = 25L;
        long actualResult = test.getUserId();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void set_User_Id_Test() {
        long newUserID = 98L;
        test.setUserId(newUserID);

        long expectedResult = 98L;
        long actualResult = test.getUserId();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void to_String_Test() {
        Account toPrint = new Account();
        toPrint.setUserId(34);
        toPrint.setAccountId(56);
        toPrint.setBalance(new BigDecimal("50.00"));

        String expectedResult = "AccountDTO{" + "accountId=" + 56 + ", userId=" + 34 + ", balance=" + "50.00" +'}';
        String actualResult = toPrint.toString();

        Assert.assertEquals(expectedResult,actualResult);
    }





}
