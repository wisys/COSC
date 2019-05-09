package year2.queues;

import java.util.ArrayList;

/**
 * Professor: R. Escalante
 * Class:     COSC-1437
 * Semester:  Spring 2019
 * Date:      May 2nd, 2019
 * Purpose:   year2.queues.FilmEntry object for list of choices in the theater.
 *
 * @author    Johnathon Skidmore
 * @code      year2.queues.FilmEntry.java
 * @since     2019-04-30
 */
public class FilmEntry {
    private String name, rating;

    public FilmEntry(String name, String rating) {
        this.name = name;
        this.rating = rating;
    }

    public boolean isRatedR() {
        return this.rating.equals("R");
    }

    public String getName() { return name; }

    public String toString() { return this.name + " [" + this.rating + "]"; }

    public static ArrayList<FilmEntry> init() {
        ArrayList<FilmEntry> arrayList = new ArrayList<>();
        arrayList.add(new FilmEntry("Avengers: Endgame", "PG-13"));
        arrayList.add(new FilmEntry("The Curse of La Llorona", "R"));
        arrayList.add(new FilmEntry("UglyDolls", "PG"));
        arrayList.add(new FilmEntry("Pet Sematary (2019)", "R"));
        arrayList.add(new FilmEntry("The Intruder", "PG-13"));
        return arrayList;
    }
}
