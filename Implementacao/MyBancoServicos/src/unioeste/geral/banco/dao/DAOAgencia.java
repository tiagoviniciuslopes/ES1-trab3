package unioeste.geral.banco.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.Agencia;

public class DAOAgencia {

	public Agencia obterAgenciaPorId(Agencia agencia, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM Agencia WHERE idAgencia = "+agencia.getIdAgencia()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		agencia.setIdAgencia(result.getInt("idAgencia"));
		agencia.setNomeAgencia(result.getString("nomeAgencia"));
	
		return agencia;
	}
	
	public ArrayList<Agencia> obterTodasAgencias(SQLConnector connector) throws Exception{
		String query = "SELECT * FROM Agencia ;";
		ResultSet result = connector.executeQuery(query);
		
		ArrayList<Agencia> a = new ArrayList<Agencia>();
		
		while(result.next()) {
			Agencia agencia = new Agencia();
			agencia.setIdAgencia(result.getInt("idAgencia"));
			agencia.setNomeAgencia(result.getString("nomeAgencia"));
			
			a.add(agencia);
			
		}

		return a;
	}
	
}
