package model.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;


/**
 * Clase entity de jugadores para mapearla con la tabla de la base de datos d epostgresSQL
 * @author cristian
 * @version 1.0
 */
@Entity
@Table(name = "xogadores")
@JsonRootName(value = "Xogadores")
public class Xogadores {

    //clave primaria que e sun entero serial(se genera automáticamente)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('xogadores_id_xogador_seq')")
    @Column(name = "id_xogador", nullable = false)
    @JsonProperty("id")
    @JsonIgnore
    private Integer id;

    //nombre del jugador, que es un String
    @Column(name = "nome", length = 100)
    @JsonProperty("nome")
    private String nome;

    //apellidos del jugador, que es un String
    @Column(name = "apelidos", length = 100)
    @JsonProperty("apellidos")
    private String apelidos;

    //Posicion del jugador, que es un String
    @Column(name = "posicion", length = 100)
    @JsonProperty("posicion")
    private String posicion;

    //fecha de nacimiento, que es un LocalDate
    @Column(name = "data_nacemento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("fechaNacimiento")
    private LocalDate dataNacemento;

    //nacionalidad, que es un String
    @Column(name = "nacionalidade", length = 100)
    @JsonProperty("nacionalidad")
    private String nacionalidade;

    //equipo al que pertenece el jugador, que es un objeto equipo
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_equipo")
    @JsonProperty("equipo")
    @JsonBackReference
    private Equipo idEquipo;

    public Xogadores() {

    }

    /**
     * Constructor de la clase
     * @param id el id del jugador, que es un Integer
     * @param nome el nombre del jugador que es un String
     * @param apelidos los apellidos del jugador que es un String
     * @param posicion la posicion del jugador que es un String
     * @param dataNacemento la fecha de nacimiento del jugaor, que es un LocalDate
     * @param nacionalidade la nacionalidad del jugador, que es un String
     * @param idEquipo el equipo al que pertenece el jugador, que es un Objeto Equipo
     */
    public Xogadores(Integer id, String nome, String apelidos, String posicion, LocalDate dataNacemento, String nacionalidade, Equipo idEquipo) {
        this.id = id;
        this.nome = nome;
        this.apelidos = apelidos;
        this.posicion = posicion;
        this.dataNacemento = dataNacemento;
        this.nacionalidade = nacionalidade;
        this.idEquipo = idEquipo;
    }

    public Xogadores(String nome, String apelidos, String posicion, LocalDate dataNacemento, String nacionalidade, Equipo idEquipo) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.posicion = posicion;
        this.dataNacemento = dataNacemento;
        this.nacionalidade = nacionalidade;
        this.idEquipo = idEquipo;
    }

    /**
     * getter y setter de la clase
     * @return los atributos correspondientes
     */
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public LocalDate getDataNacemento() {
        return dataNacemento;
    }

    public void setDataNacemento(LocalDate dataNacemento) {
        this.dataNacemento = dataNacemento;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Equipo getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Equipo idEquipo) {
        this.idEquipo = idEquipo;
    }

    /**
     * Metodo toString de la clase
     * @return la información del jugador
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nXogadores: ")
                .append("\n\tId: ")
                .append(id)
                .append("\n\tNome: ")
                .append(nome)
                .append("\n\tApelidos: ")
                .append(apelidos)
                .append("\n\tPosicion: ")
                .append(posicion)
                .append("\n\tDataNacemento: ")
                .append(dataNacemento)
                .append("\n\tNacionalidade: ")
                .append(nacionalidade)
                .append("\n\tIdEquipo: ")
                .append(idEquipo);

        return sb.toString();
    }
}