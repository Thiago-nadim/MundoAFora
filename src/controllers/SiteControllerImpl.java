package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Iterator;


import models.Administrador;
import models.SiteTurismo;
import models.Usuario;
import models.Pacote;

// vai fazer aq logica de compras, reservas, e login
public class SiteControllerImpl {

    public static void login(SiteTurismo site) {
        LeituraDadosImpl.dadosLogin(site);

    }

    public static void cadastrarUsuario(SiteTurismo site) {
        LeituraDadosImpl.cadastroDados(site);

    }

    public static void menuUsuario(SiteTurismo site, Usuario usuario) {

        Scanner scanner_1 = new Scanner(System.in);
        boolean continuaMenuUser = true;
        while (continuaMenuUser) {
            System.out.println("                   *********** MENU DE USUARIO*********");
            System.out.println(" ");
            System.out.println(" ----------------------Para acessar futuras viagens digite 1----------------------");
            System.out.println(
                    " ----------------------Para acessar Histórico de Compras digite 2 ----------------------");
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
                    System.out.println("Sair? digite 0");
                    System.out.println("Filtrar Pacotes? Digite 1");
                    System.out.println("Reservar Pacote? Digite 2");
                    System.out.println("Voltar para o Menu? Digite qualquer outro número");
                    numero = scanner_1.nextInt();
                    switch (numero) {
                        case 0:
                            continuaMenuUser=false;
                        case 1:

                        case 2:
                        System.out.println("Digite o id do pacote desejado: ");
                        int id = scanner_1.nextInt();
                        System.out.println("Qual é a data que está fazendo essa reserva? ");
                        String dataReserva = scanner_1.next();
                        System.out.println("Para quantas pessoas é a reserva? ");
                        int qtdePessoas = scanner_1.nextInt();
                        AdministradorController.realizarReserva(site, usuario, id, dataReserva, qtdePessoas);
                    }
                break;
            }
        }
        scanner_1.close();
    }

    public static void menuAdmin(SiteTurismo site, Administrador administrador) {
        Scanner scanner_1 = new Scanner(System.in);
        boolean continuaMenuAdmin = true;
        while (continuaMenuAdmin) {

            System.out.println(" *********** MENU DE ADMIN*********");
            System.out.println(" ");
            System.out.println(" ----------------------Digite 1 para acessar todos pacotes do site ----------------------");
            System.out.println(" ----------------------Digite 2 para editar pacotes   ----------------------");
            System.out.println(" ----------------------digite 3 para criar pacotes----------------------");
            System.out.println(" ----------------------Digite 4 para remover pacotes ----------------------");
            System.out.println(" ----------------------Digite 5 para cadastrar Admins---------------------");

            System.out.println(" ");

            System.out.println(" ");

            int numero = scanner_1.nextInt();
            scanner_1.nextLine();
            
                
            switch (numero) {
                
                case 1:
                System.out.println(site.getListPacotes());             // implementar
                System.out.println("Voltar para o Menu?digite 1/ Sair digite 0");
                String escolha1=scanner_1.nextLine();
                if (!escolha1.equals("1")){
                    continuaMenuAdmin=false;
                }
                break;

                case 2:   
                AdministradorController.EditarPacotes(site, scanner_1);
                System.out.println("Voltar para o Menu?digite 1/ Sair digite 0");
                String escolha2=scanner_1.nextLine();
                if (!escolha2.equals("1")){
                    continuaMenuAdmin=false;
                }
                break;

                case 3:
                AdministradorController.criarPacote(site, scanner_1);
                System.out.println("Voltar para o Menu?digite 1/ Sair digite 0");
                String escolha3=scanner_1.nextLine();
                if (!escolha3.equals("1")){
                    continuaMenuAdmin=false;
                }
                break;

                case 4:
                Scanner scanner = new Scanner(System.in);

                System.out.println("Digite o ID do pacote que deseja excluir:");
                int idPacoteParaExcluir = scanner.nextInt();
                scanner.nextLine();

                boolean pacoteEncontrado = false;

                // Criando copia da lista de pacotes
                List<Pacote> listaPacotes = new ArrayList<>(site.getListPacotes());

                for(Pacote pacoteLista : listaPacotes) {
                    if (pacoteLista.getIdPacote() == idPacoteParaExcluir) {
                        pacoteEncontrado = true;
                        listaPacotes.remove(pacoteLista);

                        // Atualizar o arquivo PacotesDisponiveis.txt
                        atualizarArquivoPacotes(site, listaPacotes);

                        System.out.println("Pacote removido com sucesso!");
                        break;
                    }
                }

                if (!pacoteEncontrado){
                    System.out.println("Pacote não encontrado.");
                }

                System.out.println("Voltar para o Menu?digite 1/ Sair digite 0");
                String escolha4=scanner_1.nextLine();
                if (!escolha4.equals("1")){
                    continuaMenuAdmin = false;
                }
                break;

                case 5:
                AdministradorController.CadastrarAdmin(site, scanner_1);

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
    

    // Método para atualizar arquivo de pacote
    private static void atualizarArquivoPacotes(SiteTurismo site, List<Pacote> listaPacotes) {
        File arquivo = new File("arquivosTxt/PacotesDisponiveis.txt");

        try {
            FileWriter fw = new FileWriter(arquivo);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Pacote pacote : listaPacotes) {
                bw.write(pacote.toFileString());
                bw.newLine();
            }

            bw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}