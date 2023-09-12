package cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.controllers;

import cat.itacademy.barcelonactiva.TrujilloPortillo.Luis.s04.t02.n01.model.Entity.Fruta;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class FrutaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp(){
        new Fruta(1,"Manzana",3);
        new Fruta(2,"Mango",2);
        new Fruta(3,"Bananas",5);
    }

    @Test
    public void test_Al_agregar_una_fruta_esta_el_resultado_sera_ok() throws Exception {
        Fruta nuevaFruta = new Fruta(4, "Sandia",6);
        mockMvc.perform(MockMvcRequestBuilders.post("/fruta/add",nuevaFruta)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}