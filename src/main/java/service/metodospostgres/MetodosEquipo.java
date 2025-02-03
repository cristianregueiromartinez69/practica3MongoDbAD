package service.metodospostgres;

import model.entity.Equipo;

import java.util.ArrayList;
import java.util.List;

public class MetodosEquipo {

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
