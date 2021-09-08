package com.github.alissonphp.dsvendas.services;

import com.github.alissonphp.dsvendas.dto.SellerDTO;
import com.github.alissonphp.dsvendas.entities.Seller;
import com.github.alissonphp.dsvendas.repositories.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerService {

    @Autowired
    private SellerRepository repository;

    public List<SellerDTO> findAll() {
        List<Seller> result = repository.findAll();
        return result.stream().map(SellerDTO::new).collect(Collectors.toList());
    }
}
