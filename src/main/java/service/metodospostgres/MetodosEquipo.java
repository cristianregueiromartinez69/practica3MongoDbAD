package service.metodospostgres;

import model.entity.Equipo;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase auxiliar para insertar datos en la tablas de postgresSQL
 * @author cristian
 * @version 1.0
 */
public class MetodosEquipo {

    /**
     * Metodo que crea los objetos y devuelve una lista de esos objetos
     * @return la lista de objetos
     */
    public List<Equipo> creacionObjetosEquipos(){
        List<Equipo> equipos = new ArrayList<>();

        Equipo equipo1 = new Equipo("Real madrid", "España");
        Equipo equipo2 = new Equipo("Barcelona", "España");
        Equipo equipo3 = new Equipo("Milan", "Italia");
        Equipo equipo4 = new Equipo("Borrusia Dortmund", "Alemania");
        Equipo equipo5 = new Equipo("Santos F.C.", "Brasil");
        Equipo equipo6 = new Equipo("Olimpique de Marsella", "Francia");
        Equipo equipo7 = new Equipo("Boca Juniors", "Argentina");
        Equipo equipo8 = new Equipo("Inter de Miami", "Estados Unidos");
        Equipo equipo9 = new Equipo("Liverpool", "Inglaterra");
        Equipo equipo10 = new Equipo("Ajax", "Países Bajos");

        insertValuesList(equipos, equipo1, equipo2, equipo3, equipo4, equipo5, equipo6, equipo7, equipo8, equipo9, equipo10);

        return equipos;

    }

    /**
     * metodo auxiliar para añadir elementos a la lista
     * @param equipos la lista de equipos
     * @param equipo1 el 1º equipo
     * @param equipo2 el 2º equipo
     * @param equipo3 el 3º equipo
     * @param equipo4 el 4º equipo
     * @param equipo5 el 5º equipo
     * @param equipo6 el 6º equipo
     * @param equipo7 el 7º equipo
     * @param equipo8 el 8º equipo
     * @param equipo9 el 9º equipo
     * @param equipo10 el 10º equipo
     */
    private void insertValuesList(List<Equipo> equipos, Equipo equipo1, Equipo equipo2, Equipo equipo3, Equipo equipo4, Equipo equipo5, Equipo equipo6, Equipo equipo7, Equipo equipo8, Equipo equipo9, Equipo equipo10) {
        equipos.add(equipo1);
        equipos.add(equipo2);
        equipos.add(equipo3);
        equipos.add(equipo4);
        equipos.add(equipo5);
        equipos.add(equipo6);
        equipos.add(equipo7);
        equipos.add(equipo8);
        equipos.add(equipo9);
        equipos.add(equipo10);
    }
}
