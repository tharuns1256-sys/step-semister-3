abstract class WashType {
    public abstract int getDuration();
    public abstract double getCharge();
    public abstract String getName();
}

class QuickWash extends WashType {
    public int getDuration() {
        return 30;
    }

    public double getCharge() {
        return 20;
    }

    public String getName() {
        return "Quick";
    }
}

class NormalWash extends WashType {
    public int getDuration() {
        return 45;
    }

    public double getCharge() {
        return 30;
    }

    public String getName() {
        return "Normal";
    }
}

class HeavyWash extends WashType {
    public int getDuration() {
        return 60;
    }

    public double getCharge() {
        return 45;
    }

    public String getName() {
        return "Heavy";
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

class WashingMachine {
    private String machineId;
    private boolean busy;

    public WashingMachine(String machineId) {
        this.machineId = machineId;
        this.busy = false;
    }

    public String getMachineId() {
        return machineId;
    }

    public boolean isBusy() {
        return busy;
    }

    public boolean startMachine() {
        if (busy) {
            return false;
        }

        busy = true;
        return true;
    }

    public void completeMachine() {
        busy = false;
    }
}

class WashCycle {
    private Student student;
    private WashingMachine machine;
    private WashType washType;

    public WashCycle(
        Student student,
        WashingMachine machine,
        WashType washType
    ) {
        this.student = student;
        this.machine = machine;
        this.washType = washType;
    }

    public void start() {
        if (!machine.startMachine()) {
            System.out.println(
                "Machine " + machine.getMachineId() +
                " is currently busy."
            );
            return;
        }

        System.out.printf(
            "%s wash started on %s for %s (%d min).%n",
            washType.getName(),
            machine.getMachineId(),
            student.getName(),
            washType.getDuration()
        );

        System.out.printf(
            "Charge: ₹%.2f%n",
            washType.getCharge()
        );
    }

    public void complete() {
        machine.completeMachine();

        System.out.println(
            machine.getMachineId() +
            " cycle completed."
        );

        System.out.println(
            machine.getMachineId() +
            " is now free."
        );
    }
}

public class LaundryDemo {
    public static void main(String[] args) {

        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Student neha = new Student("Neha");

        WashingMachine m1 =
            new WashingMachine("M1");

        WashingMachine m2 =
            new WashingMachine("M2");

        // Asha starts Quick wash on M1
        WashCycle cycle1 =
            new WashCycle(
                asha,
                m1,
                new QuickWash()
            );

        cycle1.start();

        // Ravi attempts Heavy wash on busy M1
        WashCycle cycle2 =
            new WashCycle(
                ravi,
                m1,
                new HeavyWash()
            );

        cycle2.start();

        // Ravi starts Heavy wash on M2
        WashCycle cycle3 =
            new WashCycle(
                ravi,
                m2,
                new HeavyWash()
            );

        cycle3.start();

        // M1 completes
        cycle1.complete();

        // Neha starts Normal wash on M1
        WashCycle cycle4 =
            new WashCycle(
                neha,
                m1,
                new NormalWash()
            );

        cycle4.start();
    }
}