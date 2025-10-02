
import java.time.LocalDateTime;
import java.util.Random;

public class BankAccount {
    private final String Name;
    private int balance;
    private final LocalDateTime Date;
    private boolean isBlocked;
    private final String number;

    public BankAccount(String ownerName) {
        this.Name = ownerName;
        this.balance = 0;
        this.Date = LocalDateTime.now();
        this.isBlocked = false;
        this.number = this.generateAccountNumber();
    }

    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();

        for(int i = 0; i < 8; ++i) {
            accountNumber.append(random.nextInt(10));
        }

        return accountNumber.toString();
    }

    public boolean deposit(int amount) {
        if (!this.isBlocked && amount > 0) {
            this.balance += amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean withdraw(int amount) {
        if (!this.isBlocked && amount > 0 && amount <= this.balance) {
            this.balance -= amount;
            return true;
        } else {
            return false;
        }
    }

    public boolean transfer(BankAccount otherAccount, int amount) {
        if (!this.isBlocked && !otherAccount.isBlocked && amount > 0 && amount <= this.balance) {
            return this.withdraw(amount) ? otherAccount.deposit(amount) : false;
        } else {
            return false;
        }
    }

    public String getOwnerName() {
        return this.Name;
    }

    public int getBalance() {
        return this.balance;
    }

    public LocalDateTime getOpeningDate() {
        return this.Date;
    }

    public boolean isBlocked() {
        return this.isBlocked;
    }

    public String getNumber() {
        return this.number;
    }

    public void setBlocked(boolean blocked) {
        this.isBlocked = blocked;
    }

    public String toString() {
        return String.format("Счет №%s {Владелец: '%s', Баланс: %d, Дата открытия: %s, Заблокирован: %s}", this.number, this.Name, this.balance, this.Date, this.isBlocked ? "Да" : "Нет");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (obj instanceof BankAccount) {
            BankAccount other = (BankAccount)obj;
            return this.number.equals(other.number);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return this.number.hashCode();
    }
}
