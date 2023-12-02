package DayOne;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

// Day 1 Part 1
public class PartOne {
    public static void main(String[] args) throws IOException {
        // Path of the inputd1.txt file
        String path = "C:\\Users\\dyzha\\projects\\Advent_Calendar\\src\\main\\resources\\inputd1.txt";

        // Reading each line
        List<String> lines = Files.readAllLines(Path.of(path));
        // Storing it in a String array
        String[] arr = lines.toArray(new String[lines.size()]);

        int sum = 0; // final sum
        // Foe every String, we will find the first and last character that is a number
        for (String s : arr) {
            int firstDigit = 0;
            int secondDigit = 0;
            boolean first = true; // The first digit of every line of strings
            char[] chArr = s.toCharArray(); // We create an array of chars from the string
            // for each char, we assign a first and second digit only if it is a digit
            for (char c : chArr) {
                if (!Character.isDigit(c)) continue; // if it isn't a digit, we look to the next char

                if (first) {
                    first = false;
                    firstDigit = c - '0'; // converts char to int
                    secondDigit = firstDigit;
                } else {
                    secondDigit = c - '0'; // reassignes the second digit
                }
            }
            sum += 10*firstDigit + secondDigit;
            // System.out.println(firstDigit + secondDigit);
        }

        // Prints out final sum
        System.out.println(sum); //54390
    }
}
