public class WarehouseInventoryBalancer {

    static void analyzeInventory(
            int[] sectionA,
            int[] sectionB) {

        if (sectionA.length != sectionB.length) {
            System.out.println(
                    "Both sections must have equal length."
            );
            return;
        }

        int totalA = 0;
        int totalB = 0;

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
        }

        String status;

        if (totalA == totalB) {
            status = "Balanced";
        } else {
            status = "Not Balanced";
        }

        int highest = sectionA[0];
        String highestSection = "A";
        int highestIndex = 0;

        for (int i = 0; i < sectionA.length; i++) {

            if (sectionA[i] > highest) {
                highest = sectionA[i];
                highestSection = "A";
                highestIndex = i;
            }

            if (sectionB[i] > highest) {
                highest = sectionB[i];
                highestSection = "B";
                highestIndex = i;
            }
        }

        System.out.println(
                "Section A Total: " + totalA
                + " | Section B Total: " + totalB
                + " | Status: " + status
                + " | Highest Quantity: "
                + highest
                + " (Section "
                + highestSection
                + ", Item "
                + (highestIndex + 1)
                + ")"
        );
    }

    public static void main(String[] args) {

        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}