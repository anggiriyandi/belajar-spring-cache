/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.telkomsigma.belajarspringcache.dao;

import id.co.telkomsigma.belajarspringcache.domain.Product;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author anggi
 */

public interface ProductDao extends PagingAndSortingRepository<Product, String>{
    
    public Product findByName(String name);
    public Product findByCode(String code);
    
    @Query("select p from Product p where p.name=:name")
    public List<Product> findDataByname (@Param("name") String name);
}
