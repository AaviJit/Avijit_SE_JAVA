package com.sweetitech.assessment.Validator;
import com.sweetitech.assessment.Domain.Product;
import com.sweetitech.assessment.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductValidator implements Validator {



    private static String editName = "";

    public static void setEditName(String editName) {
        ProductValidator.editName = editName;
    }

    @Autowired
    ProductRepository productRepository;

    @Override
    public boolean supports(Class<?> aClass) {
        return Product.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Product product =(Product) o;

        if (productRepository.existsByName(product.getName()) && !editName.equals(product.getName()))
        {
            errors.reject("error.duplicate.product");
        }
    }
}

