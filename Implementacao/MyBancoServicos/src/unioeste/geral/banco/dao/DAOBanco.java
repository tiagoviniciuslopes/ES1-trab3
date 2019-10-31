package unioeste.geral.banco.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.Banco;

public class DAOBanco {

	public Banco obterBancoPorId(Banco banco, SQLConnector connector) throws Exception{
		String query = "SELECT * FROM Banco WHERE idBanco = "+banco.getIdBanco()+";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		banco.setIdBanco(result.getInt("idBanco"));
		banco.setNomeBanco(result.getString("nomeBanco"));
	
		return banco;
	}
	
	public ArrayList<Banco> obterTodasBancos(SQLConnector connector) throws Exception{
		String query = "SELECT * FROM Banco;";
		ResultSet result = connector.executeQuery(query);
		
		ArrayList<Banco> b = new ArrayList<Banco>();
		
		while(result.next()) {
			Banco banco = new Banco();
			banco.setIdBanco(result.getInt("idBanco"));
			banco.setNomeBanco(result.getString("nomeBanco"));
			
			b.add(banco);
			
		}

		return b;
	}
	
}
