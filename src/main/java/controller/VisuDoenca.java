package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/visualizarDoenca"})
public class VisuDoenca extends HttpServlet{

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp){
        try{
            req.getRequestDispatcher("static/visu-doenca.jsp").forward(req, resp);
        }catch(Exception e){
            System.out.println("Impossível abrir a pagina");
        }
    }
}