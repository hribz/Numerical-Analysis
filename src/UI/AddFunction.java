/*
 * Created by JFormDesigner on Thu Jun 03 21:46:11 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import com.intellij.uiDesigner.core.*;

/**
 * @author Brainrain
 */
public class AddFunction extends JFrame {
    public AddFunction() {
        initComponents();
    }

    private void okButtonActionPerformed(ActionEvent e) {
        // TODO add your code here

    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        dispose();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        textPane1 = new JTextPane();
        panel1 = new JPanel();
        cancelButton = new JButton();
        okButton = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(400, 100));
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), 0, 0));

        //======== scrollPane1 ========
        {

            //---- textPane1 ----
            textPane1.setPreferredSize(new Dimension(300, 23));
            textPane1.setMinimumSize(new Dimension(300, 23));
            scrollPane1.setViewportView(textPane1);
        }
        contentPane.add(scrollPane1, new GridConstraints(0, 0, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));

            //---- cancelButton ----
            cancelButton.setText("\u53d6\u6d88");
            cancelButton.addActionListener(e -> cancelButtonActionPerformed(e));
            panel1.add(cancelButton, new GridConstraints(0, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

            //---- okButton ----
            okButton.setText("\u786e\u5b9a");
            okButton.addActionListener(e -> okButtonActionPerformed(e));
            panel1.add(okButton, new GridConstraints(1, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
        }
        contentPane.add(panel1, new GridConstraints(0, 1, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane1;
    private JTextPane textPane1;
    private JPanel panel1;
    private JButton cancelButton;
    private JButton okButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
