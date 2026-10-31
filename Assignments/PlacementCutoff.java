public class PlacementCutoff {

    static int kthHighest(int[] marks, int k) {
        int target = marks.length - k;

        int left = 0;
        int right = marks.length - 1;

        while (left <= right) {
            int pivotIndex = partition(marks, left, right);

            if (pivotIndex == target) {
                return marks[pivotIndex];
            } else if (pivotIndex > target) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }

        return -1;
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] marks1 = {72, 95, 60, 88, 79};
        int[] marks2 = {50, 90, 90, 70};

        System.out.println(kthHighest(marks1, 2));
        System.out.println(kthHighest(marks2, 2));
    }
}