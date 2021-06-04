package Test;

import IterativeMethods.*;
import mathElements.Function;
import mathElements.MathException;

import java.io.IOException;

public class IterationTest {
    public static void main(String[] args) throws IOException, MathException {
        double a=0;
        double b=2;
        double accuracy=1e-4;
        Function f =new Function("x^2-3");

        Dichotomy dichotomy=new Dichotomy(a,b,accuracy,f);
        dichotomy.stimulate();

        IterationMethod iterationMethod =new IterationMethod(1.5,accuracy,f);
//        iterationMethod.SteffensenStimulate();
        iterationMethod.NewTownStimulate(1.5);
    }
}
