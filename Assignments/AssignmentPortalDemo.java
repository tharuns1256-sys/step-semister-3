abstract class Assignment {
    protected String title;
    protected int maxMarks;
    protected int dueDay;

    public Assignment(
        String title,
        int maxMarks,
        int dueDay
    ) {
        this.title = title;
        this.maxMarks = maxMarks;
        this.dueDay = dueDay;
    }

    public String getTitle() {
        return title;
    }

    public int getMaxMarks() {
        return maxMarks;
    }

    public int getDueDay() {
        return dueDay;
    }

    public abstract double applyLatePenalty(
        double marks,
        int lateDays
    );
}

class CodingAssignment extends Assignment {

    public CodingAssignment(
        String title,
        int maxMarks,
        int dueDay
    ) {
        super(title, maxMarks, dueDay);
    }

    public double applyLatePenalty(
        double marks,
        int lateDays
    ) {
        return marks * (1 - 0.10 * lateDays);
    }
}

class WrittenAssignment extends Assignment {

    public WrittenAssignment(
        String title,
        int maxMarks,
        int dueDay
    ) {
        super(title, maxMarks, dueDay);
    }

    public double applyLatePenalty(
        double marks,
        int lateDays
    ) {
        return marks * (1 - 0.20 * lateDays);
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Submission {
    private Student student;
    private Assignment assignment;
    private int submissionDay;
    private String status;
    private double finalMarks;

    public Submission(
        Student student,
        Assignment assignment,
        int submissionDay
    ) {
        this.student = student;
        this.assignment = assignment;
        this.submissionDay = submissionDay;
        this.status = "Submitted";
        this.finalMarks = 0;
    }

    public void grade(double awardedMarks) {

        if (!status.equals("Submitted")) {
            System.out.println(
                "Cannot grade this submission."
            );
            return;
        }

        int lateDays =
            Math.max(0,
                submissionDay - assignment.getDueDay());

        finalMarks =
            assignment.applyLatePenalty(
                awardedMarks,
                lateDays
            );

        status = "Graded";

        System.out.printf(
            "%s graded: %.0f/%d after %d day(s) late.%n",
            student.getName(),
            finalMarks,
            assignment.getMaxMarks(),
            lateDays
        );

        System.out.println(
            "Status: Graded."
        );
    }

    public void resubmit(int newDay) {

        if (status.equals("Graded")) {
            System.out.println(
                "Cannot resubmit: '" +
                assignment.getTitle() +
                "' has already been graded."
            );
            return;
        }

        submissionDay = newDay;
    }
}

public class AssignmentPortalDemo {

    public static void main(String[] args) {

        Student asha =
            new Student("Asha");

        Student ravi =
            new Student("Ravi");

        Assignment coding =
            new CodingAssignment(
                "Linked List Lab",
                50,
                10
            );

        Assignment written =
            new WrittenAssignment(
                "Design Essay",
                50,
                12
            );

        Submission ashaSubmission =
            new Submission(
                asha,
                coding,
                10
            );

        System.out.println(
            "Asha's submission for 'Linked List Lab' received (on time)."
        );

        System.out.println(
            "Status: Submitted."
        );

        Submission raviSubmission =
            new Submission(
                ravi,
                written,
                14
            );

        System.out.println(
            "Ravi's submission for 'Design Essay' received (2 days late)."
        );

        System.out.println(
            "Status: Submitted."
        );

        ashaSubmission.grade(45);

        raviSubmission.grade(40);

        ashaSubmission.resubmit(11);
    }
}