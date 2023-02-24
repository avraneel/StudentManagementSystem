package StudentManagementSytem;

import java.util.*;

public class StudentDepartmentManager {

    static Map<Integer, Student> slist;
    static List<Department> dlist;

    static void initialize() {
        slist = new HashMap<>();
        dlist = new ArrayList<>();
        dlist.add(new Department(140, "CSE"));
        dlist.add(new Department(150, "ECE"));
        dlist.add(new Department(160, "EE"));
        dlist.add(new Department(170, "ME"));
        dlist.add(new Department(190, "FTBE"));
        slist.put(47, new Student(47, 140, "Avraneel Pal", "Kolkata", "123456789"));
        slist.put(34, new Student(34, 150, "Rakesh", "Mumbai", "987654321"));
        slist.put(28, new Student(28, 170, "Ram", "Bangalore", "1122334455"));
        slist.put(91, new Student(91, 190, "Jaydeep", "Chennai", "5544332211"));
        slist.put(74, new Student(74, 140, "John", "London", "192837465"));
        slist.put(19, new Student(19, 160, "Jacob", "New York", "918273645"));
        slist.put(56, new Student(82, 150, "Mark", "Vienna", "135798642"));
        slist.put(5, new Student(5, 140, "Luke", "Delhi", "246813579"));

    }

    static int addStudent(Student s) {
        if(slist.containsKey(s.getRoll()))
            return 1;
        else
            slist.put(s.getRoll(), s);
        return 0;
    }

    static Student getStudent(int roll) {
        return slist.get(roll);
    }

    static void displayStudent(int roll) {
        slist.get(roll).display();
    }

    static int getStudentSize() {
        return slist.size();
    }

    static Map<Integer, Student> getSlist() {
        return slist;
    }
    static void addDepartment(int dcode, String dname) {
        dlist.add(new Department(dcode, dname));
    }

    static String getNameFromCode(int dcode) {
        int index = -1;
        for(int i = 0; i < dlist.size(); i++) {
            if(dlist.get(i).getDcode() == dcode) {
               index = i;
            }
        }
        return dlist.get(index).getDname();
    }

}
