import java.util.stream.Stream;
public interface StorageService {
    public void load_Data();
    public Stream<String> getData();
    public String getName();

}
