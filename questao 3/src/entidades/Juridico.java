package entidades;


public class Juridico extends Contribuintes{
    private Integer numeroEmpregados;

    public Juridico(String nome, Double rendimentoAnual, Integer numeroEmpregados) {
        super(nome, rendimentoAnual);
        this.numeroEmpregados = numeroEmpregados;
    }

    public Integer getNumeroEmpregados() {
        return numeroEmpregados;
    }

    public void setNumeroEmpregados(Integer numeroEmpregados) {
        this.numeroEmpregados = numeroEmpregados;
    }

    @Override
    public Double imposto() {
        if (getNumeroEmpregados() > 10){
            return getRendimentoAnual() * 0.14;
        } else {
            return getRendimentoAnual() * 0.16;
        }
    }
}
