package run;

import inversion.webservice.Inversion;
import inversion.webservice.ProyectosBot;
import inversion.webservice.ProyectosBot_Service;
import java.math.BigDecimal;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/*
 // @author CARLOS SANTANDER
 */
public class SIRSAM_Bot {

    public static void main(String[] args) throws Exception {

        ProyectosBot_Service service = new ProyectosBot_Service();
        ProyectosBot port = service.getProyectosBotPort();

        InetAddress inet = InetAddress.getLocalHost();
        String host = inet.getHostName();
        String ip = inet.getHostAddress();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        String path = System.getProperty("user.dir");

        //System.setProperty("webdriver.gecko.driver", path + "\\src\\exes\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", path + "\\src\\exes\\chromedriver.exe");

        //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setCapability("marionette", true);

        //WebDriver driver = new FirefoxDriver(capabilities);
        WebDriver driver = new ChromeDriver(capabilities);
        LocalDateTime loCal = LocalDateTime.now();
        int ano_actual = loCal.getYear();
        int mes_actual = loCal.getMonthValue();
        int dia_actual = loCal.getDayOfMonth();
        Inversion beanCod = port.getLogsBotCod(" WHERE logs_id = 1 ");
        String codAct = beanCod.getProyCodigoSiaf();
        XMLGregorianCalendar xmlCal = beanCod.getFecha();
        int ano_cal = xmlCal.getYear();
        int mes_cal = xmlCal.getMonth();
        int dia_cal = xmlCal.getDay();
        ///*
        String query;
        Boolean booting;
        if (mes_actual == 1) {
            String queryCod = " WHERE g.ano_eje = '" + (ano_actual - 1) + "' AND m.act_proy ilike '2%' AND m.act_proy != '2000270' AND "
                    + "m.act_proy != '2001621' GROUP BY m.act_proy ORDER BY m.act_proy DESC LIMIT 1 ";
            List<Inversion> listLast = port.getCodigosSIAF(queryCod);
            String codLast = listLast.get(0).getProyCodigoSiaf();
            if (codAct.equals(codLast)) {
                if (ano_cal == ano_actual && mes_cal == mes_actual && dia_cal == dia_actual) {
                    booting = false;
                    query = "";
                } else {
                    booting = true;
                    query = " WHERE g.ano_eje = '" + (ano_actual - 1) + "' AND m.act_proy ilike '2%' AND m.act_proy != '2000270' AND "
                            + "m.act_proy != '2001621' GROUP BY m.act_proy ORDER BY m.act_proy ASC ";
                }
            } else {
                booting = true;
                query = " WHERE g.ano_eje = '" + (ano_actual - 1) + "' AND m.act_proy >= '" + codAct + "' AND m.act_proy ilike '2%' AND "
                        + "m.act_proy != '2000270' AND m.act_proy != '2001621' GROUP BY m.act_proy ORDER BY m.act_proy ASC ";
            }
        } else {
            String queryCod = " WHERE g.ano_eje = '" + ano_actual + "' AND m.act_proy ilike '2%' AND m.act_proy != '2000270' AND "
                    + "m.act_proy != '2001621' GROUP BY m.act_proy ORDER BY m.act_proy DESC LIMIT 1 ";
            List<Inversion> listLast = port.getCodigosSIAF(queryCod);
            String codLast = listLast.get(0).getProyCodigoSiaf();
            if (codAct.equals(codLast)) {
                if (ano_cal == ano_actual && mes_cal == mes_actual && dia_cal == dia_actual) {
                    booting = false;
                    query = "";
                } else {
                    booting = true;
                    query = " WHERE g.ano_eje = '" + ano_actual + "' AND m.act_proy ilike '2%' AND m.act_proy != '2000270' AND "
                            + "m.act_proy != '2001621' GROUP BY m.act_proy ORDER BY m.act_proy ASC ";
                }
            } else {
                booting = true;
                query = " WHERE g.ano_eje = '" + ano_actual + "' AND m.act_proy >= '" + codAct + "' AND m.act_proy ilike '2%' AND "
                        + "m.act_proy != '2000270' AND m.act_proy != '2001621' GROUP BY m.act_proy ORDER BY m.act_proy ASC ";
            }
        }
        //*/
        //String query = " WHERE g.ano_eje = '" + ano_actual + "' AND m.act_proy ilike '2%' AND m.act_proy >= '2231055' AND m.act_proy != '2000270' "
        //        + "AND m.act_proy != '2001621' GROUP BY m.act_proy ORDER BY m.act_proy ASC ";
        //String query = " WHERE m.act_proy ilike '2%' AND m.act_proy >= '0000000' AND m.act_proy != '2000270' "
        //        + "AND m.act_proy != '2001621' GROUP BY m.act_proy ORDER BY m.act_proy ASC ";
        //boolean booting = true;

        if (booting) {
            List<Inversion> list = port.getCodigosSIAF(query);
            list.stream()
                    .forEach(t -> {
                        String codigoSiaf = t.getProyCodigoSiaf();
                        System.out.println("\n" + "Código SIAF : " + t.getProyCodigoSiaf());
                        driver.get("https://ofi5.mef.gob.pe/ssi/");
                        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
                        WebDriverWait wait = new WebDriverWait(driver, 60);
                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoad")));
                        driver.findElement(By.id("optSiaf")).click();
                        driver.findElement(By.id("txtCodigo")).sendKeys(codigoSiaf);
                        driver.findElement(By.id("butBuscar")).click();

                        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("divLoad")));

                        Inversion proy = new Inversion();
                        proy.setProyCodigoSiaf(codigoSiaf);

                        WebElement elementoPadre1 = driver.findElement(By.id("tabs-1"));
                        String textTabs1 = elementoPadre1.getAttribute("innerText").trim();
                        String compare1 = "no se encontró información de preinversión";

                        if (textTabs1.toLowerCase().contains(compare1)) {

                        } else {

                            List<WebElement> listelementoHijo1 = elementoPadre1.findElements(By.className("tData"));

                            if (!listelementoHijo1.isEmpty()) {
                                WebElement elementoHijo1 = elementoPadre1.findElement(By.className("tData"));
                                List<WebElement> listaTab1H = elementoHijo1.findElements(By.tagName("th"));
                                List<WebElement> listaTab1 = elementoHijo1.findElements(By.tagName("td"));
                                //IntStream.range(0, listaTab1H.size()).forEach(th -> System.out.println(th + " -> " + listaTab1H.get(th).getAttribute("innerText")));
                                //IntStream.range(0, listaTab1.size()).forEach(td -> System.out.println(td + " -> " + listaTab1.get(td).getAttribute("innerText")));

                                proy.setProyNombre(listaTab1.get(3).getAttribute("innerText"));
                                Date date1 = null;
                                try {
                                    date1 = dateFormat.parse(listaTab1.get(1).getAttribute("innerText"));
                                } catch (ParseException ex) {
                                    Logger.getLogger(SIRSAM_Bot.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                GregorianCalendar cal1 = new GregorianCalendar();
                                cal1.setTime(date1);
                                XMLGregorianCalendar xmlGregCal1 = null;
                                try {
                                    xmlGregCal1 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal1);
                                } catch (DatatypeConfigurationException ex) {
                                    Logger.getLogger(SIRSAM_Bot.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                proy.setProyFechaRegistro(xmlGregCal1);
                                proy.setProyCadenaFuncional(listaTab1.get(4).getAttribute("innerText"));
                                proy.setProyUnidadFormuladora(listaTab1.get(5).getAttribute("innerText"));
                                proy.setProyUnidadEvaluadora(listaTab1.get(6).getAttribute("innerText"));
                                proy.setProyBeneficiarios(new BigDecimal(listaTab1.get(7).getAttribute("innerText").replaceAll(",", "")));
                                proy.setProyFuenteFinanciamiento(listaTab1.get(8).getAttribute("innerText"));

                                if (listaTab1H.get(9).getAttribute("innerText").toLowerCase().equals("responsable de viabilidad")) {
                                    proy.setProyResponsableViabilidad(listaTab1.get(9).getAttribute("innerText"));
                                    Date date2 = null;
                                    try {
                                        date2 = dateFormat.parse(listaTab1.get(10).getAttribute("innerText"));
                                    } catch (ParseException ex) {
                                        Logger.getLogger(SIRSAM_Bot.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    GregorianCalendar cal2 = new GregorianCalendar();
                                    cal2.setTime(date2);
                                    XMLGregorianCalendar xmlGregCal2 = null;
                                    try {
                                        xmlGregCal2 = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal2);
                                    } catch (DatatypeConfigurationException ex) {
                                        Logger.getLogger(SIRSAM_Bot.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    proy.setProyFechaViabilidad(xmlGregCal2);
                                    proy.setProySituacion(listaTab1.get(11).getAttribute("innerText"));
                                    proy.setProyNivelViabilidad(listaTab1.get(12).getAttribute("innerText"));
                                    proy.setProyUltimoEstudio(listaTab1.get(13).getAttribute("innerText"));
                                    proy.setProyEstado(listaTab1.get(14).getAttribute("innerText"));
                                    proy.setProyMontoViable(new BigDecimal(listaTab1.get(15).getAttribute("innerText").replaceAll(",", "")));
                                    proy.setProyMontoLaudo(new BigDecimal(listaTab1.get(19).getAttribute("innerText").replaceAll(",", "")));
                                    proy.setProyMontoEstudioDefinitivo(new BigDecimal(listaTab1.get(16).getAttribute("innerText").replaceAll(",", "")));
                                    proy.setProyMontoCartaFianza(new BigDecimal(listaTab1.get(20).getAttribute("innerText").replaceAll(",", "")));
                                    proy.setProyMontoActualizado(new BigDecimal(listaTab1.get(17).getAttribute("innerText").replaceAll(",", "")));
                                    proy.setProyPorEtapas(listaTab1.get(18).getAttribute("innerText"));
                                    proy.setProyTieneExpedienteTecnico(listaTab1.get(21).getAttribute("innerText"));
                                    proy.setProyTieneInformeCierre(listaTab1.get(22).getAttribute("innerText"));
                                } else {
                                    proy.setProySituacion(listaTab1.get(9).getAttribute("innerText"));
                                    proy.setProyNivelViabilidad(listaTab1.get(10).getAttribute("innerText"));
                                    proy.setProyUltimoEstudio(listaTab1.get(11).getAttribute("innerText"));
                                    proy.setProyEstado(listaTab1.get(12).getAttribute("innerText"));
                                    proy.setProyMontoViable(new BigDecimal(listaTab1.get(13).getAttribute("innerText").replaceAll(",", "")));
                                    proy.setProyMontoLaudo(new BigDecimal(listaTab1.get(17).getAttribute("innerText").replaceAll(",", "")));
                                    proy.setProyMontoEstudioDefinitivo(new BigDecimal(listaTab1.get(14).getAttribute("innerText").replaceAll(",", "")));
                                    proy.setProyMontoCartaFianza(new BigDecimal(listaTab1.get(18).getAttribute("innerText").replaceAll(",", "")));
                                    proy.setProyMontoActualizado(new BigDecimal(listaTab1.get(15).getAttribute("innerText").replaceAll(",", "")));
                                    proy.setProyPorEtapas(listaTab1.get(16).getAttribute("innerText"));
                                    proy.setProyTieneExpedienteTecnico(listaTab1.get(19).getAttribute("innerText"));
                                    proy.setProyTieneInformeCierre(listaTab1.get(20).getAttribute("innerText"));
                                }

                                WebElement elementoPadre2 = driver.findElement(By.id("tabs-2"));
                                String textTabs2 = elementoPadre2.getAttribute("innerText").trim();
                                String compare2 = "no se cuenta con información para el proyecto seleccionado";

                                if (textTabs2.toLowerCase().contains(compare2)) {

                                } else {
                                    List<WebElement> elementoHijo2 = elementoPadre2.findElements(By.className("tblEjecutora"));
                                    if (!elementoHijo2.isEmpty()) {
                                        List<WebElement> listaTd2 = elementoHijo2.get(0).findElements(By.tagName("td"));
                                        //listaTd2.stream().forEach(t -> System.out.println(t.getText()));
                                        //IntStream.range(0, listaTd2.size()).forEach(t -> System.out.println(t + " -> " + listaTd2.get(t).getAttribute("innerText")));   
                                        int k = 1;
                                        for (int i = 0; i < listaTd2.size(); i += 5) {
                                            Inversion proyCont = new Inversion();
                                            proyCont.setProyCodigoSiaf(codigoSiaf);
                                            proyCont.setPrcoOrden(k);
                                            proyCont.setPrcoContratista(listaTd2.get(i).getAttribute("innerText"));
                                            proyCont.setPrcoTipoProceso(listaTd2.get(i + 1).getAttribute("innerText"));
                                            proyCont.setPrcoContrato(listaTd2.get(i + 2).getAttribute("innerText"));
                                            Date dateCont = null;
                                            try {
                                                dateCont = dateFormat.parse(listaTd2.get(i + 3).getAttribute("innerText"));
                                            } catch (ParseException ex) {
                                                Logger.getLogger(SIRSAM_Bot.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            GregorianCalendar calCont = new GregorianCalendar();
                                            calCont.setTime(dateCont);
                                            XMLGregorianCalendar xmlGregCalCont = null;
                                            try {
                                                xmlGregCalCont = DatatypeFactory.newInstance().newXMLGregorianCalendar(calCont);
                                            } catch (DatatypeConfigurationException ex) {
                                                Logger.getLogger(SIRSAM_Bot.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            proyCont.setPrcoFechaSuscripcion(xmlGregCalCont);
                                            String[] partCont = listaTd2.get(i + 4).getAttribute("innerText").split("S/.");
                                            proyCont.setPrcoMontoSuscripcion(new BigDecimal(partCont[1].replaceAll(",", "")));
                                            LocalDateTime ldtCont = LocalDateTime.now();
                                            long timeCont = ldtCont.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                            String tablaCont = "proyecto_contrataciones";
                                            port.upsertProyectoContrataciones(proyCont, timeCont, tablaCont, codigoSiaf, host, ip);
                                            k++;
                                        }
                                    }
                                }

                                String codHref1 = listaTab1.get(0).getAttribute("innerHTML");
                                String codHref2 = listaTab1.get(2).getAttribute("innerHTML");

                                if (!codHref1.contains("href") && !codHref2.contains("href")) {

                                    proy.setProyCodigoInversion("");
                                    proy.setProyTipo("invierte.pe");
                                    proy.setProyUnidadEjecutora("");
                                    proy.setProyUnidadEjecutoraInversion("");
                                    proy.setProyUnidadEjecutoraPresupuestal("");
                                    proy.setProyObjetivo("");

                                    LocalDateTime ldt = LocalDateTime.now();
                                    long time = ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                    String tabla = "proyecto";
                                    port.upsertProyecto(proy, time, tabla, codigoSiaf, host, ip);

                                }
                                String href = "";
                                if (codHref1.contains("href") && codHref2.contains("href")) {
                                    List<WebElement> listaTdA = listaTab1.get(2).findElements(By.tagName("a"));
                                    href = listaTdA.get(0).getAttribute("href");
                                }
                                if (codHref1.contains("href") && !codHref2.contains("href")) {
                                    List<WebElement> listaTdA = listaTab1.get(0).findElements(By.tagName("a"));
                                    href = listaTdA.get(0).getAttribute("href");
                                }
                                if (!codHref1.contains("href") && codHref2.contains("href")) {
                                    List<WebElement> listaTdA = listaTab1.get(2).findElements(By.tagName("a"));
                                    href = listaTdA.get(0).getAttribute("href");
                                }

                                String partHref = href.substring(0, 11);
                                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                                driver.get(href);

                                if (partHref.equals("http://ofi4")) {

                                    String codigoInv = href.split("txtCodigo=")[1];
                                    proy.setProyCodigoInversion(codigoInv);
                                    proy.setProyTipo("snip");

                                    // Cambiamos al frame superior
                                    driver.switchTo().frame(driver.findElement(By.name("superior")));

                                    List<WebElement> listaFontSup = driver.findElements(By.tagName("font"));
                                    WebElement fontSup = listaFontSup.get(0);

                                    if (fontSup.getAttribute("innerText").trim().toLowerCase().contains("error")) {

                                        proy.setProyUnidadEjecutora("");
                                        proy.setProyUnidadEjecutoraInversion("");
                                        proy.setProyUnidadEjecutoraPresupuestal("");
                                        proy.setProyObjetivo("");
                                        LocalDateTime ldt = LocalDateTime.now();
                                        long time = ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                        String tabla = "proyecto";
                                        port.upsertProyecto(proy, time, tabla, codigoSiaf, host, ip);

                                    } else {

                                        List<WebElement> listaTabSup = driver.findElements(By.tagName("table"));
                                        WebElement elementoTabSup = listaTabSup.get(1);
                                        List<WebElement> listTrSup = elementoTabSup.findElements(By.tagName("tr"));
                                        WebElement trReg = listTrSup.get(3);
                                        String registros = trReg.getAttribute("innerText").toLowerCase();
                                        boolean tieneReg = registros.contains("registros en la fase de inversion");

                                        // Retornamos a la página
                                        driver.switchTo().defaultContent();

                                        // Cambiamos al frame inferior
                                        driver.switchTo().frame(driver.findElement(By.name("inferior")));
                                        WebElement elementoHeadInf = driver.findElement(By.tagName("head"));
                                        WebElement elementoTitInf = elementoHeadInf.findElement(By.tagName("title"));
                                        String tituloInf = elementoTitInf.getAttribute("innerText").toLowerCase();

                                        if (tituloInf.contains("intranet del banco de proyectos")) {
                                            // Cambiamos al frame dentro del frame inferior
                                            driver.switchTo().frame(driver.findElement(By.name("principal")));

                                            WebElement elementBody = driver.findElement(By.tagName("body"));
                                            List<WebElement> listaBodyP = elementBody.findElements(By.tagName("p"));

                                            if (listaBodyP.get(0).getAttribute("innerText").toLowerCase().contains("formato snip-3a")) {

                                                List<WebElement> listaFr2 = driver.findElements(By.tagName("table"));
                                                //IntStream.range(0, listaFr2.size()).forEach(p -> System.out.println(p + " -> " + listaFr2.get(p).getAttribute("innerText")));

                                                WebElement elementoFr2_7 = listaFr2.get(7);
                                                List<WebElement> listaEjecutora = elementoFr2_7.findElements(By.tagName("td"));
                                                //IntStream.range(0, listaEjecutora.size()).forEach(t -> System.out.println(t + " -> " + listaEjecutora.get(t).getAttribute("innerText")));
                                                String unidad_ejecutora;
                                                if (listaEjecutora.size() > 4) {
                                                    unidad_ejecutora = listaEjecutora.get(5).getAttribute("innerText") + System.lineSeparator()
                                                            + listaEjecutora.get(1).getAttribute("innerText") + " - " + listaEjecutora.get(3).getAttribute("innerText");
                                                } else {
                                                    unidad_ejecutora = listaEjecutora.get(1).getAttribute("innerText") + " - " + listaEjecutora.get(3).getAttribute("innerText");
                                                }
                                                proy.setProyUnidadEjecutora(unidad_ejecutora);
                                                proy.setProyUnidadEjecutoraInversion("");
                                                proy.setProyUnidadEjecutoraPresupuestal("");

                                                WebElement elementObj = driver.findElement(By.id("lblObjetivo"));
                                                String textObj = elementObj.getAttribute("innerText").trim();
                                                //System.out.println(textObj);
                                                proy.setProyObjetivo(textObj);

                                                LocalDateTime ldt = LocalDateTime.now();
                                                long time = ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                                String tabla = "proyecto";
                                                port.upsertProyecto(proy, time, tabla, codigoSiaf, host, ip);

                                                List<WebElement> listaTables = driver.findElements(By.className("tablas"));
                                                //IntStream.range(0, listaTables.size()).forEach(tab -> System.out.println(tab + " -> " + listaTables.get(tab).getAttribute("innerHTML")));

                                                WebElement tableComp6 = listaTables.get(6);
                                                WebElement tableComp8 = listaTables.get(8);

                                                List<WebElement> listCompTd6 = tableComp6.findElements(By.tagName("td"));
                                                int sizeTd6 = listCompTd6.size();

                                                List<WebElement> listCompTr8 = tableComp8.findElements(By.tagName("tr"));
                                                int sizeTr8 = listCompTr8.size();

                                                int idxCost = 0;
                                                for (int j = 1; j < sizeTr8 - 1; j++) {
                                                    WebElement compTr8_j = listCompTr8.get(j);
                                                    List<WebElement> listCompTd8_j = compTr8_j.findElements(By.tagName("td"));
                                                    String comp = listCompTd8_j.get(0).getAttribute("innerText").trim();
                                                    if (comp.toLowerCase().contains("costo directo")) {
                                                        idxCost = j;
                                                    }
                                                }

                                                for (int k = 1; k < sizeTr8 - 1; k++) {
                                                    WebElement compTr8_k = listCompTr8.get(k);
                                                    List<WebElement> listCompTd8_k = compTr8_k.findElements(By.tagName("td"));
                                                    Inversion proyComp = new Inversion();
                                                    proyComp.setProyCodigoSiaf(codigoSiaf);
                                                    proyComp.setPrcpOrden(k);
                                                    proyComp.setPrcpUnidadMedida(listCompTd8_k.get(1).getAttribute("innerText").trim());
                                                    String monto_reg = listCompTd8_k.get(4).getText().replaceAll(",", "");
                                                    proyComp.setPrcpMontoViable(new BigDecimal(monto_reg.replaceAll("\\s", "")));
                                                    String comp1 = listCompTd8_k.get(0).getAttribute("innerText").trim();
                                                    if (k >= 1 && k < idxCost) {
                                                        proyComp.setPrcpComponente(comp1.split("\\.")[1].trim());
                                                    }
                                                    if (k >= idxCost && k < idxCost + sizeTd6) {
                                                        String comp2 = listCompTd6.get(k - idxCost).getAttribute("innerText").trim();
                                                        proyComp.setPrcpComponente(comp2.split("\\:")[1].trim());
                                                    }
                                                    if (k >= idxCost + sizeTd6 && k < sizeTr8 - 1) {
                                                        proyComp.setPrcpComponente(comp1.split("\\.")[1].trim());
                                                    }
                                                    LocalDateTime ldtComp = LocalDateTime.now();
                                                    long timeComp = ldtComp.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                                    String tablaComp = "proyecto_componentes";
                                                    port.upsertProyectoComponentes(proyComp, timeComp, tablaComp, codigoSiaf, host, ip);
                                                }

                                                WebElement elementoFr2_8 = listaFr2.get(8);
                                                List<WebElement> listaUbigeo = elementoFr2_8.findElements(By.tagName("td"));
                                                //IntStream.range(0, listaUbigeo.size()).forEach(p -> System.out.println(p + " -> " + listaUbigeo.get(p).getAttribute("innerText")));
                                                if (listaUbigeo.size() / 4 > 1) {
                                                    for (int j = 4; j < listaUbigeo.size(); j += 4) {
                                                        Inversion proyUbig = new Inversion();
                                                        proyUbig.setProyCodigoSiaf(codigoSiaf);
                                                        proyUbig.setPrubDepartamento(listaUbigeo.get(j).getAttribute("innerText"));
                                                        proyUbig.setPrubProvincia(listaUbigeo.get(j + 1).getAttribute("innerText"));
                                                        proyUbig.setPrubDistrito(listaUbigeo.get(j + 2).getAttribute("innerText"));
                                                        proyUbig.setPrubLocalidad(listaUbigeo.get(j + 3).getAttribute("innerText"));
                                                        LocalDateTime ldtUbig = LocalDateTime.now();
                                                        long timeUbig = ldtUbig.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                                        String tablaUbig = "proyecto_ubicacion";
                                                        port.upsertProyectoUbicacion(proyUbig, timeUbig, tablaUbig, codigoSiaf, host, ip);
                                                    }
                                                }

                                            }
                                            if (listaBodyP.get(0).getAttribute("innerText").toLowerCase().contains("formato snip-03")) {
                                                List<WebElement> listaFr2 = driver.findElements(By.tagName("table"));

                                                WebElement elementoFr2_8 = listaFr2.get(8);
                                                List<WebElement> listaEjecutora = elementoFr2_8.findElements(By.tagName("td"));
                                                //IntStream.range(0, listaEjecutora.size()).forEach(t -> System.out.println(t + " -> " + listaEjecutora.get(t).getAttribute("innerText")));
                                                String unidad_ejecutora;
                                                if (listaEjecutora.size() > 4) {
                                                    unidad_ejecutora = listaEjecutora.get(5).getAttribute("innerText") + System.lineSeparator()
                                                            + listaEjecutora.get(1).getAttribute("innerText") + " - " + listaEjecutora.get(3).getAttribute("innerText");
                                                } else {
                                                    unidad_ejecutora = listaEjecutora.get(1).getAttribute("innerText") + " - " + listaEjecutora.get(3).getAttribute("innerText");
                                                }
                                                proy.setProyUnidadEjecutora(unidad_ejecutora);
                                                proy.setProyUnidadEjecutoraInversion("");
                                                proy.setProyUnidadEjecutoraPresupuestal("");

                                                WebElement elementoFr2_3 = listaFr2.get(3);
                                                String textoFicha = elementoFr2_3.getAttribute("innerText");
                                                String textObjPart = textoFicha.split("3.3	Objetivo del Proyecto de Inversión Pública")[1];
                                                String textObj = textObjPart.split("3.4	Análisis de la demanda y oferta")[0].trim();
                                                proy.setProyObjetivo(textObj);

                                                LocalDateTime ldt = LocalDateTime.now();
                                                long time = ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                                String tabla = "proyecto";
                                                port.upsertProyecto(proy, time, tabla, codigoSiaf, host, ip);

                                                List<WebElement> listaTables = driver.findElements(By.className("tablas"));
                                                //IntStream.range(0, listaTables.size()).forEach(tab -> System.out.println(tab + " -> " + listaTables.get(tab).getAttribute("innerHTML")));

                                                WebElement tableComp2 = listaTables.get(2);
                                                List<WebElement> listCompTd2 = tableComp2.findElements(By.tagName("td"));

                                                if (listCompTd2.get(0).getText().toLowerCase().toLowerCase().equals("departamento")) {

                                                    WebElement tableComp3 = listaTables.get(3);
                                                    List<WebElement> listCompTd3 = tableComp3.findElements(By.tagName("td"));
                                                    if (listCompTd3.get(0).getText().toLowerCase().toLowerCase().equals("tramo")) {
                                                        WebElement tableComp6 = listaTables.get(6);
                                                        WebElement tableComp7 = listaTables.get(7);
                                                        List<WebElement> listCompTr6 = tableComp6.findElements(By.tagName("tr"));
                                                        List<WebElement> listCompTr7 = tableComp7.findElements(By.tagName("tr"));
                                                        int sizeTr6 = listCompTr6.size();
                                                        WebElement compTr6_1 = listCompTr6.get(1);
                                                        List<WebElement> listCompTd6_1 = compTr6_1.findElements(By.tagName("td"));
                                                        int sizeTd6_1 = listCompTd6_1.size();

                                                        for (int k = 2; k < sizeTr6 - 1; k++) {
                                                            WebElement compTr6_k = listCompTr6.get(k);
                                                            WebElement compTr7_k = listCompTr7.get(k);
                                                            List<WebElement> listCompTd6_k = compTr6_k.findElements(By.tagName("td"));
                                                            List<WebElement> listCompTd7_k = compTr7_k.findElements(By.tagName("td"));
                                                            Inversion proyComp = new Inversion();
                                                            proyComp.setProyCodigoSiaf(codigoSiaf);
                                                            proyComp.setPrcpComponente(listCompTd6_k.get(0).getAttribute("innerText").trim());
                                                            proyComp.setPrcpOrden(k - 1);
                                                            proyComp.setPrcpUnidadMedida(listCompTd7_k.get(1).getAttribute("innerText").trim());
                                                            String monto_reg = listCompTd6_k.get(sizeTd6_1).getText().replaceAll(",", "");
                                                            proyComp.setPrcpMontoViable(new BigDecimal(monto_reg.replaceAll("\\s", "")));
                                                            LocalDateTime ldtComp = LocalDateTime.now();
                                                            long timeComp = ldtComp.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                                            String tablaComp = "proyecto_componentes";
                                                            port.upsertProyectoComponentes(proyComp, timeComp, tablaComp, codigoSiaf, host, ip);
                                                        }
                                                    } else {
                                                        WebElement tableComp5 = listaTables.get(5);
                                                        WebElement tableComp6 = listaTables.get(6);
                                                        List<WebElement> listCompTr5 = tableComp5.findElements(By.tagName("tr"));
                                                        List<WebElement> listCompTr6 = tableComp6.findElements(By.tagName("tr"));
                                                        int sizeTr5 = listCompTr5.size();
                                                        WebElement compTr5_1 = listCompTr5.get(1);
                                                        List<WebElement> listCompTd5_1 = compTr5_1.findElements(By.tagName("td"));
                                                        int sizeTd5_1 = listCompTd5_1.size();

                                                        for (int k = 2; k < sizeTr5 - 1; k++) {
                                                            WebElement compTr5_k = listCompTr5.get(k);
                                                            WebElement compTr6_k = listCompTr6.get(k);
                                                            List<WebElement> listCompTd5_k = compTr5_k.findElements(By.tagName("td"));
                                                            List<WebElement> listCompTd6_k = compTr6_k.findElements(By.tagName("td"));
                                                            Inversion proyComp = new Inversion();
                                                            proyComp.setProyCodigoSiaf(codigoSiaf);
                                                            proyComp.setPrcpComponente(listCompTd5_k.get(0).getAttribute("innerText").trim());
                                                            proyComp.setPrcpOrden(k - 1);
                                                            proyComp.setPrcpUnidadMedida(listCompTd6_k.get(1).getAttribute("innerText").trim());
                                                            String monto_reg = listCompTd5_k.get(sizeTd5_1).getText().replaceAll(",", "");
                                                            proyComp.setPrcpMontoViable(new BigDecimal(monto_reg.replaceAll("\\s", "")));
                                                            LocalDateTime ldtComp = LocalDateTime.now();
                                                            long timeComp = ldtComp.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                                            String tablaComp = "proyecto_componentes";
                                                            port.upsertProyectoComponentes(proyComp, timeComp, tablaComp, codigoSiaf, host, ip);
                                                        }
                                                    }

                                                }

                                                if (listCompTd2.get(0).getText().toLowerCase().toLowerCase().equals("tramo")) {
                                                    WebElement tableComp5 = listaTables.get(5);
                                                    WebElement tableComp6 = listaTables.get(6);
                                                    List<WebElement> listCompTr5 = tableComp5.findElements(By.tagName("tr"));
                                                    List<WebElement> listCompTr6 = tableComp6.findElements(By.tagName("tr"));
                                                    int sizeTr5 = listCompTr5.size();
                                                    WebElement compTr5_1 = listCompTr5.get(1);
                                                    List<WebElement> listCompTd5_1 = compTr5_1.findElements(By.tagName("td"));
                                                    int sizeTd5_1 = listCompTd5_1.size();

                                                    for (int k = 2; k < sizeTr5 - 1; k++) {
                                                        WebElement compTr5_k = listCompTr5.get(k);
                                                        WebElement compTr6_k = listCompTr6.get(k);
                                                        List<WebElement> listCompTd5_k = compTr5_k.findElements(By.tagName("td"));
                                                        List<WebElement> listCompTd6_k = compTr6_k.findElements(By.tagName("td"));
                                                        Inversion proyComp = new Inversion();
                                                        proyComp.setProyCodigoSiaf(codigoSiaf);
                                                        proyComp.setPrcpComponente(listCompTd5_k.get(0).getAttribute("innerText").trim());
                                                        proyComp.setPrcpOrden(k - 1);
                                                        proyComp.setPrcpUnidadMedida(listCompTd6_k.get(1).getAttribute("innerText").trim());
                                                        String monto_reg = listCompTd5_k.get(sizeTd5_1).getText().replaceAll(",", "");
                                                        proyComp.setPrcpMontoViable(new BigDecimal(monto_reg.replaceAll("\\s", "")));
                                                        LocalDateTime ldtComp = LocalDateTime.now();
                                                        long timeComp = ldtComp.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                                        String tablaComp = "proyecto_componentes";
                                                        port.upsertProyectoComponentes(proyComp, timeComp, tablaComp, codigoSiaf, host, ip);
                                                    }
                                                }

                                                WebElement elementoFr2_5 = listaFr2.get(5);
                                                List<WebElement> listaUbigeo = elementoFr2_5.findElements(By.tagName("td"));
                                                //IntStream.range(0, listaUbigeo.size()).forEach(t -> System.out.println(t + " -> " + listaUbigeo.get(t).getAttribute("innerText")));
                                                if (listaUbigeo.size() / 4 > 1) {
                                                    for (int j = 4; j < listaUbigeo.size(); j += 4) {
                                                        Inversion proyUbig = new Inversion();
                                                        proyUbig.setProyCodigoSiaf(codigoSiaf);
                                                        proyUbig.setPrubDepartamento(listaUbigeo.get(j).getAttribute("innerText"));
                                                        proyUbig.setPrubProvincia(listaUbigeo.get(j + 1).getAttribute("innerText"));
                                                        proyUbig.setPrubDistrito(listaUbigeo.get(j + 2).getAttribute("innerText"));
                                                        proyUbig.setPrubLocalidad(listaUbigeo.get(j + 3).getAttribute("innerText"));
                                                        LocalDateTime ldtUbig = LocalDateTime.now();
                                                        long timeUbig = ldtUbig.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                                        String tablaUbig = "proyecto_ubicacion";
                                                        port.upsertProyectoUbicacion(proyUbig, timeUbig, tablaUbig, codigoSiaf, host, ip);
                                                    }
                                                }
                                            }

                                        }
                                        if (tituloInf.contains("formato pip menor")) {

                                            List<WebElement> listaPip = driver.findElements(By.className("tbl"));

                                            WebElement elementoPip_0 = listaPip.get(0);
                                            List<WebElement> listaPip_0 = elementoPip_0.findElements(By.className("trLinea"));

                                            WebElement elementoPip_0_4 = listaPip_0.get(4);
                                            WebElement tablaEjec = elementoPip_0_4.findElement(By.className("tblIn"));
                                            List<WebElement> listEjec = tablaEjec.findElements(By.tagName("td"));
                                            //IntStream.range(0, listEjec.size()).forEach(it -> System.out.println(it + " -> " + listEjec.get(it).getAttribute("innerText")));
                                            String unidad_ejecutora = listEjec.get(5).getAttribute("innerText") + System.lineSeparator()
                                                    + listEjec.get(1).getAttribute("innerText") + " - " + listEjec.get(3).getAttribute("innerText");
                                            proy.setProyUnidadEjecutora(unidad_ejecutora);
                                            proy.setProyUnidadEjecutoraInversion("");
                                            proy.setProyUnidadEjecutoraPresupuestal("");

                                            WebElement elementoPip_1 = listaPip.get(1);
                                            List<WebElement> listaPip_1 = elementoPip_1.findElements(By.className("trLinea"));

                                            WebElement elementoPip_1_2 = listaPip_1.get(2);
                                            List<WebElement> listObj = elementoPip_1_2.findElements(By.className("Normal"));
                                            //IntStream.range(0, listObj.size()).forEach(it -> System.out.println(it + " -> " + listObj.get(it).getAttribute("innerText")));
                                            String textObj = listObj.get(0).getAttribute("innerText");
                                            proy.setProyObjetivo(textObj);

                                            LocalDateTime ldt = LocalDateTime.now();
                                            long time = ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                            String tabla = "proyecto";
                                            port.upsertProyecto(proy, time, tabla, codigoSiaf, host, ip);

                                            WebElement elementoPip_0_5 = listaPip_0.get(5);
                                            WebElement tablaUbigeo = elementoPip_0_5.findElement(By.id("UC1_tblUbicacion"));
                                            List<WebElement> listaUbigeo = tablaUbigeo.findElements(By.tagName("td"));
                                            //IntStream.range(0, listaUbigeo.size()).forEach(it -> System.out.println(it + " -> " + listaUbigeo.get(it).getAttribute("innerText")));
                                            if (!listaUbigeo.isEmpty()) {
                                                for (int j = 0; j < listaUbigeo.size(); j += 5) {
                                                    Inversion proyUbig = new Inversion();
                                                    proyUbig.setProyCodigoSiaf(codigoSiaf);
                                                    proyUbig.setPrubDepartamento(listaUbigeo.get(j + 1).getAttribute("innerText"));
                                                    proyUbig.setPrubProvincia(listaUbigeo.get(j + 2).getAttribute("innerText"));
                                                    proyUbig.setPrubDistrito(listaUbigeo.get(j + 3).getAttribute("innerText"));
                                                    proyUbig.setPrubLocalidad(listaUbigeo.get(j + 4).getAttribute("innerText"));
                                                    LocalDateTime ldtUbig = LocalDateTime.now();
                                                    long timeUbig = ldtUbig.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                                    String tablaUbig = "proyecto_ubicacion";
                                                    port.upsertProyectoUbicacion(proyUbig, timeUbig, tablaUbig, codigoSiaf, host, ip);
                                                }
                                            }

                                        }

                                        if (tieneReg) {
                                            driver.get("http://ofi5.mef.gob.pe/invierte/ejecucion/traeListaEjecucionSimplePublica/" + codigoInv);
                                            WebElement elementoPadre3 = driver.findElement(By.tagName("tbody"));
                                            List<WebElement> listaHijo3 = elementoPadre3.findElements(By.tagName("td"));
                                            //listaHijo3.stream().forEach(reg -> System.out.println(reg.getAttribute("innerText")));
                                            for (int k = 0; k < listaHijo3.size(); k += 7) {
                                                Inversion proyModif = new Inversion();
                                                proyModif.setProyCodigoSiaf(codigoSiaf);
                                                proyModif.setPrmoFechaModificacion(listaHijo3.get(k).getAttribute("innerText"));
                                                String[] partModif = listaHijo3.get(k + 1).getAttribute("innerText").split("S/.");
                                                proyModif.setPrmoMontoActualizado(new BigDecimal(partModif[1].replaceAll(",", "").trim()));
                                                proyModif.setPrmoComentarios(listaHijo3.get(k + 2).getAttribute("innerText"));
                                                proyModif.setPrmoUsuario(listaHijo3.get(k + 3).getAttribute("innerText"));
                                                proyModif.setPrmoTipoDocumento(listaHijo3.get(k + 4).getAttribute("innerText"));
                                                LocalDateTime ldtModif = LocalDateTime.now();
                                                long timeModif = ldtModif.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                                String tablaModif = "proyecto_modificaciones";
                                                port.upsertProyectoModificaciones(proyModif, timeModif, tablaModif, codigoSiaf, host, ip);
                                            }
                                        }

                                        //driver.quit(); 
                                    }

                                }

                                if (partHref.equals("http://ofi5")) {

                                    String codigoInv = href.split("verProyectoCU/")[1].trim();
                                    proy.setProyCodigoInversion(codigoInv);
                                    proy.setProyTipo("invierte.pe");

                                    WebElement elementoHeadI = driver.findElement(By.id("divVistaPreliminar"));
                                    List<WebElement> listHeadI = elementoHeadI.findElements(By.tagName("div"));
                                    WebElement elementoTitI = listHeadI.get(0);
                                    List<WebElement> listTitI = elementoTitI.findElements(By.tagName("div"));

                                    WebElement elementoTitI_0 = listTitI.get(0);
                                    String tituloInf = elementoTitI_0.getAttribute("innerText").toLowerCase();

                                    boolean tieneReg = false;

                                    if (tituloInf.contains("formato n°01")) {
                                        tieneReg = tituloInf.contains("registros en la fase de ejecución");

                                        List<WebElement> listaTableBody = elementoHeadI.findElements(By.tagName("table"));
                                        //IntStream.range(0, listaTableBody.size()).forEach(m -> System.out.println(m + " -> " + listaTableBody.get(m).getAttribute("innerText")));

                                        WebElement elementoTableBody_4 = listaTableBody.get(4);
                                        List<WebElement> listaEjecutoraInv = elementoTableBody_4.findElements(By.tagName("td"));
                                        //IntStream.range(0, listaEjecutoraInv.size()).forEach(m -> System.out.println(m + " -> " + listaEjecutoraInv.get(m).getAttribute("innerText")));
                                        String unidad_ejecutora_inversion = listaEjecutoraInv.get(5).getAttribute("innerText") + System.lineSeparator()
                                                + listaEjecutoraInv.get(1).getAttribute("innerText") + " - " + listaEjecutoraInv.get(3).getAttribute("innerText");

                                        WebElement elementoTableBody_5 = listaTableBody.get(5);
                                        List<WebElement> listaEjecutoraPre = elementoTableBody_5.findElements(By.tagName("td"));
                                        //IntStream.range(0, listaEjecutoraPre.size()).forEach(m -> System.out.println(m + " -> " + listaEjecutoraPre.get(m).getAttribute("innerText")));
                                        String unidad_ejecutora_presupuestal = listaEjecutoraPre.get(1).getAttribute("innerText");
                                        proy.setProyUnidadEjecutora("");
                                        proy.setProyUnidadEjecutoraInversion(unidad_ejecutora_inversion);
                                        proy.setProyUnidadEjecutoraPresupuestal(unidad_ejecutora_presupuestal);

                                        List<WebElement> listaTables = driver.findElements(By.className("table"));
                                        //IntStream.range(0, listaTables.size()).forEach(tab -> System.out.println(tab + " -> " + listaTables.get(tab).getAttribute("innerHTML")));

                                        WebElement tableComp;
                                        WebElement elementoTableBodyObj;
                                        String textComp9 = listaTables.get(9).getAttribute("innerText");
                                        if (textComp9.toLowerCase().contains("1.4 ámbito de influencia")) {
                                            elementoTableBodyObj = listaTableBody.get(11);
                                            tableComp = listaTables.get(18);
                                        } else {
                                            elementoTableBodyObj = listaTableBody.get(10);
                                            tableComp = listaTables.get(17);
                                        }

                                        List<WebElement> listaObjetivo = elementoTableBodyObj.findElements(By.tagName("td"));
                                        //IntStream.range(0, listaObjetivo.size()).forEach(m -> System.out.println(m + " -> " + listaObjetivo.get(m).getAttribute("innerText")));
                                        String textObj = listaObjetivo.get(1).getAttribute("innerText");
                                        proy.setProyObjetivo(textObj);

                                        LocalDateTime ldt = LocalDateTime.now();
                                        long time = ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                        String tabla = "proyecto";
                                        port.upsertProyecto(proy, time, tabla, codigoSiaf, host, ip);

                                        WebElement bodyComp = tableComp.findElement(By.tagName("tbody"));
                                        List<WebElement> listCompTr = bodyComp.findElements(By.tagName("tr"));
                                        int sizeTr = listCompTr.size();
                                        WebElement compTr_0 = listCompTr.get(0);
                                        List<WebElement> listCompTd_0 = compTr_0.findElements(By.tagName("td"));
                                        int sizeColTd = listCompTd_0.size();

                                        int countC = 1;
                                        for (int k = 0; k < sizeTr - 1; k++) {
                                            WebElement compTr_k = listCompTr.get(k);
                                            List<WebElement> listCompTd_k = compTr_k.findElements(By.tagName("td"));
                                            String comp = listCompTd_k.get(0).getAttribute("innerText").trim();
                                            if (comp.toLowerCase().contains("subtotal")) {
                                            } else {
                                                Inversion proyComp = new Inversion();
                                                proyComp.setProyCodigoSiaf(codigoSiaf);
                                                proyComp.setPrcpComponente(comp);
                                                proyComp.setPrcpOrden(countC);
                                                proyComp.setPrcpUnidadMedida(null);
                                                String monto_reg = listCompTd_k.get(sizeColTd - 1).getText().replaceAll(",", "");
                                                proyComp.setPrcpMontoViable(new BigDecimal(monto_reg.replaceAll("\\s", "")));
                                                LocalDateTime ldtComp = LocalDateTime.now();
                                                long timeComp = ldtComp.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                                String tablaComp = "proyecto_componentes";
                                                port.upsertProyectoComponentes(proyComp, timeComp, tablaComp, codigoSiaf, host, ip);
                                                countC++;
                                            }
                                        }

                                        WebElement elementoTableBody_8 = listaTableBody.get(8);
                                        List<WebElement> listaUbigeo = elementoTableBody_8.findElements(By.tagName("td"));
                                        //IntStream.range(0, listaUbigeo.size()).forEach(it -> System.out.println(it + " -> " + listaUbigeo.get(it).getAttribute("innerText")));
                                        if (!listaUbigeo.isEmpty()) {
                                            for (int j = 0; j < listaUbigeo.size(); j += 5) {
                                                Inversion proyUbig = new Inversion();
                                                proyUbig.setProyCodigoSiaf(codigoSiaf);
                                                proyUbig.setPrubDepartamento(listaUbigeo.get(j + 1).getAttribute("innerText"));
                                                proyUbig.setPrubProvincia(listaUbigeo.get(j + 2).getAttribute("innerText"));
                                                proyUbig.setPrubDistrito(listaUbigeo.get(j + 3).getAttribute("innerText"));
                                                proyUbig.setPrubLocalidad(listaUbigeo.get(j + 4).getAttribute("innerText"));
                                                LocalDateTime ldtUbig = LocalDateTime.now();
                                                long timeUbig = ldtUbig.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                                String tablaUbig = "proyecto_ubicacion";
                                                port.upsertProyectoUbicacion(proyUbig, timeUbig, tablaUbig, codigoSiaf, host, ip);
                                            }
                                        }

                                    }

                                    if (tituloInf.contains("formato n°02")) {
                                        WebElement elementoTitI_1 = listTitI.get(1);
                                        String tituloInfS = elementoTitI_1.getAttribute("innerText").toLowerCase();
                                        tieneReg = tituloInfS.contains("registros en la fase de ejecución");

                                        List<WebElement> listaTableBody = elementoHeadI.findElements(By.tagName("table"));
                                        //IntStream.range(0, listaTableBody.size()).forEach(m -> System.out.println(m + " -> " + listaTableBody.get(m).getAttribute("innerText")));

                                        WebElement elementoTableBody_2 = listaTableBody.get(2);
                                        List<WebElement> listaEjecutoraInv = elementoTableBody_2.findElements(By.tagName("td"));
                                        //IntStream.range(0, listaEjecutoraInv.size()).forEach(m -> System.out.println(m + " -> " + listaEjecutoraInv.get(m).getAttribute("innerText")));
                                        String unidad_ejecutora_inversion = listaEjecutoraInv.get(5).getAttribute("innerText") + System.lineSeparator()
                                                + listaEjecutoraInv.get(1).getAttribute("innerText") + " - " + listaEjecutoraInv.get(3).getAttribute("innerText");

                                        WebElement elementoTableBody_3 = listaTableBody.get(3);
                                        List<WebElement> listaEjecutoraPre = elementoTableBody_3.findElements(By.tagName("td"));
                                        //IntStream.range(0, listaEjecutoraPre.size()).forEach(m -> System.out.println(m + " -> " + listaEjecutoraPre.get(m).getAttribute("innerText")));
                                        String unidad_ejecutora_presupuestal = listaEjecutoraPre.get(1).getAttribute("innerText");
                                        proy.setProyUnidadEjecutora("");
                                        proy.setProyUnidadEjecutoraInversion(unidad_ejecutora_inversion);
                                        proy.setProyUnidadEjecutoraPresupuestal(unidad_ejecutora_presupuestal);

                                        WebElement elementoTableBody_5 = listaTableBody.get(5);
                                        List<WebElement> listaObjetivo = elementoTableBody_5.findElements(By.tagName("td"));
                                        //IntStream.range(0, listaObjetivo.size()).forEach(m -> System.out.println(m + " -> " + listaObjetivo.get(m).getAttribute("innerText")));
                                        String textObj = listaObjetivo.get(1).getAttribute("innerText");
                                        proy.setProyObjetivo(textObj);

                                        LocalDateTime ldt = LocalDateTime.now();
                                        long time = ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                        String tabla = "proyecto";
                                        port.upsertProyecto(proy, time, tabla, codigoSiaf, host, ip);

                                        List<WebElement> listaTables = driver.findElements(By.className("table"));
                                        //IntStream.range(0, listaTables.size()).forEach(tab -> System.out.println(tab + " -> " + listaTables.get(tab).getAttribute("innerHTML")));

                                        WebElement tableComp8 = listaTables.get(8);
                                        WebElement bodyComp8 = tableComp8.findElement(By.tagName("tbody"));
                                        List<WebElement> listCompTr8 = bodyComp8.findElements(By.tagName("tr"));

                                        int sizeAct = listCompTr8.size() - 2;

                                        WebElement tableCompB = listaTables.get(12);
                                        WebElement tableCaptB = tableCompB.findElement(By.tagName("caption"));
                                        WebElement tableCompC;
                                        int idxC;
                                        if (tableCaptB.getText().trim().toLowerCase().contains("b.1 descripción del estado situacional")) {
                                            idxC = 14 + (3 * sizeAct);
                                            tableCompC = listaTables.get(14 + (3 * sizeAct));
                                        } else {
                                            idxC = 12;
                                            tableCompC = listaTables.get(12);
                                        }
                                        WebElement tableCaptC = tableCompC.findElement(By.tagName("caption"));
                                        WebElement tableCompTab1;
                                        WebElement tableCompTab2;
                                        if (tableCaptC.getText().trim().toLowerCase().contains("causas de deterioro o daño")) {
                                            int idxTab = (2 * sizeAct);
                                            WebElement tableCompCR = listaTables.get(idxC + idxTab);
                                            WebElement tableCaptCR = tableCompCR.findElement(By.tagName("caption"));
                                            if (tableCaptCR.getText().trim().toLowerCase().contains("causas de deterioro o daño")) {
                                                tableCompTab1 = listaTables.get(idxC + (idxTab * sizeAct) + 1);
                                                tableCompTab2 = listaTables.get(idxC + (idxTab * sizeAct) + 8);
                                            } else {
                                                tableCompTab1 = listaTables.get(idxC + idxTab + 1);
                                                tableCompTab2 = listaTables.get(idxC + idxTab + 8);
                                            }
                                        } else if (tableCaptC.getText().trim().toLowerCase().contains("modifica capacidad")) {
                                            int idxTab = sizeAct;
                                            WebElement tableCompCR = listaTables.get(idxC + idxTab);
                                            WebElement tableCaptCR = tableCompCR.findElement(By.tagName("caption"));
                                            if (tableCaptCR.getText().trim().toLowerCase().contains("modifica capacidad")) {
                                                tableCompTab1 = listaTables.get(idxC + (idxTab * sizeAct) + 1);
                                                tableCompTab2 = listaTables.get(idxC + (idxTab * sizeAct) + 8);
                                            } else {
                                                tableCompTab1 = listaTables.get(idxC + idxTab + 1);
                                                tableCompTab2 = listaTables.get(idxC + idxTab + 8);
                                            }
                                        } else {
                                            tableCompTab1 = listaTables.get(idxC + 1);
                                            tableCompTab2 = listaTables.get(idxC + 8);
                                        }

                                        WebElement bodyCompTab1 = tableCompTab1.findElement(By.tagName("tbody"));
                                        List<WebElement> listCompTrTab1 = bodyCompTab1.findElements(By.tagName("tr"));
                                        int sizeTrTab1 = listCompTrTab1.size();
                                        WebElement compTdTab1_0 = listCompTrTab1.get(0);
                                        List<WebElement> listCompThTab1_0 = compTdTab1_0.findElements(By.tagName("th"));
                                        int sizeThTab1_0 = listCompThTab1_0.size();

                                        WebElement compTdTab1_1 = listCompTrTab1.get(1);
                                        List<WebElement> listCompTdTab1_1 = compTdTab1_1.findElements(By.tagName("td"));
                                        String textTab1 = listCompTdTab1_1.get(0).getText().trim().toLowerCase();
                                        WebElement compTdTr8_1 = listCompTr8.get(1);
                                        List<WebElement> listCompTdTr8_1 = compTdTr8_1.findElements(By.tagName("td"));
                                        String textTabI = listCompTdTr8_1.get(3).getText().trim().toLowerCase();

                                        int countC = 1;
                                        if (textTab1.contains(textTabI)) {
                                            for (int k = 1; k < sizeTrTab1 - 1; k++) {
                                                WebElement compTrTab1_k = listCompTrTab1.get(k);
                                                List<WebElement> listCompTdTab1_k = compTrTab1_k.findElements(By.tagName("td"));
                                                Inversion proyComp = new Inversion();
                                                proyComp.setProyCodigoSiaf(codigoSiaf);
                                                proyComp.setPrcpOrden(countC);
                                                if (k >= 1 && k <= sizeAct) {
                                                    WebElement compTdTr8_k = listCompTr8.get(k);
                                                    List<WebElement> listCompTdTr8_k = compTdTr8_k.findElements(By.tagName("td"));
                                                    proyComp.setPrcpComponente(listCompTdTr8_k.get(2).getAttribute("innerText").trim()
                                                            + " - " + listCompTdTab1_k.get(0).getAttribute("innerText").trim());
                                                }
                                                if (k > sizeAct) {
                                                    proyComp.setPrcpComponente(listCompTdTab1_k.get(0).getAttribute("innerText").trim());
                                                }
                                                proyComp.setPrcpUnidadMedida(null);
                                                String monto_reg = listCompTdTab1_k.get(sizeThTab1_0 - 1).getAttribute("innerText").trim().replaceAll(",", "");
                                                proyComp.setPrcpMontoViable(new BigDecimal(monto_reg.replaceAll("\\s", "")));
                                                LocalDateTime ldtComp = LocalDateTime.now();
                                                long timeComp = ldtComp.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                                String tablaComp = "proyecto_componentes";
                                                port.upsertProyectoComponentes(proyComp, timeComp, tablaComp, codigoSiaf, host, ip);
                                                countC++;
                                            }
                                        } else {
                                            for (int k = 1; k < sizeTrTab1 - 1; k++) {
                                                WebElement compTrTab1_k = listCompTrTab1.get(k);
                                                List<WebElement> listCompTdTab1_k = compTrTab1_k.findElements(By.tagName("td"));
                                                Inversion proyComp = new Inversion();
                                                proyComp.setProyCodigoSiaf(codigoSiaf);
                                                proyComp.setPrcpOrden(countC);
                                                proyComp.setPrcpComponente(listCompTdTab1_k.get(0).getAttribute("innerText").trim());
                                                proyComp.setPrcpUnidadMedida(null);
                                                String monto_reg = listCompTdTab1_k.get(sizeThTab1_0 - 1).getAttribute("innerText").trim().replaceAll(",", "");
                                                proyComp.setPrcpMontoViable(new BigDecimal(monto_reg.replaceAll("\\s", "")));
                                                LocalDateTime ldtComp = LocalDateTime.now();
                                                long timeComp = ldtComp.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                                String tablaComp = "proyecto_componentes";
                                                port.upsertProyectoComponentes(proyComp, timeComp, tablaComp, codigoSiaf, host, ip);
                                                countC++;
                                            }
                                        }

                                        WebElement bodyCompTab2 = tableCompTab2.findElement(By.tagName("tbody"));
                                        List<WebElement> listCompTrTab2 = bodyCompTab2.findElements(By.tagName("tr"));
                                        int sizeTrTab2 = listCompTrTab2.size();

                                        for (int k = 1; k < sizeTrTab2 - 1; k++) {
                                            WebElement compTrTab2_k = listCompTrTab2.get(k);
                                            List<WebElement> listCompTdTab2_k = compTrTab2_k.findElements(By.tagName("td"));
                                            WebElement compTdTab2 = listCompTdTab2_k.get(0);
                                            String cols = compTdTab2.getAttribute("colspan") == null ? "" : compTdTab2.getAttribute("colspan");
                                            if (!cols.equals("4")) {
                                                Inversion proyComp = new Inversion();
                                                proyComp.setProyCodigoSiaf(codigoSiaf);
                                                proyComp.setPrcpOrden(countC);
                                                proyComp.setPrcpComponente(listCompTdTab2_k.get(2).getAttribute("innerText").trim()
                                                        + " - " + listCompTdTab2_k.get(3).getAttribute("innerText").trim());
                                                proyComp.setPrcpUnidadMedida(listCompTdTab2_k.get(4).getAttribute("innerText").trim());
                                                String monto_reg = listCompTdTab2_k.get(6).getText().replaceAll(",", "");
                                                proyComp.setPrcpMontoViable(new BigDecimal(monto_reg.replaceAll("\\s", "")));
                                                LocalDateTime ldtComp = LocalDateTime.now();
                                                long timeComp = ldtComp.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                                String tablaComp = "proyecto_componentes";
                                                port.upsertProyectoComponentes(proyComp, timeComp, tablaComp, codigoSiaf, host, ip);
                                                countC++;
                                            }
                                        }

                                        WebElement elementoTableBody_7 = listaTableBody.get(7);
                                        List<WebElement> listaUbigeo = elementoTableBody_7.findElements(By.tagName("td"));
                                        //IntStream.range(0, listaUbigeo.size()).forEach(it -> System.out.println(it + " -> " + listaUbigeo.get(it).getAttribute("innerText")));
                                        if (!listaUbigeo.isEmpty()) {
                                            for (int j = 0; j < listaUbigeo.size(); j += 5) {
                                                Inversion proyUbig = new Inversion();
                                                proyUbig.setProyCodigoSiaf(codigoSiaf);
                                                proyUbig.setPrubDepartamento(listaUbigeo.get(j + 1).getAttribute("innerText"));
                                                proyUbig.setPrubProvincia(listaUbigeo.get(j + 2).getAttribute("innerText"));
                                                proyUbig.setPrubDistrito(listaUbigeo.get(j + 3).getAttribute("innerText"));
                                                proyUbig.setPrubLocalidad(listaUbigeo.get(j + 4).getAttribute("innerText"));
                                                LocalDateTime ldtUbig = LocalDateTime.now();
                                                long timeUbig = ldtUbig.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                                String tablaUbig = "proyecto_ubicacion";
                                                port.upsertProyectoUbicacion(proyUbig, timeUbig, tablaUbig, codigoSiaf, host, ip);
                                            }
                                        }

                                    }

                                    if (tieneReg) {
                                        driver.get("http://ofi5.mef.gob.pe/invierte/ejecucion/traeListaEjecucionSimplePublica/" + codigoInv);
                                        WebElement elementoPadre3 = driver.findElement(By.tagName("tbody"));
                                        List<WebElement> listaHijo3 = elementoPadre3.findElements(By.tagName("td"));
                                        //listaHijo3.stream().forEach(reg -> System.out.println(reg.getAttribute("innerText")));
                                        for (int k = 0; k < listaHijo3.size(); k += 7) {
                                            Inversion proyModif = new Inversion();
                                            proyModif.setProyCodigoSiaf(codigoSiaf);
                                            proyModif.setPrmoFechaModificacion(listaHijo3.get(k).getAttribute("innerText"));
                                            String[] partModif = listaHijo3.get(k + 1).getAttribute("innerText").split("S/.");
                                            proyModif.setPrmoMontoActualizado(new BigDecimal(partModif[1].replaceAll(",", "").trim()));
                                            proyModif.setPrmoComentarios(listaHijo3.get(k + 2).getAttribute("innerText"));
                                            proyModif.setPrmoUsuario(listaHijo3.get(k + 3).getAttribute("innerText"));
                                            proyModif.setPrmoTipoDocumento(listaHijo3.get(k + 4).getAttribute("innerText"));
                                            LocalDateTime ldtModif = LocalDateTime.now();
                                            long timeModif = ldtModif.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
                                            String tablaModif = "proyecto_modificaciones";
                                            port.upsertProyectoModificaciones(proyModif, timeModif, tablaModif, codigoSiaf, host, ip);
                                        }
                                    }
                                }
                            }
                        }
                        LocalDate ldCod = LocalDate.now();
                        int yearCod = ldCod.getYear();
                        int monthCod = ldCod.getMonthValue();
                        int dayCod = ldCod.getDayOfMonth();
                        port.updateLogsBotCod(codigoSiaf, yearCod, monthCod, dayCod);
                        System.out.println("finalizo OK");
                    }
                    );
            driver.quit();
        }

    }

}
