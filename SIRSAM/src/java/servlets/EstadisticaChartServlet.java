package servlets;

import beans.Estadistica;
import beans.EstadisticaGraficas;
import beans.EstadisticaMetaData;
import daos.EstadisticaDao;
import daos.EstadisticaGraficasDao;
import daos.EstadisticaMetaDataDao;
import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.TextAnchor;

/**
 * @author CARLOS SANTANDER
 */
@WebServlet(name = "EstadisticaChartServlet", urlPatterns = {"/EstadisticaChart"})
public class EstadisticaChartServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    public void barV2D(HttpServletRequest request, HttpServletResponse response,
            String indi_id, String graf_id)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {

            String query = " WHERE graf_id = " + graf_id + " AND graf_estado = 'A' ";
            EstadisticaGraficas graph = new EstadisticaGraficasDao().getGraficaBarv2d(query);

            List<EstadisticaMetaData> list = new EstadisticaMetaDataDao().getListaDatos(graph.getGrafQuery());

            String queryF = " WHERE a.indi_id = " + indi_id + " AND a.inva_formula = TRUE AND a.inva_estado = 'A' ";
            //Estadistica varF = new EstadisticaDao().getIndicadorVariables(queryF);

            DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
            //list.forEach((datos) -> {
            //    objDataset.setValue(datos.getMedicion(), varF.getInvaNombre(), datos.getVarP());
            //});

            JFreeChart objChart = ChartFactory.createBarChart(
                    graph.getTitulo() == null ? "" : graph.getTitulo(), // Titulo del Gráfico
                    graph.getTitulodominio() == null ? "" : graph.getTitulodominio(), // Titulo del Dominio
                    graph.getTitulorango() == null ? "" : graph.getTitulorango(), // Titulo del Rango
                    objDataset, // La información en array
                    PlotOrientation.VERTICAL, // orientacion "HORIZONTAL" O "VERTICAL"
                    graph.getIncluirleyenda(), // Incluir Leyenda?
                    graph.getIncluirtooltips(), // Incluir Tooltips?
                    false // Incluir URLs?
            );

            CategoryPlot plot = (CategoryPlot) objChart.getPlot();
            objChart.setBackgroundPaint(Color.decode(graph.getFondoimg())); // Color de Fondo de la Imagen

            if (graph.getIncluirleyenda()) {
                LegendTitle legTitle = objChart.getLegend();
                Double bordeL = graph.getBordeleyenda();
                legTitle.setBorder(bordeL, bordeL, bordeL, bordeL); // Ancho del Borde de la Leyenda (0 = sin borde)
                Font fontLeyenda = new Font(graph.getFontleyendaname(), graph.getFontleyendastyle(), graph.getFontleyendasize());
                legTitle.setItemFont(fontLeyenda); // Fuente de la Leyenda
                HorizontalAlignment alignLeyenda = HorizontalAlignment.CENTER;
                if (graph.getAlignleyenda().equals("center")) {
                    alignLeyenda = HorizontalAlignment.CENTER;
                }
                if (graph.getAlignleyenda().equals("left")) {
                    alignLeyenda = HorizontalAlignment.LEFT;
                }
                if (graph.getAlignleyenda().equals("right")) {
                    alignLeyenda = HorizontalAlignment.RIGHT;
                }
                legTitle.setHorizontalAlignment(alignLeyenda); // Alineación Horizontal de la Leyenda (centro, izquierda, derecha)
                legTitle.setItemPaint(Color.decode(graph.getColorleyenda())); // Color de letra de la Leyenda
                legTitle.setBackgroundPaint(Color.decode(graph.getFondoleyenda())); // Color de fondo de la Leyenda
            }

            TextTitle title = objChart.getTitle();
            Font fontTitulo = new Font(graph.getFonttituloname(), graph.getFonttitulostyle(), graph.getFonttitulosize());
            title.setFont(fontTitulo); // Fuente del Título del Gráfico
            title.setPaint(Color.decode(graph.getColortitulo())); // Color del Título del Gráfico
            CategoryAxis dominio = plot.getDomainAxis();
            Font fontTituloDominio = new Font(graph.getFonttitulodominioname(), graph.getFonttitulodominiostyle(), graph.getFonttitulodominiosize());
            dominio.setLabelFont(fontTituloDominio); // Fuente del Título del Dominio del Gráfico
            dominio.setLabelPaint(Color.decode(graph.getColortitulodominio())); // Color del Título del Dominio del Gráfico
            Font fontDominio = new Font(graph.getFontdominioname(), graph.getFontdominiostyle(), graph.getFontdominiosize());
            dominio.setTickLabelFont(fontDominio); // Fuente del Dominio del Gráfico
            dominio.setTickLabelPaint(Color.decode(graph.getColordominio())); // Color del Dominio del Gráfico
            ValueAxis rango = plot.getRangeAxis();
            Font fontTituloRango = new Font(graph.getFonttitulorangoname(), graph.getFonttitulorangostyle(), graph.getFonttitulorangosize());
            rango.setLabelFont(fontTituloRango); // Fuente del Título del Rango del Gráfico
            rango.setLabelPaint(Color.decode(graph.getColortitulorango())); // Color del Título del Rango del Gráfico
            Font fontRango = new Font(graph.getFontrangoname(), graph.getFontrangostyle(), graph.getFontrangosize());
            rango.setTickLabelFont(fontRango); // Fuente del Rango del Gráfico
            rango.setTickLabelPaint(Color.decode(graph.getColorrango())); // Color del Rango del Gráfico
            plot.setBackgroundPaint(Color.decode(graph.getFondopaint())); // Color de fondo del área de dibujo del gráfico
            plot.setRangeGridlinePaint(Color.decode(graph.getLinerangepaint())); // Color de las líneas guias o cuadricula del rango del área de dibujo del gráfico
            plot.setOutlineVisible(false);
            BarRenderer renderer = ((BarRenderer) plot.getRenderer());
            String[] colorBarSeries = graph.getColorbarseries().split(",");
            String[] colorFontSeries = graph.getColorfontseries().split(",");
            Font fontBarSeries = new Font(graph.getFontbarseriesname(), graph.getFontbarseriesstyle(), graph.getFontbarseriessize());
            for (int i = 0; i < colorBarSeries.length; i++) {
                renderer.setSeriesPaint(i, Color.decode(colorBarSeries[i])); // Color de las Barras de las Series
                renderer.setMaximumBarWidth(graph.getAnchobar()); // Ancho de las Barras de las Series (Ejemplo:  30% = 0.30)
                renderer.setBaseItemLabelFont(fontBarSeries); // Fuente de la Letra de los valores de las Series
                renderer.setSeriesItemLabelPaint(i, Color.decode(colorFontSeries[i])); // Color de la Letra de los valores de las Series
            }
            renderer.setBarPainter(new StandardBarPainter());
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            simbolos.setGroupingSeparator(',');
            DecimalFormat formateador = new DecimalFormat(
                    graph.getFormatonumero(),
                    simbolos); // Formato de los números ("##0.00":decimal , "##0":entero, "#,###,##0.00":separacion de miles)
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator(
                    graph.getFormatolabel(),
                    formateador); // Formato de la letra ("{2}":simple , "{2} %":porcentaje)
            renderer.setBaseItemLabelGenerator(labelGen);
            renderer.setBaseItemLabelsVisible(true);
            // Posicion de los valores de las Series con respecto a las barras ("in":dentro de la barra , "out":fuera de la barra)
            if (graph.getPosicionnumbar().equals("in")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
            }
            if (graph.getPosicionnumbar().equals("out")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
            }
            renderer.setItemMargin(graph.getMargenseries()); // Espaciado porcentual entre barras de las Series de una misma Categoria (Ejemplo:  3% = 0.03)
            dominio.setCategoryMargin(graph.getMargencategorias()); // Espaciado porcentual entre la ultima barra de una Categoria y la primera barra de la siguientes Categorias (Ejemplo:  4% = 0.04)
            dominio.setLowerMargin(graph.getMargenizquierda()); // Espaciado porcentual, margen izquierdo con la primera barra (Ejemplo:  1% = 0.01)
            dominio.setUpperMargin(graph.getMargenderecha()); // Espaciado porcentual, margen derecho con la ultima barra (Ejemplo:  1% = 0.01)
            // Formato de la imagen
            if (graph.getFormatoimg().equals("png")) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, graph.getAnchoimg(), graph.getAltoimg()); // Se imprime la imagen
            }
            if (graph.getFormatoimg().equals("jpeg")) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, graph.getAnchoimg(), graph.getAltoimg()); // Se imprime la imagen
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void barV2DFicha(HttpServletRequest request, HttpServletResponse response,
            String indi_id, String graf_id)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {

            String query = " WHERE graf_id = " + graf_id + " AND graf_estado = 'A' ";
            EstadisticaGraficas graph = new EstadisticaGraficasDao().getGraficaBarv2d(query);

            String queryG = graph.getGrafQuery().replace("{@}", indi_id);

            List<EstadisticaMetaData> list = new EstadisticaMetaDataDao().getListaDatos(queryG);

            String queryF = " WHERE a.indi_id = " + indi_id + " AND a.inva_formula = TRUE AND a.inva_estado = 'A' ";
            //Estadistica varF = new EstadisticaDao().getIndicadorVariables(queryF);

            String queryM = " WHERE a.indi_id = " + indi_id + " AND a.indi_estado = 'A' ";
            //Estadistica indi = new EstadisticaDao().getIndicador(queryM);
            String medida = "";//indi.getUnmeNombre() == null ? "" : indi.getUnmeNombre();
            String simbolo = "";//indi.getUnmeSimbolo() == null ? "" : indi.getUnmeSimbolo();

            DefaultCategoryDataset objDataset = new DefaultCategoryDataset();
            //for (EstadisticaMetaData datos : list) {
            //    objDataset.setValue(datos.getMedicion(), varF.getInvaNombre(), datos.getVarP());
            //}

            JFreeChart objChart = ChartFactory.createBarChart(
                    graph.getTitulo() == null ? "" : graph.getTitulo(), // Titulo del Gráfico
                    graph.getTitulodominio() == null ? "" : graph.getTitulodominio(), // Titulo del Dominio
                    medida + " " + simbolo, // Titulo del Rango
                    objDataset, // La información en array
                    PlotOrientation.VERTICAL, // orientacion "HORIZONTAL" O "VERTICAL"
                    graph.getIncluirleyenda(), // Incluir Leyenda?
                    graph.getIncluirtooltips(), // Incluir Tooltips?
                    false // Incluir URLs?
            );

            CategoryPlot plot = (CategoryPlot) objChart.getPlot();
            objChart.setBackgroundPaint(Color.decode(graph.getFondoimg())); // Color de Fondo de la Imagen

            if (graph.getIncluirleyenda()) {
                LegendTitle legTitle = objChart.getLegend();
                Double bordeL = graph.getBordeleyenda();
                legTitle.setBorder(bordeL, bordeL, bordeL, bordeL); // Ancho del Borde de la Leyenda (0 = sin borde)
                Font fontLeyenda = new Font(graph.getFontleyendaname(), graph.getFontleyendastyle(), graph.getFontleyendasize());
                legTitle.setItemFont(fontLeyenda); // Fuente de la Leyenda
                HorizontalAlignment alignLeyenda = HorizontalAlignment.CENTER;
                if (graph.getAlignleyenda().equals("center")) {
                    alignLeyenda = HorizontalAlignment.CENTER;
                }
                if (graph.getAlignleyenda().equals("left")) {
                    alignLeyenda = HorizontalAlignment.LEFT;
                }
                if (graph.getAlignleyenda().equals("right")) {
                    alignLeyenda = HorizontalAlignment.RIGHT;
                }
                legTitle.setHorizontalAlignment(alignLeyenda); // Alineación Horizontal de la Leyenda (centro, izquierda, derecha)
                legTitle.setItemPaint(Color.decode(graph.getColorleyenda())); // Color de letra de la Leyenda
                legTitle.setBackgroundPaint(Color.decode(graph.getFondoleyenda())); // Color de fondo de la Leyenda
            }

            TextTitle title = objChart.getTitle();
            Font fontTitulo = new Font(graph.getFonttituloname(), graph.getFonttitulostyle(), graph.getFonttitulosize());
            title.setFont(fontTitulo); // Fuente del Título del Gráfico
            title.setPaint(Color.decode(graph.getColortitulo())); // Color del Título del Gráfico
            CategoryAxis dominio = plot.getDomainAxis();
            Font fontTituloDominio = new Font(graph.getFonttitulodominioname(), graph.getFonttitulodominiostyle(), graph.getFonttitulodominiosize());
            dominio.setLabelFont(fontTituloDominio); // Fuente del Título del Dominio del Gráfico
            dominio.setLabelPaint(Color.decode(graph.getColortitulodominio())); // Color del Título del Dominio del Gráfico
            Font fontDominio = new Font(graph.getFontdominioname(), graph.getFontdominiostyle(), graph.getFontdominiosize());
            dominio.setTickLabelFont(fontDominio); // Fuente del Dominio del Gráfico
            dominio.setTickLabelPaint(Color.decode(graph.getColordominio())); // Color del Dominio del Gráfico
            ValueAxis rango = plot.getRangeAxis();
            Font fontTituloRango = new Font(graph.getFonttitulorangoname(), graph.getFonttitulorangostyle(), graph.getFonttitulorangosize());
            rango.setLabelFont(fontTituloRango); // Fuente del Título del Rango del Gráfico
            rango.setLabelPaint(Color.decode(graph.getColortitulorango())); // Color del Título del Rango del Gráfico
            Font fontRango = new Font(graph.getFontrangoname(), graph.getFontrangostyle(), graph.getFontrangosize());
            rango.setTickLabelFont(fontRango); // Fuente del Rango del Gráfico
            rango.setTickLabelPaint(Color.decode(graph.getColorrango())); // Color del Rango del Gráfico
            plot.setBackgroundPaint(Color.decode(graph.getFondopaint())); // Color de fondo del área de dibujo del gráfico
            plot.setRangeGridlinePaint(Color.decode(graph.getLinerangepaint())); // Color de las líneas guias o cuadricula del rango del área de dibujo del gráfico
            plot.setOutlineVisible(false);
            BarRenderer renderer = ((BarRenderer) plot.getRenderer());
            String[] colorBarSeries = graph.getColorbarseries().split(",");
            String[] colorFontSeries = graph.getColorfontseries().split(",");
            Font fontBarSeries = new Font(graph.getFontbarseriesname(), graph.getFontbarseriesstyle(), graph.getFontbarseriessize());
            for (int i = 0; i < colorBarSeries.length; i++) {
                renderer.setSeriesPaint(i, Color.decode(colorBarSeries[i])); // Color de las Barras de las Series
                renderer.setMaximumBarWidth(graph.getAnchobar()); // Ancho de las Barras de las Series (Ejemplo:  30% = 0.30)
                renderer.setBaseItemLabelFont(fontBarSeries); // Fuente de la Letra de los valores de las Series
                renderer.setSeriesItemLabelPaint(i, Color.decode(colorFontSeries[i])); // Color de la Letra de los valores de las Series
            }
            renderer.setBarPainter(new StandardBarPainter());
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            simbolos.setGroupingSeparator(',');
            DecimalFormat formateador = new DecimalFormat(
                    graph.getFormatonumero(),
                    simbolos); // Formato de los números ("##0.00":decimal , "##0":entero, "#,###,##0.00":separacion de miles)
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator(
                    graph.getFormatolabel(),
                    formateador); // Formato de la letra ("{2}":simple , "{2} %":porcentaje)
            renderer.setBaseItemLabelGenerator(labelGen);
            renderer.setBaseItemLabelsVisible(true);
            // Posicion de los valores de las Series con respecto a las barras ("in":dentro de la barra , "out":fuera de la barra)
            if (graph.getPosicionnumbar().equals("in")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
            }
            if (graph.getPosicionnumbar().equals("out")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
            }
            renderer.setItemMargin(graph.getMargenseries()); // Espaciado porcentual entre barras de las Series de una misma Categoria (Ejemplo:  3% = 0.03)
            dominio.setCategoryMargin(graph.getMargencategorias()); // Espaciado porcentual entre la ultima barra de una Categoria y la primera barra de la siguientes Categorias (Ejemplo:  4% = 0.04)
            dominio.setLowerMargin(graph.getMargenizquierda()); // Espaciado porcentual, margen izquierdo con la primera barra (Ejemplo:  1% = 0.01)
            dominio.setUpperMargin(graph.getMargenderecha()); // Espaciado porcentual, margen derecho con la ultima barra (Ejemplo:  1% = 0.01)
            // Formato de la imagen
            if (graph.getFormatoimg().equals("png")) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, graph.getAnchoimg(), graph.getAltoimg()); // Se imprime la imagen
            }
            if (graph.getFormatoimg().equals("jpeg")) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, graph.getAnchoimg(), graph.getAltoimg()); // Se imprime la imagen
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
