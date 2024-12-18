package org.sem.maker;

import org.sem.data.SemInput;

import java.lang.reflect.Field;
import java.util.List;

public interface SimpleMaker {
    void make(SemInput input);

    List<String> getKeyList(Field[] fields);
}
