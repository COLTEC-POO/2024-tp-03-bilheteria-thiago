import javax.swing.*;
import java.util.Date;

public class Concerto extends Evento {
    Concerto(String nome, Date data, String local, float ingressoValor) {
        super(nome, data, local, ingressoValor, 150);
    }

    public float calcularReceita() {
        float t = 0;
        for(Ingresso i : getIngressos()) t+=i.getValor();
        return t;
    }

    public void imprimirExtrato(){
        JOptionPane.showMessageDialog(null, "Receita: " + calcularReceita());
    }

    void comprarIngresso(){
        String[] opcoes = {"Entrada", "Meia-Entrada", "Vip"};
        int escolha  = JOptionPane.showOptionDialog(null, "Tipo de Ingresso", "Ingresso", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

        if(ingressosDisponiveis()>0){
            switch(escolha) {
                case 0:
                    addIngresso(new IngressoNormal(new Date(), getIngressoValor()));
                    break;
                case 1:
                    addIngresso(new IngressoMeia(new Date(), getIngressoValor()));
                    break;
                case 2:
                    if((numVips()+1)/getMaxIngressos()*100 <= 10){
                        addIngresso(new IngressoVip(new Date(), getIngressoValor()));
                    }else{
                        JOptionPane.showMessageDialog(null, "Não há ingressos VIP disponíveis.");
                    }
                    break;
            }
        }
    }
}