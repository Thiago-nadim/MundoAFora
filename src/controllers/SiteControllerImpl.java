package controllers;

import java.util.Scanner;

import models.Administrador;
import models.SiteImpl;
import models.Usuario;

// vai fazer aq logica de compras, reservas, e login
public class SiteControllerImpl {
    
    public static void login(SiteImpl site){
        LeituraDadosImpl.dadosLogin(site);
        
    }

    public static void cadastrar(SiteImpl site){
        // manualmente

    }

    public static void menuUsuario(SiteImpl site, Usuario usuario){
        System.out.println(" *********** MENU DE USUARIO*********");
        System.out.println(" ");
        System.out.println(" ----------------------Para ver acessar futuras viagens digite 1----------------------");
        System.out.println(" ----------------------Para acessar Histórico de Compras digite 2 ----------------------");
        System.out.println(" ----------------------Para acessar Pacotes digite 3 ----------------------");
        System.out.println(" ");

        Scanner scanner1 = new Scanner(System.in);
        int numero = scanner1.nextInt();
        
        switch (numero) {

            case 1:
            break;

            case 2:        
            break;

            case 3:
            break;

          
        }

    }

    public static void menuAdmin(SiteImpl site, Administrador administrador){ 

        System.out.println(" *********** MENU DE USUARIO*********");
        System.out.println(" ");
        System.out.println(" ----------------------Para ver acessar futuras viagens digite 1----------------------");
        System.out.println(" ----------------------Para editar pacotes digite 2  ----------------------");
        System.out.println(" ----------------------Para criar pacotes digite 3----------------------");
        System.out.println(" ----------------------Para remover pacotes digite 4----------------------");
        System.out.println(" ----------------------Para cadastrar Admins---------------------");


        System.out.println(" ");

        Scanner scanner1 = new Scanner(System.in);
        int numero = scanner1.nextInt();
        
        switch (numero) {
            
            case 1:
            break;

            case 2:        
            break;

            case 3:
            break;

            case 4:
            break;

            case 5:
            break;

          
        }
    }
}
