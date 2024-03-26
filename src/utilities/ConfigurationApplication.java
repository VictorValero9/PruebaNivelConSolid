package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigurationApplication implements IConfigurationApplication {
    private int umbral;
    private int minLength;
    private boolean requireCaps;
    private boolean requireNums;
    private boolean requireSymbols;

    public ConfigurationApplication() {
        loadConfiguracion();
    }

    private void loadConfiguracion() {
        try (InputStream input = ConfigurationApplication.class.getClassLoader().getResourceAsStream("utilities/config.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                System.out.println("Lo siento, no se pudo encontrar el archivo de configuración.");
                return;
            }
            prop.load(input);
            umbral = Integer.parseInt(prop.getProperty("umbral"));
            minLength = Integer.parseInt(prop.getProperty("minLength"));
            requireCaps = Boolean.parseBoolean(prop.getProperty("requireCaps"));
            requireNums = Boolean.parseBoolean(prop.getProperty("requireNums"));
            requireSymbols = Boolean.parseBoolean(prop.getProperty("requireSymbols"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int getUmbralConfirmacion() {
        return umbral;
    }

    public int getMinLength(){
        return minLength;
    }

    public boolean isRequireCaps() {
        return requireCaps;
    }

    public boolean isRequireNums() {
        return requireNums;
    }

    public boolean isRequireSymbols() {
        return requireSymbols;
    }
}

