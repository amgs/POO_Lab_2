package pt.ual.bank.models;

public class AccountClass implements Account {
    private String accountId;
    private String clientId;
    private double balance;

    public AccountClass(String accountId, String clientId, double initialDepositAmount) {
        this.accountId = accountId;
        this.clientId = clientId;
        this.balance = initialDepositAmount;
    }
}
