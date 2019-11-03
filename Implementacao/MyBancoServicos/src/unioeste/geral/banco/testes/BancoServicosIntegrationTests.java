package unioeste.geral.banco.testes;

import java.util.ArrayList;

import unioeste.geral.banco.bo.Banco;
import unioeste.geral.banco.manager.UCBancoServicos;

public class BancoServicosIntegrationTests {

	public static void main(String[] args) throws Exception{
		BancoServicosIntegrationTests b = new BancoServicosIntegrationTests();
		
		b.obterTodosBancosMustPass();
	}
	
	public void obterTodosBancosMustPass() throws Exception{
		UCBancoServicos uc = new UCBancoServicos();
		ArrayList<Banco> bancos = uc.obterTodosBancos();
		
		if(bancos.size() <= 0) {
			throw new Exception("Bancos não encontrados");
		}else {
			System.out.println("Sucesso");
		}
	}
	
}
