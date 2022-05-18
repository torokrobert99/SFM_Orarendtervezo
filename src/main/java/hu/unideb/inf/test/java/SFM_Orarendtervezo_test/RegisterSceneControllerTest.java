package hu.unideb.inf.test.java.SFM_Orarendtervezo_test;

import hu.unideb.inf.RegisterSceneController;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

public class RegisterSceneControllerTest {

    class RegisterSceneControllerAidClass{
        protected String passwordInRegister;
        protected String confirmpasswordInRegister;
        protected String userNameInRegister;
    }
    //azonos jelszoteszteles
    @Test
    public void testComparePasswords() {
        RegisterSceneControllerAidClass testPasswords = new RegisterSceneControllerAidClass();
        testPasswords.confirmpasswordInRegister = "Alma1234";
        testPasswords.passwordInRegister = "Alma1234";
        assertTrue(testPasswords.passwordInRegister.equals(testPasswords.confirmpasswordInRegister));
    }

    @Test
    public void testComparePasswordsNotEqual(){
        RegisterSceneControllerAidClass testPasswords = new RegisterSceneControllerAidClass();
        testPasswords.confirmpasswordInRegister = "Alma1234";
        testPasswords.passwordInRegister = "alma12345";
        assertFalse(testPasswords.passwordInRegister.equals(testPasswords.confirmpasswordInRegister));
    }

    @Test
    public void testIsUserNameTaken() {
        RegisterSceneControllerAidClass userNamesTester = new RegisterSceneControllerAidClass();
        List<String> userNames = new ArrayList<>();
        String randomUserName = "i";
        for (int i = 0; i < 10; i++){
            randomUserName = randomUserName + i;
            userNames.add(randomUserName);
        }
        boolean isUserNameIn = false;
        String myUserName = "i0123";

        for (String userName : userNames){
            if (userName.equals(myUserName)){
                isUserNameIn = true;
            }
        }
        assertEquals(true, isUserNameIn);
    }

}
