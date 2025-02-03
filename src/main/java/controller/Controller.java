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

public class Controller {

    public void logicaPrograma(){
        CrudDbPostgres crudBases = new CrudDbPostgres();
        MetodosEquipo metodosEquipo = new MetodosEquipo();
        MetodosJugador metodosJugador = new MetodosJugador();
        EscrituraLecturaJson elJson = new EscrituraLecturaJson();
        CrudDBMongo crudMongo = new CrudDBMongo();
        LecturaDatos lecturaDatos = new LecturaDatos();

        /*Inserccion de datos
        crudBases.insertDataDB(metodosEquipo.creacionObjetosEquipos());
        crudBases.insertDataDB(metodosJugador.creacionObjetosJugadores(crudBases.getDataFromDB("FROM Equipo", Equipo.class)));
         */


        elJson.writeFileJson(crudBases.getDataFromDB("FROM Equipo", Equipo.class), "equipos");
        elJson.writeFileJson(crudBases.getDataFromDB("FROM Xogadores", Xogadores.class), "xogadores");




        List<Map<String, Object>> equiposList = elJson.readDataJson("equipos.json");
        List<Map<String, Object>> jugadorList = elJson.readDataJson("xogadores.json");

        crudMongo.insertColecctionDb(equiposList, jugadorList);

        lecturaDatos.lecturaDatosEquipos(crudMongo.getListaColeccion("equipos"));
        lecturaDatos.lecturaDatosJugadores(crudMongo.getListaColeccion("jugadores"));


    }


}
