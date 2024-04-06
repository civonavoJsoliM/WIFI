package logic;
import java.util.regex.Pattern;

public class Checker {
    public boolean validOptionInput(String input) {
        Pattern pattern = Pattern.compile("^[abcABC]$");
        return pattern.matcher(input).find();
    }

    public boolean validInputNumber(String input) {
        Pattern pattern = Pattern.compile("[1-9]+");
        return pattern.matcher(input).find();
    }
}
