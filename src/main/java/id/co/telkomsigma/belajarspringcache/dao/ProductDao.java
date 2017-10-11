/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.telkomsigma.belajarspringcache.dao;

import id.co.telkomsigma.belajarspringcache.domain.Product;
import java.io.Serializable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author anggi
 */

public interface ProductDao extends PagingAndSortingRepository<Product, String>{
    
    public Product findByName(String name);
    public Product findByCode(String code);
}
