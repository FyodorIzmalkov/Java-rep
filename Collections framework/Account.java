import java.math.BigDecimal;

public class Account {
    private BigDecimal amount;

    public Account(BigDecimal amount){
        this.amount = amount;
    }

    public BigDecimal getAmount(){
        return amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "amount=" + amount +
                '}';
    }
}
