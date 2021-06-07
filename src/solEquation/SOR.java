package solEquation;

import java.io.IOException;

import mathElements.*;
import Tools.*;

/**
 * @author 肖瑜
 */
public class SOR {
    /**
     * 松弛迭代法,equ为Ax=b，iterateTimes为迭代步数，w为松弛因子，w=1时即为GS迭代法
     * 将Ax=b转换为x=Gx+d
     * 取x(0)代入得x(1)=Gx(0)+d
     * 若||G||<1，则x(k)收敛
     * 重复迭代，若||G||不是很接近1，则可在||x(k)-x(k+1)||很小时停止，将其当作解
     * @param equ 待求等式
     * @param iterateTimes 迭代步数
     * @param w 松弛因子
     */
    public static String sor(Equation equ, int iterateTimes, double w) throws IOException, ClassNotFoundException, MathException {
        Matrix matrixA = GenericCopy.deepCopy(equ.getA());
        StringBuilder str=new StringBuilder("");
        if (matrixA.m != matrixA.n) {
            throw new MathException("this is not a square matrix");
        }
        if (w >= 2 || w <= 0) {
            throw new MathException("松弛因子应在(0,2)之间");
        }
        int level = matrixA.m;
        Vec vectorB = GenericCopy.deepCopy(equ.getB());
        /*
        设置X,nextX,开始迭代
         */
        str.append("Step       x1          x2         x3\n");
        Vec X = new Vec(level);
        Vec nextX = new Vec(level);
        Vec cmp = new Vec(level);
        str.append("松弛因子w=").append(w).append("\n");
        str.append(" 0  ").append(printX(X)).append("\n");

        for (int i = 1; i <= iterateTimes; i++) {
            for (int j = 0; j < level; j++) {
                double temp1 = 0.0;
                double temp2 = 0.0;
                double div = matrixA.getA().get(j).x[j];
                for (int k = 0; k < j; k++) {
                    temp1 += matrixA.A.get(k).x[j] * nextX.x[k];
                }
                for (int k = j + 1; k < level; k++) {
                    temp2 += matrixA.A.get(k).x[j] * X.x[k];
                }
                nextX.x[j] = w * (vectorB.x[j] - temp1 - temp2) / div - (w - 1) * X.x[j];
            }
            str.append(" ").append(i).append("  ").append(printX(nextX)).append("\n");
            cmp.equAsubB(X, nextX);
            if (cmp.infiniteNorm() <= Constant.sorEsp) {
                str.append("SOR方法(w=").append(w).append(")经过").append(i).append("步得出精度为"+Constant.sorEsp+"的结果").append("\n");
                equ.setX(nextX);
                return str.toString();
            }
            X.equVec(nextX);
        }

        return "SOR方法(w="+w+")无法在"+iterateTimes+"步内得出精度为"+Constant.sorEsp+"的解，请尝试增加迭代步数并确保迭代法收敛\n";
    }

    public static String printX(Vec X) {
        int level = X.level;
        StringBuilder temp = new StringBuilder();
        for (int i = 0; i < level; i++) {
            temp.append(String.format("%15.9f", X.x[i]));
        }
        return temp.toString();
    }

    /**
     * 按行严格对角占优
     */
    public static boolean positiveLine(Matrix matrix) throws MathException {
        if (matrix.m != matrix.n) {
            throw new MathException("this is not a square matrix");
        }
        for (int i = 0; i < matrix.m; i++) {
            double temp = matrix.A.get(i).x[i];
            double compare = 0.0;
            for (int j = 0; j < matrix.n; j++) {
                if (j != i) {
                    compare += matrix.A.get(j).x[i];
                }
            }
            if (temp <= compare) {
                return false;
            }
        }
        return true;
    }

    /**
     * 按列严格对角占优
     */
    public static boolean positiveRow(Matrix matrix) throws MathException {
        if (matrix.m != matrix.n) {
            throw new MathException("this is not a square matrix");
        }
        for (int i = 0; i < matrix.n; i++) {
            double temp = matrix.A.get(i).x[i];
            double compare = 0.0;
            for (int j = 0; j < matrix.m; j++) {
                if (j != i) {
                    compare += matrix.A.get(i).x[j];
                }
            }
            if (temp <= compare) {
                return false;
            }
        }
        return true;
    }
}
