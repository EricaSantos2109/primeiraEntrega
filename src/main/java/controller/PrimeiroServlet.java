package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/primeira_entrega"})
public class PrimeiroServlet extends HttpServlet{

    public static void main(String[] args){

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        try{
            req.getRequestDispatcher("static/home.jsp").forward(req, resp);
        }catch(Exception e){
            System.out.println("Impossível escrever o nome do aluno e do professor, RA e Disciplina");
        }
        
    }

}
