package com.example.demo.dao;

import com.example.demo.entity.Prices;
import com.example.demo.exception.BusinessException;
import com.example.demo.repository.PriceRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.sql.Timestamp;
import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;

@DataJpaTest
@Sql(scripts = "/data.sql")
class PricesDaoImplTestWithDataSql {

    @Autowired
    PriceRepository priceRepository;


    @Test
    void testCaseOne() {

        String fecha = "2020-06-14T10.00.00";
        int brandId = 1;
        int productId = 35455;

        Prices prices = priceRepository.findPrices(fecha, brandId, productId);

        Assertions.assertTrue(prices.getPrice() >= 0);
        assertNotNull(prices);
    }

    @Test
    void testCaseTwo() {

        String fecha = "2020-06-14T16.00.00";
        int brandId = 1;
        int productId = 35455;

        Prices prices = priceRepository.findPrices(fecha, brandId, productId);

        Assertions.assertTrue(prices.getPrice() >= 0);
        assertNotNull(prices);
    }

    @Test
    void testCaseThree() {

        String fecha = "2020-06-14T21.00.00";
        int brandId = 1;
        int productId = 35455;

        Prices prices = priceRepository.findPrices(fecha, brandId, productId);

        Assertions.assertTrue(prices.getPrice() >= 0);
        assertNotNull(prices);
    }

    @Test
    void testCaseFour() {

        String fecha = "2020-06-15T10.00.00";
        int brandId = 1;
        int productId = 35455;

        Prices prices = priceRepository.findPrices(fecha, brandId, productId);

        Assertions.assertTrue(prices.getPrice() >= 0);
        assertNotNull(prices);
    }



    @Test
    void testCaseFive() {

        String fecha = "2020-12-16T21.00.00";
        int brandId = 1;
        int productId = 35455;

        Prices prices = priceRepository.findPrices(fecha, brandId, productId);

        Assertions.assertTrue(prices.getPrice() >= 0);
        assertNotNull(prices);
    }
}