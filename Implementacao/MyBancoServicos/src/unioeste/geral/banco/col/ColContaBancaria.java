package unioeste.geral.banco.col;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.Cliente;
import unioeste.geral.banco.bo.ClienteEmpresa;
import unioeste.geral.banco.bo.ClientePessoa;
import unioeste.geral.banco.bo.ContaBancaria;
import unioeste.geral.banco.dao.DAOContaBancaria;

public class ColContaBancaria {
	public ArrayList<ContaBancaria> obterContaBancariaPorCliente(Cliente c, SQLConnector connector) throws Exception {
		DAOContaBancaria dao = new DAOContaBancaria();
		return dao.obterContaBancariaPorCliente(c, connector);
	}
	
	public ContaBancaria obterContaBancariaPorId(ContaBancaria cb, SQLConnector connector) throws Exception {
		DAOContaBancaria dao = new DAOContaBancaria();
		return dao.obterContaBancariaPorId(cb, connector);
	}
	
	public boolean validarContaBancaria_Favorecido(Cliente c, ContaBancaria cb, SQLConnector connector) throws Exception{
		boolean retorno = false;
		DAOContaBancaria dao = new DAOContaBancaria();
		
		if(c.getClienteEmpresa() != null) {
			Cliente c_aux = new Cliente();
			ClienteEmpresa ce = new ClienteEmpresa();
			ce.setIdPessoa(c.getClienteEmpresa().getIdPessoa());
			c_aux.setClienteEmpresa(ce);
	
			retorno = dao.validarContaBancaria_Favorecido(c_aux, cb, connector);
			
		}else {
			Cliente c_aux = new Cliente();
			ClientePessoa cp = new ClientePessoa();
			cp.setIdPessoa(c.getClientePessoa().getIdPessoa());
			c_aux.setClientePessoa(cp);
	
			retorno = dao.validarContaBancaria_Favorecido(c_aux, cb, connector);
		}
		
		return retorno;
	}
	
	public ContaBancaria atualizarContaBancaria(ContaBancaria cb, SQLConnector connector) throws Exception {
		DAOContaBancaria dao = new DAOContaBancaria();
		
		cb = dao.atualizarContaBancaria(cb, connector);
		
		return cb;
	}
}
