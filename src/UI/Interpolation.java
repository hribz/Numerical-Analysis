/*
 * Created by JFormDesigner on Mon Jun 07 15:34:11 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.*;

/**
 * @author Brainrain
 */
public class Interpolation extends JFrame {
    public Interpolation(UI ui, Function_UI function_ui) throws HeadlessException {
        super(function_ui.getName());
        this.name = function_ui.getName();
        this.ui = ui;
        this.function_ui = function_ui;
        initComponents();
        functionText.setText(function_ui.getFunction().expr);
    }

    public Interpolation() {
        initComponents();
    }

    private void initInputPanel() {
        level = Integer.parseInt(levelSpinner.getValue().toString());
        if(level<=0){
            JOptionPane.showMessageDialog(null,"请保证阶数大于等于1");
            return;
        }
        labelX.clear();
        labelY.clear();
        textY.clear();
        textX.clear();
        inputPanel.removeAll();
        //---- inputPanel ----
        {
            inputPanel.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED));
            inputPanel.setLayout(new GridBagLayout());
            ((GridBagLayout)inputPanel.getLayout()).columnWidths = new int[level + 1];
            ((GridBagLayout)inputPanel.getLayout()).rowHeights = new int[]{30,30,30,30};
            for(int i=0;i<=level;i++){
                ((GridBagLayout)inputPanel.getLayout()).columnWidths[i]=60;
                JLabel tempLabelX=new JLabel();
                labelX.add(tempLabelX);
                JLabel tempLabelY=new JLabel();
                labelY.add(tempLabelY);
                JTextField tempTextX=new JTextField();
                textX.add(tempTextX);
                JTextField tempTextY=new JTextField();
                textY.add(tempTextY);

                tempLabelX.setText("x"+i);
                tempLabelX.setBorder(LineBorder.createBlackLineBorder());
                tempLabelX.setHorizontalAlignment(SwingConstants.CENTER);
                inputPanel.add(tempLabelX, new GridBagConstraints(i, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                inputPanel.add(tempTextX, new GridBagConstraints(i, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                tempLabelY.setText("y"+i);
                tempLabelY.setBorder(LineBorder.createBlackLineBorder());
                tempLabelY.setHorizontalAlignment(SwingConstants.CENTER);
                inputPanel.add(tempLabelY, new GridBagConstraints(i, 2, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                tempTextY.setEditable(!checkFxBox.isSelected());

                inputPanel.add(tempTextY, new GridBagConstraints(i, 3, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));
            }

        }
        setSize(420+5*level,420+5*level);
    }

    private void initText() {
        x = new ArrayList<>();
        y = new ArrayList<>();
        try{
            if (checkFxBox.isSelected()) {
                for (int i = 0; i < textX.size(); i++) {
                    x.add(Double.parseDouble(textX.get(i).getText()));
                    function_ui.getFunction().computation(x.get(i));
                    textY.get(i).setText(String.format("%.5f", function_ui.getFunction().funValue));
                    y.add(function_ui.getFunction().funValue);
                    textX.get(i).setEditable(false);
                }
            } else {
                for (int i = 0; i < textX.size(); i++) {
                    x.add(Double.parseDouble(textX.get(i).getText()));
                    y.add(Double.parseDouble(textY.get(i).getText()));
                    textX.get(i).setEditable(false);
                    textY.get(i).setEditable(false);
                }
            }
        }catch (Exception err){
            JOptionPane.showMessageDialog(null,"请确保输入为浮点数");
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        functionPanel = new JPanel();
        fx = new JLabel();
        functionText = new JTextField();
        editFunctionButton = new JButton();
        levelPanel = new JPanel();
        levelLabel = new JLabel();
        levelSpinner = new JSpinner();
        editLevelButton = new JButton();
        checkFxBox = new JCheckBox();
        inputPanel = new JPanel();
        labelX = new ArrayList<>();
        labelY = new ArrayList<>();
        textX = new ArrayList<>();
        textY = new ArrayList<>();
        confrimLevelButton = new JButton();
        panel5 = new JPanel();
        LButton = new JButton();
        LTextField = new JTextField();
        NButton = new JButton();
        NTextField = new JTextField();

        //======== this ========
        setMinimumSize(new Dimension(420, 410));
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {
                contentPanel.setLayout(new GridBagLayout());
                ((GridBagLayout)contentPanel.getLayout()).columnWidths = new int[] {343};
                ((GridBagLayout)contentPanel.getLayout()).rowHeights = new int[] {48, 60, 75, 0, 0};

                //======== functionPanel ========
                {
                    functionPanel.setLayout(new GridBagLayout());
                    ((GridBagLayout)functionPanel.getLayout()).columnWidths = new int[] {0, 212, 0, 0};
                    ((GridBagLayout)functionPanel.getLayout()).rowHeights = new int[] {28, 0};
                    ((GridBagLayout)functionPanel.getLayout()).columnWeights = new double[] {0.0, 0.0, 0.0, 1.0E-4};
                    ((GridBagLayout)functionPanel.getLayout()).rowWeights = new double[] {0.0, 1.0E-4};

                    //---- fx ----
                    fx.setText("f(x)");
                    fx.setHorizontalAlignment(SwingConstants.CENTER);
                    functionPanel.add(fx, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- functionText ----
                    functionText.setEditable(false);
                    functionPanel.add(functionText, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- editFunctionButton ----
                    editFunctionButton.setText("\u7f16\u8f91");
                    functionPanel.add(editFunctionButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                contentPanel.add(functionPanel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 20, 0), 0, 0));

                //======== levelPanel ========
                {
                    levelPanel.setLayout(new GridBagLayout());
                    ((GridBagLayout)levelPanel.getLayout()).columnWidths = new int[] {72, 103, 0, 0};

                    //---- levelLabel ----
                    levelLabel.setText("\u8bf7\u8f93\u5165\u9636\u6570");
                    levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
                    levelPanel.add(levelLabel, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));
                    levelSpinner.setValue(3);
                    levelPanel.add(levelSpinner, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- editLevelButton ----
                    editLevelButton.setText("确认");
                    editLevelButton.addActionListener(e -> editLevelButtonActionListener(e));
                    levelPanel.add(editLevelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- checkFxBox ----
                    checkFxBox.setText("\u4f7f\u7528f(x)\u4f5c\u4e3ay");
                    checkFxBox.addActionListener(e -> checkFxBoxActionListener(e));
                    checkFxBox.setSelected(true);
                    levelPanel.add(checkFxBox, new GridBagConstraints(3, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                contentPanel.add(levelPanel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 20, 0), 0, 0));

                //======== inputPanel ========
                initInputPanel();
                contentPanel.add(inputPanel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 20, 0), 0, 0));

                //---- confirmLevelButton ----
                confrimLevelButton.setText("\u786e\u5b9a");
                confrimLevelButton.addActionListener(e -> confirmLevelButtonActionLister(e));
                contentPanel.add(confrimLevelButton, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.NONE,
                    new Insets(0, 0, 20, 0), 0, 0));

                //======== panel5 ========
                {
                    panel5.setLayout(new GridBagLayout());
                    ((GridBagLayout)panel5.getLayout()).columnWidths = new int[] {0, 211, 0};
                    ((GridBagLayout)panel5.getLayout()).rowHeights = new int[] {0, 0, 0};
                    ((GridBagLayout)panel5.getLayout()).columnWeights = new double[] {0.0, 0.0, 1.0E-4};
                    ((GridBagLayout)panel5.getLayout()).rowWeights = new double[] {0.0, 0.0, 1.0E-4};

                    //---- LButton ----
                    LButton.setText("\u62c9\u683c\u6717\u65e5\u63d2\u503c");
                    LButton.addActionListener(e -> {
                        try {
                            LButtonActionListener(e);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    });
                    panel5.add(LButton, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 5), 0, 0));

                    //---- LTextField ----
                    LTextField.setEditable(false);
                    panel5.add(LTextField, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 5, 0), 0, 0));

                    //---- NButton ----
                    NButton.setText("\u725b\u987f\u63d2\u503c");
                    NButton.addActionListener(e -> {
                        try {
                            NButtonActionListener(e);
                        } catch (IOException ioException) {
                            ioException.printStackTrace();
                        }
                    });
                    panel5.add(NButton, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 5), 0, 0));

                    //---- NTextField ----
                    NTextField.setEditable(false);
                    panel5.add(NTextField, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
                        GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                        new Insets(0, 0, 0, 0), 0, 0));
                }
                contentPanel.add(panel5, new GridBagConstraints(0, 4, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.VERTICAL,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setSize(420,410);
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private void checkFxBoxActionListener(ActionEvent e) {
        for (JTextField jTextField:
             textY) {
            jTextField.setEditable(!checkFxBox.isSelected());
        }
    }

    private void NButtonActionListener(ActionEvent e) throws IOException {
        InterpolationAndApproximation.Interpolation interpolation = new InterpolationAndApproximation.Interpolation(x,y,level);
        ui.getOutputArea().append(interpolation.NewTownInterpolate());
        NTextField.setText(interpolation.simpleExpr.replaceAll("\\*\\*","\\^"));
    }

    private void LButtonActionListener(ActionEvent e) throws IOException {
        InterpolationAndApproximation.Interpolation interpolation = new InterpolationAndApproximation.Interpolation(x,y,level);
        interpolation.NewTownInterpolate();
        LTextField.setText(interpolation.simpleExpr.replaceAll("\\*\\*","\\^"));
    }

    private void editLevelButtonActionListener(ActionEvent e) {
        if(Integer.parseInt(levelSpinner.getValue().toString())==level){
            return;
        }
        initInputPanel();
    }

    private void confirmLevelButtonActionLister(ActionEvent e) {
        initText();
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JPanel functionPanel;
    private JLabel fx;
    private JTextField functionText;
    private JButton editFunctionButton;
    private JPanel levelPanel;
    private JLabel levelLabel;
    private JSpinner levelSpinner;
    private JButton editLevelButton;
    private JCheckBox checkFxBox;
    private JPanel inputPanel;
    private ArrayList<JLabel> labelX;
    private ArrayList<JLabel> labelY;
    private ArrayList<JTextField> textX;
    private ArrayList<JTextField> textY;
    private JButton confrimLevelButton;
    private JPanel panel5;
    private JButton LButton;
    private JTextField LTextField;
    private JButton NButton;
    private JTextField NTextField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public String name;
    private UI ui;
    private Function_UI function_ui;
    private int level;
    public List<Double> x;
    public List<Double> y;
}
