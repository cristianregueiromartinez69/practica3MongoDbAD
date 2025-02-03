package model.entity;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDate;

@Entity
@Table(name = "xogadores")
@JsonRootName(value = "Xogadores")
public class Xogadores {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('xogadores_id_xogador_seq')")
    @Column(name = "id_xogador", nullable = false)
    @JsonProperty("id")
    @JsonIgnore
    private Integer id;

    @Column(name = "nome", length = 100)
    @JsonProperty("nome")
    private String nome;

    @Column(name = "apelidos", length = 100)
    @JsonProperty("apellidos")
    private String apelidos;

    @Column(name = "posicion", length = 100)
    @JsonProperty("posicion")
    private String posicion;

    @Column(name = "data_nacemento")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("fechaNacimiento")
    private LocalDate dataNacemento;

    @Column(name = "nacionalidade", length = 100)
    @JsonProperty("nacionalidad")
    private String nacionalidade;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_equipo")
    @JsonProperty("equipo")
    @JsonBackReference
    private Equipo idEquipo;

    public Xogadores() {

    }

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