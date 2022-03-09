import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TxtDoc extends Documents {
    private FileReader inputStream;
    private FileWriter outputStream;
    private ArrayList<String> wordList;
    public TxtDoc(String method, String file) throws FileNotFoundException, IOException {
        try {
            if(method.equalsIgnoreCase("read")) {
                inputStream = new FileReader(file);
                readDoc(inputStream);
            } else if(method.equalsIgnoreCase("write")) {
                outputStream = new FileWriter(file);
            } else throw new FileNotFoundException();

        } catch(FileNotFoundException e) {
            System.out.println(e);
        } catch(IOException e) {
            System.out.println(e);
        } 
    }

    public ArrayList<String> getWordList() {
        return wordList;
    }

    public void readDoc(FileReader inputStream) {
        Scanner tok = new Scanner(new BufferedReader(inputStream));

        wordList = new ArrayList<>();
        for(;tok.hasNext();) {
            String word = tok.next();
            if(!isNumeric(word)) {
                wordList.add(word.toLowerCase());
            }    
        }
    }

    // TODO
    public void writeDoc(FileWriter outputStream) {

    }

    private boolean isNumeric(String tok) {
        for(char c: tok.toCharArray()) {
            if(Character.isDigit(c))
                return true;
        }
        return false;
    }
}
