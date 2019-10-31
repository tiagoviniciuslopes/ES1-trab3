package unioeste.geral.banco.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.Cliente;
import unioeste.geral.banco.bo.ContaBancaria;
import unioeste.geral.banco.dao.DAOContaBancaria;

public class ColContaBancaria {
	public ArrayList<ContaBancaria> obterContaBancariaPorCliente(Cliente c, SQLConnector connector) throws Exception {
		DAOContaBancaria dao = new DAOContaBancaria();
		return dao.obterContaBancariaPorCliente(c, connector);
	}
}
