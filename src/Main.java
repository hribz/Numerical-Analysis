import UI.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        UI ui=new UI("Numerical Analysis");
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
        JOptionPane.showMessageDialog(null,"注意：本软件的函数功能需要配置安装了sympy包的python环境");
    }
}
