Let's try to hide a rabbit this time.
We have these classes.

```java
// DO NOT EDIT
public class Rabbit {
  private int rabbitometer;
  public synchronized int enter(Hole hole) {
    rabbitometer++;
    try {
      hole.enter(this);
    } finally {
      rabbitometer--;
    }
    return rabbitometer;
  }
}
```

```java
// HACK AROUND FREELY TO GET TO THE BOTTOM OF THE RABBIT HOLE :)
public class Hole {
  public void enter(Rabbit rabbit) {

  }
}
```

```java
public class Main {
  public static void main(String[] args) {
    Rabbit theWhiteRabbit = new Rabbit();
    if (theWhiteRabbit.enter(new Hole()) != 0) {
      System.out.println("Yeahhh, I managed to hide rabbits down the hole....");
    }
  }
}
```

We create a rabbit, we enter a hole, and we expect the counter to be 0 due to the semantics
The challenge is to edit the Hole class so when Main is run, the output of the program would
be "Yeahhh, I managed to hide rabbits down the hole....".

You are allowed to edit ONLY the Hole class.