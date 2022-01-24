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
                {"Майкл Скотт", true},
                {"Рн", false},
                {"Рыванркнвд мисвтвоыаеднр", false},
                {"Майкл Скотт ", false},
                {" Майкл Скотт", false},
        };
    }

    @Mock
    Account account;

    @Test
    public void  checkValidationName() {
        account =  new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals(actual, expected);
    }

}
