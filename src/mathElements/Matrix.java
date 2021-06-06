package mathElements;

import solEquation.RowGauss;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import Tools.*;


/**
 * @author 肖瑜
 */
public class Matrix implements Serializable{
    /**
     * 矩阵
     * 阶数
     * 行数m，列数n
     * 行列式
     */
    public ArrayList<Vec> A;
    public int level;
    public int m,n;
    public Det det;

    /**
     * l列换r列
     */
    public void convertRow(int l, int r) throws MathException {
        if(l>=n||r>=n) {
            throw new MathException("l or r too large");
        }
        if(l==r) {
            return;
        }
        Collections.swap(A,l,r);
        if(m==n){
            det.res=-det.res;
        }
    }

    /**
     * 用传入的v改变i列
     */
    public void changeRow(int i, Vec v) throws MathException {
        if(i>=n) {
            throw new MathException("i too large");
        }
        A.set(i-1,v);
        if(m==n){
            det.permute(A);
        }
    }

    /**
     * l行换r行
     */
    public void convertLine(int l, int r) throws MathException {
        if(l>=m||r>=m) {
            throw new MathException("l or r too large");
        }
        if(l==r) {
            return;
        }
        Double line;
        for(int i=0;i<n;i++){
            line=A.get(i).x[l];
            A.get(i).x[l]=A.get(i).x[r];
            A.get(i).x[r]=line;
        }
        if(m==n){
            det.res=-det.res;
        }
    }

    /**
     * 用传入的v改变第i行
     */
    public void changeLine(int i, Vec v) throws MathException {
        if(i>=m) {
            throw new MathException("i too large");
        }
        if (n >= 0) {
            System.arraycopy(v.x, 0, A.get(i).x, 0, n);
        }
        if(m==n){
            det.permute(A);
        }
    }

    /**
     * l行+num*r行
     */
    public void calMatrix(int l, int r, Double num) throws MathException {
        if(l>=m||r>=m) {
            throw new MathException("l or r too large");
        }
        for(int i=0;i<n;i++){
            A.get(i).x[l]+=num*A.get(i).x[r];
        }
    }

    /**
     * 矩阵乘向量
     */
    public Vec mulVec(Vec x) throws MathException {
        if(n!=x.level){
            throw new MathException("matrix's row num doesn't match vector's");
        }
        Double[] temp=new Double[n];
        for(int i=0;i<m;i++){
            temp[i]=0.0;
            for(int j=0;j<n;j++){
                temp[i]+=A.get(j).x[i]*x.x[j];
            }
        }
        return new Vec(temp.clone());
    }

    /**
     * 矩阵乘法
     */
    public Matrix mulMatrix(Matrix matrix) throws MathException {
        if(n!=matrix.m){
            throw new MathException("these matrices can't multiply the other");
        }
        ArrayList<Vec> temp=new ArrayList<Vec>();
        Double[][] v=new Double[matrix.n][m];
        for(int j=0;j<matrix.n;j++){
            for(int i=0;i<m;i++){
                v[j][i]=0.0;
                for(int k=0;k<n;k++){
                    v[j][i]+=A.get(k).x[i]*matrix.getA().get(j).x[k];
                }
            }
        }
        for(int i=0;i<matrix.n;i++){
            temp.add(new Vec(v[i].clone()));
        }
        return new Matrix(temp);
    }

    /**
     * i行除以m
     */
    public void divLine(int i, double num){
        for(int j=0;j<n;j++){
            A.get(j).x[i]/=num;
        }
    }

    public Matrix(){}

    /**
     * 构造函数
     */
    public Matrix(ArrayList<Vec> matrix){
        this.A=matrix;
        this.level=matrix.size();
        this.n=matrix.size();
        this.m=matrix.get(0).level;
        if(m==n){
            this.det=new Det();
            this.det.level=this.level;
            this.det.permute(A);
        }
    }

    public ArrayList<Vec> getA() {
        return A;
    }

    public void setA(ArrayList<Vec> a) {
        A = a;
    }

    /**
     * 是否为实对称矩阵
     */
    public boolean isSymmetry(){
        if(m!=n){
            return false;
        }
        for(int i=0;i<level;i++){
            for(int j=0;j<level;j++){
                if(i==j) continue;
                if(!A.get(i).x[j].equals(A.get(j).x[i])){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @return 转置矩阵
     */
    public Matrix reserveMatrix() throws IOException, ClassNotFoundException {
        Matrix AT= GenericCopy.deepCopy(this);
        for(int i=0;i<level;i++){
            for(int j=0;j<level;j++){
                AT.A.get(j).x[i]=A.get(i).x[j];
            }
        }
        AT.m=n;
        AT.n=m;
        return AT;
    }

    /**
     * 单位阵
     */
    public static Matrix unitMatrix(int m){
        ArrayList<Vec> iNum =new ArrayList<>();
        Double[] rowNum =new Double[m];
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(i==j){
                    rowNum [j]=1.0;
                }else{
                    rowNum [j]=0.0;
                }
            }
            iNum .add((new Vec(rowNum.clone() )));
        }
        return new Matrix(iNum);
    }

    /**
     *
     * @return 逆矩阵
     */
    public Matrix inverseMatrix() throws MathException, IOException, ClassNotFoundException {
        Matrix I;  //单位阵

        /*
        求单位阵
         */
        I=unitMatrix(m);
        RowGauss.gaussConvert(GenericCopy.deepCopy(this),I);

        return I;
    }

    /**
     * 范数
     */
    public Double norm(int level) throws MathException, IOException, ClassNotFoundException {
        double norm=0.0;
        switch (level){
            /*
             列范数
             */
            case 1 -> {
                for(int i=0;i<n;i++){
                    double temp=0.0;
                    for(int j=0;j<m;j++){
                        temp+=Math.abs(A.get(i).x[j]);
                    }
                    norm=Math.max(norm,temp);
                }
            }
            /*
             * 谱范数
             * @tempMatrix A乘A转置
             */
            case 2 -> {
                Matrix tempMatrix= GenericCopy.deepCopy(this.mulMatrix(this.reserveMatrix()));
                throw new MathException("Sorry,I can't compute this level norm,please wait for update");
            }
            default -> {
                throw new MathException("Sorry,I can't compute this level norm,please wait for update");
            }
        }
        return norm;
    }

    /**
     * 行范数
     */
    public Double infiniteNorm(){
        double norm=0.0;
        for(int i=0;i<m;i++){
            double temp=0.0;
            for(int j=0;j<n;j++){
                temp+=Math.abs(A.get(j).x[i]);
            }
            norm=Math.max(norm,temp);
        }
        return norm;
    }

    /**
     * frobenius范数
     */
    public Double frobeniusNorm(){
        double norm=0.0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                norm+=A.get(i).x[j]*A.get(i).x[j];
            }
        }
        return Math.sqrt(norm);
    }

    @Override
    public String toString(){
        StringBuilder str=new StringBuilder();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                str.append(String.format("%10.10f",A.get(j).x[i])).append(" ");
            }
            str.append("\n");
        }
        return str.toString();
    }

//    public mathElements.Matrix deepClone() throws IOException,ClassNotFoundException{
//        //将对象写入流中
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
//        objectOutputStream.writeObject(this);
//        objectOutputStream.flush();
//        objectOutputStream.close();
//
//        //从流中取出
//        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
//        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
//        return (mathElements.Matrix) objectInputStream.readObject();
//    }
}
