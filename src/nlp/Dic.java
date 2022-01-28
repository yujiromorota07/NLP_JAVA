package nlp;

import java.util.Map;

public class Dic {

    public static void get(Map<String, String> map) {
        map.put("I", "NOUN");
        map.put("saw", "VERB");
        map.put("a", "DET");
        map.put("girl", "NOUN");
        map.put("with", "PREP");
        map.put("telescope", "NOUN");
    }

    public static void print() {
        System.out.println("yeees");
    }
}