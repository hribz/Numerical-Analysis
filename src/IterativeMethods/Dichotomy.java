package IterativeMethods;

import mathElements.*;
import Tools.*;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStreamWriter;

public class Dichotomy {
    double a;
    double b;
    double x;
    double Accuracy;
    int times;
    Function f;

    /**
     * 二分模拟
     * @return 求解过程信息
     * @throws IOException 异常
     * @throws MathException 异常
     */
    public String stimulate() throws IOException, MathException {
        StringBuilder str=new StringBuilder();
        Process pro = Runtime.getRuntime().exec("python python\\dichotomy.py "+ f.expr+ " "+ a + " " + b + " " + Accuracy);
        InputStreamReader stdin=new InputStreamReader(pro.getInputStream());
        LineNumberReader input=new LineNumberReader(stdin);

        try {
            String line = input.readLine();
            String preLine;
            String prePreLine;
            if(line.trim().equals("a,b error")){
                throw new MathException("["+a+","+b+"]"+"内函数无唯一解或有重根");
            }
            str.append(line).append("\n");
            preLine=line;
            prePreLine="error";
            while((line=input.readLine())!=null){
                str.append(line).append("\n");
                prePreLine=preLine;
                preLine=line;
            }
            x = Double.parseDouble(prePreLine);
            times = Integer.parseInt(preLine);
            pro.destroy();
            str.append("二分法通过").append(times).append("次二分，解得精度为").append(Constant.iterationEsp)
                    .append(String.format("的解x%d=%.9f\n", times, x)).append("------------------------------\n");
            return str.toString();
        }catch (NumberFormatException err){
            throw new MathException("请检查表达式是否合法");
        }
    }

    public Dichotomy(double a, double b, double accuracy, Function f) {
        this.a = a;
        this.b = b;
        this.Accuracy=accuracy;
        this.f = f;
    }

}
