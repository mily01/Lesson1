package com.training.emilylesson2.services;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

@Component("MemoryStorage")
public class MemoryStorage  implements StorageService{
     private static File archivo = new File("storage.txt");
    private static final Logger LOG =  LoggerFactory.getLogger(MemoryStorage.class);
    @Override
    public void save(String text) {
        LOG.debug("Iniciando guardado de MemoryStorage");
        try {
            FileUtils.writeStringToFile(archivo, text, Charset.defaultCharset());
        } catch (IOException e) {
            LOG.error("Ocurrio un error al escribir sobre el archivo en MemoryStorage", e);

        }
        LOG.debug("Finalizo el guardado MemoryStorage");

    }

    @Override
    public String load() {
        LOG.debug("Iniciando la carga de informacion de MemoryStorage");

        try {
            String text = FileUtils.readFileToString(archivo, Charset.defaultCharset());
            LOG.debug("Carga de informacion con exito MemoryStorage");
            return text;
        } catch (IOException e) {
            LOG.error("Ocurrio un error al leer el contenido del archivo");
            return "";
        }
    }
}
