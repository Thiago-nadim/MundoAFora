package controllers;

import models.SiteTurismo;

public class AdministradorController {

    public static void realizarCadastro(SiteTurismo site){
        LeituraDadosImpl.cadastroDados(site);//  (??) isso faz cadastro de usuario e nao de admin 
    }
    
}