package service.crud.metodosmongo;

import java.util.List;
import java.util.Map;

public class LecturaDatos {

    public void lecturaDatosEquipos(List<Map<String, Object>> equiposList){
        for(Map<String, Object> equipo : equiposList){
            System.out.println("\nEquipo: ");
            for(Map.Entry<String, Object> equipoEntry : equipo.entrySet()){
                System.out.println(equipoEntry.getKey() + ": " + equipoEntry.getValue());
            }
        }
    }

    public void lecturaDatosJugadores(List<Map<String, Object>> jugadoresList){
        for(Map<String, Object> jugador : jugadoresList){
            System.out.println("\nJugador: ");
            for(Map.Entry<String, Object> jugadorEntry : jugador.entrySet()){
                System.out.println(jugadorEntry.getKey() + ": " + jugadorEntry.getValue());
            }
        }
    }
}
