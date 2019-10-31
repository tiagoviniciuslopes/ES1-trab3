package unioeste.geral.banco.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.TipoInvestimento;

public class DAOTipoInvestimento {

	public TipoInvestimento obterTipoInvestimentoPorId(TipoInvestimento tipoInvestimento, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM TipoInvestimento WHERE idTipoInvestimento = "+tipoInvestimento.getIdTipoInvestimento()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		tipoInvestimento.setIdTipoInvestimento(result.getInt("idTipoInvestimento"));
		tipoInvestimento.setDescricaoTipoInvestimento(result.getString("descricaoTipoInvestimento"));
	
		return tipoInvestimento;
	}
	
	public ArrayList<TipoInvestimento> obterTodosTipoInvestimentos(SQLConnector connector) throws Exception{
		String query = "SELECT * FROM TipoInvestimento;";
		ResultSet result = connector.executeQuery(query);
		
		ArrayList<TipoInvestimento> ti = new ArrayList<TipoInvestimento>();
		
		while(result.next()) {
			TipoInvestimento tipoInvestimento = new TipoInvestimento();
			tipoInvestimento.setIdTipoInvestimento(result.getInt("idTipoInvestimento"));
			tipoInvestimento.setDescricaoTipoInvestimento(result.getString("descricaoTipoInvestimento"));
			
			ti.add(tipoInvestimento);
			
		}

		return ti;
	}
	
}
