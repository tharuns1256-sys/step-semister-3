class HackathonParticipant {

    String name;
    String teamName;
    boolean registered;

    // Constructor with team name
    HackathonParticipant(String name, String teamName) {
        this.name = name;
        this.teamName = teamName;
        this.registered = true;
    }

    // Constructor for solo participant
    HackathonParticipant(String name) {
        this(name, "Unassigned");
    }

    void printStatus() {
        System.out.println(
            name + " | " + teamName + " | Registered: " + registered
        );
    }
}

public class HackathonDemo {

    public static void main(String[] args) {

        String[] names = {
            "Ravi", "Meera", "Karthik", "Divya"
        };

        String[] teamNames = {
            "ByteBusters", "", "CodeCrafters", ""
        };

        for (int i = 0; i < names.length; i++) {

            HackathonParticipant participant;

            if (teamNames[i].equals("")) {
                participant = new HackathonParticipant(names[i]);
            } else {
                participant = new HackathonParticipant(
                    names[i], teamNames[i]
                );
            }

            participant.printStatus();
        }
    }
}