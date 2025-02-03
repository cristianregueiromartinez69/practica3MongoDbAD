package service.ficherojson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.entity.Equipo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class EscrituraLecturaJson {

    public <T> void writeFileJson(List<T> object, String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try{
            List<Map<String, Object>> jsonList = objectMapper.convertValue(object, new TypeReference<>() {});

            File file = new File(fileName + ".json");

            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, jsonList);
            System.out.println("Fichero de " + fileName + ".json" + " escrito correctamente");
        }catch(Exception e){
            System.out.println("Ups, escribir en el fichero " + fileName + ".json");
        }
    }

    public List<Map<String, Object>> readDataJson(String path){

        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.readValue(new File(path), mapper.getTypeFactory().constructCollectionType(List.class, Map.class));
        } catch (IOException e) {
            System.out.println("Ups, error al leer el " + path);
        }
        return null;
    }

    public <T> void auxReadObjects(List<T> objects) {
        for(T object : objects){
            System.out.println(object);
        }
    }
}
