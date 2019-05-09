package year2.queues;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Pattern;

/**
 * Professor: R. Escalante
 * Class:     COSC-1437
 * Semester:  Spring 2019
 * Date:      May 2nd, 2019
 * Purpose:   Movie Ticket Queue program flow using year2.queues.LLQueue and year2.queues.ArrayQueue.
 *
 * @author    Johnathon Skidmore
 * @code      year2.queues.TicketQueue.java
 * @since     2019-04-30
 */
public class TicketQueue {

    public static void main(String[] args) {
        final String TITLE = "Movie Queue", RATING = "Rated R - Enter driver's license number: (8-digits)", SELECT = "Select %s's film of choice:";
        final String[] OPTIONS = { "Add student", "Check latest queued", "Exit" };
        LLQueue queue = new LLQueue(); // can be replaced with -> year2.queues.ArrayQueue queue = new year2.queues.ArrayQueue();

        int option = JOptionPane.showOptionDialog(null, "Perform operations for movie ticket queue:", TITLE,
                JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, OPTIONS, OPTIONS[0]);

        while(option != JOptionPane.CANCEL_OPTION && option != JOptionPane.CLOSED_OPTION) {

            if(option == JOptionPane.YES_OPTION) {
                String input = JOptionPane.showInputDialog("Enter student name:");
                while(input == null || input.equals(""))
                    input = JOptionPane.showInputDialog(null, "Re-enter student name:");

                System.out.println(String.format("%s was added to the queue.", input));
                queue.enqueue(input);

            } else if(option == JOptionPane.NO_OPTION) {
                if(!queue.isEmpty()) {
                    String first = queue.dequeue();
                    ArrayList<FilmEntry> entries = FilmEntry.init();
                    String[] movies = new String[entries.size()];
                    Object selection;
                    int ticketID = new Random().nextInt(200);
                    double price = 9.08;
                    FilmEntry entry = null;

                    for(int index = 0; index < entries.size(); index++)
                        movies[index] = entries.get(index).toString();

                    selection = JOptionPane.showInputDialog(null, String.format(SELECT, first), TITLE,
                            JOptionPane.QUESTION_MESSAGE, null, movies, movies[0]);

                    while(selection == null || selection.equals(""))
                        selection = JOptionPane.showInputDialog(null, String.format(SELECT, first), TITLE,
                                JOptionPane.QUESTION_MESSAGE, null, movies, movies[0]);

                    for(FilmEntry filmEntry : entries) 
                        if(selection.toString().contains(filmEntry.getName()))
                            entry = filmEntry;

                    if (entry != null && entry.isRatedR()) {
                        String input = JOptionPane.showInputDialog(RATING);
                        while(input == null || input.equals("") || input.length() != 8 || Pattern.matches("[a-zA-Z]+", input))
                            input = JOptionPane.showInputDialog(null, RATING);

                        System.out.println(String.format("%s has provided their ID (%s), proceed.", first, input));
                    }

                    System.out.println(String.format("\nName: %s\nMovie: %s\n", first, selection));
                    JOptionPane.showMessageDialog(null, String.format(
                            "MOVIE TICKET %d\n" +
                            "================\n" +
                            "Name: %s\n" +
                            "Movie: %s\n" +
                            "Price: $%s\n" +
                            "================",
                            ticketID, first, selection, price));
                }
            }

            if(!queue.isEmpty()) System.out.println(queue); else JOptionPane.showMessageDialog(null, "Movie line queue empty! (Currently no people)");

            option = JOptionPane.showOptionDialog(null, (!queue.isEmpty() ? "People currently in-line:\n" + queue + "\n\n" : "") + "Perform operations for movie ticket queue:", TITLE,
                    JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, OPTIONS, OPTIONS[0]);
        }

        System.out.println("Exiting...");
    }
}
