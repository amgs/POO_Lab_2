package pt.ual.bank.controllers;

public interface Bank {
    boolean hasClientByIdNumber(String idNumber, String idType);

    String registerClient(String name, String idNumber, String idtype, String birthday, String address, String email, String phoneNumber);

    boolean hasClient(String clientId);

    void updateClient(String clientId, String name, String birthday, String address, String email, String phoneNumber);

    String openAccount(String clientId, double initialDepositAmount);

    boolean accountHasClient(String accountId, String clientId);

    void addClientToAccount(String accountId, String clientId);

    boolean hasAccount(String accountId);

    void registerTransaction(String accountId, String clientId, double amount, String date);

    double getAccountBalance(String accountId);
}
