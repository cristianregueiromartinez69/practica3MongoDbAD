package service.crud.metodosmongo;

import java.util.List;
import java.util.Map;

/**
 * Clase con los metodos para poder leer list<Map<String,Object>> que viene de los json
 * @author cristian
 * @version 1.0
 */
public class LecturaDatos {

    /**
     * Metodo para leer la lista de equipos
     * @param equiposList una lista de equipos
     */
    public void lecturaDatosEquipos(List<Map<String, Object>> equiposList){
        for(Map<String, Object> equipo : equiposList){
            System.out.println("\nEquipo: ");
            for(Map.Entry<String, Object> equipoEntry : equipo.entrySet()){
                System.out.println(equipoEntry.getKey() + ": " + equipoEntry.getValue());
            }
        }
    }

    /**
     * Metodo para leer la lista de jugadores
     * @param jugadoresList una lista de jugadores
     */
    public void lecturaDatosJugadores(List<Map<String, Object>> jugadoresList){
        for(Map<String, Object> jugador : jugadoresList){
            System.out.println("\nJugador: ");
            for(Map.Entry<String, Object> jugadorEntry : jugador.entrySet()){
                System.out.println(jugadorEntry.getKey() + ": " + jugadorEntry.getValue());
            }
        }
    }
}
