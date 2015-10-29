package lt.vu.skaitiniai;

/**
 * Created by Povilas on 2015-10-29.
 */
public class MatrixCalculations {

    public double[] perkeltiesMetodas(double[][] matrix, double[] d, int count){

        //double[] d = getD(matrix, count);
        double[] answer = new double[1000];

        double[] C = new double[1000];
        double[] D = new double[1000];
        //a = matrix[i][i-1]
        //b = matrix[i][i]
        //c = matrix[i][i+1]
        C[0] = -matrix[0][1]/matrix[0][0];
        D[0] = d[0]/matrix[0][0];
        System.out.println("C ir D yra : " + C[0] + "      " +D[0]);
        for (int i = 1; i < count; i++){
            C[i]= - matrix[i][i+1] / ((matrix[i][i-1]*C[i-1])+matrix[i][i]);
            D[i]= (d[i] - matrix[i][i-1]*D[i-1]) / (matrix[i][i-1]*C[i-1] + matrix[i][i]);
            System.out.println("C " + i + " : " + C[i] + "  D " + i + " : " + D[i] );
        }
        answer[count-1] = D[count-1];
        System.out.println("D paskutinis ir ats yra : " + answer[count-1]+ "    " + count);
        for(int i = count-2; i >= 0; i--){
            System.out.println("I == " + i);
            answer[i] = C[i]*answer[i+1] + D[i];
        }
        return answer;
    }

    public  double[] getD(double[][] matrix, int count){
        double[] d = new double[1000];
        //for (int i = 0; i < count; i++){
       //     d[i] = 0;
        //    for (int j = 0; j < count; j++){
        //        d[i] += matrix[i][j]*(i+1);
         //   }
       // }
        d[0] = 1;
        d[1] = 0;
        d[2] = 1;
        return d;
    }
}
