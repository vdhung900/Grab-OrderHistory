public class EWallet extends Method {
    private String accountNumber;

    public EWallet(String accountNumber) {
        this.type = "E_WALLET";
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
} 