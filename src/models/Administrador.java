package models;

public class Administrador extends Pessoa{
   
    public Administrador(boolean ehAdmin, String cpf, String nome, String telefone, String email, String senha) {
        super(ehAdmin, senha, senha, senha, senha, senha);
    }
    
}