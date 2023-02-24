package StudentManagementSytem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RootFrame extends JFrame {

    JPanel rootPanel;

    JLabel rootLabel;

    JButton addButton, searchButton, editButton, deleteButton, displayButton;

    RootFrame() {
        super("Student Management System");
        rootLabel = new JLabel("What would you like to do?");

        createAddButton();
        createSearchButton();
        createEditButton();
        createDeleteButton();
        createDisplayButton();

        createRootPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.add(rootPanel);
        //this.pack();
        this.setVisible(true);
    }

    void createRootPanel() {
        rootPanel = new JPanel();

        GroupLayout layout = new GroupLayout(rootPanel);
        rootPanel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                        .addComponent(rootLabel)
                        .addComponent(addButton)
                        .addComponent(searchButton)
                        .addComponent(editButton)
                        .addComponent(deleteButton)
                        .addComponent(displayButton)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(rootLabel)
                        .addComponent(addButton)
                        .addComponent(editButton)
                        .addComponent(searchButton)
                        .addComponent(deleteButton)
                        .addComponent(displayButton)
        );

    }

    void createAddButton() {
        addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == addButton)
                    new AddFrame();
            }
        });
    }

    void createSearchButton() {
        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == searchButton) {
                    new SearchFrame();
                }
            }
        });
    }

    void createEditButton() {
        editButton = new JButton("Edit");
        editButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == editButton)
                    new EditPromptFrame();
            }
        });
    }

    void createDeleteButton() {
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == deleteButton) {
                    new DeleteFrame();
                }
            }
        });
    }

    void createDisplayButton() {
        displayButton = new JButton("Display");
        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == displayButton) {
                    //System.out.println(StudentDepartmentManager.getStudent(99).getName());
                    //System.out.println(StudentDepartmentManager.getStudentSize());
                    if(StudentDepartmentManager.getStudentSize() == 0)
                    {
                        JOptionPane.showMessageDialog(rootPanel, "No Students to display", "No students", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        new DisplayFrame();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        StudentDepartmentManager.initialize();
        new RootFrame();
    }

}
