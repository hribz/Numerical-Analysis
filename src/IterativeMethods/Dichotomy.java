package IterativeMethods;

import mathElements.*;
import Tools.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Dichotomy {
    double a;
    double b;
    double x;
    double Accuracy;
    Function f;
    public Process pro;
    public InputStreamReader stdin;

    public void stimulate() throws IOException, MathException {
        double c=0.0;
        int times=-1;
        double fa,fb,fc;

        Process pro = Runtime.getRuntime().exec("python src\\IterativeMethods\\dichotomy.py "+ f.expr+ " "+ a + " " + b + " " + Accuracy);
        InputStreamReader stdin=new InputStreamReader(pro.getInputStream());

        f.computation(a);
        fa=f.funValue;
        f.computation(b);
        fb=f.funValue;
        if(fa*fb>0){
            return;
        }
        try{
            while (b - a > Accuracy) {
                c = (a + b) / 2;
                f.computation(a);
                fa = f.funValue;
                f.computation(b);
                fb = f.funValue;
                f.computation(c);
                fc = f.funValue;
                if (Math.abs(fc) < Constant.compareZeroEsp) {
                    times++;
                    x = c;
                    System.out.println(String.format("x%d=%.9f", times, c));
                    break;
                } else if (fc * fa < 0) {
                    b = c;
                } else if (fc * fb < 0) {
                    a = c;
                }
                times++;
            }
        }catch (MathException e){
            System.out.println(e.Inf);
        }finally {
            pro.destroy();
        }
        x=c;
        System.out.println(String.format("x%d=%.9f",times,c));
    }

    public Dichotomy(double a, double b, double accuracy, Function f) {
        this.a = a;
        this.b = b;
        this.Accuracy=accuracy;
        this.f = f;
    }

}
