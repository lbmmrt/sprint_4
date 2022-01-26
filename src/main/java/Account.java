import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    String regexp = "^(?=.{3,19}$)[а-яёА-ЯЁa-zA-Z]+\\s[а-яёА-ЯЁa-zA-Z]+$";
    Pattern pattern = Pattern.compile(regexp);


    public boolean checkNameToEmboss() {
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}