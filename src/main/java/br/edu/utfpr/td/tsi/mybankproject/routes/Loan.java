package br.edu.utfpr.td.tsi.mybankproject.routes;

import br.edu.utfpr.td.tsi.mybankproject.services.LoanService;
import br.edu.utfpr.td.tsi.mybankprojectclients.utils.InternalErrorException;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/loan")
public class Loan {
    private LoanService loanService;

    @PathParam("id")
    private int id;


    public Loan(LoanService loanService) {
        this.loanService = loanService;
    }

    @GET()
    @Path("/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response buscar() {
        try{
            br.edu.utfpr.tsi.td.mybankprojectloan.domains.Loan loan = loanService.buscar(id);
            return Response.ok(loan).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (NullPointerException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @POST()
    @Produces("application/json")
    @Consumes("application/json")
    public Response criar(br.edu.utfpr.tsi.td.mybankprojectloan.domains.Loan loan) {
        try{
            loan = loanService.criar(loan);
            return Response.ok(loan).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (NullPointerException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @PATCH()
    @Produces("application/json")
    @Consumes("application/json")
    public Response atualizar(br.edu.utfpr.tsi.td.mybankprojectloan.domains.Loan loan) {
        try{
            loanService.atualizar(id, loan);
            return Response.ok(loan).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (NullPointerException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @DELETE()
    @Produces("application/json")
    @Consumes("application/json")
    public Response remover() {
        try{
            loanService.remover(id);
            return Response.ok().build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (NullPointerException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET()
    @Path("/client/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response buscarPorCliente(@PathParam("id") int id) {
        try{
            var loans = loanService.buscarPorCliente(id);
            return Response.ok(loans).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (NullPointerException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET()
    @Path("/pagar/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response pagarParcela(@PathParam("id") int id) {
        try{
            loanService.pagarParcela(id);
            return Response.ok().build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (NullPointerException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET()
    @Path("/pagar/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response pagarParcela(@PathParam("id") int id, @QueryParam("qtd") int qtd) {
        try{
            loanService.pagarParcela(id, qtd);
            return Response.ok().build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (NullPointerException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET()
    @Path("/pagar/{id}/tudo")
    @Produces("application/json")
    @Consumes("application/json")
    public Response quitar(@PathParam("id") int id) {
        try{
            loanService.quitar(id);
            return Response.ok().build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (NullPointerException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET()
    @Path("/parcelas/{id}")
    @Produces("application/json")
    @Consumes("application/json")
    public Response buscarParcelasPendentes(@PathParam("id") int id) {
        try{
            var parcelas = loanService.getParcelasPendentes(id);
            return Response.ok(parcelas).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (NullPointerException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET()
    @Path("/parcelas/{id}/pago")
    @Produces("application/json")
    @Consumes("application/json")
    public Response buscarParcelasPagas(@PathParam("id") int id) {
        try{
            var parcelas = loanService.getParcelasPagas(id);
            return Response.ok(parcelas).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (NullPointerException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET()
    @Path("/parcelas/{id}/valor")
    @Produces("application/json")
    @Consumes("application/json")
    public Response buscarValorParcela(@PathParam("id") int id) {
        try{
            var valor = loanService.getValorParcela(id);
            return Response.ok(valor).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (NullPointerException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET()
    @Path("/parcelas/{id}/valor/total")
    @Produces("application/json")
    @Consumes("application/json")
    public Response buscarValorTotal(@PathParam("id") int id) {
        try{
            var valor = loanService.getValorTotal(id);
            return Response.ok(valor).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (NullPointerException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET()
    @Path("/parcelas/{id}/valor/pago")
    @Produces("application/json")
    @Consumes("application/json")
    public Response buscarValorPago(@PathParam("id") int id) {
        try{
            var valor = loanService.getValorPago(id);
            return Response.ok(valor).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (NullPointerException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }

    @GET()
    @Path("/parcelas/{id}/valor/pendente")
    @Produces("application/json")
    @Consumes("application/json")
    public Response buscarValorPendente(@PathParam("id") int id) {
        try{
            var valor = loanService.getValorPendente(id);
            return Response.ok(valor).build();
        }catch (InternalErrorException e){
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (NullPointerException e){
            return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
        }catch (IllegalArgumentException e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }


}
