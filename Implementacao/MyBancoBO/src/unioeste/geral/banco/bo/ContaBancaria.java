package unioeste.geral.banco.bo;
public class ContaBancaria {

	private int idContaBancaria;

	private float saldoAtual;

	private Banco banco;

	private Agencia agencia;

	private Transacao[] transacao;

	private TipoModalidadeContaBancaria tipoModalidadeContaBancaria;

	private Investimento[] investimento;

	public int getIdContaBancaria() {
		return idContaBancaria;
	}

	public void setIdContaBancaria(int idContaBancaria) {
		this.idContaBancaria = idContaBancaria;
	}

	public float getSaldoAtual() {
		return saldoAtual;
	}

	public void setSaldoAtual(float saldoAtual) {
		this.saldoAtual = saldoAtual;
	}

	public Banco getBanco() {
		return banco;
	}

	public void setBanco(Banco banco) {
		this.banco = banco;
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public Transacao[] getTransacao() {
		return transacao;
	}

	public void setTransacao(Transacao[] transacao) {
		this.transacao = transacao;
	}

	public TipoModalidadeContaBancaria getTipoModalidadeContaBancaria() {
		return tipoModalidadeContaBancaria;
	}

	public void setTipoModalidadeContaBancaria(TipoModalidadeContaBancaria tipoModalidadeContaBancaria) {
		this.tipoModalidadeContaBancaria = tipoModalidadeContaBancaria;
	}

	public Investimento[] getInvestimento() {
		return investimento;
	}

	public void setInvestimento(Investimento[] investimento) {
		this.investimento = investimento;
	}

}
