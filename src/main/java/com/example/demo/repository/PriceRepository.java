package com.example.demo.repository;

import com.example.demo.entity.Prices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Repository
public interface PriceRepository extends JpaRepository<Prices, Integer> {


    @Query(value = "SELECT top 1 * FROM Prices c WHERE c.BRAND_ID = :brandId and c.PRODUCT_ID = :productId and :fecha between c.START_DATE and c.END_DATE" +
            " ORDER BY PRIORITY DESC",
            nativeQuery = true)
    Prices findPrices(@Param("fecha") String fecha, @Param("brandId") int brandId, @Param("productId") int productId);


}
