package ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author ignacio.campinofernandez
 */
public class DBWordGenerator implements WordGenerator {

    Connection c;
    /**
     * Constante para direccion de conexion con base de datos
     */
    public final static String URL_DB = "jdbc:mariadb://localhost:33006/ahorcado";

    /**
     * Constante para usuario base de datos
     */
    public final static String USER = "admin";

    /**
     * Constante para contraseña base de datos
     */
    public final static String PASSWORD = "daw2pass";
//Metodo que xenera palabra random de entre as palabras dispoñibles na base de datos e tamen consigue a conexion a mesma.
    @Override
    public String generateWord() throws GenerateWordException {
        String word = "";
        try (Connection c = DriverManager.getConnection(URL_DB, USER, PASSWORD)) {
            String dataFromFilms = "SELECT * FROM word";

            Statement st = (Statement) c.createStatement();
            ResultSet rst = st.executeQuery(dataFromFilms);

            rst.last();
            int row = rst.getRow();
            Random rand = new Random();
            int tupla = rand.nextInt(row);
            rst.absolute(tupla);
            word = rst.getString("word");
            rst.close();
            st.close();
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("A conexión co servidor de bases de datos non se puido establecer");
        }
        return word;
    }

}
