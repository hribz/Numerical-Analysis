/*
 * Created by JFormDesigner on Thu Jun 03 17:05:09 CST 2021
 */

package UI;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import javax.swing.tree.*;

import com.intellij.uiDesigner.core.*;
import mathElements.Function;
import mathElements.Matrix;

/**
 * @author Brainrain
 */
public class UI extends JFrame {
    public UI(String name) {
        super(name);
        initComponents();
        initTreeComponents();
    }

    public UI() {
        initComponents();
        initTreeComponents();
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
        addFunction.setUi(this);
    }

    private void elementsClickedEvent(MouseEvent e) {
        // TODO add your code here
        TreePath selPath = elementsList.getPathForLocation(e.getX(),e.getY());
        if(selPath==null){
            return;
        }
        DefaultMutableTreeNode node = (DefaultMutableTreeNode)selPath.getLastPathComponent();
        if(node.getParent()==null){
            return;
        }else if(!node.getParent().equals(root)){
            String type=node.getUserObject().toString();
            String parentName = node.getParent().toString();
            switch (type){
                case "线性方程求解":
                    SolEquation sol_ui = SolListMethods.get(parentName);
                    sol_ui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    sol_ui.pack();
                    sol_ui.initComboBox();
                    sol_ui.setVisible(true);
                    break;
                case "求根":
                    Iterative_UI iterative_ui = IterativeListMethods.get(parentName);
                    iterative_ui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    iterative_ui.pack();
                    iterative_ui.setVisible(true);
                    iterative_ui.init();
                    break;
                case "插值拟合":
                    Interpolation interpolation = InterpolateListMethods.get(parentName);
                    interpolation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    interpolation.pack();
                    interpolation.setVisible(true);
                    break;
                default:

            }
        }else {
            String name=node.toString();
            if(MatrixListElements.containsKey(name)){
                Matrix_UI matrix_ui = MatrixListElements.get(name);
                matrix_ui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                matrix_ui.pack();
                matrix_ui.initComboBox();
                matrix_ui.setVisible(true);
            }else {
                Function_UI function_ui = FunctionListElements.get(name);
                function_ui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                function_ui.pack();
                function_ui.setVisible(true);
                function_ui.getFuntion().setText(function_ui.getFunction().expr);
            }
        }
    }

    private void initTreeComponents(){
        //---- elementsList ----
        scrollPane1.remove(elementsList);
        treeModel=new DefaultTreeModel(root);
        treeModel.addTreeModelListener(new MyTreeModelListener());
        elementsList = new JTree(treeModel);

        elementsList.getSelectionModel().setSelectionMode
                (TreeSelectionModel.SINGLE_TREE_SELECTION);
        elementsList.setShowsRootHandles(true);
        elementsList.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));

        ToolTipManager.sharedInstance().registerComponent(elementsList);

        ImageIcon RootIcon = new ImageIcon("icon\\root.png");
        ImageIcon ElementIcon = new ImageIcon("icon\\elements.png");
        ImageIcon LeafIcon = new ImageIcon("icon\\method.png");
        elementsList.setCellRenderer(new MyRenderer(RootIcon,ElementIcon,LeafIcon));
        elementsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount()==2){
                    elementsClickedEvent(e);
                }
            }
        });
        elementsList.setToggleClickCount(0);

        scrollPane1.setViewportView(elementsList);
    }

    /**
     *
     * @param top 在top节点下创建新的节点
     * @param name 节点的名称
     * @param type 节点种类
     */
    public void createNodes(DefaultMutableTreeNode top, String name, String type) {
        DefaultMutableTreeNode element = null;
        List<DefaultMutableTreeNode> methods = new ArrayList<>();

        element = new DefaultMutableTreeNode(name);

        treeModel.insertNodeInto(element,top,top.getChildCount());
        try{
            if (type.equals("Function")) {
                methods.add(new DefaultMutableTreeNode("求根"));
                methods.add(new DefaultMutableTreeNode("插值拟合"));
            } else if (type.equals("Matrix")) {
                Matrix temp_matrix = MatrixListElements.get(name).getMatrix();
                if(temp_matrix.m==temp_matrix.n){
                    methods.add(new DefaultMutableTreeNode("线性方程求解"));
                }
            } else {
                throw new Exception();
            }
        }catch (Exception err){
            JOptionPane.showMessageDialog(null,"元素类型错误");
        }
        for (DefaultMutableTreeNode method :
                methods) {
            addObject(element,method,true);
        }
        elementsList.scrollPathToVisible(new TreePath(element.getPath()));
        scrollPane1.repaint();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        rootPanel = new JPanel();
        operation = new JPanel();
        scrollPane1 = new JScrollPane();
        elementsList = new JTree();
        picture = new JPanel();
        scrollPane2 = new JScrollPane();
        outputArea = new JTextArea();
        menuBar1 = new JMenuBar();
        addMatrix = new JMenu();
        addFunction = new JMenu();
        help = new JMenu();
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
                    scrollPane1.setPreferredSize(new Dimension(200, 502));

                    //---- elementsList ----
                    elementsList.setVisibleRowCount(25);
                    elementsList.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 12));
                    scrollPane1.setViewportView(elementsList);
                }
                operation.add(scrollPane1);

                //======== picture ========
                {
                    picture.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));

                    //======== scrollPane2 ========
                    {

                        //---- outputArea ----
                        outputArea.setRequestFocusEnabled(false);
                        outputArea.setFocusable(false);
                        outputArea.setEditable(false);
                        scrollPane2.setViewportView(outputArea);
                    }
                    picture.add(scrollPane2, new GridConstraints(0, 0, 1, 1,
                        GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW,
                        null, null, null));
                }
                operation.add(picture);
            }
            rootPanel.add(operation, BorderLayout.CENTER);

            //======== menuBar1 ========
            {
                menuBar1.setBorder(UIManager.getBorder("MenuBar.border"));

                //======== addMatrix ========
                {
                    addMatrix.setText("\u65b0\u5efa\u77e9\u9635");
                    addMatrix.setIcon(new ImageIcon("C:\\Users\\Hershey\\Pictures\\ICON\\icon_\u77e9\u9635\u586b\u7a7a.png"));
                    addMatrix.setBorder(UIManager.getBorder("DesktopIcon.border"));
                    addMatrix.setDisabledIcon(null);
                    addMatrix.setDisabledSelectedIcon(null);
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
                    addFunction.setIcon(new ImageIcon("D:\\JavaProject\\Numerical-Analysis\\icon\\function png icon.png"));
                    addFunction.setBorder(UIManager.getBorder("DesktopIcon.border"));
                    addFunction.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            addFunctionMouseClicked(e);
                        }
                    });
                }
                menuBar1.add(addFunction);

                //======== help ========
                {
                    help.setText("\u8bf4\u660e");
                    help.setIcon(new ImageIcon("D:\\JavaProject\\Numerical-Analysis\\icon\\help png icon.png"));
                    help.setBorder(UIManager.getBorder("DesktopIcon.border"));
                }
                menuBar1.add(help);
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
    private JTree elementsList;
    private JPanel picture;
    private JScrollPane scrollPane2;
    private JTextArea outputArea;
    private JMenuBar menuBar1;
    private JMenu addMatrix;
    private JMenu addFunction;
    private JMenu help;
    private JPanel buttonBar;
    private JButton okButton;
    private JButton cancelButton;
    private JButton helpButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    private DefaultTreeModel treeModel;
    private Map<String, Matrix_UI> MatrixListElements = new HashMap<>();
    private Map<String, Function_UI> FunctionListElements = new HashMap<>();
    private Map<String, SolEquation> SolListMethods = new HashMap<>();
    private Map<String, Interpolation> InterpolateListMethods = new HashMap<>();
    private Map<String, Iterative_UI> IterativeListMethods = new HashMap<>();
    private final DefaultMutableTreeNode root = new DefaultMutableTreeNode("矩阵和函数");

    public JTextArea getOutputArea() {
        return outputArea;
    }

    public Map<String, Interpolation> getInterpolateListMethods() {
        return InterpolateListMethods;
    }

    public Map<String, Iterative_UI> getIterativeListMethods() {
        return IterativeListMethods;
    }

    public Map<String, SolEquation> getSolListMethods() {
        return SolListMethods;
    }

    public DefaultMutableTreeNode getRoot() {
        return root;
    }

    public Map<String, Matrix_UI> getMatrixListElements() {
        return MatrixListElements;
    }

    public void setMatrixListElements(Map<String, Matrix_UI> matrixListElements) {
        this.MatrixListElements = matrixListElements;
    }

    public JTree getElementsList() {
        return elementsList;
    }

    public Map<String, Function_UI> getFunctionListElements() {
        return FunctionListElements;
    }

    public void setFunctionListElements(Map<String, Function_UI> functionListElements) {
        FunctionListElements = functionListElements;
    }

    class MyTreeModelListener implements TreeModelListener {
        public void treeNodesChanged(TreeModelEvent e) {
            DefaultMutableTreeNode node;
            node = (DefaultMutableTreeNode)
                    (e.getTreePath().getLastPathComponent());

            try {
                int index = e.getChildIndices()[0];
                node = (DefaultMutableTreeNode)
                        (node.getChildAt(index));
            } catch (NullPointerException exc) {}

            System.out.println("The user has finished editing the node.");
            System.out.println("New value: " + node.getUserObject());
        }
        public void treeNodesInserted(TreeModelEvent e) {
        }
        public void treeNodesRemoved(TreeModelEvent e) {
        }
        public void treeStructureChanged(TreeModelEvent e) {
        }
    }

    public DefaultMutableTreeNode addObject(Object child) {
        DefaultMutableTreeNode parentNode = null;
        TreePath parentPath = elementsList.getSelectionPath();

        if (parentPath == null) {
            //There is no selection. Default to the root node.
            parentNode = root;
        } else {
            parentNode = (DefaultMutableTreeNode)
                    (parentPath.getLastPathComponent());
        }

        return addObject(parentNode, child, true);
    }

    public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
                                            Object child,
                                            boolean shouldBeVisible) {
        DefaultMutableTreeNode childNode =
                new DefaultMutableTreeNode(child);

        treeModel.insertNodeInto(childNode, parent,
                parent.getChildCount());

        //Make sure the user can see the lovely new node.
        if (shouldBeVisible) {
            elementsList.scrollPathToVisible(new TreePath(childNode.getParent()));
        }
        return childNode;
    }

    class MyRenderer extends DefaultTreeCellRenderer {
        Icon RootIcon;
        Icon ElementIcon;
        Icon LeafIcon;

        public MyRenderer(Icon rootIcon, Icon elementIcon, Icon leafIcon) {
            RootIcon = rootIcon;
            ElementIcon = elementIcon;
            LeafIcon = leafIcon;

        }

        public Component getTreeCellRendererComponent(
                JTree tree,
                Object value,
                boolean sel,
                boolean expanded,
                boolean leaf,
                int row,
                boolean hasFocus) {

            super.getTreeCellRendererComponent(
                    tree, value, sel,
                    expanded, leaf, row,
                    hasFocus);
            if (isRoot(value)){
                setIcon(RootIcon);
            } else if (leaf && isMethod(value)) {
                setIcon(LeafIcon);
//                setToolTipText("This book is in the Tutorial series.");
            } else{
                if(MatrixListElements.containsKey((String)(((DefaultMutableTreeNode)value).getUserObject()))){
                    setToolTipText("双击编辑矩阵或计算");
                }else{
                    setToolTipText("双击编辑函数或计算");
                }
                setIcon(ElementIcon);
            }

            return this;
        }

        protected boolean isMethod(Object value) {
            DefaultMutableTreeNode node =
                    (DefaultMutableTreeNode)value;
            return !node.getParent().equals(root);
        }

        protected boolean isRoot(Object value) {
            DefaultMutableTreeNode node =
                    (DefaultMutableTreeNode)value;
            return node.getParent() == null;
        }
    }
}
