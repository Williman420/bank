package bank;

import java.util.ArrayList;


public class Account  { 

    ArrayList<String> AccountUsernameList = new ArrayList<String>();
    ArrayList<String> AccountPasswordList = new ArrayList<String>();
    ArrayList<Integer> AccountBalanceList = new ArrayList<Integer>();
    

    public void setAccUsername(String newAcc) {
        AccountUsernameList.add(newAcc);
    }

    public void setAccPassword(String newPass) {
        AccountPasswordList.add(newPass);
    }

    public void setAccBalance(int newAccBalance) {
        AccountBalanceList.add(newAccBalance);
    }

    public int getAccBalance(int Pos) {
        return AccountBalanceList.get(Pos);
    }

    public void clearScreen() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                // clear screen untuk windows
                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();
            }
        } catch (final Exception e) {
            System.out.println("Error karena: " + e.getMessage());
        }

    }

  

    public static void main(String[] args) {
    }
}
