package com.example.demo.controller;

import com.example.demo.controller.model.PriceResponse;
import com.example.demo.service.PriceService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PriceController.class)
class PriceControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private PriceService priceService;


    @Test
     void prices() throws Exception {

        PriceResponse priceResponse = new PriceResponse();
        priceResponse.setPrecioFinal(35.5);
        priceResponse.setBrandId(1);
        priceResponse.setFechaAplicacion("2020-06-14");
        priceResponse.setProductId(35455);

        when(priceService.getPrice(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(priceResponse);


        mvc.perform(MockMvcRequestBuilders
                .get("/api/v1/price")
                .queryParam("brandId", String.valueOf(1))
                .queryParam("productId", String.valueOf(35455))
                .queryParam("fecha", "2020-06-14T10.00.00")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.precioFinal").exists());

        verify(priceService).getPrice("2020-06-14T10.00.00",1, 35455);


    }
}