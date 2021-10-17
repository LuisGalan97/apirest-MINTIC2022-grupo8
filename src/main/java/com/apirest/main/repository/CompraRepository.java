package com.apirest.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apirest.main.entity.Compra;

@Repository
public interface CompraRepository extends JpaRepository<Compra, Long> {

}
