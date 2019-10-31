package unioeste.geral.banco.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.Banco;
import unioeste.geral.banco.dao.DAOBanco;

public class ColBanco {
		
	public Banco obterBancoPorId(Banco banco, SQLConnector connector) throws Exception{
		DAOBanco dao = new DAOBanco();
		
		return dao.obterBancoPorId(banco, connector);
	}
	
	public ArrayList<Banco> obterTodosBancos(SQLConnector connector) throws Exception{
		DAOBanco dao = new DAOBanco();
		
		return dao.obterTodosBancos(connector);
	}
	
}
