package unioeste.geral.banco.col;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.Cliente;
import unioeste.geral.banco.dao.DAOCliente;

public class ColCliente {

	public Cliente obterClientePorCpf(Cliente c, SQLConnector connector) throws Exception{
		DAOCliente dao = new DAOCliente();
		
		c = dao.obterClientePorCpf(c,connector);	
		c.setClienteEmpresa(null);
		return c;
	}
	
	public Cliente obterClientePorCnpj(Cliente c, SQLConnector connector) throws Exception{
		DAOCliente dao = new DAOCliente();
		
		c =  dao.obterClientePorCnpj(c,connector);
		c.setClientePessoa(null);
		return c;		
	}
	
	public Cliente obterClientePorId(Cliente c, SQLConnector connector) throws Exception{
		DAOCliente dao = new DAOCliente();
		
		c = dao.obterClientePorId(c,connector);	
		return c;
	}
	
	public void inserirCliente(Cliente c, SQLConnector connector) throws Exception{
		DAOCliente dao = new DAOCliente();
		
		dao.inserirCliente(c, connector);
	}
	

	
}
