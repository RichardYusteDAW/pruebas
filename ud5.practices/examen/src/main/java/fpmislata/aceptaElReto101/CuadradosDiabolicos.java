package fpmislata.aceptaElReto101;

public class CuadradosDiabolicos {
    private int[][] array;

    CuadradosDiabolicos(int[][] array) {
        this.array = array;
    }

    public int[][] getArray() {
        return array;
    }

    public void setArray(int[][] array) {
        this.array = array;
    }

    // La constanste mágica es la suma de cada columna o cada fila o cada diagonal.
    private int cm() {
        int sum = 0;
        for (int j = 0; j < array[0].length; j++) {
            sum += array[0][j];
        }
        return sum;
    }

    public boolean esDiabolico() {
        int sum = 0;
        int cm = cm();

        // Sumar filas
        for (int i = 0; i < array.length; i++) {
            sum = 0;
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
            if (sum != cm) {
                return false;
            }
        }

        // Sumar columnnas
        for (int i = 0; i < array.length; i++) {
            sum = 0;
            for (int j = 0; j < array[i].length; j++) {
                sum += array[j][i];
            }
            if (sum != cm)
                return false;

        }

        // Sumar diagonal principal
        sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][i];
        }
        if (sum != cm)
            return false;

        // Sumar diagonal secundaria
        sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][array.length - 1 - i];
        }
        if (sum != cm)
            return false;

        return true;
    }

    public boolean esEsoterico() {
        int n = array.length;
        int totalNumbers = n * n;
        int cm = cm();
        boolean[] numeros = new boolean[totalNumbers];

        // Comprobar si es diabólico
        if (!esDiabolico())
            return false;

        // Verificar que están todos los números del 1 a totalNumbers;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int num = array[i][j];
                // Número menor que 1 o mayor que totalNumbers o repetido.
                if (num < 1 || num > totalNumbers || numeros[num - 1]) {
                    return false;
                }
                numeros[num - 1] = true;
            }
        }

        // Suma de las esquinas:
        int sumaEsquinas = array[0][0] + array[0][n - 1] + array[n - 1][0] + array[n - 1][n - 1];
        // Constante mágica 2 (CM2)
        int cm2 = 4 * cm / n;

        // Comprobar que la suma de las esquinas es 4cm/n
        if (sumaEsquinas != cm2)
            return false;

        /*
         * Si es impar:
         * La suma de las cifras de las cuatro casillas de la mitad de los laterales
         * suman la constante mágica 2.
         * Si se multiplica el valor de la casilla central por 4, se obtiene la
         * constante mágica 2.
         * 
         * Si es par:
         * La suma de las dos casillas centrales de cada uno de los cuatro laterales
         * suman el doble de la constante mágica 2 (2 · CM2)
         * La suma de las cuatro casillas centrales da como resultado la constante
         * mágica 2.
         */
        if (array.length % 2 != 0) {
            int sumaCentroLados = array[0][n / 2] + array[n / 2][0] + array[n / 2][n - 1] + array[n - 1][n / 2];
            int centro = array[n / 2][n / 2];

            if (sumaCentroLados != cm2 || centro * 4 != cm2)
                return false;
        } else {
            int sumaCentralesLaterales = array[n / 2 - 1][0] + array[n / 2][0] + // Lado izquierdo
                    array[0][n / 2 - 1] + array[0][n / 2] + // Lado superior
                    array[n - 1][n / 2 - 1] + array[n - 1][n / 2] + // Lado inferior
                    array[n / 2 - 1][n - 1] + array[n / 2][n - 1]; // Lado derecho

            int sumaCentrales = array[n / 2 - 1][n / 2 - 1] + array[n / 2 - 1][n / 2] +
                    array[n / 2][n / 2 - 1] + array[n / 2][n / 2];

            if (sumaCentralesLaterales != 2 * cm2 || sumaCentrales != cm2)
                return false;

        }

        return true;
    }
}