package year2.collections;

import java.util.HashMap;
import java.util.Scanner;

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
public class Manager {

    private HashMap<String, Person> personMap = new HashMap<>();      // Person-network HashMap ( "name", Person.class )
    private HashMap<String, Boolean> friendshipMap = new HashMap<>(); // Friendship HashMap     ( "name1*name2", Person.friendsWith() )

    /**
     * Constructor for Manager object.
     */
    public Manager() {
        try {
            this.init();
        } catch(Exception exception) { exception.printStackTrace(); }
    }

    /**
     * Starts the command-option routine.
     */
    private void init() {

        String[] options = { "CollectionsDemo commands:\n",
                "P <name> - Creates a Person with a given name. (Case-sensitive)\n",
                "F <name1> <name2> - Add a Person to each-other's friend array.\n",
                "U <name1> <name2> - Remove a Person from each-other's friend array.\n",
                "L <name> - List the friends of a given Person by name.\n",
                "Q <name1> <name2> - Query the friendship status of two Person objects.\n",
                "X - Exits the program.\n",
                "Enter command: "
        };
        for(String option : options) System.out.print(option);

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine(), name1, name2;

        while(!command.equalsIgnoreCase("x")) {

            try {
                if (command.contains(Character.toString(' '))) {
                    // Split the user's String phrase by spaces.
                    String[] parameters = command.split(Character.toString(' '));
                    String firstArg = parameters[0].toLowerCase(), secondArg, thirdArg;

                    switch (firstArg) {
                        case "p":
                            secondArg = parameters[1];
                            if(!secondArg.isEmpty()) {
                                this.personMap.put(secondArg, new Person(secondArg));
                                System.out.println(String.format("%s's profile was created. (Population: %d)", secondArg, this.personMap.size()));
                            } else {
                                System.out.println("Input arguments were malformed.");
                            }
                            break;

                        case "f":
                            secondArg = parameters[1];
                            thirdArg = parameters[2];
                            if (this.bothExist(secondArg, thirdArg)) {
                                Person personA = this.personMap.get(secondArg), personB = this.personMap.get(thirdArg);
                                if (!(personA.friendsWith(personB) || personB.friendsWith(personA))) {
                                    personA.getContactList().add(personB);
                                    personB.getContactList().add(personA);
                                    // Add Person objects to each-other's contact/friend list.
                                    this.friendshipMap.put(this.encodeString(personA.getName(), personB.getName()), personA.friendsWith(personB));
                                    System.out.println(String.format("%s and %s were added to each other's friend-list.", personA.getName(), personB.getName()));
                                } else {
                                    System.out.println(String.format("%s and %s are already friends.", personA.getName(), personB.getName()));
                                }
                            } else {
                                System.out.println("Input arguments were malformed.");
                            }
                            break;

                        case "u":
                            secondArg = parameters[1];
                            thirdArg = parameters[2];
                            if (this.bothExist(secondArg, thirdArg)) {
                                Person personA = this.personMap.get(secondArg), personB = this.personMap.get(thirdArg);
                                if (personA.friendsWith(personB)) {
                                    personA.getContactList().remove(personB);
                                    personB.getContactList().remove(personA);
                                    // Remove Person objects to each-other's contact/friend list.
                                    this.friendshipMap.remove(this.encodeString(personA.getName(), personB.getName()));
                                    System.out.println(String.format("%s and %s were removed from each other's friend-list.", personA.getName(), personB.getName()));
                                } else {
                                    System.out.println(String.format("%s and %s were never friends.", personA.getName(), personB.getName()));
                                }
                            } else {
                                System.out.println("Input arguments were malformed.");
                            }
                            break;

                        case "l":
                            secondArg = parameters[1];
                            if (this.personMap.containsKey(secondArg)) {
                                Person person = this.personMap.get(secondArg);
                                int size = person.getContactList().size();
                                if (size > 0) {
                                    System.out.println(String.format("Listing %d friend%s:", size, size == 1 ? "" : "s"));
                                    for (Person person1 : person.getContactList()) {
                                        System.out.println(String.format("  -  %s", person1.getName()));
                                    }
                                } else {
                                    System.out.println(String.format("%s has no friends.", person.getName()));
                                }
                            } else {
                                System.out.println(String.format("%s could not be located.", secondArg));
                            }
                            break;

                        case "q":
                            secondArg = parameters[1];
                            thirdArg = parameters[2];
                            if (this.bothExist(secondArg, thirdArg)) {

                                if (this.friendshipMap.containsKey(this.encodeString(secondArg, thirdArg))) {
                                    Person personA = this.personMap.get(secondArg), personB = this.personMap.get(thirdArg);

                                    if (personA.friendsWith(personB))
                                        System.out.println(String.format("Yes, %s and %s are friends. (true)", personA.getName(), personB.getName()));
                                    else
                                        System.out.println(String.format("No, %s and %s are not friends. (false)", personA.getName(), personB.getName()));
                                } else {
                                    System.out.println("Friendship status does not exist.");
                                }
                            }
                            break;

                        default:
                            command = this.prompt(scanner);
                            break;

                    }
                }

                command = this.prompt(scanner);

            } catch(Exception exception) {
                command = this.prompt(scanner);

            }
        }
    }

    /**
     * Determines if both names appear on the Person object HashMap.
     * @param secondArg The first name from the Person.class object.
     * @param thirdArg The second name from another Person.class object.
     * @return True if both people exist on the Person object HashMap from their key variable.
     */
    private boolean bothExist(String secondArg, String thirdArg) {
        return this.personMap.containsKey(secondArg) && this.personMap.containsKey(thirdArg);
    }

    /**
     * Prompts the user to input with keyboard.
     * @param scanner The current Scanner object that's reading buffered input.
     * @return The line written by the user to return a String object.
     */
    private String prompt(Scanner scanner) {
        System.out.print("Enter command: ");
        return scanner.nextLine();
    }

    /**
     * Encoded naming convention. ( "name1*name2" )
     * @param name1 - The first name from the Person.class object.
     * @param name2 - The second name from another Person.class object.
     * @return The conjoined String object exported out to a HashMap key.
     */
    private String encodeString(String name1, String name2) {
        char ASTERISK = '\u002A'; // *
        if(name1.compareTo(name2) > 0)
            return name1 + ASTERISK + name2;
        else
            return name2 + ASTERISK + name1;
    }
}
