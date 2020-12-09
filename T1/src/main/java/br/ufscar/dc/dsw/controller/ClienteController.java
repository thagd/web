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
import br.ufscar.dc.dsw.dao.UsuarioDAO;
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
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("clientes", getClientes());
        RequestDispatcher dispatcher = request.getRequestDispatcher("cliente/formulario.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String papel = request.getParameter("papel");
        
        Usuario cliente = new Usuario(nome, email, senha, papel);
        dao.insert(cliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listaadmin");
        dispatcher.forward(request, response);
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

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Usuario cliente = dao.getbyID(id);
        request.setAttribute("cliente", cliente);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cliente/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Usuario cliente = new Usuario(id);
        dao.delete(cliente);
        response.sendRedirect("listaadmin");
    }
}