// vai guardar as collecions , dados do site 

package projeto.models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SiteImpl {
    Map<String, String> MapLogin = new HashMap<>();
    List<String> ListPacotes = new ArrayList<>();
    List<String> ListReservas = new ArrayList<>();
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
    
}
