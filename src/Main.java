import javax.swing.*;

public class Main {



    public static void main(String[] args)
    {
        int escolha = 4;

        do {
            Object[] opcoes = {"Criar um evento", "Participar de um evento", "Exibir receita", "Exibir detalhes", "Sair"};
            escolha = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "NJ",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[4]);
            switch(escolha){
                case 0:
                    Evento.criarEvento();
                    break;
                case 1:
                    Evento evento = Evento.escolherEventos();
                    int acao = 1;
                    if(evento!=null) acao = JOptionPane.showConfirmDialog(null, "Você gostaria de participar do evento: "+'\n'+evento.mostrarEvento());
                    if(acao==0) evento.comprarIngresso();


                    break;
            }
        }while(escolha!=4);
    }
}