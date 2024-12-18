package maker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sem.data.SemInput;
import org.sem.maker.SimpleExcelMaker;
import test.User;

import java.util.List;

class SimpleExcelMakerTest {

    @Test
    @DisplayName("Test make")
    void makeTest() {
        // given

        List<User> userList = List.of(new User("Alice", 20), new User("Bob", 30));
        String fileName = "test";
        String sheetName = "sheet1";

        SemInput input = new SemInput.SemInputBuilder()
                .fileName(fileName)
                .sheetName(sheetName)
                .dataList(userList)
                .build();
        // when
        SimpleExcelMaker maker = new SimpleExcelMaker();
        maker.make(input);
        // then


    }
}
