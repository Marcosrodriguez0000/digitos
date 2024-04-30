import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            if (input.equals("9999 ZZZ"))
                break;
            String[] parts = input.split(" ");
            int numberPart = Integer.parseInt(parts[0]);
            String letterPart = parts[1];


            String nextPlate = getNextPlate(numberPart, letterPart);
            System.out.println(nextPlate);
        }

        scanner.close();
    }

    public static String getNextPlate(int numberPart, String letterPart) {
        numberPart++;
        if (numberPart > 9999) {
            numberPart = 0;
            letterPart = incrementLetters(letterPart);
        }
        return String.format("%04d %s", numberPart, letterPart);
    }

    public static String incrementLetters(String letters) {
        char[] chars = letters.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            char c = chars[i];
            if (c != 'Z') {
                chars[i]++;
                if (chars[i] == 'A' || chars[i] == 'E' || chars[i] == 'I' || chars[i] == 'O' || chars[i] == 'U')
                    chars[i]++;
                break;
            } else {
                chars[i] = 'B';
            }
        }
        return new String(chars);
    }
}