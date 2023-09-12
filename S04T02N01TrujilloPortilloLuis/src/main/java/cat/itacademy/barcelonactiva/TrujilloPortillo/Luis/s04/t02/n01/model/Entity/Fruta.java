package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Frutas")
public class Fruta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "Tipo fruta")
    private String nombre;

    @Column(name = "Cantidad en Quilos")
    private int cantidadQuilos;

}
