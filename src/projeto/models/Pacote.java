package projeto.models;

public class Pacote {
    private String nome;
    private int quantidadeDisponivel;
    private String local;
    private String dataIda;
    private String dataVolta;
    private double preco;
    private int quantidadeMaximaPessoas;

    // Construtor
    public Pacote(String nome, int quantidadeDisponivel, String local, String dataIda, String dataVolta, double preco,
            int quantidadeMaximaPessoas) {
        this.nome = nome;
        this.quantidadeDisponivel = quantidadeDisponivel;
        this.local = local;
        this.dataIda = dataIda;
        this.dataVolta = dataVolta;
        this.preco = preco;
        this.quantidadeMaximaPessoas = quantidadeMaximaPessoas;
    }

    // Métodos de acesso (getters e setters)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeDisponivel() {
        return quantidadeDisponivel;
    }

    public void setQuantidadeDisponivel(int quantidadeDisponivel) {
        this.quantidadeDisponivel = quantidadeDisponivel;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
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

    public int getQuantidadeMaximaPessoas() {
        return quantidadeMaximaPessoas;
    }

    public void setQuantidadeMaximaPessoas(int quantidadeMaximaPessoas) {
        this.quantidadeMaximaPessoas = quantidadeMaximaPessoas;
    }

    // Exibindi informações do pacote de viagem
    public void exibirInformacoes() {
        System.out.println("Nome do Pacote: " + nome);
        System.out.println("Quantidade Disponível: " + quantidadeDisponivel);
        System.out.println("Local: " + local);
        System.out.println("Data de Ida: " + dataIda);
        System.out.println("Data de Volta: " + dataVolta);
        System.out.println("Preço: " + preco);
        System.out.println("Quantidade Máxima de Pessoas: " + quantidadeMaximaPessoas);
    }
}
