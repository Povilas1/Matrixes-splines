package lt.vu.skaitiniai;

import Jama.Matrix;

//import static lt.vu.skaitiniai.MatrixCalculations.*;

public class Main {

    public static void main(String[] args) {
        MatrixCalculations calculations = new MatrixCalculations();
        ReadMatrix read = new ReadMatrix();

        double[][] matrix = read.readMatrixFile("matrix.txt");
        double[] list = read.readAnswerFile("list.txt");
        int count = read.countLines("matrix.txt");

        double[] answer = calculations.perkeltiesMetodas(matrix, list, count);
        System.out.println("Atsakymas : ");
        for(int i = 0; i < count; i++){
            System.out.println(answer[i]);
        }
    }
}
