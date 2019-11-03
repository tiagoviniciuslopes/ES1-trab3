package unioeste.geral.banco.dao;

import java.sql.ResultSet;

import unioeste.apoio.BD.SQLConnector;
import unioeste.geral.banco.bo.Cliente;
import unioeste.geral.banco.bo.ClienteEmpresa;
import unioeste.geral.banco.bo.ClientePessoa;
import unioeste.geral.common.bo.CNPJ;
import unioeste.geral.common.bo.CPF;
import unioeste.geral.common.bo.DocIdentidade;
import unioeste.geral.common.bo.EnderecoEspecifico;
import unioeste.geral.common.bo.OrgaoExpeditor;
import unioeste.geral.common.bo.Sexo;
import unioeste.geral.endereco.bo.Endereco;

public class DAOCliente {

	public Cliente obterClientePorCpf(Cliente cliente, SQLConnector connector) throws Exception{
		
		ClientePessoa cp = cliente.getClientePessoa();
		
		String query = "SELECT * FROM Cliente WHERE cpf = '" + cp.getCpf().getNumeroDoc() + "';";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		CPF cpf = new CPF();
		cpf.setNumeroDoc(result.getString("cpf"));
		cp.setCpf(cpf);
		DocIdentidade docIdentidade = new DocIdentidade();
		docIdentidade.setNumeroDoc(result.getString("numeroDoc"));
		docIdentidade.setDataExpedicao(result.getString("dataExpedicao"));
		OrgaoExpeditor orgaoExpeditor = new OrgaoExpeditor();
		orgaoExpeditor.setIdOrgaoExpeditor(result.getInt("idOrgaoExpeditor"));
		docIdentidade.setOrgaoExpeditor(orgaoExpeditor);
		cp.setDocIdentidade(docIdentidade);
		EnderecoEspecifico enderecoEspecifico = new EnderecoEspecifico();
		enderecoEspecifico.setNumero(result.getInt("numero"));
		enderecoEspecifico.setComplemento(result.getString("complemento"));
		Endereco endereco = new Endereco();
		endereco.setIdEndereco(result.getInt("idEndereco"));
		enderecoEspecifico.setEndereco(endereco);
		cp.setEnderecoEspecifico(enderecoEspecifico);
		cp.setIdPessoa(result.getInt("idCliente"));
		cp.setNomeAbreviado(result.getString("nomeAbreviadoCliente"));
		cp.setNomeCompleto(result.getString("nomeCompletoCliente"));
		cp.setNomeMeio(result.getString("nomeMeioCliente"));
		cp.setPrimeiroNome(result.getString("primeiroNomeCliente"));
		cp.setUltimoNome(result.getString("ultimoNomeCliente"));
		Sexo sexo = new Sexo();
		sexo.setIdSexo(result.getInt("idSexo"));
		cp.setSexo(sexo);
		
		cliente.setClientePessoa(cp);
		
		return cliente;
		
	}
	
	public Cliente obterClientePorCnpj(Cliente cliente, SQLConnector connector) throws Exception{

		ClienteEmpresa ce = cliente.getClienteEmpresa();
		
		String query = "SELECT * FROM Cliente WHERE cnpj= '" + ce.getCnpj().getNumeroDoc() + "';";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		CNPJ cnpj = new CNPJ();
		cnpj.setNumeroDoc(result.getString("cnpj"));
		ce.setCnpj(cnpj);
		EnderecoEspecifico enderecoEspecifico = new EnderecoEspecifico();
		enderecoEspecifico.setNumero(result.getInt("numero"));
		enderecoEspecifico.setComplemento(result.getString("complemento"));
		Endereco endereco = new Endereco();
		endereco.setIdEndereco(result.getInt("idEndereco"));
		enderecoEspecifico.setEndereco(endereco);
		ce.setEnderecoEspecifico(enderecoEspecifico);
		ce.setIdPessoa(result.getInt("idCliente"));
		ce.setNomeAbreviado(result.getString("nomeAbreviadoCliente"));
		ce.setNomeCompleto(result.getString("primeiroNomeCliente"));
		
		cliente.setClienteEmpresa(ce);
		
		return cliente;
	}
	
	public Cliente obterClientePorId(Cliente cliente, SQLConnector connector) throws Exception{
		int id;
		
		if(cliente.getClienteEmpresa() != null) {
			id = cliente.getClienteEmpresa().getIdPessoa();
		}else {
			id = cliente.getClientePessoa().getIdPessoa();
		}
		
		String query = "SELECT * FROM Cliente WHERE idCliente = " + id + ";";
		ResultSet result = connector.executeQuery(query);
		result.next();
		
		CPF cpf = new CPF();
		CNPJ cnpj = new CNPJ();
		cnpj.setNumeroDoc(result.getString("cnpj"));
		cpf.setNumeroDoc(result.getString("cpf"));
		
		if(cnpj.getNumeroDoc() == null) {
			ClientePessoa p = new ClientePessoa();
			p = setClientePessoa(p, result);
			cliente.setClientePessoa(p);
		}else {
			ClienteEmpresa p = new ClienteEmpresa();
			p = setClienteEmpresa(p, result);
			cliente.setClienteEmpresa(p);
		}	
				
		return cliente;
	}
	
	
	public Cliente inserirCliente(Cliente c, SQLConnector connector) throws Exception{
		
		if(c.getClienteEmpresa() != null) {
			inserirClienteEmpresa(c, connector);
		}else {
			inserirClientePessoa(c, connector);
		}
		
		return c;
		
	}
	
	public Cliente inserirClientePessoa(Cliente c, SQLConnector connector) throws Exception{
		
		ClientePessoa cp = c.getClientePessoa();
		
		String query = "INSERT INTO Cliente (nomeCompletoCliente,cpf,numeroDoc,dataExpedicao,idOrgaoExpeditor,"
				+ "numero,complemento,idEndereco,nomeAbreviadoCliente,nomeMeioCliente,"
				+ "primeiroNomeCliente,ultimoNomeCliente,idSexo) VALUES ('"+cp.getNomeCompleto()+"',"
				+ "'"+cp.getCpf().getNumeroDoc()+"','"+cp.getDocIdentidade().getNumeroDoc()+"',"
				+ cp.getDocIdentidade().getSQLData() + ","+ cp.getDocIdentidade().getOrgaoExpeditor().getIdOrgaoExpeditor() + "," + cp.getEnderecoEspecifico().getNumero() + ",'"+ cp.getEnderecoEspecifico().getComplemento() +"',"
				+ cp.getEnderecoEspecifico().getEndereco().getIdEndereco() +",'"+ cp.getNomeAbreviado() +"',"
				+ "'"+ cp.getNomeMeio() +"', '"+cp.getPrimeiroNome()+"','"+cp.getUltimoNome()+"',"+cp.getSexo().getIdSexo()+");";
		
		connector.executeUpdate(query);
		
		c = obterClientePorCpf(c,connector);
		
		return c;
		
	}
	
	public Cliente inserirClienteEmpresa(Cliente c, SQLConnector connector) throws Exception{
		
		ClienteEmpresa ce = c.getClienteEmpresa();
		
		String query = "INSERT INTO Cliente (cnpj,"
				+ "numero,complemento,idEndereco,"
				+ "primeiroNomeCliente) VALUES (,"
				+ "'"+ce.getCnpj().getNumeroDoc()+"',"
				+ ce.getEnderecoEspecifico().getNumero() + ",'"+ ce.getEnderecoEspecifico().getComplemento() +"',"
				+ ce.getEnderecoEspecifico().getEndereco().getIdEndereco() +", '"+ce.getNomeCompleto()+"');";
		
		connector.executeUpdate(query);
		
		c = obterClientePorCnpj(c,connector);
		
		return c;
		
	}
	
	public ClientePessoa setClientePessoa(ClientePessoa cp, ResultSet result) throws Exception{	
		
		DocIdentidade docIdentidade = new DocIdentidade();
		docIdentidade.setNumeroDoc(result.getString("numeroDoc"));
		docIdentidade.setDataExpedicao(result.getString("dataExpedicao"));
		OrgaoExpeditor orgaoExpeditor = new OrgaoExpeditor();
		orgaoExpeditor.setIdOrgaoExpeditor(result.getInt("idOrgaoExpeditor"));
		docIdentidade.setOrgaoExpeditor(orgaoExpeditor);
		cp.setDocIdentidade(docIdentidade);
		EnderecoEspecifico enderecoEspecifico = new EnderecoEspecifico();
		enderecoEspecifico.setNumero(result.getInt("numero"));
		enderecoEspecifico.setComplemento(result.getString("complemento"));
		Endereco endereco = new Endereco();
		endereco.setIdEndereco(result.getInt("idEndereco"));
		enderecoEspecifico.setEndereco(endereco);
		cp.setEnderecoEspecifico(enderecoEspecifico);
		cp.setIdPessoa(result.getInt("idCliente"));
		cp.setNomeAbreviado(result.getString("nomeAbreviadoCliente"));
		cp.setNomeCompleto(result.getString("nomeCompletoCliente"));
		cp.setNomeMeio(result.getString("nomeMeioCliente"));
		cp.setPrimeiroNome(result.getString("primeiroNomeCliente"));
		cp.setUltimoNome(result.getString("ultimoNomeCliente"));
		Sexo sexo = new Sexo();
		sexo.setIdSexo(result.getInt("idSexo"));
		cp.setSexo(sexo);
		
		return cp;
		
	}
	
	public ClienteEmpresa setClienteEmpresa(ClienteEmpresa ce, ResultSet result) throws Exception{
		EnderecoEspecifico enderecoEspecifico = new EnderecoEspecifico();
		enderecoEspecifico.setNumero(result.getInt("numero"));
		enderecoEspecifico.setComplemento(result.getString("complemento"));
		Endereco endereco = new Endereco();
		endereco.setIdEndereco(result.getInt("idEndereco"));
		enderecoEspecifico.setEndereco(endereco);
		ce.setEnderecoEspecifico(enderecoEspecifico);
		ce.setIdPessoa(result.getInt("idCliente"));
		ce.setNomeAbreviado(result.getString("nomeAbreviadoCliente"));
		ce.setNomeCompleto(result.getString("primeiroNomeCliente"));
		
		return ce;
		
	}
	
}
