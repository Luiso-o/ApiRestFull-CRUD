package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.model.Entity.Fruta;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.model.services.FrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//http://localhost:8080/h2-console
@RestController
@RequestMapping("/fruta")
public class FrutaController {

    @Autowired
    private FrutaService frutaService;

    @PostMapping("/add")
    public ResponseEntity<Fruta> agregarFruta(@RequestBody Fruta fruta){
        Fruta frutaGuardada = frutaService.guardarFruta(fruta);
        return ResponseEntity.ok(frutaGuardada);
    }

    @PutMapping("/update")
    public ResponseEntity<Fruta> actualizarFruta(@RequestBody Fruta fruta){
        Fruta frutaActualizada = frutaService.actualizarFruta(fruta);
        return ResponseEntity.ok(frutaActualizada);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String>eliminarFruta(@PathVariable int id){
        frutaService.eliminarFruta(id);
        return ResponseEntity.ok("Fruta eliminada");
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruta>obtenerFrutaPorId(@PathVariable int id){
        Optional<Fruta> fruta = frutaService.obtenerFrutaPorId(id);
        return fruta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruta>>obtenerTodasLasFrutas(){
        List<Fruta> frutas = frutaService.obtenerTodasLasFrutas();
        return ResponseEntity.ok(frutas);
    }
}
