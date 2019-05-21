/**
 * @Author Emily Martinez
 * @version 1.0
 * Aplicacion para cargar notas de un TXT
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class NoteStorage {
    private StorageService storageService;
    private Stream<String> contenido;
    public NoteStorage(StorageService storageService){
        this.storageService = storageService;
    }

    public void loadNotes(){
    storageService.load_Data();
    contenido = storageService.getData();
    }
    public Stream<String> getContenido(){
        return contenido;
    }
    public void print(){
        contenido.forEach(System.out::println);
    }
}
