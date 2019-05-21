/**
 * @Author Emily Martinez
 * @version 1.0
 * Aplicacion para cargar notas de un TXT
 */


public class NoteStorage {
    private StorageService storageService;

    public NoteStorage(StorageService storageService){
        this.storageService = storageService;
    }

    public void loadNotes(){
    storageService.load_Data();
    }
}
