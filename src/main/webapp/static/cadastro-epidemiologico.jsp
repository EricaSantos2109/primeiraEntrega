<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType = "text/html" pageEncoding = "UTF-8" %>
<%@ page import = "java.util.*" %>

<html>
    <head>
        <meta charset = "UTF-8">
        <title>Cadastro de Dados Epidemiologico</title>
        <link rel = "icon" type = "image/x-icon" href = "assets/save.ico">
        <link rel = "stylesheet" href = "styles/style.css">
        <link rel = "stylesheet" href = "styles/epi.css">
    </head>
    <body>
        <h4 class = "is-center">Cadastro de Dados Epidemiologico</h4>
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
                                            out.print("Cadastrar novo dado");
                                        }
                                    } catch (Exception e) {
                                        out.print("Cadastrar novo dado");
                                    }
                                %>
                            </h3>
                            <form action = "cadastroEpidemiologico" method = "POST">
                                <%
                                    Epidemiologico epi;
                                    try {
                                        epi = (Epidemiologico) request.getAttribute("epi");
                                    } catch (Exception e) {
                                        epi = new Epidemiologico();
                                    }
                                    if ( epi.getCode() == null || epi.getCode().trim().equals("") ) {
                                        out.print("Identificador: <input type = 'text' name = 'id'/><br>");
                                        out.print("Data de coleta: <input type = 'date' name = 'data'/><br>");
                                        out.print("Doença Assosciada: <input type = 'text' name = 'doencaAssociada'/><br>");
                                    } else {
                                        out.print("Identificador: <input type = 'text' name = 'id' value = '" + epi.getCode() + "'/><br>");
                                        out.print("Data de coleta: <input type = 'date' name = 'data' value = '" + epi.getData() + "'/><br>");
                                        out.print("Doença Assosciada: <input type = 'text' name = 'doencaAssociada' value = '" + epi.getDoenca() + "'/><br>");
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