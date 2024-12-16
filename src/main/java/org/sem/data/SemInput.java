package org.sem.data;

import java.util.List;

public class SemInput {
    private SemInput() {
    }

    private String fileName;
    private String sheetName;
    private List<?> dataList;

    public String getFileName() {
        return this.fileName;
    }

    public String getSheetName() {
        return this.sheetName;
    }

    public List<?> getDataList() {
        return this.dataList;
    }

    public static SemInput builder() {
        return new SemInput();
    }

    public void fileName(String fileName) {
        if (this.fileName == null || this.fileName.length() == 0) {
            this.fileName = fileName;
        }
    }

    public void dataList(List<?> dataList) {
        this.dataList = dataList;
    }

    public void sheetName(String sheetName) {
        if (this.sheetName == null || this.sheetName.length() == 0) {
            this.sheetName = sheetName;
        }
    }

}
