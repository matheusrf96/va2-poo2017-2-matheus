package br.unincor.model;

import java.text.DecimalFormat;

public class Produto {
	
	private String nome;
	private Double preco; //Valor do produto - deve ser um valor positivo (setar 'null' caso contrário)
	
	public Produto(String nome, Double preco) {
		super();
		this.nome = nome;
		
		if(preco >= 0)
			this.preco = preco;
		else
			this.preco = null;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		if(preco >= 0)
			this.preco = preco;
		else
			this.preco = null;
	}
	
	public String verDados() {
		DecimalFormat df = new DecimalFormat("0.00"); //Formatando o preço com 2 casas decimais
		return "Nome: " + this.nome + "\nPreço: R$ " + df.format(this.preco); 
	}
}
