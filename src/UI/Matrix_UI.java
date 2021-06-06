/*
 * Created by JFormDesigner on Sat Jun 05 16:20:49 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;

import mathElements.Matrix;

/**
 * @author Brainrain
 */
public class Matrix_UI extends JFrame {
    public Matrix_UI() {
        initComponents();
    }

    public Matrix_UI(String name, Matrix matrix, UI ui){
        super(name);
        this.name = name;
        this.matrix=matrix;
        this.ui = ui;
        initComponents();
        updateText();
    }

    public void updateText(){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                text.get(i).get(j).setText(String.valueOf(matrix.getA().get(i).x[j]));
            }
        }
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        if(button1.getText().equals("编辑矩阵")){
            changeText(true);
            button1.setText("确定");
        }else{
            changeText(false);
            button1.setText("编辑矩阵");
            for (int i=0;i<n;i++) {
                for (int j=0;j<m;j++) {
                    matrix.A.get(i).x[j] = Double.valueOf(text.get(i).get(j).getText());
                }
            }
            if(m==n){
                matrix.det.permute(matrix.A);
                det.setText(String.valueOf(matrix.det.res));
            }
        }
    }

    private void changeText(boolean type){
        for (ArrayList<JTextField> jTextFields:
                text) {
            for (JTextField jTextField :
                    jTextFields) {
                jTextField.setEditable(true);
            }
        }
        comboBox1.setEnabled(!type);
    }

    public void initComboBox(){
        isAdding = true;
        model.removeAllElements();
        for (String str :
                ui.getMatrixListElements().keySet()) {
            model.addElement(str);
        }
        isAdding = false;
    }

    private void comboBox1ItemStateChanged(ActionEvent e) {
        // TODO add your code here
        if(isAdding){
            return;
        }
        try{
            Matrix matrix1 = ui.getMatrixListElements().get(comboBox1.getSelectedItem().toString()).matrix;
            Matrix temp_matrix = matrix.mulMatrix(matrix1);
            String matrix_name = "matrix"+ui.getMatrixListElements().size();
            ui.getMatrixListElements().put(matrix_name,new Matrix_UI(matrix_name,temp_matrix,ui));
            ui.createNodes(ui.getRoot(),matrix_name,"Matrix");
            isAdding = true;
            model.addElement(matrix_name);
            isAdding = false;
            comboBox1.repaint();
            JOptionPane.showMessageDialog(null, "生成矩阵"+matrix_name);
        }catch (Exception err){
            JOptionPane.showMessageDialog(null, "该矩阵无法相乘");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        button1 = new JButton();
        panel2 = new JPanel();
        label1 = new JLabel();
        det = new JTextField();
        label2 = new JLabel();
        comboBoxItems = new Vector<>();
        model = new DefaultComboBoxModel(comboBoxItems);
        comboBox1 = new JComboBox(model);
        text = new ArrayList<>();
        m = matrix.m;
        n = matrix.n;

        //======== this ========
        setMinimumSize(new Dimension(300, 200));
        var contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {0, 0};
        if(n>=6){
            ((GridBagLayout)contentPane.getLayout()).columnWidths[0] = 50*n+20;
        }
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {50*m+20, 30, 80, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.01, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.01, 0.01, 0.01, 1.0E-4};

        //======== panel1 ========
        {
            panel1.setLayout(new GridBagLayout());
            ((GridBagLayout)panel1.getLayout()).columnWidths = new int[n];
            ((GridBagLayout)panel1.getLayout()).rowHeights = new int[m];
            for(int i=0;i<m;i++){
                ((GridBagLayout)panel1.getLayout()).rowHeights[i]=50;
            }
            for(int i=0;i<n;i++){
                ((GridBagLayout)panel1.getLayout()).columnWidths[i]=50;
            }
            for(int i=0;i<n;i++){
                ArrayList<JTextField> temp_text_list=new ArrayList<>();
                text.add(temp_text_list);
                for(int j=0;j<m;j++){
                    JTextField temp_text = new JTextField();
                    temp_text_list.add(temp_text);
                    temp_text.setEditable(false);
                    panel1.add(temp_text, new GridBagConstraints(i, j, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 0, 0), 0, 0));
                }
            }
        }
        contentPane.add(panel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 5, 0), 0, 0));

        //---- button1 ----
        button1.setText("\u7f16\u8f91\u77e9\u9635");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 5, 0), 0, 0));

        //======== panel2 ========
        {
            panel2.setLayout(new GridBagLayout());
            ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {0, 99, 0};
            ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {32, 0, 0};
            ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
            ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

            //---- label1 ----
            label1.setText("\u884c\u5217\u5f0f");
            label1.setHorizontalTextPosition(SwingConstants.CENTER);
            label1.setHorizontalAlignment(SwingConstants.RIGHT);
            panel2.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 10), 0, 0));
            det.setEditable(false);
            if(m==n){
                det.setText(String.valueOf(matrix.det.res));
            }else {
                det.setText("该矩阵不存在行列式");
            }
            panel2.add(det, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

            //---- label2 ----
            label2.setText("\u9009\u62e9\u77e9\u9635\u76f8\u4e58");
            label2.setHorizontalAlignment(SwingConstants.RIGHT);
            panel2.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 10), 0, 0));
//            comboBox1.addActionListener();
            comboBox1.addActionListener(e -> comboBox1ItemStateChanged(e));

            panel2.add(comboBox1, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 0), 0, 0));
        if(n<6){
            setSize(300, 50*m+140);
        }else {
            setSize(50*n+20,50*m+140);
        }
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private ArrayList<ArrayList<JTextField>> text;
    private JButton button1;
    private JPanel panel2;
    private JLabel label1;
    private JTextField det;
    private JLabel label2;
    private JComboBox comboBox1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private String name;
    private Matrix matrix;
    private UI ui;
    private int m ;
    private int n ;
    private Vector<String> comboBoxItems ;
    private DefaultComboBoxModel model ;
    private boolean isAdding;

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }
}
