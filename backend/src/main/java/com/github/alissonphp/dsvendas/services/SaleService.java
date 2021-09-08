package com.github.alissonphp.dsvendas.services;

import com.github.alissonphp.dsvendas.dto.SaleDTO;
import com.github.alissonphp.dsvendas.dto.SalesSuccessDTO;
import com.github.alissonphp.dsvendas.dto.SalesSumDTO;
import com.github.alissonphp.dsvendas.entities.Sale;
import com.github.alissonphp.dsvendas.repositories.SaleRepository;
import com.github.alissonphp.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private SellerRepository sellerRepository;

    public Page<SaleDTO> findAll(Pageable pageable) {
        sellerRepository.findAll();
        Page<Sale> result = repository.findAll(pageable);
        return result.map(SaleDTO::new);
    }

    @Transactional(readOnly = true)
    public List<SalesSumDTO> amountGroupedBySeller() {
        return repository.amountGroupedBySeller();
    }

    @Transactional(readOnly = true)
    public List<SalesSuccessDTO> successGroupedBySeller() {
        return repository.successGroupedBySeller();
    }
}
