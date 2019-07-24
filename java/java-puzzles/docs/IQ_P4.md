A bank wanted a new feature to their online-banking mechanism to stop users from executing more transactions than allowed.
The bank would like to have a CAP limit of transactions per day for a user, so it won't be able to execute a transaction
if the limit is reached.

The transaction managing system was already implemented, so the bank hired a developer to add the CAP mechanism.

This is his solution:

```java
import java.util.HashSet;
import java.util.Set;

public class AccountManager {
  private static final int CAP = 100;
  private static final int WIN = 1000;
  private Set<Transaction> transactions = new HashSet<Transaction>();

  public synchronized void execute(Transaction trx) {
    if (transactions.size() >= CAP) {
      throw new IllegalStateException("Transactions limit reached! You have been
                                      caught !:(");
    } else {
      transactions.add(trx);
    }
  }

  public synchronized void check() {
    if (transactions.size() == WIN) {
      System.out.println("AccountManager HACKED!!! Yay :)");
    }
  }
}
```

```java
public class Transaction {
  public enum Type {
    DEPOSIT,
    WITHDRAW
  }

  private final Type type;
  private final long amount;

  public Transaction(Type type, long amount) {
    this.type = type;
    this.amount = amount;
  }

  public Type getType() {
    return type;
  }

  @Override
  public String toString() {
    return "Transaction [type=" + type + ", amount=" + amount + "]";
  }
}
```

He tested his code by running the following main:

```java
public class Main {
  public static void main(String args[]) {
    AccountManager manager = new AccountManager();
    for (int i = 0; i < 1000; i++) {
      manager.execute(new Transaction(Type.DEPOSIT, 1000));
    }
    manager.check();
  }
}
```

Running the main got him here:

```
Exception in thread "main" java.lang.IllegalStateException: Transactions limit reached! You have been caught! :(
```

This solution was sent to the bank, everyone was pleased with it.
After few months someone managed to bypass the CAPing mechanism. Your task is find a way to do the same.

If your hack is successful you should see "AccountManager HACKED!!! Yay :)" on your SYS_OUT.

Rules:
* only the Main class should be edited, your hack should only live there. Editing the other classes will not count as a valid solution.
* the solution is valid only if the message was printed by the AccountManager class in the check method.