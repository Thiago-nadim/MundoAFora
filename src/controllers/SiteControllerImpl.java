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

import models.Administrador;
import models.SiteTurismo;
import models.Usuario;
import models.Pacote;

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
        System.out.println(" ----------------------Para acessar todos pacotes do site digite 1----------------------");
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
            System.out.println("Qual é o nome do novo Pacote? ");
            String nomePct = scanner_1.nextLine();
            System.out.println("O pacote já estará disponível? ");
            String disponivel = scanner_1.nextLine();
            Boolean dispBoolean = true;
            if(!disponivel.equalsIgnoreCase("sim")){
                dispBoolean = false;
            }
            System.out.println("Quantos pacotes estarão disponíveis? ");
            String qtdDispPct = scanner_1.nextLine();
            System.out.println("Qual é o destino do Pacote? ");
            String destino = scanner_1.nextLine();
            System.out.println("Qual é a data de ida do pacote? (Ex:30/01/2000) ");
            String dataIda = scanner_1.nextLine();
            System.out.println("Qual é a data de volta do pacote? (Ex:30/01/2000) ");
            String dataVolta = scanner_1.nextLine();
            System.out.println("Qual é o preço do pacote? (Ex:500)");
            String preco = scanner_1.nextLine();
            System.out.println("Qual é a quantidade máxima de pessoas que podem fazer parte do pacote? ");
            String qtdMaxPessoas = scanner_1.nextLine();
            System.out.println("Qual é a categoria do pacote? ");
            String categoria = scanner_1.nextLine(); //preciso ver como passo isso pra string pra passar pro banco de dados
            int idPacote = (int)Math.floor(Math.random() * (1001 - 1) + 1);
            System.out.println("O id do pacote criado é: " + idPacote);

            Pacote pacote = new Pacote(nomePct, Boolean.parseBoolean(disponivel), Integer.parseInt(qtdDispPct), destino,
            dataIda, dataVolta, Double.parseDouble(preco), Integer.parseInt(qtdMaxPessoas), idPacote, null);

            //Escrever no txt
            File arquivo = new File( "arquivosTxt/PacotesDisponiveis.txt" );
            try {
            FileWriter fw = new FileWriter( arquivo, true );
            BufferedWriter bw = new BufferedWriter( fw );
            bw.newLine();
            bw.write(nomePct + "," + qtdDispPct + "," + destino + "," + dataIda + "," + dataVolta + "," + preco + ","
            + qtdMaxPessoas + "," + idPacote + "," + categoria);

            bw.close();
            fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
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

            // Atualizar pacote 

            scanner.close();

            System.out.println("Voltar para o Menu?digite 1/ Sair digite 0");
            String escolha4=scanner_1.nextLine();
            if (!escolha4.equals("1")){
                continuaMenuAdmin = false;
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