package com.training.emilylesson2.services;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
@Component
public class FileStorageService implements StorageService{

    private static final Logger LOG = LoggerFactory.getLogger(FileStorageService.class);

    @Override
    public void save(String text) {

        LOG.debug("save method called with text");

        File file = getFile();
        try {
            FileUtils.writeStringToFile(file, text, Charset.defaultCharset());
            LOG.debug("Save method completed successfully");
        }catch (IOException e){
            e.printStackTrace();
            LOG.error ("Se ha producido un error al guardar contenido en el storage", e);
        }
    }

    @Override
    public String load() {
        LOG.debug("load method called");

        File file = getFile();
        try {
           String text = FileUtils.readFileToString(file, Charset.defaultCharset());

            LOG.debug("Load Method completed successfully");
            return text;
        } catch (IOException e) {
            LOG.error("Se ha producido un error al cargar contenido desde storage", e);
            return "";

        }
    }

    private File getFile() {
        return new File("storage.txt");
    }
}
