package lt.vu.skaitiniai;

import Jama.Matrix;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Povilas on 2015-10-28.
 */

public class ReadMatrix {
    private static final int MAXMATRIX = 1000;
    public static double[][] readMatrixFile(String fileName) {
        //List<int[]> rowList = new ArrayList<double[]>();
        double[][] matrix = new double[MAXMATRIX][MAXMATRIX];
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader =
                    new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            int linesCount = countLines(fileName);
            System.out.println("Eiluciu kiekis : " + linesCount);

            //int zeros = linesCount - 3;
            String line = null;

            int currentLine = 0;

            while ((line = bufferedReader.readLine()) != null) {
                int idejau = 0;
                String temp[] = line.split(" ");
                for (int i = 0; i < linesCount; i++) {
                    if (i < temp.length && currentLine < 2) {
                        matrix[currentLine][i] = Double.parseDouble(temp[i]);
                        System.out.print(temp[i] + " ");
                        idejau++;
                    } else if (i > currentLine - 2 && currentLine >= 2 && idejau < 3) {
                        matrix[currentLine][i] = Double.parseDouble(temp[idejau]);
                        System.out.print(" Dedu skaiciu  ");
                        idejau++;
                    } else {
                        matrix[currentLine][i] = 0;
                        System.out.print(" Dedu nuli ");
                    }
                }
                System.out.print("\n");
                currentLine++;

            }

            System.out.println("Matrica yra : ");
            for (int i = 0; i < linesCount; i++) {
                for (int j = 0; j < linesCount; j++) {
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.print("\n");
            }
            System.out.println("End of matrix");

            System.out.println("Eiluciu kiekis : " + currentLine);
            bufferedReader.close();

        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }

        return matrix;
    }

    public double[] readAnswerFile(String fileName){
        double[] answer = new double[MAXMATRIX];
        try {
            FileReader fileReader =
                    new FileReader(fileName);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            String line = null;
            int i = 0;
            while ((line = bufferedReader.readLine()) != null) {
                answer[i] = Double.parseDouble(line);
                i++;
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" +
                            fileName + "'");
        } catch (IOException ex) {
            System.out.println(
                    "Error reading file '"
                            + fileName + "'");
        }
            return answer;
    }

    public static int countLines(String fileReader) {
        LineNumberReader reader = null;
        try {
            reader = new LineNumberReader(new FileReader(fileReader));
            while ((reader.readLine()) != null) ;
            return reader.getLineNumber();
        } catch (Exception ex) {
            return -1;
        } finally {
            if (reader != null)
                try{
                    reader.close();
                } catch (IOException e){
                    System.out.println(e);
                }

        }

    }

    private static Matrix doubleToMatrix(double[][] doubleMatrix) {
        return new Matrix(doubleMatrix);
    }

    public static Matrix getMatrix(String fileName) {
        return doubleToMatrix(readMatrixFile(fileName));
    }
}
