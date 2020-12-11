package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.Usuario;
import br.ufscar.dc.dsw.Locacao;
import br.ufscar.dc.dsw.dao.UsuarioDAO;

@WebServlet(urlPatterns = {"/clientes/*" })
public class ClienteController extends HttpServlet {

    private static final long serialVersionUID = 1L; 
    private UsuarioDAO dao;

    @Override
    public void init() {
        dao = new UsuarioDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        String action = request.getPathInfo();
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "/listaadmin":
                    lista_admin(request, response);
                case "/cadastro":
                	apresentaFormCadastro(request, response);
                    break;
                case "/edicao":
                	apresentaFormEdicao(request, response);
                	break;
                case "/atualizacao":
                	atualize(request, response);
                	break;
                case "/insercao":
                	insere(request, response);
                    break;
                case "/remocao":
                	remove(request, response);
                    break;
                case "/locacoes":
                	lista_locacoes(request, response);
                    break;
                case "/cadastrolocacao":
                	apresentaFormCadastroLocacao(request, response);
                    break;
                case "/insercaoLocacao":
                	insere_locacao(request, response);
                    break;
                case "/edicaolocacao":
                	apresentaFormEdicaoLocacao(request, response);
                    break;
                case "/atualizacaoLocacao":
                	atualize_locacao(request, response);
                	break;
                case "/remocaolocacao":
                	remove_locacao(request, response);
                    break;
                default:
                	lista_admin(request, response);
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }

    }

    
    private void lista_admin(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
        List<Usuario> listaClientes = dao.getAllClientes();
        request.setAttribute("listaClientes", listaClientes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/listaadminCliente.jsp");
        dispatcher.forward(request, response);
    }
    
    private Map<Long, String> getClientes() {
        Map <Long,String> clientes = new HashMap<>();
        for (Usuario cliente: new UsuarioDAO().getAllClientes()) {
            clientes.put(cliente.getId(), cliente.getNome());
        }
        return clientes;
    }

    private Map<Long, String> getLocacoes(String cliente) {
        Map <Long,String> locacoes = new HashMap<>();
        for (Locacao locacao: new UsuarioDAO().getAllLocacoes(cliente)) {
            locacoes.put(locacao.getId(), locacao.getLocadora());
        }
        return locacoes;
    }
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("clientes", getClientes());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormCadastroLocacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Usuario usuario = (Usuario)request.getSession().getAttribute("usuarioLogado");
        String cliente = usuario.getLogin();
        request.setAttribute("locacoes", getLocacoes(cliente));
        List<Usuario> listaLocadoras = dao.getAllLocadoras();
        request.setAttribute("listaLocadoras", listaLocadoras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/formularioLocacoes.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String papel = "CLIENTE";
        
        Usuario cliente = new Usuario(nome, email, senha, papel);
        dao.insert(cliente);
        response.sendRedirect("listaadmin");
    }

    private void insere_locacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        Usuario usuario = (Usuario)request.getSession().getAttribute("usuarioLogado");
        String cliente = usuario.getLogin();
        String locadora = request.getParameter("locadora");
        String data = request.getParameter("data");
        
        Locacao locacao = new Locacao(cliente, locadora, data);
        dao.insertLocacao(locacao);
        response.sendRedirect("locacoes");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String papel = request.getParameter("papel");
        
        Usuario cliente = new Usuario(id, nome, email, senha, papel);
        dao.update(cliente);
        response.sendRedirect("listaadmin");
    }

    private void atualize_locacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));
        Usuario usuario = (Usuario)request.getSession().getAttribute("usuarioLogado");
        String cliente = usuario.getLogin();
        String locadora = request.getParameter("locadora");
        String data = request.getParameter("data");
        
        Locacao locacao = new Locacao(id, cliente, locadora, data);
        dao.updateLocacao(locacao);
        response.sendRedirect("locacoes");
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Usuario cliente = dao.getbyID(id);
        request.setAttribute("cliente", cliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicaoLocacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Locacao locacao = dao.getLocacaoByID(id);
        request.setAttribute("locacao", locacao);
        List<Usuario> listaLocadoras = dao.getAllLocadoras();
        request.setAttribute("listaLocadoras", listaLocadoras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/formularioLocacoes.jsp");
        dispatcher.forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Usuario cliente = new Usuario(id);
        dao.delete(cliente);
        response.sendRedirect("listaadmin");
    }

    private void remove_locacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Locacao locacao = new Locacao(id);
        dao.deleteLocacao(locacao);
        response.sendRedirect("locacoes");
    }

    private void lista_locacoes(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {

        Usuario usuario = (Usuario)request.getSession().getAttribute("usuarioLogado");
        String login = usuario.getLogin();
        List<Locacao> listaLocacoes = dao.getAllLocacoes(login);
        request.setAttribute("listaLocacoes", listaLocacoes);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/listaLocacoes.jsp");
        dispatcher.forward(request, response);
    }
}