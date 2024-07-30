import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InterfaceAddStudent{
    public InterfaceAddStudent(ArrayList<Student> list, MenuProject menu){
        JFrame frame = new JFrame();
        frame.setSize(400, 500);
        frame.setTitle("Enter Information Student");
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);


        JLabel jLB1 = new JLabel("Enter Information Student"); 
        frame.add(jLB1);
        jLB1.setFont( new Font("Arial", Font.PLAIN, 20));
        jLB1.setHorizontalAlignment(0);
        jLB1.setBounds(0, 0, 400, 20);
       
        JLabel jLB2 = new JLabel("MaSV : "); frame.add(jLB2);
        jLB2.setBounds(70, 50, 70, 20);
        
        JLabel jLB3 = new JLabel("Name : "); frame.add(jLB3);
        jLB3.setBounds(70, 80, 70, 20);
        
        JLabel jLB4 = new JLabel("Class : "); frame.add(jLB4);
        jLB4.setBounds(70, 110, 70, 20);
        
        JLabel jLB5 = new JLabel("Gpa : "); frame.add(jLB5);
        jLB5.setBounds(70, 140, 70, 20);
        
        JTextField jTF1 = new JTextField(); frame.add(jTF1);
        jTF1.setBounds(120, 50, 170, 20);
        
        JTextField jTF2 = new JTextField(); frame.add(jTF2);
        jTF2.setBounds(120, 80, 170, 20);
        
        JTextField jTF3 = new JTextField(); frame.add(jTF3);
        jTF3.setBounds(120, 110, 170, 20);
        
        JTextField jTF4 = new JTextField(); frame.add(jTF4);
        jTF4.setBounds(120, 140, 170, 20);

        JTextField jTF5 = new JTextField(); frame.add(jTF5);
        jTF5.setBounds(215, 350, 60, 20);
        jTF5.setVisible(false);

        JLabel jLB6 = new JLabel("Enter Location : "); frame.add(jLB6);
        jLB6.setBounds(115, 350, 100, 20);
        jLB6.setVisible(false);

        JButton jBT1 = new JButton("Add Student"); frame.add(jBT1);
        jBT1.setBounds(115, 200, 160, 30);

        JButton jBT2 = new JButton("Add Student By File"); frame.add(jBT2);
        jBT2.setBounds(115, 250, 160, 30);

        JButton jBT3 = new JButton("Insert Student"); frame.add(jBT3);
        jBT3.setBounds(115, 300, 160, 30);

        JButton jBT4 = new JButton("ADD"); frame.add(jBT4);
        jBT4.setBounds(165, 380, 60, 20);
        jBT4.setVisible(false);


        //Xu Ly Khi Click Add Student
        jBT1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student s = new Student(jTF1.getText(), jTF2.getText(), jTF3.getText(), Double.parseDouble(jTF4.getText()));
                s.ChuanHoaTen();
                s.ChuanHoaLop();
                list.add(s);
                menu.updateStudentList(list);
                frame.dispose();
            }
        });

        //Xu Ly Khi Click Add Student By File
        jBT2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFile = new JFileChooser();
                int returnFile = jFile.showOpenDialog(null);
                if(returnFile == JFileChooser.APPROVE_OPTION){
                    File selection = jFile.getSelectedFile();
                    try(BufferedReader br = new BufferedReader(new FileReader(selection))){
                        String line;
                        while((line = br.readLine()) != null){
                            String[] inFor = line.split(",");
                            if(inFor.length == 4){
                                Student s = new Student(inFor[0].trim(), inFor[1].trim(), inFor[2].trim(), Double.parseDouble(inFor[3]));
                                s.ChuanHoaLop();
                                s.ChuanHoaTen();
                                list.add(s);
                            }
                        }
                        menu.updateStudentList(list);
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                    frame.dispose();
                }
            }
        });

        //Xu Ly Khi Click Insert Student
        jBT3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jTF5.setVisible(true);
                jLB6.setVisible(true);
                jBT4.setVisible(true);
            }
        });
        
        //Xu Ly Khi Click ADD Sau Khi Click Insert Student
        jBT4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student s = new Student(jTF1.getText(), jTF2.getText(), jTF3.getText(), Double.parseDouble(jTF4.getText()));
                s.ChuanHoaLop();
                s.ChuanHoaTen();
                int x = Integer.parseInt(jTF5.getText());
                list.add(x - 1, s);
                menu.updateStudentList(list);
                frame.dispose();
            }
        });
    }
}
