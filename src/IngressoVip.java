import java.util.Date;

public class IngressoVip extends Ingresso{
    IngressoVip(Date data, float valor){
        super(data, valor*2);
    }

    public float calcularReceita() {
        return 0;
    }

    public void imprimirExtrato() {

    }
}
