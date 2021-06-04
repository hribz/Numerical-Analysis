/*
 * Created by JFormDesigner on Thu Jun 03 17:05:09 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Brainrain
 */
public class UI extends JFrame {
    public static void main(String[] args) {
        UI ui=new UI();
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }

    public UI() {
        initComponents();
    }

    private void okButtonActionPerformed(ActionEvent e) {
        // TODO add your code here
        JOptionPane.showMessageDialog(null, "test UI");
    }

    private void addMatrixMouseClicked(MouseEvent e) {
        // TODO add your code here
        AddMatrix addMatrix = new AddMatrix("请输入矩阵");
        addMatrix.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addMatrix.pack();
        addMatrix.setVisible(true);
        addMatrix.setUi(this);
    }

    private void addFunctionMouseClicked(MouseEvent e) {
        // TODO add your code here
        AddFunction addFunction=new AddFunction();
        addFunction.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addFunction.pack();
        addFunction.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        rootPanel = new JPanel();
        operation = new JPanel();
        scrollPane1 = new JScrollPane();
        elementsList = new JList();
        picture = new JPanel();
        menuBar1 = new JMenuBar();
        addMatrix = new JMenu();
        addFunction = new JMenu();
        buttonBar = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();
        helpButton = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(800, 600));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== rootPanel ========
        {
            rootPanel.setBorder(new EmptyBorder(12, 12, 12, 12));
            rootPanel.setLayout(new BorderLayout());

            //======== operation ========
            {
                operation.setLayout(new BoxLayout(operation, BoxLayout.X_AXIS));

                //======== scrollPane1 ========
                {

                    //---- list1 ----
                    elementsList.setPreferredSize(new Dimension(100, 62));
                    scrollPane1.setViewportView(elementsList);
                }
                operation.add(scrollPane1);

                //======== picture ========
                {
                    picture.setLayout(new GridBagLayout());
                    ((GridBagLayout)picture.getLayout()).columnWidths = new int[] {474, 0};
                    ((GridBagLayout)picture.getLayout()).rowHeights = new int[] {305, 0};
                    ((GridBagLayout)picture.getLayout()).columnWeights = new double[] {0.0, 1.0E-4};
                    ((GridBagLayout)picture.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};
                }
                operation.add(picture);
            }
            rootPanel.add(operation, BorderLayout.CENTER);

            //======== menuBar1 ========
            {

                //======== addMatrix ========
                {
                    addMatrix.setText("\u65b0\u5efa\u77e9\u9635");
                    addMatrix.setIcon(UIManager.getIcon("FileChooser.listViewIcon"));
                    addMatrix.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            addMatrixMouseClicked(e);
                        }
                    });
                }
                menuBar1.add(addMatrix);

                //======== addFunction ========
                {
                    addFunction.setText("\u65b0\u5efa\u51fd\u6570");
                    addFunction.setIcon(new ImageIcon("C:\\Users\\Hershey\\Pictures\\function png icon.png"));
                    addFunction.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            addFunctionMouseClicked(e);
                        }
                    });
                }
                menuBar1.add(addFunction);
            }
            rootPanel.add(menuBar1, BorderLayout.NORTH);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 5, 80, 5, 80, 5, 80, 0};
                ((GridBagLayout)buttonBar.getLayout()).rowHeights = new int[] {0, 0};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0E-4};
                ((GridBagLayout)buttonBar.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                //---- okButton ----
                okButton.setText("OK");
                okButton.addActionListener(e -> okButtonActionPerformed(e));
                buttonBar.add(okButton, new GridBagConstraints(2, 0, 3, 1, 0.0, 0.0,
                    GridBagConstraints.WEST, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 0, 0), 0, 0));

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                buttonBar.add(cancelButton, new GridBagConstraints(4, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));

                //---- helpButton ----
                helpButton.setText("Help");
                buttonBar.add(helpButton, new GridBagConstraints(6, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            rootPanel.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(rootPanel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel rootPanel;
    private JPanel operation;
    private JScrollPane scrollPane1;
    private JList elementsList;
    private JPanel picture;
    private JMenuBar menuBar1;
    private JMenu addMatrix;
    private JMenu addFunction;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    private JButton helpButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables

    private Map<String, Object> listElements = new HashMap<>();

    public Map<String, Object> getListElements() {
        return listElements;
    }

    public void setListElements(Map<String, Object> listElements) {
        this.listElements = listElements;
    }

    public JList getElementsList() {
        return elementsList;
    }
}
