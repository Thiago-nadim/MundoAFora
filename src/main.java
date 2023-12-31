import java.util.NoSuchElementException;
import java.util.Scanner;

import views.SiteViews;
import controllers.AdministradorController;
import controllers.LeituraDadosImpl;
import controllers.SiteControllerImpl;
import models.SiteTurismo;

public class main {

    public static void main(String[] args) {
        SiteTurismo site = null;
        int escolha = 0;
        site = LeituraDadosImpl.lerInfoSite();
        LeituraDadosImpl.leituraUsuario(site);
        LeituraDadosImpl.leituraAdmin(site);
        LeituraDadosImpl.LeituraPacotes(site);
        // System.out.println("Olaaaa");
        // System.out.println(site.getListPacotes());
        Scanner scanner1 = new Scanner(System.in);

        do {
            System.out.println(
                    " ********************* Bem Vindo ao site " + site.getNomeEmpresa() + "! ******************");
            System.out.println(" ----------------------Para fazer o Login digite 1 ----------------------");
            System.out.println(" ----------------------Para cadastro digite 2       ----------------------");
            System.out.println(" ");

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
                default:
                    System.out.println("Entrada inválida!O que deseja fazer?");
            }
            //
            System.out.println("Digite 1 para voltar à tela de login/cadastro.\nDigite 0 para encerrar o programa.");
            // System.out.println("");

            try {
                escolha = scanner1.nextInt();
            } catch (NoSuchElementException e) {
                System.err.println("Volte sempre!");
            }

            // scanner1.nextLine();
        } while (escolha != 0);
        // SiteViews.verUsuarios(site);
        System.out.println("Fim do programa!");
    }
}