package models;

import java.util.ArrayList;

public class Destino {
    
    private enum CategoriasDest{
        PRAIA, MONTANHA, CIDADE
    }

    private String descricao;
    private String imagem;
    private CategoriasDest categorias;
    private ArrayList<String> atividadesDisp; 
    
    
    

    public Destino(String descricao, String imagem, CategoriasDest categorias) {
        this.descricao = descricao;
        this.imagem = imagem;
        this.categorias = categorias;
    }

    @Override
    public String toString() {
        
        return "Descrição"+this.descricao+"\n"+
                "Imagem"+this.imagem+"\n"+
                "Categoria"+this.categorias ;
    }


    public String getDescricao() {
        return descricao;
    }


    public String getImagem() {
        return imagem;
    }

    public ArrayList<String> getAtividadesDisp() {
        return atividadesDisp;
    }
    


    public CategoriasDest getCategorias() {
        return categorias;
    }
    
    



}
