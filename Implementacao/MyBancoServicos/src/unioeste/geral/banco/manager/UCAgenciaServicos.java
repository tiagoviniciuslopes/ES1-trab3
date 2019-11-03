package unioeste.geral.banco.manager;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.Agencia;
import unioeste.geral.banco.col.ColAgencia;

public class UCAgenciaServicos {

	public ArrayList<Agencia> obterTodasAgencias() throws Exception{
		ColAgencia colAgencia = new ColAgencia();
		SQLConnector connector = new SQLConnector();
		ArrayList<Agencia> agencia = new ArrayList<Agencia>();
		
		agencia = colAgencia.obterTodasAgencias(connector);
		
		connector.close();
		
		return agencia;
	}
	
}
