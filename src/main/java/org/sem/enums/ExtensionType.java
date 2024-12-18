package org.sem.enums;

public enum ExtensionType {
    CSV("csv"),
    XLSX("xlsx");

    private final String value;

    ExtensionType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
