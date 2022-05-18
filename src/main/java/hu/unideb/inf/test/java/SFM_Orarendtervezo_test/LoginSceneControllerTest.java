package hu.unideb.inf.test.java.SFM_Orarendtervezo_test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSceneControllerTest {

    class LoginSceneControllerTestAid{
        protected String username;
        protected String password;
    }

    @Test
    void testUsernameIsValid(){
        LoginSceneControllerTestAid login = new LoginSceneControllerTestAid();
        login.username = "i";
        login.password = "a";
        List<String> userNames = new ArrayList<>();
        List<String> passwords = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            login.username = login.username + i;
            userNames.add(login.username);
        }
        for (int i = 0; i < 10; i++){
            login.password = login.password + i;
            userNames.add(login.password);
        }
        boolean isUserNameIn = false;
        String myUserName = "i0123";
        String myPassword = "a1503";
        boolean isValidUser = false;
        for (String username : userNames){
            if (myUserName.equals(username)){
                isUserNameIn = true;
            }
        }
        if (isUserNameIn && myPassword != null){
            isValidUser = true;
        }
        assertTrue(isValidUser);
    }
}
