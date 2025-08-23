package 软件测试实验;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PhoneNumberValidator extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField phoneField, nameField, passwordField;
    private JButton validateButton;

    public PhoneNumberValidator() {
        super("电话号码验证器");

        // 设置窗口布局
        setLayout(new FlowLayout());

        // 添加电话号码输入框和标签
        add(new JLabel("      "));
        add(new JLabel("电话号码："));
        phoneField = new JTextField(10);
        add(phoneField);

        // 添加客户名称输入框和标签
        add(new JLabel("         "));
        add(new JLabel("     客户名称："));
        nameField = new JTextField(10);
        add(nameField);

        // 添加登录密码输入框和标签
        add(new JLabel("         "));
        add(new JLabel("         登录密码："));
        passwordField = new JTextField(10);
        add(passwordField);

        // 添加验证按钮和事件监听器
        add(new JLabel("         "));
        validateButton = new JButton("验证");
        add(validateButton);
        validateButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 获取电话号码输入值
                String phone = phoneField.getText();
                String message = "";
                if ("".equals(phone)){
                    message = "电话号码不能为空";
                }else {
                    // 定义电话号码正则表达式
                    Pattern pattern = Pattern.compile("^(\\+86)?1[3-9]\\d{9}$");
                    // 是否带区号
                    Pattern pattern2 = Pattern.compile("^(0[0-9]{2,3}/-)?([2-9][0-9]{6,7})+(/-[0-9]{1,4})?$");
                    Matcher matcher = pattern.matcher(phone);

                    if (matcher.matches()) {
                        message = "电话号码合格";
                    }else {
                        // 判断是否带区号
                        Matcher matcher2 = pattern2.matcher(phone);
                        if (matcher2.matches()) {
                            // 带区号合格
                            message = "电话号码合格";
                        }else {
                            // 显示验证结果
                            message = "当前输入的电话号码不合格。" +
                                    "电话号码规则:\n" +
                                    "1.电话号码应为数字\n" +
                                    "2.如带区号则在区号与号码中间插入-号\n" +
                                    "3.电话号码为8位数字,区号为4位数字\n";
                        }
                    }
                }
                JOptionPane.showMessageDialog(PhoneNumberValidator.this, message, "验证结果", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // 设置窗口大小和关闭操作
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        PhoneNumberValidator validator = new PhoneNumberValidator();
        validator.setVisible(true);
    }

}
