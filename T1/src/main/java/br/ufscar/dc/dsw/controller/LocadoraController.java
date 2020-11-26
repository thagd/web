package br.ufscar.dc.dsw.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.Locadora;
import br.ufscar.dc.dsw.dao.LocadoraDAO;

@WebServlet(urlPatterns = { "/locadoras/*" , "index.jsp" })
public class LocadoraController extends HttpServlet {

    private static final long serialVersionUID = 1L; 
    private LocadoraDAO dao;

    @Override
    public void init() {
        dao = new LocadoraDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {           
        try {
    		lista(request, response);
        } catch (RuntimeException | IOException | ServletException e) {
            throw new ServletException(e);
        }
    }

    private void lista(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
        List<Locadora> listaLocadoras = dao.getAll();
        request.setAttribute("listaLocadoras", listaLocadoras);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
/*
    private Map<Long, String> getEditoras() {
        Map <Long,String> editoras = new HashMap<>();
        for (Editora editora: new EditoraDAO().getAll()) {
            editoras.put(editora.getId(), editora.getNome());
        }
        return editoras;
    }
    
    private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("editoras", getEditoras());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/livro/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Livro livro = dao.get(id);
        request.setAttribute("livro", livro);
        request.setAttribute("editoras", getEditoras());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/livro/formulario.jsp");
        dispatcher.forward(request, response);
    }

    private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        Integer ano = Integer.parseInt(request.getParameter("ano"));
        Float preco = Float.parseFloat(request.getParameter("preco"));
        
        Long editoraID = Long.parseLong(request.getParameter("editora"));
        Editora editora = new EditoraDAO().get(editoraID);
        
        Livro livro = new Livro(titulo, autor, ano, preco, editora);
        dao.insert(livro);
        response.sendRedirect("lista");
    }

    private void atualize(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        Long id = Long.parseLong(request.getParameter("id"));
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        Integer ano = Integer.parseInt(request.getParameter("ano"));
        Float preco = Float.parseFloat(request.getParameter("preco"));
        
        Long editoraID = Long.parseLong(request.getParameter("editora"));
        Editora editora = new EditoraDAO().get(editoraID);
        
        Livro livro = new Livro(id, titulo, autor, ano, preco, editora);
        dao.update(livro);
        response.sendRedirect("lista");
    }

    private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Long id = Long.parseLong(request.getParameter("id"));

        Livro livro = new Livro(id);
        dao.delete(livro);
        response.sendRedirect("lista");
    }*/
}