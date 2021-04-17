package solEquation;

import java.io.IOException;
import java.util.ArrayList;
import mathElements.*;
import Tools.*;

/**
 * @author 肖瑜
 */
public class Cramer {

    public static void cramer(Equation equ) throws IOException, ClassNotFoundException, MathException {
        Matrix oriMatrix =equ.getA();
        if(Math.abs(oriMatrix .det.res)<= Constant.compareZeroEsp){
            throw new MathException("Don't have solve, please input again");
        }
        ArrayList<Matrix> changeMatrix =new ArrayList<>();
        Vec x;
        Double[] temp=new Double[equ.getA().level];
        for(int i=0;i<equ.getA().level;i++){
            changeMatrix .add(GenericCopy.deepCopy(oriMatrix));
            Matrix THIS =changeMatrix .get(i);
//            mathElements.Matrix reserve_THIS=THIS.reserveMatrix();
//            reserve_THIS.A.set(i,equ.getB());
//            reserve_THIS.det.permute(reserve_THIS.A);
            THIS.A.set(i,equ.getB());
            THIS.det.permute(THIS.A);
            temp[i]=THIS.det.res/oriMatrix .det.res;
        }
        x=new Vec(temp);
        equ.setX(x);
    }
}
