package Day3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PartTwo {
    public static void main(String[] args) {

        char[][] array = new char[0][0];
        try {
            // Path of the inputd3.txt file
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
            int gearNum = 0;
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == '*') {
                    int firstNum = 0;
                    int secondNum = 0;

                    int leftX = Math.max(j - 1, 0);
                    int upY = Math.max(i - 1, 0);
                    int rightX = Math.min(j + 1, array[0].length - 1);
                    int botY = Math.min(i + 1, array.length-1);

                    if (Character.isDigit(array[upY][j])) {
                        gearNum++;
                        firstNum = upY*1000 + j;
                    }
                    else if (Character.isDigit(array[upY][leftX]) || Character.isDigit(array[upY][rightX])) {
                        if (Character.isDigit(array[upY][leftX])) {
                            gearNum++;
                            firstNum = upY*1000 + leftX;
                        }
                        if (Character.isDigit(array[upY][rightX])) {
                            gearNum++;
                            if (gearNum == 1) firstNum = upY*1000 + rightX;
                            else secondNum = upY*1000 + rightX;
                        }
                    }

                    if (Character.isDigit(array[i][leftX])) {
                        gearNum++;
                        if (gearNum == 1) firstNum = i*1000 + leftX;
                        else secondNum = i*1000 + leftX;
                    }
                    if (Character.isDigit(array[i][rightX])) {
                        gearNum++;
                        if (gearNum == 1) firstNum = i*1000 + rightX;
                        else secondNum = i*1000 + rightX;
                    }

                    if (Character.isDigit(array[botY][j])) {
                        gearNum++;
                        secondNum = botY*1000 + j;
                    }
                    else if (Character.isDigit(array[botY][leftX])|| Character.isDigit(array[botY][rightX])) {
                        if (Character.isDigit(array[botY][leftX])) {
                            gearNum++;
                            if (gearNum == 1) firstNum = botY*1000 + leftX;
                            else secondNum = botY*1000 + leftX;
                        }
                        if (Character.isDigit(array[botY][rightX])) {
                            gearNum++;
                            if (gearNum == 1) firstNum = botY*1000 + rightX;
                            else secondNum = botY*1000 + rightX;
                        }
                    }

                    if (gearNum == 2) {
                        firstNum = findFullNumber(array, firstNum);
                        secondNum = findFullNumber(array, secondNum);
                        sum += firstNum * secondNum;
                    }
                    gearNum = 0;
                }
            }
        }
        System.out.println(sum);

    }

    private static int findFullNumber(char[][] array, int encodedNum) {
        int j = encodedNum % 1000;
        int i = (encodedNum - j) / 1000;
        int number = 0;
        while (j-1 >= 0 && Character.isDigit(array[i][j-1])) {
            j--;
        }
        while (Character.isDigit(array[i][j])) {
            number = number*10;
            number = number + (array[i][j] - '0');
            if (j + 1 < array[0].length) j++;
            else break;
        }
        return number;
    }
}
