package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.model.repository;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.model.domain.Fruta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FrutaRepository extends JpaRepository <Fruta,Integer> {

}

/*La interfaz FrutaRepository hereda los métodos básicos de JpaRepository,
 que proporciona métodos CRUD (Create, Read, Update, Delete) para la entidad
  Fruta. Esto significa que no es necesario implementar estos métodos
  manualmente, ya que Spring Data JPA los implementará automáticamente
  en tiempo de ejecución.*/
