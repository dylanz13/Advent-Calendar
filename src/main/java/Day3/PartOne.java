package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PartOne {
    public static void main(String[] args) {
        char[][] array = new char[0][0];
        try {
            // Path of the inputd2.txt file
            String path = "./src/main/resources/inputd3.txt";

            // Reading each line
            List<String> lines = Files.readAllLines(Path.of(path));
            // Storing it in a String array
            String[] arr = lines.toArray(new String[lines.size()]);
            array = new char[arr[0].length()][arr.length];

            for(int i=0; i < arr.length; i++) {
                array[i] = arr[i].toCharArray();
            }
        } catch (IOException ignored){}

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            int lineElement = 0;
            boolean condition = false;
            for (int j = 0; j < array[0].length; j++) {
                if (Character.isDigit(array[i][j])) {
                    int leftX = Math.max(j - 1, 0);
                    int upY = Math.max(i - 1, 0);
                    int rightX = Math.min(j + 1, array[0].length - 1);
                    int botY = Math.min(i + 1, array.length-1);
                    condition = condition ||
                        (!Character.isDigit(array[upY][leftX]) && array[upY][leftX] != '.') ||
                        (!Character.isDigit(array[upY][j]) && array[upY][j] != '.') ||
                        (!Character.isDigit(array[upY][rightX]) && array[upY][rightX] != '.') ||
                        (!Character.isDigit(array[i][leftX]) && array[i][leftX] != '.') ||
                        (!Character.isDigit(array[i][rightX]) && array[i][rightX] != '.') ||
                        (!Character.isDigit(array[botY][leftX]) && array[botY][leftX] != '.') ||
                        (!Character.isDigit(array[botY][j]) && array[botY][j] != '.') ||
                        (!Character.isDigit(array[botY][rightX]) && array[botY][rightX] != '.');

                    lineElement *= 10;
                    int digit = (array[i][j] - '0');
                    lineElement = lineElement + digit;
                } else {
                    if (condition) sum += lineElement;
                    condition = false;
                    lineElement = 0;
                }


                if (condition && j + 1 >= array[0].length) {
                    sum += lineElement;
                }

            }
        }

        System.out.println(sum);
    }
}
