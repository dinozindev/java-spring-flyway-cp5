package com.example.flywaydemo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flywaydemo.model.Produto;
import com.example.flywaydemo.repository.ProdutoRepository;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	private final ProdutoRepository produtoRepository;
	
	public ProdutoController(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@GetMapping
	public List<Produto> listar() {
		return produtoRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Produto buscarPorId(@PathVariable Long id) {
		return produtoRepository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado com ID especificado."));
	}
	
	@PostMapping
	public Produto criarProduto(@RequestBody Produto produto) {
		return produtoRepository.save(produto);
	}
}
