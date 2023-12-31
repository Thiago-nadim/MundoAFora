// Guardando as collecions, dados do site 

package models;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class SiteTurismo {
    Map<String, Usuario> MapLogin = new HashMap<>(); // Login dos usuarios
    Map<String, Administrador> MapLogin2 = new HashMap<>(); // Login dos admins
    List<Pacote> ListPacotes = new ArrayList<>(); // Lista de todos os pacotes do site

    List<Reserva> ListReservas = new ArrayList<>(); // Lista com todas as reservas
    private String nomeEmpresa;
    private String cnpj;
    private String telefone;
    private String email;

    public SiteTurismo(String nomeEmpresa, String cnpj, String telefone, String email) {
        this.nomeEmpresa = nomeEmpresa;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public Map<String, Usuario> getMap() {
        return MapLogin;
    }

    public void setMap(Map<String, Usuario> novoMap) {
        this.MapLogin = novoMap;
    }

    public Map<String, Administrador> getMap2() {
        return MapLogin2;
    }

    public void setMap2(Map<String, Administrador> novoMap2) {
        this.MapLogin2 = novoMap2;
    }

    public String getEmail() {
        return email;
    }

    public List<Pacote> getListPacotes() {
        return ListPacotes;
    }

    public void setListPacotes(List<Pacote> listPacotes) {
        ListPacotes = listPacotes;
    }

    public void addListPacotes(SiteTurismo site, Pacote pacote) {
        List<Pacote> listPacotes = site.getListPacotes();
        listPacotes.add(pacote);
        site.setListPacotes(listPacotes);
    }

}