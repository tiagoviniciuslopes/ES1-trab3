package unioeste.geral.banco.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.TipoTransacao;

public class DAOTipoTransacao {

	public TipoTransacao obterTipoTransacaoPorId(TipoTransacao tipoTransacao, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM TipoTransacao WHERE idTipoTransacao = "+tipoTransacao.getIdTipoTransacao()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		tipoTransacao.setIdTipoTransacao(result.getInt("idTipoTransacao"));
		tipoTransacao.setDescricaoTransacao(result.getString("descricaoTipoTransacao"));
	
		return tipoTransacao;
	}
	
	public ArrayList<TipoTransacao> obterTodosTipoTransacoes(SQLConnector connector) throws Exception{
		String query = "SELECT * FROM TipoTransacao;";
		ResultSet result = connector.executeQuery(query);
		
		ArrayList<TipoTransacao> tt = new ArrayList<TipoTransacao>();
		
		while(result.next()) {
			TipoTransacao tipoTransacao = new TipoTransacao();
			tipoTransacao.setIdTipoTransacao(result.getInt("idTipoTransacao"));
			tipoTransacao.setDescricaoTransacao(result.getString("descricaoTipoTransacao"));
			
			tt.add(tipoTransacao);
			
		}

		return tt;
	}
	
}
