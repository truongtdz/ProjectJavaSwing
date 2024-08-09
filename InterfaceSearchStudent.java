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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InterfaceSearchStudent {
    public InterfaceSearchStudent()
    {
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.setTitle("Search Student");
        frame.setLayout(null);

        JLabel jLB0 = new JLabel("Enter Information Student"); frame.add(jLB0);
        jLB0.setBounds(150, 20, 300, 30);
        jLB0.setFont( new Font("Arial", Font.PLAIN, 20));
        jLB0.setHorizontalAlignment(0);

        JLabel jLB1 = new JLabel("Name : "); frame.add(jLB1);
        jLB1.setBounds(50, 70, 70, 20);
        
        JLabel jLB2 = new JLabel("Major : "); frame.add(jLB2);
        jLB2.setBounds(200, 70, 70, 20);
        
        JLabel jLB3 = new JLabel("Phone: "); frame.add(jLB3);
        jLB3.setBounds(350, 70, 70, 20);
        
        JLabel jLB4 = new JLabel("Street: "); frame.add(jLB4);
        jLB4.setBounds(50, 120, 70, 20);

        JLabel jLB5 = new JLabel("District: "); frame.add(jLB5);
        jLB5.setBounds(270, 120, 70, 20);
        
        JLabel jLB6 = new JLabel("AgeFrom : "); frame.add(jLB6);
        jLB6.setBounds(50, 170, 70, 20);
        
        JLabel jLB7 = new JLabel("AgeTo : "); frame.add(jLB7);
        jLB7.setBounds(160, 170, 70, 20);

        JLabel jLB8 = new JLabel("GpaFrom : "); frame.add(jLB8);
        jLB8.setBounds(260, 170, 70, 20);
        
        JLabel jLB9 = new JLabel("GpaTo : "); frame.add(jLB9);
        jLB9.setBounds(370, 170, 70, 20);
        
        JTextField jTF1 = new JTextField(); frame.add(jTF1);
        jTF1.setBounds(90, 70, 100, 20);
        
        JTextField jTF2 = new JTextField(); frame.add(jTF2);
        jTF2.setBounds(240, 70, 100, 20);
        
        JTextField jTF3 = new JTextField(); frame.add(jTF3);
        jTF3.setBounds(390, 70, 100, 20);
        
        JTextField jTF4 = new JTextField(); frame.add(jTF4);
        jTF4.setBounds(90, 120, 150, 20);

        JTextField jTF5 = new JTextField(); frame.add(jTF5);
        jTF5.setBounds(320, 120, 150, 20);

        JTextField jTF6 = new JTextField(); frame.add(jTF6);
        jTF6.setBounds(110, 170, 40, 20);

        JTextField jTF7 = new JTextField(); frame.add(jTF7);
        jTF7.setBounds(210, 170, 40, 20);

        JTextField jTF8 = new JTextField(); frame.add(jTF8);
        jTF8.setBounds(320, 170, 40, 20);

        JTextField jTF9 = new JTextField(); frame.add(jTF9);
        jTF9.setBounds(420, 170, 40, 20);

        JButton jBT1 = new JButton("OK"); frame.add(jBT1);
        jBT1.setBounds(500, 100, 70,30);

        JButton jBT2 = new JButton("EXIT"); frame.add(jBT2);
        jBT2.setBounds(500, 150, 70, 20);

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Name");
        model.addColumn("Age");
        model.addColumn("GPA");
        model.addColumn("Street");
        model.addColumn("District");
        model.addColumn("Major");
        model.addColumn("Phone");
        JTable table = new JTable(model);
        JScrollPane jScrollPane = new JScrollPane(table);
        frame.add(jScrollPane);
        jScrollPane.setBounds(20, 200, 550, 150);

        // Click Ok
        jBT1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.setRowCount(0);
                StringBuilder sql = new StringBuilder("SELECT * FROM student WHERE 1 = 1 ");
                if(jTF1.getText() != null && !jTF1.getText().isEmpty()){
                    sql.append(" AND name like '%" + jTF1.getText() + "%'");
                }
                if(jTF2.getText() != null && !jTF2.getText().isEmpty()){
                    sql.append(" AND major like '%" + jTF2.getText() + "%'");
                }
                if(jTF3.getText() != null && !jTF3.getText().isEmpty()){
                    sql.append(" AND phone like '%" + jTF3.getText() + "%'");
                }
                if(jTF4.getText() != null && !jTF4.getText().isEmpty()){
                    sql.append(" AND street like '%" + jTF4.getText() + "%'");
                }
                if(jTF5.getText() != null && !jTF5.getText().isEmpty()){
                    sql.append(" AND district like '%" + jTF5.getText() + "%'");
                }
                if(jTF6.getText() != null && !jTF6.getText().isEmpty()){
                    try {
                        int ageFrom = Integer.parseInt(jTF6.getText());
                        sql.append(" AND age >= " + ageFrom);
                    } catch (NumberFormatException ex) {
                        new InterfaceInputError();
                    }
                }
                if(jTF7.getText() != null && !jTF7.getText().isEmpty()){
                    try {
                        int ageTo = Integer.parseInt(jTF7.getText());
                        sql.append(" AND age <= " + ageTo);
                    } catch (NumberFormatException ex) {
                        new InterfaceInputError();
                    }
                }
                if(jTF8.getText() != null && !jTF8.getText().isEmpty()){
                    try {
                        double gpaFrom = Double.parseDouble(jTF8.getText());
                        sql.append(" AND gpa > " + gpaFrom);
                    } catch (NumberFormatException ex) {
                        new InterfaceInputError();
                    }
                }
                if(jTF9.getText() != null && !jTF9.getText().isEmpty()){
                    try {
                        double gpaTo = Double.parseDouble(jTF9.getText());
                        sql.append(" AND gpa < " + gpaTo);
                    } catch (NumberFormatException ex) {
                        new InterfaceInputError();
                    }
                }
                try (Connection conn = ConnectionDataBase.getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql.toString())) {

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
                } catch (Exception ex) {
                    ex.printStackTrace();
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
 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
    }
}
