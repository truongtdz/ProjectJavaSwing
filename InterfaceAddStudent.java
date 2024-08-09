import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InterfaceAddStudent{
    //public static void main(String[] args)
    public InterfaceAddStudent()
    {
        JFrame frame = new JFrame();
        frame.setSize(400, 500);
        frame.setTitle("Add Student");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLabel jLB0 = new JLabel("Enter Information Student"); 
        frame.add(jLB0);
        jLB0.setFont( new Font("Arial", Font.PLAIN, 20));
        jLB0.setHorizontalAlignment(0);
        jLB0.setBounds(0, 0, 400, 20);
       
        JLabel jLB1 = new JLabel("Name : "); frame.add(jLB1);
        jLB1.setBounds(70, 50, 70, 20);
        
        JLabel jLB2 = new JLabel("Age : "); frame.add(jLB2);
        jLB2.setBounds(70, 90, 70, 20);
        
        JLabel jLB3 = new JLabel("Street : "); frame.add(jLB3);
        jLB3.setBounds(70, 130, 70, 20);
        
        JLabel jLB4 = new JLabel("District : "); frame.add(jLB4);
        jLB4.setBounds(70, 170, 70, 20);

        JLabel jLB5 = new JLabel("Major : "); frame.add(jLB5);
        jLB5.setBounds(70, 210, 70, 20);
        
        JLabel jLB6 = new JLabel("Phone : "); frame.add(jLB6);
        jLB6.setBounds(70, 250, 70, 20);
        
        JLabel jLB7 = new JLabel("Gpa : "); frame.add(jLB7);
        jLB7.setBounds(70, 290, 70, 20);
        
        JTextField jTF1 = new JTextField(); frame.add(jTF1);
        jTF1.setBounds(120, 50, 170, 20);
        
        JTextField jTF2 = new JTextField(); frame.add(jTF2);
        jTF2.setBounds(120, 90, 170, 20);
        
        JTextField jTF3 = new JTextField(); frame.add(jTF3);
        jTF3.setBounds(120, 130, 170, 20);
        
        JTextField jTF4 = new JTextField(); frame.add(jTF4);
        jTF4.setBounds(120, 170, 170, 20);

        JTextField jTF5 = new JTextField(); frame.add(jTF5);
        jTF5.setBounds(120, 210, 170, 20);

        JTextField jTF6 = new JTextField(); frame.add(jTF6);
        jTF6.setBounds(120, 250, 170, 20);

        JTextField jTF7 = new JTextField(); frame.add(jTF7);
        jTF7.setBounds(120, 290, 170, 20);
 
        JButton jBT1 = new JButton("ADD"); frame.add(jBT1);
        jBT1.setBounds(150, 350, 100, 20);

        JButton jBT2 = new JButton("EXIT"); frame.add(jBT2);
        jBT2.setBounds(160, 410, 80, 20);

        // When Click ADD
        jBT1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder sql = new StringBuilder("INSERT INTO student (name, age, street, district, major, phone, gpa)" );
                sql.append(" VALUES");
                boolean statusInterface = true;
                // Kiểm tra xem người dùng có nhập thiếu thông tin không
                if(!checkInfor(jTF1) || !checkInfor(jTF2) || !checkInfor(jTF3) ||
                !checkInfor(jTF4) || !checkInfor(jTF5) || !checkInfor(jTF6) || !checkInfor(jTF7)){
                    new InterfaceInputMissing(); // Nếu thiếu hiển thị màn hình yêu cầu nhập đủ
                    statusInterface = false; 
                }

                if(statusInterface){
                    // Kiểm tra người dùng có nhập sai age và gpa không
                    try {
                        String name = jTF1.getText().toString();
                        int age = Integer.parseInt(jTF2.getText());
                        String street = jTF3.getText();
                        String district = jTF4.getText();
                        String major = jTF5.getText(); 
                        String phone = jTF6.getText();
                        double gpa = Double.parseDouble(jTF7.getText());
                        // Câu lệnh thêm dữ liệu cho Bảng
                        sql.append("('" + name + "', " + age + ",'" + street + "','" + district 
                                    + "','" + major + "','" + phone + "', " + gpa + ")");
                    } catch (NumberFormatException ex) {
                        new InterfaceInputError(); // Nếu nhập k đúng thì yêu cầu nhập đúng số nguyên và số thực
                        statusInterface = false;
                    } 
                }
              
                if(statusInterface){
                    try(Connection con = ConnectionDataBase.getConnection();
                        Statement stmt = con.createStatement();
                        ){
                            stmt.executeUpdate(sql.toString());
                            con.close();
                        } catch(Exception ex){
                            ex.printStackTrace();
                        }
                    InterfaceMenu.UpdateList();
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

    // Hàm check user có nhập k đủ thông tin không
    public static boolean checkInfor(JTextField jTF){
        if(jTF.getText() == null || jTF.getText().equals("")){
            return false;
        }
        return true;
    }
}
