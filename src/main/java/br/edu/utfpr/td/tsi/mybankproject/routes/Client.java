package br.edu.utfpr.td.tsi.mybankproject.routes;

import br.edu.utfpr.td.tsi.mybankproject.services.ClientService;
import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaFisica;
import br.edu.utfpr.td.tsi.mybankprojectclients.domains.PessoaJuridica;
import br.edu.utfpr.td.tsi.mybankprojectclients.utils.InternalErrorException;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/client")
public class Client {
    private ClientService clientService;
    @PathParam("id")
    private int id;

    @PathParam("name")
    private String name;

    @PathParam("cpf")
    private String cpf;

    @PathParam("cnpj")
    private String cnpj;

    public Client() {
        this.clientService = new ClientService();
    }

    //generate routes;
    @GET()
    @Produces("application/json")
    @Consumes("application/json")
    public Response index() throws InternalErrorException {

        try{
            List<PessoaFisica> res = this.clientService.listarFisica();
            return Response.ok(res).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST()
    @Produces("application/json")
    @Consumes("application/json")
    public Response create(PessoaFisica pessoa) {
        try{
            PessoaFisica p = this.clientService.criar(pessoa);
            return Response.ok(p).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PATCH()
    @Path("/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response edit(PessoaFisica pessoa) {
        try{
            this.clientService.atualizar(id, pessoa);
            return Response.status(Response.Status.NO_CONTENT).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }catch (NullPointerException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET()
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response show() {
        try{
            List<PessoaFisica> p = this.clientService.buscarFisica(id);
            if(p.isEmpty()){
                return Response.status(Response.Status.NOT_FOUND).entity("Cliente não encontrado").build();
            }
            PessoaFisica pessoa = p.get(0);
            return Response.ok(pessoa).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }catch (NullPointerException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET()
    @Path("/nome/{name}")
    public Response showByName() {
        try{
            List<PessoaFisica> p = this.clientService.buscarFisica(name);
            if(p.isEmpty()){
                return Response.status(Response.Status.NOT_FOUND).entity("Cliente não encontrado").build();
            }
            return Response.ok(p).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }catch (NullPointerException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET()
    @Path("/cpf/{cpf}")
    public Response showByCpf() {
        try{
            List<PessoaFisica> p = this.clientService.buscarFisicaCPF(cpf);
            if(p.isEmpty()){
                return Response.status(Response.Status.NOT_FOUND).entity("Cliente não encontrado").build();
            }
            return Response.ok(p.get(0)).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }catch (NullPointerException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @DELETE()
    @Path("/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response delete() {
        try{
            this.clientService.deletarFisica(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }catch (NullPointerException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    //Pessoa juridica

    @GET()
    @Path("/juridica")
    @Produces("application/json")
    @Consumes("application/json")
    public Response indexJuridica() throws InternalErrorException {

        try{
            List<PessoaJuridica> res = this.clientService.listarJuridica();
            return Response.ok(res).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST()
    @Path("/juridica")
    @Produces("application/json")
    @Consumes("application/json")
    public Response createJuridica(PessoaJuridica pessoa) {
        try{
            PessoaJuridica p = this.clientService.criar(pessoa);
            return Response.ok(p).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PATCH()
    @Path("/juridica/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response updateJuridica(PessoaJuridica pessoa) {
        try{
            this.clientService.atualizar(id, pessoa);
            return Response.status(Response.Status.NO_CONTENT).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }catch (NullPointerException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET()
    @Path("/juridica/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response showJuridica() {
        try{
            List<PessoaJuridica> p = this.clientService.buscarJuridica(id);
            if(p.isEmpty()){
                return Response.status(Response.Status.NOT_FOUND).entity("Cliente não encontrado").build();
            }
            PessoaJuridica pessoa = p.get(0);
            return Response.ok(pessoa).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }catch (NullPointerException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @GET()
    @Path("/juridica/cnpj/{cnpj}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response showByCnpj() {
        try{
            List<PessoaJuridica> p = (List<PessoaJuridica>) this.clientService.buscarJuridicaCNPJ(cnpj);
            if(p.isEmpty()){
                return Response.status(Response.Status.NOT_FOUND).entity("Cliente não encontrado").build();
            }
            return Response.ok(p.get(0)).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }catch (NullPointerException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

    @DELETE()
    @Path("/juridica/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response deleteJuridica() {
        try{
            this.clientService.deletarJuridica(id);
            return Response.status(Response.Status.NO_CONTENT).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }catch (NullPointerException e) {
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }
    }

}
