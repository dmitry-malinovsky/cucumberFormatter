package stepdefs;

import java.util.HashMap;

public class ScenarioContext {
    private static HashMap<String, Object> data = new HashMap<String, Object>();

    public static void saveData(String key, Object value) {
        data.put(key, value);
    }

    public static Object getData(String key) {
        if (data.containsKey(key)) {
            return data.get(key);
        } else {
            return null;
        }
    }
}
