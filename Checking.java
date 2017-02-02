import java.io.PrintStream;

public class Checking extends Account
{
  int noOfChecksUsed = 0;
  
  public int getNoOfChecks()
  {
    return this.noOfChecksUsed;
  }
  
  public void setNoOfChecks(int paramInt)
  {
    this.noOfChecksUsed = paramInt;
  }
  
  public void getCheckingInput()
  {
    java.util.Scanner localScanner = new java.util.Scanner(System.in);
    getAccountInput("Checking");
    System.out.println("Enter No checks used: ");
    this.noOfChecksUsed = localScanner.nextInt();
    localScanner.nextLine();
  }
}
