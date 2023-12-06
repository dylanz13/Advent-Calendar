package Day2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class PartOne {
    public static void main(String[] args) throws IOException {
        int redLim = 12;
        int greLim = 13;
        int bluLim = 14;

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
            boolean condition = true;
            for (int i = 2; i < game.length; i++) {
                if (game[i].length() > 2) {
                    String color = game[i].substring(0,game[i].length()-1);
                    if (color.equals("green"))
                        condition = condition && Integer.parseInt(game[i-1]) <= greLim;
                    else if (color.equals("red"))
                        condition = condition && Integer.parseInt(game[i-1]) <= redLim;
                    else
                        condition = condition && Integer.parseInt(game[i-1]) <= bluLim;
                }
            }

            if (condition) {
                int game_num = Integer.parseInt(game[1].substring(0, game[1].length() - 1));
                sum += game_num;
//                System.out.println(line);
            }
        }
        System.out.println(sum); // 2162
    }
}
