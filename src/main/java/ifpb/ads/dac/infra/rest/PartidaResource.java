package ifpb.ads.dac.infra.rest;

import ifpb.ads.dac.domain.Jogador;
import ifpb.ads.dac.domain.Partida;
import ifpb.ads.dac.service.ServiceJogador;
import ifpb.ads.dac.service.ServicePartida;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Ricardo Job
 * @mail ricardo.job@ifpb.edu.br
 * @since 26/03/2018, 09:02:24
 */
// .../dac-jogador/api/jogador
@Path("partida")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Stateless
public class PartidaResource {

    @Inject
    private ServicePartida service;

    @GET
//    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public Response recuperarTodos() {
        List<Partida> partidas = service.buscarTodos();

        GenericEntity<List<Partida>> entity
                = new GenericEntity<List<Partida>>(partidas) {
        };

        return Response.ok()
                .entity(entity)
                .build();
    }

    // .../dac-jogador/api/jogador/{id}
    @GET
    @Path("{codigo}")
    public Response recuperarJogador(@PathParam("codigo") int codigo) {
        Partida partida = service.buscarPorId(codigo);
        return Response.ok()
                .entity(partida)
                .build();
    }

    // .../dac-jogador/api/jogador/{id}
    @DELETE
    @Path("{codigo}")
    public Response removerJogador(@PathParam("codigo") int codigo) {
        service.remover(codigo);
        return Response.ok() // 200
                .build();
    }

    @POST
    public Response adicionarJogador(Partida partida) {
        service.add(partida);
        return Response.ok()
                .entity(partida)
                .build();
    }

    @PUT
    @Path("{codigo}")
    public Response atualizarJogador(
            @PathParam("codigo") int codigo,
            Partida partida) {
        
        service.merge(codigo,partida);
        return Response.ok()
                .entity(partida)
                .build();
    }
}
