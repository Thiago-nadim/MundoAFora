package projeto.controllers;

import projeto.models.SiteImpl;

// vai fazer aq logica de compras, reservas, e login
public class SiteControllerImpl {
    
    public static void login(SiteImpl site){
        LeituraDadosImpl.dadosLogin(site);
    }

}
