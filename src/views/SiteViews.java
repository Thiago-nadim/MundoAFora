package views;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.security.KeyStore.Entry;
import java.util.Map;

import models.SiteTurismo;
import models.Usuario;
import models.Pacote;

public class SiteViews {

    public static void verUsuarios(SiteTurismo site) {
        Map<String, Usuario> mapa = site.getMap();

        System.out.println("Conteúdo do Map:");

        for (java.util.Map.Entry<String, Usuario> entry : mapa.entrySet()) {
            String chave = entry.getKey();
            Usuario usuario = entry.getValue();

            System.out.println("email: " + chave);
            System.out.println("nome: " + usuario.getNome()); 
            System.out.println("--------");
        }
    }

}
