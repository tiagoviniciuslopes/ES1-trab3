package unioeste.geral.banco.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.TipoModalidadeContaBancaria;

public class DAOTipoModalidadeContaBancaria {

	public TipoModalidadeContaBancaria obterTipoModalidadeContaBancariaPorId(TipoModalidadeContaBancaria tipoModalidadeContaBancaria, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM TipoModalidadeContaBancaria WHERE idTipoModalidadeContaBancaria = "+tipoModalidadeContaBancaria.getIdModalidadeContaBancaria()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		tipoModalidadeContaBancaria.setIdModalidadeContaBancaria(result.getInt("idTipoModalidadeContaBancaria"));
		tipoModalidadeContaBancaria.setDescricaoTipoModalidadeContaBancaria(result.getString("descricaoTipoModalidadeContaBancaria"));
	
		return tipoModalidadeContaBancaria;
	}
	
	public ArrayList<TipoModalidadeContaBancaria> obterTodosTipoModalidadeContaBancariaa(SQLConnector connector) throws Exception{
		String query = "SELECT * FROM TipoModalidadeContaBancaria;";
		ResultSet result = connector.executeQuery(query);
		
		ArrayList<TipoModalidadeContaBancaria> tmcb = new ArrayList<TipoModalidadeContaBancaria>();
		
		while(result.next()) {
			TipoModalidadeContaBancaria tipoModalidadeContaBancaria = new TipoModalidadeContaBancaria();
			tipoModalidadeContaBancaria.setIdModalidadeContaBancaria(result.getInt("idTipoModalidadeContaBancaria"));
			tipoModalidadeContaBancaria.setDescricaoTipoModalidadeContaBancaria(result.getString("descricaoTipoModalidadeContaBancaria"));
			
			tmcb.add(tipoModalidadeContaBancaria);
			
		}

		return tmcb;
	}
	
}
