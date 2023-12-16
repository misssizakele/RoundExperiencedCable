// import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.jupiter.api.Test;

class Account {
  int accNum;
  String accHolder;
  double accBalance;

  public Account(int accNum, String accHolder, double accBalance) {
    this.accNum = accNum;
    this.accHolder = accHolder;
    this.accBalance = accBalance;
  }

  void deposit() {
    
  }

  void display() {
    
  }

  void displayInfo() {
    
  }

}

class SavingsAccount extends Account {
  private double interestRate;

  public SavingsAccount(int accNum, String accHolder, double accBalance, double interestRate) {
    super(accNum, accHolder, accBalance);
    this.interestRate = interestRate;
  }

  @override
  void withdraw() {
    
  }
}

class Main {
  public static void main(String[] args) {

  }

  // @Test
  // void addition() {
  // assertEquals(2, 1 + 1);
  // }
}