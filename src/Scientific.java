import javax.swing.*;

public class Scientific {
    public JPanel scientific;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Scientific");
        frame.setContentPane(new Scientific().scientific);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
