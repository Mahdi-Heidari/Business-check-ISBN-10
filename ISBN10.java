package isbn.pkg10;

import java.util.Scanner;

public class ISBN10 {

    public static Scanner input = new Scanner(System.in);
    public static String isbnInput;

    public static void main(String[] args) {

//        Prompts the user to enter a 9-digit integer
        System.out.print("Enter the first 9 digits of an ISBN as integer:\t");
        isbnInput = input.next();

//        Checking the number of digits to be valid
        while (isbnInput.length() != 9) {
            System.out.print("Invalid input! Try again >>>\t");
            isbnInput = input.next();
        }

//        Displaying the result in the output console
        String isbn10 = isbn(isbnInput);
        System.out.println("The ISBN-10 number is " + isbnInput + isbn10);

    }

    public static String isbn(String isbn) {

//        Checksum - the final digit
        int isbn10 = 0;

//        Using Strings to calculate the ISBN-10
        for (int i = 0; i < isbn.length();) {
            isbn10 += (isbn.charAt(i) - '0') * ++i;
        }
        //        Using Integers to calculate the ISBN-10
        /*
         int isbn9 = Integer.parseInt(isbn);
         for (int i = 9; i > 0; i--, isbn9 /= 10) {

         byte firstDigit = (byte) (isbn9 % 10);
         isbn10 += firstDigit * i;
         //            isbn10 += isbn_9 % 10 * i;
         }*/
        isbn10 %= 11;

        if (isbn10 == 10) {
            return "X";
        } else {
            return isbn10 + "";
        }
    }

}
