import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

import static java.lang.Class.forName;

public class InitListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            forName("persistance.MediathequeData");
            System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Ho NO");
        }

    }

}
