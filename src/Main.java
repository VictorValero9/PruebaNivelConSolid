import model.*;
import utilities.*;
import enums.StrengthLevel;
public class Main {
    public static void main(String[] args) {
       IConsole console = new Console();
       ConfigurationApplication configuration = new ConfigurationApplication();

       console.write("Ingrese la contraseña");
       String password = console.read();

       IPasswordVerifier verifier = new PasswordVerifier(
               configuration.getMinLength(),
               configuration.isRequireCaps(),
               configuration.isRequireNums(),
               configuration.isRequireSymbols()
               );

       int points = verifier.calculate(password);
       StrengthLevel securityLevel = StrengthLevel.getSecurityLevel(points);

       console.write("La puntuación és: " + points);
       console.write("La seguridad de la contraseña es: " + securityLevel);

       if(points < configuration.getUmbralConfirmacion()){
           if(console.confirm("La contraseña es débil. ¿Desea continuar? (s/n)")){
               console.write("Contraseña aceptada");
           } else {
               console.write("Contraseña rechazada.");
           }
       } else {
           console.write("Contraseña aceptada.");
       }


    }
}