package nlp;

import java.util.List;

public class Network {

    public static int check(int index, List<String> list) {
        if (index == (list.size() - 1)) {
            return index;
        } else {
            String current = list.get(index);
            String forward = list.get(index + 1);
            if (check_connection(current, forward) == true) {
                return check(index + 1, list);
            } else {
                return index;
            }
        }
    }

    public static boolean check_connection(String current, String forward) {
        if (current == "START") {
            if (forward != "DET" && forward != "NOUN") {
                return false;
            }
        }

        if (current == "DET") {
            if (forward != "ADJ" && forward != "NOUN") {
                return false;
            }
        }

        if (current == "NOUN") {
            if (forward != "DET" && forward != "PREP" && forward != "VERB" && forward != "ADV" && forward != "END") {
                return false;
            }
        }

        if (current == "PREP") {
            if (forward != "DET" && forward != "NOUN" && forward != "ADJ") {
                return false;
            }
        }

        if (current == "ADV") {
            if (forward != "NOUN" && forward != "PREP") {
                return false;
            }
        }

        if (current == "VERB") {
            if (forward != "ADV" && forward != "DET" && forward == "END") {
                return false;
            }
        }

        if (current == "ADJ") {
            if (forward != "NOUN") {
                return false;
            }
        }
        return true;
    }

    // }
}
