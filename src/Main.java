package src;

import jdk.jfr.Event;

import javax.swing.*;
import java.util.ArrayList;

public class Main {



    public static void main(String[] args)
    {
        int escolha = 4;

        for(int i = 0; i < 5; ++i){
            Evento.criarEvento("a", "12/12/1222", "a", 10, 0);
        }

        do {
            Object[] opcoes = {"Criar um evento", "Participar de um evento", "Exibir Eventos", "Exibir Receita", "Exibir Ingressos", "Sair"};
            escolha = JOptionPane.showOptionDialog(null, "O que deseja fazer?", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[5]);

            Evento evento;
            switch(escolha){
                case 0:
                    Evento.criarEvento();
                    break;
                case 1:
                    evento = Evento.escolherEventos();
                    int acao = 1;
                    if(evento!=null) acao = JOptionPane.showConfirmDialog(null, "Você gostaria de participar do evento: "+'\n'+evento.toString());
                    if(acao==0) evento.comprarIngresso();
                    break;
                case 2:
                    if(Evento.getEventos().size() > 0) {
                        String aux = new String();
                        for (Evento e : Evento.getEventos()) {
                            aux = aux.concat(e.toString() + '\n');
                        }
                        JOptionPane.showMessageDialog(null, aux);
                    }else{
                        JOptionPane.showMessageDialog(null, "Não há eventos disponíveis.");
                    }
                    break;
                case 3:
                    evento = Evento.escolherEventos();
                    evento.imprimirExtrato();
                    break;
                case 4:
                    evento = Evento.escolherEventos();
                    evento.mostrarIngressos();
                    break;
            }
        }while(escolha!=5);
    }
}