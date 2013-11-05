package com.spr.service;

import java.util.List;

import com.spr.exception.ProdutoNotFound;
import com.spr.model.Produto;

public interface ProdutoService {
	
	public Produto create(Produto produto);
	public Produto delete(int id) throws ProdutoNotFound;
	public List<Produto> findAll();
	public Produto update(Produto produto) throws ProdutoNotFound;
	public Produto findById(int id);

}
