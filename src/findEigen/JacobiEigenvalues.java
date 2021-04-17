package findEigen;

import Tools.GenericCopy;
import mathElements.*;

import java.io.IOException;
import java.util.ArrayList;

public class JacobiEigenvalues {
    /**
     * Jacobi方法求特征值，特征向量
     */
    public static void jacobiEigen(Matrix matrix,Vec Eigenvalues) throws MathException, IOException, ClassNotFoundException {
        if(matrix.m!=matrix.n){
            System.out.println(("please check your matrix's level"));
            return;
        }
        if(!matrix.isSymmetry()){
            System.out.println("This matrix is not symmetric");
            return;
        }
        Matrix matrixA= GenericCopy.deepCopy(matrix);
        int level=matrixA.level;
        Matrix matrixU=Matrix.unitMatrix(level);
        Matrix matrixUT=Matrix.unitMatrix(level);
        int p=0;
        int q=0;
        double maxNum=1e9;
        double f;
        double cot2f;
        double tanf;
        double cosf;
        double sinf;
        double temp;
        double app;
        double aqq;
        double apq;
        while(true){
            /*
            获得模最大的非对角元素
             */
            temp=-1e9;
            for(int i=0;i<level;i++){
                for(int j=0;j<level;j++){
                    if(i!=j&&Math.abs(matrixA.A.get(j).x[i])>temp){
                        temp=Math.abs(matrixA.A.get(j).x[i]);
                        p=i;
                        q=j;
                    }
                }
            }
            app=matrixA.A.get(p).x[p];
            aqq=matrixA.A.get(q).x[q];
            apq=matrixA.A.get(q).x[p];
            maxNum=temp;
            if(maxNum<= Constant.jacobiEignEsp){
                break;
            }

            cot2f=(matrixA.A.get(p).x[p]-matrixA.A.get(q).x[q])/2/matrixA.A.get(q).x[p];
            if(cot2f<=Constant.compareZeroEsp){
                cosf=Math.cos(Math.signum(matrixA.A.get(p).x[p])*Math.PI/4);
                sinf=Math.sin(Math.signum(matrixA.A.get(p).x[p])*Math.PI/4);
            }else{
                f=Math.atan(1/cot2f)/2;
                sinf=Math.sin(f);
                cosf=Math.cos(f);
            }

            /*
            获得U
             */
            matrixU=matrixU.mulMatrix(getU(p,q,cosf,sinf,level));
            matrixUT=matrixUT.mulMatrix(getU(p,q,cosf,-sinf,level));
//            matrixA=getU(p,q,cosf,-sinf,level).mulMatrix(matrixA).mulMatrix(getU(p,q,cosf,sinf,level));
            /*
            获得下一个A
             */
            matrixA.A.get(p).x[p]=app*cosf*cosf+aqq*sinf*sinf+2*apq*cosf*sinf;
            matrixA.A.get(q).x[q]=app*sinf*sinf+aqq*cosf*cosf-2*apq*cosf*sinf;
            for(int i=0;i<level;i++){
                if(i==p||i==q) continue;
                double api=matrixA.A.get(i).x[p];
                double aqi=matrixA.A.get(i).x[q];
                matrixA.A.get(i).x[p]=matrixA.A.get(p).x[i]=api*cosf+aqi*sinf;
                matrixA.A.get(i).x[q]=matrixA.A.get(q).x[i]=-api*sinf+aqi*cosf;
            }
            matrixA.A.get(q).x[p]=matrixA.A.get(p).x[q]=(aqq-app)*sinf*cosf+apq*(2*cosf*cosf-1);
        }
//        matrixA=matrixUT.mulMatrix(matrixA).mulMatrix(matrixU);

        /*
        计算特征向量
         */
        Double[] values=new Double[level];
        for(int i=0;i<level;i++){
            values[i]=matrixA.A.get(i).x[i];
        }
        Eigenvalues=new Vec(values);

        for(int i=0;i<level;i++){
            System.out.println("特征值"+(i+1)+"为:"+Eigenvalues.x[i]+"  对应特征向量为"+"x"+(i+1)+"="+matrixU.A.get(i));
        }
    }
    public static Matrix getU(int p, int q, double cosf, double sinf, int level){
        ArrayList<Vec> uList=new ArrayList<>();
        Double[] temp=new Double[level];
        for(int i=0;i<level;i++){
            for(int j=0;j<level;j++){
                if((i==p&&j==p)||(i==q&&j==q)){
                    temp[j]=cosf;
                }else if(i==p&&j==q){
                    temp[j]=sinf;
                }else if(i==q&&j==p){
                    temp[j]=-sinf;
                }else if(i==j){
                    temp[j]=1.0;
                }else{
                    temp[j]=0.0;
                }
            }
            uList.add(new Vec(temp.clone()));
        }
        return new Matrix(uList);
    }
}
