package year2.collections;

import java.util.LinkedList;

/**
 * Professor: R. Escalante
 * Class:     COSC-1437
 * Semester:  Spring 2019
 * Date:      March 28th, 2019
 *
 * @author    Johnathon Skidmore
 * @code      Main.java, Manager.java, Person.java
 * @since     2019-03-28
 */
public class Person {

    private String name;                    // Person object's Name
    private LinkedList<Person> contactList; // Person object's Friend-year2.lists.LinkedList

    /**
     * Constructor for Person object.
     * @param name The name of the Person object.
     */
    public Person(String name) {
        this.name = name;
        this.contactList = new LinkedList<>();
    }

    /**
     * Checking if the current Person object's year2.lists.LinkedList matches another Person object's year2.lists.LinkedList.
     * @param person The other Person object to make comparisons against.
     * @return The boolean value if they exist on each other's friend-list.
     */
    public boolean friendsWith(Person person) {
        LinkedList<Person> thisList = this.getContactList(), otherList = person.getContactList();
        return thisList.contains(person) || otherList.contains(this);
    }

    /**
     * Accessor for Person object's name. (String)
     * @return The current Person object's name.
     */
    public String getName() { return this.name; }

    /**
     * Accessor for Person object's contactList. (year2.lists.LinkedList)
     * @return The current Person object's friend-list.
     */
    public LinkedList<Person> getContactList() { return this.contactList; }
}
