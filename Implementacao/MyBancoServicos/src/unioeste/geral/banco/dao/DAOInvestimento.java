package unioeste.geral.banco.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.ContaBancaria;
import unioeste.geral.banco.bo.Investimento;
import unioeste.geral.banco.bo.TipoInvestimento;
import unioeste.geral.banco.bo.TipoTransacao;

public class DAOInvestimento {

	public  ArrayList<Investimento> obterInvestimentoPorContaBancaria(ContaBancaria cb, SQLConnector connector) throws Exception{
		ArrayList<Investimento> investimento = new ArrayList<Investimento>();
		
		String query="SELECT * FROM Investimento WHERE idContaBancaria = " + cb.getIdContaBancaria()+ ";" ;
		ResultSet result = connector.executeQuery(query);

		while(result.next()) {
			Investimento i = new Investimento();
			i.setDataInvestimento(result.getString("dataInvestimento"));
			i.setIdInvestimento(result.getInt("idInvestimento"));
			i.setValorInvestimento(result.getFloat("valorInvestimento"));
			
			TipoInvestimento tipoInvestimento = new TipoInvestimento();
			TipoTransacao tipoTransacao = new TipoTransacao();
			
			tipoInvestimento.setIdTipoInvestimento(result.getInt("idTipoInvestimento"));
			tipoTransacao.setIdTipoTransacao(result.getInt("idTipoTransacao"));
			
			i.setTipoInvestimento(tipoInvestimento);
			i.setTipoTransacao(tipoTransacao);
			
			investimento.add(i);	
		}
		
		return investimento;
	}
	
	public Investimento inserirInvestimento(Investimento i, SQLConnector connector) throws Exception{
		
		String query="INSERT INTO Investimento (dataInvestimento, valorInvestimento, idTipoInvestimento, idTipoTransacao)"
				+ " VALUES ("+ i.getSQLData() +", "+i.getValorInvestimento()+", " + i.getTipoInvestimento().getIdTipoInvestimento() +","
				+ i.getTipoTransacao().getIdTipoTransacao() + ") ;";
		
		connector.executeUpdate(query);
		
		return i;
	}
	
}
