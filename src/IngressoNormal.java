package src;

import java.util.Date;

public class IngressoNormal extends Ingresso{
    IngressoNormal(Date data, float valor){
            super(data, valor);
    }

    public float calcularReceita() {
        return 0;
    }

    public void imprimirExtrato() {

    }
}
