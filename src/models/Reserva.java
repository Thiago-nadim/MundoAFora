package models;

public class Reserva {
    
    private String dataReserva;
    private Pacote pctReserva;
    private int qtdePessoas;
    private Usuario usuarioReserv;
    private int idReserv;

    

    public Reserva(String dataReserva,Pacote pctReserva,int qtdePessoas,Usuario usuarioReserv,int idReserv){
        this.dataReserva=dataReserva;
        this.pctReserva=pctReserva;
        this.qtdePessoas=qtdePessoas;
        this.usuarioReserv=usuarioReserv;
        this.idReserv=idReserv;
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

    public Usuario getUsuarioReserv() {
        return usuarioReserv;
    }

    public int getIdReserv() {
        return idReserv;
    }
}
