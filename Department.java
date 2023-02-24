package StudentManagementSytem;

public class Department {
    int dcode;
    String dname;

    Department(int dcode, String dname) {
        this.dcode = dcode;
        this.dname = dname;
    }

    String getDname() {
        return dname;
    }

    int getDcode() {
        return dcode;
    }

}

