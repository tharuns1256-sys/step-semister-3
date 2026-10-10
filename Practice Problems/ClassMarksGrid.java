import java.util.*;
import java.util.regex.*;

public class ClassMarksGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> names = new ArrayList<>();
        List<int[]> marksList = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d+");

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String name = line.substring(0, line.indexOf('[')).trim();

            Matcher matcher = pattern.matcher(line);
            int[] marks = new int[3];
            int index = 0;

            while (matcher.find() && index < 3) {
                marks[index] = Integer.parseInt(matcher.group());
                index++;
            }

            names.add(name);
            marksList.add(marks);
        }

        if (names.isEmpty()) {
            sc.close();
            return;
        }

        int[] subjectTotals = new int[3];
        int[] totals = new int[names.size()];

        int topperIndex = 0;
        int highestTotal = -1;

        for (int i = 0; i < marksList.size(); i++) {
            int[] marks = marksList.get(i);
            int total = 0;

            for (int j = 0; j < 3; j++) {
                total += marks[j];
                subjectTotals[j] += marks[j];
            }

            totals[i] = total;

            if (total > highestTotal) {
                highestTotal = total;
                topperIndex = i;
            }
        }

        System.out.print("Totals ");

        for (int i = 0; i < names.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }

            System.out.print(names.get(i) + " " + totals[i]);
        }

        System.out.println();

        System.out.printf(
            Locale.US,
            "averages %.2f, %.2f, %.2f%n",
            subjectTotals[0] / (double) names.size(),
            subjectTotals[1] / (double) names.size(),
            subjectTotals[2] / (double) names.size()
        );

        System.out.println(
            "topper " + names.get(topperIndex)
            + " (" + highestTotal + ")"
        );

        sc.close();
    }
}