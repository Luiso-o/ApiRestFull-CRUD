package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.model.Entity.Fruta;
import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.model.repository.FrutaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FrutaControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private FrutaRepository frutaRepository;

    @BeforeEach
    public void setUp() {
        frutaRepository.save(Fruta.builder()
                .nombre("Manzana")
                .cantidadQuilos(5)
                .build());

       frutaRepository.save(Fruta.builder()
                .nombre("Plátano")
                .cantidadQuilos(7)
                .build());

    }

    @Test
    public void test_Al_agregar_una_fruta_esta_el_resultado_sera_ok() throws Exception {
        Fruta nuevaFruta = new Fruta(4, "Sandia",6);

        String nuevaFrutaJson = objectMapper.writeValueAsString(nuevaFruta);

        mockMvc.perform(MockMvcRequestBuilders.post("/fruta/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(nuevaFrutaJson))
                .andExpect(status().isOk());
    }

    @Test
    public void test_ActualizarFruta_DeberiaRetornarOk() throws Exception {
        Fruta frutaActualizada = Fruta.builder()
                .id(1)
                .nombre("Manzana Roja")
                .cantidadQuilos(7)
                .build();

        String frutaActualizadaJson = objectMapper.writeValueAsString(frutaActualizada);

        mockMvc.perform(MockMvcRequestBuilders.put("/fruta/update")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(frutaActualizadaJson))
                .andExpect(status().isOk());

        // Verificar que la fruta se haya actualizado correctamente en la base de datos
        Fruta nuevaFruta = frutaRepository.findById(1).orElse(null);
        assertNotNull(nuevaFruta);
        assertEquals("Manzana Roja", nuevaFruta.getNombre());
        assertEquals(7, nuevaFruta.getCantidadQuilos());
    }

    @Test
    public void test_EliminarFruta_DeberiaRetornarOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/fruta/delete/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(content().string("Fruta eliminada"));
    }

    @Test
    public void test_ObtenerFrutaPorId_DeberiaRetornarOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fruta/getOne/{id}", 2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void test_ObtenerTodasLasFrutas_DeberiaRetornarOk() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/fruta/getAll")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

}