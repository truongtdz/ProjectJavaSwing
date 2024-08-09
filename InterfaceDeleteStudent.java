import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
public class InterfaceDeleteStudent {
    //public static void main(String[] args)
    public InterfaceDeleteStudent()
    {
        JFrame frame = new JFrame();
        frame.setSize(300, 200);
        frame.setTitle("Enter Id Student");
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel jLB = new JLabel("Enter Id :"); frame.add(jLB);
        jLB.setBounds(70, 30, 100, 30);
        jLB.setHorizontalAlignment(0);
        jLB.setFont(new Font("Arial", Font.PLAIN, 20));

        JTextField jTF = new JTextField(); frame.add(jTF);
        jTF.setBounds(170, 30, 50, 30);


        JButton jBT1 = new JButton("OK"); frame.add(jBT1);
        jBT1.setBounds(170, 100, 70, 30);

        JButton jBT2 = new JButton("EXIT"); frame.add(jBT2);
        jBT2.setBounds(50, 100, 70, 30);

        //Xu ly khi click OK
        jBT1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sql = new StringBuilder("DELETE FROM Student WHERE id = ");
                Boolean status = true;
                try {
                    sql.append(Integer.parseInt(jTF.getText()));
                } catch (Exception ex) {
                    new InterfaceInputError();
                    status = false;
                }
                try(Connection con = ConnectionDataBase.getConnection();
                    Statement stmt = con.createStatement();) 
                {
                    stmt.executeUpdate(sql.toString());
                    con.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    status = false;
                }
                if(status){
                    InterfaceMenu.UpdateList("");
                    frame.dispose();
                }
            }
        });

        // When Click EXIT
        jBT2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });  
    }
}

