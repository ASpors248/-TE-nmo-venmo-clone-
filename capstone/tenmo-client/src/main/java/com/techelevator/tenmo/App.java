package com.techelevator.tenmo;

import com.techelevator.tenmo.model.*;
import com.techelevator.tenmo.services.AccountService;
import com.techelevator.tenmo.services.AuthenticationService;
import com.techelevator.tenmo.services.ConsoleService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";

    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);

    private AuthenticatedUser currentUser;
    private AccountService accountService = new AccountService();
    private AccountDTO accountDTO;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        consoleService.printGreeting();
        loginMenu();
        if (currentUser != null) {
            mainMenu();
        }
    }

    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != 0 && currentUser == null) {
            consoleService.printLoginMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                handleRegister();
            } else if (menuSelection == 2) {
                handleLogin();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
                consoleService.pause();
            }
        }
    }

    private void handleRegister() {
        System.out.println("Please register a new user account");
        UserCredentials credentials = consoleService.promptForCredentials();
        if (authenticationService.register(credentials)) {
            System.out.println("Registration successful. You can now login.");
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleLogin() {

        try {
            UserCredentials credentials = consoleService.promptForCredentials();
            currentUser = authenticationService.login(credentials);
            accountService.setAuthToken(currentUser.getToken());
            if (currentUser == null) {
                consoleService.printErrorMessage();
            }
        } catch (NullPointerException e) {
            System.out.println("Incorrect Username or Password. Please retry or register.");
        }


    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                viewCurrentBalance();
            } else if (menuSelection == 2) {
                viewTransferHistory();
            } else if (menuSelection == 3) {
                viewPendingRequests();
            } else if (menuSelection == 4) {
                sendBucks();
            } else if (menuSelection == 5) {
                requestBucks();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

    private void viewCurrentBalance() {
        System.out.println("Your current account balance is: " + accountService.getBalance());


    }

    private void viewTransferHistory() {
        TransferDTO[] transfers = accountService.getCurrentUserTransfers();

        System.out.println("------------------------------");
        System.out.println("Transfers\nID" + "        From/To        Amount");
        System.out.println("------------------------------");
        for (TransferDTO transfer : transfers ) {
            System.out.println(transfer);
        }

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter transfer ID to view details (0 to cancel): ");
            String id = scanner.nextLine();
            Long transferId = Long.parseLong(id);
            if(transferId == 0) {
                mainMenu();
            }
            if(transferId > 0 ) {

                System.out.println("-----------------------------");
                System.out.println("Transfer Details");
                System.out.println("-----------------------------");
                accountService.getATransfer(transferId);
            }

        }catch (NumberFormatException e) {
            System.out.println("Numbers only please. Please enter a valid ID number.");
            viewTransferHistory();

        }




    }

    private void viewPendingRequests() {
        // TODO Auto-generated method stub

    }

    private void sendBucks() {
        User[] users = accountService.displayAllUsers();
        System.out.println("------------------------------");
        System.out.println("Users\nID" + "        Name");
        System.out.println("------------------------------");
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(currentUser.getUser().getUsername())) {
                continue;
            }
            System.out.println(user);
        }
        try {
            System.out.println("Enter ID of user you are sending to (0 to cancel):");
            Scanner scanner = new Scanner(System.in);
            String userId = scanner.nextLine();
            Long id = Long.parseLong(userId);
            if (id == 0) {
                mainMenu();
            }
            if (currentUser.getUser().getId().equals(id)) {
                System.out.println("Sorry, you can't transfer money to yourself");
                mainMenu();
            }
            if (id > 0) {
                System.out.println("Enter Amount:");
                String amount = scanner.nextLine();
                BigDecimal transferAmount = new BigDecimal(amount);
                if (transferAmount.compareTo(accountService.getBalance()) == 1) {
                    System.out.println("Insufficient Funds");
                    sendBucks();
                } else if ( transferAmount.compareTo(new BigDecimal("0")) <= 0 ) {
                    System.out.println("Cannot transfer a zero amount or negative value");
                    sendBucks();
                } else {
                    Transfer transfer = new Transfer();
                    transfer.setAccountFromId(currentUser.getUser().getId());
                    transfer.setAccountToId(id);
                    transfer.setTransferAmount(transferAmount);
                    accountService.sendTransfer(transfer);
                }

            }
        }catch (NumberFormatException e) {
            System.out.println("Invalid entry. Numbers only please. Enter a valid User ID and try again.");
        }


    }


    private void requestBucks() {
        // TODO Auto-generated method stub

    }

}
