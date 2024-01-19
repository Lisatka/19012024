import java.sql.*;
import java.util.*;

public class DeleteMySQL {

    public static void main(String[] args) {

        String status = "Nada aconteceu ainda.";
        Connection conn = App.conectar();
        Scanner scnLogin = new Scanner(System.in);
        Scanner scnResp = new Scanner(System.in);
        Scanner scnSenha = new Scanner(System.in);

        try {
            System.out.println("Bem-vindo à opção de DELETE do seu Banco de Dados.");
            System.out.println("Digite o ID do login que deseja excluir: ");
            int idLogin = scnLogin.nextInt(); 
            System.out.println("Digite sua senha: ");
            String strSenha = scnSenha.nextLine();
            System.out.println("Deseja realmente deletar esses dados? (N) para não, ou (S) para sim. ");
            String strResp = scnResp.nextLine();

            if (strResp.equalsIgnoreCase("S")) {
                Statement stmSql = conn.createStatement();
                String strSqlDeleteLogin = "DELETE FROM `mysql_connector`.`tbl_login` WHERE id = " + idLogin + ";";
                stmSql.executeUpdate(strSqlDeleteLogin);
                status = "Dados deletados com sucesso!";
                System.out.println(status);
            } else {
                status = "Operação de exclusão cancelada pelo usuário.";
                System.out.println(status);
            }

        } catch (Exception e) {
            System.err.println("Ops! Ocorreu um erro: " + e);
        
            scnLogin.close();
            scnResp.close();
            scnSenha.close();
        }
    }
}