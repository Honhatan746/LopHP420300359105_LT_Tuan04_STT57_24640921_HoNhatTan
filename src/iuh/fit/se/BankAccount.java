package iuh.fit.se;

public class BankAccount {
	private String accountNumber;
	private double balance;
	private String ownerName;
	/*Constructor mặc định: Tạo một tài khoản với số tài khoản "0000-0000-0000", tên chủ tài khoản "No Name" và số dư 0.0.*/
	public BankAccount() {
		this("0000-0000-0000", "No Name", 0.0);
	}
	/*Constructor có tham số: Cho phép khởi tạo tài khoản với thông tin cụ thể. Gọi các phương thức setAccountNumber, setOwnerName, và setBalance để đảm bảo dữ liệu hợp lệ.*/
	public BankAccount(String accountNumber, String ownerName,double balance) {
		setAccountNumber(accountNumber);
		setOwnerName(ownerName);
		setBalance(balance);
	}
	/*Nạp tiền vào tài khoản.
Nếu amount > 0, cộng số tiền vào số dư.
Nếu không, ném ra IllegalArgumentException với thông báo "Amount must be greater than 0".*/
	public void deposit(double amount) {
		if(amount > 0) {
			this.balance += amount;
		}else {
		 throw new IllegalArgumentException("Amount must be greater than 0");
		}
	}
	/*Rút tiền khỏi tài khoản.
	Nếu amount <= 0 hoặc lớn hơn số dư hiện tại, ném ra IllegalArgumentException.
	Nếu hợp lệ, trừ số tiền khỏi số dư.*/
	public void withdraw(double amount) {
		if(amount <= 0 || amount > this.balance) {
			throw new IllegalArgumentException("Amount must be greater than 0 and less than or equal to balance");
		}
		this.balance -= amount;
	}
	//setter
	public void setBalance(double balance) {
		if(balance < 0) {
			throw new IllegalArgumentException("Balance must be greater than or equal to 0");
		}
		this.balance = balance;
	}
	//getter
	public double getBalance() {
		return balance;
	}
	
	/*Chuyển tiền sang tài khoản khác.
Nếu amount > 0, thực hiện rút tiền từ tài khoản hiện tại và nạp tiền vào tài khoản other.
Không xử lý trường hợp amount <= 0, nên sẽ không làm gì nếu số tiền không hợp lệ.*/
	public void transfer(BankAccount other, double amount) {
		if(amount > 0) {
			this.withdraw(amount);
			other.deposit(amount);
		}
	}
	
	//getter
	public String getAccountNumber() {
		return accountNumber;
	}
	//setter
	public void setAccountNumber(String accountNumber) {
		if(accountNumber == "" ||accountNumber == null) {
		 throw new IllegalArgumentException("The account number must not be null");
		}
		this.accountNumber = accountNumber;
	}
	//getter
	public String getOwnerName() {
		return ownerName;
	}
	
	//setter
	public void setOwnerName(String ownerName) {
		if(ownerName == "" || ownerName == null) {
			throw new IllegalArgumentException("The owner name must not be null");
		}
		this.ownerName = ownerName;
	}
	
	//toString
	@Override
	public String toString() {
	return String.format("%s | %s | %.2f", accountNumber, ownerName, balance);	
	}
	
	
}
