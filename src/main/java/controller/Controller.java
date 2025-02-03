package controller;

import service.crud.CrudBases;
import service.metodospostgres.MetodosEquipo;
import service.metodospostgres.MetodosJugador;

public class Controller {

    public void logicaPrograma(){
        CrudBases crudBases = new CrudBases();
        MetodosEquipo metodosEquipo = new MetodosEquipo();
        MetodosJugador metodosJugador = new MetodosJugador();

        crudBases.insertar10PokemonsInPokedex(meto);
    }

}
