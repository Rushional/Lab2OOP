import static java.lang.StrictMath.pow;
import static java.lang.StrictMath.sqrt;

public class Polynomial {
//    When add a math class, I'll make this package-private
    private ComplexNumber a, b, c;

    public Polynomial(ComplexNumber a, ComplexNumber b, ComplexNumber c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void showPolynomial() {
        System.out.println(a.realPart + "x^2 + " + b.realPart + "x + " + c.realPart);
    }

    //If I need roots amount, I can call x.length
//    I'd probably create another class called RootsCalculator or something like that have this method public there
    public static ComplexNumber[] calculateRoots(Polynomial polynomial) {
        var roots = new ComplexNumber[2];
//        I could use ComplexNumber static divide(ComplexNumber a, ComplexNumber b) here, but I divide only once,
//        and the divisor is real, so I never really use Complex division, no point to implement it,
//        it's simpler to change this class for now instead of using weird code and only change Number
//        If i was using c++ and typedef and all that stuff, it'd make more sense I guess, but I don't want to deal with c++
//        So that's partly why I add a little bit of changes to the class
        var discriminant = new ComplexNumber(pow(polynomial.b.realPart, 2) -
                4 * polynomial.a.realPart * polynomial.c.realPart, 0);
        if (discriminant.realPart < 0) {
            roots[0] = new ComplexNumber((-polynomial.b.realPart) / (2 * polynomial.a.realPart),
                    sqrt(-discriminant.realPart) / 2 * polynomial.a.realPart);
            roots[1] = new ComplexNumber((-polynomial.b.realPart) / (2 * polynomial.a.realPart),
                    -sqrt(-discriminant.realPart) / 2 * polynomial.a.realPart);
        }
        else {
            roots[0] = new ComplexNumber((-polynomial.b.realPart + sqrt(discriminant.realPart))
                    / (2 * polynomial.a.realPart) , 0);
            if (discriminant.realPart == 0) roots[1] = roots[0];
            else roots[1] = new ComplexNumber((-polynomial.b.realPart - sqrt(discriminant.realPart))
                    / (2 * polynomial.a.realPart), 0);
        }
        return roots;
    }

    public static ComplexNumber calculateValue(Polynomial polynomial, ComplexNumber argument) {
        return new ComplexNumber(polynomial.a.realPart * pow(argument.realPart, 2) + polynomial.b.realPart * argument.realPart + polynomial.c.realPart, 0);
    }
}
