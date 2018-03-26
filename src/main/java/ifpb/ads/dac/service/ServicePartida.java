package ifpb.ads.dac.service;

import ifpb.ads.dac.domain.Jogador;
import ifpb.ads.dac.domain.Partida;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 26/03/2018, 09:54:41
 */
@Stateless
public class ServicePartida implements Service<Partida> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Partida partida) {
        em.persist(partida);
    }

    @Override
    public List<Partida> buscarTodos() {
        return em.createQuery("FROM Partida p", Partida.class).getResultList();
    }

    @Override
    public Partida buscarPorId(int codigo) {
        return em.find(Partida.class, codigo);
    }

    @Override
    public void remover(int id) {
        Partida find = em.find(Partida.class, id);
        em.remove(find);
    }

    @Override
    public void merge(int codigo, Partida partida) {
        partida.setCodigo(codigo);
        em.merge(partida);
        
//        Jogador find = em.find(Jogador.class, id);
//        jogador.
    }

}
