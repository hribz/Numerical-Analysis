//package Test;
//
//import mathElements.*;
//import Tools.*;
//import solEquation.*;
//import findEigen.*;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Scanner;
//
///**
// * 求特征值、特征向量的测试类
// * @author 肖瑜
// */
//public class findEigenTest {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        String input;
//        final String quit="q";
//        final String Continue="c";
//        int level;
//
//        while(true){
//            Matrix matrix, inverseMatrix;
//            ArrayList<Vec> a = new ArrayList<>();
//            Double[][] read;
//            Double[] x;
//            Vec b;
//            Equation equ;
//            try {
//                System.out.println("please input level:");
//                level=sc.nextInt();
//                read=new Double[level][level];
//
//                System.out.println("please input matrix:");
//                for(int i=0;i<level;i++){
//                    for(int j=0;j<level;j++){
//                        read[i][j]=sc.nextDouble();
//                    }
//                }
//                for(int i=0;i<level;i++){
//                    x=new Double[level];
//                    for(int j=0;j<level;j++){
//                        x[j]=read[j][i];
//                    }
//                    a .add(new Vec(x));
//                }
//                matrix=new Matrix(a );
//                Vec target=new Vec();
//
//                System.out.println("用Jacobi迭代法求矩阵特征值和特征向量:");
//                JacobiEigenvalues.jacobiEigen(matrix,target);
//            }catch (MathException e){
//                System.out.println(e.Inf);
//            }
//            catch (IOException | ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println("If you want to quit, please input 'q', if not, input'c'");
//            input=sc.next();
//            while(!quit.equals(input) && !Continue.equals(input)){
//                System.out.println("please input 'q' or 'c'");
//                input=sc.next();
//            }
//            if(quit.equals(input)){
//                System.out.println("bye bye");
//                System.exit(0);
//            }
//        }
//    }
//}
