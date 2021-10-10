public class Calculator {
    private int[] vlFirst;
    private int[] vlLast;
    private String znk;

    public Calculator(int[] vlFirst, int[] vlLast, String znk) {
        this.vlFirst = vlFirst;
        this.vlLast = vlLast;
        this.znk = znk;
    }
    public void calculate() throws Exception {
        if (!(vlFirst[1] == vlLast[1])) {
           throw new Exception("используются одновременно разные системы счисления");
        }
        if (vlFirst[1] == 0) {
            System.out.println(clc(vlFirst[0], vlLast[0], znk));
        } else {
            int rez = clc(vlFirst[0], vlLast[0], znk);
            if (rez < 1) {
                throw new Exception("в римской системе нет отрицательных чисел");
            }
            System.out.println(converterArbian(rez));
        }
    }

    private int clc(int vlFirst, int vlLast, String znk) throws Exception {
        switch (znk) {
            case ("*"):
                return vlFirst * vlLast;
            case ("/"):
                return vlFirst / vlLast;
            case ("+"):
                return vlFirst + vlLast;
            case ("-"):
                return vlFirst - vlLast;
            default: {
                throw new Exception("некорректный оператор");
            }
        }
    }

    private String converterArbian(int number) {
        int numbers[]  = {1, 4, 5, 9, 10, 50, 100};
        String letters[]  = { "I", "IV", "V", "IX", "X", "L", "C"};
        String romanValue = "";
        int N = number;
        while ( N > 0 ){
            for (int i = 0; i < numbers.length; i++){
                if ( N < numbers[i] ){
                    N -= numbers[i-1];
                    romanValue += letters[i-1];
                    break;
                }
            }
        }
        return romanValue;
    }
}
