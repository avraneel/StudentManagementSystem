package StudentManagementSytem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class DisplayFrame extends JFrame {

    JPanel singlePanel, allFivePanels, displayPanel;
    JLabel pageLabel;
    JLabel roll1, roll2, roll3, roll4, roll5;
    JLabel name1, name2, name3, name4, name5;
    JLabel dept1, dept2, dept3, dept4, dept5;
    JLabel addr1, addr2, addr3, addr4, addr5;
    JLabel phn1, phn2, phn3, phn4, phn5;
    JButton prevButton, nextButton; // Shows the buttons
    Student buffer[];
    int rollSet[];
    int pgText, maxPage;

    public DisplayFrame() {
        super("Displaying Student details");

        rollSet = new int[StudentDepartmentManager.getStudentSize()];
        maxPage = StudentDepartmentManager.getStudentSize() % 5 == 0 ? StudentDepartmentManager.getStudentSize()/5 : StudentDepartmentManager.getStudentSize()/5 + 1;
        //maxPage = StudentDepartmentManager.getStudentSize();

        createPrevButton();
        createNextButton();

        //Iterator sIterator = StudentDepartmentManager.slist.entrySet().iterator();

        extractRoll();
        Arrays.sort(rollSet);


        pgText = 1;

        prevButton.setEnabled(false);
        //if(pgText == 1)
            //prevButton.setEnabled(false);
        //else
            //prevButton.setEnabled(true);

        pageLabel = new JLabel("Showing" + String.valueOf(pgText) + " of " + maxPage);

        roll1 = new JLabel(); roll2 = new JLabel();
        roll3 = new JLabel(); roll4 = new JLabel();
        roll5 = new JLabel();

        name1 = new JLabel(); name2 = new JLabel();
        name3 = new JLabel(); name4 = new JLabel();
        name5 = new JLabel();

        dept1 = new JLabel(); dept2 = new JLabel();
        dept3 = new JLabel(); dept4 = new JLabel();
        dept5 = new JLabel();

        addr1 = new JLabel("Address:");
        addr2 = new JLabel("Address:");
        addr3 = new JLabel("Address:");
        addr4 = new JLabel("Address:");
        addr5 = new JLabel("Address:");

        phn1 = new JLabel(); phn2 = new JLabel();
        phn3 = new JLabel(); phn4 = new JLabel();
        phn5 = new JLabel();

        this.changeLabels(0);

        createDisplayPanel();

        this.setSize(800,200);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(displayPanel);
        //this.pack();
        if(StudentDepartmentManager.getStudentSize() <= 5) {
            if (pgText == 1)
                nextButton.setEnabled(false);
            else
                nextButton.setEnabled(true);
        }
        this.setVisible(true);
    }

    void createSinglePanel() {
        singlePanel = new JPanel();

        GroupLayout layout = new GroupLayout(singlePanel);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

    }

    void createDisplayPanel() {
        displayPanel = new JPanel();

        GroupLayout layout = new GroupLayout(displayPanel);
        displayPanel.setLayout(layout);

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(roll1)
                                .addComponent(roll2)
                                .addComponent(roll3)
                                .addComponent(roll4)
                                .addComponent(roll5))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(name1)
                                .addComponent(name2)
                                .addComponent(name3)
                                .addComponent(name4)
                                .addComponent(name5))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(dept1)
                                .addComponent(dept2)
                                .addComponent(dept3)
                                .addComponent(dept4)
                                .addComponent(dept5))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(addr1)
                                .addComponent(addr2)
                                .addComponent(addr3)
                                .addComponent(addr4)
                                .addComponent(addr5))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(phn1)
                                .addComponent(phn2)
                                .addComponent(phn3)
                                .addComponent(phn4)
                                .addComponent(phn5))
                        .addComponent(pageLabel)
                        .addComponent(prevButton)
                        .addComponent(nextButton)
        );

        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(roll1)
                                .addComponent(name1)
                                .addComponent(dept1)
                                .addComponent(addr1)
                                .addComponent(phn1))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(roll2)
                                .addComponent(name2)
                                .addComponent(dept2)
                                .addComponent(addr2)
                                .addComponent(phn2))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(roll3)
                                .addComponent(name3)
                                .addComponent(dept3)
                                .addComponent(addr3)
                                .addComponent(phn3))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(roll4)
                                .addComponent(name4)
                                .addComponent(dept4)
                                .addComponent(addr4)
                                .addComponent(phn4))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(roll5)
                                .addComponent(name5)
                                .addComponent(dept5)
                                .addComponent(addr5)
                                .addComponent(phn5))
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(pageLabel)
                                .addComponent(prevButton)
                                .addComponent(nextButton))
        );

    }

    void createPrevButton() {
        prevButton = new JButton("Prev");
        prevButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == prevButton) {
                    pgText--;
                    if(pgText == 1)
                        prevButton.setEnabled(false);
                    else
                        prevButton.setEnabled(true);
                    if(pgText >= maxPage)
                        nextButton.setEnabled(false);
                    else
                        nextButton.setEnabled(true);
                    changeLabels((pgText-1)*5);
                }
                pageLabel.setText("Showing: " + String.valueOf(pgText) + " of " + maxPage);
            }
        });
    }

    void createNextButton() {
        nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource() == nextButton) {
                    pgText++;
                    if(pgText > 1)
                        prevButton.setEnabled(true);
                    if(pgText == 1)
                        nextButton.setEnabled(false);
                    else
                        nextButton.setEnabled(true);

                    if(pgText >= maxPage) {
                        nextButton.setEnabled(false);
                    }
                    else
                        nextButton.setEnabled(true);
                    changeLabels((pgText-1)*5);
                }

                pageLabel.setText("Showing: " + String.valueOf(pgText) + " of " + maxPage);
            }
        });
    }

    void extractRoll() {
        int i = 0;
        for(int roll : StudentDepartmentManager.getSlist().keySet()) {
            rollSet[i++] = roll;
        }
    }

    void changeLabels(int i) {

        roll1.setText("Roll:    "+StudentDepartmentManager.getStudent(rollSet[i]).getRoll()+"\t");
        name1.setText("Name:    "+StudentDepartmentManager.getStudent(rollSet[i]).getName()+"\t");
        dept1.setText("Dept:    "+StudentDepartmentManager.getNameFromCode(StudentDepartmentManager.getStudent(rollSet[i]).getDeptCode()));
        addr1.setText("Address: "+StudentDepartmentManager.getStudent(rollSet[i]).getAddress());
        phn1.setText("Phone:    "+StudentDepartmentManager.getStudent(rollSet[i]).getPhone());

        if(i+1 < StudentDepartmentManager.getStudentSize()) {
            roll2.setText("Roll:    "+StudentDepartmentManager.getStudent(rollSet[i+1]).getRoll()+"\t");
            name2.setText("Name:    "+StudentDepartmentManager.getStudent(rollSet[i+1]).getName()+"\t");
            dept2.setText("Dept:    "+StudentDepartmentManager.getNameFromCode(StudentDepartmentManager.getStudent(rollSet[i+1]).getDeptCode()));
            addr2.setText("Address: "+StudentDepartmentManager.getStudent(rollSet[i+1]).getAddress()+"\t");
            phn2.setText("Phone:    "+StudentDepartmentManager.getStudent(rollSet[i+1]).getPhone()+"\t");
        }
        else {
            roll2.setText("\t\n");
            name2.setText("\t\n");
            dept2.setText("\t\n");
            addr2.setText("\t\n");
            phn2.setText("\t\n");
        }

        if(i+2 < StudentDepartmentManager.getStudentSize()) {
            roll3.setText("Roll:    "+StudentDepartmentManager.getStudent(rollSet[i+2]).getRoll()+"\t");
            name3.setText("Name:    "+StudentDepartmentManager.getStudent(rollSet[i+2]).getName()+"\t");
            dept3.setText("Dept:    "+StudentDepartmentManager.getNameFromCode(StudentDepartmentManager.getStudent(rollSet[i+2]).getDeptCode())+"\t");
            addr3.setText("Address: "+StudentDepartmentManager.getStudent(rollSet[i+2]).getAddress()+"\t");
            phn3.setText("Phone:    "+StudentDepartmentManager.getStudent(rollSet[i+2]).getPhone()+"\t");
        }
        else {
            roll3.setText("\t\n");
            name3.setText("\t\n");
            dept3.setText("\t\n");
            addr3.setText("\t\n");
            phn3.setText("\t\n");
        }

        if(i+3 < StudentDepartmentManager.getStudentSize()) {
            roll4.setText("Roll:    "+StudentDepartmentManager.getStudent(rollSet[i+3]).getRoll()+"\t");
            name4.setText("Name:    "+StudentDepartmentManager.getStudent(rollSet[i+3]).getName());
            dept4.setText("Dept:    "+StudentDepartmentManager.getNameFromCode(StudentDepartmentManager.getStudent(rollSet[i+3]).getDeptCode()));
            addr4.setText("Address: "+StudentDepartmentManager.getStudent(rollSet[i+3]).getAddress());
            phn4.setText("Phone:    "+StudentDepartmentManager.getStudent(rollSet[i+3]).getPhone());
        }
        else {
            roll4.setText("\t\n");
            name4.setText("\t\n");
            dept4.setText("\t\n");
            addr4.setText("\t\n");
            phn4.setText("\t\n");
        }

        if(i+4 < StudentDepartmentManager.getStudentSize()) {
            roll5.setText("Roll:    "+StudentDepartmentManager.getStudent(rollSet[i+4]).getRoll()+"\t");
            name5.setText("Name:    "+StudentDepartmentManager.getStudent(rollSet[i+4]).getName()+"\t");
            dept5.setText("Dept:    "+StudentDepartmentManager.getNameFromCode(StudentDepartmentManager.getStudent(rollSet[i+4]).getDeptCode())+"\t");
            addr5.setText("Address: "+StudentDepartmentManager.getStudent(rollSet[i+4]).getAddress()+"\t");
            phn5.setText("Phone:    "+StudentDepartmentManager.getStudent(rollSet[i+4]).getPhone()+"\t");
        }
        else {
            roll5.setText("\t\n");
            name5.setText("\t\n");
            dept5.setText("\t\n");
            addr5.setText("\t\n");
            phn5.setText("\t\n");
        }
    }

    public static void main(String[] args) {
        StudentDepartmentManager.initialize();
        new DisplayFrame();
    }


}
