package controller;

import model.entity.Equipo;
import service.crud.CrudBases;
import service.metodospostgres.MetodosEquipo;
import service.metodospostgres.MetodosJugador;

public class Controller {

    public void logicaPrograma(){
        CrudBases crudBases = new CrudBases();
        MetodosEquipo metodosEquipo = new MetodosEquipo();
        MetodosJugador metodosJugador = new MetodosJugador();

        /*Inserccion de datos
        crudBases.insertDataDB(metodosEquipo.creacionObjetosEquipos());
        crudBases.insertDataDB(metodosJugador.creacionObjetosJugadores(crudBases.getDataFromDB("FROM Equipo", Equipo.class)));
         */
    }

}
