package entidades;

public class ProdutoImportado extends Produto {
    private double taxa;

    public ProdutoImportado(String nome, Double preco, double taxa) {
        super(nome, preco);
        this.taxa = taxa;
    }

    public double getTaxa() {
        return taxa;
    }

    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }

    public Double precoTotal() {
        return getPreco() * taxa;
    }

    @Override
    public String etiqueta() {
        return String.format(getNome() + " R$" + String.format("%.2f", precoTotal()) + " (Taxa alfandegária: R$" + String.format("%.2f", taxa) + ")");
    }
}
