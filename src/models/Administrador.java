package models;

public class Administrador extends Pessoa {

    public Administrador(boolean ehAdmin, String cpf, String nome, String telefone, String email, String senha) {
        super(ehAdmin, cpf, nome, telefone, email, senha);
    }

    @Override
    public String toString() {

        return "Cpf:" + this.cpf + "\n"
                + "Nome:" + this.nome + "\n"
                + "Telefone:" + this.telefone + "\n"
                + "E-mail:" + this.email + "\n";
    }
}
