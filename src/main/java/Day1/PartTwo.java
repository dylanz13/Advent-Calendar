package Day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;

// Day 1 Part 2
public class PartTwo {
    public static void main(String[] args) throws IOException {
        // Path of the inputd1.txt file
        String path = "./src/main/resources/inputd1.txt";
        List<String> lines = Files.readAllLines(Path.of(path)); // Reading each line
        String[] arr = lines.toArray(new String[lines.size()]); // Storing it in a String array

        // Creating our text to number dictionary
        HashMap<String, Integer> numbersMap = new HashMap<>();
        String[] numbers = new String[]{"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        for (int i = 0; i < 9; i++) {
            numbersMap.put(numbers[i], i+1); // for every number string, we assign their numeric counterpart
        }

        int sum = 0; // final sum
        /* For every String, we will find the first and last character that is a number
         (converting string numbers into their numeric counterparts) */
        for (String s : arr) {
            int firstDigit = 0;
            int secondDigit = 0;
            boolean first = true; // The first digit of every line of strings
            // Split by regex that looks ahead and behind of each of the number string
            String[] split = s.split("(?=(one|two|three|four|five|six|seven|eight|nine))|" +
                    "(?<=(one|two|six))|" +
                    "(?<=(four|five|nine))|" +
                    "(?<=(three|seven|eight))");
            // Verified at https://regex101.com

            StringBuilder sb = new StringBuilder(); // We convert every instance of a string of number into its numeric counterpart
            // For each of the split strings, we check if it can be converted into a number
            for (int i = 0; i < split.length; i++) {
                // we ignore singular letter cases
                if (split[i].length() == 1 && !Character.isDigit(split[i].charAt(0))) {
                    continue;
                }
                // we have to check if the string += index of 1 is a valid number string
                if (numbersMap.containsKey(split[i])) sb.append(numbersMap.get(split[i])); // if a string is a number string
                else if (i > 0 && numbersMap.containsKey(split[i-1] + split[i])) // if string with its previous index is a number string
                    sb.append(numbersMap.get(split[i - 1]+split[i]));
                else if(i < split.length-1 && numbersMap.containsKey(split[i] + split[i+1])) // if a string with its next index is a number string
                    sb.append(numbersMap.get(split[i] + split[i+1]));
                else sb.append(split[i]); // it must not be a number string, so some combination of numbers and/or characters
            }

            char[] charArr = sb.toString().toCharArray(); // We create an array of chars from the string
            // for each char, we assign a first and second digit only if it is a digit
            for (char c : charArr) {
                if (!Character.isDigit(c)) continue; // if it isn't a digit, we look to the next char
                if (first) {
                    first = false;
                    firstDigit = c - '0'; // converts char to int
                    secondDigit = firstDigit;
                } else {
                    secondDigit = c - '0'; // reassigns the second digit
                }
            }
            sum += 10 * firstDigit + secondDigit;
//            System.out.println(10*firstDigit + secondDigit + ": " + s); // To verify each line is correct
        }

        // Prints out final sum
        System.out.println(sum); //54277

    }
}
