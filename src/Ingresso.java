

import javax.swing.*;
import java.text.SimpleDateFormat;
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
        String classe = this.getClass().toString();
        classe = classe.substring(5, classe.length());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        return "Tipo: "+classe+'\n'+"Data: "+formato.format(data)+'\n'+"Valor: R$ "+String.format("%.2f", valor)+'\n';
    }


}
