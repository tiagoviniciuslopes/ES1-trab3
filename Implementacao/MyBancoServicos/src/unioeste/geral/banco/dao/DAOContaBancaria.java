package unioeste.geral.banco.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.Agencia;
import unioeste.geral.banco.bo.Banco;
import unioeste.geral.banco.bo.Cliente;
import unioeste.geral.banco.bo.ContaBancaria;
import unioeste.geral.banco.bo.TipoModalidadeContaBancaria;

public class DAOContaBancaria {

	public  ArrayList<ContaBancaria> obterContaBancariaPorCliente(Cliente c, SQLConnector connector) throws Exception{
		ArrayList<ContaBancaria> contaBancaria = new ArrayList<ContaBancaria>();
		
		int id;
		
		if(c.getClienteEmpresa() != null) {
			id = c.getClienteEmpresa().getIdPessoa();
		}else {
			id = c.getClientePessoa().getIdPessoa();
		}
		
		String query="SELECT * FROM ContaBancaria WHERE idCliente = " + id + ";" ;
		ResultSet result = connector.executeQuery(query);

		while(result.next()) {
			ContaBancaria cb = new ContaBancaria();
			cb.setIdContaBancaria(result.getInt("idContaBancaria"));
			Agencia a = new Agencia();
			a.setIdAgencia(result.getInt("idAgencia"));
			cb.setAgencia(a);
			Banco b = new Banco();
			b.setIdBanco(result.getInt("idBanco"));
			cb.setBanco(b);
			TipoModalidadeContaBancaria tmcb = new TipoModalidadeContaBancaria();
			tmcb.setIdModalidadeContaBancaria(result.getInt("idTipoModalidadeContaBancaria"));
			cb.setTipoModalidadeContaBancaria(tmcb);
			cb.setSaldoAtual(result.getFloat("saldoAtual"));
			
			contaBancaria.add(cb);	
		}
		
		return contaBancaria;
	}
	
}
