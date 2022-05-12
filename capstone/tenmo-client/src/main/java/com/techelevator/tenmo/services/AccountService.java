package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.*;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.List;

public class AccountService {
    private static final String API_BASE_URL = "http://localhost:8080/";
    private final RestTemplate restTemplate = new RestTemplate();
    private String authToken = null;
    private AccountDTO accountDTO = new AccountDTO();

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    private HttpEntity<AccountDTO> makeAccountEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(this.authToken);
        HttpEntity<AccountDTO> entity = new HttpEntity<>(headers);

        return entity;
    }

    private HttpEntity<AccountDTO> makeAccountEntityFromUserId(long userId) {
        accountDTO.setUserId(userId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(this.authToken);
        HttpEntity<AccountDTO> entity = new HttpEntity<>(accountDTO, headers);

        return entity;
    }

    private HttpEntity<User> makeUserEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(this.authToken);
        HttpEntity<User> entity = new HttpEntity<>(headers);

        return entity;
    }

    private HttpEntity<Transfer> makeTransferEntity(Transfer transfer) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(this.authToken);
        HttpEntity<Transfer> entity = new HttpEntity<>(transfer, headers);

        return entity;
    }

    private HttpEntity<TransferDTO> makeTransferEntityWithoutObject() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(this.authToken);
        HttpEntity<TransferDTO> entity = new HttpEntity<>(headers);

        return entity;
    }

    private HttpEntity<TransferDTO> makeTransferEntitywithID() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(this.authToken);
        HttpEntity<TransferDTO> entity = new HttpEntity<>(headers);

        return entity;
    }


    public void sendTransfer(Transfer transfer) {
        try {
            Long newTransferId = restTemplate.exchange(API_BASE_URL + "transfer", HttpMethod.POST, makeTransferEntity(transfer), Long.class).getBody();

            System.out.println("Thank you. This transfer's ID is: " + newTransferId);

        } catch (RestClientResponseException | ResourceAccessException e) {
            System.out.println("Something went wrong");
        }
    }

    public BigDecimal getBalance() {

        BigDecimal balance = restTemplate.exchange(API_BASE_URL + "account", HttpMethod.GET, makeAccountEntity(), BigDecimal.class).getBody();
        return balance;
    }

    public User[] displayAllUsers() {
        User[] user = null;
        try {
            user = restTemplate.exchange(API_BASE_URL + "user", HttpMethod.GET, makeUserEntity(), User[].class).getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            System.out.println("Something went wrong");
        }
        return user;
    }

    public TransferDTO[] getCurrentUserTransfers () {
        TransferDTO[] transfers = null;
        try {
            transfers = restTemplate.exchange(API_BASE_URL + "transfer/user", HttpMethod.GET, makeTransferEntityWithoutObject(), TransferDTO[].class).getBody();

        } catch (RestClientResponseException | ResourceAccessException e) {
            System.out.println("Something went wrong");
        }
        return transfers;
    }

    public void getATransfer(Long transferId) {
        TransferDTO transferDTO1 = new TransferDTO();
        try {
            transferDTO1 = restTemplate.exchange(API_BASE_URL + "transfer/view" + transferId, HttpMethod.GET, makeTransferEntityWithoutObject(), TransferDTO.class).getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            System.out.println("Something went Wrong");
        }
        if (transferDTO1.getTransferId() == null) {
            System.out.println("Transfer not found. Please enter a valid Transfer ID");
        } else {
            System.out.println(transferDTO1.toString2());
        }

    }


}
