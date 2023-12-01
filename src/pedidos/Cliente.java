package pedidos;

import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente extends Pessoa{
	
	private String endereco;
	private String numeroTel;
	private LocalDate dataNascimento;
	
	public Cliente(String nome, String email, String senha, String endereco, String numeroTel, LocalDate dataNascimento) {
		super(nome, email, senha);
		setEndereco(endereco);
		setNumeroTel(numeroTel);
		setDataNascimento(dataNascimento);
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getNumeroTel() {
		return numeroTel;
	}
	public void setNumeroTel(String numeroTel) {
		this.numeroTel = numeroTel;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void visualizarPedido(Pedido pedido) {
		System.out.println("Data: " + pedido.getData());
		System.out.println("Os produto escolhidos são: ");
		ArrayList<Produto> produto = new ArrayList<Produto>();
		produto.addAll(pedido.getProdutos());
		for (int x = 0; x < produto.size(); x++) {
			System.out.println(produto.get(x).getNome() + " | " + produto.get(x).getDescricao());
			System.out.println("Preço: " + produto.get(x).getPreco());
		}
	}
	
	public void excluirPerfil (Cliente cliente) {
		cliente = null;
		System.out.println("Perfil excluído com sucesso.");
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Cliente [endereco=");
		builder.append(endereco);
		builder.append(", numeroTel=");
		builder.append(numeroTel);
		builder.append(", dataNascimento=");
		builder.append(dataNascimento);
		builder.append(", toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

}
