import java.io.PrintStream;

public class Loan extends Account {
  private static final double FEE_PENALTY = 5.0D;
  private static final double FEE_RATE = 0.01D;
  double monthlyPay = 0.0D;
  int noOfDaysLate = 0;
  
  public int getDaysLate()
  {
    return this.noOfDaysLate;
  }
  
  public double getMonthPay()
  {
    return this.monthlyPay;
  }
  
  public void setDaysLate(int paramInt) {
    this.noOfDaysLate = paramInt;
  }
  
  public void setMonthPay(double paramDouble)
  {
    this.monthlyPay = paramDouble;
  }
  
  public void getLoanInput()
  {
    java.util.Scanner localScanner = new java.util.Scanner(System.in);
    getAccountInput("Loan");
    System.out.print("Enter Monthly Payment: ");
    this.monthlyPay = localScanner.nextDouble();
    localScanner.nextLine();
    System.out.print("Enter Days Late: ");
    this.noOfDaysLate = localScanner.nextInt();
    localScanner.nextLine();
  }
}
