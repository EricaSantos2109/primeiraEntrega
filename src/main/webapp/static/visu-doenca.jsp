<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Dados Epidemiologico</title>
    <link rel="icon" type="image/x-icon" href="assets/save.ico" />
    <link rel="stylesheet" href="styles/visu-doe.css" />
  </head>
  <body>
    <ul>
      <li><a href="primeira_entrega">Home</a></li>
      <li>
        <a href="visualizarEpi">Visualização dos dados Epidemiológicos</a>
      </li>
      <li><a href="visualizarDoenca">Visualizar Doença</a></li>
      <li><a href="doenca">Cadastro de dados da doença</a></li>
      <li><a href="epi">Cadastro de dados epidemiológicos</a></li>
    </ul>
    <div class="center">
      <table style="width:100%">
        <caption>
          <h3>Doenças</h3>
        </caption>
        <tr>
          <th>Nome</th>
          <th>Sintomas</th>
        </tr>
        <tr>
          <td>Covid19</td>
          <td>Gripe forte</td>
        </tr>
        <tr>
          <td>Diarreia</td>
          <td>Febre e dor de barriga</td>
        </tr>
      </table>
    </div>
    <footer>
      <p>
          Sistema de dado de coletas e visualização de dados epidemiológicos
      </p>
    </footer>
  </body>
</html>
