package org.sem.maker;

import org.sem.data.SemInput;

public class ObjectExcelMaker implements SimpleExcelMaker {
    private final String DEFAULT_FILE_NAME = "excel.xlsx";
    private final String DEFAULT_SHEET_NAME = "sheet1";

    @Override
    public void makeExcel(SemInput input) {

    }

    public void nameSet(SemInput input) {
        input.fileName(DEFAULT_FILE_NAME);
        input.sheetName(DEFAULT_SHEET_NAME);
    }
}
