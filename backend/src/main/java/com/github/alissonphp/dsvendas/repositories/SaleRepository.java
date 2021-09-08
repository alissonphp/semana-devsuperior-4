package com.github.alissonphp.dsvendas.repositories;

import com.github.alissonphp.dsvendas.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Sale, Long> {
}
