package pt.ual.bank.views;

import pt.ual.bank.controllers.Bank;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        Bank bank = null; // new BankClass();

        String name, idNumber, idType, birthday, address, email, phoneNumber;
        String clientId, accountId;

        switch (command.toUpperCase()) {
            case "RC":
                name = scanner.nextLine();
                idNumber = scanner.nextLine();
                idType = scanner.nextLine();
                birthday = scanner.nextLine();
                address = scanner.nextLine();
                email = scanner.nextLine();
                phoneNumber = scanner.nextLine();
                if (bank.hasClientByIdNumber(idNumber, idType)) {
                    System.out.println("Número de identificação existente.");
                } else {
                    clientId = bank.registerClient(name, idNumber, idType, birthday, address, email, phoneNumber);
                    System.out.println("Cliente registado com sucesso. O identificador é " + clientId);
                }
                break;
            case "AC":
                clientId = scanner.nextLine();
                name = scanner.nextLine();
                birthday = scanner.nextLine();
                address = scanner.nextLine();
                email = scanner.nextLine();
                phoneNumber = scanner.nextLine();
                if(!bank.hasClient(clientId)){
                    System.out.println("Cliente inexistente.");
                }
                else {
                    bank.updateClient(clientId, name, birthday, address ,email, phoneNumber);
                    System.out.println("Cliente alterado com sucesso");
                }
                break;
            case "NC":
                clientId = scanner.nextLine();
                double initialDepositAmount = Double.parseDouble(scanner.nextLine()); // "1000.0"
                if(!bank.hasClient(clientId)) {
                    System.out.println("Cliente inexistente.");
                }
                else {
                    String accountNumber = bank.openAccount(clientId, initialDepositAmount);
                    System.out.println("Conta criada com sucesso. O número é "+accountNumber+".");
                }
            case "ACC":
                clientId = scanner.nextLine();
                accountId = scanner.nextLine();
                if (!bank.hasClient(clientId)) {
                    System.out.println("Cliente inexistente.");
                }
                else if(bank.accountHasClient(accountId, clientId)) {
                    System.out.println("Cliente já associado.");
                }
                bank.addClientToAccount(accountId, clientId);
                System.out.println("Cliente associado a conta.");
            case "M":
                clientId = scanner.nextLine();
                accountId = scanner.nextLine();
                double amount = Double.parseDouble(scanner.nextLine());
                String date = scanner.nextLine();
                if (!bank.hasClient(clientId)) {
                    System.out.println("Cliente inexistente.");
                }
                else if(!bank.hasAccount(accountId)) {
                    System.out.println("Conta inexistente.");
                }
                bank.registerTransaction(accountId, clientId, amount, date);
                System.out.println("Movimento reigstado com sucesso");
            case "SC":
                accountId = scanner.nextLine();
                if(!bank.hasAccount(accountId)) {
                    System.out.println("Conta inexistente.");
                }
                double balance = bank.getAccountBalance(accountId);
                System.out.println("A conta tem saldo "+balance);
            default:
                System.out.println("Instrução inválida.");
        }
    }
}
