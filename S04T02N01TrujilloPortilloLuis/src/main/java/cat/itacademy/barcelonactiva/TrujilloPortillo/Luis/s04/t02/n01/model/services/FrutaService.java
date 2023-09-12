package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.model.services;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.model.Entity.Fruta;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.model.repository.FrutaRepository;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@RequiredArgsConstructor
@Service
public class FrutaService {

    @Autowired
    private final FrutaRepository frutaRepository;

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
