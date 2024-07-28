import java.util.Date;

public class Concerto extends Evento {
    Concerto(String nome, Date data, String local, float ingressoValor) {
        super(nome, data, local, ingressoValor, 150);
    }
}