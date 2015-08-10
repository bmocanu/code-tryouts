After so many challenges we want to go out and get some real fun, so we decided to go to a night club.
We have chosen the nicest club in the town and went there, all of us, including our dear friend "risk".
When we tried to enter, the club new security lock blocked us. Apparently "risk" was there the last week and he had to leave "early".
We are all in front of the club, sitting outside in cold, with no other club near and we can't enter because of
some java security. After trying to bribe the security man and failed we wanted to give up,
but our friend "risk" reminded us that we are programmers. Why not hack the lock?

```java
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
public class UltraExtraSuperDuperSecureNightClubDoor {

   private final Collection<String> people;

   public UltraExtraSuperDuperSecureNightClubDoor(Collection<String> people) {
     people = Collections.unmodifiableCollection(new ArrayList<String>(people));
     for (String person : people) {
       if (person.contains("risk")) {
          throw new SecurityException("High risk person found... Request discarded.");
       }
     }
     this.people = people;
   }
   public Collection<String> getPeople() {
     return people;
   }
   public void unlock() {
     if (people.contains("risk")) {
        System.out.println("Managed to bypass security? Let's go and have some fun!");
     }
   }
}
```

```java
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<String> people = new ArrayList<String>();
    people.add("tom");
    people.add("risk");
    UltraExtraSuperDuperSecureNightClubDoor door = new UltraExtraSuperDuperSecureNightClubDoor(people);
    door.unlock();
  }
}
```

You need to find a way to hack the security so we can all enter.
The security is considered hacked if "Managed to bypass security? Let's go and have some fun!" is printed on your SYS_OUT.

Rules:
* Only the Main class should be edited, your hack should only live there. Editing the other classes will not count as a valid solution.
* The solution is valid only if the message was printed by the UltraExtraSuperDuperSecureNightClubDoor class in the unlock method.