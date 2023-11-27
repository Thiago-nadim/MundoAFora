package models;

public abstract class Pessoa {
    protected  boolean ehAdmin;
    protected String cpf;
    protected String nome;
    protected String telefone;
    protected String email;
    protected String senha;

    public Pessoa(boolean ehAdmin, String cpf, String nome, String telefone, String email, String senha) {
        this.ehAdmin = ehAdmin;
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }

    public String getTelefone() { return telefone; }
    public String getCpf() { return cpf; }
    public boolean isEhAdmin() { return ehAdmin;}
    public String getNome() { return nome; }
    public void setEmail(String email) { this.email = email; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public void setSenha(String senha) {this.senha=senha; }
  
}
