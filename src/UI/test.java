/*
 * Created by JFormDesigner on Thu Jun 03 16:47:12 CST 2021
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
public class test extends JFrame {
    public static void main(String[] args) {
        test T = new test();
        T.pack();
        T.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        T.setVisible(true);
    }

    public test() {
        initComponents();
    }

    private void button1ActionPerformed(ActionEvent e) {
        // TODO add your code here
        AddMatrix addMatrix = new AddMatrix("请输入矩阵");
        addMatrix.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addMatrix.pack();
        addMatrix.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane2 = new JScrollPane();
        scrollPane1 = new JScrollPane();
        tree1 = new JTree();

        //======== this ========
        setMinimumSize(new Dimension(300, 350));
        var contentPane = getContentPane();
        contentPane.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), 5, -1));

        //======== scrollPane2 ========
        {

            //======== scrollPane1 ========
            {
                scrollPane1.setViewportView(tree1);
            }
            scrollPane2.setViewportView(scrollPane1);
        }
        contentPane.add(scrollPane2, new GridConstraints(0, 1, 1, 1,
            GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
            null, null, null));
        setSize(300, 460);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JScrollPane scrollPane2;
    private JScrollPane scrollPane1;
    private JTree tree1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
