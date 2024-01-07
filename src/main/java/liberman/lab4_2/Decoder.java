package liberman.lab4_2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Decoder {

    public static String decodeOfVowels(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        Map<Character, Character> vowels = new HashMap<>();
        vowels.put('1', 'a');
        vowels.put('2', 'e');
        vowels.put('3', 'i');
        vowels.put('4', 'o');
        vowels.put('5', 'u');

        char[] chars = str.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (vowels.containsKey(chars[i])) {
                chars[i] = vowels.get(chars[i]);
            }
        }
        return String.valueOf(stringBuilder.append(chars));
    }

    public static String decodeOfConsonants(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Character> consonants = List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        char[] chars = str.toLowerCase().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (consonants.contains(chars[i])) {
                int indexOf = consonants.indexOf(chars[i]);
                chars[i] = consonants.get(indexOf-1);
            }
        }
        return String.valueOf(stringBuilder.append(chars));
    }
}
