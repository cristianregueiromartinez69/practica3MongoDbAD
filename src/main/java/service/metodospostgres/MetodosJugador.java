package service.metodospostgres;

import model.entity.Equipo;
import model.entity.Xogadores;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase auxiliar para insertar datos en la tablas de mongoDB
 * @author cristian
 * @version 1.0
 */
public class MetodosJugador {

    /**
     * Metodo para crear los objetos jugadores
     * @param equiposList la lista de equipos que leemos de la base de datos
     * @return la lista de jugadores
     */
    public List<Xogadores> creacionObjetosJugadores(List<Equipo> equiposList){
        List<Xogadores> xogadoresList = new ArrayList<>();

        Xogadores xogador1 = new Xogadores("Kylian", "Mbappé Lottin", "Delantero", LocalDate.of(1998, 12, 20), "Francia", equiposList.get(0));
        Xogadores xogador2 = new Xogadores("Lamine Yamal", "Nasraoui Ebana", "Delantero", LocalDate.of(2007, 7, 13), "Español", equiposList.get(1));
        Xogadores xogador3 = new Xogadores("Rafael Alexandre", "Conceição Leão", "Delantero", LocalDate.of(1999, 6, 10), "Portugal", equiposList.get(2));
        Xogadores xogador4 = new Xogadores("Emre", "Can", "Centrocampista", LocalDate.of(1994, 1, 12), "Alemania", equiposList.get(3));
        Xogadores xogador5 = new Xogadores("Neymar da Silva", "Santos Júnior", "Delantero", LocalDate.of(1992, 2, 5), "Brasil", equiposList.get(4));
        Xogadores xogador6 = new Xogadores("Adrien", "Rabiot-Provost", "Centrocampista", LocalDate.of(1995, 4, 3), "Francia", equiposList.get(5));
        Xogadores xogador7 = new Xogadores("Sergio", "Germán Romero", "Portero", LocalDate.of(1987, 2, 22), "Argentina", equiposList.get(6));
        Xogadores xogador8 = new Xogadores("Jordi", "Alba Ramos", "Defensa", LocalDate.of(1989, 3, 21), "Español", equiposList.get(7));
        Xogadores xogador9 = new Xogadores("Mohamed Salah", "Hamed Mahrous Ghaly", "Delantero", LocalDate.of(1992, 6, 15), "Egipto", equiposList.get(8));
        Xogadores xogador10 = new Xogadores("Daniele", "Rugani", "Defensa", LocalDate.of(1994, 7, 29), "Italia", equiposList.get(9));

        insertValuesXogadores(xogadoresList, xogador1, xogador2, xogador3, xogador4, xogador5, xogador6, xogador7, xogador8, xogador9, xogador10);

        return xogadoresList;
    }

    /**
     * metodo auxiliar para añadir jugadores a la lista
     * @param xogadoresList la lista de jugadores
     * @param xogador1 el 1º jugador
     * @param xogador2 el 2º jugador
     * @param xogador3 el 3º jugador
     * @param xogador4 el 4º jugador
     * @param xogador5 el 5º jugador
     * @param xogador6 el 6º jugador
     * @param xogador7 el 7º jugador
     * @param xogador8 el 8º jugador
     * @param xogador9 el 9º jugador
     * @param xogador10 el 10º jugador
     */
    private static void insertValuesXogadores(List<Xogadores> xogadoresList, Xogadores xogador1, Xogadores xogador2, Xogadores xogador3, Xogadores xogador4, Xogadores xogador5, Xogadores xogador6, Xogadores xogador7, Xogadores xogador8, Xogadores xogador9, Xogadores xogador10) {
        xogadoresList.add(xogador1);
        xogadoresList.add(xogador2);
        xogadoresList.add(xogador3);
        xogadoresList.add(xogador4);
        xogadoresList.add(xogador5);
        xogadoresList.add(xogador6);
        xogadoresList.add(xogador7);
        xogadoresList.add(xogador8);
        xogadoresList.add(xogador9);
        xogadoresList.add(xogador10);
    }


}
