package org.sem.maker;

import org.sem.data.SemInput;
import org.sem.util.SemUtils;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleCsvMaker implements SimpleMaker {

    @Override
    public void make(SemInput input) {
        List<?> dataList = input.getDataList();

        Field[] fields = SemUtils.getFields(dataList);

        List<String> keyList = getKeyList(fields);

        try (FileWriter writer = new FileWriter(input.getFileFullName())) {
            writer.append(String.join(",", keyList));
            writer.append("\n");

            for (Object item : dataList) {
                List<String> row = new ArrayList<>();
                for (Field field : fields) {
                    field.setAccessible(Boolean.TRUE);
                    row.add(field.get(item).toString());
                }
                writer.append(String.join(",", row));
                writer.append("\n");
            }
        } catch (IOException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getKeyList(Field[] fields) {
        return Arrays.stream(fields).map(Field::getName).toList();
    }

}
