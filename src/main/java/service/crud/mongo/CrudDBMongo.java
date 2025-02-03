package service.crud.mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import config.MongoDBConnection;
import model.entity.Equipo;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CrudDBMongo {

    public void insertColecctionDb(List<Map<String, Object>> equiposList, List<Map<String, Object>> jugadoresList) {
        MongoDatabase mongoDatabase = MongoDBConnection.getConnectionMongoDB();

        MongoCollection<Document> collectionEquipos = mongoDatabase.getCollection("equipos");
        MongoCollection<Document> collectionJugadores = mongoDatabase.getCollection("jugadores");

        for(Map<String, Object> equipo : equiposList) {
            Document equipoDoc = new Document(equipo);
            collectionEquipos.insertOne(equipoDoc);
        }
        System.out.println("Documento de equipos insertado correctamente en mongo");

        for(Map<String, Object> jugador : jugadoresList) {
            Document jugadorDoc = new Document(jugador);
            collectionJugadores.insertOne(jugadorDoc);
        }
        System.out.println("Documento de jugados insertado correctamente en mongo");
    }

    /**
     * Metodo que lee las colecciones de paises mongoDB
     * @return la lista con los datos de la colección
     */
    public List<Map<String, Object>> getListaDePaises(String coleccion){

        //establecemos la conexión y obtenemos la coleccion para luego que retorne esa colección en un ArrayList
        MongoDatabase mongoDatabase = MongoDBConnection.getConnectionMongoDB();
        MongoCollection<Document> collectionPaises = mongoDatabase.getCollection(coleccion);

        return collectionPaises.find().into(new ArrayList<>());
    }
}
