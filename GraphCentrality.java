import java.util.*;
import java.io.*;

public class GraphCentrality {
    public static void main(String args[]) throws Exception {
        File file;
        String path;

        do {
            System.out.print("please enter the path to graph.txt:" + "\nsuch as: \"/home/Desktop/...../\" , including \"graph.txt\" is not needed"
            +"\nif the path is incorrect you will be re-prompted");
            Scanner in = new Scanner(System.in);
            path = in.next();

            file = new File(path+"graph.txt");

        }while(!file.exists());



        BufferedReader br = new BufferedReader(new FileReader(file));

        Scanner sc = new Scanner(file);
        int n = Integer.valueOf(sc.next()) + 1;

        int m = Integer.valueOf(sc.next());
        int matrix[][] = new int[n][n];
        matrix = fillMatrix(matrix);
        //printMatrix(matrix);
        int max = 0;
        for (int i = 0; i < m; i++) {

            int a = Integer.valueOf(sc.next().trim());

            int b = Integer.valueOf(sc.next().trim());

            int c = Integer.valueOf(sc.next().trim());
            matrix[a][b] = c;
            matrix[b][a] = c;


        }


        degree(matrix, path);
        System.out.println("output has been written to: "+path+"wdegree.txt");


    }

    public static void degree(int matrix[][], String path) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + "wdegree.txt"));
            for (int i = 1; i < matrix.length; i++) {
                int nodeDegree = 0;
                for (int j = 1; j < matrix.length; j++) {
                    nodeDegree += matrix[i][j];

                }
                writer.write(Integer.toString(nodeDegree));
                writer.newLine();


            }
            writer.close();

        } catch (Exception e) {
            System.out.print("io exception");
        }
    }

    public static int[][] fillMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    public static void printMatrix(int matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);

            }
        }

    }
}
