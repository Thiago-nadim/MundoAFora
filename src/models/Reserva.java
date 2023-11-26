package models;

public class Reserva {
    
    private String dataReserva;
    private Pacote pctReserva;
    private int qtdePessoas;
    private Usuario usuarioReserva;
    private int idReserva;

    

    public Reserva(String dataReserva,Pacote pctReserva,int qtdePessoas,Usuario usuarioReserva,int idReserva){
        this.dataReserva=dataReserva;
        this.pctReserva=pctReserva;
        this.qtdePessoas=qtdePessoas;
        this.usuarioReserva=usuarioReserva;
        this.idReserva=idReserva;
    }

   @Override
   public String toString() {
       
       return "Data da reserva"+ this.dataReserva+"\n"+
                "Pacote:"+ this.pctReserva +"\n"+
                "Quantidade de pessoas:"+ this.qtdePessoas+"\n"+
                "Usuário que efetuou a reserva" + this.usuarioReserva+"\n"+
                "id da Reserva"+ this.idReserva;

   }

    
    // getters
    public String getDataReserva() {
        return dataReserva;
    }

    public Pacote getPctReserva() {
        return pctReserva;
    }

    public int getQtdePessoas() {
        return qtdePessoas;
    }

    public Usuario getUsuarioReserva() {
        return usuarioReserva;
    }

    public int getIdReserva() {
        return idReserva;
    }
}
