package 软件测试实验;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TriangleGUI extends JFrame implements ActionListener {
    // 创建文本框、按钮等组件
    private JTextField txtA, txtB, txtC;
    private JButton btnValidate, btnClear, btnExit;
    private JLabel lblResult;

    public TriangleGUI() {
        // 设置窗口标题和大小
        setTitle("三角形验证器");
        setSize(400, 200);

        // 创建组件
        txtA = new JTextField();
        txtB = new JTextField();
        txtC = new JTextField();
        btnValidate = new JButton("Validate");
        btnClear = new JButton("Clear");
        btnExit = new JButton("Exit");
        lblResult = new JLabel("");

        // 设置组件布局和位置
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("边长 A:"));
        inputPanel.add(txtA);
        inputPanel.add(new JLabel("边长 B:"));
        inputPanel.add(txtB);
        inputPanel.add(new JLabel("边长 C:"));
        inputPanel.add(txtC);
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(btnValidate);
        buttonPanel.add(btnClear);
        buttonPanel.add(btnExit);

        // 将组件添加到窗口中
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(inputPanel, BorderLayout.CENTER);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);
        contentPane.add(lblResult, BorderLayout.NORTH);

        // 添加事件监听器
        btnValidate.addActionListener(this);
        btnClear.addActionListener(this);
        btnExit.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        // 判断哪个按钮被点击了
        if (e.getSource() == btnValidate) {
            // 获取文本框中输入的数字
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double c = Double.parseDouble(txtC.getText());

            // 判断是否可以构成三角形
            if (a + b > c && a + c > b && b + c > a) {
                // 判断三角形类型
                if (a == b && b == c) {
                    lblResult.setText("这是一个等边三角形。");
                } else if (a == b || a == c || b == c) {
                    lblResult.setText("这是一个等腰三角形。");
                } else {
                    lblResult.setText("这是一个斜角三角形。");
                }
            } else {
                lblResult.setText("这些边不能形成三角形。");
            }
        } else if (e.getSource() == btnClear) {
            // 清空文本框和结果标签
            txtA.setText("");
            txtB.setText("");
            txtC.setText("");
            lblResult.setText("");
        } else if (e.getSource() == btnExit) {
            // 关闭窗口
            dispose();
        }
    }

    public static void main(String[] args) {
        // 创建并显示窗口
        TriangleGUI window = new TriangleGUI();
        window.setVisible(true);
    }
}
