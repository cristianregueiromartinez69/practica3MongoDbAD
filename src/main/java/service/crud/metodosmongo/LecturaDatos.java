package service.crud.metodosmongo;

import java.util.List;
import java.util.Map;

public class LecturaDatos {

    public void lecturaDatosEquipos(List<Map<String, Object>> equiposList){
        for(Map<String, Object> equipo : equiposList){
            for(Map.Entry<String, Object> equipoEntry : equipo.entrySet()){
                System.out.println("\nEquipo: " + "\nClave: " + equipoEntry.getKey() + "\nValor: " + equipoEntry.getValue());
            }
        }
    }

    public void lecturaDatosJugadores(List<Map<String, Object>> jugadoresList){
        for(Map<String, Object> jugador : jugadoresList){
            for(Map.Entry<String, Object> jugadorEntry : jugador.entrySet()){
                System.out.println("\nJugador: " + "\nClave: " +  jugadorEntry.getKey() + "\nValor: " + jugadorEntry.getValue());
            }
        }
    }
}
