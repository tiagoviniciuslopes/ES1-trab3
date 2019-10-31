package unioeste.geral.banco.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.ContaBancaria;
import unioeste.geral.banco.bo.Transacao;
import unioeste.geral.banco.dao.DAOTransacao;

public class ColTransacao {

	public  ArrayList<Transacao> obterTransacaoPorContaBancaria(ContaBancaria cb, SQLConnector connector) throws Exception{
		DAOTransacao dao = new DAOTransacao();
		return dao.obterTransacaoPorContaBancaria(cb, connector);
	}
	
	public Transacao inserirTransacao(ContaBancaria cb, Transacao t, SQLConnector connector) throws Exception{
		DAOTransacao dao = new DAOTransacao();
		return dao.inserirTransacao(cb, t, connector);
	}
	
}
