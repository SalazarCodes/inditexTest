package com.example.demo.controller;


import com.example.demo.controller.model.PriceResponse;
import com.example.demo.service.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PriceController {


    @Autowired
    private PriceService priceService;


    @GetMapping(path = "/price" , produces = "application/json")
    public PriceResponse prices(@RequestParam String fecha, @RequestParam int brandId, @RequestParam int productId){


        return priceService.getPrice(fecha,brandId, productId);
    }

}
