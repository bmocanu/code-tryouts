Today we are teachers. We were asked to hold a lecture to a group of enthusiastic students.
They learned last time about methods and now would be a good time to teach  them javadoc.

Since the best way to learn is through practice, we asked them to write the javadoc for this problem.

```java
public class IForgotHowToMath {
  public static void main(String[] args) {
    System.out.println(add(1, 1));
  }
 
  public static int add(int a, int b) {
    return a + b;
  }
}
```

While checking the problems, we found a student who said in java doc that the program prints 22.
How can it print 22? Must be wrong.

We run the program and surprise, it prints 22.
We checked the code, he only added java doc. How is this possible?

Your job is to recreate the student's solution that prints 22 by only adding javadoc.

Rules:
* Only the IForgotHowToMath should be edited.
* Only java doc can be added.