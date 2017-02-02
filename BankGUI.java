import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFrame;

public class BankGUI extends JFrame implements ActionListener
{
  private java.util.ArrayList<Account> accountList = new java.util.ArrayList();
  private java.awt.Container content;
  private int accountCount = 0;
  private int curIndex = 0;
  
  private Account curAcc;
  
  private Savings savAcc;
  
  private Loan loanAcc;
  
  private Checking checkAcc;
  
  private javax.swing.JLabel lblMsg;
  
  private java.io.ObjectInputStream inputstream;
  
  private java.io.ObjectOutputStream outstream;
  
  public static final long serialVersionUID = 1L;
  
  private javax.swing.JTextField txtaccountNumber;
  
  private javax.swing.JTextField txtbankName;
  
  private javax.swing.JTextField txtbankCity;
  
  private javax.swing.JTextField txtbalance;
  
  private javax.swing.JTextField txtaccountType;
  
  private javax.swing.JTextField txtMinBal;
  
  private javax.swing.JTextField txtAvgBal;
  private javax.swing.JTextField txtNoOfChecksUsed;
  private javax.swing.JTextField txtMonthPay;
  private javax.swing.JTextField txtDaysLate;
  private javax.swing.JPanel loanP;
  private javax.swing.JPanel checkingP;
  private javax.swing.JPanel savingsP;
  private javax.swing.JTabbedPane tabbedPane;
  
  public BankGUI()
  {
    setSize(1000, 300);
    setTitle("Account Data");
    this.content = getContentPane();
    this.content.setBackground(java.awt.Color.LIGHT_GRAY);
    this.content.setLayout(new java.awt.BorderLayout());
    javax.swing.JPanel localJPanel1 = new javax.swing.JPanel();
    
    localJPanel1.setBackground(java.awt.Color.YELLOW);
    localJPanel1.setLayout(new java.awt.GridLayout(3, 2));
    
    javax.swing.JPanel localJPanel2 = new javax.swing.JPanel();
    localJPanel2.add(new javax.swing.JLabel("Bank Name: "));
    this.txtbankName = new javax.swing.JTextField(30);
    localJPanel2.add(this.txtbankName);
    localJPanel2.setBackground(java.awt.Color.YELLOW);
    localJPanel1.add(localJPanel2);
    
    localJPanel2 = new javax.swing.JPanel();
    localJPanel2.add(new javax.swing.JLabel("Bank City: "));
    this.txtbankCity = new javax.swing.JTextField(30);
    localJPanel2.add(this.txtbankCity);
    localJPanel2.setBackground(java.awt.Color.YELLOW);
    localJPanel1.add(localJPanel2);
    
    localJPanel2 = new javax.swing.JPanel();
    localJPanel2.add(new javax.swing.JLabel("Account Number: "));
    this.txtaccountNumber = new javax.swing.JTextField(30);
    localJPanel2.add(this.txtaccountNumber);
    localJPanel2.setBackground(java.awt.Color.YELLOW);
    localJPanel1.add(localJPanel2);
    
    localJPanel2 = new javax.swing.JPanel();
    localJPanel2.add(new javax.swing.JLabel("Account balance: "));
    this.txtbalance = new javax.swing.JTextField(30);
    localJPanel2.add(this.txtbalance);
    localJPanel2.setBackground(java.awt.Color.YELLOW);
    
    localJPanel1.add(localJPanel2);
    localJPanel2 = new javax.swing.JPanel();
    localJPanel2.add(new javax.swing.JLabel("Account Type: "));
    this.txtaccountType = new javax.swing.JTextField(30);
    localJPanel2.add(this.txtaccountType);
    localJPanel2.setBackground(java.awt.Color.YELLOW);
    localJPanel1.add(localJPanel2);
    
    javax.swing.JPanel localJPanel3 = new javax.swing.JPanel();
    localJPanel3.setLayout(new java.awt.BorderLayout());
    javax.swing.JPanel localJPanel4 = new javax.swing.JPanel();
    localJPanel4.setBackground(java.awt.Color.CYAN);
    
    javax.swing.JButton localJButton = new javax.swing.JButton("Next");
    localJButton.addActionListener(this);
    localJPanel4.add(localJButton);
    
    localJButton = new javax.swing.JButton("Previous");
    localJButton.addActionListener(this);
    localJPanel4.add(localJButton);
    localJPanel3.add(localJPanel4, "West");
    this.lblMsg = new javax.swing.JLabel();
    localJPanel3.add(this.lblMsg, "East");
    this.content.add(localJPanel3, "South");
    
    this.content.add(localJPanel1, "North");
    //addWindowListener(new WindowDestroyer());
    
    javax.swing.JMenuBar localJMenuBar = new javax.swing.JMenuBar();
    javax.swing.JMenuItem localJMenuItem = new javax.swing.JMenuItem("Exit");
    localJMenuItem.addActionListener(this);
    localJMenuBar.add(localJMenuItem);
    setJMenuBar(localJMenuBar);
    
    this.tabbedPane = new javax.swing.JTabbedPane();
    
    this.checkingP = new javax.swing.JPanel();
    this.checkingP.setBackground(java.awt.Color.ORANGE);
    this.checkingP.setLayout(new java.awt.GridLayout(1, 2));
    localJPanel2 = new javax.swing.JPanel();
    localJPanel2.add(new javax.swing.JLabel("No of Checks Used: "));
    this.txtNoOfChecksUsed = new javax.swing.JTextField(30);
    localJPanel2.add(this.txtNoOfChecksUsed);
    localJPanel2.setBackground(java.awt.Color.ORANGE);
    this.checkingP.add(localJPanel2);
    
    this.tabbedPane.addTab("Checking account", this.checkingP);
    
    this.savingsP = new javax.swing.JPanel();
    this.savingsP.setBackground(java.awt.Color.ORANGE);
    this.savingsP.setLayout(new java.awt.GridLayout(2, 2));
    localJPanel2 = new javax.swing.JPanel();
    localJPanel2.add(new javax.swing.JLabel("Min Balance Required: "));
    this.txtMinBal = new javax.swing.JTextField(30);
    localJPanel2.add(this.txtMinBal);
    localJPanel2.setBackground(java.awt.Color.ORANGE);
    this.savingsP.add(localJPanel2);
    
    localJPanel2 = new javax.swing.JPanel();
    localJPanel2.add(new javax.swing.JLabel("Average Monthy Balance: "));
    this.txtAvgBal = new javax.swing.JTextField(30);
    localJPanel2.add(this.txtAvgBal);
    localJPanel2.setBackground(java.awt.Color.ORANGE);
    this.savingsP.add(localJPanel2);
    this.tabbedPane.addTab("Savings account", this.savingsP);
    
    this.loanP = new javax.swing.JPanel();
    this.loanP.setBackground(java.awt.Color.ORANGE);
    this.loanP.setLayout(new java.awt.GridLayout(1, 2));
    localJPanel2 = new javax.swing.JPanel();
    localJPanel2.add(new javax.swing.JLabel("Monthly payment: "));
    this.txtMonthPay = new javax.swing.JTextField(30);
    localJPanel2.add(this.txtMonthPay);
    localJPanel2.setBackground(java.awt.Color.ORANGE);
    this.loanP.add(localJPanel2);
    
    localJPanel2 = new javax.swing.JPanel();
    localJPanel2.add(new javax.swing.JLabel("Days Late: "));
    this.txtDaysLate = new javax.swing.JTextField(30);
    localJPanel2.add(this.txtDaysLate);
    localJPanel2.setBackground(java.awt.Color.ORANGE);
    this.loanP.add(localJPanel2);
    this.tabbedPane.addTab("Loan account", this.loanP);
    
    this.content.add(this.tabbedPane, "Center");
  }
  
  public static void main(String[] paramArrayOfString)
  {
    BankGUI localBankGUI = new BankGUI();
    localBankGUI.initialize();
    localBankGUI.setVisible(true);
  }
  
  public void actionPerformed(java.awt.event.ActionEvent paramActionEvent)
  {
    java.awt.Container localContainer = getContentPane();
    String str = paramActionEvent.getActionCommand();
    if (str.equals("Next")) {
      nextaccount();
    } else if (str.equals("Previous")) {
      previousaccount();
    } else if (str.equals("Exit"))
    {
      saveData();
      System.exit(0);
    }
    else {
      System.out.println("error in Command Interface");
    }
  }
  
  public void readData()
  {
    try
    {
      this.inputstream = new java.io.ObjectInputStream(new FileInputStream("accountdata.dat"));
      
      try
      {
        this.accountCount = 0;
        for (;;)
        {
          this.accountList.add((Account)this.inputstream.readObject());
          this.accountCount += 1;
        }
        
      }
      catch (java.io.EOFException localEOFException)
      {
        System.out.println("Entered EOF");
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        System.out.println("Class Error: " + localClassNotFoundException.getMessage());
      }
      this.inputstream.close();
    }
    catch (java.io.FileNotFoundException localFileNotFoundException)
    {
      System.out.println("File Error: " + localFileNotFoundException.getMessage());
    }
    catch (java.io.IOException localIOException)
    {
      System.out.println("IO Error in read file data: " + localIOException.getMessage());
    }
  }
  
  public void initialize()
  {
    readData();
    loadData();
    this.accountCount = this.accountList.size();
    this.curIndex = 0;
  }
  
  public void loadData()
  {
    this.curAcc = ((Account)this.accountList.get(this.curIndex));
    this.txtaccountNumber.setText(this.curAcc.getaccountNumber());
    this.txtbankCity.setText(this.curAcc.getBankCity());
    this.txtbankName.setText(this.curAcc.getBankName());
    this.txtbalance.setText(Double.toString(this.curAcc.getBalance()));
    this.txtaccountType.setText(this.curAcc.getAccountType());
    
    if (this.curAcc.getAccountType().equals("Checking"))
    {
      this.checkAcc = ((Checking)this.curAcc);
      this.txtNoOfChecksUsed.setText(Integer.toString(this.checkAcc.getNoOfChecks()));
      this.tabbedPane.setSelectedIndex(0);
    }
    else if (this.curAcc.getAccountType().equals("Savings"))
    {
      this.savAcc = ((Savings)this.curAcc);
      this.txtMinBal.setText(Double.toString(this.savAcc.getMinBal()));
      this.txtAvgBal.setText(Double.toString(this.savAcc.getAvgBal()));
      this.tabbedPane.setSelectedIndex(1);
    }
    else if (this.curAcc.getAccountType().equals("Loan"))
    {
      this.loanAcc = ((Loan)this.curAcc);
      this.txtMonthPay.setText(Double.toString(this.loanAcc.getMonthPay()));
      this.txtDaysLate.setText(Integer.toString(this.loanAcc.getDaysLate()));
      this.tabbedPane.setSelectedIndex(2);
    }
  }
  
  public void nextaccount()
  {
    if (this.curIndex == this.accountCount - 1) {
      this.lblMsg.setText("Already at last record     ");
    }
    else {
      this.lblMsg.setText("");
      this.curIndex += 1;
      loadData();
    }
  }
  
  public void previousaccount()
  {
    if (this.curIndex == 0) {
      this.lblMsg.setText("Already at first record     ");
    }
    else {
      this.lblMsg.setText("");
      this.curIndex -= 1;
      loadData();
    }
  }
  
  public void saveData()
  {
    try
    {
      this.outstream = new java.io.ObjectOutputStream(new FileOutputStream("accountdata.dat", false));
      
      for (Account localAccount : this.accountList)
      {
        this.outstream.writeObject(localAccount);
      }
      this.outstream.flush();
      this.outstream.close();
    }
    catch (java.io.IOException localIOException)
    {
      System.out.println("IO Error in saveData: " + localIOException.getMessage());
    }
  }
}
