package liberman.lab4_2;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String str1 = "uftujoh";
        Main.regexInfo(str1);
        String str2 = "t2st3ng";
        Main.regexInfo(str2);
    }

    public static String regexInfo(String str) {
        String stringPattern = ".*\\d.*";
        Pattern pattern = Pattern.compile(stringPattern);
        Matcher matcher = pattern.matcher(str);
        if (matcher.find()) {
            System.out.println("Decoder of vowels");
            return Decoder.decodeOfVowels(str);
        }
        System.out.println("Decoder of consonants");
        return Decoder.decodeOfConsonants(str);
    }
}
