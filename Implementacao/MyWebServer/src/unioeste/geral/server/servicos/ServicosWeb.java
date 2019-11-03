package unioeste.geral.server.servicos;

import java.util.ArrayList;

import javax.jws.WebService;

import unioeste.geral.banco.bo.Agencia;
import unioeste.geral.banco.bo.Banco;
import unioeste.geral.banco.bo.Cliente;
import unioeste.geral.banco.bo.ContaBancaria;
import unioeste.geral.banco.bo.Investimento;
import unioeste.geral.banco.bo.Transacao;
import unioeste.geral.banco.manager.UCAgenciaServicos;
import unioeste.geral.banco.manager.UCBancoServicos;
import unioeste.geral.banco.manager.UCClienteServicos;
import unioeste.geral.banco.manager.UCInvestimentoServicos;
import unioeste.geral.banco.manager.UCTransacaoServicos;
import unioeste.geral.server.interfaces.ServicosWebInterface;

@WebService(endpointInterface = "unioeste.geral.server.servicos.ServicosWeb")
public class ServicosWeb implements ServicosWebInterface {
	
		public ServicosWeb() {
			super();
		}

		@Override
		public ArrayList<Agencia> obterTodasAgencias() throws Exception{
			UCAgenciaServicos uc = new UCAgenciaServicos();
			return uc.obterTodasAgencias();
		}

		@Override
		public ArrayList<Banco> obterTodosBancos() throws Exception{
			UCBancoServicos uc = new UCBancoServicos();
			return uc.obterTodosBancos();
		}

		@Override
		public Cliente obterClienteEmpresaPorCnpj(Cliente c) throws Exception{
			UCClienteServicos uc = new UCClienteServicos();
			return uc.obterClienteEmpresaPorCnpj(c);
		}

		@Override
		public Cliente obterClientePessoaPorCpf(Cliente c) throws Exception{
			UCClienteServicos uc = new UCClienteServicos();
			return uc.obterClientePessoaPorCpf(c);
		}

		@Override
		public ArrayList<Investimento> obterInvestimentoPorContaBancaria(ContaBancaria cb) throws Exception{
			UCInvestimentoServicos uc = new UCInvestimentoServicos();
			return uc.obterInvestimentoPorContaBancaria(cb);
		}

		@Override
		public Transacao inserirTransacao(Cliente c, ContaBancaria cb, Transacao t) throws Exception{
			UCTransacaoServicos uc = new UCTransacaoServicos();
			return uc.inserirTransacao(c, cb, t);
		}

		@Override
		public ArrayList<Transacao> obterTransacaoPorContaBancaria(ContaBancaria cb) throws Exception{
			UCTransacaoServicos uc = new UCTransacaoServicos();
			return uc.obterTransacaoPorContaBancaria(cb);
		}
		
		

}
