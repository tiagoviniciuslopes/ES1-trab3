package unioeste.geral.banco.manager;

import java.util.ArrayList;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.Agencia;
import unioeste.geral.banco.bo.Banco;
import unioeste.geral.banco.bo.ContaBancaria;
import unioeste.geral.banco.bo.Transacao;
import unioeste.geral.banco.col.ColAgencia;
import unioeste.geral.banco.col.ColBanco;
import unioeste.geral.banco.col.ColContaBancaria;
import unioeste.geral.banco.col.ColTipoTransacao;
import unioeste.geral.banco.col.ColTransacao;

public class UCTransacaoServicos {
	
	public  ArrayList<Transacao> obterTransacaoPorContaBancaria(ContaBancaria cb) throws Exception{
		SQLConnector connector = new SQLConnector();
		ColContaBancaria colContaBancaria = new ColContaBancaria();
		ColTransacao colTransacao = new ColTransacao();
		ColTipoTransacao colTipoTransacao = new ColTipoTransacao();
		ColAgencia colAgencia = new ColAgencia();
		ColBanco colBanco = new ColBanco();
		
		ArrayList<Transacao> transacao = colTransacao.obterTransacaoPorContaBancaria(cb, connector);
		
		for(Transacao t : transacao) {
			t.setTipoTransacao(colTipoTransacao.obterTipoTransacaoPorId(t.getTipoTransacao(), connector));
			t.setContaBancaria(colContaBancaria.obterContaBancariaPorId(t.getContaBancaria(), connector));
			Agencia agencia = colAgencia.obterAgenciaPorId(t.getContaBancaria().getAgencia(), connector);
			Banco banco = colBanco.obterBancoPorId(t.getContaBancaria().getBanco(), connector);
			ContaBancaria contaBancaria = t.getContaBancaria();
			contaBancaria.setAgencia(agencia);
			contaBancaria.setBanco(banco);
			t.setContaBancaria(contaBancaria);
		}
		
		return transacao;
	
	}
	
}
