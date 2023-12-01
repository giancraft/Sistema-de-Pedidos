package pedidos;

public class Administrador extends Pessoa{
	
	public Administrador(String nome, String email, String senha) {
		super(nome, email, senha);
	}
	
	public void visualizarProduto(Produto produto) {
		System.out.println(produto.getNome() + " | " +  produto.getDescricao());
		System.out.println("Preço: " + produto.getPreco());
		System.out.println("Quantidade: " + produto.getQuantidade());
	}
	
	public void excluirPerfil(Administrador administrador) {
		administrador = null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Administrador [toString()=");
		builder.append(super.toString());
		builder.append("]");
		return builder.toString();
	}

}
