
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
public class InterfaceSortStudent{
    static String sql = "";
    //public static void main(String[] args)
    public InterfaceSortStudent()
    {
        JFrame frame = new JFrame();
        frame.setSize(200, 250);
        frame.setTitle("Selection Sort Student");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JButton jBT1 = new JButton("By Name"); frame.add(jBT1);
        jBT1.setBounds(45, 30, 100, 20);

        JButton jBT2 = new JButton("By Age"); frame.add(jBT2);
        jBT2.setBounds(45, 70, 100, 20);

        JButton jBT3 = new JButton("By Gpa"); frame.add(jBT3);
        jBT3.setBounds(45, 110, 100, 20);

        JButton jBT4 = new JButton("EXIT"); frame.add(jBT4);
        jBT4.setBounds(60, 160, 70, 20);

        // Click By Name
        jBT1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfaceMenu.UpdateList(" ORDER BY name ASC;");
                frame.dispose();
            }
        });

        // Click By Age
        jBT2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfaceMenu.UpdateList(" ORDER BY age ASC;");
                frame.dispose();
            }
        });

        // Click By Gpa
        jBT3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InterfaceMenu.UpdateList(" ORDER BY gpa ASC;");
                frame.dispose();
            }
        });
        // Click EXIT
        jBT4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        
    }
}
