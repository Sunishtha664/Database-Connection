import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class App {
    public static void main(String[] args) {
        JFrame f = new JFrame("Database Connectivity");
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500, 400);  // Adjusted window size

        // First column (ID)
        JLabel l = new JLabel("ID:");
        l.setBounds(100, 150, 50, 20);
        f.add(l);

        JTextField t = new JTextField();
        t.setBounds(100, 170, 120, 30);
        f.add(t);

        // Second column (Marks) - placed to the right of ID
        JLabel l1 = new JLabel("Marks in Java:");
        l1.setBounds(250, 150, 100, 20);  // x=250 puts it to the right of ID field
        f.add(l1);

        JTextField t1 = new JTextField();
        t1.setBounds(250, 170, 120, 30);
        f.add(t1);

        // Submit button centered below both fields
        JButton b = new JButton("Submit");
        b.setBounds(190, 220, 100, 30);
        f.add(b);

        f.setVisible(true);

        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    int id = Integer.parseInt(t.getText());
                    int marks = Integer.parseInt(t1.getText());

                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/javamark");
                    System.out.println("Connection Successful");

                    Statement st= con.createStatement();
                    String query = "INSERT INTO result(id,mark) VALUES('"+id+"','"+marks+"')";
                    st.execute(query);
                    System.out.println("Data Inserted successfully");
                }
                catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        });

    ;}

}
