package unioeste.geral.banco.testes;

import unioeste.geral.banco.bo.Agencia;
import unioeste.geral.banco.bo.Banco;
import unioeste.geral.banco.bo.Cliente;
import unioeste.geral.banco.bo.ClientePessoa;
import unioeste.geral.banco.bo.ContaBancaria;
import unioeste.geral.banco.bo.TipoModalidadeContaBancaria;
import unioeste.geral.banco.bo.TipoTransacao;
import unioeste.geral.banco.bo.Transacao;
import unioeste.geral.banco.manager.UCTransacaoServicos;
import unioeste.geral.common.bo.CPF;

public class TransacaoServicosIntegrationTests {
	
	public static void main(String[] args) throws Exception{
		TransacaoServicosIntegrationTests t = new TransacaoServicosIntegrationTests();
		
		t.inserirTransacaoMustPass();
	}
	
	public void inserirTransacaoMustPass() throws Exception {
		Transacao t = new Transacao();
		UCTransacaoServicos uc = new UCTransacaoServicos();
		Cliente c = new Cliente();
		ClientePessoa cp = new ClientePessoa();
		CPF cpf = new CPF();
		TipoModalidadeContaBancaria tmcb = new TipoModalidadeContaBancaria();
		Agencia a = new Agencia();
		Banco b = new Banco();
		ContaBancaria cb = new ContaBancaria();
		ContaBancaria contaBancaria = new ContaBancaria();
		TipoTransacao tipoTransacao = new TipoTransacao();
		
		tipoTransacao.setIdTipoTransacao(4);
		b.setIdBanco(1);
		a.setIdAgencia(1);
		tmcb.setIdModalidadeContaBancaria(3);
		cb.setAgencia(a);
		cb.setBanco(b);
		cb.setIdContaBancaria(1);
		cb.setTipoModalidadeContaBancaria(tmcb);
		t.setContaBancaria(cb);
		t.setTipoTransacao(tipoTransacao);
		t.setValorTransferencia(500);	
		cpf.setNumeroDoc("09722879901");
		cp.setCpf(cpf);
		c.setClientePessoa(cp);
		c.setClienteEmpresa(null); //Cliente recebendo a transacao
		
		contaBancaria.setIdContaBancaria(2);// Cliente fazendo a transacao
		
		t = uc.inserirTransacao(c, contaBancaria, t);
		
		if(t.getIdTransferencia() <=0) {
			throw new Exception("Erro ao cadastrar transação");
		}else {
			System.out.println("Sucesso");
		}
		
		
		
	}
	
}
