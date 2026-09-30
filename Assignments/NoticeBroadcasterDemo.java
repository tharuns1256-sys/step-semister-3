interface NotificationChannel {

    void send(Student student, Notice notice);
}

class EmailChannel implements NotificationChannel {

    public void send(
        Student student,
        Notice notice
    ) {

        System.out.println(
            "[Email → " +
            student.getName() +
            "] " +
            notice.getTitle()
        );
    }
}

class SmsChannel implements NotificationChannel {

    public void send(
        Student student,
        Notice notice
    ) {

        System.out.println(
            "[SMS → " +
            student.getName() +
            "] " +
            notice.getTitle()
        );
    }
}

class AppChannel implements NotificationChannel {

    public void send(
        Student student,
        Notice notice
    ) {

        System.out.println(
            "[App → " +
            student.getName() +
            "] " +
            notice.getTitle()
        );
    }
}

class Student {

    private String name;
    private String department;
    private NotificationChannel[] channels;
    private int channelCount;

    public Student(
        String name,
        String department
    ) {
        this.name = name;
        this.department = department;
        this.channels =
            new NotificationChannel[5];

        this.channelCount = 0;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public void addChannel(
        NotificationChannel channel
    ) {

        channels[channelCount] = channel;
        channelCount++;
    }

    public void receive(Notice notice) {

        for (int i = 0; i < channelCount; i++) {

            channels[i].send(
                this,
                notice
            );
        }
    }
}

class Notice {

    private String title;
    private String[] departments;
    private int departmentCount;

    public Notice(
        String title,
        String[] departments
    ) {
        this.title = title;
        this.departments = departments;
        this.departmentCount =
            departments.length;
    }

    public String getTitle() {
        return title;
    }

    public boolean isForDepartment(
        String department
    ) {

        for (int i = 0;
             i < departmentCount;
             i++) {

            if (departments[i]
                    .equalsIgnoreCase(department)) {
                return true;
            }
        }

        return false;
    }

    public boolean isValid() {

        return title != null &&
               !title.trim().isEmpty() &&
               departmentCount > 0;
    }

    public String getDepartments() {

        String result = "";

        for (int i = 0;
             i < departmentCount;
             i++) {

            result += departments[i];

            if (i < departmentCount - 1) {
                result += ", ";
            }
        }

        return result;
    }
}

class NoticeBoard {

    private Student[] students;
    private int studentCount;

    public NoticeBoard() {
        students = new Student[20];
        studentCount = 0;
    }

    public void addStudent(Student student) {

        students[studentCount] = student;
        studentCount++;
    }

    public void postNotice(Notice notice) {

        if (!notice.isValid()) {

            System.out.println(
                "Cannot post notice: " +
                "At least one target department is required."
            );

            return;
        }

        System.out.println(
            "Notice '" +
            notice.getTitle() +
            "' posted to " +
            notice.getDepartments() +
            "."
        );

        for (int i = 0;
             i < studentCount;
             i++) {

            Student student = students[i];

            if (notice.isForDepartment(
                    student.getDepartment())) {

                student.receive(notice);
            }
        }
    }
}

public class NoticeBroadcasterDemo {

    public static void main(String[] args) {

        NoticeBoard board =
            new NoticeBoard();

        Student asha =
            new Student("Asha", "CSE");

        Student ravi =
            new Student("Ravi", "ECE");

        // Asha prefers Email and App
        asha.addChannel(
            new EmailChannel()
        );

        asha.addChannel(
            new AppChannel()
        );

        // Ravi prefers SMS
        ravi.addChannel(
            new SmsChannel()
        );

        board.addStudent(asha);
        board.addStudent(ravi);

        // Notice for CSE
        Notice notice1 =
            new Notice(
                "Lab Closed Tomorrow",
                new String[]{"CSE"}
            );

        board.postNotice(notice1);

        // Notice for CSE and ECE
        Notice notice2 =
            new Notice(
                "Fee Deadline Extended",
                new String[]{"CSE", "ECE"}
            );

        board.postNotice(notice2);

        // Notice with no department
        Notice notice3 =
            new Notice(
                "Sports Day",
                new String[]{}
            );

        board.postNotice(notice3);
    }
}