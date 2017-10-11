package id.co.telkomsigma.belajarspringcache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BelajarSpringCacheApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(BelajarSpringCacheApplication.class, args);
    }
}
