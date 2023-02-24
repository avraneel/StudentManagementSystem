package StudentManagementSytem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchFrame extends JFrame {

    JPanel searchPanel;
    JLabel rollLabel;

    JTextField searchBox;
    JButton searchButton ;

    public SearchFrame() {

        rollLabel = new JLabel("Enter Roll:");
        searchBox = new JTextField();

        createSearchButton();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(350, 120);
        this.setTitle("Search Student");

        createSearchPanel();

        this.add(searchPanel);
        this.setVisible(true);
    }

    void createSearchPanel() {

        searchPanel = new JPanel();

        GroupLayout layout = new GroupLayout(searchPanel);
        searchPanel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addComponent(rollLabel)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(searchBox)
                        .addComponent(searchButton))
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(rollLabel)
                    .addComponent(searchBox))
                .addComponent(searchButton)
        );
    }

    void createSearchButton() {
        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == searchButton) {
                    int roll = Integer.parseInt(searchBox.getText());
                    Student s = StudentDepartmentManager.getStudent(roll);
                    if(s == null) {
                        JOptionPane.showMessageDialog(searchPanel, "Student not found", "Error", JOptionPane.PLAIN_MESSAGE);
                    }
                    else {
                        String details = "Roll: " + s.getRoll() + "\n";
                        details += "Name: " + s.getName() + "\n";
                        details += "Dept: " + StudentDepartmentManager.getNameFromCode(s.getDeptCode()) + "\n";
                        details += "Address: " + s.getAddress() + "\n";
                        details += "Phone: " + s.getPhone() + "\n";

                        JOptionPane.showMessageDialog(searchPanel, details, "Student Details", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        StudentDepartmentManager.initialize();
        new SearchFrame();
    }

}
