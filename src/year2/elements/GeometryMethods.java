package year2.elements;/*
 * COSC1437 - Assignment #2
 *   Objectives:
 *   - Throw checked exceptions from methods
 *   - Catch checked exceptions
 *   - Adding proper Javadoc comments
 *
 * Original Author / Professor: R. Escalante-Ruiz
 * Author: Johnathon Skidmore
 * Date: February 6th, 2019
 * Class: Java II (COSC1437)
 * Time: TR 8am - 9:50am (Tuesdays-Thursdays)
 *
 */

import java.util.Scanner;

public class GeometryMethods {

    /** Prints a menu of options to the user */
    private static void printMenu() {
        System.out.println("This program computes various geometric values");
        System.out.println("----------------------------------------------");
        System.out.println("Select an option:");
        System.out.println("1) Compute the area of a circle");
        System.out.println("2) Compute the area of a rectangle");
        System.out.println("3) Compute the area of a triangle");
        System.out.println("4) Compute the circumference of a circle");
        System.out.println("5) Compute the circumference of a rectangle");
        System.out.println("6) Compute the circumference of a triangle");
    }

    public static void main(String[] args) {
        int choice;            //the user's choice
        double value = 0;    //the value returned from the method
        char letter;        //the Y or N from the user's decision to exit
        double radius;        //the radius of the circle
        double length;        //the length of the rectangle
        double width;        //the width of the rectangle
        double height;        //the height of the triangle
        double base;        //the base of the triangle
        double side1;        //the first side of the triangle
        double side2;        //the second side of the triangle
        double side3;        //the third side of the triangle

        //create a scanner object to read from the keyboard
        Scanner keyboard = new Scanner(System.in);

        do {
            printMenu(); // Print the user's menu

            choice = keyboard.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the radius of the circle:  ");
                    radius = keyboard.nextDouble();
                    //call the circleArea method and store the result in the value variable
                    try {
                        value = circleArea(radius);
                        System.out.println("The area of the circle is " + value);

                    } catch(Exception e) { error(e); }

                    break;
                case 2:
                    System.out.print("Enter the length of the rectangle:  ");
                    length = keyboard.nextDouble();
                    System.out.print("Enter the width of the rectangle:  ");
                    width = keyboard.nextDouble();
                    //call the rectangleArea method and store the result in the value variable
                    try {
                        value = rectangleArea(length, width);
                        System.out.println("The area of the rectangle is " + value);

                    } catch(Exception e) { error(e); }

                    break;
                case 3:
                    System.out.print("Enter the height of the triangle:  ");
                    height = keyboard.nextDouble();
                    System.out.print("Enter the base of the triangle:  ");
                    base = keyboard.nextDouble();
                    //call the triangleArea method and store the result in the value variable
                    try {
                        value = triangleArea(height, base);
                        System.out.println("The area of the triangle is " + value);

                    } catch(Exception e) { error(e); }

                    break;
                case 4:
                    System.out.print("Enter the radius of the circle:  ");
                    radius = keyboard.nextDouble();
                    //call the circumference method and store the result in the value variable
                    try {
                        value = circleCircumference(radius);
                        System.out.println("The circumference of the circle is " + value);

                    } catch(Exception e) { error(e); }

                    break;
                case 5:
                    System.out.print("Enter the length of the rectangle:  ");
                    length = keyboard.nextDouble();
                    System.out.print("Enter the width of the rectangle:  ");
                    width = keyboard.nextDouble();
                    //call the perimeter method and store the result in the value variable
                    try {
                        value = rectangleCircumference(length, width);
                        System.out.println("The perimeter of the rectangle is " + value);

                    } catch(Exception e) { error(e); }

                    break;
                case 6:
                    System.out.print("Enter the length of side 1 of the triangle:  ");
                    side1 = keyboard.nextDouble();
                    System.out.print("Enter the length of side 2 of the triangle:  ");
                    side2 = keyboard.nextDouble();
                    System.out.print("Enter the length of side 3 of the triangle:  ");
                    side3 = keyboard.nextDouble();
                    //call the perimeter method and store the result in the value variable
                    try {
                        value = triangleCircumference(side1, side2, side3);
                        System.out.println("The perimeter of the triangle is " + value);

                    } catch(Exception e) { error(e); }

                    break;
                default:
                    System.out.println("You did not enter a valid choice.");
            }
            keyboard.nextLine(); //consumes the new line character after the number
            System.out.println("Do you want to exit the program (Y/N)?:  ");
            String answer = keyboard.nextLine();
            letter = answer.charAt(0);
        } while (letter != 'Y' && letter != 'y');
    }

    /**
     * Computes the area of a certain rectangle using algebra from two variables.
     * @param length The measured length of the specified rectangle.
     * @param width The measured width of the specified rectangle.
     * @return Rectangular area from length times width. ( length*width )
     * @exception Exception When either parameters (length or width) are non-positive doubles.
     */
    public static double rectangleArea(double length, double width) throws Exception {

        if(length <= 0 || width <= 0) throw new Exception("Rectangular variable expected a positive double.");
        return length * width;
    }

    /**
     * Computes the area of a certain triangle using algebra from two variables.
     * @param height The measurement of the altitude (or height) of the specified triangle.
     * @param base The measurement of the base of the specified triangle.
     * @return Triangular area from base times height over two. ( (height*base)/2 )
     * @exception Exception When either parameters (height or base) are non-positive doubles.
     */
    public static double triangleArea(double height, double base) throws Exception {

        if(height <= 0 || base <= 0) throw new Exception("Triangular variable expected a positive double.");
        return (height * base) / 2;
    }

    /**
     * Computes the circumference of a certain circle using algebra from the circle's radius.
     * @param radius The measured radius of the specified circle.
     * @return Circular perimeter from two times pi times radius. ( 2*(pi)*r )
     * @exception Exception When the radius parameter is a non-positive double.
     */
    public static double circleCircumference(double radius) throws Exception {

        if(radius <= 0) throw new Exception("Circular radius variable expected a positive double, received " + radius + " instead.");
        return Math.PI * radius * 2;
    }

    /**
     * Computes the circumference of a certain triangle using algebra from the triangle's side measurements.
     * @param side1 The first measured side of the triangle.
     * @param side2 The second measured side of the triangle.
     * @param side3 The third measured side of the triangle.
     * @return Triangular perimeter from the accumulated three sides of the triangle. ( a+b+c )
     * @exception Exception When any side parameter given is less than or equal to zero. (Non-positive double)
     */
    public static double triangleCircumference(double side1, double side2, double side3) throws Exception {

        if(side1 <= 0 || side2 <= 0 || side3 <= 0) throw new Exception("Triangular variable expected a positive double.");
        return side1 + side2 + side3;
    }

    /**
     * Computes the area of a certain circle using algebra from the circle's radius.
     * @param radius The measured radius of the specified circle.
     * @return Circular area from the radius of a given circle. ( pi*(r^2) )
     * @exception Exception When the radius parameter is a non-positive double.
     */
    public static double circleArea(double radius) throws Exception {

        if(radius <= 0) throw new Exception("Circular radius variable expected a positive double, received " + radius + " instead.");
        return Math.PI * radius * radius;
    }

    /**
     * Computes the circumference of a certain rectangle using algebra from two variables.
     * @param length The measured length of the specified rectangle.
     * @param width The measured width of the specified rectangle.
     * @return Rectangular perimeter from length-times-two plus width-times-two. ( (2*length)+(2*width) )
     * @exception Exception When either parameters (length or width) are non-positive doubles.
     */
    public static double rectangleCircumference(double length, double width) throws Exception {

        if(length <= 0 || width <= 0) throw new Exception("Rectangular variable expected a positive double.");
        return 2 * length + 2 * width;
    }

    public static void error(Exception generic) {
        System.err.println("Program encountered " + generic.getClass().getSimpleName() + ": " + generic.getMessage());
    }
}