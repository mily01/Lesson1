import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileStorageService implements StorageService{

    private String fileName;
    private boolean errorName;
    private Stream<String> Data;
    public FileStorageService(String filename){
        if(filename.contains(".txt") || filename.contains(".TXT") ){
            errorName = false;
        }
        else{
            errorName = true;
        }
        this.fileName = filename;
    }
    public String getName(){
        return fileName;
    }

    @Override
    public void load_Data() {
        if(errorName) return;
        try {
            Data = Files.lines(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
