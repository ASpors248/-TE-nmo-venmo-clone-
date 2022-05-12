package com.techelevator.tenmo.model;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TransferDTOTest {

    TransferDTO transferDTO = new TransferDTO();

    @Test
    public void SetTransferIdTest() {
        Long expected = 100L;
        transferDTO.setTransferId(100L);
        Assert.assertEquals(expected, transferDTO.getTransferId());
    }

    @Test
    public void SetAccountFromIDTest() {
        Long expected = 100L;
        transferDTO.setAccountFromId(100L);
        Assert.assertEquals(expected, transferDTO.getAccountFromId());
    }

    @Test
    public void SetAccountToIDTest() {
        Long expected = 100L;
        transferDTO.setAccountToId(100L);
        Assert.assertEquals(expected, transferDTO.getAccountToId());
    }


    @Test
    public void SetTransferTypeTest() {
        String expected = "expected";
        transferDTO.setTransferType("expected");
        Assert.assertEquals(expected, transferDTO.getTransferType());
    }

    @Test
    public void SetTransferStatusTest() {
        String expected = "expected";
        transferDTO.setTransferStatus("expected");
        Assert.assertEquals(expected, transferDTO.getTransferStatus());
    }

    @Test
    public void SetUserNameTest() {
        String expected = "expected";
        transferDTO.setUserName("expected");
        Assert.assertEquals(expected, transferDTO.getUserName());
    }

    @Test
    public void SetUserName2Test() {
        String expected = "expected";
        transferDTO.setUserName2("expected");
        Assert.assertEquals(expected, transferDTO.getUserName2());
    }

    @Test
    public void SetAmountTest() {
        BigDecimal expected = new BigDecimal(100);
        transferDTO.setAmount(BigDecimal.valueOf(100));
        Assert.assertEquals(expected,transferDTO.getAmount());
    }

    @Test
    public void SetIsFromCurrentUserTest() {
        Boolean expectedTrue = true;
        transferDTO.setFromCurrentUser(true);
        Assert.assertEquals(expectedTrue, transferDTO.getFromCurrentUser());
    }

    @Test
    public void ToStringTest() {
        String expected = "TransferDTO{" +
                "transferId=" + 1L +
                ", userName='" + "potato" + '\'' +
                ", amount=" + BigDecimal.valueOf(100) +
                '}';

        transferDTO.setTransferId(1L);
        transferDTO.setUserName("potato");
        transferDTO.setAmount(BigDecimal.valueOf(100));

        Assert.assertEquals(expected,transferDTO.toString());

    }

}
