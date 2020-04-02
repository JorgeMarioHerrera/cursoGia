/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.utp.isc.gia.restUser.web.controller;

import co.edu.utp.isc.gia.restUser.service.UserService;
import co.edu.utp.isc.gia.restUser.web.dto.UserDTO;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mario
 */
@RestController
@RequestMapping("user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody UserDTO user) {
        UserDTO userDto = userService.save(user);

        if (userDto != null) {
            return ResponseEntity.ok(userDto);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/listarTodo")
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> dto = userService.listAll();
        if (dto == null || dto.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/buscarId/{id}")
    public ResponseEntity<UserDTO> findOne(@PathVariable("id") Long id) {
        UserDTO dto = userService.findOne(id);
        if (dto == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/borrar/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
        String dto = userService.deleteById(id);
        if (dto != null || !dto.isEmpty()) {
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<UserDTO> updateById(@PathVariable("id") Long id, @RequestBody UserDTO user) {
        UserDTO dto = this.userService.findOne(id);
        if (dto != null) {
            user.setId(dto.getId());
            dto = this.userService.save(user);
            if (dto == null) {
                return ResponseEntity.notFound().build();
            }            
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.noContent().build();
    }
}
