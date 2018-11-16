package com.spr.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spr.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
