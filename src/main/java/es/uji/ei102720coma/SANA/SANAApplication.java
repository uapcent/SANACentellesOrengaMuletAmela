package es.uji.ei102720coma.SANA;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import java.util.logging.Logger;

@SpringBootApplication
public class SANAApplication {
    private static final Logger log = Logger.getLogger(SANAApplication.class.getName());

    public static void main(String[] args) {
        //Auto-configura l'aplicacio
        new SpringApplicationBuilder(SANAApplication.class).run(args);
    }
}
