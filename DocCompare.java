import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class DocCompare {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        if(args.length != 2) {
            System.out.println("usage <doc1.txt> <doc2.txt>");
            System.exit(-1);
        }
        
        TxtDoc firstDoc = new TxtDoc("read", args[0]);
        HashMap<String, Integer> map1 = fillMap(firstDoc);

        TxtDoc secondDoc = new TxtDoc("read", args[1]);
        HashMap<String, Integer> map2 = fillMap(secondDoc);

        compareDocs(map1, map2);

    }

    public static void compareDocs(HashMap<String, Integer> map1, HashMap<String, Integer> map2) {
        for(String s: map2.keySet()) {
            if(!map1.containsKey(s)) {
                System.out.println("****NEW WORD****:\t" + s);
            } 
        }

        for(String s: map1.keySet()) {
            if(!map2.containsKey(s)) {
                System.out.println("****DELETED****:\t" + s);
            } else {
                if(map2.get(s) > map1.get(s)) {
                    System.out.println("\tADDED " + (map2.get(s) - map1.get(s)) + " MORE OF:\t" + s);
                } else if(map2.get(s) < map1.get(s)) {
                    System.out.println("\tDELETED " + (map1.get(s) - map2.get(s)) + " OF:\t" + s);
                }
            }
        }
        
    }

    public static HashMap<String, Integer> fillMap(TxtDoc doc) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < doc.getWordList().size(); i++) {
            if(map.containsKey(doc.getWordList().get(i))) {
                map.put(doc.getWordList().get(i), map.get(doc.getWordList().get(i)) + 1);
            } else {
                map.put(doc.getWordList().get(i), 1);
            }
        }

        return map;
    }
}