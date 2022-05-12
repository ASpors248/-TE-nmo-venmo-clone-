package com.techelevator.tenmo.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TransferTest {

    private Transfer transfer;

    @Before
    public void setup() {
        this.transfer = new Transfer();
    }

    Transfer test = new Transfer();

    @Test
    public void get_Transfer_ID_Test() {
        test.setTransferId(56L);

        long expectedResult = 56L;
        long actualResult = test.getTransferId();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void set_Transfer_ID_Test() {

        long numToTest = 80L;
        test.setTransferId(numToTest);

        long expectedResult = 80L;
        long actualResult = test.getTransferId();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void get_Transfer_Type_ID_Test() {
        test.setTransferTypeId(2);

        long expectedResult = 2;
        long actualResult = test.getTransferTypeId();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void set_Transfer_Type_ID_Test() {
        int numToTest = 1;
        test.setTransferTypeId(1);

        long expectedResult = 1;
        long actualResult = test.getTransferTypeId();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void get_Transfer_Status_Id_Test() {
        test.setTransferStatusId(3);

        long expectedResult = 3;
        long actualResult = test.getTransferStatusId();

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void set_Transfer_Status_Id_Test() {
        int numToTest = 1;
        test.setTransferStatusId(numToTest);

        long expectedResult = 1;
        long actualResult = test.getTransferStatusId();

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void get_Account_From_Id_Test() {
        test.setAccountFromId(100L);

        long expectedResult = 100L;
        long actualResult = test.getAccountFromId();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void set_Account_From_Id_Test() {
        long numToTest = 690L;
        test.setAccountFromId(numToTest);

        long expectedResult = 690L;
        long actualResult = test.getAccountFromId();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void get_Account_To_Id_Test() {
        test.setAccountToId(1000L);

        long expectedResult = 1000L;
        long actualResult = test.getAccountToId();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void set_Account_To_Id_Test() {
        long numToTest = 87L;
        test.setAccountToId(numToTest);

        long expectedResult = 87L;
        long actualResult = test.getAccountToId();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void get_Transfer_Amount_Test() {
        test.setTransferAmount(new BigDecimal("500"));

        BigDecimal expectedResult = new BigDecimal("500");
        BigDecimal actualResult = test.getTransferAmount();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void set_Transfer_Amount_Test() {
        BigDecimal numToTest = new BigDecimal("1000");
        test.setTransferAmount(numToTest);

        BigDecimal expectedResult = new BigDecimal("1000");
        BigDecimal actualResult = test.getTransferAmount();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void to_String_Test() {
        Transfer toPrint = new Transfer();
        toPrint.setTransferAmount(new BigDecimal("590"));
        toPrint.setAccountFromId(56L);
        toPrint.setAccountToId(60L);
        toPrint.setTransferStatusId(3);
        toPrint.setTransferTypeId(1);
        toPrint.setTransferId(800L);

        String expectedResult = "Transfer{" + "transferId=" + 800L + ", transferTypeId=" + 1 + ", transferStatusId=" + 3 + ", accountFromId=" + 56L + ", accountToId=" + 60L + ", transferAmount=" +  "590" + '}';
        String actualResult = toPrint.toString();

        Assert.assertEquals(expectedResult,actualResult);


    }


}
