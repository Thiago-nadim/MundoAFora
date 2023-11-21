package projeto.controllers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import projeto.models.SiteImpl;


    // uma função para abrir o TXT
    // uma função pra mandar pro TXT
    // uma função para leitura para cadastro
    // uma função para leitura do login

public class LeituraDadosImpl {

    public static SiteImpl lerInfoSite() {

        // Especifique o caminho do arquivo que você deseja ler
            SiteImpl site = null;
            String caminhoArquivo = "/home/ec2021-fra/ra247035/Documents/testeTxt.txt";

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
        }


        public static void dadosLogin(SiteImpl site){
            Scanner scanner1 = new Scanner(System.in);
            Scanner scanner2 = new Scanner(System.in);

            System.out.print("Informe o email ");
            String email  = scanner1.nextLine();

            System.out.print("Informe a senha ");
            String senha  = scanner2.nextLine();


            // vai ter que verificar aqui se o email e a senha está aqui pq nao tem como retornar duas coisas :(
            // depois vou implementar essa lógica

        }

}


 
