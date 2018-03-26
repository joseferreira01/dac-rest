package ifpb.ads.dac.service;

import ifpb.ads.dac.domain.Jogador;
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
public class ServiceJogador implements Service<Jogador> {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void add(Jogador jogador) {
        em.persist(jogador);
    }

    @Override
    public List<Jogador> buscarTodos() {
        return em.createQuery("FROM Jogador j", Jogador.class).getResultList();
    }

    @Override
    public Jogador buscarPorId(int id) {
        return em.find(Jogador.class, id);
    }

    @Override
    public void remover(int id) {
        Jogador find = em.find(Jogador.class, id);
        em.remove(find);
    }

    @Override
    public void merge(int id, Jogador jogador) {
        jogador.setId(id);
        em.merge(jogador);
        
//        Jogador find = em.find(Jogador.class, id);
//        jogador.
    }

}
