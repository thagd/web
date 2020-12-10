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

@WebServlet(name = "Index", urlPatterns = { "/index.jsp", "/locadoras/*" })
public class LocadoraController extends HttpServlet {

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
                case "/lista":
                    lista(request, response);
                    break;
                case "/listaadmin":
                    lista_admin(request, response);
                case "/listaCidade":
                    buscaCidade(request, response);
                    break;
                case "/cadastro":
                	apresentaFormCadastro(request, response);
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
                case "/edicao":
                	apresentaFormEdicao(request, response);
                default:
                	lista(request, response);
            }
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }

	}

    private void buscaCidade(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	String cidade = request.getParameter("cidade");	
    	List<Usuario> listaLocadoras = dao.getLocadoraByCidade(cidade);
        request.setAttribute("listaLocadoras", listaLocadoras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/locadora/listaCidade.jsp");
        dispatcher.forward(request, response);
	}

	private void lista(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
        List<Usuario> listaLocadoras = dao.getAllLocadoras();
        request.setAttribute("listaLocadoras", listaLocadoras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/locadora/lista.jsp");
        dispatcher.forward(request, response);
    }
    
    private void lista_admin(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
        List<Usuario> listaLocadoras = dao.getAllLocadoras();
        request.setAttribute("listaLocadoras", listaLocadoras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/locadora/listaadmin.jsp");
        dispatcher.forward(request, response);
    }
    
    private Map<Long, String> getLocadoras() {
        Map <Long,String> locadoras = new HashMap<>();
        for (Usuario locadora: new UsuarioDAO().getAllLocadoras()) {
            locadoras.put(locadora.getId(), locadora.getNome());
        }
        return locadoras;
    }
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("locadoras", getLocadoras());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/locadora/formulario.jsp");
        dispatcher.forward(request, response);
    }
    
    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String papel = "LOCADORA";
        
        Usuario locadora = new Usuario(nome, email, senha, papel, cidade);
        dao.insertLocadora(locadora);
        response.sendRedirect("listaadmin");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));
        String nome = request.getParameter("nome");
        String cidade = request.getParameter("cidade");
        String email = request.getParameter("email");
        String senha = request.getParameter("senha");
        String papel = request.getParameter("papel");
        
        Usuario locadora = new Usuario(id, nome, email, senha, papel, cidade);
        dao.updateLocadora(locadora);
        response.sendRedirect("listaadmin");
    }
    
    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Usuario locadora = dao.getbyIDLocadora(id);
        request.setAttribute("locadora", locadora);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/locadora/formulario.jsp");
        dispatcher.forward(request, response);
    }
    
    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Usuario livro = new Usuario(id);
        dao.delete(livro);
        response.sendRedirect("listaadmin");
    }
    
}