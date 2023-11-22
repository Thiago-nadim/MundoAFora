package controllers;

import models.SiteImpl;

public class AdministradorController {

    public static void realizarCadastro(SiteImpl site){
        LeituraDadosImpl.cadastroDados(site);
    }
    
}