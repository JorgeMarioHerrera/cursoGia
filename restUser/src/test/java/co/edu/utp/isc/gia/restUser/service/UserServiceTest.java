/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restUser.service;

import co.edu.utp.isc.gia.restUser.data.entity.User;
import co.edu.utp.isc.gia.restUser.data.repository.UserRepository;
import co.edu.utp.isc.gia.restUser.web.dto.UserDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.modelmapper.ModelMapper;

/**
 *
 * @author mario
 */
public class UserServiceTest {
    
    @Mock
    private UserRepository userRepository;
    @Mock
    private ModelMapper modelMapper;

    UserDTO userdto;
    User userEntity;

    public UserServiceTest() {
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("before");
        userRepository = Mockito.mock(UserRepository.class);
        modelMapper = new ModelMapper();        
        userEntity = new User();
        userdto = new UserDTO();
    }

    @Test
    public void save() {
        userEntity = new User(1L, "mario", "mario", "marito", "mario@vorreo");
        when(userRepository.save(any(User.class))).thenReturn(userEntity);

        userdto = new UserDTO(null, "MARIO", "mario", "mario", "mario@mario");
        UserService instance = new UserService(userRepository, modelMapper);
        UserDTO expected = new UserDTO(1L, "mario", "mario", "mario", "mario@mario");

        UserDTO result = instance.save(userdto);

        assertEquals(expected.getId(), result.getId());
        assertEquals(expected.getUsername(), result.getUsername());
        assertEquals(expected, result);
    }
}
