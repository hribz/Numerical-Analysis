/*
 * Created by JFormDesigner on Sat Jun 05 16:21:05 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import mathElements.Function;
import mathElements.MathException;

/**
 * @author Brainrain
 */
public class Function_UI extends JFrame {
    public Function_UI() {
        initComponents();
    }

    public Function_UI(String name, Function function,UI ui) {
        super(name);
        this.name = name;
        this.function = function;
        this.ui = ui;
        initComponents();
        Funtion.setText(function.expr);
    }

    private void EditButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(EditButton.getText().equals("编辑函数")){
            EditButton.setText("确定");
            Funtion.setEditable(true);
            setComEnabled(false);
        }else {
            try{
                if(Funtion.getText().isEmpty()){
                    throw new Exception();
                }
                function.editFunction(Funtion.getText());
            }catch (Exception err){
                JOptionPane.showMessageDialog(null, "请输入仅含变量x的函数表达式，例如x+1");
                return;
            }
            EditButton.setText("编辑函数");
            Funtion.setEditable(false);
            setComEnabled(true);
        }
    }

    private void setComEnabled(boolean method){
        textField1.setEnabled(method);
        textField2.setEnabled(method);
        textField2.setText("");
        textField3.setEnabled(method);
        textField3.setText("");
        okButton.setEnabled(method);
        cancelButton.setEnabled(method);
    }

    private void okButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        double x;
        try{
            x = Double.parseDouble(textField1.getText());
            function.computation(x);
            textField2.setText(String.valueOf(function.funValue));
            textField3.setText(String.valueOf(function.derivationValue));
        }catch (MathException err){
            JOptionPane.showMessageDialog(null,err.Inf);
        } catch (Exception err){
            JOptionPane.showMessageDialog(null,"请保证输入的x为数字");
        }
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        Funtion = new JTextField();
        EditButton = new JButton();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();
        panel1 = new JPanel();
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        textField3 = new JTextField();

        //======== this ========
        setMinimumSize(new Dimension(14, 200));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPanel.getLayout()).columnWidths = new int[] {302, 110, 0};
                ((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {31, 0};
                ((GridBagLayout)contentPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)contentPanel.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //---- Funtion ----
                Funtion.setEditable(false);
                contentPanel.add(Funtion, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));

                //---- EditButton ----
                EditButton.setText("\u7f16\u8f91\u51fd\u6570");
                EditButton.addActionListener(e -> EditButtonActionPerformed(e));
                contentPanel.add(EditButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(contentPanel, BorderLayout.NORTH);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 83, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- okButton ----
                okButton.setText("\u8ba1\u7b97");
                okButton.addActionListener(e -> okButtonActionPerformed(e));
                buttonBar.add(okButton, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 3), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("\u9000\u51fa");
                cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);

            //======== panel1 ========
            {
                panel1.setLayout(new GridBagLayout());
                ((GridBagLayout)panel1.getLayout()).columnWidths = new int[] {0, 63, 18, 106, 21, 103};
                ((GridBagLayout)panel1.getLayout()).rowHeights = new int[] {24};

                //---- label1 ----
                label1.setText("x=");
                panel1.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));
                panel1.add(textField1, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- label2 ----
                label2.setText("f(x)");
                panel1.add(label2, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- textField2 ----
                textField2.setEditable(false);
                panel1.add(textField2, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- label3 ----
                label3.setText("f'(x)");
                panel1.add(label3, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 5), 0, 0));

                //---- textField3 ----
                textField3.setEditable(false);
                panel1.add(textField3, new GridBagConstraints(5, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(panel1, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JTextField Funtion;
    private JButton EditButton;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    private JPanel panel1;
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JTextField textField3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private String name;
    private Function function;
    private UI ui;

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public JTextField getFuntion() {
        return Funtion;
    }
}
