<%@page import="java.util.List" %>
<%@ page import = "model.epi.Epi" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta charset = "UTF-8">
        <title>Dados Epidemiologico</title>
        <link rel = "icon" type = "image/x-icon" href = "assets/save.ico">
        <link rel = "stylesheet" href = "styles/epi.css">
    </head>
    <body>
        <ul>
            <li><a href="primeira_entrega">Home</a></li>
            <li><a href="visualizarEpi">Visualização dos dados Epidemiológicos</a></li>
            <li><a href="visualizarDoenca">Visualizar Doença</a></li>
            <li><a href="doenca">Cadastro de dados da doença</a></li>
            <li><a href="epi">Cadastro de dados epidemiológicos</a></li>
        </ul>
        <div>
            <div>
                <h3>Dado de Coleta Epidemiologico</h3>
                <div id = "epi" class="center">
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
                            <form action = "epi" method = "POST">
                                <%
                                    Epi epi;
                                    try {
                                        epi = (Epi) request.getAttribute("epi");
                                    } catch (Exception e) {
                                        epi = new Epi();
                                    }
                                    out.print("Data de coleta: <input type = 'date' name = 'coleta'/><br>");
                                    out.print("Doença Associada: <input type = 'text' name = 'associada'/><br>");                                        
                                %>
                                <%
                                    try {
                                        String option = (String) request.getAttribute("option");
                                        if (option.equals("criar")) {
                                            out.print("<input type = 'reset' value = 'Cancelar' style = 'align-items: center'/>");
                                            out.print("<input type = 'submit' value = 'Cadastrar' style = 'align-items: center'/>");
                                        }else if (option.equals("editar")) {
                                            out.print("<input type = 'reset' value = 'Cancelar' style = 'align-items: center'/>");
                                            out.print("<input type = 'submit' value = 'Salvar' style = 'align-items: center'/>");
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
        <footer>
            <p>
                Sistema de dado de coletas e visualização de dados epidemiológicos
            </p>
        </footer>
    </body>
</html>