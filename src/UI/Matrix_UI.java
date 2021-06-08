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
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import findEigen.JacobiEigenvalues;
import mathElements.MathException;
import mathElements.Matrix;
import mathElements.Vec;

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
                initEigenValues();
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

    private void initEigenValues(){
        labelX.clear();
        labelV.clear();
        Eigen.clear();
        Vector.clear();
        panel3.removeAll();
        try{
            JacobiEigenvalues.jacobiEigen(matrix);
            EigenValues=JacobiEigenvalues.Eigenvalues;
            EigenVectors=JacobiEigenvalues.EigenVectors;

            //======== panel3 ========
            {
                panel3.setLayout(new GridBagLayout());
                ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {0, 42, 0, 176};
                ((GridBagLayout)panel3.getLayout()).rowHeights = new int[EigenValues.level];
                for(int i=0;i<EigenValues.level;i++){
                    ((GridBagLayout)panel3.getLayout()).rowHeights[i]=30;
                    JLabel temp_labelX = new JLabel();
                    JTextField temp_eigen = new JTextField();
                    JLabel temp_labelV = new JLabel();
                    JTextField temp_vector = new JTextField();
                    labelX.add(temp_labelX);
                    labelV.add(temp_labelV);
                    Eigen.add(temp_eigen);
                    Vector.add(temp_vector);
                    temp_labelX.setText("x"+(i+1));
                    temp_labelV.setText("v"+(i+1));
                    temp_eigen.setText(String.format("%.5f",EigenValues.x[i]));
                    temp_eigen.setEditable(false);
                    temp_vector.setText(EigenVectors.A.get(i).toString());
                    temp_vector.setEditable(false);
                    temp_eigen.setPreferredSize(new Dimension(65,30));
                    temp_vector.setPreferredSize(new Dimension(175,30));
                    //---- label4 ----
                    panel3.add(temp_labelX, new GridBagConstraints(0, i, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));
                    panel3.add(temp_eigen, new GridBagConstraints(1, i, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));

                    //---- label5 ----
                    panel3.add(temp_labelV, new GridBagConstraints(2, i, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 5), 0, 0));
                    panel3.add(temp_vector, new GridBagConstraints(3, i, 1, 1, 0.0, 0.0,
                            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                            new Insets(0, 0, 5, 0), 0, 0));
                }
            }
        }catch (MathException err){
            panel3.setLayout(new GridBagLayout());
            ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {0 };
            NullEigen.setText(err.Inf);
            panel3.add(NullEigen, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));
        }
        catch (Exception err){
            panel3.setLayout(new GridBagLayout());
            ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {0 };
            NullEigen.setText("该矩阵不存在特征值");
            panel3.add(NullEigen, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        panel4 = new JPanel();
        panel5 = new JPanel();
        button1 = new JButton();
        det = new JTextField();
        NullEigen = new JTextField();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        comboBoxItems = new Vector<>();
        model = new DefaultComboBoxModel(comboBoxItems);
        comboBox1 = new JComboBox(model);
        text = new ArrayList<>();
        labelX = new ArrayList<>();
        labelV = new ArrayList<>();
        Eigen = new ArrayList<>();
        Vector = new ArrayList<>();
        m = matrix.m;
        n = matrix.n;

        //======== this ========
        setMinimumSize(new Dimension(570, 300));
        var contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {200, 380, 0, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {260};
        if(n>=6){
            ((GridBagLayout)contentPane.getLayout()).columnWidths[0] = 50*n+20;
        }
        if(m>=4){
            ((GridBagLayout)contentPane.getLayout()).rowHeights[0] = 50*m+110;
        }
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 0.01, 0.0, 0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.01};

        //======== panel4 ========
        {
            panel4.setBorder(LineBorder.createBlackLineBorder());
            panel4.setLayout(new GridBagLayout());
            ((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {200};
            if(n>=4){
                ((GridBagLayout)panel4.getLayout()).columnWidths[0] = 50*n+50;
            }
            //======== panel1 ========
            {
                panel1.setLayout(new GridBagLayout());
                ((GridBagLayout) panel1.getLayout()).columnWidths = new int[n];
                ((GridBagLayout) panel1.getLayout()).rowHeights = new int[m];
                for (int i = 0; i < m; i++) {
                    ((GridBagLayout) panel1.getLayout()).rowHeights[i] = 50;
                }
                for (int i = 0; i < n; i++) {
                    ((GridBagLayout) panel1.getLayout()).columnWidths[i] = 50;
                }
                for (int i = 0; i < n; i++) {
                    ArrayList<JTextField> temp_text_list = new ArrayList<>();
                    text.add(temp_text_list);
                    for (int j = 0; j < m; j++) {
                        JTextField temp_text = new JTextField();
                        temp_text_list.add(temp_text);
                        temp_text.setEditable(false);
                        panel1.add(temp_text, new GridBagConstraints(i, j, 1, 1, 0.0, 0.0,
                                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                                new Insets(0, 0, 0, 0), 0, 0));
                    }
                }
            }
            panel4.add(panel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(0, 0, 20, 0), 0, 0));

            //---- button1 ----
            button1.setText("\u7f16\u8f91\u77e9\u9635");
            button1.addActionListener(e -> button1ActionPerformed(e));
            panel4.add(button1, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(0, 0, 5, 0), 0, 0));
        }
        contentPane.add(panel4, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                new Insets(0, 0, 0, 5), 0, 0));

        //======== panel2 ========
        {
            panel2.setLayout(new GridBagLayout());
            ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {105, 99};
            ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {32, 103, 0};

            //---- label1 ----
            label1.setText("\u884c\u5217\u5f0f");
            label1.setHorizontalTextPosition(SwingConstants.CENTER);
            label1.setHorizontalAlignment(SwingConstants.RIGHT);
            panel2.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 10), 0, 0));

            //---- det ----
            det.setPreferredSize(new Dimension(150, 30));
            det.setEditable(false);
            if(m==n){
                det.setText(String.valueOf(matrix.det.res));
            }else {
                det.setText("该矩阵不存在行列式");
            }
            panel2.add(det, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 5, 0), 0, 0));

            //---- label3 ----
            label3.setText("特征值和特征向量");
            label3.setHorizontalTextPosition(SwingConstants.RIGHT);
            label3.setHorizontalAlignment(SwingConstants.RIGHT);
            label3.setPreferredSize(new Dimension(100, 30));
            panel2.add(label3, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.EAST, GridBagConstraints.NONE,
                    new Insets(0, 0, 5, 10), 0, 0));
            //---- panel3 ----
            initEigenValues();
            panel2.add(panel3, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.NONE,
                    new Insets(0, 0, 5, 0), 0, 0));
            //---- label2 ----
            label2.setText("\u9009\u62e9\u77e9\u9635\u76f8\u4e58");
            label2.setHorizontalAlignment(SwingConstants.RIGHT);
            panel2.add(label2, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 10), 0, 0));

            //---- comboBox1 ----
            comboBox1.addActionListener(e -> comboBox1ItemStateChanged(e));

            panel2.add(comboBox1, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 0, 0), 0, 0));
        }
        contentPane.add(panel2, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.NONE,
                new Insets(0, 0, 0, 5), 0, 0));

        setSize(570, 300);
        if(m>=4&&n<4){
            setSize(570,50*m+150);
        }else if(m<4&&n>=4){
            setSize(370+50*n+50,300);
        }else if(m >= 4){
            setSize(370+50*n+50,50*m+150);
        }
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    private ArrayList<ArrayList<JTextField>> text;
    private JButton button1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField det;
    private JTextField NullEigen;
    private ArrayList<JLabel> labelX;
    private ArrayList<JLabel> labelV;
    private ArrayList<JTextField> Eigen;
    private ArrayList<JTextField> Vector;
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
    private Vec EigenValues;
    private Matrix EigenVectors;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public Matrix getMatrix() {
        return matrix;
    }

    public void setMatrix(Matrix matrix) {
        this.matrix = matrix;
    }
}
