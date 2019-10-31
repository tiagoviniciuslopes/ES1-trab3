package unioeste.geral.banco.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.ContaBancaria;
import unioeste.geral.banco.bo.Investimento;
import unioeste.geral.banco.dao.DAOInvestimento;

public class ColInvestimento {

	public  ArrayList<Investimento> obterInvestimentoPorContaBancaria(ContaBancaria cb, SQLConnector connector) throws Exception{
		DAOInvestimento dao = new DAOInvestimento();
		return dao.obterInvestimentoPorContaBancaria(cb, connector);
	}
	
	public Investimento inserirInvestimento(Investimento i, SQLConnector connector) throws Exception{
		DAOInvestimento dao = new DAOInvestimento();
		return dao.inserirInvestimento(i, connector);
		
	}
	
}
