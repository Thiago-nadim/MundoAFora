package controllers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import models.Pacote;
import models.SiteTurismo;

public class AdministradorController {

    public static void realizarCadastro(SiteTurismo site){
        LeituraDadosImpl.cadastroDados(site);//  (??) isso faz cadastro de usuario e nao de admin 
    }

    public static void criarPacote(SiteTurismo site, Scanner scanner_1) {
        LeituraDadosImpl.criarPacoteNovo(site, scanner_1);
    }
    
}