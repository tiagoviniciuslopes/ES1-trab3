package unioeste.geral.banco.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.TipoModalidadeContaBancaria;
import unioeste.geral.banco.dao.DAOTipoModalidadeContaBancaria;

public class ColTipoModalidadeContaBancaria {

	public TipoModalidadeContaBancaria obterTipoModalidadeContaBancariaPorId(TipoModalidadeContaBancaria tipoModalidadeContaBancaria, SQLConnector connector) throws Exception{
		DAOTipoModalidadeContaBancaria dao = new DAOTipoModalidadeContaBancaria();
		return dao.obterTipoModalidadeContaBancariaPorId(tipoModalidadeContaBancaria, connector);
	}
	
	public ArrayList<TipoModalidadeContaBancaria> obterTodosTipoModalidadeContaBancariaa(SQLConnector connector) throws Exception{
		DAOTipoModalidadeContaBancaria dao = new DAOTipoModalidadeContaBancaria();
		return dao.obterTodosTipoModalidadeContaBancariaa(connector);
	}
	
}
