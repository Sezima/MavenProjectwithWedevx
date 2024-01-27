package wedevxPlatform;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EncodeTheString {

    public static void main(String[] args) {
        String input = "ddd222aaabbbcccccg";
        System.out.println(input);
        String encodedOutput = encodeString(input);
        System.out.println(encodedOutput);

        String input2 = "No changes here";
        String encodedOutput2 = encodeString(input2);
        System.out.println(encodedOutput2);
    }

    public static String encodeString(String str) {
        StringBuilder result = new StringBuilder();
        Matcher matcher = Pattern.compile("(.)\\1*").matcher(str);
        while (matcher.find()) {
            result.append(matcher.group().charAt(0));
            if (matcher.group().length() > 1) {
                result.append(matcher.group().length());
            }
        }
        return result.toString();
    }
}
