import java.util.Scanner;

import controllers.LeituraDadosImpl;
import controllers.SiteControllerImpl;
import models.SiteImpl;


public class Main {

    public static void main(String[] args) {
        SiteImpl site = null;
        int escolha;
        site= LeituraDadosImpl.lerInfoSite();

        do {
            System.out.println(" ********************* Bem Vindo ao site " + site.getNomeEmpresa() + "! ******************");
            System.out.println(" ");
            System.out.println(" Esse é o nosso menu ");
            System.out.println(" ");
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
                    // Coloque o código relacionado ao cadastro aqui
                 
                    break;
            }

            System.out.println("Sr(a) quer continuar no menu digite algo diferente de ZERO ");
            System.out.println("");
            escolha = scanner1.nextInt();
        } while (escolha != 0);
    }
}

/*
    O  que eu fiz(Damner): 
        - criei o "site" e to preenchendo o construtor dele lendo o arquivo TXT pra nao ficar digitando e porque tem que fazer ALGUMAS leituras pelo TXT
        - criei uma classe para a leitura de dados para nao poluir a classe do siteControllerImpl

        
 Quando for rodar o codigo em seu computador faça o seguinte:
            1- crie um arquvio txt com o conteúdo:(apenas essa linha debaixo)
                agencia turismo,cnpj123,36689426,agenciaturismo@org.com
            2- mude o endereço para o código procurar o txt

 Depois vou terminar de fazer as coisas relacionadas ao Login e ao cadastro( Damner), vulgo sexta a noite ou sabado de dia
 
 - O codigo ta funcionando perfeitamente se der erro é por conta de deu merda na hora de ler os dados do TXT
 - To com problema no git aque pelo pc do ic e vou ter que sair "correndo" pra resolver uns negócio entao nao deu tempo de mandar pro git, perdão

 */