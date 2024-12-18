package org.sem.maker;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.sem.data.SemInput;
import org.sem.util.SemUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;

public class SimpleExcelMaker implements SimpleMaker {

    @Override
    public void make(SemInput input) {
        List<?> dataList = input.getDataList();

        Field[] fields = SemUtils.getFields(dataList);

        List<String> keyList = getKeyList(fields);

        List<Map<String, String>> itemList = new ArrayList<>();

        for (Object item : dataList) {
            Map<String, String> itemMap = new HashMap<>();

            for (Field field : fields) {
                field.setAccessible(Boolean.TRUE);
                try {
                    itemMap.put(field.getName(), field.get(item).toString());
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            itemList.add(itemMap);
        }

        try (Workbook workbook = new XSSFWorkbook();
             FileOutputStream fos = new FileOutputStream(input.getFileFullName())) {
            Sheet sheet = workbook.createSheet(input.getSheetName());

            int rowNum = 0;
            Row headerRow = sheet.createRow(rowNum++);

            setHeaders(headerRow, keyList);

            for (Map<String, String> map : itemList) {
                Row row = sheet.createRow(rowNum++);
                int cellNum = 0;
                for (Field field : fields) {
                    Cell cell = row.createCell(cellNum++);
                    cell.setCellValue(map.get(field.getName()));
                }
            }
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<String> getKeyList(Field[] fields) {
        return Arrays.stream(fields).map(Field::getName).toList();
    }

    void setHeaders(Row row, List<String> keyList) {
        int i = 0;
        for (String key : keyList) {
            Cell cell = row.createCell(i++);
            cell.setCellValue(key);
        }
    }


}
