package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.model.services;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.model.repository.FrutaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
/*@Service, Le indica a Spring que debe gestionarla como un componente
 de servicio. La clase tiene una dependencia del repositorio FrutaRepository, que se inyecta
 mediante la anotación @Autowired en el constructor.*/
public class FrutaService {
    private final FrutaRepository frutaRepository;

    @Autowired
    public FrutaService(FrutaRepository frutaRepository){
        this.frutaRepository = frutaRepository;
    }

    //frutaRepository hereda métodos de JpaRepository
    public Fruta guardarFruta(Fruta fruta){
        return frutaRepository.save(fruta);
    }

    public Fruta actualizarFruta(Fruta fruta){
        return frutaRepository.save(fruta);
    }

    public void eliminarFruta(int id){
        frutaRepository.deleteById(id);
    }

    public Optional<Fruta> obtenerFrutaPorId(int id){
        return frutaRepository.findById(id);
    }

    public List<Fruta> obtenerTodasLasFrutas(){
        return frutaRepository.findAll();
    }

}
