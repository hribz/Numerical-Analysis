/*
 * Created by JFormDesigner on Thu Jun 03 21:46:11 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import com.intellij.uiDesigner.core.*;
import mathElements.Function;

public class AddFunction extends JFrame {
    public AddFunction() {
        initComponents();
    }

    private void okButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        Function function;
        try{
            if(textField1.getText().isEmpty()){
                throw new Exception();
            }
            function = new Function(textField1.getText());
        }catch (Exception err){
            JOptionPane.showMessageDialog(null, "请输入仅含变量x的函数表达式，例如x+1");
            return;
        }
        String function_name = "function" + ui.getFunctionListElements().size();
        Function_UI function_ui = new Function_UI(function_name,function,ui);
        ui.getFunctionListElements().put(function_name,function_ui);
        ui.getInterpolateListMethods().put(function_name,new Interpolation(ui,function_ui));
        ui.getIterativeListMethods().put(function_name,new Iterative_UI(ui,function_ui));
        ui.createNodes(ui.getRoot(),function_name,"Function");
        dispose();
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel4 = new JPanel();
        textField1 = new JTextField();
        panel3 = new JPanel();
        cancelButton = new JButton();
        okButton = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(400, 100));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel1 ========
        {
            panel1.setLayout(new BorderLayout(5, 5));

            //======== panel2 ========
            {
                panel2.setLayout(new GridBagLayout());
                ((GridBagLayout)panel2.getLayout()).columnWidths = new int[] {350, 96, 0};
                ((GridBagLayout)panel2.getLayout()).rowHeights = new int[] {71, 0};
                ((GridBagLayout)panel2.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel2.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //======== panel4 ========
                {
                    panel4.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel4.getLayout()).columnWidths = new int[] {340};
                    ((GridBagLayout)panel4.getLayout()).rowHeights = new int[] {31};

                    //---- textField1 ----
                    textField1.setPreferredSize(new Dimension(260, 25));
                    textField1.setMinimumSize(new Dimension(49, 20));
                    panel4.add(textField1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                panel2.add(panel4, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));

                //======== panel3 ========
                {
                    panel3.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel3.getLayout()).columnWidths = new int[] {85};
                    ((GridBagLayout)panel3.getLayout()).rowHeights = new int[] {30, 25};

                    //---- cancelButton ----
                    cancelButton.setText("\u53d6\u6d88");
                    cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
                    panel3.add(cancelButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 3, 3));

                    //---- okButton ----
                    okButton.setText("\u786e\u5b9a");
                    okButton.addActionListener(e -> okButtonActionPerformed(e));
                    panel3.add(okButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                panel2.add(panel3, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            panel1.add(panel2, BorderLayout.SOUTH);
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel4;
    private JTextField textField1;
    private JPanel panel3;
    private JButton cancelButton;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private UI ui;

    public UI getUi() {
        return ui;
    }

    public void setUi(UI ui) {
        this.ui = ui;
    }
}
