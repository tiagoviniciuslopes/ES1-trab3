package unioeste.geral.banco.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.Agencia;
import unioeste.geral.banco.bo.Banco;
import unioeste.geral.banco.bo.ContaBancaria;
import unioeste.geral.banco.bo.TipoModalidadeContaBancaria;
import unioeste.geral.common.bo.Pessoa;

public class DAOContaBancaria {

	public  ArrayList<ContaBancaria> obterContaBancariaPorCliente(Pessoa pessoa, SQLConnector connector) throws Exception{
		ArrayList<ContaBancaria> contaBancaria = new ArrayList<ContaBancaria>();
		
		String query="SELECT * FROM ContaBancaria WHERE idCliente = " + pessoa.getIdPessoa()+ ";" ;
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
