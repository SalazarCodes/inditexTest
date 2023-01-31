package com.example.demo.service;

import com.example.demo.controller.model.PriceResponse;
import com.example.demo.dao.PricesDao;
import com.example.demo.entity.Prices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {


    @InjectMocks
    PriceServiceImpl priceService;

    @Mock
    PricesDao pricesDao;

    @Test
    void getPrice() {

        Prices pricesBuilder = new Prices();

        pricesBuilder.setId(1);
        pricesBuilder.setBrandId(1);
        pricesBuilder.setPriceList(1);
        pricesBuilder.setProductId(35455);
        pricesBuilder.setStartDate(Timestamp.from(Instant.now()));
        pricesBuilder.setEndDate(Timestamp.from(Instant.now()));
        pricesBuilder.setPriority(0);
        pricesBuilder.setPrice(35.50);

        Mockito.when(pricesDao.getPrice(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(pricesBuilder);


        //test
        PriceResponse prices = priceService.getPrice("2020-06-14T10.00.00",35455,1);

        // Validate the result
        assertEquals(35455, prices.getProductId());
        assertTrue(prices.getPrecioFinal() > 0);
    }
}