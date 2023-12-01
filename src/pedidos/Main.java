package pedidos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		LocalDate dataNascimento = LocalDate.parse("2004-10-19");
		LocalDate dataAtual = LocalDate.now();
		
		Cliente c1 = new Cliente("Gianluca", "gianlucamk04@gmail.com", "12345", "Rua Castelo Branco, 132, Centro", "(47) 98832-7228", dataNascimento);
		
		Administrador ad1 = new Administrador("Pedro Ryan", "pedroscgamer@gmail.com", "16483");
		
		Produto pro1 = new Produto("Pizza", "Uma delícia", 99.99f, 40, ad1);
		
		Produto pro2 = new Produto("Hamburguer", "Uma delícia²", 25.99f, 120, ad1);
		
		Produto pro3 = new Produto("Esfirra", "Uma delícia³", 10.99f, 200, ad1);
		
		ArrayList<Produto> combo = new ArrayList<Produto>();
		combo.add(pro1);
		combo.add(pro2);
		
		Pedido ped1 = new Pedido(dataAtual, combo, c1);
		
		Pagamento pag1 = new Pagamento("Cartão", ped1);
		
		ped1.adicionarItem(pro3);
		pag1.totalPagar(ped1);
		c1.visualizarPedido(ped1);
		
		System.out.println(pag1);
		//System.out.println(ped1);
		//System.out.println(c1);
		System.out.println(ad1);
	}

}
