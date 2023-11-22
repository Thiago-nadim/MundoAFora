package views;

import java.security.KeyStore.Entry;
import java.util.Map;

import models.SiteImpl;
import models.Usuario;

public class SiteViews {

    public static void verUsuarios( SiteImpl site){
        Map<String, Usuario> mapa = site.getMap();

        System.out.println("Conteúdo do Map:");

        for (java.util.Map.Entry<String, Usuario> entry : mapa.entrySet()) {
            String chave = entry.getKey();
            Usuario usuario = entry.getValue();

            System.out.println("email: " + chave);
            System.out.println("nome: " + usuario.getNome()); // Aqui depende da implementação do método toString() em Usuario
            System.out.println("--------");
        }
    }
    
}
