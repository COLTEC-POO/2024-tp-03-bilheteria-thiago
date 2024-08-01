import java.util.Date;

public abstract class Ingresso implements receita{
    private Date data;
    private float valor;

    Ingresso(Date data, float valor){
        this.data = data;
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }
}
