<%@page import="java.util.List" %>
<%@ page import = "model.doenca.Doenca" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta charset = "UTF-8">
        <title>Dados da Doenças</title>
        <link rel = "icon" type = "image/x-icon" href = "assets/save.ico">
        <link rel = "stylesheet" href = "styles/doenca.css">
    </head>
    <body>
        <div>
            <div>
                <nav class="container">
                    <table>
                        <th>
                            <a href = "primeira_entrega">Home</a>
                        </th>
                        <th>
                            <a href = "visualizarEpi">Visualização dos dados Epidemiológicos</a>
                        </th>
                        <th>
                            <a href = "visualizarDoenca">Visualizar Doença</a>
                        </th>
                        <th>
                            <a href = "doenca">Cadastro de dados da doença</a>
                        </th>
                        <th>
                            <a href = "epidemiologico"> Cadastro de dados epidemiológicos</a>
                        </th>
                    </table>
                </nav>
                    <h3>Dado de Coleta de Doença</h3>
                <div id = "doenca" class="center">
                    <div class = "row">
                        <div class = "col">
                            <h3>
                                <%
                                    try {
                                        String option = (String) request.getAttribute("option");
                                        if (option.equals("criar")) {
                                            out.print("Cadastrar nova doença");
                                        }
                                    } catch (Exception e) {
                                        out.print("Cadastrar nova doença");
                                    }
                                %>
                            </h3>
                            <form action = "doenca" method = "POST">
                                <%
                                    Doenca doenca;
                                    try {
                                        doenca = (Doenca) request.getAttribute("doenca");
                                    } catch (Exception e) {
                                        doenca = new Doenca();
                                    }
                                    out.print("Nome: <input type = 'text' name = 'name'/><br>");
                                    out.print("Sintomas: <input type = 'text' name = 'sintomas'/><br>");                                        
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
                <b>Sistema de dado de coletas e visualização de dados epidemiológicos</b>
            </p>
        </footer>
    </body>
</html>