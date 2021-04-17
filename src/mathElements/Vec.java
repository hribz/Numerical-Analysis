package mathElements;

import java.io.*;

/**
 * @author 肖瑜
 */
public class Vec implements Serializable {
    public Double[] x;
    public int level;

    public Double dotVec(Vec v) throws MathException {
        if(v.level!=this.level){
            throw new MathException("level not matches!");
        }
        double temp = 0.0;
        for(int i=0;i<level;i++){
            temp+=v.x[i]*this.x[i];
        }
        return temp;
    }

    public void addVec(Vec v) throws MathException {
        if(v.level!=this.level){
            throw new MathException("level not matches!");
        }
        for(int i=0;i<level;i++){
            x[i]+=v.x[i];
        }
    }

    public void subVec(Vec v) throws MathException {
        if(v.level!=this.level){
            throw new MathException("level not matches!");
        }
        for(int i=0;i<level;i++){
            x[i]-=v.x[i];
        }
    }

    public void equVec(Vec v) throws MathException {
        if(v.level!=this.level){
            throw new MathException("level not matches!");
        }
        for(int i=0;i<level;i++){
            x[i]=v.x[i];
        }
    }

    public void equAsubB(Vec A,Vec B) throws MathException {
        if(A.level!=this.level){
            throw new MathException("level not matches!");
        }
        for(int i=0;i<level;i++){
            x[i]=A.x[i]-B.x[i];
        }
    }

    public void calVector(int l, int r, double num) throws MathException {
        if(l>=level||r>=level) {
            throw new MathException("l or r too large");
        }
        x[l]+=num*x[r];
    }

    public void convertVector(int l,int r) throws MathException {
        if(l>=level||r>=level) {
            throw new MathException("l or r too large");
        }
        Double temp=x[l];
        x[l]=x[r];
        x[r]=temp;
    }

    public Vec(){}

    public Vec(int level){
        x=new Double[level];
        for(int i=0;i<level;i++){
            x[i]=0.0;
        }
        this.level=level;
    }

    public Vec(Double[] x){
        this.x=x;
        level=x.length;
    }

    /**
     * 范数
     */
    public Double norm(int level) throws MathException, IOException, ClassNotFoundException {
        double norm=0.0;
        switch (level){
            case 1 -> {
                for(int i=0;i<level;i++){
                    norm+=Math.abs(x[i]);
                }
            }
            case 2 -> {
                for(int i=0;i<level;i++){
                    norm+=x[i]*x[i];
                }
                norm=Math.sqrt(norm);
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
        for(int i=0;i<level;i++){
            norm=Math.max(norm,Math.abs(x[i]));
        }
        return norm;
    }

    @Override
    public String toString(){
        StringBuilder str=new StringBuilder();
        str.append("(");
        for (int i=0;i<level-1;i++) {
            str.append(x[i]);
            str.append(", ");
        }
        str.append(x[level - 1]).append(")");
        return str.toString();
    }

//    public mathElements.Vec deepClone() throws IOException,ClassNotFoundException{
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
//        return (mathElements.Vec) objectInputStream.readObject();
//    }
}
