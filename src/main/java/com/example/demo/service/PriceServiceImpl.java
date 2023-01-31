package com.example.demo.service;

import com.example.demo.controller.model.PriceResponse;
import com.example.demo.dao.PricesDao;
import com.example.demo.entity.Prices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

     private PricesDao pricesDao;


    @Override
    public PriceResponse getPrice(String fecha, int brandId, int productId) {

        Prices prices = pricesDao.getPrice(fecha, brandId, productId);


        return priceResponseBuilder(prices, fecha, prices.getPrice());

    }


    private PriceResponse priceResponseBuilder(Prices prices, String fecha, double precioFinal){

        PriceResponse priceResponse = new PriceResponse();
        priceResponse.setBrandId(prices.getBrandId());
        priceResponse.setFechaAplicacion(fecha.substring(0, 10));
        priceResponse.setPrecioFinal(precioFinal);
        priceResponse.setProductId(prices.getProductId());

        return priceResponse;
    }

}
