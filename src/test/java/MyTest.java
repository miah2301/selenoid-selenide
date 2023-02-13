import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class MyTest {
    @Test
    public void myTest(){
        Driver.initDriver();
        open("https://yandex.ru");
        Selenide.sleep(1000);
        open("https://google.com");
        Selenide.sleep(5000);
    }
}
