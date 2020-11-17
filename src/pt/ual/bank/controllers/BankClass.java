package pt.ual.bank.controllers;

import pt.ual.bank.models.Account;
import pt.ual.bank.models.AccountClass;
import pt.ual.bank.models.Client;
import pt.ual.bank.models.ClientClass;

import java.util.List;

public class BankClass implements Bank {
    private List<Client> clients;
    private int clientIdSequence;
    private int accountIdSequence;

    @Override
    public boolean hasClientByIdNumber(String idNumber, String idType) {
        for (Client client : clients) {
            if(client.getIdType().equalsIgnoreCase(idType)) {
                if (client.getIdNumber().equalsIgnoreCase(idNumber)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String registerClient(String name, String idNumber, String idtype, String birthday, String address, String email, String phoneNumber) {
        String clientId = ""+this.clientIdSequence++;
        Client client = new ClientClass(clientId, name, idNumber, idtype, birthday, address, email, phoneNumber);
        clients.add(client);
        return clientId;
    }

    @Override
    public boolean hasClient(String clientId) {
        for (Client client : clients) {
            if(client.getClientId().equalsIgnoreCase(clientId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void updateClient(String clientId, String name, String birthday, String address, String email, String phoneNumber) {
        Client client = getClient(clientId);
        if(!name.isBlank()) {
            client.setName(name);
        }
        if(!birthday.isBlank()){
            client.setBirthday(birthday);
        }
        if(!address.isBlank()) {
            client.setAddress(address);
        }
        if(!email.isBlank()) {
            client.setEmail(email);
        }
        if(!phoneNumber.isBlank()) {
            client.setPhoneNumber(phoneNumber);
        }
    }

    private Client getClient(String clientId) {
        for (Client client : clients) {
            if (client.getClientId().equalsIgnoreCase(clientId)) {
                return client;
            }
        }
        return null;
    }

    @Override
    public String openAccount(String clientId, double initialDepositAmount) {
        Client client = getClient(clientId);
        String accountId = ""+accountIdSequence++;
        Account account = new AccountClass(accountId, clientId, initialDepositAmount);
        return accountId;
    }

    @Override
    public boolean accountHasClient(String accountId, String clientId) {
        return false;
    }

    @Override
    public void addClientToAccount(String accountId, String clientId) {

    }

    @Override
    public boolean hasAccount(String accountId) {
        return false;
    }

    @Override
    public void registerTransaction(String accountId, String clientId, double amount, String date) {

    }

    @Override
    public double getAccountBalance(String accountId) {
        return 0;
    }
}
