import java.util.ArrayList;

public class EncryptionProgram {

    public static char[] CHARS = {'A', 'B', 'C',
            'D', 'E', 'F',
            'G', 'H', 'I',
            'J', 'K', 'L',
            'M', 'N', 'O',
            'P', 'Q', 'R',
            'S', 'T', 'U',
            'V', 'W', 'X',
            'Y', 'Z', 'a', 'b', 'c', 'd', 'e',
    'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
    'v', 'w', 'x', 'y', 'z'};

    public static String encrypt(ArrayList<Character> toEncrypt, int key){
        StringBuilder str = new StringBuilder();
        for (var character : toEncrypt) {
            int index = new String(CHARS).indexOf(character);

            if (index == -1) {
                str.append(character);
                continue;
            }

            index += key;
            if (index >= CHARS.length){
                index -= CHARS.length;
            }
            char newChar = CHARS[index];
            str.append(newChar);
        }
        String result = str.toString();
        return result;
    }

    public static String decrypt(ArrayList<Character> toDecrypt, int key){
        StringBuilder str = new StringBuilder();
        for (var character : toDecrypt) {
            int index = new String(CHARS).indexOf(character);

            if (index == -1) {
                str.append(character);
                continue;
            }
            index -= key;
            if (index <= -1){
                index += CHARS.length;
            }
            char newChar = CHARS[index];
            str.append(newChar);
        }
        String result = str.toString();
        return result;
    }

    public static String bruteForce(ArrayList<Character> toDecrypt){
        //ArrayList<String> COMMON_ENGLISH_WORDS = new ArrayList<>(Arrays.asList("the", "am", "they", "when", "at", "on", "do", "in", "see", "is", "from"));
        String[] COMMON_ENGLISH_WORDS = {"the", "am", "they", "when", "at", "on", "do", "in", "see", "is", "from"};
        String charsStr = new String(CHARS);

        for (int key = 1; key < CHARS.length; key++){
            StringBuilder str = new StringBuilder();
            for (var character : toDecrypt) {
                int index = charsStr.indexOf(character);

                if (index == -1) {
                    str.append(character);
                    continue;
                }
                index = (index - key + CHARS.length) % CHARS.length;

                char newChar = CHARS[index];
                str.append(newChar);
            }
            String result = str.toString();
            System.out.printf("Trying key %d: %s\n", key, result);
            System.out.println("Contains any? " + Utils.containsAny(result, COMMON_ENGLISH_WORDS));
            if (Utils.containsAny(result, COMMON_ENGLISH_WORDS)) {
                System.out.printf("The key was: %d\n", key);
                return result;
            }
            
        }
        System.err.println("Couldn't brute force the message");
        return "";
    }
}
