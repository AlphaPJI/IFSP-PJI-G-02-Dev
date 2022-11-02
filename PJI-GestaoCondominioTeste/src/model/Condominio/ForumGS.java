package model.Condominio;

public class ForumGS {
	//atributos categoria
	private int id;
	private String tituloCategoria;
	
	//atributos comentario
	private int idConta;
	private String tituloComentarios;
	private String topico;
	private String assunto;
	
	
	public int getIdConta() {
		return idConta;
	}
	public void setIdConta(int idConta) {
		this.idConta = idConta;
	}
	public String getTituloComentarios() {
		return tituloComentarios;
	}
	public void setTituloComentarios(String tituloComentarios) {
		this.tituloComentarios = tituloComentarios;
	}
	public String getTopico() {
		return topico;
	}
	public void setTopico(String topico) {
		this.topico = topico;
	}
	public String getAssunto() {
		return assunto;
	}
	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
	public String getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(String dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	private String dataPublicacao;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTituloCategoria() {
		return tituloCategoria;
	}
	public void setTituloCategoria(String tituloCategoria) {
		this.tituloCategoria = tituloCategoria;
	}
}
