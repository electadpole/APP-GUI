import java.io.Serializable;
import java.util.Locale;

public abstract class Account implements Serializable
{
  private String accountType;
  private String bankName;
  private String bankCity;
  private String accountNumber;
  private double balance;
  private java.text.NumberFormat nf = java.text.NumberFormat.getCurrencyInstance(Locale.US);
  
  public String getAccountType() {
    return this.accountType;
  }
  
  public String getBankCity()
  {
    return this.bankCity;
  }
  
  public Account getObj() {
    return this;
  }
  
  public String getBankName()
  {
    return this.bankName;
  }
  
  public String getaccountNumber() {
    return this.accountNumber;
  }
  
  public double getBalance()
  {
    return this.balance;
  }
  
  public java.text.NumberFormat getNF()
  {
    return this.nf;
  }
  
  public void getAccountInput(String paramString)
  {
    this.accountType = paramString;
    java.util.Scanner localScanner = new java.util.Scanner(System.in);
    System.out.print("Enter Bank Name: ");
    this.bankName = localScanner.nextLine();
    System.out.print("Enter Bank City: ");
    this.bankCity = localScanner.nextLine();
    System.out.print("Enter account Number: ");
    this.accountNumber = localScanner.nextLine();
    System.out.print("Enter account balance: ");
    this.balance = localScanner.nextDouble();
    localScanner.nextLine();
  }
}
