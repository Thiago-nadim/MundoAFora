package controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import models.Administrador;
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
                        System.out.println("Login realizado com sucesso!/n Logado como admin."); 
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
            System.out.println("Email ou Senha errada, tente novamente!");
            scanner1.close();
            scanner2.close();
            scanner3.close();
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
    
}


