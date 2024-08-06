import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InterfaceEnterNameDelete{
    public InterfaceEnterNameDelete(ArrayList<Student> list, MenuProject menu){
        JFrame frame = new JFrame();   
        frame.setTitle("Enter Name Delete");
        frame.setSize(300, 200);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        
        JLabel jLB1 = new JLabel("Enter Name Delete"); frame.add(jLB1);
        jLB1.setBounds(50, 20, 200, 30);
        jLB1.setFont(new Font("Arial", Font.PLAIN, 20));
        jLB1.setHorizontalAlignment(0);
        
        JLabel jLB2 = new JLabel("Name : "); frame.add(jLB2);
        jLB2.setBounds(30, 70, 50, 20);

        JTextField jTF1 = new JTextField(); frame.add(jTF1);
        jTF1.setBounds(80, 70, 150, 20);

        JButton jBT1 = new JButton("Delete"); frame.add(jBT1);
        jBT1.setBounds(95, 110, 100, 20);

        jBT1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nameSearch = jTF1.getText();
                for(int i = 0; i < list.size(); i++){
                    Student str = list.get(i);
                    String[] arr = str.getName().split("\\s+");
                    if(arr[arr.length - 1].equals(nameSearch)){
                        list.remove(list.get(i));
                        break;
                    }                    
                }
                frame.dispose();
                menu.updateStudentList(list);
            }  
        });
    }
}
