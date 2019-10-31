package unioeste.geral.banco.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.TipoInvestimento;
import unioeste.geral.banco.dao.DAOTipoInvestimento;

public class ColTipoInvestimento {
	
	public TipoInvestimento obterTipoInvestimentoPorId(TipoInvestimento tipoInvestimento, SQLConnector connector) throws Exception{
		DAOTipoInvestimento dao = new DAOTipoInvestimento();
		return dao.obterTipoInvestimentoPorId(tipoInvestimento, connector);
	}
	
	public ArrayList<TipoInvestimento> obterTodosTipoInvestimentos(SQLConnector connector) throws Exception{
		DAOTipoInvestimento dao = new DAOTipoInvestimento();
		return dao.obterTodosTipoInvestimentos(connector);
	}
	
}
