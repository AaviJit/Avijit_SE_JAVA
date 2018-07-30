package com.sweetitech.assessment.Validator;

import com.sweetitech.assessment.Domain.Product;
import com.sweetitech.assessment.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {

    @Autowired
    ProductRepository productRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product = (Product) o;


        if(product.getId() == null)
        {
            if(productRepository.existsByName(product.getName()))
            {
                errors.rejectValue("name", "error.duplicate.product");
            }
        }

        else {
            Product product1 = productRepository.getOne(product.getId());
            if (!product.getName().equals(product1.getName()) && productRepository.existsByName(product.getName())) {
                errors.rejectValue("name", "error.duplicate.product");
            }
        }
    }
}

