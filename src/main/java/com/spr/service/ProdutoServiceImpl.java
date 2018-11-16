package com.spr.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spr.exception.ProdutoNotFound;
import com.spr.model.Produto;
import com.spr.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	@Resource
	private ProdutoRepository produtoRepository;

	@Override
	@Transactional
	public Produto create(Produto produto) {
		Produto criaProduto = produto;
		return produtoRepository.save(criaProduto);
	}
	
	@Override
	@Transactional
	public Produto findById(int id) {
		return produtoRepository.findOne(id);
	}

	@Override
	@Transactional(rollbackFor=ProdutoNotFound.class)
	public Produto delete(int id) throws ProdutoNotFound {
		Produto deleteProduto = produtoRepository.findOne(id);
		
		if (deleteProduto == null)
			throw new ProdutoNotFound();
		
		produtoRepository.delete(deleteProduto);
		return deleteProduto;
	}

	@Override
	@Transactional
	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	@Override
	@Transactional(rollbackFor=ProdutoNotFound.class)
	public Produto update(Produto produto) throws ProdutoNotFound {
		Produto updateProduto = produtoRepository.findOne(produto.getId());
		
		if (updateProduto == null)
			throw new ProdutoNotFound();
		
		updateProduto.setNome(produto.getNome());
		updateProduto.setQtdProduto(produto.getQtdProduto());
		updateProduto.setMarca(produto.getMarca());
		updateProduto.setModelo(produto.getModelo());
		updateProduto.setDescricao(produto.getDescricao());
		
		return updateProduto;
	}

}
