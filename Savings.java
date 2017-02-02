import java.io.PrintStream;

public class Savings extends Account {
  private static final double FEE_PENALTY = 50.0D;
  double minBal = 0.0D;
  double avgBal = 0.0D;
  
  public double getMinBal()
  {
    return this.minBal;
  }
  
  public double getAvgBal()
  {
    return this.avgBal;
  }
  
  public void setMinBal(double paramDouble)
  {
    this.minBal = paramDouble;
  }
  
  public void setAvgBal(double paramDouble)
  {
    this.avgBal = paramDouble;
  }
  
  public void getSavingsInput()
  {
    java.util.Scanner localScanner = new java.util.Scanner(System.in);
    getAccountInput("Savings");
    System.out.print("Enter minimum balance: ");
    this.minBal = localScanner.nextDouble();
    System.out.print("Enter average balance: ");
    this.avgBal = localScanner.nextDouble();
  }
}
