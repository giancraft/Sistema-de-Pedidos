package pedidos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {
	
	private LocalDate data;
	private ArrayList<Produto> produtos;
	private Cliente cliente;
	
	public Pedido(LocalDate data, ArrayList<Produto> produtos, Cliente cliente) {
		setData(data);
		setProdutos(produtos);
		setCliente(cliente);
	}
	
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public ArrayList<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void adicionarItem(Produto produto) {
		produtos.add(produto);
	}
	
	public void removerItem(Produto produto) {
		for (int i = 0; i < produtos.size(); i++) {
			if (produto == produtos.get(i)) {
				produtos.remove(i);
				i = produtos.size();
			}
		}
	}
	
	public void excluirPedido(Pedido pedido) {
		pedido = null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pedido [data=");
		builder.append(data);
		builder.append(", produtos=");
		builder.append(produtos);
		builder.append(", cliente=");
		builder.append(cliente);
		builder.append("]");
		return builder.toString();
	}
	

}
