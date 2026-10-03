import java.util.HashMap;
import java.util.Map;

public class MostPopularOrder {

    public static String[] mostPopular(String[] orders) {

        HashMap<String, Integer> count = new HashMap<>();

        // Count each item
        for (String item : orders) {
            count.put(item, count.getOrDefault(item, 0) + 1);
        }

        String popularItem = orders[0];
        int maxCount = count.get(popularItem);

        // Find the first item having the highest count
        for (String item : orders) {

            if (count.get(item) > maxCount) {
                maxCount = count.get(item);
                popularItem = item;
            }
        }

        return new String[]{popularItem, String.valueOf(maxCount)};
    }

    public static void main(String[] args) {

        String[] orders = {
            "dosa", "idli", "vada", "dosa",
            "idli", "dosa", "tea"
        };

        String[] result = mostPopular(orders);

        System.out.println("(" + result[0] + ", " + result[1] + ")");
    }
}