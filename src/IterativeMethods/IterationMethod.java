package IterativeMethods;

import mathElements.Constant;
import mathElements.Function;
import mathElements.MathException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;

public class IterationMethod {
    double x;
    double Accuracy;
    Function f;
    int times;

    /**
     * 普通迭代法模拟
     * @return
     * @throws IOException
     * @throws MathException
     */
    public String SimpleStimulate() throws IOException, MathException {
        StringBuilder str=new StringBuilder();
        Process pro = Runtime.getRuntime().exec("python python\\SimpleIteration.py "+ f.expr+ " "+ x + " " + Accuracy);
        InputStreamReader stdin=new InputStreamReader(pro.getInputStream());
        LineNumberReader input=new LineNumberReader(stdin);

        try {
            String line;
            String preLine;
            String prePreLine;
            preLine="err";
            prePreLine="err";
            while((line=input.readLine())!=null){
                if(line.trim().equals("error")){
                    throw new MathException("迭代方法在"+ x +"处发散，请修改x或φ(x)");
                }
                str.append(line).append("\n");
                prePreLine=preLine;
                preLine=line;
            }
            x = Double.parseDouble(prePreLine);
            times = Integer.parseInt(preLine);
            pro.destroy();
            str.append("普通迭代法通过").append(times).append("次迭代，解得精度为").append(Constant.iterationEsp)
                    .append(String.format("的解x%d=%.9f\n", times, x)).append("------------------------------\n");
            return str.toString();
        }catch (NumberFormatException err){
            throw new MathException("请检查表达式是否合法");
        }
    }

    /**
     * Steffensen迭代法模拟
     * @return
     * @throws IOException
     * @throws MathException
     */
    public String SteffensenStimulate() throws IOException, MathException {
        StringBuilder str=new StringBuilder();
        Process pro = Runtime.getRuntime().exec("python python\\SteffensenIteration.py "+ f.expr+ " "+ x + " " + Accuracy);
        InputStreamReader stdin=new InputStreamReader(pro.getInputStream());
        LineNumberReader input=new LineNumberReader(stdin);

        try {
            String line;
            String preLine;
            String prePreLine;
            preLine="err";
            prePreLine="err";
            while((line=input.readLine())!=null){
                if(line.trim().equals("error")){
                    throw new MathException("迭代方法在"+ x +"处发散，请修改x或φ(x)");
                }
                str.append(line).append("\n");
                prePreLine=preLine;
                preLine=line;
            }
            x = Double.parseDouble(prePreLine);
            times = Integer.parseInt(preLine);
            pro.destroy();
            str.append("Sttenfensen迭代法通过").append(times).append("次迭代，解得精度为").append(Constant.iterationEsp)
                    .append(String.format("的解x%d=%.9f\n", times, x)).append("------------------------------\n");
            return str.toString();
        }catch (NumberFormatException err){
            throw new MathException("请检查表达式是否合法");
        }
    }

    /**
     * 牛顿法模拟
     * @return
     * @throws IOException
     * @throws MathException
     */
    public String NewTownStimulate() throws IOException, MathException {
        StringBuilder str=new StringBuilder();
        Process pro = Runtime.getRuntime().exec("python python\\NewtonIteration.py "+ f.expr+ " "+ x + " " + Accuracy);
        InputStreamReader stdin=new InputStreamReader(pro.getInputStream());
        LineNumberReader input=new LineNumberReader(stdin);

        try {
            String line;
            String preLine;
            String prePreLine;
            preLine="err";
            prePreLine="err";
            while((line=input.readLine())!=null){
                if(line.trim().equals("error")){
                    throw new MathException("牛顿法在"+ x +"处发散，请修改x或φ(x)");
                }
                str.append(line).append("\n");
                prePreLine=preLine;
                preLine=line;
            }
            x = Double.parseDouble(prePreLine);
            times = Integer.parseInt(preLine);
            pro.destroy();
            str.append("牛顿法通过").append(times).append("次迭代，解得精度为").append(Constant.iterationEsp)
                    .append(String.format("的解x%d=%.9f\n", times, x)).append("------------------------------\n");
            return str.toString();
        }catch (NumberFormatException err){
            throw new MathException("请检查表达式是否合法");
        }
    }

    public IterationMethod(double x, double accuracy, Function f) {
        this.x = x;
        Accuracy = accuracy;
        this.f = f;
    }
}
