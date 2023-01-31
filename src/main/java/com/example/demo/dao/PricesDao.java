package com.example.demo.dao;

import com.example.demo.controller.model.*;
import com.example.demo.entity.Prices;

import java.time.LocalDateTime;

public interface PricesDao {

     Prices getPrice(String fecha, int brandId, int productId);



}
