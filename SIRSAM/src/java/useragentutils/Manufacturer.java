package useragentutils;

/**
 * @author CARLOS SANTANDER
 */
public enum Manufacturer {

    OTHER(1, "OTRO"),
    MICROSOFT(2, "MICROSOFT"),
    APPLE(3, "APPLE"),
    SUN(4, "SUN"),
    SYMBIAN(5, "SYMBIAN"),
    NOKIA(6, "NOKIA"),
    BLACKBERRY(7, "BLACKBERRY"),
    HP(8, "HP"),
    SONY_ERICSSON(9, "SONY_ERICSSON"),
    SAMSUNG(20, "SAMSUNG"),
    SONY(10, "SONY"),
    NINTENDO(11, "NINTENDO"),
    OPERA(12, "OPERA"),
    MOZILLA(13, "MOZILLA"),
    GOOGLE(15, "GOOGLE"),
    COMPUSERVE(16, "COMPUSERVE"),
    YAHOO(17, "YAHOO"),
    AOL(18, "AOL"),
    MMC(19, "MMC"),
    AMAZON(24, "AMAZON"),
    ROKU(21, "ROKU"),
    ADOBE(23, "ADOBE"),
    CONONICAL(25, "CANONICAL");

    private final short id;
    private final String name;

    private Manufacturer(int id, String name) {
        this.id = (byte) id;
        this.name = name;
    }

    /**
     * @return the id
     */
    public short getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

}
