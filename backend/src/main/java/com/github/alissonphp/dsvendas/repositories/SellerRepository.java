package com.github.alissonphp.dsvendas.repositories;

import com.github.alissonphp.dsvendas.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {
}
