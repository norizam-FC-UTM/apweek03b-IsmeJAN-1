import java.util.Scanner;

class BankAccount {


    String name;
    double balance;
    double dividendRate; // example: 0.05 = 5%
    String[] transactionHistory;
    int idx;


    // Constructors
    public BankAccount() {
    }


    public BankAccount(String name, double initialDeposit) {
        this.name = name;
        this.balance = initialDeposit;
        this.transactionHistory = new String[90];
        idx=0;
        // this.dividendRate = 0.0;
    }


    public double getBalance() {
        return this.balance;
    }


    public void createAccount(String name, double initDeposit) {
        this.name = name;
        this.balance = initDeposit;
        this.dividendRate = 0.0;
    }


    // Deposit money
    public void deposit(double amount) {
        balance = balance + amount;
        transactionHistory[idx] = "Deposit  "+amount;
        idx++;
        // too simple - need refinement
    }


    // Withdraw money
    public void withdraw(double amount) {
        balance = balance - amount;
        transactionHistory[idx] = "withdraw..."+amount;
        idx++;
        // too simple - need refinement
    }


    // Calculate dividend
    public double calculateDividend() {
        return balance * dividendRate;
    }


    // Apply dividend to balance
    public void applyDividend() {
        double dividend = calculateDividend();
        balance = balance + dividend;
        transactionHistory[idx] = "Add Dividend ...."+dividend;
        idx++;
    }


    public void printTransac(){
        for(int i=0; i<idx;i++){
            System.out.println(transactionHistory[i]);
        }
    }


    // Set dividend rate
    public void setDividendRate(double rate) {
        dividendRate = rate;
        // too simple - need refinement
    }


    // Display account information
    public void printObjectState() {
        System.out.println("\n===== ACCOUNT INFO =====");
        System.out.println("Name          : " + name);
        System.out.println("Balance       : RM " + balance);
        System.out.println("Dividend Rate : " + dividendRate * 100 + "%");
        System.out.println();
    }
}


public class App {


    public static void main(String[] args) {
        int[] finMark = { 88, 75, 60, 80, 90, 95, 77, 91, 77, 80 };
        for (int elem:finMark) {
            System.out.println(elem);
        }


        // finMark[0]=88;


        Scanner sc = new Scanner(System.in);
        System.out.println("===== BANK ACCOUNT SYSTEM =====");
        // create accs
        BankAccount acc1 = new BankAccount("ALI", 10.00);
        BankAccount a2 = new BankAccount("BALI", 10.00);
        BankAccount a3 = new BankAccount("CALI", 10.00);
        BankAccount a4 = new BankAccount("DALI", 10.00);
        BankAccount a5 = new BankAccount("EALI", 10.00);
        // call method to display info
        System.out.println(acc1);
        System.out.println(a2);
        System.out.println(a3);


        a3.deposit(575);
        a3.setDividendRate(0.125); // 12.5%
        a3.applyDividend();
        a3.printObjectState();


        BankAccount[] accArr = new BankAccount[7];
        System.out.println(accArr);
        System.out.println(accArr[0]);
        System.out.println(accArr[1]);
        System.out.println(accArr[2]);
        System.out.println(accArr[3]);
        System.out.println(accArr[4]);


        // lets assg
        accArr[0] = acc1;
        accArr[1] = a2;
        accArr[2] = a3;
        accArr[3] = new BankAccount("SITI", 500);
        accArr[4] = new BankAccount("SIVA", 100);
        accArr[5] = a4;
        accArr[6] = a5;


        // deposit another rm700 to siti
        accArr[3].deposit(700);


        // wd rm50 from siva
        accArr[4].withdraw(50);
        accArr[4].deposit(400);
        accArr[4].withdraw(200);


        for (int i = 0; i < 7; i++) { // print info - all accs
            accArr[i].printObjectState();
        }


        // end of year 2026, apply divid 7.5% to all acc
        // do the coding here // printout after add dividend
        for (int i = 0; i < 7; i++) {
            accArr[i].setDividendRate(0.075);
            accArr[i].applyDividend();
            accArr[i].printObjectState();
        }


        // search for acc w highest balance, then printinfo
        BankAccount temp = accArr[0]; //using enhanced loop
        for (BankAccount elem:accArr) {
            if (elem.getBalance() > temp.getBalance()) {
                temp = elem;
            }
        }
        System.out.println("Acc w highst bal...");
        temp.printObjectState();


        accArr[4].printTransac(); //Transactn for Siva’s Account


        System.out.println("===== END OF PROGRAM =====");


        // ArrayList<BankAccount> aList = new ArrayList<>();
        // aList.add(acc1);
        // aList.add(a2);
        // ((BankAccount) aList.get(0)).printObjectState();
        sc.close();
    }
}
