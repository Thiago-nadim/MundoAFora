package controllers;

import models.Administrador;
import models.SiteTurismo;
import java.util.Scanner;


public class AdministradorController {

    public static void realizarCadastro(SiteTurismo site){
        LeituraDadosImpl.cadastroDados(site);//  (??) isso faz cadastro de usuario e nao de admin 
    }

    
}