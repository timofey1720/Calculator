import java.util.Scanner;
import java.util.regex.Pattern;

public class Utils {
    public static String getData(){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        return string;
    }
    public static String[] parseParams(String string) throws Exception {

        String[] str;
        String[] rez = new String[3];
        int indexpl = string.indexOf("+");
        int indexmn = string.indexOf("-");
        int indexpr = string.indexOf("*");
        int indexdr = string.indexOf("/");
        if(indexpl != -1){
            return prsString(string, "+");
        }
        else if(indexmn != -1){
            return prsString(string, "-");
        }
        else if(indexpr != -1){
            return prsString(string, "*");
        }
        else if(indexdr != -1){
            return prsString(string, "/");
        }
        else {
            throw new Exception("строка не является математической операцией");
        }

    }
    public static int[] getCorrectSymbol(String pr) throws Exception {
        Integer romVl = getRomSymbol(pr);
        if  (romVl == null) {
            Integer num = Integer.parseInt(pr);
            if (num > 0 && num <= 10) {
                return new int[]{num, 0};
            } else {
                throw new Exception("Число не удовл.  условию задачи");
            }
        }
        return new int[] {romVl, 1};
    }

    public static Integer getRomSymbol(String pr) {
        for(int i = 0; i < 10;  i++) {
            switch (pr) {
                case ("I"):
                   return 1;
                case ("II"):
                   return 2;
                case ("III"):
                    return 3;
                case ("IV"):
                    return 4;
                case ("V"):
                    return 5;
                case ("VI"):
                    return 6;
                case ("VII"):
                    return 7;
                case ("VIII"):
                    return 8;
                case ("IX"):
                    return 9;
                case ("X"):
                    return 10;
                default:
                    continue;
            }
        }
        return null;
    }

    private static String[] prsString(String string, String symb) throws Exception {

        String[] rez = new String[3];
        String[] str = string.split(Pattern.quote(symb),2);
        rez[0] = str[0].trim();
        if(str[1].split("[(/)|(-)|(+)|(*)]").length > 1) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        }
        rez[2] = str[1].trim();
        rez[1] = symb;
        return rez;
    }
}
