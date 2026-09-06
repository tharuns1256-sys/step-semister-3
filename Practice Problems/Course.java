class Course {

    String code;
    String title;
    int credits;
    int labCredits;

    // Four-argument constructor
    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    // Three-argument constructor
    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return credits + labCredits;
    }
}

public class CourseDemo {

    public static void main(String[] args) {

        Course theoryCourse =
                new Course("21CSC201J", "Data Structures", 4);

        Course labCourse =
                new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println("21CSC201J total credits: "
                + theoryCourse.totalCredits());

        System.out.println("21CSC205L total credits: "
                + labCourse.totalCredits());
    }
}