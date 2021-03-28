package com.prueba.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.util.Optional;
import java.util.ArrayList;
import java.util.List;

import com.prueba.test.ViewModels.UsuarioViewModel;
import com.prueba.test.model.Usuario;
import com.prueba.test.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import java.math.BigDecimal;

@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> find(@PathVariable("id") final Long id) {
        // repository.findById(id)
        List<Object[]> ver = repository.buscar();
        System.out.println("Verr; " + ver.get(0)[0].getClass().getSimpleName());
        List<UsuarioViewModel> lista = new ArrayList<UsuarioViewModel>();
        for (int i = 0; i < ver.size(); i++) {
            UsuarioViewModel obj = new UsuarioViewModel();
            obj.setIdUsuario((BigDecimal) ver.get(i)[0]);
            obj.setNombre((String) ver.get(i)[1]);
            obj.setIdRol((BigDecimal) ver.get(i)[2]);
            lista.add(obj);
        }
        return ResponseEntity.ok(lista);
    }

    @RequestMapping(value = "/prueba", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> prueba() {
        return ResponseEntity.ok("ok");
    }

}
