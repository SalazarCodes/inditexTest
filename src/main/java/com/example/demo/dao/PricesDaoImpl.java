package com.example.demo.dao;

import com.example.demo.entity.Prices;
import com.example.demo.exception.BusinessException;
import com.example.demo.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class PricesDaoImpl implements PricesDao {

    @Autowired
    private PriceRepository priceRepository;


    @Override
    public Prices getPrice(String fecha, int brandId, int productId) {

        Prices prices =  priceRepository.findPrices(fecha ,brandId, productId);

        if(Objects.nonNull(prices)) {

       return prices;

        }

            else {
                throw new BusinessException("E001", HttpStatus.NOT_FOUND, "No se encontro el precio del producto");
            }

        }

}
