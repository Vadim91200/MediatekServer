package JavaCode;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import static java.lang.Class.forName;

public class InitListener implements ServletContextListener {

    
    public void contextInitialized(ServletContextEvent sce) {
        try {
            forName("JavaCode.persistance.MediathequeData");
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Ho NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        }

    }

}
