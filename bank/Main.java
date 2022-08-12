package bank;

import java.util.Scanner;


public class Main {

    boolean start = true;
    boolean accStart = true;
    String accOp;
    String userData;
    String pswData;
    String NewUsernameData;
    String newPswData;
    String stop;
    int userBalance;
    int newUserBalance;
    int userPos;
    int amountIn;
    int totalAmount;
    int totalAddBalance;
    int totalSubBalance;
    int amountOut;
    int picAction;

    public static void main(String[] args)  {
        Main mainObj = new Main();
        Account NewObj = new Account();

        // admin
        NewObj.AccountUsernameList.add("admin");
        NewObj.AccountPasswordList.add("admin22");
        NewObj.AccountBalanceList.add(15000);

        NewObj.AccountUsernameList.add("admin2");
        NewObj.AccountPasswordList.add("admin11");
        NewObj.AccountBalanceList.add(12000);

        // Start
        while (mainObj.accStart) {

            System.out.println("do you already have an account? ");
            Scanner newInput = new Scanner(System.in);
            String stOp = newInput.next();
            if (stOp.equals("yes") || stOp.equals("login")) {

                // username
                System.out.print("Username: ");

                mainObj.userData = newInput.next();

                // password
                System.out.print("Password: ");
                mainObj.pswData = newInput.next();
                mainObj.userPos = mainObj.userPos = NewObj.AccountUsernameList.indexOf(mainObj.userData);
                if (NewObj.AccountUsernameList.contains(mainObj.userData)
                        && NewObj.AccountPasswordList.contains(mainObj.pswData)) {
  
                    while (mainObj.accStart) {
                        NewObj.clearScreen();
                        System.out.println("wellcome to your account");
                        System.out.print("your balance is: ");
                        System.out.println(NewObj.getAccBalance(mainObj.userPos));
                        System.out.println("[1] add money to balance");
                        System.out.println("[2] get money from balance");
                        System.out.println("[3] exit");
                        System.out.println("pick action:");
                        mainObj.picAction = newInput.nextInt();

                        if (mainObj.picAction == 1) {
                            // putiing money
                            System.out.println("your balance is:");
                            System.out.println(NewObj.getAccBalance(mainObj.userPos));
                            System.out.println("put your amount that you want to put in your bank account: ");
                            mainObj.amountIn = newInput.nextInt();

                            mainObj.totalAddBalance = NewObj.getAccBalance(mainObj.userPos) + mainObj.amountIn;
                            System.out.println("your total balance in your account is: " + mainObj.totalAddBalance);
                            NewObj.AccountBalanceList.set(mainObj.userPos, mainObj.totalAddBalance);
                            System.out.println("type menu to go back to menu");
                            mainObj.accOp = newInput.next();
                            if (mainObj.accOp.equalsIgnoreCase("menu")) {
                                mainObj.accStart = true;

                            }

                        }

                        else if (mainObj.picAction == 2) {
                            // getting money
                            System.out.println("your balance is:");
                            System.out.println(NewObj.getAccBalance(mainObj.userPos));
                            System.out.println("put your amount that you want to get from your account: ");
                            mainObj.amountOut = newInput.nextInt();

                            if (mainObj.amountOut <= NewObj.getAccBalance(mainObj.userPos)) {
                                mainObj.totalSubBalance = NewObj.getAccBalance(mainObj.userPos) - mainObj.amountOut;
                                System.out.println("your total balance is: ");
                                System.out.println(mainObj.totalSubBalance);
                                NewObj.AccountBalanceList.set(mainObj.userPos, mainObj.totalSubBalance);
                                System.out.println("type menu to go back to menu");
                                mainObj.accOp = newInput.next();
                                if (mainObj.accOp.equalsIgnoreCase("menu")) {
                                    mainObj.accStart = true;
                                }
                            } else {
                                System.out.println("the amount " + mainObj.amountOut
                                        + " that you put in is over than your balance");
                                System.out.println("type menu to go back to menu");
                                mainObj.accOp = newInput.next();
                                if (mainObj.accOp.equalsIgnoreCase("menu")) {
                                    mainObj.accStart = true;
                                }
                            }
                        } else if (mainObj.picAction == 3) {
                            mainObj.accStart = false;
                        }
                    }
                }

                else {
                    System.out.println("ur password and username is wrong");
                }

                // new account
            } else if (stOp.equalsIgnoreCase("no")) {
                // username
                System.out.println("please enter your new username here: ");
                mainObj.NewUsernameData = newInput.next();
                NewObj.setAccUsername(mainObj.NewUsernameData);

                // password
                System.out.println("put your password here");
                mainObj.newPswData = newInput.next();
                NewObj.setAccPassword(mainObj.newPswData);
                System.out.print("place you first balance here: ");
                mainObj.newUserBalance = newInput.nextInt();
                NewObj.AccountBalanceList.add(mainObj.newUserBalance);
            } else {
                System.out.println(mainObj.userData + "your input is wrong");

            }

        }

    }
}
