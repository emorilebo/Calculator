import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CGPA_calculator extends JFrame {
    private JTextField displayName;
    private JLabel nameL;

    private JTextField displayRegNo;
    private JLabel regL;

    private JTextField course;
    private JLabel courseL;

    private JTextField test;
    private JLabel testL;

    private JTextField exam;
    private JLabel examL;

    private JTextField displayCourseUnit;
    private JLabel courseUnitL;

    private JTextField displayField;
    private JLabel totalL;

    private JTextField displayGradePoint;
    private JLabel gradePointL;

    private JTextField displayGrade;
    private JLabel gradeL;

    private JTextField displayCourseOffer;
    private JLabel coursesOffer = new JLabel();

    private JTextField displayNumSemester;
    private JLabel numSemesterL;

    private JTextField displayCourseGp;
    private JLabel courseGpL;

    private JTextField displayGp;
    private JLabel gpL;

    private JTextField displayErro = new JTextField(15);

    private JPanel panel = new JPanel();
    private JPanel buttonPanel = new JPanel();
    private JPanel namePanel = new JPanel(new GridLayout(2, 1));


    public CGPA_calculator() {

        namePanel.add(nameL = new JLabel("Department:"));
        namePanel.add(displayName = new JTextField(2));

        namePanel.add(regL = new JLabel("Registration Number"));
        namePanel.add(displayRegNo = new JTextField(2));

        buttonPanel.add(coursesOffer = new JLabel("Number of register Courses:"));
        buttonPanel.add(displayCourseOffer = new JTextField(2));

        JButton button = new JButton("Calc CGPA");
        button.setBackground(Color.cyan);
        buttonPanel.add(button);

        buttonPanel.add(numSemesterL = new JLabel("Number of Semester:"));
        buttonPanel.add(displayNumSemester = new JTextField(2));
        buttonPanel.add(displayErro);

        panel.add(courseL = new JLabel("Course:"));
        panel.add(course = new JTextField(5));

        panel.add(testL = new JLabel("Test:"));
        panel.add(test = new JTextField(2));

        panel.add(examL = new JLabel("Exam:"));
        panel.add(exam = new JTextField(2));

        panel.add(courseUnitL = new JLabel("Course Unit: "));
        panel.add(displayCourseUnit = new JTextField(2));

        panel.add(totalL = new JLabel("Total Scores: "));
        panel.add(displayField = new JTextField(2));
        displayField.setEditable(false);

        panel.add(gradeL = new JLabel("Grade:"));
        panel.add(displayGrade = new JTextField(2));
        displayGrade.setEditable(false);

        panel.add(gradePointL = new JLabel("Grade Point:"));
        panel.add(displayGradePoint = new JTextField(2));
        displayGradePoint.setEditable(false);

        panel.add(courseGpL = new JLabel("Course GP:"));
        panel.add(displayCourseGp = new JTextField(5));
        displayCourseGp.setEditable(false);

        panel.add(gpL = new JLabel("GP"));
        panel.add(displayGp = new JTextField(5));
        displayGp.setEditable(false);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int test1 = Integer.parseInt(test.getText());
                int exam1 = Integer.parseInt(exam.getText());
                int totalScore = test1 + exam1;
                displayField.setText(String.valueOf(totalScore));

                if (totalScore >= 70 && totalScore <= 100) {
                    displayGrade.setText("A");
                    displayGradePoint.setText(Integer.toString(gradePoint_A));
                } else if (totalScore >= 60 && totalScore <= 69) {
                    displayGrade.setText("B");
                    displayGradePoint.setText(Integer.toString(gradePoint_B));
                } else if (totalScore >= 50 && totalScore <= 59) {
                    displayGrade.setText("C");
                    displayGradePoint.setText(Integer.toString(gradePoint_C));
                } else if (totalScore >= 45 && totalScore <= 49) {
                    displayGrade.setText("D");
                    displayGradePoint.setText(Integer.toString(gradePoint_D));
                } else if (totalScore >= 0 && totalScore < 45) {
                    displayGrade.setText("F");
                    displayGradePoint.setText(Integer.toString(gradePoint_F));
                } else {
                    displayErro.setText("Total score out of Range");
                }
                double courseUnit = Integer.parseInt(displayCourseUnit.getText());
                double gradePoint = Integer.parseInt(displayGradePoint.getText());
                double numOfCourse = Integer.parseInt(displayCourseOffer.getText());
                double totalCourseUnit = 0;
                for (int counter = 1; counter <= numOfCourse; counter++) {
                    totalCourseUnit += courseUnit;
                }
                double courseGp = courseUnit * gradePoint / totalCourseUnit;
                displayCourseGp.setText(Double.toString(courseGp));

                double gp = 0.0;
                for (int counter = 1; counter <= numOfCourse; counter++) {
                    gp += courseGp;
                }
                displayGp.setText(Double.toString(gp));
            }
        });
        add(buttonPanel, BorderLayout.SOUTH);
        add(panel, BorderLayout.WEST);
        add(namePanel, BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();
        setLocationRelativeTo(null);
        setTitle("CGPA CALCULATOR");
    }

    public static void main(String[] args) {
        CGPA_calculator cg = new CGPA_calculator();
    }

    private final int gradePoint_A = 5;
    private final int gradePoint_B = 4;
    private final int gradePoint_C = 3;
    private final int gradePoint_D = 2;
    private final int gradePoint_F = 0;
}

