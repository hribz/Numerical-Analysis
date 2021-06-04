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
        panel1 = new JPanel();
        panel3 = new JPanel();
        scrollPane2 = new JScrollPane();
        textPane2 = new JTextPane();
        scrollPane3 = new JScrollPane();
        textPane3 = new JTextPane();
        scrollPane4 = new JScrollPane();
        textPane4 = new JTextPane();
        scrollPane5 = new JScrollPane();
        textPane5 = new JTextPane();
        scrollPane6 = new JScrollPane();
        textPane6 = new JTextPane();
        scrollPane7 = new JScrollPane();
        textPane7 = new JTextPane();
        scrollPane8 = new JScrollPane();
        textPane8 = new JTextPane();
        scrollPane9 = new JScrollPane();
        textPane9 = new JTextPane();
        panel2 = new JPanel();
        button1 = new JButton();
        button2 = new JButton();
        panel4 = new JPanel();
        panel6 = new JPanel();
        label1 = new JLabel();
        scrollPane11 = new JScrollPane();
        spinner1 = new JSpinner();
        label2 = new JLabel();
        scrollPane12 = new JScrollPane();
        spinner2 = new JSpinner();
        panel5 = new JPanel();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(300, 350));
        var contentPane = getContentPane();
        contentPane.setLayout(new GridBagLayout());
        ((GridBagLayout)contentPane.getLayout()).columnWidths = new int[] {300, 0};
        ((GridBagLayout)contentPane.getLayout()).rowHeights = new int[] {305, 0, 50, 0};
        ((GridBagLayout)contentPane.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
        ((GridBagLayout)contentPane.getLayout()).rowWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};

        //======== panel1 ========
        {
            panel1.setLayout(new GridLayoutManager(3, 3, new Insets(0, 0, 0, 0), -1, -1));

            //======== panel3 ========
            {
                panel3.setBorder(LineBorder.createBlackLineBorder());
                panel3.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
            }
            panel1.add(panel3, new GridConstraints(0, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

            //======== scrollPane2 ========
            {
                scrollPane2.setViewportView(textPane2);
            }
            panel1.add(scrollPane2, new GridConstraints(0, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

            //======== scrollPane3 ========
            {
                scrollPane3.setViewportView(textPane3);
            }
            panel1.add(scrollPane3, new GridConstraints(0, 2, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

            //======== scrollPane4 ========
            {
                scrollPane4.setViewportView(textPane4);
            }
            panel1.add(scrollPane4, new GridConstraints(1, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

            //======== scrollPane5 ========
            {
                scrollPane5.setViewportView(textPane5);
            }
            panel1.add(scrollPane5, new GridConstraints(1, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

            //======== scrollPane6 ========
            {
                scrollPane6.setViewportView(textPane6);
            }
            panel1.add(scrollPane6, new GridConstraints(1, 2, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

            //======== scrollPane7 ========
            {
                scrollPane7.setViewportView(textPane7);
            }
            panel1.add(scrollPane7, new GridConstraints(2, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

            //======== scrollPane8 ========
            {
                scrollPane8.setViewportView(textPane8);
            }
            panel1.add(scrollPane8, new GridConstraints(2, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

            //======== scrollPane9 ========
            {
                scrollPane9.setViewportView(textPane9);
            }
            panel1.add(scrollPane9, new GridConstraints(2, 2, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
        }
        contentPane.add(panel1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== panel2 ========
        {
            panel2.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));

            //---- button1 ----
            button1.setText("text");
            button1.addActionListener(e -> button1ActionPerformed(e));
            panel2.add(button1, new GridConstraints(0, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

            //---- button2 ----
            button2.setText("text");
            panel2.add(button2, new GridConstraints(0, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
        }
        contentPane.add(panel2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 5, 0), 0, 0));

        //======== panel4 ========
        {
            panel4.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));

            //======== panel6 ========
            {
                panel6.setLayout(new GridBagLayout());
                ((GridBagLayout)panel6.getLayout()).columnWidths = new int[] {0, 0, 0};
                ((GridBagLayout)panel6.getLayout()).rowHeights = new int[] {0, 25, 0};
                ((GridBagLayout)panel6.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                ((GridBagLayout)panel6.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

                //---- label1 ----
                label1.setText("m");
                panel6.add(label1, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 10), 0, 0));

                //======== scrollPane11 ========
                {

                    //---- spinner1 ----
                    spinner1.setMinimumSize(new Dimension(50, 30));
                    spinner1.setMaximumSize(new Dimension(50, 30));
                    spinner1.setPreferredSize(new Dimension(50, 20));
                    scrollPane11.setViewportView(spinner1);
                }
                panel6.add(scrollPane11, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 5, 0), 0, 0));

                //---- label2 ----
                label2.setText("n");
                panel6.add(label2, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 10), 0, 0));

                //======== scrollPane12 ========
                {

                    //---- spinner2 ----
                    spinner2.setMinimumSize(new Dimension(50, 20));
                    spinner2.setPreferredSize(new Dimension(50, 20));
                    scrollPane12.setViewportView(spinner2);
                }
                panel6.add(scrollPane12, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            panel4.add(panel6, new GridConstraints(0, 0, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));

            //======== panel5 ========
            {
                panel5.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));

                //---- button3 ----
                button3.setText("text");
                panel5.add(button3, new GridConstraints(0, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));

                //---- button4 ----
                button4.setText("text");
                panel5.add(button4, new GridConstraints(1, 0, 1, 1,
                    GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                    null, null, null));
            }
            panel4.add(panel5, new GridConstraints(0, 1, 1, 1,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                null, null, null));
        }
        contentPane.add(panel4, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.CENTER, GridBagConstraints.BOTH,
            new Insets(0, 0, 0, 0), 0, 0));
        setSize(300, 460);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel1;
    private JPanel panel3;
    private JScrollPane scrollPane2;
    private JTextPane textPane2;
    private JScrollPane scrollPane3;
    private JTextPane textPane3;
    private JScrollPane scrollPane4;
    private JTextPane textPane4;
    private JScrollPane scrollPane5;
    private JTextPane textPane5;
    private JScrollPane scrollPane6;
    private JTextPane textPane6;
    private JScrollPane scrollPane7;
    private JTextPane textPane7;
    private JScrollPane scrollPane8;
    private JTextPane textPane8;
    private JScrollPane scrollPane9;
    private JTextPane textPane9;
    private JPanel panel2;
    private JButton button1;
    private JButton button2;
    private JPanel panel4;
    private JPanel panel6;
    private JLabel label1;
    private JScrollPane scrollPane11;
    private JSpinner spinner1;
    private JLabel label2;
    private JScrollPane scrollPane12;
    private JSpinner spinner2;
    private JPanel panel5;
    private JButton button3;
    private JButton button4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
