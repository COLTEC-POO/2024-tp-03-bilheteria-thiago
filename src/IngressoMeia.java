package src;

import java.util.Date;

public class IngressoMeia extends Ingresso{
    IngressoMeia(Date data, float valor){
        super(data, valor/2);
    }

    public float calcularReceita() {
        return 0;
    }

    public void imprimirExtrato() {

    }
}
