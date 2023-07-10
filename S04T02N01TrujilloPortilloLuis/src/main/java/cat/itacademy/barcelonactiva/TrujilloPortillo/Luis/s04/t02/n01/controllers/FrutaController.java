package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.model.domain.Fruta;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.model.services.FrutaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localHost:8080")
@RestController
/*@RestController, indica que es un controlador de Spring MVC que manejará
las peticiones HTTP y producirá las respuestas en formato JSON.*/
@RequestMapping("/fruta")
/*establecer el prefijo de la ruta URL para todas las rutas de este controlador.*/
public class FrutaController {
    private final FrutaService frutaService;

    @Autowired
    public FrutaController(FrutaService frutaService){
        this.frutaService = frutaService;
    }

    //Métodos que manejan las peticiones HTTP correspondientes a las operaciones CRUD relacionadas con la entidad Fruta.
    @PostMapping("/add")
    /* Maneja la petición HTTP POST a /fruta/add para agregar una nueva fruta a la base de datos.*/
    public ResponseEntity<Fruta> agregarFruta(@RequestBody Fruta fruta){
        Fruta frutaGuardada = frutaService.guardarFruta(fruta);
        return ResponseEntity.ok(frutaGuardada);
    }

    @PutMapping("/update")
    /*Maneja la petición HTTP PUT a /fruta/update para actualizar una fruta existente en la base de datos.*/
    public ResponseEntity<Fruta> actualizarFruta(@RequestBody Fruta fruta){
        Fruta frutaActualizada = frutaService.actualizarFruta(fruta);
        return ResponseEntity.ok(frutaActualizada);
    }

    @DeleteMapping("/delete/{id}")
    /* Maneja la petición HTTP DELETE a /fruta/delete/{id} para eliminar una fruta de la base de datos según su ID.*/
    public ResponseEntity<String>eliminarFruta(@PathVariable int id){
        frutaService.eliminarFruta(id);
        return ResponseEntity.ok("Fruta eliminada");
    }

    @GetMapping("/getOne/{id}")
    /* Maneja la petición HTTP GET a /fruta/getOne/{id} para obtener una fruta de la base de datos según su ID.*/
    public ResponseEntity<Fruta>obtenerFrutaPorId(@PathVariable int id){
        Optional<Fruta> fruta = frutaService.obtenerFrutaPorId(id);
        return fruta.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/getAll")
    /*Maneja la petición HTTP GET a /fruta/getAll para obtener todas las frutas de la base de datos.*/
    public ResponseEntity<List<Fruta>>obtenerTodasLasFrutas(){
        List<Fruta> frutas = frutaService.obtenerTodasLasFrutas();
        return ResponseEntity.ok(frutas);
    }
}
