package br.unincor.exception;

import br.unincor.model.Produto;

/**
 * Receber um objeto "Produto" via
 * construtor e implementar o método
 * 'getMessage()' retornando o texto:
 * 
 * "O produto <nome do produto> está com o preço zerado!"
 *
 */
public class PrecoZeradoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private Produto prod;
	
	public PrecoZeradoException(Produto prod) {
		super();
		this.prod = prod;
	}
	
	@Override
	public String getMessage() {
		return "O preço final do produto '" + this.prod.getNome() + "' está zerado!";
	}

}
