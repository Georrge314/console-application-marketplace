package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringValidator {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
    private static final String PASSWORD_REGEX = "(?=.*[0-9])(?=.*[A-Z])(?=.*[a-z])(?=.*[\\W])(?=\\S+$).{8,15}";
    private static final String PICTURE_REGEX = "^(https?|ftp|file):\\/\\/[-a-zA-Z0-9+&@#\\/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#\\/%=~_|]";

    public static boolean isValidPassword(String password) {
        Pattern pattern = Pattern.compile(PASSWORD_REGEX);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidPictureUrl(String pictureUrl) {
        Pattern pattern = Pattern.compile(PICTURE_REGEX);
        Matcher matcher = pattern.matcher(pictureUrl);
        return matcher.matches();
    }
}
