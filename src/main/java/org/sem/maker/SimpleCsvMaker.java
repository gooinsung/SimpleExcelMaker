package org.sem.maker;

import org.sem.data.SemInput;

import java.lang.reflect.Field;
import java.util.List;

public class SimpleCsvMaker implements SimpleMaker {
    private final String DEFAULT_FILE_NAME = "excel.csv";

    @Override
    public void make(SemInput input) {

    }

    @Override
    public List<String> getKeyList(Field[] fields) {
        return null;
    }

}
