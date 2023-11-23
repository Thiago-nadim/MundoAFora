package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import models.SiteImpl;
import models.Usuario;


    // uma função para abrir o TXT
    // uma função pra mandar pro TXT
    // uma função para leitura para cadastro
    // uma função para leitura do login

public class LeituraDadosImpl {

    // o construtor do site
    public static SiteImpl lerInfoSite() {

        // Especifique o caminho do arquivo que você deseja ler
            SiteImpl site = null;
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
                        site = new SiteImpl(partes[0].trim(), partes[1].trim(), partes[2].trim(), partes[3].trim());
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

        public static void leituraUsuario(SiteImpl site){
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
                        usuario = new Usuario(false, partes[0].trim(), partes[1].trim(), partes[2].trim(), partes[3].trim(), partes[4].trim());
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

        public static void dadosLogin(SiteImpl site){
            Scanner scanner1 = new Scanner(System.in);
            Scanner scanner2 = new Scanner(System.in);

            System.out.print("Informe o email ");
            String email  = scanner1.nextLine();

            System.out.print("Informe a senha ");
            String senha  = scanner2.nextLine();

            if (site.getMap().containsKey(email)) {
                System.out.println("O email '" + email + "' está presente no Map de usuarios.");
                System.out.println(" teste " + site.getMap().get(email).getSenha());

                if(senha.equals(site.getMap().get(email).getSenha())){ 
                    System.out.println("Login feito com sucesso!"); 
                    SiteControllerImpl.menuUsuario(site,  site.getMap().get(email)); 
                    return;
                }
            }
            if(site.getMap2().containsKey(email)){
                if(senha.equals(site.getMap2().get(email).getSenha())){  
                    SiteControllerImpl.menuAdmin(site, site.getMap2().get(email));  
                    return;
                }
            }
            System.out.println("Email ou Senha errada, tente novamente!");
        }

        public static void cadastroDados(SiteImpl site ){
            // cadastrar manualmente
            Map<String, Usuario> mapTemporario = site.getMap();
            Scanner scanner1 = new Scanner(System.in);

            System.out.print("ATENÇÃO, informe o seu: cpf, nome, telefone, email, senha. SEPARADOS POR VIRGULA e SEM ESPAÇO\n");
            String linha  = scanner1.nextLine();
            String[] partes = linha.split(",");
            Usuario usuario = new Usuario(false, partes[0].trim(), partes[1].trim(), partes[2].trim(), partes[3].trim(), partes[4].trim());
            mapTemporario.put(usuario.getEmail(), usuario);
            site.setMap(mapTemporario);

            System.out.println("Email cadastrado: "+  usuario.getEmail());
            System.out.println("Senha cadastrada: " + usuario.getSenha());

        }

}


