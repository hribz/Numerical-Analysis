package solEquation;

import java.io.IOException;
import java.util.ArrayList;
import mathElements.*;
import Tools.*;

/**
 * @author 肖瑜
 */
public class Jacobi {
    /**
     * jacobi迭代法,equ为Ax=b，iterateTimes为迭代步数
     * 将Ax=b转换为x=Gx+d
     * 取x(0)代入得x(1)=Gx(0)+d
     * 若||G||<1，则x(k)收敛
     * 重复迭代，若||G||不是很接近1，则可在||x(k)-x(k+1)||很小时停止，将其当作解
     * @param iterateTimes 迭代次数
     * @param equ 待求方程组
     */
    public static String jacobi(Equation equ, int iterateTimes) throws IOException, ClassNotFoundException, MathException {
        Matrix matrixA= GenericCopy.deepCopy(equ.getA());
        StringBuilder str=new StringBuilder();
        if(matrixA.m!=matrixA.n){
            throw new MathException("this is not a square matrix");
        }
        int level=matrixA.m;
        Vec vectorB= GenericCopy.deepCopy(equ.getB());
        /*
        获得迭代矩阵G,d
         */
        Matrix matrixG;
        Vec d;
        ArrayList<Vec> vecListG=new ArrayList<>();
        Double[][] vg=new Double[level][level];
        Double[] vd=new Double[level];
        for(int i=0;i<level;i++){
            double div=matrixA.A.get(i).x[i];
            for(int j=0;j<level;j++){
                vg[j][i]=-matrixA.A.get(j).x[i]/div;
            }
            vg[i][i]=0.0;
            vd[i]=vectorB.x[i]/div;
        }
        for(int i=0;i<level;i++){
            vecListG.add(new Vec(vg[i].clone()));
        }
        matrixG=new Matrix(vecListG);
        d=new Vec(vd);
        str.append("迭代矩阵为：\n").append(matrixG).append("\n");
        str.append("d为：\n").append(d).append("\n");
        /*
        设置X,nextX,开始迭代
         */
        str.append("Step       x1          x2         x3\n");
        Vec X=new Vec(level);
        Vec nextX;
        Vec cmp=new Vec(level);
        str.append(" 0  ").append(printX(X)).append("\n");

        for(int i=1;i<=iterateTimes;i++){
            nextX=matrixG.mulVec(X);
            nextX.addVec(d);
            str.append(" ").append(i).append("  ").append(printX(nextX)).append("\n");
            cmp.equAsubB(X,nextX);
            if(cmp.infiniteNorm()<= Constant.jacobiEsp){
                str.append("Jacobi迭代法经过").append(i).append("步得出精度为").append(Constant.jacobiEsp).append("的结果\n");
                equ.setX(nextX);
                return str.toString();
            }
            X.equVec(nextX);
        }

        return "Jacobi迭代法无法在"+iterateTimes+"步内得出精度为"+Constant.jacobiEsp+"的解，请尝试增加迭代步数并确保迭代法收敛\n";
    }

    public static String printX(Vec X){
        int level=X.level;
        StringBuilder temp=new StringBuilder();
        for(int i=0;i<level;i++){
            temp.append(String.format("%15.9f",X.x[i]));
        }
        return temp.toString();
    }

    /**
     * 按行严格对角占优
     */
    public static boolean positiveLine(Matrix matrix) throws MathException {
        if(matrix.m!=matrix.n){
            throw new MathException("this is not a square matrix");
        }
        for(int i=0;i<matrix.m;i++){
            double temp=matrix.A.get(i).x[i];
            double compare=0.0;
            for(int j=0;j<matrix.n;j++){
                if(j!=i){
                    compare+=matrix.A.get(j).x[i];
                }
            }
            if(temp<=compare){
                return false;
            }
        }
        return true;
    }

    /**
     * 按列严格对角占优
     */
    public static boolean positiveRow(Matrix matrix) throws MathException {
        if(matrix.m!=matrix.n){
            throw new MathException("this is not a square matrix");
        }
        for(int i=0;i<matrix.n;i++){
            double temp=matrix.A.get(i).x[i];
            double compare=0.0;
            for(int j=0;j<matrix.m;j++){
                if(j!=i){
                    compare+=matrix.A.get(i).x[j];
                }
            }
            if(temp<=compare){
                return false;
            }
        }
        return true;
    }
}
