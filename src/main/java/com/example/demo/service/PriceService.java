package com.example.demo.service;


import com.example.demo.controller.model.*;


public interface PriceService {

    PriceResponse getPrice(String fecha, int brandId, int productId);


}
