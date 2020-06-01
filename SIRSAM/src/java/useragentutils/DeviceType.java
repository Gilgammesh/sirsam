package useragentutils;

/**
 * @author CARLOS SANTANDER
 */
public enum DeviceType {

    COMPUTER("Computadora"),
    MOBILE("SmartPhone"),
    TABLET("Tablet"),
    GAME_CONSOLE("Consola de Juego"),
    DMR("Reproductor Digital"),
    WEARABLE("SmartWatch"),
    UNKNOWN("Desconocido");

    String name;

    private DeviceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
