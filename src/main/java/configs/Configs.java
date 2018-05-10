package configs;

import java.util.*;

public class Configs {

    private static HashMap<String, String> configsApp = new HashMap<String, String>();
    public Configs(){
        configsApp.put("baseUrl", "https://swapi.co/api/");

    }


    public static HashMap<String, String> getConfigsApp() {
        return configsApp;
    }

}
