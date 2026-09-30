abstract class Employee {

    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract boolean isLeaveAllowed(int days);
}

class FullTimeEmployee extends Employee {

    public FullTimeEmployee(String name) {
        super(name);
    }

    public boolean isLeaveAllowed(int days) {
        return days <= 30;
    }
}

class PartTimeEmployee extends Employee {

    public PartTimeEmployee(String name) {
        super(name);
    }

    public boolean isLeaveAllowed(int days) {
        return days <= 10;
    }
}

class Contractor extends Employee {

    public Contractor(String name) {
        super(name);
    }

    public boolean isLeaveAllowed(int days) {
        return days <= 5;
    }
}

class LeaveRequest {

    private Employee employee;
    private String startDate;
    private String endDate;
    private String status;

    public LeaveRequest(
        Employee employee,
        String startDate,
        String endDate
    ) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = "Pending";
    }

    public void approve() {

        if (status.equals("Pending")) {
            status = "Approved";

            System.out.println(
                employee.getName() +
                "'s leave request (" +
                startDate + "-" + endDate +
                ") approved."
            );

            System.out.println("Status: Approved.");
        }
    }

    public void reject() {

        if (status.equals("Pending")) {
            status = "Rejected";

            System.out.println(
                employee.getName() +
                "'s leave request (" +
                startDate + "-" + endDate +
                ") rejected."
            );

            System.out.println("Status: Rejected.");
        }
    }

    public void changeStatus(String newStatus) {

        if (!status.equals("Pending")) {

            System.out.println(
                "Cannot change leave request status from " +
                status + " to " + newStatus + "."
            );

            return;
        }

        status = newStatus;
    }
}

public class LeaveManagementDemo {

    public static void main(String[] args) {

        FullTimeEmployee john =
            new FullTimeEmployee("John");

        PartTimeEmployee jane =
            new PartTimeEmployee("Jane");

        LeaveRequest johnRequest =
            new LeaveRequest(
                john,
                "Jan 1",
                "Jan 5"
            );

        System.out.println(
            "Leave request submitted for John (Jan 1-Jan 5)."
        );

        System.out.println("Status: Pending.");

        johnRequest.approve();

        LeaveRequest janeRequest =
            new LeaveRequest(
                jane,
                "Feb 10",
                "Feb 11"
            );

        System.out.println(
            "Leave request submitted for Jane (Feb 10-Feb 11)."
        );

        System.out.println("Status: Pending.");

        janeRequest.reject();

        johnRequest.changeStatus("Pending");
    }
}