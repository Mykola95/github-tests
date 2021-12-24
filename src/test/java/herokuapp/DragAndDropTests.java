package herokuapp;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void checkDragAndDrop () {
        open("/drag_and_drop");
        $$("#columns .column").shouldHave(texts("A", "B"));

        $("#column-a").dragAndDropTo($("#column-b"));
        $$("#columns .column").shouldHave(texts("B", "A"));
    }
}
