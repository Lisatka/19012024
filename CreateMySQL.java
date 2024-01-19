////importar biblioteca java.sql
import java.sql.*;
//declaração de classe\objeto app
public class CreateMySQL {
     /**
     * declaração do método executor main
     * public:porque poderá ser importado por outros objetos\classes
     * static: porque o método não poderá ser alteradoou sobresquito
     * void: porque é um métoso sem retorno
     * @param String[] porque poderão ser invocados métodos do tipo String e matrizes[]
     * @param args porque poderá ser invocado o objetivoargs da biblioteca java.lang
     */
    public static void main(String[] args) {
        String status = "Nada aconteceu ainda.";
        try{
            String strCreateTable = "CREATE TABLE `mysql_connector`.`tbl_create` (`id` INT NOT NULL AUTO_INCREMENT,`nome` VARCHAR(255) NULL,PRIMARY KEY (`id`));";
            Connection conn = App.conectar();
            Statement stmSql = conn.createStatement();
            stmSql.addBatch(strCreateTable);
            stmSql.executeBatch();
            stmSql.close();
            status = "Ok! Tabela criada com sucesso.";

        }catch(Exception e){
            System.err.println("Ops! Oocrreu o erro" + e);
        }
      System.out.println(status);
    }
    
}
