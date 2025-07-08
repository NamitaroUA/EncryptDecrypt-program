import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Utils {
    public static boolean containsAny(String mainString, String[] searchStrings) {
        String[] words = mainString.toLowerCase().split("\\W+"); // Splits on non-word characters
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));

        for (String keyword : searchStrings) {
            if (wordSet.contains(keyword.toLowerCase())) {
                return true;
            }
        }

        return false;
    }


    public static void askChoice() {
        System.out.println("Pick your choice:");
        System.out.println("1. Write your own path to a file.");
        System.out.println("2. Use a default settings.");
    }
}
