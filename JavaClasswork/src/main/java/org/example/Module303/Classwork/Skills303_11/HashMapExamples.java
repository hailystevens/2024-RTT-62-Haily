package org.example.Module303.Classwork.Skills303_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapExamples {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        Map<String,String> stringMap = new HashMap<>();

        stringMap.put("key", "value");
        stringMap.put("key2", "value2");
        stringMap.put(null, "actual value");
        stringMap.put("null value", null);
        stringMap.put("null value1", null);

        stringMap.put(null, "actual value 1234");
        stringMap.put("key", "value 1234");



        String value = stringMap.get("key");
        System.out.println(value);

        for (String key : stringMap.keySet()) {
            System.out.println(key + "*==*" + stringMap.get(key));

        }

        List<String> maplist = new ArrayList<>();

        Map<Integer, String> intMap = new HashMap<>();
        intMap.put(10, "ten");

    }
}
