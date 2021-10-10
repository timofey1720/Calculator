import java.util.Scanner;

public class Utils {
    public static String getData(){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        return string;
    }
    public static String[] parseParams(String string) throws Exception {
        String vol = string.trim();
        String[] ms = vol.split(" ");
        if(ms.length <= 1) {
            throw new Exception("строка не является математической операцией");
        } else if(ms.length > 3) {
            throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        } else {
            return ms;
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
}
