/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.telkomsigma.belajarspringcache.controller;

import id.co.telkomsigma.belajarspringcache.domain.Product;
import id.co.telkomsigma.belajarspringcache.service.ProductService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
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
    
    @Autowired
    private CacheManager cacheManager;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping("/findProduct/name/{name}")
    public Product findProductByName(@PathVariable("name") String name){
        logger.info("CONTROLLER UNTUK FIND PRODUCT BY NAME !!");
        logger.info("PROVIDER YANG DIGUNAKAN : {}",cacheManager.getClass().getName());
        return productService.findProductByName(name);
    }

    @GetMapping("/findProduct/code/{code}")
    public Product findProductByCode(@PathVariable("code") String code){
        logger.info("CONTROLLER UNTUK FIND PRODUCT BY Code !!");
        return productService.findProductByCode(code);
    }
    
    
    @GetMapping("/findProductList/name/{name}")
    public List<Product> findProductList(@PathVariable("name") String name) {
        logger.info("CONTROLLER UNTUK FIND PRODUCT BY Code !!");
        return productService.findProductListByName(name);
    }

    
    @GetMapping("/updateProduct/name/{id}/{name}")
    public String UpdateProduct(
            @PathVariable("id") String id,
            @PathVariable("name") String name){
        logger.info("UPDATE PRODUCT NAME DENGAN ID {} MENJADI {}",id,name);
        productService.updateProductName(id, name);
        return "DATA BERHASIL DI UPDATE !!";
    }
    
    @GetMapping("/deleteCacheProduct/name/{name}")
    public String deleteCacheProductByName(@PathVariable("name") String name){
        productService.deleteCacheProductByName(name);
        return "cache berhasil dihapus !!";
    }
}
