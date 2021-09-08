package com.github.alissonphp.dsvendas.controllers;

import com.github.alissonphp.dsvendas.dto.SaleDTO;
import com.github.alissonphp.dsvendas.dto.SalesSuccessDTO;
import com.github.alissonphp.dsvendas.dto.SalesSumDTO;
import com.github.alissonphp.dsvendas.dto.SellerDTO;
import com.github.alissonphp.dsvendas.entities.Sale;
import com.github.alissonphp.dsvendas.services.SaleService;
import com.github.alissonphp.dsvendas.services.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService service;

    @GetMapping
    public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable) {
        Page<SaleDTO> list = service.findAll(pageable);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/amount-by-seller")
    public ResponseEntity<List<SalesSumDTO>> amountGroupedBySeller() {
        List<SalesSumDTO> list = service.amountGroupedBySeller();
        return ResponseEntity.ok(list);
    }

    @GetMapping(value = "/success-by-seller")
    public ResponseEntity<List<SalesSuccessDTO>> successGroupedBySeller() {
        List<SalesSuccessDTO> list = service.successGroupedBySeller();
        return ResponseEntity.ok(list);
    }

}
