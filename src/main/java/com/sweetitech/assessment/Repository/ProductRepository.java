package com.sweetitech.assessment.Repository;

import com.sweetitech.assessment.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    public boolean existsByName(String name);
}
