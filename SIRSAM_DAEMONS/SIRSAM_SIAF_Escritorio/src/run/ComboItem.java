package run;

/**
 *
 * @author CARLOS SANTANDER
 */
public class ComboItem {

    private final String text;
    private final String value;

    public ComboItem(String text, String value) {
        this.text = text;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return text;
    }

}
