package StudentManagementSytem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteFrame extends JFrame {

    JPanel deletePanel;
    JLabel deleteLabel;
    JTextField deleteBox;
    JButton deleteButton;

    public DeleteFrame() {
        super("Delete Student");

        deleteLabel = new JLabel("Enter roll to delete:");
        deleteBox = new JTextField();
        createDeleteButton();
        createDeletePanel();
        this.add(deletePanel);
        this.pack();
        this.setVisible(true);
    }

    void createDeletePanel() {
        deletePanel = new JPanel();

        GroupLayout layout = new GroupLayout(deletePanel);
        deletePanel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(deleteLabel)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(deleteBox)
                                .addComponent(deleteButton))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(deleteLabel)
                                .addComponent(deleteBox))
                        .addComponent(deleteButton)
        );
    }

    public void createDeleteButton() {
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int roll = Integer.parseInt(deleteBox.getText());
                if(StudentDepartmentManager.getSlist() ==  null){
                    JOptionPane.showMessageDialog(deletePanel, "No Student of this roll exists", "Student not found", JOptionPane.ERROR_MESSAGE);
                    return;
                }
                Student s = StudentDepartmentManager.getSlist().remove(roll);
                if(s == null){
                    JOptionPane.showMessageDialog(deletePanel, "No Student of this roll exists", "Student not found", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(deletePanel, "Student successfully deleted", "Deletion success", JOptionPane.PLAIN_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        StudentDepartmentManager.initialize();
        new DeleteFrame();
    }



}
