import java.util.*;

class Student {
    String rollNumber;
    String name;

    Student(String rollNumber, String name) {
        this.rollNumber = rollNumber;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Student)) {
            return false;
        }

        Student other = (Student) obj;
        return rollNumber.equals(other.rollNumber);
    }

    @Override
    public int hashCode() {
        return rollNumber.hashCode();
    }
}

public class StudentClubRegistration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Student> members = new HashSet<>();
        List<String> addMessages = new ArrayList<>();
        List<String> containsMessages = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();

            if (line.isEmpty()) {
                continue;
            }

            String[] p = line.split("\\s+");

            String operation = p[0];
            String roll = p[1];
            String name = p[2];

            Student student = new Student(roll, name);

            if (operation.equals("ADD")) {
                if (members.add(student)) {
                    addMessages.add("Added");
                } else {
                    addMessages.add("duplicate rejected");
                }
            } else if (operation.equals("CONTAINS")) {
                containsMessages.add(
                    "contains: " + members.contains(student));
            }
        }

        for (String message : addMessages) {
            System.out.println(message);
        }

        System.out.println("member count " + members.size());

        for (String message : containsMessages) {
            System.out.println(message);
        }

        sc.close();
    }
}