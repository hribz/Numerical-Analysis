/*
 * Created by JFormDesigner on Mon Jun 07 15:09:17 CST 2021
 */

package UI;

import java.awt.event.*;

import mathElements.Equation;
import mathElements.MathException;
import mathElements.Matrix;
import solEquation.*;

import java.awt.*;
import java.io.IOException;
import java.util.Vector;
import javax.swing.*;
import javax.swing.border.*;

public class SolEquation extends JFrame {
    public SolEquation(UI ui,Matrix_UI parent){
        super(parent.getName());
        this.name=parent.getName();
        this.ui=ui;
        this.parent=parent;
        initComponents();
        panel1.remove(comboBox1);
        comboBox1=new JComboBox(model);
        comboBox1.addActionListener(e->comboBox1ActionPerformed(e));
        panel1.add(comboBox1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                new Insets(0, 0, 0, 0), 0, 0));
        initComboBox();
    }

    public SolEquation() {
        initComponents();
    }

    public void initComboBox(){
        isAdding = true;
        model.removeAllElements();
        for (Matrix_UI matrix_ui :
                ui.getMatrixListElements().values()) {
            if(matrix_ui.getMatrix().n==1&&matrix_ui.getMatrix().m==parent.getMatrix().m){
                model.addElement(matrix_ui.getName());
            }
        }
        isAdding = false;
        if(model.getElementAt(0)!=null){
            target=ui.getMatrixListElements().get((String) model.getElementAt(0)).getMatrix();
        }
    }


    private void comboBox1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        System.out.println(isAdding);
        if(isAdding){
            return;
        }
        try{
            Matrix_UI matrix_ui = ui.getMatrixListElements().get(comboBox1.getSelectedItem().toString());
            target = matrix_ui.getMatrix();
            String matrix_name = (String) model.getElementAt(0);
            model.setSelectedItem(model.getElementAt(0));
            model.removeElement(model.getElementAt(0));
            model.insertElementAt(matrix_name,0);
            comboBox1.repaint();
        }catch (Exception err){
            JOptionPane.showMessageDialog(null, "该矩阵无法相乘");
        }
    }

    /**
     * 调用克莱姆法则
     * @param e
     * @throws Exception
     */
    private void button1ActionPerformed(ActionEvent e) throws Exception {
        // TODO add your code here
        if(target==null){
            JOptionPane.showMessageDialog(null,"请选择目标向量");
            throw new Exception();
        }
        try{
            long startTime=System.currentTimeMillis();
            Equation equ = new Equation(parent.getMatrix(),target.A.get(0));
            Cramer.cramer(equ);
            ui.getOutputArea().append("克莱姆法则求解得：\n"+equ.getX()+"\n");
            long endTime=System.currentTimeMillis();
            textField1.setText(String.valueOf((double) (endTime-startTime)/1000));
        } catch (Exception err) {
            ui.getOutputArea().append("无法使用克莱姆法则求解\n");
            textField1.setText("-1");
        } finally {
            ui.getOutputArea().append("------------------------------\n");
        }
    }

    /**
     * 调用高斯消元法
     * @param e
     */
    private void button2ActionPerformed(ActionEvent e) throws Exception {
        // TODO add your code here
        if(target==null){
            JOptionPane.showMessageDialog(null,"请选择目标向量");
            throw new Exception();
        }
        try{
            long startTime=System.currentTimeMillis();
            Equation equ = new Equation(parent.getMatrix(),target.A.get(0));
            RowGauss.rowGauss(equ);
            ui.getOutputArea().append("列主元高斯消元法求解得：\n"+equ.getX()+"\n");
            long endTime=System.currentTimeMillis();
            textField2.setText(String.valueOf((double) (endTime-startTime)/1000));
        } catch (Exception err) {
            ui.getOutputArea().append("无法使用列主元高斯消元法求解\n");
            textField2.setText("-1");
        } finally {
            ui.getOutputArea().append("------------------------------\n");
        }
    }

    /**
     * 调用高斯迭代法
     * @param e
     * @throws Exception
     */
    private void button3ActionPerformed(ActionEvent e) throws Exception {
        // TODO add your code here
        if(target==null){
            JOptionPane.showMessageDialog(null,"请选择目标向量");
            throw new Exception();
        }
        try{
            long startTime=System.currentTimeMillis();
            Equation equ = new Equation(parent.getMatrix(),target.A.get(0));
            int times= Integer.parseInt(textField6.getText());
            if(times<=0){
                throw new MathException("迭代次数应位大于0的整数!");
            }
            ui.getOutputArea().append(GaussSeidel.GS(equ,times));
            long endTime=System.currentTimeMillis();
            textField3.setText(String.valueOf((double) (endTime-startTime)/1000));
        }catch (NumberFormatException err){
            JOptionPane.showMessageDialog(null,"迭代次数应为整数！");
            textField3.setText("-1");
        }catch (MathException err){
            JOptionPane.showMessageDialog(null,err.Inf);
            textField3.setText("-1");
        }
        catch (Exception err) {
            ui.getOutputArea().append("无法使用高斯迭代法求解\n");
            textField3.setText("-1");
        } finally {
            ui.getOutputArea().append("------------------------------\n");
        }
    }

    /**
     * 调用Jacobi迭代法
     * @param e
     */
    private void button4ActionPerformed(ActionEvent e) throws Exception {
        // TODO add your code here
        if(target==null){
            JOptionPane.showMessageDialog(null,"请选择目标向量");
            throw new Exception();
        }
        try{
            long startTime=System.currentTimeMillis();
            Equation equ = new Equation(parent.getMatrix(),target.A.get(0));
            int times= Integer.parseInt(textField7.getText());
            if(times<=0){
                throw new MathException("迭代次数应位大于0的整数!");
            }
            ui.getOutputArea().append(Jacobi.jacobi(equ,times));
            long endTime=System.currentTimeMillis();
            textField4.setText(String.valueOf((double) (endTime-startTime)/1000));
        }catch (NumberFormatException err){
            JOptionPane.showMessageDialog(null,"迭代次数应为大于0的整数！");
            textField4.setText("-1");
        }catch (MathException err){
            JOptionPane.showMessageDialog(null,err.Inf);
            textField4.setText("-1");
        }
        catch (Exception err) {
            ui.getOutputArea().append("无法使用Jacobi迭代法求解\n");
            textField4.setText("-1");
        } finally {
            ui.getOutputArea().append("------------------------------\n");
        }
    }

    /**
     * 调用SOR方法
     * @param e
     */
    private void button5ActionPerformed(ActionEvent e) throws Exception {
        // TODO add your code here
        if(target==null){
            JOptionPane.showMessageDialog(null,"请选择目标向量");
            throw new Exception();
        }
        try{
            long startTime=System.currentTimeMillis();
            Equation equ = new Equation(parent.getMatrix(),target.A.get(0));
            int times= Integer.parseInt(textField8.getText());
            double w = Double.parseDouble(textField9.getText());
            if(times<=0){
                throw new MathException("迭代次数应位大于0的整数!");
            }
            ui.getOutputArea().append(SOR.sor(equ,times,w));
            long endTime=System.currentTimeMillis();
            textField5.setText(String.valueOf((double) (endTime-startTime)/1000));
        }catch (NumberFormatException err){
            JOptionPane.showMessageDialog(null,"迭代次数应为大于0的整数,松弛因子应为浮点数！");
            textField5.setText("-1");
        }catch (MathException err){
            JOptionPane.showMessageDialog(null,err.Inf);
            textField5.setText("-1");
        }
        catch (Exception err) {
            ui.getOutputArea().append("无法使用Jacobi迭代法求解\n");
            textField5.setText("-1");
        } finally {
            ui.getOutputArea().append("------------------------------\n");
        }
    }

    private void button6ActionPerformed(ActionEvent e) {
        // TODO add your code here
        try{
            button1ActionPerformed(e);
            button2ActionPerformed(e);
            button3ActionPerformed(e);
            button4ActionPerformed(e);
            button5ActionPerformed(e);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private void comboBox1ItemStateChanged(ItemEvent e) {
        // TODO add your code here
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        panel1 = new JPanel();
        label1 = new JLabel();
        comboBox1 = new JComboBox();
        panel2 = new JPanel();
        button6 = new JButton();
        panel6 = new JPanel();
        label4 = new JLabel();
        label10 = new JLabel();
        label5 = new JLabel();
        label3 = new JLabel();
        label2 = new JLabel();
        button1 = new JButton();
        textField1 = new JTextField();
        label11 = new JLabel();
        label6 = new JLabel();
        button2 = new JButton();
        textField2 = new JTextField();
        label12 = new JLabel();
        label7 = new JLabel();
        textField6 = new JTextField();
        button3 = new JButton();
        textField3 = new JTextField();
        label13 = new JLabel();
        label8 = new JLabel();
        textField7 = new JTextField();
        button4 = new JButton();
        textField4 = new JTextField();
        label14 = new JLabel();
        label9 = new JLabel();
        textField8 = new JTextField();
        textField9 = new JTextField();
        button5 = new JButton();
        textField5 = new JTextField();
        label15 = new JLabel();

        //======== this ========
        setMinimumSize(new Dimension(418, 304));
        var contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {418, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {302, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setMinimumSize(new Dimension(418, 304));
            dialogPane.setLayout(new GridBagLayout());
            ((GridBagLayout)dialogPane.getLayout()).columnWidths = new int[] {0, 0};
            ((GridBagLayout)dialogPane.getLayout()).rowHeights = new int[] {0, 0};
            ((GridBagLayout)dialogPane.getLayout()).columnWeights = new double[] {1.0, 1.0E-4};
            ((GridBagLayout)dialogPane.getLayout()).rowWeights = new double[] {1.0, 1.0E-4};

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {38, 40, 113};

                //======== panel1 ========
                {
                    panel1.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 103};

                    //---- label1 ----
                    label1.setText("\u9009\u62e9\u76ee\u6807\u5411\u91cf");
                    panel1.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- comboBox1 ----
                    comboBox1.addActionListener(e -> comboBox1ActionPerformed(e));
                    panel1.add(comboBox1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                contentPanel.add(panel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //======== panel2 ========
                {
                    panel2.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {25};

                    //---- button6 ----
                    button6.setText("GO ALL");
                    button6.addActionListener(e -> button6ActionPerformed(e));
                    panel2.add(button6, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                contentPanel.add(panel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //======== panel6 ========
                {
                    panel6.setBorder(new MatteBorder(1, 1, 1, 1, Color.black));
                    panel6.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel6.getLayout()).columnWidths = new int[] {0, 0, 0, 0, 0, 54, 0, 0};

                    //---- label4 ----
                    label4.setText("\u8ba1\u7b97\u65b9\u6cd5");
                    label4.setHorizontalAlignment(SwingConstants.CENTER);
                    panel6.add(label4, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label10 ----
                    label10.setText("\u8fed\u4ee3\u6b65\u6570");
                    label10.setHorizontalAlignment(SwingConstants.CENTER);
                    panel6.add(label10, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label5 ----
                    label5.setText("\u677e\u5f1b\u56e0\u5b50");
                    label5.setHorizontalAlignment(SwingConstants.CENTER);
                    panel6.add(label5, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label3 ----
                    label3.setText("\u7528\u65f6");
                    label3.setHorizontalAlignment(SwingConstants.CENTER);
                    panel6.add(label3, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label2 ----
                    label2.setText("\u514b\u83b1\u59c6\u6cd5\u5219");
                    label2.setHorizontalAlignment(SwingConstants.CENTER);
                    panel6.add(label2, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- button1 ----
                    button1.setText("GO");
                    button1.addActionListener(e -> {
                        try {
                            button1ActionPerformed(e);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    });
                    panel6.add(button1, new GridBagConstraints(4, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- textField1 ----
                    textField1.setEditable(false);
                    panel6.add(textField1, new GridBagConstraints(5, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label11 ----
                    label11.setText("s");
                    panel6.add(label11, new GridBagConstraints(6, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label6 ----
                    label6.setText("\u5217\u4e3b\u5143\u9ad8\u65af\u6d88\u5143\u6cd5");
                    label6.setHorizontalAlignment(SwingConstants.CENTER);
                    panel6.add(label6, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- button2 ----
                    button2.setText("GO");
                    button2.addActionListener(e -> {
                        try {
                            button2ActionPerformed(e);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    });
                    panel6.add(button2, new GridBagConstraints(4, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- textField2 ----
                    textField2.setEditable(false);
                    panel6.add(textField2, new GridBagConstraints(5, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label12 ----
                    label12.setText("s");
                    panel6.add(label12, new GridBagConstraints(6, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label7 ----
                    label7.setText("\u9ad8\u65af\u8fed\u4ee3\u6cd5");
                    label7.setHorizontalAlignment(SwingConstants.CENTER);
                    panel6.add(label7, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel6.add(textField6, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- button3 ----
                    button3.setText("GO");
                    button3.addActionListener(e -> {
                        try {
                            button3ActionPerformed(e);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    });
                    panel6.add(button3, new GridBagConstraints(4, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- textField3 ----
                    textField3.setEditable(false);
                    panel6.add(textField3, new GridBagConstraints(5, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label13 ----
                    label13.setText("s");
                    panel6.add(label13, new GridBagConstraints(6, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label8 ----
                    label8.setText("Jacobi\u8fed\u4ee3\u6cd5");
                    label8.setHorizontalAlignment(SwingConstants.CENTER);
                    panel6.add(label8, new GridBagConstraints(1, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));
                    panel6.add(textField7, new GridBagConstraints(2, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- button4 ----
                    button4.setText("GO");
                    button4.addActionListener(e -> {
                        try {
                            button4ActionPerformed(e);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    });
                    panel6.add(button4, new GridBagConstraints(4, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- textField4 ----
                    textField4.setEditable(false);
                    panel6.add(textField4, new GridBagConstraints(5, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label14 ----
                    label14.setText("s");
                    panel6.add(label14, new GridBagConstraints(6, 4, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- label9 ----
                    label9.setText("SOR\u65b9\u6cd5");
                    label9.setHorizontalAlignment(SwingConstants.CENTER);
                    panel6.add(label9, new GridBagConstraints(1, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));
                    panel6.add(textField8, new GridBagConstraints(2, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));
                    panel6.add(textField9, new GridBagConstraints(3, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- button5 ----
                    button5.setText("GO");
                    button5.addActionListener(e -> {
                        try {
                            button5ActionPerformed(e);
                        } catch (Exception exception) {
                            exception.printStackTrace();
                        }
                    });
                    panel6.add(button5, new GridBagConstraints(4, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- textField5 ----
                    textField5.setEditable(false);
                    panel6.add(textField5, new GridBagConstraints(5, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- label15 ----
                    label15.setText("s");
                    panel6.add(label15, new GridBagConstraints(6, 5, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));
                }
                contentPanel.add(panel6, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(contentPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(dialogPane, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel panel1;
    private JLabel label1;
    private JComboBox comboBox1;
    private JPanel panel2;
    private JButton button6;
    private JPanel panel6;
    private JLabel label4;
    private JLabel label10;
    private JLabel label5;
    private JLabel label3;
    private JLabel label2;
    private JButton button1;
    private JTextField textField1;
    private JLabel label11;
    private JLabel label6;
    private JButton button2;
    private JTextField textField2;
    private JLabel label12;
    private JLabel label7;
    private JTextField textField6;
    private JButton button3;
    private JTextField textField3;
    private JLabel label13;
    private JLabel label8;
    private JTextField textField7;
    private JButton button4;
    private JTextField textField4;
    private JLabel label14;
    private JLabel label9;
    private JTextField textField8;
    private JTextField textField9;
    private JButton button5;
    private JTextField textField5;
    private JLabel label15;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private Matrix target;
    public String name;
    private UI ui;
    private boolean isAdding;
    private Matrix_UI parent;
    private Vector<String> comboBoxItems = new Vector<>();
    private DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
}
