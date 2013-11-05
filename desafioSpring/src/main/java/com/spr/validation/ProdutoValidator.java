package com.spr.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.spr.model.Produto;

@Component
public class ProdutoValidator implements Validator {
	
	private final static String QUANTIDADE_PRODUTO = "qtdProduto";

	@Override
	public boolean supports(Class<?> clazz) {
		return Produto.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Produto produto = (Produto) target;
		
		Integer qtdProduto = produto.getQtdProduto();
		
		ValidationUtils.rejectIfEmpty(errors, "nome", "produto.nome.empty");
		ValidationUtils.rejectIfEmpty(errors, QUANTIDADE_PRODUTO, "produto.qtdProduto.empty");
		
		if (qtdProduto != null && qtdProduto < 1)
			errors.rejectValue(QUANTIDADE_PRODUTO, "produto.qtdProduto.lessThenOne");

	}

}
