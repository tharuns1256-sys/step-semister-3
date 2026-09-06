class SrmStudent {

    static String collegeName;
    static int academicYear;

    String name;

    // Static block
    static {
        collegeName = "SRM";
        academicYear = 2026;

        System.out.println("College info loaded");
    }

    SrmStudent(String name) {
        this.name = name;
    }

    void printConfirmation() {
        System.out.println("Student record created: " + name);
    }
}

public class SrmStudentDemo {

    public static void main(String[] args) {

        String[] names = {
            "Ravi",
            "Meera",
            "Karthik",
            "Divya",
            "Anitha"
        };

        for (String name : names) {
            SrmStudent student = new SrmStudent(name);
            student.printConfirmation();
        }
    }
}