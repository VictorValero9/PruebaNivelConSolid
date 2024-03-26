package enums;

public enum StrengthLevel {
    MUY_DEBIL(1,"Muy débil"),
    DEBIL(2,"Débil"),
    MODERADA(3,"Moderada"),
    FUERTE(4, "Fuerte"),
    MUY_FUERTE(5,"Muy fuerte");

    private final int valor;
    private final String descripcion;

    StrengthLevel(int valor, String descripcion){
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public int getValor(){
        return valor;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public static StrengthLevel getSecurityLevel(int points) {
        if (points >= 1 && points <= 2) {
            return MUY_DEBIL;
        } else if (points >= 3 && points <= 5) {
            return DEBIL;
        } else if (points >= 6 && points <= 7) {
            return MODERADA;
        } else if (points >= 8 && points <= 9) {
            return FUERTE;
        } else {
            return MUY_FUERTE;
        }
    }
}
