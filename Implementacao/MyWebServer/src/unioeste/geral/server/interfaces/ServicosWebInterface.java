package unioeste.geral.server.interfaces;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;

import unioeste.geral.banco.bo.Agencia;
import unioeste.geral.banco.bo.Banco;
import unioeste.geral.banco.bo.Cliente;
import unioeste.geral.banco.bo.ContaBancaria;
import unioeste.geral.banco.bo.Investimento;
import unioeste.geral.banco.bo.Transacao;

@WebService
public interface ServicosWebInterface {

	@WebMethod public ArrayList<Agencia> obterTodasAgencias() throws Exception;
	@WebMethod public ArrayList<Banco> obterTodosBancos() throws Exception;
	@WebMethod public Cliente obterClienteEmpresaPorCnpj(Cliente c) throws Exception;
	@WebMethod public Cliente obterClientePessoaPorCpf(Cliente c) throws Exception;
	@WebMethod public ArrayList<Investimento> obterInvestimentoPorContaBancaria(ContaBancaria cb) throws Exception;
	@WebMethod public Transacao inserirTransacao(Cliente c, ContaBancaria cb, Transacao t) throws Exception;
	@WebMethod public ArrayList<Transacao> obterTransacaoPorContaBancaria(ContaBancaria cb) throws Exception;
	
}
