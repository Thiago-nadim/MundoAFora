import java.util.Scanner;

import views.SiteViews;
import controllers.AdministradorController;
import controllers.LeituraDadosImpl;
import controllers.SiteControllerImpl;
import models.SiteTurismo;


public class main {

    public static void main(String[] args) {
        SiteTurismo site = null;
        int escolha=0;
        site= LeituraDadosImpl.lerInfoSite();
        LeituraDadosImpl.leituraUsuario(site);
        LeituraDadosImpl.leituraAdmin(site);


        do {
            System.out.println(" ********************* Bem Vindo ao site " + site.getNomeEmpresa() + "! ******************");
                        System.out.println(" ----------------------Para fazer o Login digite 1 ----------------------");
            System.out.println(" ----------------------Para cadastro digite 2       ----------------------");
            System.out.println(" ");

            Scanner scanner1 = new Scanner(System.in);
            int numero = scanner1.nextInt();
            scanner1.nextLine();
            switch (numero) {
                case 1:
                    System.out.println("  ");
                    SiteControllerImpl.login(site);
                    break;

                case 2:
                    SiteControllerImpl.cadastrarUsuario(site);

                    break;
            }
            scanner1.close();
            System.out.println("Sr(a) quer continuar no menu digite algo diferente de ZERO ");
            System.out.println("");

            
            // escolha = scanner1.nextInt();//ta dando erro nessa linha depois eu corrijo - thiago nadim
        } while (escolha != 0);
        // SiteViews.verUsuarios(site);
        System.err.println("fim do programa!");
    }
}