package model.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "equipos")
public class Equipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ColumnDefault("nextval('equipos_id_equipo_seq')")
    @Column(name = "id_equipo", nullable = false)
    private Integer id;

    @Column(name = "nome", length = 100)
    private String nome;

    @Column(name = "cidade", length = 100)
    private String cidade;

    @OneToMany(mappedBy = "idEquipo")
    private Set<Xogadores> xogadores = new LinkedHashSet<>();

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