package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.epi.Epi;
import model.epi.EpiDAOImpl;

@WebServlet(urlPatterns={"/epi"})
public class CadEpi extends HttpServlet{

    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException{
        req.setAttribute("epi", new Epi());
        req.setAttribute("option", "criar");
        try {            
            req.getRequestDispatcher("static/cadastro-epi.jsp").forward(req, res);
            
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
            Epi epi;
            try {
                // Verifica se já existe uma doenca com o id especificado na requisição
                List<Epi> epis = new EpiDAOImpl().findByCode(req.getParameter("id"));
                // Se a lista estiver vazia criamos uma nova doença
                if (epis.isEmpty()) {
                    epi = new Epi();
                } else {
                    // Caso a lista não esteja vazia significa que existe doença com este id
                    epi = epis.get(0);
                }
            } catch (Exception e) {
                epi = new Epi();
            }
            // Se o campo id do formulário estiver com algum valor válido atualizamos a doenca
            if ( !(req.getParameter("id") == null) && !req.getParameter("id").trim().equals("") ) {
                // Pegamos os valores dos campos do formulário
                String coleta = (String)req.getParameter("coleta");
                String associada = (String)req.getParameter("associada");
                System.out.println("Atualizando dados\nColeta:");
                System.out.println(coleta);
                System.out.println("Associada:");
                System.out.println(associada);
                // Alteramos os valores da classe
                epi.setColeta(coleta);
                epi.setAssociada(associada);
                
                try {
                    // Atualiza os dados da classe
                    Epi updateEpi = new EpiDAOImpl().updateEpi(epi);
                } catch (Exception e) {
                    // Salva os dados da classe
                    Epi saveEpi = new EpiDAOImpl().saveEpi(epi);
                }
                // Encaminha os dados da doença para o template
                req.setAttribute("epi", epi);
                req.getRequestDispatcher("/static/cadastro-epi.jsp").forward(req, res);
            } else {
                // Pegamos os valores dos campos do formulário
                String coleta = (String)req.getParameter("coleta");
                String associada = (String)req.getParameter("associada");
                System.out.println("Cadastrando doença\nColeta:");
                System.out.println("Coleta:");
                System.out.println(coleta);
                System.out.println("Associada:");
                System.out.println(associada);
                // Alteramos os valores da classe
                epi.setColeta(coleta);
                epi.setAssociada(associada);
                // Salvamos a classe
                Epi saveEpi = new EpiDAOImpl().saveEpi(epi);
                // Encaminhamos os dados da classe para o template
                req.setAttribute("epi", epi);
                req.setAttribute("option", "criar");
                req.getRequestDispatcher("/static/cadastro-epi.jsp").forward(req, res);
            }
        } catch (Exception e) {
            System.out.println("Erro em 10 ou Servlet");
            System.out.println(e.getMessage());
        }
    }
}