package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordVerifier implements IPasswordVerifier {
    private final int minLength;
    private final boolean requireBothCaps;
    private final boolean requireNumbers;
    private final boolean requireSymbols;

    public PasswordVerifier(int minLength, boolean requireBothCaps, boolean requireNumbers, boolean requireSymbols){
        this.minLength = minLength;
        this.requireBothCaps = requireBothCaps;
        this.requireNumbers = requireNumbers;
        this.requireSymbols = requireSymbols;
    }
    @Override
    public int calculate(String password){
        int points = 0;
        points += calculatePointsLength(password);
        points += calculatePointsCaps(password);
        points += calculatePointsNumbers(password);
        points += calculatePointsSymbols(password);
        points = calculateExtraPoints(points);
        return points;
    }

    private int calculatePointsLength(String password){
        int length = password.length();
        if (length >= 7 && length <= 8) return 1;
        else if (length >= 9 && length <= 12) return 12;
        else if (length > 12) return 3;
        return 0;
    }

    private int calculatePointsCaps(String password){
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z]).+$");
        Matcher matcher = pattern.matcher(password);
        if (requireBothCaps && matcher.matches()) return 3;
        else if (!requireBothCaps && (onlyMajus(password) || (onlyMinus(password)))) return 1;
        return 0;
    }

    private int calculatePointsNumbers(String password){
        if(requireNumbers && password.matches(".*\\d.*")) return 1;
        return 0;
    }

    private int calculatePointsSymbols(String password){
        if(requireSymbols && password.matches(".*[!@#$&^*()-_+?¡¿].*")) return 2;
        return 0;
    }


    private int calculateExtraPoints(int points){
        if (points == 9) {
            points = 10;
        }
        return points;
    }

    private boolean onlyMajus(String password){
        return password.equals(password.toUpperCase());
    }

    private boolean onlyMinus(String password){
        return password.equals(password.toLowerCase());
    }

}

