package Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PartTwo {
    public static void main(String[] args) throws IOException {

        // Path of the inputd2.txt file
        String path = "./src/main/resources/inputd2.txt";

        // Reading each line
        List<String> lines = Files.readAllLines(Path.of(path));
        // Storing it in a String array
        String[] arr = lines.toArray(new String[lines.size()]);

        int sum = 0;
        for (String line : arr) {
            line = line + ";";
            String[] game  = line.split(" ");
            int redMax = 0;
            int greMax = 0;
            int bluMax = 0;
            for (int i = 2; i < game.length; i++) {
                if (game[i].length() > 2) {
                    String color = game[i].substring(0,game[i].length()-1);
                    if (color.equals("green"))
                        greMax = Math.max(Integer.parseInt(game[i - 1]), greMax);
                    else if (color.equals("red"))
                        redMax = Math.max(Integer.parseInt(game[i-1]), redMax);
                    else
                        bluMax = Math.max(Integer.parseInt(game[i-1]), bluMax);
                }
            }

            sum += greMax * redMax * bluMax;
            System.out.println(line + " :: r:" + redMax + ", g:" + greMax + ", b:" + bluMax);
        }
        System.out.println(sum); // 72513
    }
}
