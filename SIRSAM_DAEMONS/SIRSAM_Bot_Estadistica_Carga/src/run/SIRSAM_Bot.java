package run;

import dao.EstadisticaDao;
import estadistica.webservice.EstadisticaBot;
import estadistica.webservice.EstadisticaBot_Service;
import estadistica.webservice.InstitucionEducativa;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.List;

/*
 // @author CARLOS SANTANDER
 */
public class SIRSAM_Bot {

    public static void main(String[] args) throws UnknownHostException {

        Runtime rt = Runtime.getRuntime();
        long memoTotal = rt.totalMemory();
        long memoMaxim = rt.maxMemory();
        long memoLibre = rt.freeMemory();
        double megas = 1048576.0;

        System.out.println("Memoria Total: " + memoTotal + " (" + (memoTotal / megas) + " MB)");
        System.out.println("Memoria Máxima:   " + memoMaxim + " (" + (memoMaxim / megas) + " MB)");
        System.out.println("Memoria Libre:  " + memoLibre + " (" + (memoLibre / megas) + " MB)\n");

        EstadisticaBot_Service service = new EstadisticaBot_Service();
        EstadisticaBot port = service.getEstadisticaBotPort();

        InetAddress inet = InetAddress.getLocalHost();
        String host = inet.getHostName();
        String ip = inet.getHostAddress();

        System.out.println("Sincronizando fuentes primarias de Estadística \n");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        try {
            Calendar cal = Calendar.getInstance();
            long time = cal.getTimeInMillis();
            String query = " WHERE codgeo like '22%' ORDER BY cod_mod, anexo ASC ";
            String fuente = "instituciones_educativas";
            List<InstitucionEducativa> data = new EstadisticaDao().getInstitucionesEducativas(query, time, fuente, host, ip);
            if (!data.isEmpty()) {
                port.upsertInstitucionEducativa(data, time, fuente, host, ip);
            }
            System.out.println("Fuente: instituciones_educativas ==> (sincronizado)");
        } catch (IOException ex) {
            System.out.println("Fuente: instituciones_educativas ==> (falló)");
        }

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////            
        System.out.println("\n... TAREA COMPLETADA ....\n");

    }

}
