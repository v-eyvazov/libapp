package az.lib.libapp.utilities;


public class Extract {
    public static Integer extractId(String nameAndID) {
        return Integer.valueOf(
                nameAndID.
                        substring(
                                nameAndID.indexOf(":") + 1,
                                nameAndID.indexOf("]")
                        ));
    }
}
