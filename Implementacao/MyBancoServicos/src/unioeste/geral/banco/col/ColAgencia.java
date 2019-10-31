package unioeste.geral.banco.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.Agencia;
import unioeste.geral.banco.dao.DAOAgencia;

public class ColAgencia {
	public Agencia obterAgenciaPorId(Agencia agencia, SQLConnector connector) throws Exception{
		DAOAgencia dao = new DAOAgencia();
		
		return dao.obterAgenciaPorId(agencia, connector);
	}
	
	public ArrayList<Agencia> obterTodasAgencias(SQLConnector connector) throws Exception{
		DAOAgencia dao = new DAOAgencia();
		
		return dao.obterTodasAgencias(connector);
	}
}
