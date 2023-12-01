package pedidos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class CadastroCliente {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		boolean esc = true;
		
		System.out.print("Olá! Se você deseja se cadastrar, digite (0). Se não, digite outro número: ");
		int resp1 = entrada.nextInt();
		
		if (resp1 == 0) {
			entrada.nextLine();
			System.out.print("Digite seu nome: ");
			String nome = entrada.nextLine();
			
			System.out.print("Digite seu email: ");
			String email = entrada.nextLine();
			
			System.out.print("Digite sua senha: ");
			String senha = entrada.nextLine();
			
			System.out.print("Digite seu endereço: ");
			String endereco = entrada.nextLine();
			
			System.out.print("Digite seu número de telefone: ");
			String numTel = entrada.nextLine();
			
			System.out.print("Digite sua data de nascimento: ");
			String dataNasc = entrada.nextLine();
			
			LocalDate dataNascimento = LocalDate.parse(dataNasc);
			
			Cliente cli1 = new Cliente(nome, email, senha, endereco, numTel, dataNascimento);
			
			System.out.println("Os dados cadastrados são:");
			System.out.println("Nome: " + cli1.getNome());
			System.out.println("Email: " + cli1.getEmail());
			System.out.println("Senha: " + cli1.getSenha());
			System.out.println("Endereço: " + cli1.getEndereco());
			System.out.println("Número de Telefone: " + cli1.getNumeroTel());
			System.out.println("Data de Nascimento: " + cli1.getDataNascimento());
			
			int resp;
			System.out.print("Deseja mudar alguma informação do seu perfil? se sim, digite (0). Se não, digite outro número: ");
			resp = entrada.nextInt();
			
			do {
				if (resp == 0) {
					System.out.print("Digite 1 - nome, 2 - email, 3 - senha, 4 - endereço, 5 - telefone, 6 - dataNascimento: ");
					resp = entrada.nextInt();
					
					while (resp < 1 && resp > 6) {
						System.out.print("Opção inválida. Digite uma opção válida: ");
						resp = entrada.nextInt();
					}
					entrada.nextLine();
					System.out.print("Antes de modificar, digite seu email para verificação: ");
					email = entrada.nextLine();
				
					System.out.print("Agora sua senha para verificação: ");
					senha = entrada.nextLine();
				
					if (email.equals(cli1.getEmail()) && senha.equals(cli1.getSenha())) {
						if (resp == 1) {
							System.out.print("Digite o nome atualizado: ");
							nome = entrada.nextLine();
							cli1.setNome(nome);
						} else if (resp == 2) {
							System.out.print("Digite o email atualizado: ");
							email = entrada.nextLine();
							cli1.setEmail(email);
						} else if (resp == 3) {
							System.out.print("Digite a senha atualizada: ");
							senha = entrada.nextLine();
							cli1.setSenha(senha);
						} else if (resp == 4) {
							System.out.print("Digite o endereço atualizado: ");
							endereco = entrada.nextLine();
							cli1.setEndereco(endereco);
						} else if (resp == 5) {
							System.out.print("Digite o telefone atualizado: ");
							numTel = entrada.nextLine();
							cli1.setNumeroTel(numTel);
						} else {
							System.out.println("Digite a data de nascimento atualizada: ");
							dataNasc = entrada.nextLine();
							dataNascimento = LocalDate.parse(dataNasc);
							cli1.setDataNascimento(dataNascimento);
						}
					} else {
						System.out.println("Email ou Senha incorreto.");
					}
					System.out.print("Deseja mudar mais alguma informação? Se sim, digite (0). Se não, digite outro número: ");
					resp = entrada.nextInt();
				}
			} while (resp == 0);
			
			System.out.print("Deseja excluir o seu perfil? Se sim, digite (0). Se não, digite outro número: ");
			resp = entrada.nextInt();
			
			if (resp == 0) {
				entrada.nextLine();
				System.out.print("Antes de efetuar a ação, digite seu email para verificação: ");
				email = entrada.nextLine();
				
				System.out.print("Agora sua senha para verificação: ");
				senha = entrada.nextLine();
				
				if (email.equals(cli1.getEmail()) && senha.equals(cli1.getSenha())) {
					cli1.excluirPerfil(cli1);
				} else {
					System.out.println("Email ou Senha incorreto.");
				}
			} else {
			
				Administrador adm = new Administrador("Pedro", "pedrorhd@gmail.com", "senha");
				
				Produto pro1 = new Produto("1 - Pizza", "Uma delícia", 99.99f, 200, adm);
			
				Produto pro2 = new Produto("2 - Hamburguer", "Uma delícia²", 25.99f, 120, adm);
			
				Produto pro3 = new Produto("3 - Esfirra", "Uma delícia³", 10.99f, 20, adm);
			
				ArrayList<Produto> escolha = new ArrayList<Produto>();
				
				System.out.println("Se desejar realizar o seu pedido, digite (0). Caso não queira fazer mais nada, digite qualquer outro número");
				resp = entrada.nextInt();
				
				do {
					if (resp == 0) {
				
						System.out.println("Os pedidos que possuímos no catálogo são:");
						System.out.println(pro1.getNome() + " | " + pro1.getDescricao());
						System.out.println("Preço: " + pro1.getPreco());
				
						System.out.println(pro2.getNome() + " | " + pro2.getDescricao());
						System.out.println("Preço: " + pro2.getPreco());
				
						System.out.println(pro3.getNome() + " | " + pro3.getDescricao());
						System.out.println("Preço: " + pro3.getPreco());
				
						System.out.print("O que você gostaria de pedir? Digite o número referente ao pedido: ");
						resp = entrada.nextInt();
				
						do {
							if ((resp == 1 && pro1.getQuantidade() == 0) || (resp == 2 && pro2.getQuantidade() == 0) || (resp == 3 && pro3.getQuantidade() == 0 || resp < 1 || resp > 3)) {
								esc = false;
								System.out.print("Opção inválida. Escolha outra opção: ");
								resp = entrada.nextInt();
							} else
								esc = true;
						} while (!(esc));
			
						if (resp == 1) {
							escolha.add(pro1);
							pro1.setQuantidade(pro1.getQuantidade() - 1);
						} else if (resp == 2) {
							escolha.add(pro2);
							pro2.setQuantidade(pro2.getQuantidade() - 1);
						} else {
							escolha.add(pro3);
							pro3.setQuantidade(pro3.getQuantidade() - 1);
						}
				
						LocalDate dataAtual = LocalDate.now();
						Pedido ped1 = new Pedido(dataAtual, escolha, cli1);
				
						do {
							System.out.print("Deseja adicionar mais algum produto? Se sim, digite (0). Caso não queira, digite qualquer outro número: ");
							resp = entrada.nextInt();
							if (resp == 0) {
								System.out.println("Os pedidos que possuímos no catálogo são:");
								System.out.println(pro1.getNome() + " | " + pro1.getDescricao());
								System.out.println("Preço: " + pro1.getPreco());
						
								System.out.println(pro2.getNome() + " | " + pro2.getDescricao());
								System.out.println("Preço: " + pro2.getPreco());
						
								System.out.println(pro3.getNome() + " | " + pro3.getDescricao());
								System.out.println("Preço: " + pro3.getPreco());
						
								System.out.print("O que você gostaria de pedir? Digite o número referente ao pedido: ");
								resp1 = entrada.nextInt();
								
								do {
									if ((resp1 == 1 && pro1.getQuantidade() == 0) || (resp1 == 2 && pro2.getQuantidade() == 0) || (resp1 == 3 && pro3.getQuantidade() == 0)) {
										esc = false;
										System.out.print("Opção inválida. Escolha outra opção: ");
										resp1 = entrada.nextInt();
									} else
										esc = true;
								} while (!(esc));
								
								if (resp1 == 1) {
									ped1.adicionarItem(pro1);
									pro1.setQuantidade(pro1.getQuantidade() - 1);
								} else if (resp1 == 2) {
									ped1.adicionarItem(pro2);
									pro2.setQuantidade(pro2.getQuantidade() - 1);
								} else if (resp1 == 3){
									ped1.adicionarItem(pro3);
									pro3.setQuantidade(pro3.getQuantidade() - 1);
								} else {
									System.out.println("Produto inválido. Tente novamente.");
								}
							}
						} while (resp == 0);
				
						do {
							System.out.print("Deseja remover algum produto? Se sim, digite (0). Se não, digite qualquer número: ");
							resp = entrada.nextInt();
					
							if (resp == 0) {
								System.out.print("Digite o produto você deseja remover: ");
								resp1 = entrada.nextInt();
						
								if (resp1 == 1) {
									ped1.removerItem(pro1);
								} else if (resp1 == 2) {
									ped1.removerItem(pro2);
								} else if (resp1 == 3) {
									ped1.removerItem(pro3);
								} else {
									System.out.println("Produto não encontrado. Tente novamente.");
								}
							}
						} while (resp == 0);
				
						entrada.nextLine();
						System.out.print("Caso queira visualizar o seu pedido, digite (0), se não, digite qualquer outro número: ");
						resp = entrada.nextInt();
				
						if (resp == 0) {
							cli1.visualizarPedido(ped1);
						}
				
						System.out.print("Caso queira deletar o seu pedido, digite (0). Caso não queira, digite qualquer número: ");
						resp = entrada.nextInt();
				
						if (resp == 0) {
							ped1.excluirPedido(ped1);
							System.out.println("Pedido deletado com sucesso.");
							escolha.clear();
						} else {
							System.out.print("Como pagamento, digite o método a ser utilizado (exemplo: dinheiro): ");
							entrada.nextLine();
							String forma = entrada.nextLine();
				
							Pagamento pag1 = new Pagamento (forma, ped1);
							pag1.totalPagar(ped1);
				
							System.out.println("Os dados em relação ao pagamento são: ");
							System.out.println("Método de Pagamento: " + pag1.getMetodoPagamento());
							System.out.println("Total a pagar: " + pag1.getValorPagar());
						
							System.out.println("Pedido realizado com sucesso.");
						}
						System.out.print("Se Desejar realizar outro pedido, digite (0). Caso não queira, digite outro número: ");
						resp = entrada.nextInt();
						escolha.clear();
					}
				} while (resp == 0);
			}
		}
		System.out.println("Sistema encerrado.");
		entrada.close();
		}
	}
