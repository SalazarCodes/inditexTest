package com.example.demo.controller.model;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PriceResponse {


 private int brandId;

 private int productId;

 private String fechaAplicacion;

 private double precioFinal;

}
