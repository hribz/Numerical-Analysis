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
    public Process pro;
    public InputStreamReader stdin;
    public OutputStreamWriter stdout;

    public Function(String expr){
        this.expr = expr.replaceAll("\\s*","").replaceAll("\\^","**");
    }

    public void computation(double outX) throws IOException, MathException {
        x=outX;
        try{
            System.out.println(pro.isAlive());
            LineNumberReader input=new LineNumberReader(stdin);

            String line = input.readLine();
            funValue = Double.parseDouble(line);
            line = input.readLine();
            derivationValue = Double.parseDouble(line);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
