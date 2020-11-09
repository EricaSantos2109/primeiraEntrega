package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.doenca.Doenca;
import model.doenca.DoencaDAOImpl;

@WebServlet(urlPatterns={"/doenca"})
public class CadDoenca extends HttpServlet{

    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException{
        req.setAttribute("doenca", new Doenca());
        req.setAttribute("option", "criar");
        try {            
            req.getRequestDispatcher("static/cadastro-doenca.jsp").forward(req, res);
            
        } catch (Exception e) {
            System.out.println("An exception was thrown");
            System.out.println(e.toString());
        }
        
    }

    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException{
        try {
            req.setCharacterEncoding("UTF-8");
            // Declara objeto doenca
            Doenca doenca;
            try {
                // Verifica se já existe uma doenca com o id especificado na requisição
                List<Doenca> doencas = new DoencaDAOImpl().findByCode(req.getParameter("id"));
                // Se a lista estiver vazia criamos uma nova doença
                if (doencas.isEmpty()) {
                    doenca = new Doenca();
                } else {
                    // Caso a lista não esteja vazia significa que existe doença com este id
                    doenca = doencas.get(0);
                }
            } catch (Exception e) {
                doenca = new Doenca();
            }
            // Se o campo id do formulário estiver com algum valor válido atualizamos a doenca
            if ( !(req.getParameter("id") == null) && !req.getParameter("id").trim().equals("") ) {
                // Pegamos os valores dos campos do formulário
                String nameDoenca = (String)req.getParameter("name");
                String sintomas = (String)req.getParameter("sintomas");
                System.out.println("Atualizando dados\nNome da doenca:");
                System.out.println(nameDoenca);
                System.out.println("Sintomas:");
                System.out.println(sintomas);
                // Alteramos os valores da classe
                doenca.setName(nameDoenca);
                doenca.setSintomas(sintomas);
                
                try {
                    // Atualiza os dados da classe
                    Doenca updateDoenca = new DoencaDAOImpl().updateDoenca(doenca);
                } catch (Exception e) {
                    // Salva os dados da classe
                    Doenca saveDoenca = new DoencaDAOImpl().saveDoenca(doenca);
                }
                // Encaminha os dados da doença para o template
                req.setAttribute("doenca", doenca);
                req.getRequestDispatcher("/static/cadastro-doenca.jsp").forward(req, res);
            } else {
                // Pegamos os valores dos campos do formulário
                String nameDoenca = (String)req.getParameter("name");
                String sintomas = (String)req.getParameter("sintomas");
                System.out.println("Cadastrando doença\nNome da doenca:");
                System.out.println("Nome da doença:");
                System.out.println(nameDoenca);
                System.out.println("Sintomas:");
                System.out.println(sintomas);
                // Alteramos os valores da classe
                doenca.setName(nameDoenca);
                doenca.setSintomas(sintomas);
                // Salvamos a classe
                Doenca saveDoenca = new DoencaDAOImpl().saveDoenca(doenca);
                // Encaminhamos os dados da classe para o template
                req.setAttribute("doenca", doenca);
                req.setAttribute("option", "criar");
                req.getRequestDispatcher("/static/cadastro-doenca.jsp").forward(req, res);
            }
        } catch (Exception e) {
            System.out.println("Erro em 10 ou Servlet");
            System.out.println(e.getMessage());
        }
    }

}