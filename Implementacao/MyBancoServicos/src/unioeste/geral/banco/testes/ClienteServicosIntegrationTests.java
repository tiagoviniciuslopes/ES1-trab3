package unioeste.geral.banco.testes;

import unioeste.geral.banco.bo.Cliente;
import unioeste.geral.banco.bo.ClienteEmpresa;
import unioeste.geral.banco.bo.ClientePessoa;
import unioeste.geral.banco.manager.UCClienteServicos;
import unioeste.geral.common.bo.CNPJ;
import unioeste.geral.common.bo.CPF;


public class ClienteServicosIntegrationTests {
	
	public static void main(String[] args) throws Exception{
		ClienteServicosIntegrationTests c = new ClienteServicosIntegrationTests();
		c.obterClientePorCpfMustPass();
		c.obterClientePorCnpjMustPass();
	}
	
	public void obterClientePorCpfMustPass() throws Exception{
		System.out.println("obterClientePorCpfMustPass");
		
		UCClienteServicos uc = new UCClienteServicos();
		Cliente c = new Cliente();
		ClientePessoa cp = new ClientePessoa();
		CPF cpf = new CPF();
		
		cpf.setNumeroDoc("09722879901");
		cp.setCpf(cpf);
		c.setClientePessoa(cp);
		
		c = uc.obterClientePessoaPorCpf(c);
		
		if(c == null) {
			System.out.println("O cliente retornou nulo");
			throw new Exception();
		}else {
			System.out.println("Sucesso");
		}
	}
	
	public void obterClientePorCnpjMustPass() throws Exception{
		System.out.println("obterClientePorCnpjMustPass");
		UCClienteServicos uc = new UCClienteServicos();
		Cliente c = new Cliente();
		ClienteEmpresa ce = new ClienteEmpresa();
		CNPJ cnpj = new CNPJ();
		
		cnpj.setNumeroDoc("32864581000104");
		ce.setCnpj(cnpj);
		c.setClienteEmpresa(ce);
		
		c = uc.obterClienteEmpresaPorCnpj(c);
		
		if(c == null) {
			System.out.println("O cliente retornou nulo");
			throw new Exception();
		}else {
			System.out.println("Sucesso");
		}
	}
}
