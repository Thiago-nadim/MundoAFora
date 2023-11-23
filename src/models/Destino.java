package models;

public class Destino {
    
    private enum CategoriasDest{
        PRAIA, MONTANHA, CIDADE
    }

    private String descricao;
    private String imagem;
    private String atividadesDisp; // aqui é ima lista em vez de string Mudar!
    private CategoriasDest categorias;
    

    public Destino(String descricao, String imagem, String atividadesDisp, CategoriasDest categorias) {
        this.descricao = descricao;
        this.imagem = imagem;
        this.atividadesDisp = atividadesDisp;
        this.categorias = categorias;
    }


    public String getDescricao() {
        return descricao;
    }


    public String getImagem() {
        return imagem;
    }


    public String getAtividadesDisp() {
        return atividadesDisp;
    }


    public CategoriasDest getCategorias() {
        return categorias;
    }
    
    



}
