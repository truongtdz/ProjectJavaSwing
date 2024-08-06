import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
public class InterfaceEnterNameSearch {
    public InterfaceEnterNameSearch(ArrayList<Student> list){
        JFrame frame = new JFrame();   
        frame.setTitle("Enter Name Search");
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        JLabel jLB1 = new JLabel("Enter Name Search"); frame.add(jLB1);
        jLB1.setBounds(50, 20, 200, 30);
        jLB1.setFont(new Font("Arial", Font.PLAIN, 20));
        jLB1.setHorizontalAlignment(0);
        
        JLabel jLB2 = new JLabel("Name : "); frame.add(jLB2);
        jLB2.setBounds(30, 70, 50, 20);

        JTextField jTF1 = new JTextField(); frame.add(jTF1);
        jTF1.setBounds(80, 70, 150, 20);

        JButton jBT1 = new JButton("Search"); frame.add(jBT1);
        jBT1.setBounds(95, 110, 100, 20);

        JLabel jLB3 = new JLabel("Not found !"); frame.add(jLB3);
        jLB3.setHorizontalAlignment(0);
        jLB3.setFont(new Font("Arial", Font.PLAIN, 20));
        jLB3.setBounds(50, 150, 200, 30);
        jLB3.setVisible(false);

        String[] columnNames = {"MaSV", "Name", "Class", "Gpa"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table); frame.add(scrollPane);
        scrollPane.setBounds(2, 150, 283, 200);
        scrollPane.setVisible(false);

        jBT1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameSearch = jTF1.getText();
                boolean resultSearch = false;
                for(int i = 0; i < list.size(); i++){
                    Student str = list.get(i);
                    String[] arr = str.getName().split("\\s+");
                    if(arr[arr.length - 1].equals(nameSearch)){
                        resultSearch = true;
                        tableModel.addRow(new Object[]{str.getMaSV(), str.getName(), str.getClassName(), str.getGpa()});
                    }                    
                }
                if(resultSearch){
                    scrollPane.setVisible(true);
                } else jLB3.setVisible(true);
                jBT1.setVisible(false);
            }  
        });
    }
}
