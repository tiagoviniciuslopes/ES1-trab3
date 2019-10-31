package unioeste.geral.banco.bo;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transacao {

	private int idTransferencia;

	private Date dataTransferencia;

	private String motivoTransferencia;

	private float valorTransferencia;

	private ContaBancaria contaBancaria;

	private TipoTransacao tipoTransacao;

	
	public String getSQLData() {
		if (dataTransferencia == null)
			return "null";
		SimpleDateFormat stringify = new SimpleDateFormat("yyyy-MM-dd");
		return "'" + stringify.format(dataTransferencia) + "'";
	}
	public String getStringData() {
		SimpleDateFormat stringify = new SimpleDateFormat("dd/MM/yyyy");
		return stringify.format(dataTransferencia);
	}
	public boolean setDataTransferencia(String data) {
		String format = "dd/MM/yyyy";
		if (data.indexOf("-") != -1) {
			format = "yyyy-MM-dd";
		}
		SimpleDateFormat parser = new SimpleDateFormat(format);
		try {
			this.dataTransferencia = parser.parse(data);
			return true;
		} catch (Exception exception) {
			return false;
		}
	}
	public int getIdTransferencia() {
		return idTransferencia;
	}
	public void setIdTransferencia(int idTransferencia) {
		this.idTransferencia = idTransferencia;
	}
	public Date getDataTransferencia() {
		return dataTransferencia;
	}
	public void setDataTransferencia(Date dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}
	public String getMotivoTransferencia() {
		return motivoTransferencia;
	}
	public void setMotivoTransferencia(String motivoTransferencia) {
		this.motivoTransferencia = motivoTransferencia;
	}
	public float getValorTransferencia() {
		return valorTransferencia;
	}
	public void setValorTransferencia(float valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}
	public ContaBancaria getContaBancaria() {
		return contaBancaria;
	}
	public void setContaBancaria(ContaBancaria contaBancaria) {
		this.contaBancaria = contaBancaria;
	}
	public TipoTransacao getTipoTransacao() {
		return tipoTransacao;
	}
	public void setTipoTransacao(TipoTransacao tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	
	
}
