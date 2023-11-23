import java.util.Scanner;

import views.SiteViews;
import controllers.AdministradorController;
import controllers.LeituraDadosImpl;
import controllers.SiteControllerImpl;
import models.SiteTurismo;


public class main {

    public static void main(String[] args) {
        SiteTurismo site = null;
        int escolha;
        site= LeituraDadosImpl.lerInfoSite();
        LeituraDadosImpl.leituraUsuario(site);

        do {
            System.out.println(" ********************* Bem Vindo ao site " + site.getNomeEmpresa() + "! ******************");
                        System.out.println(" ----------------------Para fazer o Login digite 1 ----------------------");
            System.out.println(" ----------------------Para cadastro digite 2       ----------------------");
            System.out.println(" ");

            Scanner scanner1 = new Scanner(System.in);
            int numero = scanner1.nextInt();

            switch (numero) {
                case 1:
                    System.out.println("  ");
                    SiteControllerImpl.login(site);
                    break;

                case 2:
                    AdministradorController.realizarCadastro(site);
                    // Coloque o código relacionado ao cadastro aqui

                    break;
            }

            System.out.println("Sr(a) quer continuar no menu digite algo diferente de ZERO ");
            System.out.println("");
            escolha = scanner1.nextInt();
        } while (escolha != 0);
        SiteViews.verUsuarios(site);
    }
}