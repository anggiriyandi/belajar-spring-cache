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
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 *
 * @author anggi
 */
@Service
@CacheConfig(cacheNames = "products")
public class ProductService {

    @Autowired
    private ProductDao productDao;

    Logger logger = LoggerFactory.getLogger(ProductDao.class);

    @Cacheable(key = "#name")
    public List<Product> findProductListByName(String name) {
        logger.info("MEMANGGIL SERVICE FIND PRODUCT BY NAME !!");
        return productDao.findDataByname(name);
    }
    
    @Cacheable(key = "#name")
    public Product findProductByName(String name) {
        logger.info("MEMANGGIL SERVICE FIND PRODUCT BY NAME !!");
        return productDao.findByName(name);
    }

    @Cacheable(key = "#code")
    public Product findProductByCode(String code) {
        logger.info("MEMANGGIL SERVICE FIND PRODUCT BY CODE !!");
        return productDao.findByCode(code);
    }
    
    
    @CachePut(key = "#name")
    public Product updateProductName(String id, String name){
        logger.info("MEMANGGIL SERVICE UPDATE PRODUCT NAME !!");
        Product p = productDao.findOne(id);
        p.setName(name);
        
        productDao.save(p);
        return p;
    }
    
    @CacheEvict(key = "#name")
    public void deleteCacheProductByName(String name){
    }
}
