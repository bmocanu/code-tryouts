package ro.bmocanu.javapuzzles.iq.p5;

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