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

    @RequestMapping(method = RequestMethod.POST, value = "/addproduct", params = "create")
    public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "addProduct";
        }
            productRepository.save(product);
            return "redirect:/productList";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/addproduct", params = "update")
    public String updateProduct(@Valid @ModelAttribute("product") Product product, BindingResult result)
    {
        if(result.hasErrors())
        {
            return "addProduct";
        }
        productRepository.save(product);

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
        model.addAttribute("path","update");
        return "addProduct";
    }


}
