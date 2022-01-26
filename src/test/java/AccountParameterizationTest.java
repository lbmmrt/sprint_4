import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountParameterizationTest {

    private final String name;
    private final boolean expected;

    public AccountParameterizationTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getName() {
        return new Object[][]{
                {"Майкл Скотт", true}, // один пробел в середине
                {"Майкл  Скотт", false}, // два пробела в середине
                {"Майкл Скотт ", false}, // пробел в конце
                {" Майкл Скотт", false}, // пробел в начале
                {"Рн", false}, // меньше 3 символов
                {"Рыванркнвд мисвтвоыаеднр", false}, // больше 19 символов
                {"Рыванркнвд мисвтвшш", true}, // 19 символов
                {"", false}, // пустая строка
                {"             ", false}, // пробелы
                {"Я Л", true}, // 3 символа
                {"МАЙЛ СКОТТ", true}, // верхний регистр
                {"майкл скотт", true}, // нижний регистр
                {"Michael Scott", true}, // латинские буквы
                {"Майкл Скотт!", false}, // буквы со спец. символами
                {"! ))", false}, // спец.символы
                {"123 234", false}, // цифры

        };
    }

    @Mock
    Account account;

    @Test
    public void checkValidationName() {
        account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(actual, expected);
    }
}
