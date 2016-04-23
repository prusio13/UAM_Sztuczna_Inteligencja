package szi.data;

import java.util.Random;

public class Weather{

    public static final String RAIN = "rain";
    public static final String SUN = "sun";
    private static String type = RAIN;

    private static String icon = System.getProperty("user.dir") + "\\src\\graphics\\Info\\" + RAIN + ".jpg";;

    public static void change() {
        if (type == SUN) {
            type = RAIN;
        } else {
            type = SUN;
        }
        icon = System.getProperty("user.dir") + "\\src\\graphics\\Info\\" + type + ".jpg";
    }

    public static String getType() {
        return type;
    }

    public static String getIcon() {
        return icon;
    }

    public static void tryChangeWeather() {
        Random generator = new Random();
        int random = 10 - generator.nextInt(10);
        if (random > 5) {
            change();
        }
        Time.counter = 0;
    }

}
