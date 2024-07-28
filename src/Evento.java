import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public abstract class Evento {
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

    public int ingressosDisponiveis(){
        return maxIngressos-ingressos.size();
    }

    public void comprarIngresso(){

    }

    public static void criarEvento(){
        Object[] opcoes = {"Filme", "Concerto", "Teatro", "Voltar"};
        int escolha = JOptionPane.showOptionDialog(null, "Qual evento você deseja criar?", "NJ",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[3]);

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

        switch (escolha){
            case 0:
                eventos.add(new Filme(nome, data, local, ingressoValor));
                break;
            case 2:
                eventos.add(new Concerto(nome, data, local, ingressoValor));
                break;
            case 3:
                eventos.add(new Teatro(nome, data, local, ingressoValor));
                break;
        }
    }

    public static void escolherEventos(){
        int opcInt = 1;
        do {
            Object[] evts = new Object[eventos.size()];

            for (int i = 0; i < eventos.size(); ++i) {
                Evento e = eventos.get(i);
                evts[i] = e.nome;
            }

            Object escolha = JOptionPane.showInputDialog(null, "Escolha um evento", "Opçao", JOptionPane.INFORMATION_MESSAGE, null, evts, evts[0]);


            for (int i = 0; i < eventos.size(); ++i) {
                if (evts[i] == escolha) {
                    opcInt = JOptionPane.showConfirmDialog(null, eventos.get(i).mostrarEvento() + '\n' + "Você gostaria de participar do evento?" + '\n', "Evento", JOptionPane.YES_NO_OPTION);
                    break;
                }
            }
        }while(opcInt!=0);
    }

    public String mostrarEvento(){
        return "Evento: "+nome+'\n'+"Data: "+data+'\n'+"Local: "+local+'\n'+"Valor do Ingresso: "+ingressoValor+'\n';
    }
}
