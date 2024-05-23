//package hotel.management.system;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class AddDriver extends JFrame implements ActionListener {
//
//    JButton add, cancel;
//    JTextField tfname, tfcompany, tfage, tfmodel, tflocation;
//    JComboBox gendercombo, availablecombo;
//
//    AddDriver() {
//        getContentPane().setBackground(Color.WHITE);
//        setLayout(null);
//
//        JLabel heading = new JLabel("Add Drivers");
//        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
//        heading.setBounds(150, 10, 200, 20);
//        add(heading);
//
//        JLabel lblname = new JLabel("Name");
//        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        lblname.setBounds(60, 75, 120, 30);
//        add(lblname);
//
//        tfname = new JTextField();
//        tfname.setBounds(200, 80, 150, 30);
//        add(tfname);
//
//        JLabel lblage = new JLabel("Age");
//        lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        lblage.setBounds(60, 130, 120, 30);
//        add(lblage);
//
//        tfage = new JTextField();
//        tfage.setBounds(200, 130, 150, 30);
//        add(tfage);
//
//        JLabel lblgender = new JLabel("Gender");
//        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        lblgender.setBounds(60, 180, 120, 30);
//        add(lblgender);
//
//        String[] genderOptions = {"Male", "Female"};
//        gendercombo = new JComboBox(genderOptions);
//        gendercombo.setBounds(200, 180, 150, 30);
//        gendercombo.setBackground(Color.WHITE);
//        add(gendercombo);
//
//        JLabel lblcompany = new JLabel("Car Company");
//        lblcompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        lblcompany.setBounds(60, 230, 120, 30);
//        add(lblcompany);
//
//        tfcompany = new JTextField();
//        tfcompany.setBounds(200, 230, 150, 30);
//        add(tfcompany);
//
//        JLabel lblmodel = new JLabel("Car Model");
//        lblmodel.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        lblmodel.setBounds(60, 280, 120, 30);
//        add(lblmodel);
//
//        tfmodel = new JTextField();
//        tfmodel.setBounds(200, 280, 150, 30);
//        add(tfmodel);
//
//        JLabel lblavailable = new JLabel("Available");
//        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        lblavailable.setBounds(60, 330, 120, 30);
//        add(lblavailable);
//
//        String[] availabilityOptions = {"Available", "Busy"};
//        availablecombo = new JComboBox(availabilityOptions);
//        availablecombo.setBounds(200, 330, 150, 30);
//        availablecombo.setBackground(Color.WHITE);
//        add(availablecombo);
//
//        JLabel lbllocation = new JLabel("Location");
//        lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
//        lbllocation.setBounds(60, 380, 120, 30);
//        add(lbllocation);
//
//        tflocation = new JTextField();
//        tflocation.setBounds(200, 380, 150, 30);
//        add(tflocation);
//
//        add = new JButton("Add Driver");
//        add.setForeground(Color.WHITE);
//        add.setBackground(Color.BLACK);
//        add.setBounds(60, 430, 130, 30);
//        add.addActionListener(this);
//        add(add);
//
//        cancel = new JButton("Cancel");
//        cancel.setForeground(Color.WHITE);
//        cancel.setBackground(Color.BLACK);
//        cancel.setBounds(220, 430, 130, 30);
//        cancel.addActionListener(this);
//        add(cancel);
//
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
//        ImageIcon i3 = new ImageIcon(i2);
//        JLabel image = new JLabel(i3);
//        image.setBounds(400, 30, 500, 300);
//        add(image);
//
//        setBounds(300, 200, 980, 500);
//        setVisible(true);
//    }
//
//    public void actionPerformed(ActionEvent ae) {
//        if (ae.getSource() == add) {
//            String name = tfname.getText();
//            String age = tfage.getText();  // Ensure that age should be a valid number or handled properly
//            String gender = (String) gendercombo.getSelectedItem();
//            String company = tfcompany.getText();
//            String model = tfmodel.getText();
//            String available = (String) availablecombo.getSelectedItem();
//            String location = tflocation.getText();
//
//            try {
//                Conn conn = new Conn();  // This initializes both the connection and statement
//                // Use the statement 's' from Conn class to execute update
//                String str = "INSERT INTO drivers (name, age, gender, company, model, availability, location) VALUES ('" + name + "', '" + age + "', '" + gender + "', '" + company + "', '" + model + "', '" + available + "', '" + location + "')";
//                conn.s.executeUpdate(str);  // Using the statement object directly
//                JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        } else {
//            setVisible(false);
//        }
//    }
//
//    public static void main(String[] args) {
//        new AddDriver();
//    }
//}
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddDriver extends JFrame implements ActionListener {

    JButton add, cancel;
    JTextField tfname, tfcompany, tfage, tfmodel, tflocation;
    JComboBox<String> gendercombo, availablecombo;

    AddDriver() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add Drivers");
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 10, 200, 20);
        add(heading);

        JLabel lblname = new JLabel("Name");
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblname.setBounds(60, 75, 120, 30);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 75, 150, 30);
        add(tfname);

        JLabel lblage = new JLabel("Age");
        lblage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblage.setBounds(60, 130, 120, 30);
        add(lblage);

        tfage = new JTextField();
        tfage.setBounds(200, 130, 150, 30);
        add(tfage);

        JLabel lblgender = new JLabel("Gender");
        lblgender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblgender.setBounds(60, 180, 120, 30);
        add(lblgender);

        String[] genderOptions = {"Male", "Female"};
        gendercombo = new JComboBox<>(genderOptions);
        gendercombo.setBounds(200, 180, 150, 30);
        gendercombo.setBackground(Color.WHITE);
        add(gendercombo);

        JLabel lblcompany = new JLabel("Car Company");
        lblcompany.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblcompany.setBounds(60, 230, 120, 30);
        add(lblcompany);

        tfcompany = new JTextField();
        tfcompany.setBounds(200, 230, 150, 30);
        add(tfcompany);

        JLabel lblmodel = new JLabel("Car Model");
        lblmodel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblmodel.setBounds(60, 280, 120, 30);
        add(lblmodel);

        tfmodel = new JTextField();
        tfmodel.setBounds(200, 280, 150, 30);
        add(tfmodel);

        JLabel lblavailable = new JLabel("Available");
        lblavailable.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblavailable.setBounds(60, 330, 120, 30);
        add(lblavailable);

        String[] availabilityOptions = {"Available", "Busy"};
        availablecombo = new JComboBox<>(availabilityOptions);
        availablecombo.setBounds(200, 330, 150, 30);
        availablecombo.setBackground(Color.WHITE);
        add(availablecombo);

        JLabel lbllocation = new JLabel("Location");
        lbllocation.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbllocation.setBounds(60, 380, 120, 30);
        add(lbllocation);

        tflocation = new JTextField();
        tflocation.setBounds(200, 380, 150, 30);
        add(tflocation);

        add = new JButton("Add Driver");
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setBounds(60, 430, 130, 30);
        add.addActionListener(this);
        add(add);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220, 430, 130, 30);
        cancel.addActionListener(this);
        add(cancel);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 500, 300);
        add(image);

        setBounds(300, 200, 980, 500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == add) {
            String name = tfname.getText();
            String age = tfage.getText();  // Ensure that age should be a valid number or handled properly
            String gender = (String) gendercombo.getSelectedItem();
            String company = tfcompany.getText();
            String model = tfmodel.getText();
            String available = (String) availablecombo.getSelectedItem();
            String location = tflocation.getText();

            // Using try-with-resources to ensure proper resource management
            try (Conn conn = new Conn()) {
                String query = "INSERT INTO driver (name, age, gender, company, brand, available, location) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement pstmt = conn.c.prepareStatement(query);
                pstmt.setString(1, name);
                pstmt.setString(2, age);
                pstmt.setString(3, gender);
                pstmt.setString(4, company);
                pstmt.setString(5, model);
                pstmt.setString(6, available);
                pstmt.setString(7, location);
                pstmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "New Driver Added Successfully");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage());
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new AddDriver();
    }
}
