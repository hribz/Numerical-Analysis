package mathElements;

import javax.sound.sampled.Line;
import java.io.*;
import java.sql.Time;
import java.util.TimerTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Function {
    public double x;
    public String expr;
    public double funValue;
    public double derivationValue;

    public Function(String expr){
        this.expr = expr.replaceAll("\\s*","").replaceAll("\\^","**");
    }

    public void editFunction(String function){
        this.expr = function.replaceAll("\\s*","").replaceAll("\\^","**");
    }

    public void computation(double outX) throws IOException, MathException {
        x=outX;
        try{
            Process pro = Runtime.getRuntime().exec("python python\\function.py "+ expr+ " "+ x);
            InputStreamReader stdin=new InputStreamReader(pro.getInputStream());
            LineNumberReader input=new LineNumberReader(stdin);

            String line = input.readLine();
            funValue = Double.parseDouble(line);
            line = input.readLine();
            derivationValue = Double.parseDouble(line);
            pro.destroy();
        }catch (Exception e){
            throw new MathException("请检查表达式是否合法");
        }
    }

}
