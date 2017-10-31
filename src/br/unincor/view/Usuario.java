package br.unincor.view;

import javax.swing.JOptionPane;

public class Usuario {
	
	public void exibeMsg(String texto) {
		JOptionPane.showMessageDialog(null, texto, "MENSAGEM", JOptionPane.INFORMATION_MESSAGE);
	}

	public void exibeMsgErro(String texto) {
		JOptionPane.showMessageDialog(null, texto, "ERRO", JOptionPane.ERROR_MESSAGE);
	}

	public int exibeMenuPrincipal(){
		Object[] opcoes = { "Sanduiche", "Sobremesa", "Finalizar Pedido" };
		
		int escolha = JOptionPane.showOptionDialog(null, 
		    "Escolha o produto?",
		    "Menu Principal", 
		    JOptionPane.YES_NO_OPTION, 
		    JOptionPane.QUESTION_MESSAGE, 
		    null, 
		    opcoes, 
		    opcoes[0]);

		return escolha;
	}
	
	public Integer exibeMenuPagamento(){
		Object[] opcoes = { "Dinheiro", "Cartão" };
		
		int escolha = JOptionPane.showOptionDialog(null, 
		    "Forma de pagamento",
		    "Pagamento", 
		    JOptionPane.YES_NO_OPTION, 
		    JOptionPane.QUESTION_MESSAGE, 
		    null, 
		    opcoes, 
		    opcoes[0]);

		return escolha;
	}
	

	public Double recebeDouble(String texto) {
		int f = 0;
		
		while(f == 0){
			try {
				String resposta = JOptionPane.showInputDialog(texto);
				Double respostaConvertida = Double.parseDouble(resposta);
				f = 1;
				
				return respostaConvertida;
			} catch (Exception e) {
				exibeMsg("Entrada inválida!");
				f = 0;
			}
		}
		return null;
	}
	
	public Boolean recebeBoolean(String texto) {
		Integer op = JOptionPane.showConfirmDialog(null, texto);

		if (op == 0)
			return true;
		return false;
	}

	public String recebeTexto(String texto) {
		return JOptionPane.showInputDialog(texto);
	}
}
