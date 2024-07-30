import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MenuProject{
    private static ArrayList<Student> list = new ArrayList<>();
    private JTable table;
    private DefaultTableModel tableModel;
    private boolean trangThai = false;

    public static void main(String[] args){
        new MenuProject().InterfaceProject();
    }
        // Giao Dien 
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

        JLabel jLB2 = new JLabel("Menu Selection");frame.add(jLB2); 
        jLB2.setHorizontalAlignment(0);
        jLB2.setBounds(425, 10, 335, 20);
        jLB2.setFont( new Font("Arial", Font.PLAIN, 20));

        String[] columnNames = {"MaSV", "Name", "Class", "Gpa"};
        tableModel = new DefaultTableModel(columnNames, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);
        scrollPane.setBounds(10, 50, 390, 300);     
        
        JButton jBT1 = new JButton("Add Student");frame.add(jBT1);
        jBT1.setBounds(125, 370, 160, 30);
        
        JButton jBT2 = new JButton("Sort");frame.add(jBT2);
        jBT2.setBounds(430, 60, 100, 30); 
        
        JButton jBT3 = new JButton("Search");frame.add(jBT3);
        jBT3.setBounds(545, 60, 100, 30);
        
        JButton jBT4 = new JButton("Delete");frame.add(jBT4);
        jBT4.setBounds(660, 60, 100, 30);

        JButton jBT21 = new JButton("Sort by Name"); frame.add(jBT21);
        jBT21.setBounds(430, 115, 150, 25);
        jBT21.setVisible(false);

        JButton jBT22 = new JButton("Sort by Gpa"); frame.add(jBT22);
        jBT22.setBounds(430, 155, 150, 25);
        jBT22.setVisible(false);

        JButton jBT31 = new JButton("Search by Name"); frame.add(jBT31);
        jBT31.setBounds(520, 115, 150, 25);
        jBT31.setVisible(false);

        // JButton jBT32 = new JButton("Search by Gpa"); frame.add(jBT32);
        // jBT32.setBounds(520, 155, 150, 25);
        // jBT32.setVisible(false);

        JButton jBT41 = new JButton("Delete by Name"); frame.add(jBT41);
        jBT41.setBounds(610, 115, 150, 25);
        jBT41.setVisible(false);

        JButton jBT42 = new JButton("Delete by MaSV"); frame.add(jBT42);
        jBT42.setBounds(610, 155, 150, 25);
        jBT42.setVisible(false);

        // Xu Ly Khi Click Add
        jBT1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InterfaceAddStudent(list, MenuProject.this);
            }
        });

        // Xu Ly khi Click Sort
        jBT2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trangThai = !trangThai;
                jBT21.setVisible(trangThai);
                jBT22.setVisible(trangThai);
            }
            
        });
        
        //Xu Ly Khi Click Search
        jBT3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trangThai = !trangThai;
                jBT31.setVisible(trangThai);
                //jBT32.setVisible(trangThai);
            }
        });

        //Xu Ly Khi Click Delete
        jBT4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trangThai = !trangThai;
                jBT41.setVisible(trangThai);
                jBT42.setVisible(trangThai);
            }
            
        });

        // Xu Ly Khi Click Sort By Name
        jBT21.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(list, new Comparator<Student>() {
                    public int compare(Student s1, Student s2){
                        String[] arr1 = s1.getName().split("\\s+");
                        String[] arr2 = s2.getName().split("\\s+");
                        String firstName1 = "";
                        String firstName2 = "";
                        if(!arr1[arr1.length - 1].equals(arr2[arr2.length - 1])){
                            return arr1[arr1.length - 1].compareTo(arr2[arr2.length - 1]);
                        } else {
                            for(int i = 0; i < arr1.length - 1; i++){
                                firstName1 += arr1[i];
                            }
                            for(int i = 0; i < arr2.length - 1; i++){
                                firstName2 += arr2[i];
                            } 
                            return firstName1.compareTo(firstName2);
                        } 
                    }
                });
                updateStudentList(list);
            }
        });

        //Xu Ly Khi Click Sort by Gpa
        jBT22.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Collections.sort(list, new Comparator<Student>() {
                    public int compare(Student s1, Student s2){
                        if(s1.getGpa() < s2.getGpa()){
                            return -1;
                        } else return 1;
                    }
                });
                updateStudentList(list);
            }     
        });

        //Xu Ly Khi Click Search by Name
        jBT31.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InterfaceEnterNameSearch(list);
            }
            
        });

        //Xu Ly Khi Click Delete by Name
        jBT41.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new InterfaceEnterNameDelete(list, MenuProject.this);
            }     
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }
        
    public void updateStudentList(ArrayList<Student> list) {
        tableModel.setRowCount(0);
        for (Student s : list) {
            tableModel.addRow(new Object[]{s.getMaSV(), s.getName(), s.getClassName(), s.getGpa()});
        }
    }
}
