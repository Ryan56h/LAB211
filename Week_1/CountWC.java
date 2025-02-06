package Week_1;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CountWC {

    private Map<String, Integer> wordCounter = new HashMap<String, Integer>();
    private Map<Character, Integer> charCounter = new HashMap<Character, Integer>();

    public void display() {
        System.out.println("Word count" + wordCounter);
        System.out.println("Character count" + charCounter);
    }

    public void analyze(String content) {
        for (char ch : content.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                continue;
            }

            charCounter.put(ch, charCounter.getOrDefault(ch, 0) + 1);
        }

        StringTokenizer tokenizer = new StringTokenizer(content);
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();

            wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);
        }
    }
}
