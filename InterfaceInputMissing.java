import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class InterfaceInputMissing {
    //public static void main(String[] args)
    public InterfaceInputMissing()
    {
        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setTitle("Error Enter Missing InforMation");
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel jLB1 = new JLabel("Error Enter Full Information"); frame.add(jLB1);
        jLB1.setBounds(0, 30, 280, 30);
        jLB1.setHorizontalAlignment(0);
        jLB1.setFont(new Font("Arial", Font.PLAIN, 20));

        JButton jBT1 = new JButton("OK"); frame.add(jBT1);
        jBT1.setBounds(115, 100, 60, 30);

        //Xu ly khi click OK
        jBT1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
            
        });
    }
}
