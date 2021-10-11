import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        String string = Utils.getData();
        String[] symbs = Utils.parseParams(string);
        int[] vlFirst = Utils.getCorrectSymbol(symbs[0]);
        int[] vlLast = Utils.getCorrectSymbol(symbs[2]);
        String znk = symbs[1];
        Calculator calculator = new Calculator(vlFirst, vlLast, znk);
        calculator.calculate();
    }
}
