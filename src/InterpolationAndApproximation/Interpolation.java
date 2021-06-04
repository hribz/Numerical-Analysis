package InterpolationAndApproximation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interpolation {
    public int level;
    List<Double> x;
    List<Double> f;
    List<List<Double>> DividedDifference= new ArrayList<>();

    public Interpolation(List<Double> x,List<Double> f,int level) {
        this.x=x;
        this.f = f;
        this.level=level;
    }

    public void NewTownInterpolate(){
        System.out.print("     x         f    ");
        DividedDifference.clear();
        for(int i=0;i<=level;i++){
            List<Double> temp=new ArrayList<>();
            DividedDifference.add(temp);
        }
        for(int i=1;i<=level;i++){
            System.out.print(String.format("       level%d",i));
        }
        System.out.println();
        for(int i=0;i<=level;i++){
            System.out.print(String.format("%5f    %5f    ",x.get(i),f.get(i)));
            for(int j=0;j<=i;j++){
                if(j==0){
                    DividedDifference.get(j).add(f.get(i));
                }else{
                    int n=DividedDifference.get(j-1).size()-1;
                    double d1=DividedDifference.get(j-1).get(n);
                    double d2=DividedDifference.get(j-1).get(n-1);
                    DividedDifference.get(j).add((d1-d2)/(x.get(i)-x.get(i-j)));
                    System.out.print(String.format("  %5f  ",DividedDifference.get(j).get(DividedDifference.get(j).size()-1)));
                }
            }
            System.out.println();
        }
    }


}
