package run;

import dao.SiafDao;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import presupuesto.webservice.ActProyNombre;
import presupuesto.webservice.Banco;
import presupuesto.webservice.CategoriaGasto;
import presupuesto.webservice.CategoriaIngreso;
import presupuesto.webservice.Certificado;
import presupuesto.webservice.CertificadoFase;
import presupuesto.webservice.CertificadoMeta;
import presupuesto.webservice.CertificadoSecuencia;
import presupuesto.webservice.Ciclo;
import presupuesto.webservice.ComponenteNombre;
import presupuesto.webservice.CtaCte;
import presupuesto.webservice.Departamento;
import presupuesto.webservice.Distrito;
import presupuesto.webservice.Ejecutora;
import presupuesto.webservice.Especifica;
import presupuesto.webservice.EspecificaDet;
import presupuesto.webservice.Expediente;
import presupuesto.webservice.ExpedienteAdjunto;
import presupuesto.webservice.ExpedienteDocumento;
import presupuesto.webservice.ExpedienteFase;
import presupuesto.webservice.ExpedienteIngreso;
import presupuesto.webservice.ExpedienteMeta;
import presupuesto.webservice.ExpedienteNota;
import presupuesto.webservice.ExpedienteSecuencia;
import presupuesto.webservice.Fase;
import presupuesto.webservice.Finalidad;
import presupuesto.webservice.FuenteFinanc;
import presupuesto.webservice.FuenteFinancAgregada;
import presupuesto.webservice.Funcion;
import presupuesto.webservice.Gasto;
import presupuesto.webservice.Generica;
import presupuesto.webservice.Ingreso;
import presupuesto.webservice.MaestroDocumento;
import presupuesto.webservice.Meta;
import presupuesto.webservice.MetaTrimestral;
import presupuesto.webservice.NotaModificatoriaCab;
import presupuesto.webservice.NotaModificatoriaDet;
import presupuesto.webservice.NotaModificatoriaDoc;
import presupuesto.webservice.NotaModificatoriaIng;
import presupuesto.webservice.NotaModificatoriaSec;
import presupuesto.webservice.PadronPersona;
import presupuesto.webservice.Persona;
import presupuesto.webservice.PersonaCciEjec;
import presupuesto.webservice.Pliego;
import presupuesto.webservice.ProgramaNombre;
import presupuesto.webservice.ProgramaPptoNombre;
import presupuesto.webservice.Provincia;
import presupuesto.webservice.SincronizarSIAF;
import presupuesto.webservice.SincronizarSIAF_Service;
import presupuesto.webservice.SubGenerica;
import presupuesto.webservice.SubGenericaDet;
import presupuesto.webservice.SubProgramaNombre;
import presupuesto.webservice.TipoDocumento;
import presupuesto.webservice.TipoOperacion;
import presupuesto.webservice.TipoProgramaPpto;
import presupuesto.webservice.TipoRecurso;
import presupuesto.webservice.TipoTransaccion;
import presupuesto.webservice.UnidadMedida;

/**
 *
 * @author CARLOS SANTANDER
 */
public class SIRSAM_SIAF extends javax.swing.JFrame {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat sdt = new SimpleDateFormat("hh:mm:ss");

    public SIRSAM_SIAF() {
        initComponents();
        final ImageIcon imageicon = new ImageIcon(getClass().getResource("/images/logo.png"));
        setIconImage(imageicon.getImage());
        setLocationRelativeTo(null);
        inicioOculto();
        llenarTipos();
        cargando();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sincronizador de SIAF");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(689, 269));

        jLabel3.setText("Elegir Año : ");

        jLabel4.setText("Sec. Ejec. : ");

        jButton1.setText("Comenzar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("SINCRONIZAR DATOS DE SIAF");

        jLabel2.setText("Elegir Tipo : ");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reiniciar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton1)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.Alignment.LEADING, 0, 103, Short.MAX_VALUE)))
                        .addGap(1467, 1467, 1467))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("Sincronizador");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void llenarTipos() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        jComboBox1.setModel(model);
        model.addElement(new ComboItem("Datos de Ejecutora Generales", "1"));
        model.addElement(new ComboItem("Datos de Ejecutora Anuales", "2"));
        model.addElement(new ComboItem("Datos de Ejecutora Diario", "3"));
        model.addElement(new ComboItem("Ejecución Histórica", "0"));
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            ComboItem item1 = (ComboItem) jComboBox1.getSelectedItem();
            final String tipo = item1.getValue();

            SincronizarSIAF_Service service = new SincronizarSIAF_Service();
            final SincronizarSIAF port = service.getSincronizarSIAFPort();

            Calendar cal = Calendar.getInstance();
            final int ano_actual = cal.get(Calendar.YEAR);

            InetAddress inet = InetAddress.getLocalHost();
            final String host = inet.getHostName();
            final String ip = inet.getHostAddress();

            final Runnable cargaInicial = new Runnable() {
                @Override
                public void run() {
                    cargando();
                    jButton1.setEnabled(false);
                    jLabel5.setVisible(true);
                }
            };
            Thread appThread = new Thread() {
                @Override
                public void run() {
                    try {
                        SwingUtilities.invokeAndWait(cargaInicial);
                    } catch (InterruptedException | InvocationTargetException ex) {
                    }
                    System.out.println("\nINICIANDO TAREA */*\n");
                    if (tipo.equals("0")) {
                        final String ejec = "";
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "ejecucion_historica_total";
                            port.upsertEjecucionHistoricaTotal(time, ejec, tabla, host, ip);
                            System.out.println("Tabla: ejecucion_historica_total ==> (sincronizado)");
                        } catch (Exception ex) {
                            System.out.println("Tabla: ejecucion_historica_total ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "ejecucion_historica_anterior";
                            port.upsertEjecucionHistoricaActual(ano_actual - 1, time, ejec, tabla, host, ip);
                            System.out.println("Tabla: ejecucion_historica_anterior ==> (sincronizado)");
                        } catch (Exception ex) {
                            System.out.println("Tabla: ejecucion_historica_anterior ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "ejecucion_historica_actual";
                            port.upsertEjecucionHistoricaActual(ano_actual, time, ejec, tabla, host, ip);
                            System.out.println("Tabla: ejecucion_historica_actual ==> (sincronizado)");
                        } catch (Exception ex) {
                            System.out.println("Tabla: ejecucion_historica_actual ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "recaudacion_historica_total";
                            port.upsertRecaudacionHistoricaTotal(time, ejec, tabla, host, ip);
                            System.out.println("Tabla: recaudacion_historica_total ==> (sincronizado)");
                        } catch (Exception ex) {
                            System.out.println("Tabla: recaudacion_historica_total ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "recaudacion_historica_anterior";
                            port.upsertRecaudacionHistoricaActual(ano_actual - 1, time, ejec, tabla, host, ip);
                            System.out.println("Tabla: recaudacion_historica_anterior ==> (sincronizado)");
                        } catch (Exception ex) {
                            System.out.println("Tabla: recaudacion_historica_anterior ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "recaudacion_historica_actual";
                            port.upsertRecaudacionHistoricaActual(ano_actual, time, ejec, tabla, host, ip);
                            System.out.println("Tabla: recaudacion_historica_actual ==> (sincronizado)");
                        } catch (Exception ex) {
                            System.out.println("Tabla: recaudacion_historica_actual ==> (falló)");
                        }
                        System.out.println("\nFINALIZO LA TAREA!!!!");
                        finalizado();
                    }
                    if (tipo.equals("1")) {
                        final String ejec = "";
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "banco";
                            List<Banco> data = new SiafDao().getBanco("", time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertBanco(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: banco ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: banco ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "ciclo";
                            List<Ciclo> data = new SiafDao().getCiclo("", time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertCiclo(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: ciclo ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: ciclo ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "departamento";
                            List<Departamento> data = new SiafDao().getDepartamento("", time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertDepartamento(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: departamento ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: departamento ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "distrito";
                            List<Distrito> data = new SiafDao().getDistrito("", time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertDistrito(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: distrito ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: distrito ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "fase";
                            List<Fase> data = new SiafDao().getFase("", time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertFase(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: fase ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: fase ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "maestro_documento";
                            List<MaestroDocumento> data = new SiafDao().getMaestroDocumento("", time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertMaestroDocumento(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: maestro_documento ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: maestro_documento ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "padron_persona";
                            List<PadronPersona> data = new SiafDao().getPadronPersona("", time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertPadronPersona(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: padron_persona ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: padron_persona ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "persona";
                            List<Persona> data = new SiafDao().getPersona("", time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertPersona(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: persona ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: persona ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "provincia";
                            List<Provincia> data = new SiafDao().getProvincia("", time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertProvincia(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: provincia ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: provincia ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "tipo_documento";
                            List<TipoDocumento> data = new SiafDao().getTipoDocumento("", time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertTipoDocumento(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: tipo_documento ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: tipo_documento ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "unidad_medida";
                            List<UnidadMedida> data = new SiafDao().getUnidadMedida("", time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertUnidadMedida(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: unidad_medida ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: unidad_medida ==> (falló)");
                        }
                        System.out.println("\nFINALIZO LA TAREA!!!!");
                        finalizado();
                    }
                    if (tipo.equals("2")) {
                        ComboItem item2 = (ComboItem) jComboBox2.getSelectedItem();
                        final String ano = item2.getValue();
                        final String ejec = "";
                        final String query = " WHERE ano_eje = '" + ano + "' ";
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "categoria_gasto";
                            List<CategoriaGasto> data = new SiafDao().getCategoriaGasto(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertCategoriaGasto(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: categoria_gasto ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: categoria_gasto ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "categoria_ingreso";
                            List<CategoriaIngreso> data = new SiafDao().getCategoriaIngreso(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertCategoriaIngreso(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: categoria_ingreso ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: categoria_ingreso ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "componente_nombre";
                            List<ComponenteNombre> data = new SiafDao().getComponenteNombre(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertComponenteNombre(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: componente_nombre ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: componente_nombre ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "ejecutora";
                            List<Ejecutora> data = new SiafDao().getEjecutora(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertEjecutora(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: ejecutora ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: ejecutora ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "especifica";
                            List<Especifica> data = new SiafDao().getEspecifica(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertEspecifica(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: especifica ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: especifica ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "especifica_det";
                            List<EspecificaDet> data = new SiafDao().getEspecificaDet(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertEspecificaDet(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: especifica_det ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: especifica_det ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "finalidad";
                            List<Finalidad> data = new SiafDao().getFinalidad(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertFinalidad(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: finalidad ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: finalidad ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "fuente_financ";
                            List<FuenteFinanc> data = new SiafDao().getFuenteFinanc(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertFuenteFinanc(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: fuente_financ ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: fuente_financ ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "fuente_financ_agregada";
                            List<FuenteFinancAgregada> data = new SiafDao().getFuenteFinancAgregada(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertFuenteFinancAgregada(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: fuente_financ_agregada ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: fuente_financ_agregada ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "funcion";
                            List<Funcion> data = new SiafDao().getFuncion(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertFuncion(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: funcion ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: funcion ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "generica";
                            List<Generica> data = new SiafDao().getGenerica(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertGenerica(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: generica ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: generica ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "pliego";
                            List<Pliego> data = new SiafDao().getPliego(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertPliego(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: pliego ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: pliego ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "programa_nombre";
                            List<ProgramaNombre> data = new SiafDao().getProgramaNombre(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertProgramaNombre(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: programa_nombre ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: programa_nombre ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "programa_ppto_nombre";
                            List<ProgramaPptoNombre> data = new SiafDao().getProgramaPptoNombre(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertProgramaPptoNombre(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: programa_ppto_nombre ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: programa_ppto_nombre ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "sub_generica";
                            List<SubGenerica> data = new SiafDao().getSubGenerica(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertSubGenerica(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: sub_generica ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: sub_generica ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "sub_generica_det";
                            List<SubGenericaDet> data = new SiafDao().getSubGenericaDet(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertSubGenericaDet(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: sub_generica_det ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: sub_generica_det ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "sub_programa_nombre";
                            List<SubProgramaNombre> data = new SiafDao().getSubProgramaNombre(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertSubProgramaNombre(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: sub_programa_nombre ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: sub_programa_nombre ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "tipo_operacion";
                            List<TipoOperacion> data = new SiafDao().getTipoOperacion(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertTipoOperacion(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: tipo_operacion ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: tipo_operacion ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "tipo_programa_ppto";
                            List<TipoProgramaPpto> data = new SiafDao().getTipoProgramaPpto(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertTipoProgramaPpto(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: tipo_programa_ppto ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: tipo_programa_ppto ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "tipo_recurso";
                            List<TipoRecurso> data = new SiafDao().getTipoRecurso(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertTipoRecurso(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: tipo_recurso ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: tipo_recurso ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "tipo_transaccion";
                            List<TipoTransaccion> data = new SiafDao().getTipoTransaccion(query, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertTipoTransaccion(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: tipo_transaccion ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: tipo_transaccion ==> (falló)");
                        }
                        System.out.println("\nFINALIZO LA TAREA DEL AÑO " + ano + " !!!!");
                        finalizado();
                    }
                    if (tipo.equals("3")) {
                        ComboItem item2 = (ComboItem) jComboBox2.getSelectedItem();
                        final String ano = item2.getValue();
                        final String ejec = jTextField1.getText();
                        final String query1 = " WHERE ano_eje = '" + ano + "' AND sec_ejec = '" + ejec + "' ";
                        final String query2 = " WHERE ano_eje = '" + ano + "' ";
                        final String query3 = " WHERE sec_ejec = '" + ejec + "' ";
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "act_proy_nombre";
                            List<ActProyNombre> data = new SiafDao().getActProyNombre(query2, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertActProyNombre(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: " + tabla + " ==> (sincronizado)");
                        } catch (IOException ex) {
                            String tabla = "act_proy_nombre";
                            System.out.println("Tabla: " + tabla + " ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "certificado";
                            List<Certificado> data = new SiafDao().getCertificado(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertCertificado(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: certificado ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: certificado ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "certificado_fase";
                            List<CertificadoFase> data = new SiafDao().getCertificadoFase(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertCertificadoFase(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: certificado_fase ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: certificado_fase ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "certificado_meta";
                            List<CertificadoMeta> data = new SiafDao().getCertificadoMeta(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertCertificadoMeta(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: certificado_meta ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: certificado_meta ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "certificado_secuencia";
                            List<CertificadoSecuencia> data = new SiafDao().getCertificadoSecuencia(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertCertificadoSecuencia(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: certificado_secuencia ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: certificado_secuencia ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "expediente";
                            List<Expediente> data = new SiafDao().getExpediente(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertExpediente(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: expediente ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: expediente ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "expediente_adjunto";
                            List<ExpedienteAdjunto> data = new SiafDao().getExpedienteAdjunto(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertExpedienteAdjunto(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: expediente_adjunto ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: expediente_adjunto ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "expediente_documento";
                            List<ExpedienteDocumento> data = new SiafDao().getExpedienteDocumento(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertExpedienteDocumento(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: expediente_documento ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: expediente_documento ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "expediente_fase";
                            List<ExpedienteFase> data = new SiafDao().getExpedienteFase(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertExpedienteFase(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: expediente_fase ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: expediente_fase ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "expediente_ingreso";
                            List<ExpedienteIngreso> data = new SiafDao().getExpedienteIngreso(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertExpedienteIngreso(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: expediente_ingreso ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: expediente_ingreso ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "expediente_meta";
                            List<ExpedienteMeta> data = new SiafDao().getExpedienteMeta(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertExpedienteMeta(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: expediente_meta ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: expediente_meta ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "expediente_nota";
                            List<ExpedienteNota> data = new SiafDao().getExpedienteNota(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertExpedienteNota(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: expediente_nota ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: expediente_nota ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "expediente_secuencia";
                            List<ExpedienteSecuencia> data = new SiafDao().getExpedienteSecuencia(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertExpedienteSecuencia(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: expediente_secuencia ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: expediente_secuencia ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "gasto";
                            List<Gasto> data = new SiafDao().getGasto(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertGasto(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: gasto ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: gasto ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "ingreso";
                            List<Ingreso> data = new SiafDao().getIngreso(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertIngreso(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: ingreso ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: ingreso ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "meta";
                            List<Meta> data = new SiafDao().getMeta(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertMeta(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: meta ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: meta ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "meta_trimestral";
                            List<MetaTrimestral> data = new SiafDao().getMetaTrimestral(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertMetaTrimestral(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: meta_trimestral ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: meta_trimestral ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "nota_modificatoria_cab";
                            List<NotaModificatoriaCab> data = new SiafDao().getNotaModificatoriaCab(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertNotaModificatoriaCab(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: nota_modificatoria_cab ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: nota_modificatoria_cab ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "nota_modificatoria_det";
                            List<NotaModificatoriaDet> data = new SiafDao().getNotaModificatoriaDet(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertNotaModificatoriaDet(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: nota_modificatoria_det ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: nota_modificatoria_det ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "nota_modificatoria_doc";
                            List<NotaModificatoriaDoc> data = new SiafDao().getNotaModificatoriaDoc(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertNotaModificatoriaDoc(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: nota_modificatoria_doc ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: nota_modificatoria_doc ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "nota_modificatoria_ing";
                            List<NotaModificatoriaIng> data = new SiafDao().getNotaModificatoriaIng(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertNotaModificatoriaIng(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: nota_modificatoria_ing ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: nota_modificatoria_ing ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "nota_modificatoria_sec";
                            List<NotaModificatoriaSec> data = new SiafDao().getNotaModificatoriaSec(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertNotaModificatoriaSec(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: nota_modificatoria_sec ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: nota_modificatoria_sec ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "persona_cci_ejec";
                            List<PersonaCciEjec> data = new SiafDao().getPersonaCciEjec(query1, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertPersonaCciEjec(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: persona_cci_ejec ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: persona_cci_ejec ==> (falló)");
                        }
                        try {
                            Calendar cal = Calendar.getInstance();
                            long time = cal.getTimeInMillis();
                            String tabla = "cta_cte";
                            List<CtaCte> data = new SiafDao().getCtaCte(query3, time, ejec, tabla, host, ip);
                            if (!data.isEmpty()) {
                                port.upsertCtaCte(data, time, ejec, tabla, host, ip);
                            }
                            System.out.println("Tabla: cta_cte ==> (sincronizado)");
                        } catch (IOException ex) {
                            System.out.println("Tabla: cta_cte ==> (falló)");
                        }
                        System.out.println("\nFINALIZO LA TAREA DEL AÑO " + ano + " - EJECUTORA " + ejec + " !!!!");
                        finalizado();
                    }
                    jButton2.setEnabled(true);

                }
            };
            appThread.start();
        } catch (UnknownHostException ex) {
            Logger.getLogger(SIRSAM_SIAF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        ComboItem item = (ComboItem) jComboBox1.getSelectedItem();
        if (item.getValue().equals("0")) {
            jLabel3.setVisible(false);
            jComboBox2.setVisible(false);
            jLabel4.setVisible(false);
            jTextField1.setVisible(false);
        }
        if (item.getValue().equals("1")) {
            jLabel3.setVisible(false);
            jComboBox2.setVisible(false);
            jLabel4.setVisible(false);
            jTextField1.setVisible(false);
        }
        if (item.getValue().equals("2")) {
            llenarAnos();
            jLabel3.setVisible(true);
            jComboBox2.setVisible(true);
            jLabel4.setVisible(false);
            jTextField1.setVisible(false);
        }
        if (item.getValue().equals("3")) {
            llenarAnos();
            jLabel3.setVisible(true);
            jComboBox2.setVisible(true);
            jLabel4.setVisible(true);
            jTextField1.setVisible(true);
        }
        if (item.getValue().equals("4")) {
            llenarAnos();
            jLabel3.setVisible(true);
            jComboBox2.setVisible(true);
            jLabel4.setVisible(true);
            jTextField1.setVisible(true);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jButton1.setEnabled(true);
        jButton2.setEnabled(false);
        jLabel5.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void inicioOculto() {
        jLabel5.setVisible(false);
        jButton2.setEnabled(false);
    }

    private void llenarAnos() {
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        jComboBox2.setModel(model);

        Calendar cal = Calendar.getInstance();
        int anoA = cal.getWeekYear();
        for (int i = anoA; i > 2010; i--) {
            model.addElement(new ComboItem(i + "", i + ""));
        }
    }

    private void cargando() {
        Calendar calCarga = Calendar.getInstance();
        String textoCarga = "<html><body>"
                + "<p style=\"padding:4;\"> FECHA : " + sdf.format(calCarga.getTime()) + "</p>"
                + "<p style=\"padding:4;\"> HORA INICIO : " + sdt.format(calCarga.getTime()) + "</p>"
                + "<p style=\"padding:4;\"> SINCRONIZANDO ... </p>"
                + "</body></html>";
        jLabel5.setText(textoCarga);
        jLabel5.setFont(new Font("Verdana", Font.BOLD, 12));
        ImageIcon imageload = new ImageIcon(getClass().getResource("/images/load.gif"));
        Icon icoload = new ImageIcon(imageload.getImage().getScaledInstance(95, 95, Image.SCALE_DEFAULT));
        jLabel5.setIcon(icoload);
    }

    private void finalizado() {
        Calendar calFin = Calendar.getInstance();
        String textoFin = "<html><body>"
                + "<p style=\"padding:4;\"> FECHA : " + sdf.format(calFin.getTime()) + "</p>"
                + "<p style=\"padding:4;\"> HORA FIN : " + sdt.format(calFin.getTime()) + "</p>"
                + "<p style=\"padding:4;\"> SINCRONIZADO CORRECTAMENTE  </p>"
                + "</body></html>";
        jLabel5.setText(textoFin);
        jLabel5.setFont(new Font("Verdana", Font.BOLD, 12));
        ImageIcon imagefinish = new ImageIcon(getClass().getResource("/images/ok.png"));
        jLabel5.setIcon(imagefinish);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SIRSAM_SIAF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SIRSAM_SIAF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SIRSAM_SIAF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SIRSAM_SIAF.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SIRSAM_SIAF().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
