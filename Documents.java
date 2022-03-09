import java.io.FileReader;
import java.io.FileWriter;

public abstract class Documents {
    abstract void readDoc(FileReader inputStream);
    abstract void writeDoc(FileWriter outputStream);
}
