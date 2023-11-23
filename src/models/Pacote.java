package models;


public class Pacote {

    private enum CategoriasPct{
    AVENTURA,CULTURA,RELAXAMENTO
    }

    private String nomePct;
    private int qtdDispPct;
    private String destino;
    private String dataIda;
    private String dataVolta;
    private double preco;
    private int qtdMaxPessoas;
    private int idPacote;
    private String categoria;

   

    

    // Construtor
    public Pacote(String nomePct, int qtdDispPct, String destino, String dataIda, String dataVolta, double preco,
            int qtdMaxPessoas, int idPacote, String categorias) {
        this.nomePct = nomePct;
        this.qtdDispPct = qtdDispPct;
        this.destino = destino;
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
        this.preco = preco;
        this.qtdMaxPessoas = qtdMaxPessoas;
        this.idPacote=idPacote;
        this.categoria=categorias;
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
    public String getCategoria() {
        return categoria;
    }

    // Exibindi informações do pacote de viagem
    public void exibirInformacoes() {
        System.out.println("Nome do Pacote: " + nomePct);
        System.out.println("Quantidade Disponível: " + qtdDispPct);
        System.out.println("Local: " + destino);
        System.out.println("Data de Ida: " + dataIda);
        System.out.println("Data de Volta: " + dataVolta);
        System.out.println("Preço: " + preco);
        System.out.println("Quantidade Máxima de Pessoas: " + qtdMaxPessoas);
        System.out.println("Categoria do pacote" + categoria);
        System.out.println("Id do pacote:" + idPacote);
    }
}