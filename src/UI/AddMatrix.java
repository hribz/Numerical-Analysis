/*
 * Created by JFormDesigner on Thu Jun 03 16:09:23 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.*;
import com.intellij.uiDesigner.core.*;
import mathElements.*;

/**
 * @author Brainrain
 */
public class AddMatrix extends JFrame {
    public AddMatrix() {
        initComponents();
    }

    public AddMatrix(String title){
        super(title);
        initComponents();
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void mnCancelButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void okButtonActionPerformed(ActionEvent e){
        Matrix matrix;
        ArrayList<Vec> a = new ArrayList<>();
        Double[] x;
        Vec b;
        try{
            for (ArrayList<JTextField> jTextPanes : text) {
                x = new Double[m];
                for (int j = 0; j < jTextPanes.size(); j++) {
                    String str = jTextPanes.get(j).getText();
                    double number = Double.parseDouble(str);
                    x[j] = number;
                }
                a.add(new Vec(x));
            }
        }catch (Exception err){
            JOptionPane.showMessageDialog(null, "请输入浮点数或整数");
            return;
        }
        matrix = new Matrix(a);
        String matrix_name = "matrix"+ui.getMatrixListElements().size();
        Matrix_UI matrix_ui = new Matrix_UI(matrix_name,matrix,ui);
        ui.getMatrixListElements().put(matrix_name,matrix_ui);
        ui.getSolListMethods().put(matrix_name,new SolEquation(ui,matrix_ui));
        ui.createNodes(ui.getRoot(),matrix_name,"Matrix");
        dispose();
    }

    private void mnOkButtonActionPerformed(ActionEvent e){
        String strM = spinnerM.getValue().toString();
        String strN = spinnerN.getValue().toString();
        int m = 0,n = 0;
        try{
            m = Integer.parseInt(strM);
            n = Integer.parseInt(strN);
            if(m<=0||n<=0){
                throw new Exception();
            }
            if(m==this.m&&n==this.n){
                return;
            }
        }catch (Exception err){
            JOptionPane.showMessageDialog(null, "行数和列数应为大于零的整数！");
            return;
        }
        initInputComponents(m, n);
    }

    private void initComponents() {
        rootPanel = new JPanel();
        inputPanel = new JPanel();
        buttonPanel = new JPanel();
        mnPanel = new JPanel();
        mnInputPanel = new JPanel();
        mnButtonPanel = new JPanel();

        panel = new ArrayList<>();
        text = new ArrayList<>();
        scroll = new ArrayList<>();
        
        cancelButton = new JButton();
        okButton = new JButton();
        mnCancelButton = new JButton();
        mnOkButton = new JButton();

        labelM = new JLabel();
        labelN = new JLabel();
        spinnerM = new JSpinner();
        spinnerN = new JSpinner();
        scrollPaneM = new JScrollPane();
        scrollPaneN = new JScrollPane();

        hasInput = false;
        //======== this ========
        setMinimumSize(new Dimension(300, 65));
        var contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {300, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[4];
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};
        initMnComponents();
        setSize(300, 65);
        setLocationRelativeTo(getOwner());
    }

    private void initMnComponents(){
        var contentPane = getContentPane();
        ((GridBagLayout)contentPane.getLayout()).rowHeights[0]=50;
        //======== mnPanel ========
        {
            mnPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));

            //======== mnInputPanel ========
            {
                mnInputPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)mnInputPanel.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout)mnInputPanel.getLayout()).rowHeights = new int[] {0, 0, 0};
                ((GridBagLayout)mnInputPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)mnInputPanel.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

                //---- labelM ----
                labelM.setText("行数");
                mnInputPanel.add(labelM, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 10), 0, 0));

                //======== scrollPaneM ========
                {

                    //---- textPaneM ----
                    spinnerM.setPreferredSize(new Dimension(50, 23));
                    scrollPaneM.setViewportView(spinnerM);
                }
                mnInputPanel.add(scrollPaneM, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                //---- labelN ----
                labelN.setText("列数");
                mnInputPanel.add(labelN, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 10), 0, 0));

                //======== scrollPaneN ========
                {

                    //---- textField ----
                    spinnerN.setPreferredSize(new Dimension(50, 23));
                    scrollPaneN.setViewportView(spinnerN);
                }
                mnInputPanel.add(scrollPaneN, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
            }
            mnPanel.add(mnInputPanel, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

            //======== mnButtonPanel ========
            {
                mnButtonPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));

                //---- mnCancelButton ----
                mnCancelButton.setText("取消");
                mnCancelButton.addActionListener(e -> mnCancelButtonActionPerformed(e));
                mnButtonPanel.add(mnCancelButton, new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- mnOkButton ----
                mnOkButton.setText("确定");
                mnOkButton.addActionListener(e -> mnOkButtonActionPerformed(e));
                mnButtonPanel.add(mnOkButton, new GridConstraints(1, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));
            }
            mnPanel.add(mnButtonPanel, new GridConstraints(0, 1, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));
        }
        contentPane.add(mnPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                new Insets(0, 0, 0, 0), 0, 0));
    }

    private void initInputComponents(int m,int n){
        setMinimumSize(new Dimension(100*n, 100*m+135));
        var contentPane = getContentPane();
        if(n>3){
            ((GridBagLayout)contentPane.getLayout()).columnWidths[0] = 100 * n;
        }else{
            ((GridBagLayout)contentPane.getLayout()).columnWidths[0] = 300;
        }
        ((GridBagLayout)contentPane.getLayout()).rowHeights[1]=100*m;
        ((GridBagLayout)contentPane.getLayout()).rowHeights[2]=50;
        panel.clear();
        scroll.clear();
        text.clear();
        //======== rootPanel ========
        {
            inputPanel.removeAll();
            //======== inputPanel ========
            {
                inputPanel.setLayout(new GridLayoutManager(m, n, new Insets(0, 0, 0, 0), -1, -1));
                //======== panel_list ========
                {
                    for(int i=0;i<n;i++){
                        ArrayList<JPanel> temp_panel_list=new ArrayList<>();
                        panel.add(temp_panel_list);
                        ArrayList<JScrollPane> temp_scroll_list=new ArrayList<>();
                        scroll.add(temp_scroll_list);
                        ArrayList<JTextField> temp_text_list=new ArrayList<>();
                        text.add(temp_text_list);
                        for(int j=0;j<m;j++){
                            //======== panel ========
                            {
                                JPanel temp_panel = new JPanel();
                                temp_panel_list.add(temp_panel);
                                temp_panel.setBorder(LineBorder.createBlackLineBorder());
                                temp_panel.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
                                //======== scrollPane ========
                                {
                                    JScrollPane temp_scroll = new JScrollPane();
                                    temp_scroll_list.add(temp_scroll);
                                    //---- textField ----
                                    JTextField temp_text=new JTextField();
                                    temp_text_list.add(temp_text);
                                    temp_text.setMinimumSize(new Dimension(60, 23));
                                    temp_text.setPreferredSize(new Dimension(60, 23));
                                    temp_scroll.setViewportView(temp_text);
                                    temp_panel.add(temp_scroll, new GridConstraints(0, 0, 1, 1,
                                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                            null, null, null, 0, true));
                                    inputPanel.add(temp_panel, new GridConstraints(j, i, 1, 1,
                                            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                                            null, null, null));
                                }
                            }
                        }
                    }
                }
            }
            contentPane.add(inputPanel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

            //======== buttonPanel ========
            if(!hasInput){
                buttonPanel.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));

                //---- cancelButton ----
                cancelButton.setText("取消");
                cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
                buttonPanel.add(cancelButton, new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                //---- okButton ----
                okButton.setText("确认");
                okButton.addActionListener(e -> okButtonActionPerformed(e));
                buttonPanel.add(okButton, new GridConstraints(0, 1, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));

                contentPane.add(buttonPanel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                hasInput = true;
            }
        }
        if(n>3){
            setSize(105*n, 135+100*m);
        }else{
            setSize(300+5*n, 135+100*m);
        }
        setLocationRelativeTo(getOwner());
        this.m = m;
        this.n = n;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel rootPanel;
    private JPanel inputPanel;
    private JPanel mnPanel;
    private JPanel mnInputPanel;
    private JPanel mnButtonPanel;
    private ArrayList<ArrayList<JPanel>> panel;
    private ArrayList<ArrayList<JTextField>> text;
    private ArrayList<ArrayList<JScrollPane>> scroll;
    private JPanel buttonPanel;
    private JButton cancelButton;
    private JButton okButton;
    private JButton mnCancelButton;
    private JButton mnOkButton;
    private JLabel labelM;
    private JLabel labelN;
    private JSpinner spinnerM;
    private JSpinner spinnerN;
    private JScrollPane scrollPaneM;
    private JScrollPane scrollPaneN;

    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private boolean hasInput;
    private int m,n;
    private UI ui;

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }
}
