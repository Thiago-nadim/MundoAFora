package models;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Pessoa {
    private String localizacao;
    List<String> FutViagens = new ArrayList<>();
   
    public Usuario(boolean ehAdmin, String cpf, String nome, String telefone, String email, String senha) {
        super(ehAdmin, cpf, nome, telefone, email, senha);
    }
    public String getLocalizacao() { return localizacao; }
    public String getCpf() { return senha; }
    public String getNome() { return senha; }
    public String getTelefone() { return senha; }
    public String getEmail() { return email; }
    public String getSenha() { return senha; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

}
