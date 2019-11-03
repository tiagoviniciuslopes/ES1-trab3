package unioeste.geral.banco.manager;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.ContaBancaria;
import unioeste.geral.banco.bo.Investimento;
import unioeste.geral.banco.col.ColInvestimento;
import unioeste.geral.banco.col.ColTipoInvestimento;
import unioeste.geral.banco.col.ColTipoTransacao;

public class UCInvestimentoServicos {
	public  ArrayList<Investimento> obterInvestimentoPorContaBancaria(ContaBancaria cb) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColTipoInvestimento colTipoInvestimento = new ColTipoInvestimento();
		ColInvestimento colInvestimento = new ColInvestimento();
		ColTipoTransacao colTipoTransacao = new ColTipoTransacao();
		
		ArrayList<Investimento> investimento = colInvestimento.obterInvestimentoPorContaBancaria(cb, connector);
		
		for(Investimento i : investimento) {
			i.setTipoInvestimento(colTipoInvestimento.obterTipoInvestimentoPorId(i.getTipoInvestimento(), connector));
			i.setTipoTransacao(colTipoTransacao.obterTipoTransacaoPorId(i.getTipoTransacao(), connector));
		}
		
		return investimento;
	
	}
}
