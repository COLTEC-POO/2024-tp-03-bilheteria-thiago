import java.util.Date;

public class Filme extends Evento{
    Filme(String nome, Date data, String local, float ingressoValor){
        super(nome, data, local, ingressoValor, 200);
    }
}
