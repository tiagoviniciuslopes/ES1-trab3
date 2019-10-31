package unioeste.geral.banco.bo;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Investimento {

	private int idInvestimento;

	private Date dataInvestimento;

	private float valorInvestimento;

	private TipoInvestimento tipoInvestimento;

	private TipoTransacao tipoTransacao;


	public String getSQLData() {
		if (dataInvestimento == null)
			return "null";
		SimpleDateFormat stringify = new SimpleDateFormat("yyyy-MM-dd");
		return "'" + stringify.format(dataInvestimento) + "'";
	}
	public String getStringData() {
		SimpleDateFormat stringify = new SimpleDateFormat("dd/MM/yyyy");
		return stringify.format(dataInvestimento);
	}
	public boolean setDataInvestimento(String data) {
		String format = "dd/MM/yyyy";
		if (data.indexOf("-") != -1) {
			format = "yyyy-MM-dd";
		}
		SimpleDateFormat parser = new SimpleDateFormat(format);
		try {
			this.dataInvestimento = parser.parse(data);
			return true;
		} catch (Exception exception) {
			return false;
		}
	}
	public int getIdInvestimento() {
		return idInvestimento;
	}
	public void setIdInvestimento(int idInvestimento) {
		this.idInvestimento = idInvestimento;
	}
	public Date getDataInvestimento() {
		return dataInvestimento;
	}
	public void setDataInvestimento(Date dataInvestimento) {
		this.dataInvestimento = dataInvestimento;
	}
	public float getValorInvestimento() {
		return valorInvestimento;
	}
	public void setValorInvestimento(float valorInvestimento) {
		this.valorInvestimento = valorInvestimento;
	}
	public TipoInvestimento getTipoInvestimento() {
		return tipoInvestimento;
	}
	public void setTipoInvestimento(TipoInvestimento tipoInvestimento) {
		this.tipoInvestimento = tipoInvestimento;
	}
	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}
	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	

}
