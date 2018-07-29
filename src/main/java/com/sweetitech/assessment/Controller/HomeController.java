package com.sweetitech.assessment.Controller;

import com.sweetitech.assessment.Domain.Product;
import com.sweetitech.assessment.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class HomeController {

    @Autowired
    ProductRepository productRepository;



    private float getTotalProfit(Product product)
    {
        return product.getPrice()*(product.getProfitPercentage()/100)*product.getSoldCount();
    }

    @RequestMapping("/home")
    public String loginPage(Model model)
    {
        List<Product> productList =productRepository.findAll();
        productList.forEach(p->p.setTotalProfit(getTotalProfit(p)));
        productList.sort(Comparator.comparing(Product::getTotalProfit).reversed());
        List<Product> top5Product = productList.stream().limit(5).collect(Collectors.toList());
        model.addAttribute("top5Product",top5Product);

        List<Product> soldProduct =productRepository.findAll();
        soldProduct.sort(Comparator.comparing(Product::getSoldCount).reversed());
        List<Product> top5Sold = soldProduct.stream().limit(5).collect(Collectors.toList());
        model.addAttribute("top5Sold",top5Sold);

        return "home";



    }

    @GetMapping("/about")
    public String aboutPage()
    {
        return "about";
    }
}
