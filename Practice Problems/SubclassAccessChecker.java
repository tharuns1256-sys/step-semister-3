class SubclassAccessChecker {

    static String classifyAccess(String modifier, String context) {

        if (context.equals("SAME_CLASS")) {
            return "ALLOWED";
        }

        if (context.equals("SAME_PACKAGE")) {

            if (modifier.equals("private")) {
                return "DENIED";
            }

            return "ALLOWED";
        }

        if (context.equals("DIFFERENT_PACKAGE")) {

            if (modifier.equals("public")) {
                return "ALLOWED";
            }

            return "DENIED";
        }

        if (context.equals("SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE")) {

            if (modifier.equals("protected") ||
                modifier.equals("public")) {
                return "ALLOWED";
            }

            return "DENIED";
        }

        if (context.equals("SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE")) {

            if (modifier.equals("public")) {
                return "ALLOWED";
            }

            return "DENIED";
        }

        return "DENIED";
    }
}

public class SubclassAccessDemo {

    public static void main(String[] args) {

        System.out.println(
            SubclassAccessChecker.classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_OWN_TYPE"
            )
        );

        System.out.println(
            SubclassAccessChecker.classifyAccess(
                "protected",
                "SUBCLASS_DIFFERENT_PACKAGE_PARENT_TYPE"
            )
        );
    }
}