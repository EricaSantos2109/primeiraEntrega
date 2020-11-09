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
            PrintWriter pw = resp.getWriter();
            pw.write("Primeira Entrega da Disciplina \n Nome da aluna: Erica dos Santos Moreira da Rosa. \n R.A:1460481821022 \n Nome do professor: Fabricio Galende \n Disciplina: Laboratorio de Engenharia de Software");
        }catch(IOException ioe){
            System.out.println("Impossível escrever o nome do aluno e do professor, RA e Disciplina");
        }
        
    }

}
