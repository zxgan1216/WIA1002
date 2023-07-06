package PLN;
import java.util.*;

public class N2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        for (int testCase = 0; testCase < t; testCase++) {
            int n = scanner.nextInt(); // Number of icons
            List<Integer> categories = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int category = scanner.nextInt();
                categories.add(category);
            }

            int screens = calculateMinScreens(n, categories);
            System.out.println(screens);
        }
    }

    private static int calculateMinScreens(int n, List<Integer> categories) {
        Map<Integer, Integer> categoryCounts = new HashMap<>();

        // Count the number of icons in each category
        for (int category : categories) {
            categoryCounts.put(category, categoryCounts.getOrDefault(category, 0) + 1);
        }

        int maxCategoryCount = 0;
        for (int count : categoryCounts.values()) {
            maxCategoryCount = Math.max(maxCategoryCount, count);
        }

        int s = (int) Math.ceil(n / 2.0);
        int m = (int) Math.ceil(maxCategoryCount / (double) s);

        return m;
    }
}







