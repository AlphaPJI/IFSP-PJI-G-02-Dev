package model.Condominio;

public class Conta {
		private int id;
		private String nome;
		private String email;
		private String senha;
		private String cpf;
		private String rg;
		private boolean verificarEmail;
		private boolean verificado;
		private boolean administrador;
		private String apartamento;
		private Object bloco;
		private String novaSenha;
		private String emailRecuperacao;
		private String novoEmail;
		private String emailVerificacao;
		private String senhaCriptografada;
		
		public String getSenhaCriptografada() {
			return senhaCriptografada;
		}
		public void setSenhaCriptografada(String senhaCriptografada) {
			this.senhaCriptografada = senhaCriptografada;
		}
		public String getEmailVerificacao() {
			return emailVerificacao;
		}
		public void setEmailVerificacao(String emailVerificacao) {
			this.emailVerificacao = emailVerificacao;
		}
		public String getNovoEmail() {
			return novoEmail;
		}
		public void setNovoEmail(String novoEmail) {
			this.novoEmail = novoEmail;
		}
		public String getEmailRecuperacao() {
			return emailRecuperacao;
		}
		public void setEmailRecuperacao(String emailRecuperacao) {
			this.emailRecuperacao = emailRecuperacao;
		}
		public String getNovaSenha() {
			return novaSenha;
		}
		public void setNovaSenha(String novaSenha) {
			this.novaSenha = novaSenha;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getSenha() {
			return senha;
		}
		public void setSenha(String senha) {
			this.senha = senha;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getRg() {
			return rg;
		}
		public void setRg(String rg) {
			this.rg = rg;
		}
		public boolean isVerificarEmail() {
			return verificarEmail;
		}
		public void setVerificarEmail(boolean verificarEmail) {
			this.verificarEmail = verificarEmail;
		}
		public boolean isVerificado() {
			return verificado;
		}
		public void setVerificado(boolean verificado) {
			this.verificado = verificado;
		}
		public boolean isAdministrador() {
			return administrador;
		}
		public void setAdministrador(boolean administrador) {
			this.administrador = administrador;
		}
		public String getApartamento() {
			return apartamento;
		}
		public void setApartamento(String apartamento) {
			this.apartamento = apartamento;
		}
		public Object getBloco() {
			return bloco;
		}
		public void setBloco(Object bloco) {
			this.bloco = bloco;
		}
	}