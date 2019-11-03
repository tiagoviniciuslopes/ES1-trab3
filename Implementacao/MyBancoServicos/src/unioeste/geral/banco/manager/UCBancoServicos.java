package unioeste.geral.banco.manager;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.Banco;
import unioeste.geral.banco.col.ColBanco;

public class UCBancoServicos {
	public ArrayList<Banco> obterTodosBancos() throws Exception{
		SQLConnector connector = new SQLConnector();
		ColBanco colBanco = new ColBanco();
		ArrayList<Banco> banco = new ArrayList<Banco>();
		
		banco = colBanco.obterTodosBancos(connector);
		connector.close();
		
		return banco;
	}
}
