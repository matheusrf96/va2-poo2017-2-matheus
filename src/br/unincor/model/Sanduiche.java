package br.unincor.model;

/**
 * Implementar relacionamento de herança
 * com a classe "Produto"
 *
 */
public class Sanduiche extends Produto{
	
	private Boolean trio; //Define se adiciona batata e refrigerante - sem validação
	private Boolean dobroRecheio; //Define se terá o dobro de recheio - sem validação
	
	/** Criar um construtor que recebe todos os atributos como parâmetro **/
	public Sanduiche(String nome, Double preco, Boolean trio, Boolean dobroRecheio) {
		super(nome, preco);
		this.trio = trio;
		this.dobroRecheio = dobroRecheio;
	}

	/** Criar getters e setters **/
	public Boolean getTrio() {
		return trio;
	}

	public void setTrio(Boolean trio) {
		this.trio = trio;
	}

	public Boolean getDobroRecheio() {
		return dobroRecheio;
	}

	public void setDobroRecheio(Boolean dobroRecheio) {
		this.dobroRecheio = dobroRecheio;
	}

	/** Implementar para mostrar os valores de todos os atributos **/
	public String verDados() {
		return super.verDados() +
				"\n-- SANDUÍCHE --" +
				"\nTrio: " + this.trio +
				"\nDobro de recheio: " + this.dobroRecheio;
	}	
	
}
