package StudentManagementSytem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddFrame extends JFrame {

    JPanel addPanel;
    JLabel rollLabel, nameLabel, deptLabel, addressLabel, phoneLabel;
    JTextField rollBox, nameBox, phoneBox, searchBox;
    JComboBox deptBox;
    JTextArea addressBox;
    JButton saveButton, cancelButton;

    String darray[];
    int dcodearray[];

    public AddFrame() {
        super(" Add Student");

        dcodearray = new int[StudentDepartmentManager.dlist.size()];
        // Extracting name to show in Combo box
        darray = new String[StudentDepartmentManager.dlist.size()];
        for(int i = 0; i < darray.length; i++) {
            darray[i] = StudentDepartmentManager.dlist.get(i).dname;
            dcodearray[i] = StudentDepartmentManager.dlist.get(i).dcode;
        }

        rollLabel = new JLabel("Roll:");
        nameLabel = new JLabel("Name:");
        deptLabel = new JLabel("Department:");
        addressLabel = new JLabel("Address");
        phoneLabel = new JLabel("Phone:");

        rollBox = new JTextField();
        nameBox = new JTextField();
        deptBox = new JComboBox(darray);
        addressBox = new JTextArea();
        addressBox.setLineWrap(true);
        addressBox.setWrapStyleWord(true);
        phoneBox = new JTextField();

        createSaveButton();
        createCancelButton();

        createAddPanel();

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(350, 300);

        this.add(addPanel);

        //this.setResizable(false);
        this.setVisible(true);
    }

    void createAddPanel() {
        addPanel = new JPanel();

        GroupLayout layout = new GroupLayout(addPanel);
        addPanel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(rollLabel)
                                .addComponent(nameLabel)
                                .addComponent(deptLabel)
                                .addComponent(addressLabel)
                                .addComponent(phoneLabel))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(rollBox)
                                .addComponent(nameBox)
                                .addComponent(deptBox)
                                .addComponent(addressBox)
                                .addComponent(phoneBox)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(saveButton)
                                        .addComponent(cancelButton)))
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(rollLabel)
                                .addComponent(rollBox))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(nameLabel)
                                .addComponent(nameBox))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(deptLabel)
                                .addComponent(deptBox))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(addressLabel)
                                .addComponent(addressBox))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(phoneLabel)
                                .addComponent(phoneBox))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(saveButton)
                                .addComponent(cancelButton))
        );
    }

    void createSaveButton() {
        saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == saveButton) {
                    if(rollBox.getText().equals("")) {
                        JOptionPane.showMessageDialog(addPanel, "Roll is compulsory", "Enter roll", JOptionPane.ERROR_MESSAGE);
                    }
                    else {
                        int roll = Integer.parseInt(rollBox.getText());
                        String name = nameBox.getText();
                        String dname = deptBox.getSelectedItem().toString();
                        int index = -1;
                        for (int i = 0; i < darray.length; i++) {
                            if (dname.equals(darray[i])) {
                                index = i;
                            }
                        }
                        String address = addressBox.getText();
                        String phone = phoneBox.getText();
                        int dcode = dcodearray[index];
                        Student s = new Student(roll, dcode, name, address, phone);
                        int err = StudentDepartmentManager.addStudent(s);
                        if (err > 0)
                            JOptionPane.showMessageDialog(addPanel, "Student roll already exits", "Duplicate Addition", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
    }

    void createCancelButton() {
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == cancelButton) {
                    rollBox.setText("");
                    nameBox.setText("");
                    addressBox.setText("");
                    phoneBox.setText("");
                }
            }
        });
    }

    public static void main(String[] args) {
        StudentDepartmentManager.initialize();
        new AddFrame();
    }

}

