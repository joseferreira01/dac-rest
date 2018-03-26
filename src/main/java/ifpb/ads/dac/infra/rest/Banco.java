package ifpb.ads.dac.infra.rest;

import ifpb.ads.dac.domain.Jogador;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 26/03/2018, 09:16:22
 */
@Singleton
public class Banco {

    private List<Jogador> jogadores = new ArrayList<>();
    
    private AtomicInteger chave = new AtomicInteger(3);

    @PostConstruct
    public void init() {
        Jogador jogador = new Jogador(1, "Chaves", "sffsfs");
        Jogador segundo = new Jogador(2, "Kiko", "asfadsfa");

        jogadores.add(jogador);
        jogadores.add(segundo);
    }

    public void add(Jogador jogador) {
        jogador.setId(chave.getAndIncrement());
        this.jogadores.add(jogador);
    }

    public List<Jogador> jogadores() {
        return this.jogadores;
    }

    public Jogador jogador(int id) {
        return this.jogadores.stream()
                .filter(j -> j.getId() == id)
                .findFirst()
                .orElse(new Jogador(-1, "fake", "fake"));
    }

    public void remover(int id) {
        this.jogadores.removeIf(j -> j.getId() == id);
    }
}
