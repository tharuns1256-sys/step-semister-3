class LibraryMember {
    private String membershipPin;
    String branchCode;
    protected double finesOwed;
    public String displayName;
}

class AccessChecker {

    static String classifyAccess(String modifier, String context) {

        if (modifier.equals("private")) {
            if (context.equals("SAME_CLASS"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        if (modifier.equals("default")) {
            if (context.equals("SAME_CLASS") ||
                context.equals("SAME_PACKAGE"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        if (modifier.equals("protected")) {
            if (context.equals("SAME_CLASS") ||
                context.equals("SAME_PACKAGE"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        if (modifier.equals("public")) {
            return "ALLOWED";
        }

        return "DENIED";
    }

    static String summarizeByModifier(String[][] attempts) {

        int privateAllowed = 0, privateDenied = 0;
        int defaultAllowed = 0, defaultDenied = 0;
        int protectedAllowed = 0, protectedDenied = 0;
        int publicAllowed = 0, publicDenied = 0;

        for (int i = 0; i < attempts.length; i++) {

            String modifier = attempts[i][0];
            String context = attempts[i][1];

            String result = classifyAccess(modifier, context);

            if (modifier.equals("private")) {
                if (result.equals("ALLOWED"))
                    privateAllowed++;
                else
                    privateDenied++;
            }
            else if (modifier.equals("default")) {
                if (result.equals("ALLOWED"))
                    defaultAllowed++;
                else
                    defaultDenied++;
            }
            else if (modifier.equals("protected")) {
                if (result.equals("ALLOWED"))
                    protectedAllowed++;
                else
                    protectedDenied++;
            }
            else if (modifier.equals("public")) {
                if (result.equals("ALLOWED"))
                    publicAllowed++;
                else
                    publicDenied++;
            }
        }

        return "private: " + privateAllowed + " allowed / " +
               privateDenied + " denied | default: " +
               defaultAllowed + " allowed / " +
               defaultDenied + " denied | protected: " +
               protectedAllowed + " allowed / " +
               protectedDenied + " denied | public: " +
               publicAllowed + " allowed / " +
               publicDenied + " denied";
    }
}

public class MembershipCheckerDemo {

    public static void main(String[] args) {

        String[][] attempts = {
            {"private", "SAME_CLASS"},
            {"private", "SAME_PACKAGE"},
            {"default", "SAME_PACKAGE"},
            {"default", "DIFFERENT_PACKAGE"},
            {"protected", "SAME_PACKAGE"},
            {"protected", "SAME_CLASS"},
            {"public", "DIFFERENT_PACKAGE"}
        };

        System.out.println(
            AccessChecker.summarizeByModifier(attempts)
        );
    }
}