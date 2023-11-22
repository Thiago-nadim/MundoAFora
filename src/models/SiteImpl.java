// vai guardar as collecions , dados do site 

package models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SiteImpl {
    Map<String, Usuario> MapLogin = new HashMap<>();  
    Map<String, Administrador> MapLogin2 = new HashMap<>();  
    List<Pacote> ListPacotes = new ArrayList<>();
    List<Reserva> ListReservas = new ArrayList<>();
    private String nomeEmpresa;
    private String cpj;
    private String telefone;

    public SiteImpl(String nomeEmpresa, String cpj, String telefone, String contato) {
        this.nomeEmpresa = nomeEmpresa;
        this.cpj = cpj;
        this.telefone = telefone;
    }

    public String getNomeEmpresa() { return nomeEmpresa; }
    public String getCpj() { return cpj; }
    public String getTelefone() { return telefone;}
    public Map<String, Usuario> getMap() { return MapLogin; }
    public void setMap(Map<String, Usuario> novoMap) { this.MapLogin = novoMap;}
    public Map<String, Administrador> getMap2() { return MapLogin2; }
    public void setMap2(Map<String, Administrador> novoMap2) { this.MapLogin2 = novoMap2;}
    
    
}
