import java.util.Date;

public abstract class Ingresso {
    private Date data;
    private float valor;

    Ingresso(Date data, float valor){
        this.data = data;
        this.valor = valor;
    }
}
