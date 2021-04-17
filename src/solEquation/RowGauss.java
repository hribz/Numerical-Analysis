package solEquation;

import java.io.IOException;
import java.util.ArrayList;
import mathElements.*;
import Tools.*;

/**
 * @author 肖瑜
 */
public class RowGauss {

    public static void rowGauss(Equation equ) throws MathException, IOException, ClassNotFoundException {
        if(Math.abs(equ.getA().det.res)<= Constant.compareZeroEsp){
            throw new MathException("Don't have solve, please input again");
        }
        int level=equ.getLevel();
        Matrix matrixA= GenericCopy.deepCopy(equ.getA());
        Matrix matrixB;
        Vec b= GenericCopy.deepCopy(equ.getB());
        ArrayList<Vec> bNum =new ArrayList<>();
        Double[] temp=new Double[level];

        /*
        将b向量转换为矩阵
         */
        bNum .add(b);
        matrixB=new Matrix(bNum );
        gaussConvert(matrixA,matrixB);

//        for(int i=level-1;i>=0;i--){
//            m=0;
//            for(int j=i+1;j<level;j++){
//                m+=matrixA.matrixA.get(j).x[i]*temp[j];
//            }
//            m=(b.x[i]-m)/matrixA.matrixA.get(i).x[i];
//            temp[i]=m;
//        }
        if (level >= 0) {
            System.arraycopy(b.x, 0, temp, 0, level);
        }
        equ.setX(new Vec(temp));
    }

    /**
     * 列主元高斯变换
     */
    public static void gaussConvert(Matrix A, Matrix B) throws MathException {
        double m;
        int level=A.m;
        /*
          寻找列主元，上三角化
         */
        for(int i=0;i<level;i++){
            int maxSite =i;
            double max=A.A.get(i).x[i];
            for(int j=i+1;j<level;j++){
                if(A.A.get(i).x[j]>max){
                    maxSite =j;
                    max=A.A.get(i).x[j];
                }
            }
            A.convertLine(i,maxSite );
            B.convertLine(i,maxSite );
            if(Math.abs(A.A.get(i).x[i])<=1e-10){
                throw new MathException("this equation can't solve");
            }
            for(int j=i+1;j<level;j++){
                m=A.A.get(i).x[j]/A.A.get(i).x[i];
                A.calMatrix(j,i,-m);
                B.calMatrix(j,i,-m);
            }
        }
        /*
          单位化
         */
        for(int i=level-1;i>=0;i--){
            for(int j=i-1;j>=0;j--){
                m=A.A.get(i).x[j]/A.A.get(i).x[i];
                A.calMatrix(j,i,-m);
                B.calMatrix(j,i,-m);
            }
        }
        for(int i=0;i<level;i++){
            m=A.A.get(i).x[i];
            A.divLine(i,m);
            B.divLine(i,m);
        }
        System.out.print("高斯变换后A矩阵:\n"+A.toString()+"高斯变换后B矩阵:\n"+B.toString());
    }
}
