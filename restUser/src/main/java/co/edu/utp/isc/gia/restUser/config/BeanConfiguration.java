/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restUser.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author mario
 */
@Configuration
public class BeanConfiguration {
    
    @Bean
    ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
    
    
}
