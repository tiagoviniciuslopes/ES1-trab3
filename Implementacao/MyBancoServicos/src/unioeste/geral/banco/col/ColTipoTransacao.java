package unioeste.geral.banco.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.TipoTransacao;
import unioeste.geral.banco.dao.DAOTipoTransacao;

public class ColTipoTransacao {
	
	public TipoTransacao obterTipoTransacaoPorId(TipoTransacao tipoTransacao, SQLConnector connector) throws Exception{
		DAOTipoTransacao dao = new DAOTipoTransacao();
		return dao.obterTipoTransacaoPorId(tipoTransacao, connector);
	}
	
	public ArrayList<TipoTransacao> obterTodosTipoTransacoes(SQLConnector connector) throws Exception{
		DAOTipoTransacao dao = new DAOTipoTransacao();
		return dao.obterTodosTipoTransacoes(connector);
	}
	
}
