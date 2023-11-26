package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import models.Administrador;
import models.Pacote;
import models.Reserva;
import models.Pacote.CategoriasPct;
import models.SiteTurismo;
import models.Usuario;


    // uma função para abrir o TXT
    // uma função pra mandar pro TXT
    // uma função para leitura para cadastro
    // uma função para leitura do login

public class LeituraDadosImpl {

    // o construtor do site


    public static SiteTurismo lerInfoSite() {

    // Especifique o caminho do arquivo que você deseja ler
        SiteTurismo site = null;
        String caminhoArquivo = "arquivosTxt/testeTxt.txt";

        // Cria um objeto File para representar o arquivo
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
            
                if (partes.length >= 4) {
                    site = new SiteTurismo(partes[0].trim(), partes[1].trim(), partes[2].trim(), partes[3].trim());
                    System.out.println(linha);
                } else {
                    System.out.println("Linha inválida: " + linha);
                }
            }                

            // Fecha o BufferedReader
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    return site;

        // fazer a mesma coisa mas nao só apenas ler o construtor do site mas  também inicializar alguns usuarios, pacotes e adm
    }



    public static void leituraUsuario(SiteTurismo site){
        Usuario usuario = null;
        String caminhoArquivo = "arquivosTxt/leituraUsuario.txt";
        Map<String, Usuario> mapTemporario = site.getMap();

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
            
                if (partes.length >= 4) {
                    usuario = new Usuario(false, partes[0].trim(), partes[1].trim(), partes[2].trim(), partes[3].trim(), partes[4].trim(),partes[5].trim());
                    System.out.println(linha);
                    System.out.println("o nome é: " + usuario.getNome());
                    mapTemporario.put(usuario.getEmail(), usuario); 
                    site.setMap(mapTemporario);

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



    public static void leituraAdmin(SiteTurismo site){
        Administrador admin = null;
        String caminhoArquivo = "arquivosTxt/leituraAdmin.txt";
        Map<String, Administrador> mapTemporario2 = site.getMap2();

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
            
                if (partes.length >= 4) {
                    admin = new Administrador(true, partes[0].trim(), partes[1].trim(), partes[2].trim(), partes[3].trim(), partes[4].trim());
                    System.out.println(linha);
                    System.out.println("o nome é: " + admin.getNome());
                    mapTemporario2.put(admin.getEmail(),admin); 
                    site.setMap2(mapTemporario2);
                    
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


    // checa se o email e senha declarados batem com algum dos dois maps (usuario e admin)
    public static void dadosLogin(SiteTurismo site){
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3= new Scanner(System.in);

        System.out.print("Informe o email ");
        String email  = scanner1.nextLine();

        System.out.print("Informe a senha ");
        String senha  = scanner2.nextLine();

        //checa usuario
        if (site.getMap().containsKey(email)) {
            System.out.println("O email '" + email + "' está presente no sistema.");
            // System.out.println(" teste " + site.getMap().get(email).getSenha());
            boolean tentarNovamente = true;
            
            while (tentarNovamente) {
                
                if(senha.equals(site.getMap().get(email).getSenha())){ 
                    System.out.println("Login realizado com sucesso!"); 
                    SiteControllerImpl.menuUsuario(site,  site.getMap().get(email)); 
                    return;
                }
                else{
                    
                    System.out.println("Senha incorreta!");
                    System.out.println(" digite 1 para tentar novamente e 0 para sair");//exceção?
                    String escolha=scanner3.nextLine();
                    if (escolha.equals("1")){
                        System.out.print("Informe a senha ");
                        senha  = scanner2.nextLine();
                    }else{
                        tentarNovamente=false;
                    }
                    
                    
                }
                }
                return;
            }
                
        //checa admin
        if(site.getMap2().containsKey(email)){
            System.out.println("O email '" + email + "' está presente no sistema.");
            // System.out.println(" teste " + site.getMap2().get(email).getSenha());
            boolean tentarNovamente = true;
            
            while (tentarNovamente) {
                
                if(senha.equals(site.getMap2().get(email).getSenha())){ 
                    System.out.println("Login realizado com sucesso!");
                    System.out.println("Logado como admin."); 
                    SiteControllerImpl.menuAdmin(site,  site.getMap2().get(email));
                    return;
                }
                else{
                    
                    System.out.println("Senha incorreta!");
                    System.out.println(" digite 1 para tentar novamente e 0 para sair");//exceção?
                    String escolha=scanner3.nextLine();
                    if (escolha.equals("1")){
                        System.out.print("Informe a senha ");
                        senha  = scanner2.nextLine();
                    }else{
                        tentarNovamente=false;
                    }
                    
                    
                }
                }
                return;

                
            }
            scanner1.close();
            scanner2.close();
            scanner3.close();
            System.out.println("Email ou Senha errada, tente novamente!");
            return;
        }


    
    // vai cadastrar um usuário
    public static void cadastroDados(SiteTurismo site ){
        // cadastrar manualmente
        Map<String, Usuario> mapTemporario = site.getMap();
        Scanner scanner1 = new Scanner(System.in);

        System.out.print("ATENÇÃO, informe o seu: cpf, nome, telefone, email, senha e localizacao. SEPARADOS POR VIRGULA e SEM ESPAÇO\n");
        String linha  = scanner1.nextLine();
        String[] partes = linha.split(",");
        Usuario usuario = new Usuario(false, partes[0].trim(), partes[1].trim(), partes[2].trim(), partes[3].trim(), partes[4].trim(), partes[5].trim());
        mapTemporario.put(usuario.getEmail(), usuario);
        site.setMap(mapTemporario);
        
        System.out.println("Email cadastrado: " +  usuario.getEmail());
        System.out.println("Senha cadastrada: " + usuario.getSenha());

    }

    // vai cadastrar um admin
    public static void cadastroDadosAdmin(SiteTurismo site ){
        // cadastrar manualmente
        Map<String, Administrador> mapTemporario2 = site.getMap2();
        Scanner scanner1 = new Scanner(System.in);

        System.out.print("ATENÇÃO, informe os dados a seguir od admin a ser cadastrado: cpf, nome, telefone, email, senha. SEPARADOS POR VIRGULA e SEM ESPAÇO\n");
        String linha  = scanner1.nextLine();
        String[] partes = linha.split(",");
        Administrador admin = new Administrador(true, partes[0].trim(), partes[1].trim(), partes[2].trim(), partes[3].trim(), partes[4].trim());
        mapTemporario2.put(admin.getEmail(), admin);
        site.setMap2(mapTemporario2);
        
        System.out.println("Email cadastrado: " +  admin.getEmail());
        System.out.println("Senha cadastrada: " + admin.getSenha());

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
                    System.out.println("***********" + partes[0].trim() + "***********");
                    System.out.println("Quantidade Disponivel: " + partes[1].trim() );
                    System.out.println("Destino: " + partes[2].trim() );
                    System.out.println("Data de ida: " + partes[3].trim() );
                    System.out.println("Data de volta: " + partes[4].trim() );
                    System.out.println("Preço: R$" + partes[5].trim() + ",00" );
                    System.out.println("Quantidade máxima de pessoas: " + partes[6].trim() );
                    System.out.println("Id do Pacote: " + partes[7].trim() );
                    System.out.println();
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

    public static void criarPacoteNovo(SiteTurismo site, Scanner scanner_1) {
        System.out.println("Qual é o nome do novo Pacote? ");
        String nomePct = scanner_1.nextLine();
        System.out.println("O pacote já estará disponível? (sim/não)");
        String disponivel = scanner_1.nextLine();
        Boolean dispBoolean = true;
        if(!disponivel.trim().equalsIgnoreCase("sim")){
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

        System.out.println("Qual é a categoria do pacote? (Aventura, cultura ou relaxamento)");
        String categoriaStr = scanner_1.nextLine();
        CategoriasPct categoria = CategoriasPct.valueOf(categoriaStr.toUpperCase());

        int idPacote = (int)Math.floor(Math.random() * (10001 - 1) + 1);
        System.out.println("O id do pacote criado é: " + idPacote);

        Pacote pacote = new Pacote(nomePct, dispBoolean, Integer.parseInt(qtdDispPct), destino,
        dataIda, dataVolta, Double.parseDouble(preco), Integer.parseInt(qtdMaxPessoas), idPacote, categoria); // cria objeto

        site.addListPacotes(site, pacote); // adiciona na lista de pacotes em SiteTurismo

        // Coloca no Banco de dados
        File arquivo = new File( "arquivosTxt/PacotesDisponiveis.txt" );
        try {
        FileWriter fw = new FileWriter( arquivo, true );
        BufferedWriter bw = new BufferedWriter( fw );
        bw.newLine();
        bw.write(pacote.getNome() + "," + qtdDispPct + "," + destino + "," + dataIda + "," + dataVolta + "," + preco + ","
        + qtdMaxPessoas + "," + idPacote + "," + categoriaStr);

        bw.close();
        fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void fazerReserva(SiteTurismo site, Usuario usuario, int idPacote, String dataReserva, int qtdPessoas) {

        File arquivoEntrada = new File("arquivosTxt/PacotesDisponiveis.txt");
        File arquivoTemporario = new File("arquivosTxt/Temporario.txt");
        try (BufferedReader leitor = new BufferedReader(new FileReader(arquivoEntrada));
        BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoTemporario))) {

        String linhaAtual;

        //arruma banco de dados
        while ((linhaAtual = leitor.readLine()) != null) {
            String[] partes = linhaAtual.split(",");
            if (Integer.parseInt(partes[7].trim()) != idPacote) {
                System.out.println(partes[7].trim());
                escritor.write(linhaAtual);
                escritor.newLine();
            } else {
                int qtdDispPct = Integer.parseInt(partes[1]) - 1;
                String qtdDispPctStr = Integer.toString(qtdDispPct);
                escritor.write(partes[0] + "," + qtdDispPctStr + "," + partes[2] + "," + partes[3] + "," + partes[4]
                + "," + partes[5] + "," + partes[6] + "," + partes[7]);
                escritor.newLine();

                List<String> futViagens = usuario.getFutViagens();
                futViagens.add(partes[0]);
                usuario.setFutViagens(futViagens);

            }
        }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //arruma lista de pacotes site
        List<Pacote> lPacotes = site.getListPacotes();
        for(Pacote unicoPacote : lPacotes) {
            int id = unicoPacote.getIdPacote();
            if (idPacote == id)
                unicoPacote.setQuantidadeDisponivel(unicoPacote.getQuantidadeDisponivel() - 1);
                Reserva reserva = new Reserva(dataReserva, unicoPacote, qtdPessoas, usuario, idPacote);
                List<Reserva> historicoReservas = usuario.getHistoricoReservas();
                historicoReservas.add(reserva);
                usuario.setHistoricoReservas(historicoReservas);
                break;
        }

        // Renomear o arquivo temporário para substituir o original
        if (arquivoEntrada.delete() && arquivoTemporario.renameTo(arquivoEntrada)) {
            System.out.println("Pacote reservado com sucesso.");
        } else {
            System.out.println("Erro ao remover a linha.");
        }
        

    }
}