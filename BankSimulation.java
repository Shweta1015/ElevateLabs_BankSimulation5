import java.util.ArrayList;
import java.util.List;

class Account {
    private String accNum;
    private String accHolder;
    private double balance;
    private List<String> transactionHistory;

    public Account(String accNo, String accHolder, double initialBalance){
        this.accNum = accNo;
        this.accHolder = accHolder;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: "+initialBalance);
    }

    //Deposit
    public void deposit(double amount){
        if (amount > 0){
            balance += amount;
            transactionHistory.add("Deposite: "+amount+" | Balance: "+ balance);
            System.out.println("Deposite successful: "+ amount);
        }else {
            System.out.println("Deposite amount must be greater than 0!");
        }
    }

    //Withdraw
    public void withdraw(double amount){
        if (amount > 0 && amount <= balance){
            balance -= amount;
            transactionHistory.add("Withdraw: "+amount+" | Balance: "+balance);
            System.out.println("Withdraw successful: "+ amount);
        }else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    //get balance
    public double getBalance(){
        return balance;
    }

    //show transaction history
    public void showTransactionHistory(){
        System.out.println("\nTransaction History for "+ accHolder);
        for (String record: transactionHistory){
            System.out.println(record);
        }
    }
}

public class BankSimulation{
    public static void main(String[] args) {
        //Create an account
        Account acc1 = new Account("2903", "Shweta", 500000);

        //transactions
        acc1.deposit(100000);
        acc1.withdraw(10000);

        System.out.println("Final Balance: "+acc1.getBalance());
        acc1.showTransactionHistory();
    }
}
