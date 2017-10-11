/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.telkomsigma.belajarspringcache.service;

import id.co.telkomsigma.belajarspringcache.dao.ProductDao;
import id.co.telkomsigma.belajarspringcache.domain.Product;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author anggi
 */

@Service
public class ProductService {
    
    @Autowired
    private ProductDao productDao;
    
    Logger logger = LoggerFactory.getLogger(ProductDao.class);
        
    @Cacheable(value="products", key="#name")
    public Product findProductByName(String name){
        logger.info("MEMANGGIL SERVICE FIND PRODUCT BY NAME !!");
        return productDao.findByName(name);
    }
    
    @Cacheable(value="products", key="#code")
    public Product findProductByCode(String code){
        logger.info("MEMANGGIL SERVICE FIND PRODUCT BY CODE !!");
        return productDao.findByCode(code);
    } 
}
