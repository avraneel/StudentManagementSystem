package StudentManagementSytem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditPromptFrame extends JFrame {
    JPanel editPromptPanel;

    JButton editButton;

    JTextField editBox;

    JLabel editLabel;

    public EditPromptFrame() {
        super("Enter roll");

        editLabel = new JLabel("Enter roll:");
        editBox = new JTextField();
        createEditButton();
        createEditPromptPanel();
        this.add(editPromptPanel);
        this.pack();
        this.setVisible(true);
    }

    void createEditButton() {
        editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int roll = Integer.parseInt(editBox.getText());
                if(!StudentDepartmentManager.getSlist().containsKey(roll)){
                    JOptionPane.showMessageDialog(editPromptPanel, "No student of this roll exists", "Student not found", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    new EditFrame(roll);
                }
            }
        });
    }

    void createEditPromptPanel() {
        editPromptPanel = new JPanel();

        GroupLayout layout = new GroupLayout(editPromptPanel);
        editPromptPanel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addComponent(editLabel)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(editBox)
                                .addComponent(editButton))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(editLabel)
                                .addComponent(editBox))
                        .addComponent(editButton)
        );
    }

    public static void main(String[] args) {
        new EditPromptFrame();
    }

}
