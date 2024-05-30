import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        ATMop obj = new ATMop();
    }
}

class Data {
    float balance;
}

class ATMop {
    float balance;
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, Data> map = new HashMap<>();

    ATMop() {
        System.out.println("****************************************************************");
        System.out.println("Welcome to our ATM");
        op();
    }

    public void op() {
        int pincode = getPincode("Enter Your pincode");

        if (map.containsKey(pincode)) {
            Data obj = map.get(pincode);
            menu(obj);
        } else {
            System.out.println("***********************************************************");
            System.out.println("Please create account first");
            int pin = getPincode("Set your pin code");
            Data obj = new Data();
            map.put(pin, obj);
            menu(obj);
        }
    }

    public void menu(Data obj) {
        System.out.println("****************************************************************");
        System.out.println("Please Enter Valid Number");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Check another account");
        System.out.println("5. exit");

        int x = sc.nextInt();
        if (x == 1) {
            check_balance(obj);
        } else if (x == 2) {
            deposit(obj);
        } else if (x == 3) {
            withdraw(obj);
        } else if (x == 4) {
            op();
        } else if (x == 5) {
            System.out.println("Thank you!");
        } else {
            System.out.println("Please Enter a valid number");
            menu(obj);
        }
    }

    public void check_balance(Data obj) {
        System.out.println("Your balance: " + obj.balance);
        menu(obj);
    }

    public void deposit(Data obj) {
        System.out.println("Enter your amount");
        float a = sc.nextFloat();
        obj.balance = obj.balance + a;
        System.out.println("Amount deposited Successfully !!!");
        menu(obj);
    }

    public void withdraw(Data obj) {
        System.out.println("Enter your amount");
        float a = sc.nextFloat();
        if (obj.balance >= a) {
            obj.balance = obj.balance - a;
            System.out.println("Amount withdrawn successfully!!");
        } else {
            System.out.println("Insufficient balance");
        }
        System.out.println("*************************************************************************");
        menu(obj);
    }

    private int getPincode(String prompt) {
        int pincode = -1;
        boolean valid = false;
        while (!valid) {
            System.out.println(prompt);
            pincode = sc.nextInt();
            if (pincode >= 1000 && pincode <= 9999) {
                valid = true;
            } else {
                System.out.println("Invalid PIN. Please enter a 4-digit PIN.");
            }
        }
        return pincode;
    }
}
