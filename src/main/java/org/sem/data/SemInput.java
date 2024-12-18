package org.sem.data;

import org.sem.enums.ExtensionType;

import java.util.List;

public class SemInput {
    private SemInput(SemInputBuilder builder) {
        this.fileName = builder.fileName;
        this.sheetName = builder.sheetName;
        this.dataList = builder.dataList;
        this.extensionType = builder.extensionType;
    }

    private final String fileName;
    private final String sheetName;
    private final List<?> dataList;
    private final ExtensionType extensionType;

    public String getFileName() {
        return this.fileName;
    }

    public String getSheetName() {
        return this.sheetName;
    }

    public List<?> getDataList() {
        return this.dataList;
    }

    public String getFileFullName() {
        return this.fileName + "." + extensionType.getValue();
    }

    public ExtensionType getExtensionType() {
        return this.extensionType;
    }


    public static class SemInputBuilder {
        private String fileName = "excel.xlsx";
        private String sheetName = "sheet1";
        private List<?> dataList;
        private ExtensionType extensionType = ExtensionType.XLSX;

        public SemInputBuilder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }

        public SemInputBuilder sheetName(String sheetName) {
            this.sheetName = sheetName;
            return this;
        }

        public SemInputBuilder dataList(List<?> dataList) {
            if (dataList.isEmpty()) {
                throw new IllegalArgumentException("Data list cannot be empty");
            }
            this.dataList = dataList;
            return this;
        }

        public SemInputBuilder extensionType(ExtensionType extensionType) {
            this.extensionType = extensionType;
            return this;
        }

        public SemInput build() {
            return new SemInput(this);
        }
    }


}
