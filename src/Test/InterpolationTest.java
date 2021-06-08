package Test;

import InterpolationAndApproximation.Interpolation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InterpolationTest {
    public static void main(String[] args) {
        List<Double> x=new ArrayList<>();
        List<Double> f=new ArrayList<>();
        Double[] X={-2.0,-1.5,0.5,1.0,1.5};
        Double[] F={21.0,23.0,22.0,21.0,20.0};
        Collections.addAll(x, X);
        Collections.addAll(f, F);

        Interpolation interpolation=new Interpolation(x,f,4);
    }
}
