

import sun.java2d.pipe.SpanShapeRenderer;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public abstract class Evento implements receita {
    private String nome;
    private Date data;
    private Date hora;
    private String local;
    private float ingressoValor;
    private int maxIngressos;
    private ArrayList<Ingresso> ingressos;
    private static ArrayList<Evento> eventos = new ArrayList<Evento>();

    Evento(String nome, Date data, Date hora, String local, float ingressoValor, int maxIngressos){
        this.nome = nome;
        this.data = data;
        this.hora = hora;
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

    public static void criarEvento(String nome, String dataAux, String horaAux, String local, float ingressoValor, int tipo){
        Date data = new Date();
        Date hora = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHoras = new SimpleDateFormat("HH:mm:ss");

        try {
            data = formato.parse(dataAux);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de data invalido!");
        }

        try {
            hora = formatoHoras.parse(horaAux);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Formato de data invalido!");
        }

        switch(tipo){
                case 0:
                    eventos.add(new Filme(nome, data, hora, local, ingressoValor));
                    break;
            case 1:
                eventos.add(new Concerto(nome, data, hora,local, ingressoValor));
                break;
            case 2:
                eventos.add(new Teatro(nome, data, hora, local, ingressoValor));
                break;
            }
    }

    public static void criarEvento(){
        Object[] opcoes = {"Filme", "Concerto", "Teatro", "Voltar"};
        int escolha = JOptionPane.showOptionDialog(null, "Qual evento você deseja criar?", "Evento",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[3]);

        if(escolha!=3) {
            String nome = JOptionPane.showInputDialog("Nome do Evento: ");
            if(nome==null) return;
            Date data = new Date();
            Date hora = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat formatoHoras = new SimpleDateFormat("HH:mm:ss");
            boolean dataIncorreta = false;
            do {
                try {
                    String dataAux = JOptionPane.showInputDialog("Data do Evento (dd/MM/yyyy): ");
                    System.out.println(dataAux);
                    if(dataAux!=null) data = formato.parse(dataAux);
                    else return;
                    dataIncorreta = false;
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(null, "Formato de data invalido!");
                    dataIncorreta = true;
                }
            }while(dataIncorreta);

            boolean horaIncorreta = false;
            do {
                String horaAux = JOptionPane.showInputDialog("Hora do Evento (HH:mm:ss): ");

                try {
                    if(horaAux!=null) hora = formatoHoras.parse(horaAux);
                    else return;
                    horaIncorreta = false;
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(null, "Formato de data invalido!");
                    horaIncorreta = true;
                }
            }while(horaIncorreta);

            String local = JOptionPane.showInputDialog("Local do Evento: ");
            if(local==null) return;
            String ingressoValorAux = JOptionPane.showInputDialog("Preço do Ingresso (Ex.: 15.50): ");
            if(ingressoValorAux==null) return;
            float ingressoValor = Float.parseFloat(ingressoValorAux);

            switch (escolha) {
                case 0:
                    eventos.add(new Filme(nome, data, hora, local, ingressoValor));
                    break;
                case 1:
                    eventos.add(new Concerto(nome, data, hora, local, ingressoValor));
                    break;
                case 2:
                    eventos.add(new Teatro(nome, data, hora, local, ingressoValor));
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

            Object escolha = JOptionPane.showInputDialog(null, "Escolha um evento", "Evento", JOptionPane.INFORMATION_MESSAGE, null, evts, evts[0]);

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
        String classe = this.getClass().toString();
        classe = classe.substring(5, classe.length());
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHoras = new SimpleDateFormat("HH:mm:ss");
        return "Evento: "+nome+'\n'+"Tipo: "+classe+'\n'+"Data: "+ formato.format(data)+'\n'+"Hora: "+formatoHoras.format(hora)+'\n'+"Local: "+local+'\n'+"Nº de Ingressos Disponíveis: "+ingressosDisponiveis()+'\n'+"Nº de Ingressos Vendidos: "+(maxIngressos-ingressosDisponiveis())+'\n'+"Valor do Ingresso: R$"+String.format("%.2f", ingressoValor)+'\n';
    }

    abstract void comprarIngresso();

    public void mostrarIngressos(){
        int t = 0;
        String aux = new String();
        for (Ingresso i : ingressos) {
            ++t;
            aux = aux.concat(i.toString() + '\n');
        }
        if(t > 0) {
            JOptionPane.showMessageDialog(null, aux);
        }else{
            JOptionPane.showMessageDialog(null, "Não há ingressos.");
        }
    }

    public void imprimirExtrato() {
        JOptionPane.showMessageDialog(null, "R$: "+String.format("%.2f", calcularReceita()));
    }
}
