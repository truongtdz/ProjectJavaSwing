import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class InterfaceMenu {
    static DefaultTableModel model = new DefaultTableModel();
    private boolean trangThai = false;
    public void InterfaceProject(){
        JFrame frame = new JFrame();
        frame.setSize(800, 500);
        frame.setTitle("Project Student Management");
        
        JLabel jLB = new JLabel("This is project of Tran Duc Truong");
        frame.add(jLB);
        jLB.setHorizontalAlignment(0);
        jLB.setBounds(200, 430, 400, 20);
        jLB.setFont( new Font("Arial", Font.PLAIN, 20));

        JLabel jLB1 = new JLabel("Student List");frame.add(jLB1);
        jLB1.setHorizontalAlignment(0);
        jLB1.setBounds(0, 10, 294, 20);
        jLB1.setFont( new Font("Arial", Font.PLAIN, 20));

        JButton jBT0 = new JButton("Menu Selection");frame.add(jBT0); 
        jBT0.setHorizontalAlignment(0);
        jBT0.setBounds(550, 10, 200, 30);
        jBT0.setFont( new Font("Arial", Font.PLAIN, 20)); 
        
        JButton jBT1 = new JButton("Add Student");frame.add(jBT1);
        jBT1.setBounds(580, 70, 170, 30);
        jBT1.setVisible(false);
        
        JButton jBT2 = new JButton("Update Student");frame.add(jBT2);
        jBT2.setBounds(580, 130, 170, 30); 
        jBT2.setVisible(false);

        JButton jBT3 = new JButton("Sort Student");frame.add(jBT3);
        jBT3.setBounds(580, 190, 170, 30);
        jBT3.setVisible(false);

        JButton jBT4 = new JButton("Search Student");frame.add(jBT4);
        jBT4.setBounds(580, 250, 170, 30);
        jBT4.setVisible(false);

        JButton jBT5 = new JButton("Delete Student");frame.add(jBT5);
        jBT5.setBounds(580, 310, 170, 30);
        jBT5.setVisible(false);

        JButton jBT6 = new JButton("Exit");frame.add(jBT6);
        jBT6.setBounds(650, 380, 100, 30);

        // Table Print Infor Student
        model.addColumn("ID");
        model.addColumn("Tên");
        model.addColumn("Tuổi");
        model.addColumn("GPA");
        model.addColumn("Đường");
        model.addColumn("Quận/Huyện");
        model.addColumn("Ngành");
        model.addColumn("SĐT");
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        scrollPane.setBounds(20, 80, 500, 300);
        UpdateList("");

        // Click Menu Selection
        jBT0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trangThai = !trangThai;
                jBT1.setVisible(trangThai);
                jBT2.setVisible(trangThai);
                jBT3.setVisible(trangThai);
                jBT4.setVisible(trangThai);
                jBT5.setVisible(trangThai);
            }  
        });

        // Click Add Student
        jBT1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InterfaceAddStudent();
            }  
        });

        // Click Update Student
        jBT2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InterfaceUpdateStudent();
            }  
        });

         // Click Sort Student
         jBT3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InterfaceSortStudent();
            }  
        });

        // Click Exit Menu
        jBT6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void UpdateList(String s){
        model.setRowCount(0);
        try (Connection conn = ConnectionDataBase.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM student" + s)) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getDouble("gpa"),
                    rs.getString("street"),
                    rs.getString("district"),
                    rs.getString("major"),
                    rs.getString("phone")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
