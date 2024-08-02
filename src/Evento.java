import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Evento implements receita{
    private String nome;
    private Date data;
    private String local;
    private float ingressoValor;
    private int maxIngressos;
    private ArrayList<Ingresso> ingressos;
    private static ArrayList<Evento> eventos = new ArrayList<Evento>();

    Evento(String nome, Date data, String local, float ingressoValor, int maxIngressos){
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.ingressoValor = ingressoValor;
        this.maxIngressos = maxIngressos;
        this.ingressos = new ArrayList<Ingresso>();
    }

    public void addIngresso(Ingresso ingresso){
        ingressos.add(ingresso);
    }

    public ArrayList<Ingresso> getIngressos() {
        return ingressos;
    }

    public float getIngressoValor() {
        return ingressoValor;
    }

    public int getMaxIngressos() {
        return maxIngressos;
    }

    public int ingressosDisponiveis(){
        return maxIngressos-ingressos.size();
    }

    public int numEntradas(){
        int t = 0;
        for(Ingresso i : ingressos) t+=(i instanceof IngressoNormal ? 1 : 0);
        return t;
    }

    public int numMeias(){
        int t = 0;
        for(Ingresso i : ingressos) t+=(i instanceof IngressoNormal ? 1 : 0);
        return t;
    }

    public int numVips(){
        int t = 0;
        for(Ingresso i : ingressos) t+=(i instanceof IngressoNormal ? 1 : 0);
        return t;
    }

    public static ArrayList<Evento> getEventos() {
        return eventos;
    }

    public static void criarEvento(String nome, String dataAux, String local, float ingressoValor, int tipo){
        Date data = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

        try {
            data = formato.parse(dataAux);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de data invalido!");
        }

        switch(tipo){
                case 0:
                    eventos.add(new Filme(nome, data, local, ingressoValor));
                    break;
            case 1:
                eventos.add(new Concerto(nome, data, local, ingressoValor));
                break;
            case 2:
                eventos.add(new Teatro(nome, data, local, ingressoValor));
                break;
            }
    }

    public static void criarEvento(){
        Object[] opcoes = {"Filme", "Concerto", "Teatro", "Voltar"};
        int escolha = JOptionPane.showOptionDialog(null, "Qual evento você deseja criar?", "NJ",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[3]);

        if(escolha!=3) {
            String nome = JOptionPane.showInputDialog("Nome do Evento: ");
            String dataAux = JOptionPane.showInputDialog("Data do Evento: ");
            Date data = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

            try {
                data = formato.parse(dataAux);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "Formato de data invalido!");
            }

            String local = JOptionPane.showInputDialog("Local do Evento: ");
            String ingressoValorAux = JOptionPane.showInputDialog("Preço do Ingresso: ");
            float ingressoValor = Float.parseFloat(ingressoValorAux);

            switch (escolha) {
                case 0:
                    eventos.add(new Filme(nome, data, local, ingressoValor));
                    break;
                case 1:
                    eventos.add(new Concerto(nome, data, local, ingressoValor));
                    break;
                case 2:
                    eventos.add(new Teatro(nome, data, local, ingressoValor));
                    break;
            }
        }
    }

    public static Evento escolherEventos(){
        int opcInt = 1;
        if(eventos.size()>0) {
            Object[] evts = new Object[eventos.size()];

            for (int i = 0; i < eventos.size(); ++i) {
                Evento e = eventos.get(i);
                evts[i] = e.nome;
            }

            Object escolha = JOptionPane.showInputDialog(null, "Escolha um evento", "Opçao", JOptionPane.INFORMATION_MESSAGE, null, evts, evts[0]);

            for (int i = 0; i < eventos.size(); ++i) {
                if (evts[i] == escolha) {
                    return eventos.get(i);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Não há eventos disponíveis.");
        }
            return null;
    }

    public String toString(){
        return "Evento: "+nome+'\n'+"Data: "+data+'\n'+"Local: "+local+'\n'+"Valor do Ingresso: R$"+String.format("%.2f", ingressoValor)+'\n';
    }

    abstract void comprarIngresso();
}
