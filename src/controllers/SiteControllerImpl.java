package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import models.Administrador;
import models.Pacote;
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
        System.out.println(" *********** MENU DE USUARIO*********");
        System.out.println(" ");
        System.out.println(" ----------------------Para acessar futuras viagens digite 1----------------------");
        System.out.println(" ----------------------Para acessar Histórico de Compras digite 2 ----------------------");
        System.out.println(" ----------------------Para acessar Pacotes digite 3 ----------------------");
        System.out.println(" ");

        Scanner scanner1 = new Scanner(System.in);
        int numero = scanner1.nextInt();
        
        switch (numero) {

            case 1:
                System.out.println(usuario.getFutViagens());
                break;
                
                case 2:       
                System.out.println(usuario.getHistoricoReservas());

            break;

            case 3:
                verPacotesDisponiveis(site);
            break;

        }

    }

    public static void verPacotesDisponiveis( SiteTurismo site){
            String caminhoArquivo = "arquivosTxt/PacotesDisponiveis.txt";

            File arquivo = new File(caminhoArquivo);
    
            try {
                // Cria um FileReader para ler o arquivo
                FileReader leitor = new FileReader(arquivo);

                // Cria um BufferedReader para leitura eficiente
                BufferedReader bufferedReader = new BufferedReader(leitor);
    
                String linha;
    
                // Lê cada linha do arquivo até o final
                while ((linha = bufferedReader.readLine()) != null) {
                    String[] partes = linha.split(",");
                
                    if (partes.length >= 7) {
                        Pacote pacote = new Pacote(partes[0].trim(), Integer.parseInt(partes[1].trim()), partes[2].trim(), partes[3].trim(), partes[4].trim(), Double.parseDouble(partes[5].trim()), Integer.parseInt(partes[6].trim()), Integer.parseInt(partes[7].trim()), partes[8].trim());
                        pacote.exibirInformacoes();
                    } else {
                        System.out.println("Linha inválida: " + linha);
                    }
                }                
    
                // Fecha o BufferedReader
                bufferedReader.close();
    
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public static void menuAdmin(SiteTurismo site, Administrador administrador){ 

        System.out.println(" *********** MENU DE ADMIN*********");
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
