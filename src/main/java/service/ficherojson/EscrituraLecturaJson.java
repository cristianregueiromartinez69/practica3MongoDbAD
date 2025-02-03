package service.ficherojson;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.util.List;

public class EscrituraLecturaJson {

    public <T> void writeFileJson(List<T> object, String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try{
            File file = new File(fileName + ".json");

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, object);
            System.out.println("Fichero de " + fileName + ".json" + " escrito correctamente");
        }catch(Exception e){
            System.out.println("Ups, escribir en el fichero " + fileName + ".json");
        }
    }
}
