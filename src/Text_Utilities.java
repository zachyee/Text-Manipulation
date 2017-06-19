/**
 * Created by Zachary on 6/17/2017.
 */
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Text_Utilities {
    public static String reverse(String input) {
        char[] input_chars = input.toCharArray();
        for (int i = 0; i < input.length() / 2; i++) {
            char temp = input_chars[i];
            input_chars[i] = input_chars[input.length()-(1+i)];
            input_chars[input.length()-(i+1)] = temp;
        }
        return String.valueOf(input_chars);
    }

    public static boolean isPalindrome(String input) {
        boolean result = true;
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length()-(1+i))) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static HashMap<Character,Integer> countChars(String input) {
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();
        for (int i = 0; i < input.length(); i++) {
            Character current_char = input.charAt(i);
            if (map.containsKey(current_char)) {
                map.put(current_char, map.get(current_char)+1);
            }
            else {
                map.put(current_char, 1);
            }
        }
        return map;
    }

    public static HashMap<String,Integer> countWords(String input) {
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        String[] split_input = input.split("\\s+");
        for (int i = 0; i < split_input.length; i++) {
            String current_string = split_input[i];
            if (current_string.equals("")) {
                continue;
            }
            if (map.containsKey(current_string)) {
                    map.put(current_string, map.get(current_string)+1);
            }
            else {
                map.put(current_string, 1);
            }
        }
        return map;
    }

    public static int totalWords(String input) {
        int total = 0;
        HashMap<String,Integer> word_counts = countWords(input);
        for (Map.Entry<String,Integer> entry : word_counts.entrySet()) {
            total += entry.getValue();
        }
        return total;
    }

    private static final int maxChunkSize = 1000000;

    public static void generateRandomFile(long numBytes, String alphabet){
        DecimalFormat decimalFormat = new DecimalFormat("0000000000000");
        String fileName = decimalFormat.format(numBytes) + ".txt";
        Random random = new Random();
        try {
            FileWriter fileWriter = new FileWriter(fileName, false);
            long currentByte = 0;
            while (currentByte < numBytes) {
                long remainingBytes = numBytes - currentByte;
                int chunkSize = (remainingBytes >= maxChunkSize) ? maxChunkSize : (int) remainingBytes;
                char[] currentChunk = new char[chunkSize];
                for (int i = 0; i < chunkSize; i++) {
                    currentChunk[i] = alphabet.charAt(random.nextInt(alphabet.length()));
                }
                fileWriter.write(currentChunk);
                currentByte += chunkSize;
            }
            fileWriter.close();
        }
        catch (IOException e) {
            System.err.println(e.getStackTrace());
            System.err.println("Error writing to: " + fileName);
            System.exit(1);
        }
    }
}
