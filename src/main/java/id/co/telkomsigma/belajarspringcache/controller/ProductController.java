/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.telkomsigma.belajarspringcache.controller;

import id.co.telkomsigma.belajarspringcache.domain.Product;
import id.co.telkomsigma.belajarspringcache.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anggi
 */
@RestController
public class ProductController {
    
    @Autowired 
    ProductService productService;
    
    Logger logger = LoggerFactory.getLogger(ProductController.class);
    
    @GetMapping("/findProduct/name/{name}")
    public Product findProductByName(@PathVariable("name") String name){
        logger.info("CONTROLLER UNTUK FIND PRODUCT BY NAME !!");
        return productService.findProductByName(name);
    }
    
    @GetMapping("/findProduct/code/{code}")
    public Product findProductByCode(@PathVariable("code") String code){
        logger.info("CONTROLLER UNTUK FIND PRODUCT BY Code !!");
        return productService.findProductByCode(code);
    }
}
