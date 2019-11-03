package unioeste.gera.server.main;

import javax.xml.ws.Endpoint;

import unioeste.geral.server.servicos.ServicosWeb;

public class WebServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Endpoint.publish("http://localhost:9876/WebServer",new ServicosWeb());

	}

}
