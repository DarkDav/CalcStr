import java.io.IOException;
import java.util.Scanner;

public class Input {
    public static String input() throws IOException {
        Scanner sc = new Scanner(System.in);
        int maxLength = 40;
        String result = sc.nextLine();
        String[] values = Parser.getValues(result);
        String[] s = Parser.getAnyValues(result);


        if (values.length < 2) {throw new IOException("строка не является математической операцией");}
        if (values[0].length()-2 > 11 || values[1].length() > 10) {throw new IOException("Вводимая строка не должна быть больше 10 символов");}

        return result;
    }
}