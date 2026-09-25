abstract class DeliveryNote {

    public abstract String confirmDelivery();

    public String confirmDelivery(String signature) {

        return confirmDelivery() +
               ", signed by " + signature;
    }
}

class ParcelNote extends DeliveryNote {

    private String trackingId;

    public ParcelNote(String trackingId) {
        this.trackingId = trackingId;
    }

    public String confirmDelivery() {

        return "Parcel " + trackingId + " delivered";
    }
}

class LetterNote extends DeliveryNote {

    private String trackingId;

    public LetterNote(String trackingId) {
        this.trackingId = trackingId;
    }

    public String confirmDelivery() {

        return "Letter " + trackingId + " delivered";
    }
}

class DeliveryLogger {

    static void logAll(DeliveryNote[] notes) {

        for (int i = 0; i < notes.length; i++) {
            System.out.println(notes[i].confirmDelivery());
        }
    }
}

public class DeliveryDemo {

    public static void main(String[] args) {

        ParcelNote p = new ParcelNote("TRK-1");
        LetterNote l = new LetterNote("TRK-2");

        System.out.println(p.confirmDelivery());

        System.out.println(
            p.confirmDelivery("J. Smith")
        );

        DeliveryNote ref = p;

        DeliveryNote[] notes = {
            ref,
            l
        };

        DeliveryLogger.logAll(notes);
    }
}