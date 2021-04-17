package Test;

import mathElements.*;
import Tools.*;
import solEquation.*;
import findEigen.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 解方程组的测试类
 * @author 肖瑜
 */
public class solEquationTest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String input;
        final String quit="q";
        final String Continue="c";
        int level;

        while(true){
            Matrix matrix, inverseMatrix;
            ArrayList<Vec> a = new ArrayList<>();
            Double[][] read;
            Double[] x;
            Vec b;
            Equation equ;
            try {
                System.out.println("please input level:");
                level=sc.nextInt();
                read=new Double[level][level];

                System.out.println("please input matrix:");
                for(int i=0;i<level;i++){
                    for(int j=0;j<level;j++){
                        read[i][j]=sc.nextDouble();
                    }
                }
                for(int i=0;i<level;i++){
                    x=new Double[level];
                    for(int j=0;j<level;j++){
                        x[j]=read[j][i];
                    }
                    a .add(new Vec(x));
                }
                matrix=new Matrix(a );
                x=new Double[level];

                System.out.println("please input target vector:");
                for(int i=0;i<level;i++){
                    x[i]=sc.nextDouble();
                }
                b=new Vec(x);
                equ=new Equation(matrix,b);
                System.out.println("行列式的值:\n"+equ.getA().det.res);

                Cramer.cramer(equ);
                System.out.println("克莱姆法则求解:\n"+equ.getX());
                System.out.println("--------------------------");

                RowGauss.rowGauss(equ);
                System.out.println("列主元高斯变换求解:\n"+equ.getX());
                System.out.println("--------------------------");

                inverseMatrix=matrix.inverseMatrix();
                System.out.println("矩阵的逆:\n"+ inverseMatrix);
                System.out.println("使用逆求得解:\n"+ inverseMatrix.mulVec(b));
                System.out.println("--------------------------");

                Jacobi.jacobi(equ,50);
                System.out.println("Jacobi求解:\n"+equ.getX());
                System.out.println("--------------------------");

                GaussSeidel.GS(equ,50);
                System.out.println("Gauss-Seidel求解:\n"+equ.getX());
                System.out.println("--------------------------");

                SOR.sor(equ,50,1.25);
                System.out.println("SOR求解:(w=1.25)\n"+equ.getX());
                System.out.println("--------------------------");
            }catch (MathException e){
                System.out.println(e.Inf);
            }
            catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

            System.out.println("If you want to quit, please input 'q', if not, input'c'");
            input=sc.next();
            while(!quit.equals(input) && !Continue.equals(input)){
                System.out.println("please input 'q' or 'c'");
                input=sc.next();
            }
            if(quit.equals(input)){
                System.out.println("bye bye");
                System.exit(0);
            }
        }
    }
}
