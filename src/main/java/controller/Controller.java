package controller;

import model.entity.Equipo;
import model.entity.Xogadores;
import service.crud.metodosmongo.LecturaDatos;
import service.crud.mongo.CrudDBMongo;
import service.crud.postgres.CrudDbPostgres;
import service.ficherojson.EscrituraLecturaJson;
import service.metodospostgres.MetodosEquipo;
import service.metodospostgres.MetodosJugador;

import java.util.List;
import java.util.Map;

/**
 * Clase controller con la lógica de la aplicación
 * @author cristian
 * @version 1.0
 */
public class Controller {

    //metodo con la logica del programa
    public void logicaPrograma(){
        CrudDbPostgres crudBases = new CrudDbPostgres();
        MetodosEquipo metodosEquipo = new MetodosEquipo();
        MetodosJugador metodosJugador = new MetodosJugador();
        EscrituraLecturaJson elJson = new EscrituraLecturaJson();
        CrudDBMongo crudMongo = new CrudDBMongo();
        LecturaDatos lecturaDatos = new LecturaDatos();

        //inserccion de datos en postgresSQL
        crudBases.insertDataDB(metodosEquipo.creacionObjetosEquipos());
        crudBases.insertDataDB(metodosJugador.creacionObjetosJugadores(crudBases.getDataFromDB("FROM Equipo", Equipo.class)));


        //lectura de datos con escritura de los mismos en JSON
        elJson.writeFileJson(crudBases.getDataFromDB("FROM Equipo", Equipo.class), "equipos");
        elJson.writeFileJson(crudBases.getDataFromDB("FROM Xogadores", Xogadores.class), "xogadores");



        //obtenemos un List Map con los datos de los JSON
        List<Map<String, Object>> equiposList = elJson.readDataJson("equipos.json");
        List<Map<String, Object>> jugadorList = elJson.readDataJson("xogadores.json");

        //insertamos los datos en las colecciones de mongo
        crudMongo.insertColecctionDb(equiposList, jugadorList);

        //leemos los datos de la base de mongoDB
        lecturaDatos.lecturaDatosEquipos(crudMongo.getListaColeccion("equipos"));
        lecturaDatos.lecturaDatosJugadores(crudMongo.getListaColeccion("jugadores"));


    }


}
