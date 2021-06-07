package InterpolationAndApproximation;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Interpolation {
    public int level;
    List<Double> x;
    List<Double> f;
    List<List<Double>> DividedDifference= new ArrayList<>();
    public String originExpr;
    public String simpleExpr;

    public Interpolation(List<Double> x,List<Double> f,int level) {
        this.x=x;
        this.f = f;
        this.level=level;
    }

    /**
     * 牛顿插值
     */
    public String NewTownInterpolate() throws IOException {
        StringBuilder str=new StringBuilder("");
        str.append("      x                 f      ");
        DividedDifference.clear();
        for(int i=0;i<=level;i++){
            List<Double> temp=new ArrayList<>();
            DividedDifference.add(temp);
        }
        for(int i=1;i<=level;i++){
            str.append(String.format("          level%d",i));
        }
        str.append("\n");
        for(int i=0;i<=level;i++){
            str.append(String.format("%5f    %5f    ",x.get(i),f.get(i)));
            for(int j=0;j<=i;j++){
                if(j==0){
                    DividedDifference.get(j).add(f.get(i));
                }else{
                    int n=DividedDifference.get(j-1).size()-1;
                    double d1=DividedDifference.get(j-1).get(n);
                    double d2=DividedDifference.get(j-1).get(n-1);
                    DividedDifference.get(j).add((d1-d2)/(x.get(i)-x.get(i-j)));
                    str.append(String.format("  %5f  ",DividedDifference.get(j).get(DividedDifference.get(j).size()-1)));
                }
            }
            str.append("\n");
        }
        StringBuilder originExprBuilder = new StringBuilder();
        str.append("牛顿插值得到多项式：\n");
        for(int i=0;i<=level;i++){
            originExprBuilder.append(String.format("%+.5f",DividedDifference.get(i).get(0)));
            for(int j=0;j<i;j++){
                originExprBuilder.append(String.format("*(x-%f)",x.get(i)));
            }
        }
        originExpr = originExprBuilder.toString();
        str.append(originExpr);
        str.append("\n");
        Process pro = Runtime.getRuntime().exec("python python\\Simplize.py "+ originExprBuilder.toString());
        InputStreamReader stdin=new InputStreamReader(pro.getInputStream());
        LineNumberReader input=new LineNumberReader(stdin);
        String line = input.readLine();
        simpleExpr = line;
        pro.destroy();
        str.append("化简后多项式为：\n");
        str.append(line).append("\n------------------------------------------\n");
        return str.toString();
    }

    public void LagrangeInterpolate(){

    }
}
