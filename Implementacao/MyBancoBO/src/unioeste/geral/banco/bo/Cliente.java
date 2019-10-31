package unioeste.geral.banco.bo;
public class Cliente {

	private ClienteEmpresa clienteEmpresa;

	private ClientePessoa clientePessoa;

	private ContaBancaria[] contaBancaria;

	public ClienteEmpresa getClienteEmpresa() {
		return clienteEmpresa;
	}

	public void setClienteEmpresa(ClienteEmpresa clienteEmpresa) {
		this.clienteEmpresa = clienteEmpresa;
	}

	public ClientePessoa getClientePessoa() {
		return clientePessoa;
	}

	public void setClientePessoa(ClientePessoa clientePessoa) {
		this.clientePessoa = clientePessoa;
	}

	public ContaBancaria[] getContaBancaria() {
		return contaBancaria;
	}

	public void setContaBancaria(ContaBancaria[] contaBancaria) {
		this.contaBancaria = contaBancaria;
	}

}
