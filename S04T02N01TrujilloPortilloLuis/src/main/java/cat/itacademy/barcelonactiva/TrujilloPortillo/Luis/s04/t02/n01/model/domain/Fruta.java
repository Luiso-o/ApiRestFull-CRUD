package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.model.domain;

import jakarta.persistence.*;

@Entity
/*@Entity para indicar que la clase "Fruta" es una entidad JPA que
debe ser mapeada a una tabla en la base de datos.*/
@Table(name = "Frutas")
public class Fruta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Tipo fruta")
    private String nombre;

    @Column(name = "Cantidad en Quilos")
    private int cantidadQuilos;

    /*La anotación @Id marca el campo "id" como la clave primaria de la
    entidad, y la anotación @GeneratedValue especifica la estrategia de
    generación de valores para la clave primaria.*/

    public Fruta(){}

    public Fruta(String nombre, int cantidadQuilos){
        this.nombre = nombre;
        this.cantidadQuilos = cantidadQuilos;

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadQuilos() {
        return cantidadQuilos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadQuilos(int cantidadQuilos) {
        this.cantidadQuilos = cantidadQuilos;
    }
}
