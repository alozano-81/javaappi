package com.prueba.test.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import com.prueba.test.model.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long> {

    @Query(value = " select id_usuario,nombre,id_rol from system.usuario ", nativeQuery = true)
    List<Object[]> buscar();

}
