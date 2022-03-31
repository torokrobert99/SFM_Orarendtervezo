package hu.unideb.inf;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            MainApp.main(args);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
