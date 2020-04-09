public class StringToComplex {
    public static ComplexNumber convert(String stringNumber) {
        double realPart, imaginaryPart;
//        Remove all spaces
        stringNumber = stringNumber.replaceAll("\\s","");
//        Find out where the real part of the complex number ends
        int iIndex = stringNumber.indexOf("i");
        //If there's no "i", then the whole string is just real part
        if (iIndex == -1) return new ComplexNumber(Double.parseDouble(stringNumber), 0);
        else {
            int signIndex = stringNumber.indexOf("+");
            if (signIndex == -1) {
                signIndex = stringNumber.lastIndexOf("-");
                if (signIndex <= 0) {
                    return new ComplexNumber(0, Double.parseDouble(stringNumber.substring(0, iIndex)));
                }
                else return new ComplexNumber(
                        Double.parseDouble(stringNumber.substring(0, signIndex)),
                        Double.parseDouble(stringNumber.substring(signIndex, iIndex))
                );
//            if (signIndex <= 0) signIndex = stringNumber.indexOf("+");
            }
//            I'd optimise it to have only 3 returns - zeroNumber, numberZero, numberNumber, but it works now and it's just a lab, so I won't
            else return new ComplexNumber(
                    Double.parseDouble(stringNumber.substring(0, signIndex)),
                    Double.parseDouble(stringNumber.substring(signIndex, iIndex))
            );
        }
    }
}
