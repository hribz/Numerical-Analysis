package IterativeMethods;

import mathElements.Function;
import mathElements.MathException;

import java.io.IOException;

public class IterationMethod {
    double x;
    double Accuracy;
    Function f;

    public void SimpleStimulate() throws IOException, MathException {
        int times=0;
        double preX=x;
        double error=1;
        while(error>Accuracy){
            f.computation(preX);
            x= f.funValue;
            error=Math.abs((x-preX)/x);
            times++;
            preX=x;
        }
        System.out.println(String.format("x%d=%.9f",times,x));
    }

    public void SteffensenStimulate() throws IOException, MathException {
        int times=0;
        double preX=x;
        double error=1;
        double y,z;
        while(error>Accuracy){
            f.computation(preX);
            y=f.funValue;
            f.computation(y);
            z=f.funValue;
            x=preX-(y-preX)*(y-preX)/(z-2*y+preX);
            error=Math.abs((x-preX)/x);
            times++;
            preX=x;
        }
        System.out.println(String.format("x%d=%.9f",times,x));
    }

    public void NewTownStimulate(double x) throws IOException, MathException {
        int times=0;
        double preX=x;
        double error=1;
        double fx,dfx;
        while(error>Accuracy){
            f.computation(preX);
            fx=f.funValue;
            dfx=f.derivationValue;
            x=preX-fx/dfx;
            error=Math.abs((x-preX));
            times++;
            preX=x;
        }
        System.out.println(String.format("x%d=%.9f",times,x));
    }

    public IterationMethod(double x, double accuracy, Function f) {
        this.x = x;
        Accuracy = accuracy;
        this.f = f;
    }
}
