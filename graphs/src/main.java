import java.util.ArrayList;
import java.util.Scanner;
/**/

public class main {

    static Scanner scan = new Scanner(System.in);
    static int[][] tablero = new int[][]{{0, 4, 0, 2, 0, 0}, {4, 0, 3, 0, 3, 0}, {0, 3, 0, 0, 0, 2}, {2, 0, 0, 0, 3, 0}, {0, 3, 0, 3, 0, 1}, {0, 0, 2, 0, 1, 0}};
    static int[] pueblos = new int[]{0,1,2,3,4,5};
    static ArrayList<Integer> camino = new ArrayList<>();
    static int distancia = 0;

    public static void genCamino(int i, int j){
        pueblos[i] = 7;
        if (tablero[i][j] != 0){
            camino.add(j+1);
            distancia += tablero[i][j];
        }
        else {
            for (int k = 0; k < 3; k++){
                if (tablero[i][k] != 0 && pueblos[k] != 7) { //Si hay conexion y no ha llegado al limite
                    camino.add(k+1); //Añadimos el pueblo al vector
                    distancia += tablero[i][k];
                    genCamino(k,j);
                }
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Matriz de adyacencia de los pueblos en Sucre (っ.❛ ᴗ ❛.)っ");
        for (int x = 0; x < 6; x++){
            System.out.println(tablero[x][0]+"  "+tablero[x][1]+"  "+tablero[x][2]+"  "+tablero[x][3]+"  "+
                    tablero[x][4]+"  "+tablero[x][5]);
        }

        int i = 1;
        int j = 4;
        genCamino(i,j);

        System.out.println("El camino desde el pueblo "+(i+1)+": "+camino);
        System.out.println("Con distancia: "+distancia);

    }
}
