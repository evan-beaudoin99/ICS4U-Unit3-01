/*
* This program solves
* the Tower of Hanoi riddle.
*
* @author  Evan Beaudoin
* @version 1.0
* @since   2024-05-13
*/
import java.util.Scanner;

final class Main {
    private Main() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }


    static void hanoi(final int numberOfDisks, final int startPeg,
                            final int endPeg) {
        // This function calculates where the disks should be placed in
    
        if (numberOfDisks == 1) {
            System.out.println("Move disk 1 from peg " + startPeg + " to peg "
                            + endPeg);
        } else {
            hanoi(numberOfDisks - 1, startPeg, 6 - startPeg - endPeg);
            System.out.println("Move disk " + numberOfDisks + " from peg " + startPeg + " to " + endPeg);
            hanoi(numberOfDisks -1, 6 - startPeg - endPeg, endPeg);
        }
    }


    public static void main(final String[] args) {
        final int startPeg = 1;
        final int endPeg = 3;

        System.out.println("Tower of Hanoi");

        // input
        Scanner userInput = new Scanner(System.in);
        System.out.print("\nHow many disks do you want?: ");

        try {
            int numberOfDisks = userInput.nextInt();
            System.out.println();
            if (numberOfDisks > 0) {
                // process
                hanoi(numberOfDisks, startPeg, endPeg);
            } else {
                System.out.println("\nPlease enter a positive integer");
            }
        } catch (Exception ex) {
            System.err.print("\nThis is not an integer");
        }

        System.out.println("\nDone.");
    }
}