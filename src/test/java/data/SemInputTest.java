package data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sem.data.SemInput;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SemInputTest {

    @Test
    @DisplayName("SemInputBuilder Test")
    void semInputBuilderTest() {
        // given

        String fimeName = "filename";
        String sheetName = "sheetname";
        class User {
            private String name;
            private int age;

            public User(String name, int age) {
                this.name = name;
                this.age = age;
            }
        }
        List<User> userList = List.of(new User("user1", 10), new User("user2", 20));
        // when

        SemInput semInput = new SemInput.SemInputBuilder()
                .fileName(fimeName)
                .sheetName(sheetName)
                .dataList(userList)
                .build();

        SemInput semInput2 = new SemInput.SemInputBuilder()
                .dataList(userList)
                .build();
        // then

        assertEquals(semInput.getFileName(), fimeName);
        assertEquals(semInput.getSheetName(), sheetName);
        assertEquals(semInput.getDataList(), userList);

        assertEquals(semInput2.getFileName(), "excel.xlsx");
        assertEquals(semInput2.getSheetName(), "sheet1");


    }
}
