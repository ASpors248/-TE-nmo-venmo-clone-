package com.techelevator.tenmo.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class TransferDTOTest {

    private TransferDTO transferDTO;

    @Before
    public void setup() {
        this.transferDTO = new TransferDTO();
    }

    TransferDTO test = new TransferDTO();

    @Test
    public void get_Transfer_Status_Test() {
        test.setTransferStatus("Pending");

        String expectedResult = "Pending";
        String actualResult = test.getTransferStatus();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void set_Transfer_Status_Test() {
        String newStatus = "Approved";
        test.setTransferStatus(newStatus);

        String expectedResult = "Approved";
        String actualResult = test.getTransferStatus();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void get_User_Name_2_Test() {
        test.setUserName2("user2");

        String expectedResult = "user2";
        String actualResult = test.getUserName2();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void set_User_Name_2_Test() {
        String newName = "user3";
        test.setUserName2(newName);

        String expectedResult = "user3";
        String actualResult = test.getUserName2();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void get_From_Current_User_Test() {
        Boolean expected = false;
        Boolean actual = test.getFromCurrentUser();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void set_From_Current_User_Test() {
        test.setFromCurrentUser(true);

        Boolean expected = true;
        Boolean actual = test.getFromCurrentUser();

        Assert.assertEquals(expected,actual);
    }


    @Test
    public void get_Account_From_Id_Test() {
        test.setAccountFromId(19L);

        long expectedResult = 19L;
        long actualResult = test.getAccountFromId();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void set_Account_From_Id_Test() {
        long numToTest = 90L;
        test.setAccountFromId(numToTest);

        long expectedResult = 90L;
        long actualResult = test.getAccountFromId();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void get_Account_To_Id_Test() {
        test.setAccountToId(11L);

        long expectedResult = 11L;
        long actualResult = test.getAccountToId();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void set_Account_To_Id_Test() {
        long numToTest = 198L;
        test.setAccountToId(numToTest);

        long expectedResult = 198L;
        long actualResult = test.getAccountToId();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void get_Transfer_Type_Test() {
        test.setTransferType("Request");

        String expectedResult = "Request";
        String actualResult = test.getTransferType();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void set_Transfer_Type_ID_Test() {
        String newType = "Send";
        test.setTransferType(newType);

        String expectedResult = "Send";
        String actualResult = test.getTransferType();

        Assert.assertEquals(expectedResult,actualResult);
    }



    @Test
    public void get_Transfer_ID_Test() {
        test.setTransferId(60L);

        long expectedResult = 60L;
        long actualResult = test.getTransferId();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void set_Transfer_ID_Test() {

        long numToTest = 1778L;
        test.setTransferId(numToTest);

        long expectedResult = 1778L;
        long actualResult = test.getTransferId();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void get_User_Name_Test() {
        test.setUserName("user1");

        String expectedResult = "user1";
        String actualResult = test.getUserName();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void set_User_Name_Test() {
        String newName = "potato";
        test.setUserName(newName);

        String expectedResult = "potato";
        String actualResult = test.getUserName();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void get_Amount_Test() {
        test.setAmount(new BigDecimal("1000"));

        BigDecimal expectedResult = new BigDecimal("1000");
        BigDecimal actualResult = test.getAmount();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void set_Amount_Test() {
        BigDecimal numToTest = new BigDecimal("300");
        test.setAmount(numToTest);

        BigDecimal expectedResult = new BigDecimal("300");
        BigDecimal actualResult = test.getAmount();

        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void to_String_False_Test() {
        TransferDTO toPrint = new TransferDTO();
        toPrint.setAmount(new BigDecimal("590"));
        toPrint.setAccountFromId(80L);
        toPrint.setAccountToId(81L);
        toPrint.setTransferStatus("Approved");
        toPrint.setTransferType("Send");
        toPrint.setTransferId(50L);
        toPrint.setUserName2("Alex");
        toPrint.setUserName("Will");
        toPrint.setFromCurrentUser(false);


        String expectedResult = 50L + "      " + "From: " + "Will" + "       $" + "590";
        String actualResult = toPrint.toString();

        Assert.assertEquals(expectedResult,actualResult);


    }

    @Test
    public void to_String_True_Test() {
        TransferDTO toPrint = new TransferDTO();
        toPrint.setAmount(new BigDecimal("590"));
        toPrint.setAccountFromId(80L);
        toPrint.setAccountToId(81L);
        toPrint.setTransferStatus("Approved");
        toPrint.setTransferType("Send");
        toPrint.setTransferId(50L);
        toPrint.setUserName2("Alex");
        toPrint.setUserName("Will");
        toPrint.setFromCurrentUser(true);


        String expectedResult = 50L + "      " + "To: " + "Will" + "         $" + "590";
        String actualResult = toPrint.toString();

        Assert.assertEquals(expectedResult,actualResult);


    }

    @Test
    public void to_String_2_False_Test() {
        TransferDTO toPrint = new TransferDTO();
        toPrint.setAmount(new BigDecimal("590"));
        toPrint.setAccountFromId(80L);
        toPrint.setAccountToId(81L);
        toPrint.setTransferStatus("Approved");
        toPrint.setTransferType("Send");
        toPrint.setTransferId(50L);
        toPrint.setUserName2("Alex");
        toPrint.setUserName("Will");
        toPrint.setFromCurrentUser(false);


        String expectedResult = "Id: " + 50L + "\n" + "From: " + "Alex" + "\n" +
                "To: " + "Will"  + "\n" + "Type: " + "Send" + "\n" +
                "Status: " + "Approved" + "\n" + "Amount: $" + "590";
        String actualResult = toPrint.toString2();

        Assert.assertEquals(expectedResult,actualResult);

    }

    @Test
    public void to_String_2_True_Test() {
        TransferDTO toPrint = new TransferDTO();
        toPrint.setAmount(new BigDecimal("590"));
        toPrint.setAccountFromId(80L);
        toPrint.setAccountToId(81L);
        toPrint.setTransferStatus("Approved");
        toPrint.setTransferType("Send");
        toPrint.setTransferId(50L);
        toPrint.setUserName2("Alex");
        toPrint.setUserName("Will");
        toPrint.setFromCurrentUser(true);


        String expectedResult = "Id: " + 50L + "\n" + "From: " + "Will" + "\n" +
                "To: " + "Alex"  + "\n" + "Type: " + "Send" + "\n" +
                "Status: " + "Approved" + "\n" + "Amount: $" + "590";
        String actualResult = toPrint.toString2();

        Assert.assertEquals(expectedResult,actualResult);


    }


}
