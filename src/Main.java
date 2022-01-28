
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import nlp.*;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        List<String> wordlist = new ArrayList<>();
        List<String> typelist = new ArrayList<>();

        Dic.get(map);
        try {
            File f = new File("sentence.txt");
            BufferedReader br = new BufferedReader(new FileReader(f));

            String line = br.readLine();
            while (line != null) {
                System.out.println(line);
                String[] words = line.split(" ", 0);
                line = br.readLine();
                wordlist.add("");
                typelist.add("START");
                for (int i = 0; i < words.length; i++) {
                    wordlist.add(words[i]);
                    typelist.add(map.get(words[i]));
                }
                wordlist.add("");
                typelist.add("END");

                int index = Network.check(0, typelist);
                for (int i = 0; i <= index; i++) {
                    for (int j = 0; j <= i; j++) {
                        System.out.print(typelist.get(j));
                        if (j != i) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println("\n");
                }
                if (typelist.size() - 1 == index) {
                    System.out.println("これは正文です。");
                } else {
                    System.out.println("これは正文ではありません.");
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}