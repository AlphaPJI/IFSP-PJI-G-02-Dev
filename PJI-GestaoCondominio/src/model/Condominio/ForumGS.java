package model.Condominio;

import java.sql.Date;

public class ForumGS {
	//atributos categoria
	private int id;
	private String tituloCategoria;
	
	//atributos comentario
	private int idConta;
	private String tituloComentarios;
	private String topico;
	private String assunto;
	private Date dataPublicacao;
	
	private String nome;
	private String bloco;

	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getBloco() {
		return bloco;
	}
	public void setBloco(String bloco) {
		this.bloco = bloco;
	}
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
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	
	
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
