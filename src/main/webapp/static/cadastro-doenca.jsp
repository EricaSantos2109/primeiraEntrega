<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType = "text/html" pageEncoding = "UTF-8" %>
<%@ page import = "java.util.*" %>

<html>
    <head>
        <meta charset = "UTF-8">
        <title>Cadastro de Doença</title>
        <link rel = "icon" type = "image/x-icon" href = "assets/save.ico">
        <link rel = "stylesheet" href = "styles/style.css">
        <link rel = "stylesheet" href = "styles/doenca.css">
    </head>
    <body>
        <h4 class = "is-center">Cadastro de Doença</h4>
        <div class = "container">
            <div class = "hero is-full-screen">
                <nav class = "tabs is-center">
                    <a href = "primeira_entrega">Home</a>
                    <a href = "epidemiologico">Cadastro de Dados Epidemiológico</a>
                    <a href = "doenca">Cadastro de Dados da Doença</a>
                    <a href = "visualizacao-epi">Visualizar Dados Epidemiológico</a>
                    <a href = "visualizacao-doe">Visualizar Dados Doença</a>
                </nav>
                <div id = "doenca">
                    <div class = "row">
                        <div class = "col">
                            <h3>
                                <%
                                    try {
                                        String option = (String) request.getAttribute("option");
                                        if (option.equals("criar")) {
                                            out.print("Cadastrar nova doenca");
                                        }
                                    } catch (Exception e) {
                                        out.print("Cadastrar novo produto");
                                    }
                                %>
                            </h3>
                            <form action = "cadastroDoenca" method = "POST">
                                <%
                                    Doenca doenca;
                                    try {
                                        doenca = (Doenca) request.getAttribute("doenca");
                                    } catch (Exception e) {
                                        doenca = new Doenca();
                                    }
                                    if ( doenca.getCode() == null || doenca.getCode().trim().equals("") ) {
                                        out.print("Identificador: <input type = 'text' name = 'id'/><br>");
                                        out.print("Nome: <input type = 'text' name = 'name'/><br>");
                                        out.print("Sintomas: <input type = 'text' name = 'sintomas'/><br>");
                                    } else {
                                        out.print("Identificador: <input type = 'text' name = 'id' value = '" + doenca.getCode() + "'/><br>");
                                        out.print("Nome: <input type = 'text' name = 'name' value = '" + doenca.getName() + "'/><br>");
                                        out.print("Sintomas: <input type = 'text' name = 'sintomas' value = '" + doenca.getSintomas() + "'/><br>");
                                    }
                                %>
                                <%
                                    try {
                                        String option = (String) request.getAttribute("option");
                                        if (option.equals("criar")) {
                                            out.print("<input type = 'reset' value = 'Cancelar' style = 'align-items: center'/>");
                                            out.print("<input type = 'submit' value = 'Cadastrar' style = 'align-items: center'/>");
                                        }
                                    } catch (Exception e) {
                                        out.print("<input type = 'reset' value = 'Cancelar' style = 'align-items: center'/>");
                                        out.print("<input type = 'submit' value = 'Cadastrar' style = 'align-items: center'/>");
                                    }
                                %>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class = "is-text-center">
            <p>
                Sistema de coleta e visualização de dados epidemiológicos - Desenvolvido por Érica dos Santos
            </p>
        </footer>
    </body>
</html>