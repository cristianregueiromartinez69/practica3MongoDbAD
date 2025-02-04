package config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

/**
 * Clase que sirve para establecer la conexion con la base de datos de mongoDB
 * @author cristian
 * @version 1.0
 */
public class MongoDBConnection {

    /**
     * variables provadas, estáticas y finales de la url donde está la base de mongo en la nube y el nombre de la base de datos
     */
    private static final String connectionMongoDb = "mongodb+srv://mongo:mongo@proyectoad.xgtsf.mongodb.net/?retryWrites=true&w=majority&appName=ProyectoAD";
    private static final String databaseName = "dbfutbol";

    /**
     * Metodo que crea la conexión a mongo con las variables anteriores
     * @return la base de datos de mongo
     */
    public static MongoDatabase getConnectionMongoDB(){
        MongoClient mongoClient = MongoClients.create(connectionMongoDb);
        System.out.println("Conexion exitosa con la base de datos de mongo db");
        return mongoClient.getDatabase(databaseName);

    }

}
