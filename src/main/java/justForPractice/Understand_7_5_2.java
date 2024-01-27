package justForPractice;

public class Understand_7_5_2 {
    public static void main(String[] args) {
        System.out.println(repeatString("Hello", 2, 3));
    }
    public static String repeatString(String str, int columns, int rows) {
        String output = "";
        int currentColumn = 1;
        while(currentColumn <= columns) {
            int currentRow = 1;
            System.out.println("Output in first loop:    " + output);
            System.out.println("in first loop currentColumn: " + currentColumn);
            while(currentRow <= rows) {
                output += str;
                currentRow++;
                System.out.println("Current row: " + currentRow);
                System.out.println("Output in second loop:      " + output);
            }
            output += "\n";
            currentColumn++;

        }
        return output;
    }
}
