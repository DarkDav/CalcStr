import java.io.IOException;

public class StringCalc {
    public final String[] values;
    public final String[] s;
    public final String operator;
    public String result;

    public StringCalc(String[] values, String operator, String[] s) {
        this.operator = operator;
        this.values = values;
        this.s = s;
    }

    public String getResult() throws IOException {
        String a = values[0];
        String b = values[1];

        switch (operator) {

            case "+": {
                result = plus(a, b);
                break;
            }
            case "*": {
                result = multiplication(a, b);
                if (Integer.parseInt(values[1].trim()) > 10 || Integer.parseInt(values[1].trim()) <= 0) {
                    throw new IOException("Число должно быть меньше или равно 10 и больше 0");
                }
                break;
            }

            case "-": {
                result = (minus(s[1], s[3]));
                break;
            }
            case "/": {
                result = division(a, b);
                if (Integer.parseInt(values[1].trim()) > 10 || Integer.parseInt(values[1].trim()) <= 0) {
                    throw new IOException("Число должно быть меньше или равно 10 и больше 0");
                }
                break;
            }
        }
        if (s.length < 3) {
            throw new IOException("Неверный формат");
        }
        if (s[2].trim().equals("-")) {
            result = (minus(s[1], s[3]));
        }
        if (s[2].isEmpty()) {
            throw new IOException("первый операнд не является строкой");
        }

        if (result == null) {
            throw new IOException("не соответствует условиям");
        }
        if (result.length() > 40) {
            return result.substring(0, 40) + "..." + "\"";
        } else {
            return result;

        }

    }

    private String plus(String a, String b) {
        var ar = validate(a, b);
        return ("\"" + ar[0].trim() + ar[1].trim() + "\"");
    }

    private String minus(String a, String b) {
        var ar = validate(a, b);
        return ("\"" + ar[0].replaceAll(ar[1], "") + "\"");
    }

    private String multiplication(String a, String b) {
        var ar = validate(a, b);
        return ("\"" + ar[0].trim().repeat(Integer.parseInt(ar[1].trim())) + "\"");
    }

    private String division(String a, String b) {
        var ar = validate(a, b);
        return ("\"" + ar[0].substring(0, (a.length() / Integer.parseInt(ar[1].trim()) - 1)) + "\"");
    }

    private String[] validate(String a, String b) {
        a = a.replaceAll("[\"]+", "");
        b = b.replaceAll("[\"]+", "");
        String[] ar = {a, b};
        return ar;
    }


    public String calculate() throws IOException {
        return getResult();
    }
}