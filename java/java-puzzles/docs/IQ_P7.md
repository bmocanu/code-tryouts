Greece received a new loan in order to get back on its tracks, meanwhile the ATM crisis remains.
In order to receive the loan, they had to make some hard decisions like increasing taxes for example.

They also found an issue in the ATM software, somehow there were some people who managed to get more the 60 euros per day.
This is a simplified version of the new Greek ATM.

```java
public class SecureATM {
  private static final int MAX_AMOUNT = 60; //Euros
  private int current = 0;

  public synchronized void withdraw(int amount) {
    current += amount ;
     if (current> MAX_AMOUNT) {
      reset();
    }
  }

  private void reset(){
    current = MAX_AMOUNT;
  }

  public synchronized void checkIfHacked() {
    if (current > MAX_AMOUNT) {
      System.out.println("Someone is rich :P!");
    }
  }
}
```

```java
public class Person {
  public static void main(String[] args) {
    SecureATM atm = new SecureATM();
    atm.withdraw(100);
    atm.checkIfHacked();
  }
}
```

You need to find a way to withdraw more than 60 euros.
It is considered that you withdrew more than 60 euros if  "Someone is rich :P" is printed on your SYS_OUT.

Rules:
* Only the Person class should be edited, your hack should only live there. Editing the other classes will not count as a valid solution.
* The solution is valid only if the message was printed by the SecureATM class in checkIfHacked method