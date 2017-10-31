package br.unincor.controle;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import br.unincor.exception.PrecoZeradoException;
import br.unincor.model.Produto;
import br.unincor.model.Sanduiche;
import br.unincor.model.Sobremesa;
import br.unincor.view.Usuario;

public class Main {

	public static void main(String[] args) {
		
		/**
		 * 1. Exibir o menu principal, onde o usuário deverá escolher
		 * qual produto deseja (sanduíche ou sobremesa), também deve-se ter a
		 * opção de “Finalizar pedido”.
		 * 
		 * 2. De acordo com a opção escolhida receber todos os atributos do
		 * produto desejado (nome, preço, trio e dobro de recheio para sanduíche
		 * e nome, preço e adicionais para sobremesa).
		 * 
		 * 3. Após a criação do produto, adicioná-lo na lista de produtos.
		 * 
		 * 4. Exibir o menu de pagamento com as opções “Dinheiro” e “Cartão”.
		 * Caso não seja selecionada nenhuma opção, considerar que o pagamento
		 * será feito em dinheiro.
		 * 
		 * 5. Para cada produto da lista calcular o seu valor final (utilizando
		 * os métodos da classe CalculaPreco) e salvá-lo no atributo ‘preco’.
		 * Tratar a exceção de preço zerado.
		 * 
		 * 6. Somar o valor final de todos os produtos para obter o valor total do pedido.
		 * 
		 * 7. Ao final do processamento do pedido, exibir um resumo do pedido com o preço
		 * final de cada produto e valor final do pedido.
		 * 
		 */
		
		List<Produto> listaProdutos = new ArrayList<Produto>();
		Usuario gui = new Usuario();
		CalculoPrecos cp = new CalculoPrecos();

		
		while(true){
			int opcao = gui.exibeMenuPrincipal();
			
			if(opcao == -1 || opcao == 2) {
				break;
			}
			else if(opcao == 0) {
				Sanduiche sand = new Sanduiche(
						gui.recebeTexto("Entre com o nome do Produto:"),
						gui.recebeDouble("Preço:"),
						gui.recebeBoolean("Trio?"),
						gui.recebeBoolean("Dobro de Recheio?")
					);
				
				listaProdutos.add(sand);
			}
			else if(opcao == 1) {
				Sobremesa sm = new Sobremesa(
						gui.recebeTexto("Entre com o nome da Sobremesa:"),
						gui.recebeDouble("Preço: "),
						gui.recebeBoolean("Adicionais?")
					);
				
				listaProdutos.add(sm);
			}
		}
		
		double totalPedido = 0d;
		String resumoPedido = "Resumo do pedido:\n";
		
		int pagamento = gui.exibeMenuPagamento();
		
		for(int i = 0; i < listaProdutos.size(); i++){
			try{
				cp.calculaPrecoFinal(listaProdutos.get(i));
				
				if(pagamento == 0 || pagamento == -1)
					cp.pagtoDinheiro(listaProdutos.get(i));
				else if(pagamento == 1)
					cp.pagtoCartao(listaProdutos.get(i));
				
				totalPedido += listaProdutos.get(i).getPreco();
				resumoPedido += listaProdutos.get(i).verDados() + "\n";
					
				
			}catch(PrecoZeradoException pze){
				gui.exibeMsgErro(pze.getMessage());
			}
		}
		
		DecimalFormat f = new DecimalFormat("R$ 0.00");
		
		resumoPedido += "\n" + "Valor final: " + f.format(totalPedido);
		gui.exibeMsg(resumoPedido);
		
		
	}
}