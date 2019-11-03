package unioeste.geral.banco.manager;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.Cliente;
import unioeste.geral.banco.bo.ContaBancaria;
import unioeste.geral.banco.bo.Investimento;
import unioeste.geral.banco.bo.Transacao;
import unioeste.geral.banco.col.ColAgencia;
import unioeste.geral.banco.col.ColBanco;
import unioeste.geral.banco.col.ColContaBancaria;
import unioeste.geral.banco.col.ColTipoModalidadeContaBancaria;

public class UCContaBancariaServicos {
	public ArrayList<ContaBancaria> obterContaBancariaPorCliente(Cliente c) throws Exception {
		SQLConnector connector = new SQLConnector();
		ColContaBancaria colContaBancaria = new ColContaBancaria();
		ColAgencia colAgencia = new ColAgencia();
		ColBanco colBanco = new ColBanco();
		ColTipoModalidadeContaBancaria colTipoModalidadeContaBancaria = new ColTipoModalidadeContaBancaria();
		UCInvestimentoServicos ucInvestimento = new UCInvestimentoServicos();
		UCTransacaoServicos ucTransacao = new UCTransacaoServicos();
		
		
		ArrayList<ContaBancaria> contaBancaria = new ArrayList<ContaBancaria>();
		contaBancaria = colContaBancaria.obterContaBancariaPorCliente(c, connector);
		
		for(ContaBancaria cb : contaBancaria) {
			cb.setAgencia(colAgencia.obterAgenciaPorId(cb.getAgencia(), connector));
			cb.setBanco(colBanco.obterBancoPorId(cb.getBanco(), connector));
			cb.setTipoModalidadeContaBancaria(colTipoModalidadeContaBancaria.obterTipoModalidadeContaBancariaPorId(cb.getTipoModalidadeContaBancaria(), connector));
			ArrayList<Investimento> i = ucInvestimento.obterInvestimentoPorContaBancaria(cb);
			cb.setInvestimento(i.toArray(new Investimento[i.size()]));
			ArrayList<Transacao> t = ucTransacao.obterTransacaoPorContaBancaria(cb);
			cb.setTransacao(t.toArray(new Transacao[t.size()]));
			
		}
		
		return contaBancaria;
	}
}
