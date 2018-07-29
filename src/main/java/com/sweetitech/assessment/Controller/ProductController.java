package com.sweetitech.assessment.Controller;

import com.sweetitech.assessment.Domain.Product;
import com.sweetitech.assessment.Repository.ProductRepository;
import com.sweetitech.assessment.Validator.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@Controller
public class ProductController {

    @Autowired
    ProductValidator productValidator;

    @Autowired
    ProductRepository productRepository;

    @InitBinder("product")
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(productValidator);
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
    }

    @GetMapping("/addproduct")
    public String addProduct(Model model)
    {

        model.addAttribute("product" ,new Product());

        return "addProduct";
    }

    @PostMapping("/addproduct")
    public String doAdd(@Valid @ModelAttribute("product") Product product, BindingResult result, Model model)
    {

        //Validation Code
        if(product.getId() != null)
        {
            ProductValidator.setEditName(productRepository.getOne(product.getId()).getName());
        }

        productValidator.validate(product,result);

        if(result.hasErrors())
        {
            if(product.getId() == null)
            {

                final List<ObjectError> errors = result.getAllErrors().stream()
                        .filter(e -> e.getCode().equals("Size"))
                        .collect(Collectors.toList());
                if(errors.size() ==0)
                {
                    model.addAttribute("exit", true);
                }
                return "addProduct";
            }
            else
            {
                Product product2 = productRepository.getOne(product.getId());
                ProductValidator.setEditName(product2.getName());
                model.addAttribute("product2",product2);
                model.addAttribute("exit","exit");
                return "addProduct";
            }
        }


        //for save and edit

       if(product.getId() == null)
       {
           productRepository.save(product);
       }
        else
        {
            Product product1 = productRepository.getOne(product.getId());
            product1.setName(product.getName());
            product1.setPrice(product.getPrice());
            product1.setProductType(product.getProductType());
            product1.setProfitPercentage(product.getProfitPercentage());
            product1.setSoldCount(product.getSoldCount());
            productRepository.save(product1);

        }
        return "redirect:/productList";
    }


    @GetMapping("/productList")
    public String getAllProduct(Model model)
    {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products",products);
        return "prdoctList";
    }

    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable Integer id)
    {
        Product product = productRepository.getOne(id);
        productRepository.delete(product);
        return "redirect:/productList";
    }


    @GetMapping("/editProduct/{id}")
    public String editProduct(@PathVariable Integer id, Model model)
    {
        Product product = productRepository.getOne(id);
        model.addAttribute("product",product);
        return "addProduct";
    }


}
