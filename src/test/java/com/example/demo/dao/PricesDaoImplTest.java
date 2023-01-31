package com.example.demo.dao;

import com.example.demo.entity.Prices;
import com.example.demo.exception.BusinessException;
import com.example.demo.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PricesDaoImplTest {


    @InjectMocks
    PricesDaoImpl pricesDao;

    @Mock
    PriceRepository priceRepository;

    @Test
    void getPriceDetail() {

        Prices pricesBuilder = new Prices();

        pricesBuilder.setId(1);
        pricesBuilder.setBrandId(1);
        pricesBuilder.setPriceList(1);
        pricesBuilder.setProductId(35455);
        pricesBuilder.setStartDate(Timestamp.from(Instant.now()));
        pricesBuilder.setEndDate(Timestamp.from(Instant.now()));
        pricesBuilder.setPriority(0);
        pricesBuilder.setPrice(35.50);

        Mockito.when(priceRepository.findPrices(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(pricesBuilder);


        //test
        Prices prices = pricesDao.getPrice("2020-06-14T10.00.00",35455,1);

        // Validate the result
        assertEquals(35455, prices.getProductId());
    }

    @Test
    void getPriceDetailThenError() {

        Mockito.when(priceRepository.findPrices(Mockito.anyString(), Mockito.anyInt(), Mockito.anyInt()))
                .thenReturn(null);


        // Verify that the expected exception is thrown
        assertThrows(BusinessException.class, () -> pricesDao.getPrice("2020-06-14T10.00.00",35455,1));
    }
}