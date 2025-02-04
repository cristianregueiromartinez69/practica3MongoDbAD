package service.crud.mongo;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import config.MongoDBConnection;
import model.entity.Equipo;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Clase para realizar los crud sobre colecciones de mongo
 * @author cristian
 * @version 1.0
 */
public class CrudDBMongo {

    /**
     * metodo para insertar datos en 2 colecciones de mongoDB
     * @param equiposList la lista de equipos a insertar
     * @param jugadoresList la lista de jugadores a insertar
     */
    public void insertColecctionDb(List<Map<String, Object>> equiposList, List<Map<String, Object>> jugadoresList) {

        //recibimos la conexion de la base de mongo
        MongoDatabase mongoDatabase = MongoDBConnection.getConnectionMongoDB();

        //recibimos las 2 colecciones de la base de mongo
        MongoCollection<Document> collectionEquipos = mongoDatabase.getCollection("equipos");
        MongoCollection<Document> collectionJugadores = mongoDatabase.getCollection("jugadores");

        //con un for, metemos los datos uno a uno en las colecciones
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
     * Metodo que lee las colecciones  mongoDB
     * @return la lista con los datos de la colección
     */
    public List<Map<String, Object>> getListaColeccion(String coleccion){

        //establecemos la conexión y obtenemos la coleccion para luego que retorne esa colección en un ArrayList
        MongoDatabase mongoDatabase = MongoDBConnection.getConnectionMongoDB();
        MongoCollection<Document> collectionPaises = mongoDatabase.getCollection(coleccion);

        return collectionPaises.find().into(new ArrayList<>());
    }


}
