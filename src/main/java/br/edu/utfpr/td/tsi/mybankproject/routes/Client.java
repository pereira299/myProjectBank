package br.edu.utfpr.td.tsi.mybankproject.routes;

import br.edu.utfpr.td.tsi.mybankproject.services.ClientService;
import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaFisica;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;

@Path("/client")
public class Client {
    private ClientService clientService;
    @PathParam("id")
    private int id;

    public Client() {
        this.clientService = new ClientService();
    }

    //generate routes;
    @GET()
    @Produces("application/json")
    @Consumes("application/json")
    public void index() {
        this.clientService.listarFisica();
    }

    @POST()
    @Produces("application/json")
    @Consumes("application/json")
    public void create(PessoaFisica pessoa) {
        this.clientService.criar(pessoa);
    }

    @PUT()
    @Path("/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public void edit(PessoaFisica pessoa) {
        this.clientService.atualizar(id, pessoa);
    }

    @GET()
    @Path("/{id}")
    public void show() {
        this.clientService.buscarFisica(id);
    }
}
