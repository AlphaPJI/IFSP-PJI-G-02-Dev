package model.Condominio;

import java.sql.Date;

public class ForumGS {
	//atributos categoria
	private int id;
	private String tituloCategoria;
	
	//atributos comentario
	private int idComentario;
	private int idConta;
	private String tituloComentarios;
	private String topico;
	private String assunto;
	private boolean avaliação;
	private Date dataPublicacao;	
	private String nome;
	private String bloco;

	public boolean isAvaliacao() {
		return avaliação;
	}
	public void setAvaliacao(boolean avaliacao) {
		this.avaliação = avaliacao;
	}
	
	public int getIdComentario() {
		return idComentario;
	}
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}
	
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
	public void setDataPublicacao(Date date) {
		this.dataPublicacao = date;
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
