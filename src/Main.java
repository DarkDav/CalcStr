import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String result = Input.input();
        String[] values = Parser.getValues(result);
        String operator = Parser.getOperator(result);
        String[] s = Parser.getAnyValues(result);
        StringCalc str1 = new StringCalc(values,operator,s);
        System.out.println(str1.calculate());

    }
}