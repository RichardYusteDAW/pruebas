package fpmislata.aceptaElReto103;

import java.util.Scanner;

public class Herencia {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int polinomialDegree;
        int[] coefficients;
        int rectangles;

        while (true) {
            System.out.print("Introduce el coeficiente: ");
            polinomialDegree = sc.nextInt();
            if (polinomialDegree == 20)
                break;

            System.out.print("Introduce los coeficientes del polinomio: ");
            coefficients = new int[polinomialDegree + 1];
            for (int i = 0; i < coefficients.length; i++) {
                coefficients[i] = sc.nextInt();
            }

            System.out.println("Introduce el número de rectángulos: ");
            rectangles = sc.nextInt();

            System.out.println(determineResult(coefficients, rectangles));
        }

        sc.close();

    }

    // Evaluate the polynomial
    public static double evaluatePolynomial(double x, int[] coefficients) {
        double result = 0;
        for (int i = 0; i < coefficients.length; i++) {
            result += coefficients[i] * Math.pow(x, coefficients.length - i - 1);
        }
        return result;
    }

    // Calculate the area of the polynomial
    public static double calculateArea(int[] coefficients, int rectangles) {
        double area = 0;
        double base = 1.0 / rectangles;

        for (int i = 0; i < rectangles; i++) {
            double height = evaluatePolynomial(i * base, coefficients);

            if (height > 1) {
                height = 1;
            } else if (height < 0) {
                height = 0;
            }

            area += base * height;

        }

        return area;
    }

    // Determine the result of the inheritance
    public static String determineResult(int[] coefficients, int rectangles) {

        double cainArea = calculateArea(coefficients, rectangles);
        double abelArea = 1 - cainArea;

        if (Math.abs(cainArea - abelArea) <= 0.001) {
            return "JUSTO";
        } else if (cainArea > abelArea) {
            return "CAIN";
        } else {
            return "ABEL";
        }
    }
}
