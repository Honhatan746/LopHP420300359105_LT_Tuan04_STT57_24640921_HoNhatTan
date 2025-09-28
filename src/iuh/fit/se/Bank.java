package iuh.fit.se;

import java.util.Arrays;

/**
 * Lớp Bank đại diện cho một ngân hàng, quản lý các tài khoản ngân hàng.
 */
public class Bank {
    private String name; // Tên của ngân hàng
    private BankAccount[] accounts; // Mảng lưu trữ các tài khoản ngân hàng
    private int count = 0; // Số lượng tài khoản hiện có trong ngân hàng

    /**
     * Constructor mặc định: tạo ngân hàng với tên "No Name" và tối đa 100 tài khoản.
     */
    public Bank() {
        this("No Name", 100);
    }

    /**
     * Constructor có tham số: cho phép đặt tên ngân hàng và số lượng tài khoản tối đa.
     */
    public Bank(String name, int numberOfAccount) {
        setName(name); // Gọi phương thức setName để kiểm tra và gán tên
        if (numberOfAccount > 0) {
            this.accounts = new BankAccount[numberOfAccount]; // Khởi tạo mảng tài khoản
        } else {
            throw new IllegalArgumentException("Number of accounts must be greater than 0"); // Nếu số lượng <= 0 thì báo lỗi
        }
    }

    /**
     * Thêm tài khoản mới vào ngân hàng.
     */
    public void addNew(String accountNumber, String accountName, double balance) {
        // Kiểm tra nếu ngân hàng đã đầy
        if (accounts.length == count) {
            throw new IllegalArgumentException("Bank is full");
        }

        // Kiểm tra trùng số tài khoản
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber().equalsIgnoreCase(accountNumber)) {
                throw new IllegalArgumentException("Account number already exists");
            }
        }

        // Thêm tài khoản mới vào mảng và tăng biến đếm
        accounts[count++] = new BankAccount(accountNumber, accountName, balance);
    }

    /**
     * Tìm tài khoản theo số tài khoản.
     *  accountNumber Số tài khoản cần tìm
     *  Đối tượng BankAccount nếu tìm thấy, ngược lại trả về null
     */
    public BankAccount find(String accountNumber) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber().equalsIgnoreCase(accountNumber)) {
                return accounts[i]; // Trả về tài khoản nếu tìm thấy
            }
        }
        return null; // Không tìm thấy thì trả về null
    }

    /**
     * Tính tổng số dư của tất cả tài khoản trong ngân hàng.
     * Tổng số dư
     */
    public double getTotalBalance() {
        double sum = 0.0;
        for (int i = 0; i < count; i++) {
            sum += accounts[i].getBalance(); // Cộng dồn số dư từng tài khoản
        }
        return sum;
    }

    /**
     * Lấy số lượng tài khoản hiện có trong ngân hàng.
     * Số lượng tài khoản
     */
    public int getNumberOfAccounts() {
        return count;
    }

    /**
     * Trả về mảng các tài khoản hiện có (sao chép để tránh thay đổi trực tiếp).
     * Mảng các tài khoản
     */
    public BankAccount[] getAccounts() {
        return Arrays.copyOf(accounts, count); // Trả về bản sao của mảng accounts
    }

    /**
     * Lấy tên ngân hàng.
     * Tên ngân hàng
     */
    public String getName() {
        return name;
    }

    /**
     * Thiết lập tên ngân hàng.
     *name Tên mới
     */
    public void setName(String name) {
        // Kiểm tra tên không được rỗng hoặc null
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("The bank name must not be null");
        }
        this.name = name;
    }
}