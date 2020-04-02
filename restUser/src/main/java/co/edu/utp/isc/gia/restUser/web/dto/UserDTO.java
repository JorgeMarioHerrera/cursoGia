/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restUser.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author mario
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {
    
    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;
    
}
