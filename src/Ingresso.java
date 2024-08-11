

import javax.swing.*;
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

    public float calcularReceita() {
        return valor;
    }

    public void imprimirExtrato() {
        JOptionPane.showMessageDialog(null, valor);
    }

    public String toString(){
        return "Data: "+data+'\n'+"Valor: R$ "+String.format("%.2f", valor)+'\n';
    }


}
