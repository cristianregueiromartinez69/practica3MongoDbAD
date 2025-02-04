package service.ficherojson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Clase con los metodos de escritura y lectura para los ficheros JSON
 * @author cristian
 * @version 1.0
 */
public class EscrituraLecturaJson {

    /**
     * Metodo genérico para escribir en un archivo JSON
     * @param object la lista de objetos que le vamos a pasar
     * @param fileName el path del archivo
     * @param <T> el tipo de objeto
     */
    public <T> void writeFileJson(List<T> object, String fileName) {

        //creamos el objetMapper
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());

        try{

            //tenemos que convertir la lista en un list<Map> para luego meterlo en mongo
            List<Map<String, Object>> jsonList = objectMapper.convertValue(object, new TypeReference<>() {});

            //establecemos el path del archivo
            File file = new File(fileName + ".json");

            //escribimos los valores en el json
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file, jsonList);
            System.out.println("Fichero de " + fileName + ".json" + " escrito correctamente");
        }catch(Exception e){
            System.out.println("Ups, escribir en el fichero " + fileName + ".json");
        }
    }

    /**
     * Metodo para leer los datos de un archivo JSON
     * @param path el path del archivo
     * @return la lista de objetos
     */
    public List<Map<String, Object>> readDataJson(String path){

        ObjectMapper mapper = new ObjectMapper();
        try{
            return mapper.readValue(new File(path), mapper.getTypeFactory().constructCollectionType(List.class, Map.class));
        } catch (IOException e) {
            System.out.println("Ups, error al leer el " + path);
        }
        return null;
    }


}
