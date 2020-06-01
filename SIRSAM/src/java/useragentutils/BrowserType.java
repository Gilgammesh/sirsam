package useragentutils;

/**
 * @author CARLOS SANTANDER
 */
public enum BrowserType {

    /**
     * Standard web-browser
     */
    WEB_BROWSER("Browser"),
    /**
     * Special web-browser for movil devices
     */
    MOBILE_BROWSER("Browser (movil)"),
    /**
     * Text only browser like the good old Lynx
     */
    TEXT_BROWSER("Browser (text only)"),
    /**
     * Email client like Thunderbird
     */
    EMAIL_CLIENT("Email Client"),
    /**
     * Search robot, spider, crawler,...
     */
    ROBOT("Robot"),
    /**
     * Downloading tools
     */
    TOOL("Downloading tool"),
    /**
     * Application
     */
    APP("Application"),
    UNKNOWN("unknown");

    private String name;

    private BrowserType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
