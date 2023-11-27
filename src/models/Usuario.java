package models;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Pessoa {
    private String localizacao;
    List<String> FutViagens = new ArrayList<>();
    List<Reserva> historicoReservas = new ArrayList<>();

    
    public Usuario(boolean ehAdmin, String cpf, String nome, String telefone, String email, String senha,String localizacao
    ) { 

        super(ehAdmin, cpf, nome, telefone, email, senha);
        this.localizacao=localizacao;
    }

    @Override
    public String toString() {
        
        return "Cpf:"+this.cpf +"\n"
        +"Nome:"+this.nome+"\n"
        +"Telefone:"+this.telefone+"\n"
        +"E-mail:"+this.email+"\n"
        +"Localização:"+this.localizacao+"\n";
    }



    public String getLocalizacao() { return localizacao; }

    public List<String> getFutViagens() {
      return FutViagens;
    }
    public void setFutViagens(List<String> futViagens) {
      FutViagens = futViagens;
    }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    public List<Reserva> getHistoricoReservas() {
      return historicoReservas;
    }
    public void setHistoricoReservas(List<Reserva> historicoReservas) {
      this.historicoReservas = historicoReservas;
    }
}
