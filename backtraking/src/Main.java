package com.company;

public class Main {

    /*
    Resolver usando Bactracking, en un lenguaje de programación el siguiente problema:
    En un tablero de ajedrez, se coloca un alfil en la posición (x0, y0) y un peón en la posición (1, j), siendo 1 <= j <= 8.
    Se pretende encontrar una ruta para el peón que llegue a la fila 8 sin ser comido por el alfil,
    siendo el único movimiento permitido para el peón el de avance desde la posición (i, j) a la posición (i+1, j).
    Si se encuentra que el peón está amenazado por el alfil en la posición (i,j), entonces debe retroceder a la
    fila 1, columna j+1 o j-1 {(1, j+1), (1, j-1)}.
    Hay que tener en cuenta que el alfil ataca por diagonales.
    Contar la cantidad de soluciones que tiene dicho problema, dados x0, y0 y j.
     */

    static int cantSoluciones = 0;
    static int j = 0; //Fila
    static int interseccion = 0;
    static int[][] tablero = {{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0}};
    static int columnaAlfil = 1;
    static int filaAlfil = 3;

    public static void main(String[] args) {
        for (int x = 0; x < 8; x++){
            for (int y = 0; y < 8; y++){
                if ((Math.abs(columnaAlfil - x) == Math.abs(filaAlfil - y))) {
                    tablero[y][x] = 1;
                }
            }
        }
        for (int x = 0; x < 8; x++){
            System.out.println(tablero[x][0]+" "+tablero[x][1]+" "+tablero[x][2]+" "+tablero[x][3]+" "+
                    tablero[x][4]+" "+tablero[x][5]+" "+tablero[x][6]+" "+tablero[x][7]);
        }

        soluciones(0);

        System.out.println("La cantidad de soluciones es: " + cantSoluciones);
    }

    private static void soluciones(int z) { //Columna

            if (z < 8) {
                if (valido(z)) { //Posición en la matriz de 1
                    cantSoluciones += 1;
                    soluciones(z + 1);
                }else {
                    soluciones(z +1);
                }
            }

    }

    private static boolean valido(int z) {
        for (int w = 0; w < 8; w++) { //Recorre fila
            if (tablero[w][z] == 0) {
                interseccion = 0;
            } else {
                interseccion = 1;
                break;
            }
        }
        return interseccion == 0;
    }
}
