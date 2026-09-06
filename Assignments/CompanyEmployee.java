class CompanyEmployee {

    // Instance fields
    String empName;
    double salary;

    // Static fields
    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    // Constructor
    CompanyEmployee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    // Static method
    static void displayCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class CompanyEmployeeDemo {

    public static void main(String[] args) {

        CompanyEmployee employee1 =
                new CompanyEmployee("Divya", 65000);

        CompanyEmployee employee2 =
                new CompanyEmployee("Arjun", 40000);

        CompanyEmployee employee3 =
                new CompanyEmployee("Priya", 55000);

        System.out.println("3 Employee objects created");

        // Calling static method using class name
        CompanyEmployee.displayCompanyInfo();
    }
}