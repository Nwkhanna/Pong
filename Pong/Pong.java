public class Pong {
    public static int state = 0;
    public static Thread mainThread;
    public static MainMenu menu;
    public static GPanel gpanel;
    public static void main(String[] args) {
        //GPanel game = new GPanel();
         menu = new MainMenu();

        mainThread = new Thread(menu);
        mainThread.start();
    }
    public static void changeState(int newState){
        if(newState == 1 && state == 0){
            menu.stop();
            gpanel = new GPanel();
            mainThread = new Thread(gpanel);
            mainThread.start();
        }
        else if(newState == 0 && state == 1){
            gpanel.stop();
            menu = new MainMenu();
            mainThread = new Thread(menu);
            mainThread.start();
        }
        else if(newState == 2){
            if(gpanel != null){
                gpanel.stop();
            }
            if(menu != null){
                menu.stop();
            }
        }
        state = newState;
    }
}
