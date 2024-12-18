package org.sem.data;

import java.util.List;

public class SemInput {
    private SemInput(SemInputBuilder builder) {
        this.fileName = builder.fileName;
        this.sheetName = builder.sheetName;
        this.dataList = builder.dataList;
    }

    private final String fileName;
    private final String sheetName;
    private final List<?> dataList;

    public String getFileName() {
        return this.fileName;
    }

    public String getSheetName() {
        return this.sheetName;
    }

    public List<?> getDataList() {
        return this.dataList;
    }


    public static class SemInputBuilder {
        private String fileName = "excel.xlsx";
        private String sheetName = "sheet1";
        private List<?> dataList;

        public SemInputBuilder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public SemInputBuilder sheetName(String sheetName) {
            this.sheetName = sheetName;
            return this;
        }

        public SemInputBuilder dataList(List<?> dataList) {
            this.dataList = dataList;
            return this;
        }

        public SemInput build() {
            return new SemInput(this);
        }
    }


}
