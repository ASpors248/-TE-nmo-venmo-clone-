package com.techelevator.tenmo.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TransferTest {

    Transfer transfer = new Transfer();

    @Test
    public void SetTransferIdTest() {
        long expected = 100;
        transfer.setTransferId(100);
        Assert.assertEquals(expected, transfer.getTransferId());
    }

    @Test
    public void GetTransferIdTest() {
        long expected = 100;
        transfer.setTransferId(100);
        Assert.assertEquals(expected, transfer.getTransferId());
    }

    @Test
    public void SetTransferTypeIDTest() {
        int expected = 100;
        transfer.setTransferTypeId(100);
        Assert.assertEquals(expected,transfer.getTransferTypeId());
    }

    @Test
    public void GetTransferTypeIDTest() {
        int expected = 100;
        transfer.setTransferTypeId(100);
        Assert.assertEquals(expected,transfer.getTransferTypeId());
    }

    @Test
    public void SetTransferStatusIdTest() {
        int expected = 100;
        transfer.setTransferStatusId(100);
        Assert.assertEquals(expected,transfer.getTransferStatusId());
    }

    @Test
    public void GetTransferStatusIdTest() {
        int expected = 100;
        transfer.setTransferStatusId(100);
        Assert.assertEquals(expected,transfer.getTransferStatusId());
    }

    @Test
    public void SetAccountFromIdTest() {
        long expected = 100;
        transfer.setAccountFromId(100);
        Assert.assertEquals(expected,transfer.getAccountFromId());
    }

    @Test
    public void GetAccountFromIdTest() {
        long expected = 100;
        transfer.setAccountFromId(100);
        Assert.assertEquals(expected,transfer.getAccountFromId());
    }

    @Test
    public void SetAccountToIdTest() {
        long expected =100;
        transfer.setAccountToId(100);
        Assert.assertEquals(expected,transfer.getAccountToId());
    }

    @Test
    public void GetAccountToIdTest() {
        long expected =100;
        transfer.setAccountToId(100);
        Assert.assertEquals(expected,transfer.getAccountToId());
    }

    @Test
    public void SetTransferAmountTest() {
        BigDecimal expected = new BigDecimal(100);
        transfer.setTransferAmount(BigDecimal.valueOf(100));
        Assert.assertEquals(expected,transfer.getTransferAmount());
    }

    @Test
    public void GetTransferAmountTest() {
        BigDecimal expected = new BigDecimal(100);
        transfer.setTransferAmount(BigDecimal.valueOf(100));
        Assert.assertEquals(expected,transfer.getTransferAmount());
    }

    @Test
    public void ToStringTest() {
        String expected = "Transfer{" +
                "transferId=" + 1 +
                ", transferTypeId=" + 2 +
                ", transferStatusId=" + 3 +
                ", accountFromId=" + 4 +
                ", accountToId=" + 5 +
                ", transferAmount=" + BigDecimal.valueOf(6) +
                '}';

        transfer.setTransferId(1);
        transfer.setTransferTypeId(2);
        transfer.setTransferStatusId(3);
        transfer.setAccountFromId(4);
        transfer.setAccountToId(5);
        transfer.setTransferAmount(BigDecimal.valueOf(6));

        Assert.assertEquals(expected,transfer.toString());

    }

}
