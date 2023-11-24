package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import models.Administrador;
import models.SiteTurismo;
import models.Usuario;

// vai fazer aq logica de compras, reservas, e login
public class SiteControllerImpl {
    
    public static void login(SiteTurismo site){
        LeituraDadosImpl.dadosLogin(site);
        
    }

    public static void cadastrarUsuario(SiteTurismo site){
        LeituraDadosImpl.cadastroDados(site);

    }

    public static void menuUsuario(SiteTurismo site, Usuario usuario){
        
        Scanner scanner_1 = new Scanner(System.in);
        boolean continuaMenuUser=true;
        while (continuaMenuUser) {
            System.out.println("                   *********** MENU DE USUARIO*********");
            System.out.println(" ");
            System.out.println(" ----------------------Para acessar futuras viagens digite 1----------------------");
            System.out.println(" ----------------------Para acessar Histórico de Compras digite 2 ----------------------");
            System.out.println(" ----------------------Para acessar Pacotes digite 3 ----------------------");
            System.out.println(" ");
        int numero = scanner_1.nextInt();
        scanner_1.nextLine();
        
        switch (numero) {

            case 1:
                System.out.println("As futuras viagens progrmadas são as seguintes:");
                System.out.println(usuario.getFutViagens());
                System.out.println("Voltar para o Menu?digite 1/ Sair digite 0");
                String escolha1=scanner_1.nextLine();
                if (!escolha1.equals("1")){
                    continuaMenuUser=false;
                }
                break;
                
                case 2:       
                System.out.println("O histórico de viagens é o seguinte:");
                System.out.println(usuario.getHistoricoReservas());
                System.out.println("Voltar para o Menu?digite 1/ Sair digite 0");
                String escolha2=scanner_1.nextLine();
                if (!escolha2.equals("1")){
                    continuaMenuUser=false;
                }

            break;

            case 3:
                System.out.println("Acessando pacotes disponíveis");
                LeituraDadosImpl.verPacotesDisponiveis(site);
                System.out.println("Voltar para o Menu?digite 1/ Sair digite 0");
                String escolha3=scanner_1.nextLine();
                if (!escolha3.equals("1")){
                    continuaMenuUser=false;
                }
            break;

        }
        }
        scanner_1.close();
    }

    

    public static void menuAdmin(SiteTurismo site, Administrador administrador){ 
        Scanner scanner_1 = new Scanner(System.in);
        boolean continuaMenuAdmin=true;
        while (continuaMenuAdmin) {

        System.out.println(" *********** MENU DE ADMIN*********");
        System.out.println(" ");
        System.out.println(" ----------------------Para ver acessar todos pacotes do site digite 1----------------------");
        System.out.println(" ----------------------Para editar pacotes digite 2  ----------------------");
        System.out.println(" ----------------------Para criar pacotes digite 3----------------------");
        System.out.println(" ----------------------Para remover pacotes digite 4----------------------");
        System.out.println(" ----------------------Para cadastrar Admins---------------------");


        System.out.println(" ");

        int numero = scanner_1.nextInt();
        scanner_1.nextLine();
        
            
        switch (numero) {
            
            case 1:
            System.out.println(site.getListPacotes());
            System.out.println("Voltar para o Menu?digite 1/ Sair digite 0");
            String escolha1=scanner_1.nextLine();
            if (!escolha1.equals("1")){
                continuaMenuAdmin=false;
            }
            break;

            case 2:        
            System.out.println("Qual pacote deseja editar");
            //logiva de edição de pacotes
            System.out.println("Voltar para o Menu?digite 1/ Sair digite 0");
            String escolha2=scanner_1.nextLine();
            if (!escolha2.equals("1")){
                continuaMenuAdmin=false;
            }
            break;

            case 3:
            System.out.println("Criar um novo Pacote");
            //lógica de criação de pacote
            System.out.println("Voltar para o Menu?digite 1/ Sair digite 0");
            String escolha3=scanner_1.nextLine();
            if (!escolha3.equals("1")){
                continuaMenuAdmin=false;
            }
            break;

            case 4:
            System.out.println("Qual pacote deseja remover?");
            //lógica de remoção de pacote
            System.out.println("Voltar para o Menu?digite 1/ Sair digite 0");
            String escolha4=scanner_1.nextLine();
            if (!escolha4.equals("1")){
                continuaMenuAdmin=false;
            }
            break;

            case 5:
            System.out.println("Área de cadastro de admins");
            //lógica de cadastro de admins
            System.out.println("Voltar para o Menu?digite 1/ Sair digite 0");
            String escolha5=scanner_1.nextLine();
            if (!escolha5.equals("1")){
                continuaMenuAdmin=false;
            }
            break;

          
        }
        }
        scanner_1.close();
    }
}
