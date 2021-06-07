/*
 * Created by JFormDesigner on Mon Jun 07 15:33:43 CST 2021
 */

package UI;

import IterativeMethods.Dichotomy;
import IterativeMethods.IterationMethod;
import mathElements.Constant;
import mathElements.Function;
import mathElements.MathException;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Brainrain
 */
public class Iterative_UI extends JFrame {
    public Iterative_UI(UI ui, Function_UI function_ui) {
        super(function_ui.getName()+"求根");
        this.name = function_ui.getName();
        this.ui = ui;
        this.function_ui = function_ui;
        initComponents();
        init();
    }

    public void init(){
        textField1.setText(function_ui.getFunction().expr);
    }

    public Iterative_UI() {
        initComponents();
    }

    /**
     * 二分法
     * @param e 触发事件
     */
    private void button5ActionPerformed(ActionEvent e) {
        // TODO add your code here
        try{
            long startTime=System.currentTimeMillis();
            double a=Double.parseDouble(textField3.getText());
            double b=Double.parseDouble(textField4.getText());
            Dichotomy dichotomy = new Dichotomy(a,b, Constant.iterationEsp,function_ui.getFunction());
            ui.getOutputArea().append(dichotomy.stimulate());
            long endTime=System.currentTimeMillis();
            textField6.setText(String.valueOf((double)(endTime-startTime)/1000));
        }catch (NumberFormatException | IOException err){
            JOptionPane.showMessageDialog(null,"请确保a,b为浮点数");
        } catch (MathException err) {
            JOptionPane.showMessageDialog(null,err.Inf);
        }
    }

    /**
     * 简单迭代法
     * @param e 触发事件
     */
    private void button2ActionPerformed(ActionEvent e) {
        // TODO add your code here
        try{
            long startTime=System.currentTimeMillis();
            double x=Double.parseDouble(textField7.getText());
            IterationMethod iterationMethod = new IterationMethod(x, Constant.iterationEsp,fi);
            ui.getOutputArea().append(iterationMethod.SimpleStimulate());
            long endTime=System.currentTimeMillis();
            textField10.setText(String.valueOf((double)(endTime-startTime)/1000));
        }catch (NumberFormatException | IOException err){
            JOptionPane.showMessageDialog(null,"请确保x0为浮点数");
        } catch (MathException err) {
            JOptionPane.showMessageDialog(null,err.Inf);
        }
    }

    /**
     * 加速迭代
     * @param e 触发事件
     */
    private void button3ActionPerformed(ActionEvent e) {
        // TODO add your code here
        try{
            long startTime=System.currentTimeMillis();
            double x=Double.parseDouble(textField7.getText());
            IterationMethod iterationMethod = new IterationMethod(x, Constant.iterationEsp,fi);
            ui.getOutputArea().append(iterationMethod.SteffensenStimulate());
            long endTime=System.currentTimeMillis();
            textField11.setText(String.valueOf((double)(endTime-startTime)/1000));
        }catch (NumberFormatException | IOException err){
            JOptionPane.showMessageDialog(null,"请确保x0为浮点数");
        } catch (MathException err) {
            JOptionPane.showMessageDialog(null,err.Inf);
        }
    }

    /**
     * 牛顿迭代
     * @param e 触发事件
     */
    private void button4ActionPerformed(ActionEvent e) {
        // TODO add your code here
        // TODO add your code here
        try{
            long startTime=System.currentTimeMillis();
            double x=Double.parseDouble(textField7.getText());
            IterationMethod iterationMethod = new IterationMethod(x, Constant.iterationEsp,function_ui.getFunction());
            ui.getOutputArea().append(iterationMethod.NewTownStimulate());
            long endTime=System.currentTimeMillis();
            textField12.setText(String.valueOf((double)(endTime-startTime)/1000));
        }catch (NumberFormatException | IOException err){
            JOptionPane.showMessageDialog(null,"请确保x0为浮点数");
        } catch (MathException err) {
            JOptionPane.showMessageDialog(null,err.Inf);
        }
    }

    private void button6ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(button6.getText().equals("确定")){
            button6.setText("编辑");
            changeState(true);
            fi=new Function(textField2.getText());
        }else{
            button6.setText("确定");
            changeState(false);
        }
    }

    private void changeState(boolean type){
        button2.setEnabled(type);
        button3.setEnabled(type);
        button4.setEnabled(type);
        textField2.setEditable(!type);
        textField7.setEnabled(type);
        textField8.setEnabled(type);
        textField9.setEnabled(type);
    }

    private void button7ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(button7.getText().equals("确定")){
            button7.setText("编辑");
            textField1.setEditable(false);
            textField3.setEnabled(true);
            textField4.setEnabled(true);
            textField6.setEnabled(true);
            button5.setEnabled(true);
            function_ui.setFunction(new Function(textField1.getText()));
        }else{
            button7.setText("确定");
            textField1.setEditable(true);
            textField3.setEnabled(false);
            textField4.setEnabled(false);
            textField6.setEnabled(false);
            button5.setEnabled(false);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        panel2 = new JPanel();
        label8 = new JLabel();
        textField1 = new JTextField();
        button7 = new JButton();
        label17 = new JLabel();
        panel3 = new JPanel();
        label3 = new JLabel();
        label4 = new JLabel();
        label1 = new JLabel();
        label2 = new JLabel();
        textField3 = new JTextField();
        textField4 = new JTextField();
        button5 = new JButton();
        textField6 = new JTextField();
        label18 = new JLabel();
        panel5 = new JPanel();
        label16 = new JLabel();
        label9 = new JLabel();
        textField2 = new JTextField();
        button6 = new JButton();
        panel4 = new JPanel();
        label11 = new JLabel();
        label12 = new JLabel();
        label6 = new JLabel();
        textField7 = new JTextField();
        button2 = new JButton();
        textField10 = new JTextField();
        label13 = new JLabel();
        label7 = new JLabel();
        textField8 = new JTextField();
        button3 = new JButton();
        textField11 = new JTextField();
        label14 = new JLabel();
        label10 = new JLabel();
        textField9 = new JTextField();
        button4 = new JButton();
        textField12 = new JTextField();
        label15 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new GridBagLayout());
            ((GridBagLayout)dialogPane.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)dialogPane.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)dialogPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)dialogPane.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPanel.getLayout()).columnWidths = new int[] {286};
                ((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {0, 49, 0};

                //======== panel1 ========
                {
                    panel1.setLayout(new GridBagLayout());

                    //======== panel2 ========
                    {
                        panel2.setLayout(new GridBagLayout());
                        ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 225, 0};
                        ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {34, 0};

                        //---- label8 ----
                        label8.setText("f(x)");
                        panel2.add(label8, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- textField1 ----
                        textField1.setPreferredSize(new Dimension(5, 30));
                        textField1.setEditable(false);
                        panel2.add(textField1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- button7 ----
                        button7.setText("\u7f16\u8f91");
                        button7.addActionListener(e -> button7ActionPerformed(e));
                        panel2.add(button7, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 0), 0, 0));

                        //---- label17 ----
                        label17.setText("\u4e8c\u5206\u6cd5\u9700\u8981\u5148\u786e\u5b9a\u533a\u95f4[a,b]");
                        label17.setHorizontalAlignment(SwingConstants.CENTER);
                        panel2.add(label17, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));
                    }
                    panel1.add(panel2, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //======== panel3 ========
                    {
                        panel3.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                        panel3.setLayout(new GridBagLayout());
                        ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {0, 46, 47, 43, 46, 0};
                        ((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {36, 0};

                        //---- label3 ----
                        label3.setText("a");
                        label3.setHorizontalAlignment(SwingConstants.CENTER);
                        panel3.add(label3, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- label4 ----
                        label4.setText("b");
                        label4.setHorizontalAlignment(SwingConstants.CENTER);
                        panel3.add(label4, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- label1 ----
                        label1.setText("\u65f6\u95f4");
                        label1.setHorizontalAlignment(SwingConstants.CENTER);
                        panel3.add(label1, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                        //---- label2 ----
                        label2.setText("\u4e8c\u5206\u6cd5");
                        label2.setHorizontalAlignment(SwingConstants.CENTER);
                        panel3.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));
                        panel3.add(textField3, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));
                        panel3.add(textField4, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                        //---- button5 ----
                        button5.setText("GO");
                        button5.addActionListener(e -> button5ActionPerformed(e));
                        panel3.add(button5, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                        //---- textField6 ----
                        textField6.setEditable(false);
                        panel3.add(textField6, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 5), 0, 0));

                        //---- label18 ----
                        label18.setText("s");
                        panel3.add(label18, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 0), 0, 0));
                    }
                    panel1.add(panel3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                contentPanel.add(panel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //======== panel5 ========
                {
                    panel5.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel5.getLayout()).columnWidths = new int[] {0, 225, 0};
                    ((GridBagLayout)panel5.getLayout()).rowHeights = new int[] {32, 26};

                    //---- label16 ----
                    label16.setText("\u8fed\u4ee3\u6cd5\u9700\u8981\u5c06f(x)=0\u5316\u4e3ax=\u03c6(x)\u7684\u5f62\u5f0f");
                    label16.setHorizontalAlignment(SwingConstants.CENTER);
                    panel5.add(label16, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label9 ----
                    label9.setText("\u03c6(x)");
                    panel5.add(label9, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- textField2 ----
                    textField2.setPreferredSize(new Dimension(5, 30));
                    panel5.add(textField2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- button6 ----
                    button6.setText("\u786e\u5b9a");
                    button6.addActionListener(e -> button6ActionPerformed(e));
                    panel5.add(button6, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                contentPanel.add(panel5, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //======== panel4 ========
                {
                    panel4.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
                    panel4.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {0, 0, 61, 0, 49, 0, 0};

                    //---- label11 ----
                    label11.setText("x0");
                    label11.setHorizontalAlignment(SwingConstants.CENTER);
                    panel4.add(label11, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label12 ----
                    label12.setText("\u65f6\u95f4");
                    label12.setHorizontalAlignment(SwingConstants.CENTER);
                    panel4.add(label12, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label6 ----
                    label6.setText("\u7b80\u5355\u8fed\u4ee3\u65b9\u6cd5");
                    label6.setHorizontalAlignment(SwingConstants.CENTER);
                    panel4.add(label6, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- textField7 ----
                    textField7.setEnabled(false);
                    panel4.add(textField7, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- button2 ----
                    button2.setText("GO");
                    button2.setEnabled(false);
                    button2.addActionListener(e -> button2ActionPerformed(e));
                    panel4.add(button2, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- textField10 ----
                    textField10.setEditable(false);
                    panel4.add(textField10, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label13 ----
                    label13.setText("s");
                    panel4.add(label13, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label7 ----
                    label7.setText("Steffensen\u52a0\u901f\u6536\u655b\u65b9\u6cd5");
                    label7.setHorizontalAlignment(SwingConstants.CENTER);
                    panel4.add(label7, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- textField8 ----
                    textField8.setEnabled(false);
                    panel4.add(textField8, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- button3 ----
                    button3.setText("GO");
                    button3.setEnabled(false);
                    button3.addActionListener(e -> button3ActionPerformed(e));
                    panel4.add(button3, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- textField11 ----
                    textField11.setEditable(false);
                    panel4.add(textField11, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label14 ----
                    label14.setText("s");
                    panel4.add(label14, new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label10 ----
                    label10.setText("\u725b\u987f\u6cd5");
                    label10.setHorizontalAlignment(SwingConstants.CENTER);
                    panel4.add(label10, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- textField9 ----
                    textField9.setEnabled(false);
                    panel4.add(textField9, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- button4 ----
                    button4.setText("GO");
                    button4.setEnabled(false);
                    button4.addActionListener(e -> button4ActionPerformed(e));
                    panel4.add(button4, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- textField12 ----
                    textField12.setEditable(false);
                    panel4.add(textField12, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- label15 ----
                    label15.setText("s");
                    panel4.add(label15, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));
                }
                contentPanel.add(panel4, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(contentPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel1;
    private JPanel panel2;
    private JLabel label8;
    private JTextField textField1;
    private JButton button7;
    private JLabel label17;
    private JPanel panel3;
    private JLabel label3;
    private JLabel label4;
    private JLabel label1;
    private JLabel label2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton button5;
    private JTextField textField6;
    private JLabel label18;
    private JPanel panel5;
    private JLabel label16;
    private JLabel label9;
    private JTextField textField2;
    private JButton button6;
    private JPanel panel4;
    private JLabel label11;
    private JLabel label12;
    private JLabel label6;
    private JTextField textField7;
    private JButton button2;
    private JTextField textField10;
    private JLabel label13;
    private JLabel label7;
    private JTextField textField8;
    private JButton button3;
    private JTextField textField11;
    private JLabel label14;
    private JLabel label10;
    private JTextField textField9;
    private JButton button4;
    private JTextField textField12;
    private JLabel label15;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    public String name;
    private UI ui;
    private Function_UI function_ui;
    private Function fi;
}
