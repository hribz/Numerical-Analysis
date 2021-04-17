package mathElements;

public class Equation { //Ax=b
    private Vec b,x;
    private int level;
    private Matrix A;

    public Equation(){}

    public Equation(Matrix A, Vec b) throws MathException {
        if(A.n != A.m){
            throw new MathException("A is not tangile");
        } else if(A.level!=b.level){
            throw new MathException("A's level not matches b!");
        }
        this.A=A;
        this.level=A.level;
        this.b=b;
    }

    public Vec getB() {
        return b;
    }

    public void setB(Vec b) {
        this.b = b;
    }

    public Vec getX() {
        return x;
    }

    public void setX(Vec x) {
        this.x = x;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Matrix getA() {
        return A;
    }

    public void setA(Matrix a) {
        A = a;
    }
}
