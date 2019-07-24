The next problem is about the implementation of a Singleton.

Let's say we have a nice class which has some business logic in it.

This class contains an object that is very expensive to compute.
What we would like is to have a lazy getter on it.

There are of course many ways of doing this...

```java
abstract class BrilliantClass {
  private boolean evaluated;
  private Object extremelyExpensiveValue; // You could work on a String for your implementation.

  public Object getExtremelyExpensiveValue() {
    if (!evaluated) {
      extremelyExpensiveValue = compute();
      evaluated = true;
    }
    return extremelyExpensiveValue;
  }

  abstract protected Object compute();
}
```

The challenge is to find an alternative implementation which can provide the same functionality,
but without having to rely on a conditional check (in other words NO IF statements in your solution,
including no ternary operator, for, while, switch or bit operators (or, and, xor, etc )).

Also, no reflection!