package example.csv;

import example.User;
import org.sem.data.SemInput;
import org.sem.enums.ExtensionType;
import org.sem.maker.SimpleCsvMaker;

import java.util.List;

public class CsvExample {
    public static void main(String[] args) {
        List<User> userList = List.of(
                new User("Alice", 20, "Seoul", "010-1234-5678"),
                new User("Bob", 30, "Busan", "010-2345-6789"),
                new User("Charlie", 40, "Daegu", "010-3456-7890"),
                new User("David", 50, "Incheon", "010-4567-8901"),
                new User("Edward", 60, "Gwangju", "010-5678-9012")
        );

        SemInput input = new SemInput.SemInputBuilder()
                .fileName("csv_file")
                .sheetName("csv_sheet")
                .dataList(userList)
                .extensionType(ExtensionType.CSV)
                .build();

        SimpleCsvMaker maker = new SimpleCsvMaker();
        maker.make(input);
    }
}
