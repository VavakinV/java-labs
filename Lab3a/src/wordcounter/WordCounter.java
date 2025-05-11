package wordcounter;

import java.util.HashMap;
import java.util.Map;

public class WordCounter {
    private String text;
    private HashMap<String, Integer> map = new HashMap<>();

    public String getText(){
        return text;
    }

    public void setText(String text){
        this.text = text;
    }

    public void calculate(){
        for (String word : text.split(" ")){
            String lword = word.toLowerCase();
            if (map.containsKey(lword)){
                map.put(lword, map.get(lword) + 1);
            }
            else {
                map.put(lword, 1);
            }
        }
    }

    @Override
    public String toString(){
        String result = "";
        for (Map.Entry<String, Integer> entry: map.entrySet()){
            result += "word: " + entry.getKey() + "; count: " + entry.getValue() + "\n";
        }
        return result;
    }
}
