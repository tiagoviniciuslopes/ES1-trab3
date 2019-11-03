package unioeste.geral.banco.testes;

import java.util.ArrayList;

import unioeste.geral.banco.bo.Agencia;
import unioeste.geral.banco.manager.UCAgenciaServicos;

public class AgenciaServicosIntegrationTests {
	
	public static void main(String[] args) throws Exception{
		AgenciaServicosIntegrationTests a = new AgenciaServicosIntegrationTests();
		
		a.obterTodasAgenciasMustPass();
	}
	
	public void obterTodasAgenciasMustPass() throws Exception{
		UCAgenciaServicos uc = new UCAgenciaServicos();
		ArrayList<Agencia> agencias = uc.obterTodasAgencias();
		
		if(agencias.size() <= 0) {
			throw new Exception("Agencias não encontradas");
		}else {
			System.out.println("Sucesso");
		}
	}
	
}
