package szi.data;

/**
 * Created with IntelliJ IDEA.
 * User: Guest
 * Date: 18.04.16
 * Time: 15:01
 * To change this template use File | Settings | File Templates.
 */
public class Weather {

    private static String type;
    public static String RAIN = "rain";
    public static String SUN = "sun";

    public static void Change() {
        if (type == SUN) {
            type = RAIN;
        } else {
            type = SUN;
        }
    }

    public static String getType() {
        return type;
    }
}
