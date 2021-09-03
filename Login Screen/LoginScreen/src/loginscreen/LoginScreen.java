/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginscreen;

/**
 *
 * @author Matheus Camargo
 */
public class LoginScreen {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        UI_LoginScreen Login_Screen = new UI_LoginScreen();
        UI_LoadingScreen LoadScreen = new UI_LoadingScreen();
        LoadScreen.ProgressBar.setStringPainted(true);
        LoadScreen.setVisible(true);
        
        try {
            for (int i = 0; i <= 100; i+=4){
                Thread.sleep(100);
                LoadScreen.ProgressBar.setValue(i);
            }
        }catch(Exception e){}
        
        LoadScreen.dispose();
        
        Login_Screen.setVisible(true);
    }
    
}
