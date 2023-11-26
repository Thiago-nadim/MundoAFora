package models;

public class Pacote {

    public enum CategoriasPct {
        AVENTURA, CULTURA, RELAXAMENTO,FAMILIA,NATUREZA
    }

    private String nomePct;
    private boolean disponivel;
    private int qtdDispPct;
    private String destino;
    private String dataIda;
    private String dataVolta;
    private double preco;
    private int qtdMaxPessoas;
    private int idPacote;
    private CategoriasPct categoria;

    // Construtor
    public Pacote(String nomePct, boolean disponivel, int qtdDispPct, String destino, String dataIda, String dataVolta,
            double preco,int qtdMaxPessoas, int idPacote, CategoriasPct categoria) {
        this.nomePct = nomePct;
        this.qtdDispPct = qtdDispPct;
        this.disponivel = disponivel;
        this.destino = destino;
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
        this.preco = preco;
        this.qtdMaxPessoas = qtdMaxPessoas;
        this.idPacote = idPacote;
        this.categoria = categoria;
    }

    @Override
    public String toString() {

        return "------------------------------------------------ \n"
                +"Nome do pacote:" + this.nomePct + "\n" +
                "Quantidade disponíveis:" + this.qtdDispPct + "\n" +
                "Destino:" + this.destino + "\n" +
                "Data de ida:" + this.dataIda + "\n" +
                "Data de volta:" + this.dataVolta + "\n" +
                "Preço:" + this.preco + "\n" +
                "Quantidade máxima de pessoas:" + this.qtdMaxPessoas + "\n" +
                "Id do pacote:" + this.idPacote + "\n" +
                "Categoria do pacote:" + this.categoria + "\n";
    }

    // Métodos de acesso (getters e setters)
    public String getNome() {
        return nomePct;
    }

    public void setNome(String nomePct) {
        this.nomePct = nomePct;
    }

    public int getQuantidadeDisponivel() {
        return qtdDispPct;
    }

    public void setQuantidadeDisponivel(int qtdDispPct) {
        this.qtdDispPct = qtdDispPct;
    }

    public String getLocal() {
        return destino;
    }

    public void setLocal(String local) {
        this.destino = local;
    }

    public String getDataIda() {
        return dataIda;
    }

    public void setDataIda(String dataIda) {
        this.dataIda = dataIda;
    }

    public String getDataVolta() {
        return dataVolta;
    }

    public void setDataVolta(String dataVolta) {
        this.dataVolta = dataVolta;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getqtdMaxPessoas() {
        return qtdMaxPessoas;
    }

    public void setqtdMaxPessoas(int qtdMaxPessoas) {
        this.qtdMaxPessoas = qtdMaxPessoas;
    }

    public int getIdPacote() {
        return idPacote;
    }

    public CategoriasPct getCategoria() {
        return categoria;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // Método para representar o objeto em formato de string
    public String toFileString() {
        String disponibilidade = disponivel ? "true" : "false";
        String categoriaString = categoria.name();
        return String.format("%s,%d,%s,%s,%s,%f,%d,%d,%s",
                nomePct, qtdDispPct, destino, dataIda, dataVolta, preco, qtdMaxPessoas, idPacote, categoria);
    }

}