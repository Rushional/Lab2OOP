import java.util.Scanner;

public class Application {
    public void run() {
        int userInput = 1;
        var a = new ComplexNumber(1, 0);
        var b = new ComplexNumber(2, 0);
        var c = new ComplexNumber(1, 0);
        while (userInput != 0) {
            showUserOptions();
            Scanner scanner = new Scanner(System.in);
            userInput = scanner.nextInt();
            if (userInput == 0) break;
            switch (userInput) {
                case 1:
                    System.out.println("Input coefficient a: ");
//                    I know this input is weird,
//                    but the entire idea to rename double to "number" without any new functionality is weird
//                    So I'm leaving it like that until questioned (hopefully forever)
                    a.realPart = scanner.nextDouble();
                    System.out.println("Input coefficient b: ");
                    b.realPart = scanner.nextDouble();
                    System.out.println("Input coefficient c: ");
                    c.realPart = scanner.nextDouble();
                    break;
                case 2:
                    var rootCalcPolynomial = new Polynomial(a, b, c);
                        ComplexNumber[] roots = Polynomial.calculateRoots(rootCalcPolynomial);
                        if ((roots[0].realPart == roots[1].realPart) && (roots[0].imaginaryPart == 0 ))System.out.println("The only root is " + roots[0].asString());
                        else System.out.println("The first root is " + roots[0].asString() + ", and the second one is " + roots[1].asString());
                    break;
                case 3:
                    System.out.println("Please input an argument of the polynomial: ");
                    var argument = new ComplexNumber(scanner.nextDouble(), 0);
                    var calcValuePolynomial = new Polynomial(a, b, c);
                    ComplexNumber calculatedValue = Polynomial.calculateValue(calcValuePolynomial, argument);
                    System.out.println("With the argument "+ argument.asString() + ", the value of the polynomial is " + calculatedValue.asString());
                    break;
                case 4:
                    var outputPolynomial = new Polynomial(a, b, c);
                    outputPolynomial.showPolynomial();
                    break;
                default:
                    break;
            }
        }
    }

    private static void showUserOptions() {
        System.out.println("1) Input polynomial coefficients");
        System.out.println("2) Calculate roots of the polynomial");
        System.out.println("3) Calculate value of a polynomial");
        System.out.println("4) Output a polynomial");
        System.out.println("0) Exit");
    }
}

