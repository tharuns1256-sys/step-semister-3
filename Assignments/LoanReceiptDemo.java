final class LoanReceipt {

    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {

        this.memberId = memberId;

        // Defensive copy
        this.bookIds = bookIds.clone();
    }

    public String[] getBookIds() {

        // Defensive copy
        return bookIds.clone();
    }

    public LoanReceipt withCorrectedBookId(
        int index,
        String newId
    ) {

        String[] newBookIds = bookIds.clone();

        newBookIds[index] = newId;

        return new LoanReceipt(memberId, newBookIds);
    }
}

class ReferenceOnlyLoanReceipt extends LoanReceipt {

    String roomNumber;

    public ReferenceOnlyLoanReceipt(
        String memberId,
        String[] bookIds,
        String roomNumber
    ) {
        super(memberId, bookIds);
        this.roomNumber = roomNumber;
    }
}

class CirculationLedger {

    static String branchCode;

    // Static block
    static {
        branchCode = "PT-001";
    }

    static String processNightlyCirculation(
        LoanReceipt[] receipts
    ) {

        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        for (int i = 0; i < receipts.length; i++) {

            if (receipts[i] == null) {

                nullSkipped++;

            } else {

                processed++;

                if (receipts[i]
                    instanceof ReferenceOnlyLoanReceipt) {

                    referenceOnly++;

                } else {

                    regular++;
                }
            }
        }

        return processed + " processed | " +
               nullSkipped + " null skipped | " +
               referenceOnly + " reference-only | " +
               regular + " regular";
    }
}

public class LoanReceiptDemo {

    public static void main(String[] args) {

        LoanReceipt receipt =
            new LoanReceipt(
                "LIB-8841",
                new String[]{"BK-100", "BK-101"}
            );

        // Test defensive copying
        String[] ids = receipt.getBookIds();

        ids[0] = "HACKED";

        System.out.println(
            receipt.getBookIds()[0]
        );

        // Test with-style method
        LoanReceipt corrected =
            receipt.withCorrectedBookId(
                1,
                "BK-102"
            );

        System.out.println(
            receipt.getBookIds()[1]
        );

        System.out.println(
            corrected.getBookIds()[1]
        );

        // Process batch
        LoanReceipt[] receipts = {

            new ReferenceOnlyLoanReceipt(
                "LIB-001",
                new String[]{"BK-200"},
                "Reading Room 3"
            ),

            null,

            new LoanReceipt(
                "LIB-002",
                new String[]{"BK-201"}
            )
        };

        System.out.println(
            CirculationLedger.processNightlyCirculation(
                receipts
            )
        );
    }
}