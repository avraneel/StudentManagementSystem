package StudentManagementSytem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditFrame extends JFrame {
    JLabel rollLabel, nameLabel, deptLabel, addressLabel, phoneLabel;
    JLabel rollValue;
    JTextField nameBox, addressBox, phoneBox;
    JComboBox deptBox;
    JPanel editPanel;
    JButton saveButton, cancelButton;

    int globRoll;

    String darray[];
    int dcodearray[];

    public EditFrame(int roll) {
        super("Edit Student");

        // Extracting name to show in Combo box
        dcodearray = new int[StudentDepartmentManager.dlist.size()];
        darray = new String[StudentDepartmentManager.dlist.size()];
        for(int i = 0; i < darray.length; i++) {
            darray[i] = StudentDepartmentManager.dlist.get(i).dname;
            dcodearray[i] = StudentDepartmentManager.dlist.get(i).dcode;
        }
        globRoll = roll;
        rollLabel = new JLabel("Roll:");
        nameLabel = new JLabel("Name:");
        deptLabel = new JLabel("Dept:");
        addressLabel = new JLabel("Address:");
        phoneLabel = new JLabel("Phone:");
        rollValue = new JLabel(String.valueOf(roll));
        nameBox = new JTextField();
        nameBox.setText(StudentDepartmentManager.getStudent(roll).getName());
        deptBox = new JComboBox(darray);
        addressBox = new JTextField(StudentDepartmentManager.getStudent(roll).getAddress());
        phoneBox = new JTextField(StudentDepartmentManager.getStudent(roll).getPhone());
        createSaveButton();
        createCancelButton();
        createEditPanel();
        this.add(editPanel);
        this.pack();
        this.setVisible(true);
    }

    void createEditPanel() {
        editPanel = new JPanel();

        GroupLayout layout = new GroupLayout(editPanel);
        editPanel.setLayout(layout);

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
                                .addComponent(rollValue)
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
                                .addComponent(rollValue))
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
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == saveButton) {
                    String name = nameBox.getText();
                    String dname = deptBox.getSelectedItem().toString();
                    int index = -1;
                    for(int i = 0; i < darray.length; i++) {
                        if(dname.equals(darray[i])){
                            index = i;
                        }
                    }
                    int dcode = dcodearray[index];
                    String address = addressBox.getText();
                    String phone = phoneBox.getText();
                    StudentDepartmentManager.getStudent(globRoll).setName(name);
                    StudentDepartmentManager.getStudent(globRoll).setDeptCode(dcode);
                    StudentDepartmentManager.getStudent(globRoll).setAddress(address);
                    StudentDepartmentManager.getStudent(globRoll).setPhone(phone);
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
                    nameBox.setText(StudentDepartmentManager.getStudent(globRoll).getName());
                    addressBox.setText(StudentDepartmentManager.getStudent(globRoll).getAddress());
                    phoneBox.setText(StudentDepartmentManager.getStudent(globRoll).getPhone());
                }
            }
        });
    }

    public static void main(String[] args) {
        StudentDepartmentManager.initialize();
        new EditFrame(12);
    }
}
