import java.util.ArrayList;

public class Main {

    //Test graph 1
    static int[][] graph1 = new int[][]{
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 1},
            {0, 1, 1, 1, 0}
    };

    //Test graph 2
    static int[][] graph2 = new int[][]{
            {0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 0},
            {0, 1, 1, 0, 0}
    };

    //Trace variables
    static  ArrayList<Integer> nodes = new ArrayList<>();
    static ArrayList<Integer> road = new ArrayList<>();
    static ArrayList<Integer> neighbours = new ArrayList<>();

    //Function to print the graph and generate the nodes
    public static void printGrph (int[][] graph){
        String row = "";
        for (int x = 0; x < graph.length; x++){
            for (int y = 0; y < graph.length; y++){
                String number = graph[x][y]+"";
                row = row + number + "  ";
            }
            System.out.println(row);
            row = "";
        }
        for (int n = 0; n < graph.length; n++){
            nodes.add(n);
        }
    }

    //Main recursive function
    public static void cycleExist(int[][]graph,int x){
        nodes.set(x, 69);
        int z = 0;
        traverseGraph(graph,x,z);
    }

    //Secondary recursive function
    public static void traverseGraph(int[][] graph,int y, int z) {
        if (z < graph.length) {
            if (graph[y][z] != 0 && nodes.get(z) != 69) {
                road.add(z);
                cycleExist(graph,z);
            }
            else{
                traverseGraph(graph,y,z+1);
            }
        }
    }

    //Neighboring nodes evaluating backtracking
    public static void neighbours(int[][] graph, int x){
        for (int y = 0; y < graph.length; y++){
            if (graph[x][y] != 0){
                neighbours.add(y);
            }
        }
    }

    //Test different graphs
    public static void test(int[][] graph, int origin){
        System.out.println("Adjacency matrix of graph:");
        printGrph(graph);
        origin = 0;
        neighbours.add(origin);
        neighbours(graph,origin);
        String cyclabe = "";
        for (int c = 0; c < neighbours.size(); c++){
            road.clear();
            road.add(origin);
            cycleExist(graph,neighbours.get(c));
            if (road.size() == graph.length) {
                cyclabe = "This graph is cyclable! (っ.❛ ᴗ ❛.)っ";
                road.add(origin);
                System.out.println("Cicle: "+road);
                break;
            }
            else{
                cyclabe = "This graph is not cyclable (´;︵;`)";
            }
        }
        System.out.println(cyclabe);
        System.out.println("");
    }

    public static void main(String[] args) {

        test(graph1, 0);
        test(graph2, 0);

    }
}
