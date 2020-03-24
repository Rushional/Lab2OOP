public class ComplexNumber {
    public double realPart, imaginaryPart;

//    AFAIK there's no such thing as typedef in Java so I use a class
//    And boy is this annoying to work with!1!1!
//    In the original program Number was just a double in disguise, so I am leaving all the fields public
//    Also there is no operator overloading in Java
//    so I'm gonna have to shuffle from double to Number back and forth all the time
//    This is going to be amazing.
    public ComplexNumber(double realPart, double imaginaryPart) {
        this.realPart = realPart;
        this.imaginaryPart = imaginaryPart;
    }

    public String asString() {
        if (imaginaryPart < 0) {
            return realPart + " " + imaginaryPart + "i";
        }
        else {
            if (imaginaryPart == 0) return String.valueOf(realPart);
            else return realPart + " + " + imaginaryPart + "i";
        }
    }
}
