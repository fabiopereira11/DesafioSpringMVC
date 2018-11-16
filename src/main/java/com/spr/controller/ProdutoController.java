package com.spr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spr.exception.ProdutoNotFound;
import com.spr.model.Produto;
import com.spr.service.ProdutoService;
import com.spr.validation.ProdutoValidator;

@Controller
@RequestMapping(value="/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ProdutoValidator produtoValidator;
	
	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(produtoValidator);
	}

	@RequestMapping(value="/create", method=RequestMethod.GET)
	public ModelAndView newShopPage() {
		ModelAndView mav = new ModelAndView("produto-new", "produto", new Produto());
		return mav;
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView criarNovoProduto(@ModelAttribute @Valid Produto produto,
			BindingResult result,
			final RedirectAttributes redirectAttributes) {
		
		if (result.hasErrors())
			return new ModelAndView("produto-new");
		
		ModelAndView mav = new ModelAndView();
		String message = "Seu produto "+produto.getNome()+" foi incluido com sucesso.";
		
		produtoService.create(produto);
		mav.setViewName("redirect:/produto/create.html");
				
		redirectAttributes.addFlashAttribute("message", message);	
		return mav;		
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView shopListPage() {
		ModelAndView mav = new ModelAndView("produto-list");
		List<Produto> produtoList = produtoService.findAll();
		mav.addObject("produtoList", produtoList);
		return mav;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)
	public ModelAndView editShopPage(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("produto-edit");
		Produto produto = produtoService.findById(id);
		mav.addObject("produto", produto);
		return mav;
	}
	
	@RequestMapping(value="/edit/{id}", method=RequestMethod.POST)
	public ModelAndView editShop(@ModelAttribute @Valid Produto produto,
			BindingResult result,
			@PathVariable Integer id,
			final RedirectAttributes redirectAttributes) throws ProdutoNotFound {
		
		if (result.hasErrors())
			return new ModelAndView("produto-edit");
		
		ModelAndView mav = new ModelAndView("redirect:/produto/list.html");
		String message = "Produto alterado com sucesso.";

		produtoService.update(produto);
		
		redirectAttributes.addFlashAttribute("message", message);	
		return mav;
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public ModelAndView deleteShop(@PathVariable Integer id,
			final RedirectAttributes redirectAttributes) throws ProdutoNotFound {
		
		ModelAndView mav = new ModelAndView("redirect:/produto/list.html");		
		
		Produto produto = produtoService.delete(id);
		String message = "O produto "+produto.getNome()+" foi deletado com sucesso.";
		
		redirectAttributes.addFlashAttribute("message", message);
		return mav;
	}
	
}
