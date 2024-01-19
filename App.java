//importar biblioteca java 
import java.sql.*;
//declaração de classe\objeto app
public class App {
    /**
     * declaração do método executor main
     * public:porque poderá ser importado por outros objetos\classes
     * static: porque o método não poderá ser alteradoou sobresquito
     * void: porque é um métoso sem retorno
     * @param String[] porque poderão ser invocados métodos do tipo String e matrizes[]
     * @param args porque poderá ser invocado o objetivoargs da biblioteca java.lang
     */
    public static void main(String[] args) {
        /**
         *  Este trecho de código imprime uma mensagem simples no console
         *  usando System.out.println.
         */
        System.out.println("Conectando ao banco de dados...");
        conectar();
    }
    /**
     * @param Connection um tipo de dado para retornar um método
     * @param conectar  método para chamar o Banco de Dados
     */

    public static Connection conectar() {
        String status = "Nada aconteceu ainda...";//está criando uma variável chamada status que pode armazenar dados do tipo String
        String mysqlHost = "127.0.0.1";//uma variavel do tipo string utilizada para armazenar informações relacionadas ao host de um servidor MySQL.
        String mysqlDb = "mysql_connector";// está criando uma variável chamada mysqlDb do tipo String e atribuindo a ela o valor "mysql_connector"
        String mysqlUser = "lisandra";//criando uma variável do tipo string para armazenará o nome de usuário
        String mysqlPassword = "";//criando uma variável do tipo string para armazenará o senha de usuário
        String mysqlUrl = "jdbc:mysql://" + mysqlHost + "/" + mysqlDb + "?user=" + mysqlUser + "&password=" + mysqlPassword;// construindo uma string que representa a URL de conexão JDBC( uma API que permite que programas Java interajam com bancos de dados relacionais.) para o banco de dados MySQL, incorporando o host, o nome do banco de dados, e informações de autenticação (nome de usuário e senha).
        Connection conn = null;// declaração da variavel conn
        try {//Código que pode lançar exceções
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
           /**
            *  @param Class.forName() é um método que carrega dinamicamente a classe especificada em tempo de execução.
            *  "com.mysql.cj.jdbc" é o pacote que contém a implementação do driver JDBC para MySQL, e "Driver" é o nome da classe do driver.
            * newInstance() é um método que cria uma nova instância da classe carregada por Class.forName()
            */
            conn = DriverManager.getConnection(mysqlUrl);
            /**
             * está estabelecendo uma conexão com um banco de dados usando o DriverManager e a URL de conexão (mysqlUrl)
             * DriverManager:É usada para estabelecer conexões com bancos de dados usando JDBC.
             * getConnection(mysqlUrl):  é usado para obter uma conexão com um banco de dados.
             * mysqlUrl: A variável mysqlUrl contém a URL de conexão com o banco de dados MySQL
             */
            status = "Conexão realizada com sucesso!";
             //método usado para imprimir informações detalhes sobre
           
             //  Lidar com exceções relacionadas à conexão com o banco de dados
        } catch (SQLException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            status = "Ops! Algo de errado não está certo com a conexão com o banco de dados MySQL! mensagem do servidor: " + e;
        }
        System.out.println(status);// imprimir o valor da variável status no console.
        return conn;// retornar o objeto conn, que é uma instância da classe Connection, de um método. 
    }//encerra método
}//encerra a classe