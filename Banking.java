public class Banking extends Method {
    private String accountNumber;

    public Banking(String accountNumber) {
        this.type = "BANKING";
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
} 