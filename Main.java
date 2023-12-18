// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

class Account {
  protected int accNum;
  protected String accHolder;
  protected double accBalance;

  public Account(int accNum, String accHolder, double accBalance) {
    this.accNum = accNum;
    this.accHolder = accHolder;
    this.accBalance = accBalance;
  }

  void deposit(double depAmount) {
    accBalance += depAmount;
    System.out.println("Deposit of $" + depAmount + " successful. New balance: $" + accBalance);

  }

  public void withdraw(double amount) {
    if (amount <= accBalance) {
      accBalance = accBalance - amount;
    } else {
      System.out.println("Insufficient funds. Withdrawal unsuccessful.");
    }

  }

  void displayInfo() {
    System.out.println("Account number: " + accNum);
    System.out.println("Account holder: " + accHolder);
    System.out.println("Account balance: " + accBalance);
  }

}

class SavingsAccount extends Account {
  private double interestRate;

  public SavingsAccount(int accNum, String accHolder, double accBalance, double interestRate) {
    super(accNum, accHolder, accBalance);
    this.interestRate = interestRate;
  }

  @Override
  public void withdraw(double amount) {

    if (accBalance - amount > 10) {
      accBalance = accBalance - amount;
    } else {
      System.out.println("Withdrawal would go below the minimum limit. Withdrawal unsuccessful.");
    }
  }
}

class CurrentAccount extends Account {
  private double overdraftLimit;

  public CurrentAccount(int accNum, String accHolder, double accBalance, double overdraftLimit) {
    super(accNum, accHolder, accBalance);
    this.overdraftLimit = overdraftLimit;
  }

  @Override
  public void withdraw(double amount) {

    if (amount <= accBalance + overdraftLimit) {
      accBalance = accBalance - amount;
      System.out.println("Withdrawal of $" + amount + " successful. New balance: $" + accBalance);
    } else {
      System.out.println("Exceeds overdraft limit. Withdrawal unsuccessful.");
    }
  }
}

class Main {
  public static void main(String[] args) {
    SavingsAccount savAcc = new SavingsAccount(123, "John Doe", 10000.0, 300);

    savAcc.deposit(600.0);
    savAcc.displayInfo();

    System.out.println();

    savAcc.withdraw(200.0);
    savAcc.displayInfo();

    System.out.println();

    CurrentAccount curAcc = new CurrentAccount(456, "Jane Doe", 100.0, 500.0);
    curAcc.withdraw(300.0);
    curAcc.displayInfo();

  }

  // @Test
  // void addition() {
  // assertEquals(2, 1 + 1);
  // }
}