/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package id.co.telkomsigma.belajarspringcache.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author anggi
 */

@Configuration
public class HazelcastConfig {
    
    @Bean
    public Config hezelCastConf(){
        return new Config()
                .setInstanceName("hezelcast-instance")
                .addMapConfig(
                        new MapConfig()
                            .setName("products")
                            .setMaxSizeConfig(
                                    new MaxSizeConfig(
                                            200,
                                            MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE
                                    )                            
                            )
                            .setEvictionPolicy(EvictionPolicy.LRU)
                            .setTimeToLiveSeconds(20)
                );  
    }
}
