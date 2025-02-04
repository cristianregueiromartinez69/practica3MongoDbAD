package model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Clase entity de equipos para mapearla con la tabla de la base de datos d epostgresSQL
 * @author cristian
 * @version 1.0
 */
@Entity
@Table(name = "equipos")
@JsonRootName(value = "Equipos")
public class Equipo {

    //clave primaria que e sun entero serial(se genera automáticamente)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('equipos_id_equipo_seq')")
    @Column(name = "id_equipo", nullable = false)
    @JsonProperty("id")
    @JsonIgnore
    private Integer id;

    //nombre del equipo, es un String
    @Column(name = "nome", length = 100)
    @JsonProperty("nome")
    private String nome;

    //ciudad del equipo, es un String
    @Column(name = "cidade", length = 100)
    @JsonProperty("cidade")
    private String cidade;

    //lista de jugadores que tiene el equipo
    @OneToMany(mappedBy = "idEquipo", fetch = FetchType.EAGER)
    @JsonProperty("xogadores")
    @JsonManagedReference
    private Set<Xogadores> xogadores = new LinkedHashSet<>();

    /**
     * Constructor de la clase
     * @param id la clave primaria que es un Integer
     * @param nome el nombre del equipo que es un String
     * @param cidade la ciudad del equipo que es un String
     * @param xogadores la lista de jugadores que es un Set
     */
    public Equipo(Integer id, String nome, String cidade, Set<Xogadores> xogadores) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.xogadores = xogadores;
    }

    public Equipo(String nome, String cidade, Set<Xogadores> xogadores) {
        this.nome = nome;
        this.cidade = cidade;
        this.xogadores = xogadores;
    }

    public Equipo(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    public Equipo() {

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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Set<Xogadores> getXogadores() {
        return xogadores;
    }

    public void setXogadores(Set<Xogadores> xogadores) {
        this.xogadores = xogadores;
    }

    /**
     * Metodo toString de la clase
     * @return información del equipo
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\nEquipos: ")
                .append("\nId: ")
                .append(id)
                .append("\nNome: ")
                .append(nome)
                .append("\nCidade: ")
                .append(cidade);

        if (xogadores != null) {
            sb.append("\nXogadores: ")
                    .append(xogadores);
        }
        return sb.toString();
    }
}