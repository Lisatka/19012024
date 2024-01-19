
import java.sql.*;

public class CreateMySQL1 {
    public static void main(String[] args) {
    String status = "Nada aconteceu ainda.";
    try{
     String strCreateTable = "CREATE TABLE `mysql_connector`.`tbl_create`  (`id` INT NOT NULL AUTO_INCREMENT, `nome` VARCHAR(255) NULL, PRIMARY KEY (`id`));";
        Connection conn = App.conectar();  
        Statement stmSql = conn.createStatement();
        stmSql.addBatch(strCreateTable);
        stmSql.executeBatch();
        stmSql.close();
        status = "Ok! Tabela crIada com sucesso...";
    String strCreatLogin = "CREATE TABLE `mysql_connector`.`tbl_login` (`login` INT NOT NULL, `nome` VARCHAR(255) NULL,`senha` VARCHAR(255) NULL, PRIMARY KEY (`login`));";
    Statement stmSqlLogin = conn.createStatement();
    stmSqlLogin.addBatch(strCreatLogin);
    stmSqlLogin.executeBatch();
    stmSqlLogin.close();


    }catch (Exception e){
        System.err.println("Ops! Ocorreu o erro..." + e);
    }
    System.out.println(status);
    }
}