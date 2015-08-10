We all know about the current situation in Greece. Greeks are not allowed to withdraw more than 60 euros from their ATM's per day.
This is a simplified version of a Greek ATM.

```java
public class ATM {
  private static final int MAX_AMOUNT = 60; //Euros
  private int current = 0;
 
  public synchronized void withdraw(int amount) {
    if (amount > MAX_AMOUNT - current) {
      return;
    }
    current += amount;
  }
 
  public synchronized void checkIfHacked() {
    if (current > MAX_AMOUNT) {
      System.out.println("Someone is rich :P!");
    } else {
      System.out.println("Maximum limit exceeded, try again tomorrow");
    }
  }
}
```

```java
public class Person {
  public static void main(String[] args) {
    ATM atm = new ATM();
    atm.withdraw(100);
    atm.checkIfHacked();
  }
}
```

You need to find a way to withdraw more than 60 euros.
It is considered that you withdrew more than 60 euros if  "Someone is rich :P" is printed on your SYS_OUT.

Rules:
* Only the Person class should be edited, your hack should only live there. Editing the other classes will not count as a valid solution.
* The solution is valid only if the message was printed by the ATM class in checkIfHacked method