package unioeste.geral.banco.dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.ContaBancaria;
import unioeste.geral.banco.bo.TipoTransacao;
import unioeste.geral.banco.bo.Transacao;

public class DAOTransacao {

	public  ArrayList<Transacao> obterTransacaoPorContaBancaria(ContaBancaria cb, SQLConnector connector) throws Exception{
		ArrayList<Transacao> transacao = new ArrayList<Transacao>();
		
		String query="SELECT * FROM Transacao WHERE idContaBancaria = " + cb.getIdContaBancaria()+ " OR IdContaBancaria_Favorecido = " + cb.getIdContaBancaria() + " ORDER BY idTransacao;" ;
		ResultSet result = connector.executeQuery(query);

		while(result.next()) {
			Transacao t = new Transacao();
			t.setDataTransferencia(result.getString("dataTransacao"));
			t.setIdTransferencia(result.getInt("idTransacao"));
			t.setMotivoTransferencia(result.getString("motivoTransacao"));
			t.setValorTransferencia(result.getFloat("valorTransacao"));
			
			ContaBancaria contaBancaria = new ContaBancaria();
			contaBancaria.setIdContaBancaria(result.getInt("idContaBancaria_Favorecido"));
			t.setContaBancaria(contaBancaria);
			
			TipoTransacao tipoTransacao = new TipoTransacao();
			tipoTransacao.setIdTipoTransacao(result.getInt("idTipoTransacao"));
			t.setTipoTransacao(tipoTransacao);
			
			transacao.add(t);	
		}
		
		return transacao;
	}
	
	public Transacao inserirTransacao(ContaBancaria cb, Transacao t, SQLConnector connector) throws Exception{
		
		String query="INSERT INTO Transacao (dataTransacao, valorTransacao, motivoTransacao, idTipoTransacao, idContaBancaria_Favorecido, idContaBancaria)"
				+ " VALUES ("+t.getSQLData()+", "+ t.getValorTransferencia()+"," + t.getMotivoTransferencia() + ", "+ t.getTipoTransacao().getIdTipoTransacao()+", "+t.getContaBancaria().getIdContaBancaria()+", " +cb.getIdContaBancaria()+ ") ;";
		
		connector.executeUpdate(query);
		
		return t;
	}
	
}
