class ReferenceAccessChecker {

    static String classifyAccess(String modifier, String context) {

        if (context.equals("SAME_CLASS")) {
            return "ALLOWED";
        }

        if (context.equals("SAME_PACKAGE")) {

            if (modifier.equals("private"))
                return "DENIED";
            else
                return "ALLOWED";
        }

        if (context.equals("DIFFERENT_PACKAGE")) {

            if (modifier.equals("public"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        if (context.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {

            if (modifier.equals("protected") ||
                modifier.equals("public"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        if (context.equals("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {

            if (modifier.equals("public"))
                return "ALLOWED";
            else
                return "DENIED";
        }

        return "DENIED";
    }

    static String firstDeniedAttempt(String[][] attempts) {

        for (int i = 0; i < attempts.length; i++) {

            String modifier = attempts[i][0];
            String context = attempts[i][1];

            if (classifyAccess(modifier, context).equals("DENIED")) {

                return modifier + " via " +
                       context + " (attempt #" + (i + 1) + ")";
            }
        }

        return "None Denied";
    }
}

public class ReferenceDeskDemo {

    public static void main(String[] args) {

        String[][] attempts = {
            {"public", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"},
            {"protected", "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"}
        };

        System.out.println(
            ReferenceAccessChecker.firstDeniedAttempt(attempts)
        );
    }
}