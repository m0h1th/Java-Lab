import java.util.Scanner;

class Account
{
	String cust_name;
	long acc_no;
	String acc_type;
	int balance=0;

	public void credit(int amt)
	{
		balance+=amt;
	}
}

class CurrentAccount extends Account
{
	public void deposit(int amt)
	{
		credit(amt);
	}
	public void penalty()
	{
		if(balance<1000)
		{
			balance-=100;
		}
	}
	public void checkMinBalance()
	{
		if(balance<1000)
		{
			System.out.println("Minimum balance not maintained");
			penalty();
		}
		else
		{
			System.out.println("Minimum balance maintained");
		}
	}
	public int withdraw(int amt)
	{
		if(amt>balance)
		{
			System.out.println("Insufficient balance");
			return 0;
		}
		else
		{
			balance-=amt;
			return amt;
		}
	}
	public void checkBalance()
	{
		System.out.println("Balance: "+balance);
	}
}

class SavingsAccount extends Account
{
	public void deposit(int amt)
	{
		credit(amt);
	}
	public void addInterest()
	{
		credit(balance*5/100);
	}
	public int withdraw(int amt)
	{
		if(amt>balance)
		{
			System.out.println("Insufficient balance");
			return 0;
		}
		else
		{
			balance-=amt;
			return amt;
		}
	}
	public void checkBalance()
	{
		System.out.println("Balance: "+balance);
	}
}


public class L3Q3
{
	public static void main(String args[])
	{
		CurrentAccount ca = new CurrentAccount();
		SavingsAccount sa = new SavingsAccount();
		Scanner sc = new Scanner(System.in);
		int ch;
		do
		{
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Check Balance");
			System.out.println("4. Check Minimum Balance");
			System.out.println("5. Add Interest");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");
			ch = sc.nextInt();
			switch(ch)
			{
				case 1:
					System.out.print("Enter amount to deposit: ");
					int amt = sc.nextInt();
					ca.deposit(amt);
					sa.deposit(amt);
					break;
				case 2:
					System.out.print("Enter amount to withdraw: ");
					amt = sc.nextInt();
					ca.withdraw(amt);
					sa.withdraw(amt);
					break;
				case 3:
					ca.checkBalance();
					sa.checkBalance();
					break;
				case 4:
					ca.checkMinBalance();
					break;
				case 5:
					sa.addInterest();
					break;
				case 6:
					break;
				default:
					System.out.println("Invalid choice");
			}
		}while(ch!=6);
	}
}
