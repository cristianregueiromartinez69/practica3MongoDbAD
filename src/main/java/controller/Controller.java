package controller;

import model.entity.Equipo;
import model.entity.Xogadores;
import service.crud.CrudBases;
import service.ficherojson.EscrituraLecturaJson;
import service.metodospostgres.MetodosEquipo;
import service.metodospostgres.MetodosJugador;

public class Controller {

    public void logicaPrograma(){
        CrudBases crudBases = new CrudBases();
        MetodosEquipo metodosEquipo = new MetodosEquipo();
        MetodosJugador metodosJugador = new MetodosJugador();
        EscrituraLecturaJson elJson = new EscrituraLecturaJson();

        /*Inserccion de datos
        crudBases.insertDataDB(metodosEquipo.creacionObjetosEquipos());
        crudBases.insertDataDB(metodosJugador.creacionObjetosJugadores(crudBases.getDataFromDB("FROM Equipo", Equipo.class)));
         */

        /* Escritura en JSON
        elJson.writeFileJson(crudBases.getDataFromDB("FROM Equipo", Equipo.class), "equipos");
        elJson.writeFileJson(crudBases.getDataFromDB("FROM Xogadores", Xogadores.class), "xogadores");
         */

        /*Lectura fichero JSON
        elJson.auxReadObjects(elJson.readFileJson("equipos.json"));
        elJson.auxReadObjects(elJson.readFileJson("xogadores.json"));
         */
    }


}
