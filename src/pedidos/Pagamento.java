package pedidos;

public class Pagamento {
	
	private String metodoPagamento; //se é cartão, dinheiro ou pix
	private Pedido pedido;
	private float valorPagar;
	
	public Pagamento(String metodoPagamento, Pedido pedido) {
		setMetodoPagamento(metodoPagamento);
		setPedido(pedido);
	}
	
	public String getMetodoPagamento() {
		return metodoPagamento;
	}
	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	public float getValorPagar() {
		return valorPagar;
	}
	public void setValorPagar(float valorPagar) {
		this.valorPagar = valorPagar;
	}
	
	public void totalPagar(Pedido pedido) {
		for (int i = 0; i < pedido.getProdutos().size(); i++)
			valorPagar += pedido.getProdutos().get(i).getPreco();
		setValorPagar(valorPagar);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pagamento [metodoPagamento=");
		builder.append(metodoPagamento);
		builder.append(", pedido=");
		builder.append(pedido);
		builder.append(", valorPagar=");
		builder.append(valorPagar);
		builder.append("]");
		return builder.toString();
	}
	

}
