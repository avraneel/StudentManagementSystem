package StudentManagementSytem;
public class Student {
    int roll;
    int deptCode;
    String name;
    String address;
    String phone;

    Student(int roll, int deptCode, String name, String address, String phone) {
        this.roll = roll;
        this.deptCode = deptCode;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    int getRoll() {
        return roll;
    }

    String getName() {
        return name;
    }

    int getDeptCode() {
        return deptCode;
    }

    String getPhone() {
        return phone;
    }

    String getAddress() {
        return address;
    }

    void setName(String s) {
        name = s;
    }

    void setAddress(String s) {
        address = s;
    }

    void setPhone(String s) {
        phone = s;
    }

    void setDeptCode(int d) {
        deptCode = d;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll: " + roll);
        System.out.println("Phone:" + phone);
    }

}
