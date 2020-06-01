package servlets;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Paint;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
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
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PieLabelLinkStyle;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.Range;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.TextAnchor;
import org.jfree.ui.VerticalAlignment;

/**
 * @author CARLOS SANTANDER
 */
@WebServlet(name = "JFreeChartServlet", urlPatterns = {"/JFreeChart"})
public class JFreeChartServlet extends HttpServlet {

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

    Paint transparente = new Color(0, 0, 0, 0);
    Paint verde = new Color(98, 156, 56);
    Paint naranja = new Color(247, 147, 50);
    Paint naranja_fuerte = new Color(241, 89, 33);
    Paint rojo = new Color(238, 29, 35);
    Paint azul = new Color(1, 90, 170);
    Paint azul_pers = new Color(143, 163, 188);
    Paint azul_barra = new Color(51, 90, 135);
    Paint azul_titu = new Color(51, 74, 99);
    Paint celeste = new Color(30, 184, 245);
    Paint gris = new Color(128, 130, 133);
    Paint gris_suave = Color.LIGHT_GRAY;
    Paint blanco = Color.WHITE;
    Paint negro = Color.BLACK;
    Paint negro_suave = new Color(60, 60, 60);
    Paint suave = new Color(255, 248, 235);
    Paint amarillo = new Color(255, 255, 0);

    public void pie_2D(HttpServletRequest request, HttpServletResponse response,
            DefaultPieDataset objDataset, String[] key,
            String titulo, int ancho, int alto, String formato, Boolean label)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {
            JFreeChart objChart = ChartFactory.createPieChart(
                    titulo, //Titulo
                    objDataset, //Datos 
                    true, // incluir leyenda?
                    true, // incluir tooltips?
                    false // incluir URLs?
            );
            PiePlot plot = (PiePlot) objChart.getPlot();
            int size = key.length;
            if (size == 1) {
                Paint[] color = new Paint[]{naranja};
                for (int i = 0; i < size; i++) {
                    plot.setSectionPaint(key[i], color[i]);
                }
            }
            if (size == 2) {
                Paint[] color = new Paint[]{naranja, azul_pers};
                for (int i = 0; i < size; i++) {
                    plot.setSectionPaint(key[i], color[i]);
                }
            }
            if (size == 3) {
                Paint[] color = new Paint[]{naranja, azul_pers, rojo};
                for (int i = 0; i < size; i++) {
                    plot.setSectionPaint(key[i], color[i]);
                }
            }
            if (size == 4) {
                Paint[] color = new Paint[]{naranja, azul_pers, rojo, gris};
                for (int i = 0; i < size; i++) {
                    plot.setSectionPaint(key[i], color[i]);
                }
            }
            plot.setBackgroundPaint(blanco);
            TextTitle title = objChart.getTitle();
            title.setPaint(naranja_fuerte);
            LegendTitle legTitle = objChart.getLegend();
            legTitle.setBorder(0, 0, 0, 0);
            legTitle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            plot.setSimpleLabels(label);
            if (ancho <= 200) {
                title.setFont(new Font("Tahoma", Font.BOLD, 12));
                legTitle.setItemFont(new Font("Tahoma", Font.BOLD, 10));
                plot.setLabelFont(new Font("Tahoma", Font.BOLD, 8));
            }
            if (ancho > 200 && ancho < 300) {
                title.setFont(new Font("Tahoma", Font.BOLD, 12));
                legTitle.setItemFont(new Font("Tahoma", Font.BOLD, 10));
                plot.setLabelFont(new Font("Tahoma", Font.BOLD, 8));
            }
            if (ancho >= 300) {
                title.setFont(new Font("Tahoma", Font.BOLD, 14));
                legTitle.setItemFont(new Font("Tahoma", Font.BOLD, 12));
                plot.setLabelFont(new Font("Tahoma", Font.BOLD, 11));
            }
            legTitle.setItemPaint(negro);
            plot.setSectionOutlinesVisible(false);
            plot.setNoDataMessage("No hay datos disponibles");
            //plot.setOutlinePaint(negro);
            plot.setOutlineVisible(false);
            if (label == true) {
                plot.setLabelPaint(blanco);
            }
            if (label == false) {
                plot.setLabelPaint(negro_suave);
                plot.setLabelLinkStyle(PieLabelLinkStyle.STANDARD);
                plot.setLabelLinkPaint(gris);
            }
            plot.setLabelBackgroundPaint(transparente);
            plot.setLabelShadowPaint(transparente);
            plot.setLabelOutlinePaint(transparente);
            plot.setShadowPaint(transparente);
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("##0.00", simbolos);
            DecimalFormat formateadorPorc = new DecimalFormat("##0.00%", simbolos);
            PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                    "{1}%", formateador, formateadorPorc);
            plot.setLabelGenerator(gen);
            if ("png".equals(formato)) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, ancho, alto);
            }
            if ("jpeg".equals(formato)) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, ancho, alto);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void pieInt_2D(HttpServletRequest request, HttpServletResponse response,
            DefaultPieDataset objDataset, String[] key,
            String titulo, int ancho, int alto, String formato, Boolean label)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {
            JFreeChart objChart = ChartFactory.createPieChart(
                    titulo, //Titulo
                    objDataset, //Datos 
                    true, // incluir leyenda?
                    true, // incluir tooltips?
                    false // incluir URLs?
            );
            PiePlot plot = (PiePlot) objChart.getPlot();
            int size = key.length;
            if (size == 1) {
                Paint[] color = new Paint[]{naranja};
                for (int i = 0; i < size; i++) {
                    plot.setSectionPaint(key[i], color[i]);
                }
            }
            if (size == 2) {
                Paint[] color = new Paint[]{naranja, azul_pers};
                for (int i = 0; i < size; i++) {
                    plot.setSectionPaint(key[i], color[i]);
                }
            }
            if (size == 3) {
                Paint[] color = new Paint[]{naranja, azul_pers, rojo};
                for (int i = 0; i < size; i++) {
                    plot.setSectionPaint(key[i], color[i]);
                }
            }
            if (size == 4) {
                Paint[] color = new Paint[]{naranja, azul_pers, rojo, gris};
                for (int i = 0; i < size; i++) {
                    plot.setSectionPaint(key[i], color[i]);
                }
            }
            plot.setBackgroundPaint(blanco);
            TextTitle title = objChart.getTitle();
            title.setPaint(naranja_fuerte);
            LegendTitle legTitle = objChart.getLegend();
            legTitle.setBorder(0, 0, 0, 0);
            legTitle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            plot.setSimpleLabels(label);
            if (ancho <= 200) {
                title.setFont(new Font("Tahoma", Font.BOLD, 12));
                legTitle.setItemFont(new Font("Tahoma", Font.BOLD, 10));
                plot.setLabelFont(new Font("Tahoma", Font.BOLD, 8));
            }
            if (ancho > 200 && ancho < 300) {
                title.setFont(new Font("Tahoma", Font.BOLD, 12));
                legTitle.setItemFont(new Font("Tahoma", Font.BOLD, 10));
                plot.setLabelFont(new Font("Tahoma", Font.BOLD, 8));
            }
            if (ancho >= 300) {
                title.setFont(new Font("Tahoma", Font.BOLD, 14));
                legTitle.setItemFont(new Font("Tahoma", Font.BOLD, 12));
                plot.setLabelFont(new Font("Tahoma", Font.BOLD, 13));
            }
            legTitle.setItemPaint(negro);
            plot.setSectionOutlinesVisible(false);
            plot.setNoDataMessage("No hay datos disponibles");
            plot.setOutlineVisible(false);
            if (label == true) {
                plot.setLabelPaint(blanco);
            }
            if (label == false) {
                plot.setLabelPaint(negro_suave);
                plot.setLabelLinkStyle(PieLabelLinkStyle.STANDARD);
                plot.setLabelLinkPaint(gris);
            }
            plot.setLabelBackgroundPaint(transparente);
            plot.setLabelShadowPaint(transparente);
            plot.setLabelOutlinePaint(transparente);
            plot.setShadowPaint(transparente);
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("##0", simbolos);
            DecimalFormat formateadorPorc = new DecimalFormat("##0.00%", simbolos);
            PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                    "{1}", formateador, formateadorPorc);
            plot.setLabelGenerator(gen);
            if ("png".equals(formato)) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, ancho, alto);
            }
            if ("jpeg".equals(formato)) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, ancho, alto);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void barraStackedV_2D(HttpServletRequest request, HttpServletResponse response,
            DefaultCategoryDataset objDataset, String[] rowkey, String titulo,
            String tituloX, String tituloY, int ancho, int alto, String formato)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {
            JFreeChart objChart = ChartFactory.createStackedBarChart(
                    titulo, //Titulo   StackedBarChartDemo
                    tituloX, //Titulo del Dominio (eje X)
                    tituloY, //Titulo del Rango (eje Y)
                    objDataset, //Datos
                    PlotOrientation.VERTICAL, // orientacion "HORIZONTAL" O "VERTICAL"
                    true, // incluir leyenda?
                    true, // incluir tooltips?
                    false // incluir URLs?
            );
            CategoryPlot plot = (CategoryPlot) objChart.getPlot();
            objChart.setBackgroundPaint(blanco);
            TextTitle title = objChart.getTitle();
            title.setFont(new Font("Tahoma", Font.BOLD, 14));
            title.setPaint(naranja_fuerte);
            CategoryAxis dominio = plot.getDomainAxis();
            dominio.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            dominio.setLabelPaint(azul);
            ValueAxis rango = plot.getRangeAxis();
            rango.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            rango.setLabelPaint(azul);
            rango.setRange(new Range(0, 100));
            LegendTitle legTitle = objChart.getLegend();
            legTitle.setBorder(0, 0, 0, 0);
            legTitle.setItemFont(new Font("Tahoma", Font.BOLD, 12));
            legTitle.setItemPaint(negro);
            plot.setBackgroundPaint(blanco);
            plot.setRangeGridlinePaint(gris_suave);
            plot.setOutlineVisible(false);
            BarRenderer renderer = ((BarRenderer) plot.getRenderer());
            int size = rowkey.length;
            if (size == 1) {
                Paint[] color = new Paint[]{naranja};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                }
            }
            if (size == 2) {
                Paint[] color = new Paint[]{azul_pers, naranja};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                }
            }
            if (size == 3) {
                Paint[] color = new Paint[]{azul_pers, azul_barra, naranja};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                }
            }
            renderer.setBarPainter(new StandardBarPainter());
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("##0.00", simbolos);
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator(
                    "{2}%", formateador);
            renderer.setBaseItemLabelGenerator(labelGen);
            renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, 11));
            renderer.setBaseItemLabelPaint(blanco);
            renderer.setBaseItemLabelsVisible(true);
            double d = 65 / (double) ancho;
            renderer.setMaximumBarWidth(d);
            renderer.setItemMargin(0.03);
            dominio.setCategoryMargin(0.03);
            if ("png".equals(formato)) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, ancho, alto);
            }
            if ("jpeg".equals(formato)) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, ancho, alto);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void barraStackedH_2D(HttpServletRequest request, HttpServletResponse response,
            DefaultCategoryDataset objDataset, String[] rowkey, String titulo,
            String tituloX, String tituloY, int ancho, int alto, String formato)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {
            JFreeChart objChart = ChartFactory.createStackedBarChart(
                    titulo, //Titulo   StackedBarChartDemo
                    tituloX, //Titulo del Dominio (eje X)
                    tituloY, //Titulo del Rango (eje Y)
                    objDataset, //Datos
                    PlotOrientation.HORIZONTAL, // orientacion "HORIZONTAL" O "VERTICAL"
                    true, // incluir leyenda?
                    true, // incluir tooltips?
                    false // incluir URLs?
            );
            CategoryPlot plot = (CategoryPlot) objChart.getPlot();
            objChart.setBackgroundPaint(blanco);
            TextTitle title = objChart.getTitle();
            title.setFont(new Font("Tahoma", Font.BOLD, 14));
            title.setPaint(naranja_fuerte);
            CategoryAxis dominio = plot.getDomainAxis();
            dominio.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            dominio.setLabelPaint(azul);
            ValueAxis rango = plot.getRangeAxis();
            rango.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            rango.setLabelPaint(azul);
            rango.setRange(0, 100);
            LegendTitle legTitle = objChart.getLegend();
            legTitle.setBorder(0, 0, 0, 0);
            legTitle.setItemFont(new Font("Tahoma", Font.BOLD, 12));
            legTitle.setItemPaint(negro);
            plot.setBackgroundPaint(blanco);
            plot.setRangeGridlinePaint(gris_suave);
            plot.setOutlineVisible(false);
            BarRenderer renderer = ((BarRenderer) plot.getRenderer());
            int size = rowkey.length;
            if (size == 1) {
                Paint[] color = new Paint[]{naranja};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                }
            }
            if (size == 2) {
                Paint[] color = new Paint[]{azul_pers, naranja};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                }
            }
            if (size == 3) {
                Paint[] color = new Paint[]{azul_pers, azul_barra, naranja};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                }
            }
            renderer.setBarPainter(new StandardBarPainter());
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("##0.00", simbolos);
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator(
                    "{2}%", formateador);
            renderer.setBaseItemLabelGenerator(labelGen);
            if (ancho <= 560) {
                renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, 8));
            }
            if (ancho > 560) {
                renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, 10));
            }
            renderer.setBaseItemLabelPaint(blanco);
            renderer.setBaseItemLabelsVisible(true);
            renderer.setMaximumBarWidth(0.08);
            if ("png".equals(formato)) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, ancho, alto);
            }
            if ("jpeg".equals(formato)) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, ancho, alto);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void barraSimpleV_2D(HttpServletRequest request, HttpServletResponse response,
            DefaultCategoryDataset objDataset, String[] Leyenda, String titulo, String tituloX, String tituloY,
            int ancho, int alto, int font_size, double bar_width, String formato, Paint fondo, Paint letra, String posicion)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {
            JFreeChart objChart = ChartFactory.createBarChart(
                    titulo, //Titulo   BarChartDemo
                    tituloX, //Titulo del Dominio (eje X)
                    tituloY, //Titulo del Rango (eje Y)
                    objDataset, //Datos
                    PlotOrientation.VERTICAL, // orientacion "HORIZONTAL" O "VERTICAL"
                    true, // incluir leyenda?
                    true, // incluir tooltips?
                    false // incluir URLs?
            );
            CategoryPlot plot = (CategoryPlot) objChart.getPlot();
            objChart.setBackgroundPaint(fondo);
            LegendTitle legTitle = objChart.getLegend();
            legTitle.setBorder(0, 0, 0, 0);
            legTitle.setItemFont(new Font("Tahoma", Font.PLAIN, 12));
            legTitle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            legTitle.setItemPaint(negro);
            legTitle.setBackgroundPaint(fondo);
            TextTitle title = objChart.getTitle();
            title.setFont(new Font("Tahoma", Font.BOLD, 14));
            title.setPaint(azul_titu);
            CategoryAxis dominio = plot.getDomainAxis();
            dominio.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            dominio.setLabelPaint(azul);
            ValueAxis rango = plot.getRangeAxis();
            rango.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            rango.setLabelPaint(azul);
            plot.setBackgroundPaint(fondo);
            plot.setRangeGridlinePaint(gris_suave);
            plot.setOutlineVisible(false);
            BarRenderer renderer = ((BarRenderer) plot.getRenderer());
            int size = Leyenda.length;
            if (size == 1) {
                Paint[] color = new Paint[]{azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                }
            }
            if (size == 2) {
                Paint[] color = new Paint[]{naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                }
            }
            if (size == 3) {
                Paint[] color = new Paint[]{rojo, naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                }
            }
            if (size == 10) {
                Paint[] color = new Paint[]{naranja, azul_barra};
                for (int i = 0; i < color.length; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));                      
                }
            }
            renderer.setBarPainter(new StandardBarPainter());
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            simbolos.setGroupingSeparator(',');
            DecimalFormat formateador = new DecimalFormat("#,###,###,##0.00", simbolos);
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator(
                    "{2}", formateador);
            renderer.setBaseItemLabelGenerator(labelGen);
            renderer.setBaseItemLabelsVisible(true);
            if (posicion.equals("in")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
                renderer.setBaseItemLabelPaint(letra);
            }
            if (posicion.equals("out")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
                renderer.setBaseItemLabelPaint(letra);
            }
            renderer.setItemMargin(0.03); // Espaciado entre barras de una misma Categoria (en forma porcentual)
            dominio.setCategoryMargin(0.04); // Espaciado entre la ultima barra y la primera barra entre Categorias (en forma porcentual)
            dominio.setLowerMargin(0.01); // Espaciado margen izquierdo con la primera barra (en forma porcentual)
            dominio.setUpperMargin(0.01); // Espaciado margen derecho con la ultima barra (en forma porcentual)
            if ("png".equals(formato)) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, ancho, alto);
            }
            if ("jpeg".equals(formato)) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, ancho, alto);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void barraSimpleV_Porc_2D(HttpServletRequest request, HttpServletResponse response,
            DefaultCategoryDataset objDataset, String[] Leyenda, String titulo,
            String tituloX, String tituloY, int ancho, int alto, String formato, Paint fondo)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {
            JFreeChart objChart = ChartFactory.createBarChart(
                    titulo, //Titulo   BarChartDemo
                    tituloX, //Titulo del Dominio (eje X)
                    tituloY, //Titulo del Rango (eje Y)
                    objDataset, //Datos
                    PlotOrientation.VERTICAL, // orientacion "HORIZONTAL" O "VERTICAL"
                    true, // incluir leyenda?
                    true, // incluir tooltips?
                    false // incluir URLs?
            );
            CategoryPlot plot = (CategoryPlot) objChart.getPlot();
            objChart.setBackgroundPaint(fondo);
            LegendTitle legTitle = objChart.getLegend();
            legTitle.setBorder(0, 0, 0, 0);
            legTitle.setItemFont(new Font("Tahoma", Font.PLAIN, 12));
            legTitle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            legTitle.setItemPaint(negro);
            legTitle.setBackgroundPaint(fondo);
            TextTitle title = objChart.getTitle();
            title.setFont(new Font("Tahoma", Font.BOLD, 14));
            title.setPaint(azul_titu);
            CategoryAxis dominio = plot.getDomainAxis();
            dominio.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            dominio.setLabelPaint(azul);
            ValueAxis rango = plot.getRangeAxis();
            rango.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            rango.setLabelPaint(azul);
            plot.setBackgroundPaint(fondo);
            plot.setRangeGridlinePaint(gris_suave);
            plot.setOutlineVisible(false);
            BarRenderer renderer = ((BarRenderer) plot.getRenderer());
            int size = Leyenda.length;
            if (size == 1) {
                Paint[] color = new Paint[]{azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(0.25);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, 11));
                }
            }
            if (size == 2) {
                Paint[] color = new Paint[]{naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(0.25);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, 10));
                }
            }
            if (size == 3) {
                Paint[] color = new Paint[]{rojo, naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(0.25);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, 8));
                }
            }
            if (size == 10) {
                Paint[] color = new Paint[]{naranja, azul_barra};
                for (int i = 0; i < color.length; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(0.25);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, 11));
                }
            }
            renderer.setBarPainter(new StandardBarPainter());
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("##0.00", simbolos);
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator(
                    "{2} %", formateador);
            renderer.setBaseItemLabelGenerator(labelGen);
            renderer.setBaseItemLabelPaint(blanco);
            renderer.setBaseItemLabelsVisible(true);
            renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
            renderer.setItemMargin(0.03);
            dominio.setCategoryMargin(0.03);
            if ("png".equals(formato)) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, ancho, alto);
            }
            if ("jpeg".equals(formato)) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, ancho, alto);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void barraSimpleV_X2_2D(HttpServletRequest request, HttpServletResponse response,
            DefaultCategoryDataset objDataset, DefaultCategoryDataset objDataset2, String[] Leyenda, String titulo, String tituloX, String tituloY,
            int ancho, int alto, int font_size, double bar_width, String formato, Paint fondo, Paint letra, Paint letra2)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {
            JFreeChart objChart = ChartFactory.createBarChart(
                    titulo, //Titulo   BarChartDemo
                    tituloX, //Titulo del Dominio (eje X)
                    tituloY, //Titulo del Rango (eje Y)
                    objDataset, //Datos
                    PlotOrientation.VERTICAL, // orientacion "HORIZONTAL" O "VERTICAL"
                    true, // incluir leyenda?
                    true, // incluir tooltips?
                    false // incluir URLs?
            );
            CategoryPlot plot = (CategoryPlot) objChart.getPlot();
            objChart.setBackgroundPaint(fondo);
            LegendTitle legTitle = objChart.getLegend();
            legTitle.setBorder(0, 0, 0, 0);
            legTitle.setItemFont(new Font("Tahoma", Font.PLAIN, 12));
            legTitle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            legTitle.setItemPaint(negro);
            legTitle.setBackgroundPaint(fondo);
            TextTitle title = objChart.getTitle();
            title.setFont(new Font("Tahoma", Font.BOLD, 14));
            title.setPaint(azul_titu);
            CategoryAxis dominio = plot.getDomainAxis();
            dominio.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            dominio.setLabelPaint(azul);
            ValueAxis rango = plot.getRangeAxis();
            rango.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            rango.setLabelPaint(azul);
            plot.setBackgroundPaint(fondo);
            plot.setRangeGridlinePaint(gris_suave);
            plot.setOutlineVisible(false);
            BarRenderer renderer = ((BarRenderer) plot.getRenderer());
            CategoryItemRenderer rendererBack = new BarRenderer();
            plot.setDataset(1, objDataset2);
            plot.setRenderer(1, rendererBack);
            plot.setDatasetRenderingOrder(DatasetRenderingOrder.REVERSE);
            BarRenderer renderer2 = ((BarRenderer) plot.getRenderer(1));
            int size = Leyenda.length;
            if (size == 1) {
                Paint[] color = new Paint[]{azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesPaint(i, color[i]);
                    renderer2.setMaximumBarWidth(bar_width);
                    renderer2.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesVisibleInLegend(i, false);
                }
            }
            if (size == 2) {
                Paint[] color = new Paint[]{naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesPaint(i, color[i]);
                    renderer2.setMaximumBarWidth(bar_width);
                    renderer2.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesVisibleInLegend(i, false);
                }
            }
            if (size == 3) {
                Paint[] color = new Paint[]{rojo, naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesPaint(i, color[i]);
                    renderer2.setMaximumBarWidth(bar_width);
                    renderer2.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesVisibleInLegend(i, false);
                }
            }
            if (size == 10) {
                Paint[] color = new Paint[]{naranja, azul_barra};
                for (int i = 0; i < color.length; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesPaint(i, color[i]);
                    renderer2.setMaximumBarWidth(bar_width);
                    renderer2.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesVisibleInLegend(i, false);
                }
            }
            renderer.setBarPainter(new StandardBarPainter());
            renderer2.setBarPainter(new StandardBarPainter());
            renderer2.setShadowVisible(false);
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("##0.00", simbolos);
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator(
                    "{2}", formateador);
            renderer.setBaseItemLabelGenerator(labelGen);
            renderer.setBaseItemLabelsVisible(true);
            renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
            renderer.setBaseItemLabelPaint(letra);
            StandardCategoryItemLabelGenerator labelGen2 = new StandardCategoryItemLabelGenerator(
                    "{0}", formateador);
            renderer2.setBaseItemLabelGenerator(labelGen2);
            renderer2.setBaseItemLabelsVisible(true);
            renderer2.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
            renderer2.setBaseItemLabelPaint(letra2);
            renderer.setItemMargin(0.03); // Espaciado entre barras de una misma Categoria (en forma porcentual)
            renderer2.setItemMargin(0.03); // Espaciado entre barras de una misma Categoria (en forma porcentual)
            dominio.setCategoryMargin(0.04); // Espaciado entre la ultima barra y la primera barra entre Categorias (en forma porcentual)
            dominio.setLowerMargin(0.01); // Espaciado margen izquierdo con la primera barra (en forma porcentual)
            dominio.setUpperMargin(0.01); // Espaciado margen derecho con la ultima barra (en forma porcentual)
            if ("png".equals(formato)) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, ancho, alto);
            }
            if ("jpeg".equals(formato)) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, ancho, alto);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void barraLineV_X2_2D(HttpServletRequest request, HttpServletResponse response,
            DefaultCategoryDataset objDataset, DefaultCategoryDataset objDataset2, DefaultCategoryDataset dataLine, String[] Leyenda, String titulo,
            String tituloX, String tituloY, int ancho, int alto, int font_size, double bar_width, String formato, Paint fondo, Paint letra, Paint letra2)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {
            JFreeChart objChart = ChartFactory.createBarChart(
                    titulo, //Titulo   BarChartDemo
                    tituloX, //Titulo del Dominio (eje X)
                    tituloY, //Titulo del Rango (eje Y)
                    objDataset, //Datos
                    PlotOrientation.VERTICAL, // orientacion "HORIZONTAL" O "VERTICAL"
                    true, // incluir leyenda?
                    true, // incluir tooltips?
                    false // incluir URLs?
            );
            CategoryPlot plot = (CategoryPlot) objChart.getPlot();
            objChart.setBackgroundPaint(fondo);
            LegendTitle legTitle = objChart.getLegend();
            legTitle.setBorder(0, 0, 0, 0);
            legTitle.setItemFont(new Font("Tahoma", Font.PLAIN, 12));
            legTitle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            legTitle.setItemPaint(negro);
            legTitle.setBackgroundPaint(fondo);
            TextTitle title = objChart.getTitle();
            title.setFont(new Font("Tahoma", Font.BOLD, 14));
            title.setPaint(azul_titu);
            CategoryAxis dominio = plot.getDomainAxis();
            dominio.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            dominio.setLabelPaint(azul);
            ValueAxis rango = plot.getRangeAxis();
            rango.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            rango.setLabelPaint(azul);
            plot.setBackgroundPaint(fondo);
            plot.setRangeGridlinePaint(gris_suave);
            plot.setOutlineVisible(false);
            BarRenderer renderer = ((BarRenderer) plot.getRenderer());
            CategoryItemRenderer rendererBack = new BarRenderer();
            plot.setDataset(1, objDataset2);
            plot.setRenderer(1, rendererBack);
            plot.setDatasetRenderingOrder(DatasetRenderingOrder.REVERSE);
            BarRenderer renderer2 = ((BarRenderer) plot.getRenderer(1));
            int size = Leyenda.length;
            if (size == 1) {
                Paint[] color = new Paint[]{azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesPaint(i, color[i]);
                    renderer2.setMaximumBarWidth(bar_width);
                    renderer2.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesVisibleInLegend(i, false);
                }
            }
            if (size == 2) {
                Paint[] color = new Paint[]{naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesPaint(i, color[i]);
                    renderer2.setMaximumBarWidth(bar_width);
                    renderer2.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesVisibleInLegend(i, false);
                }
            }
            if (size == 3) {
                Paint[] color = new Paint[]{rojo, naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesPaint(i, color[i]);
                    renderer2.setMaximumBarWidth(bar_width);
                    renderer2.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesVisibleInLegend(i, false);
                }
            }
            if (size == 10) {
                Paint[] color = new Paint[]{naranja, azul_barra};
                for (int i = 0; i < color.length; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesPaint(i, color[i]);
                    renderer2.setMaximumBarWidth(bar_width);
                    renderer2.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesVisibleInLegend(i, false);
                }
            }
            renderer.setBarPainter(new StandardBarPainter());
            renderer2.setBarPainter(new StandardBarPainter());
            renderer2.setShadowVisible(false);
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("##0.00", simbolos);
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator(
                    "{2}", formateador);
            renderer.setBaseItemLabelGenerator(labelGen);
            renderer.setBaseItemLabelsVisible(true);
            renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
            renderer.setBaseItemLabelPaint(letra);
            StandardCategoryItemLabelGenerator labelGen2 = new StandardCategoryItemLabelGenerator(
                    "{0}", formateador);
            renderer2.setBaseItemLabelGenerator(labelGen2);
            renderer2.setBaseItemLabelsVisible(true);
            renderer2.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
            renderer2.setBaseItemLabelPaint(letra2);
            renderer.setItemMargin(0.03); // Espaciado entre barras de una misma Categoria (en forma porcentual)
            renderer2.setItemMargin(0.03); // Espaciado entre barras de una misma Categoria (en forma porcentual)
            dominio.setCategoryMargin(0.04); // Espaciado entre la ultima barra y la primera barra entre Categorias (en forma porcentual)
            dominio.setLowerMargin(0.01); // Espaciado margen izquierdo con la primera barra (en forma porcentual)
            dominio.setUpperMargin(0.01); // Espaciado margen derecho con la ultima barra (en forma porcentual)
            if ("png".equals(formato)) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, ancho, alto);
            }
            if ("jpeg".equals(formato)) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, ancho, alto);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void barraSimpleH_2D(HttpServletRequest request, HttpServletResponse response,
            DefaultCategoryDataset objDataset, String[] Leyenda, String titulo, String tituloX, String tituloY,
            int ancho, int alto, int font_size, double bar_width, String formato, Paint fondo, Paint letra, String posicion)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {
            JFreeChart objChart = ChartFactory.createBarChart(
                    titulo, //Titulo   BarChartDemo
                    tituloX, //Titulo del Dominio (eje X)
                    tituloY, //Titulo del Rango (eje Y)
                    objDataset, //Datos
                    PlotOrientation.HORIZONTAL, // orientacion "HORIZONTAL" O "VERTICAL"
                    true, // incluir leyenda?
                    true, // incluir tooltips?
                    false // incluir URLs?
            );
            CategoryPlot plot = (CategoryPlot) objChart.getPlot();
            objChart.setBackgroundPaint(fondo);
            LegendTitle legTitle = objChart.getLegend();
            legTitle.setBorder(0, 0, 0, 0);
            legTitle.setItemFont(new Font("Tahoma", Font.PLAIN, 12));
            legTitle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            legTitle.setItemPaint(negro);
            legTitle.setBackgroundPaint(fondo);
            TextTitle title = objChart.getTitle();
            title.setFont(new Font("Tahoma", Font.BOLD, 14));
            title.setPaint(azul_titu);
            CategoryAxis dominio = plot.getDomainAxis();
            dominio.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            dominio.setLabelPaint(azul);
            ValueAxis rango = plot.getRangeAxis();
            rango.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            rango.setLabelPaint(azul);
            plot.setBackgroundPaint(fondo);
            plot.setRangeGridlinePaint(gris_suave);
            plot.setOutlineVisible(false);
            BarRenderer renderer = ((BarRenderer) plot.getRenderer());
            int size = Leyenda.length;
            if (size == 1) {
                Paint[] color = new Paint[]{azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                }
            }
            if (size == 2) {
                Paint[] color = new Paint[]{naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));

                }
            }
            if (size == 3) {
                Paint[] color = new Paint[]{rojo, naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                }
            }
            if (size == 10) {
                Paint[] color = new Paint[]{naranja, azul_barra};
                for (int i = 0; i < color.length; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                }
            }
            renderer.setBarPainter(new StandardBarPainter());
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("##0.00", simbolos);
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator(
                    "{2}", formateador);
            renderer.setBaseItemLabelGenerator(labelGen);
            renderer.setBaseItemLabelsVisible(true);
            if (posicion.equals("in")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER_RIGHT));
                renderer.setBaseItemLabelPaint(letra);
            }
            if (posicion.equals("out")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.CENTER_LEFT));
                renderer.setBaseItemLabelPaint(letra);
            }
            renderer.setItemMargin(0.03); // Espaciado entre barras de una misma Categoria (en forma porcentual)
            dominio.setCategoryMargin(0.04); // Espaciado entre la ultima barra y la primera barra entre Categorias (en forma porcentual)
            dominio.setLowerMargin(0.01); // Espaciado margen izquierdo con la primera barra (en forma porcentual)
            dominio.setUpperMargin(0.01); // Espaciado margen derecho con la ultima barra (en forma porcentual)
            if ("png".equals(formato)) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, ancho, alto);
            }
            if ("jpeg".equals(formato)) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, ancho, alto);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void barraLineV_2D(HttpServletRequest request, HttpServletResponse response,
            DefaultCategoryDataset objDataset, DefaultCategoryDataset dataLine, String[] Leyenda, String titulo, String tituloX, String tituloY,
            int ancho, int alto, int font_size, double bar_width, String formato, Paint fondo, Paint letra, String posicion)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {
            JFreeChart objChart = ChartFactory.createBarChart(
                    titulo, //Titulo   BarChartDemo
                    tituloX, //Titulo del Dominio (eje X)
                    tituloY, //Titulo del Rango (eje Y)
                    objDataset, //Datos
                    PlotOrientation.VERTICAL, // orientacion "HORIZONTAL" O "VERTICAL"
                    true, // incluir leyenda?
                    true, // incluir tooltips?
                    false // incluir URLs?
            );

            CategoryPlot plot = (CategoryPlot) objChart.getPlot();
            objChart.setBackgroundPaint(fondo);//<------
            LegendTitle legTitle = objChart.getLegend();
            legTitle.setBorder(0, 0, 0, 0);
            legTitle.setItemFont(new Font("Tahoma", Font.PLAIN, 12));
            legTitle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            legTitle.setItemPaint(negro);
            legTitle.setBackgroundPaint(fondo);
            CategoryItemRenderer lineRenderer = new LineAndShapeRenderer();
            plot.setDataset(1, dataLine);
            plot.setRenderer(1, lineRenderer);
            plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
            lineRenderer.setSeriesPaint(0, rojo);
            lineRenderer.setSeriesStroke(0, new BasicStroke(1.3f));
            TextTitle title = objChart.getTitle();
            title.setFont(new Font("Tahoma", Font.BOLD, 14));
            title.setPaint(azul_titu);
            CategoryAxis dominio = plot.getDomainAxis();
            dominio.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            dominio.setLabelPaint(azul);            
            ValueAxis rango = plot.getRangeAxis();
            rango.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            rango.setLabelPaint(azul);            
            plot.setBackgroundPaint(fondo);//<------
            plot.setRangeGridlinePaint(gris_suave);
            plot.setOutlineVisible(false);
            BarRenderer renderer = ((BarRenderer) plot.getRenderer());
            int size = Leyenda.length;
            if (size == 1) {
                Paint[] color = new Paint[]{azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setMaximumBarWidth(bar_width);
                }
            }
            if (size == 2) {
                Paint[] color = new Paint[]{naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setMaximumBarWidth(bar_width);
                }
            }
            if (size == 3) {
                Paint[] color = new Paint[]{rojo, naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setMaximumBarWidth(bar_width);
                }
            }
            renderer.setBarPainter(new StandardBarPainter());
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("##0.00", simbolos);
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator(
                    "{2}", formateador);
            renderer.setBaseItemLabelGenerator(labelGen);
            renderer.setBaseItemLabelsVisible(true);
            if (posicion.equals("in")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
                renderer.setBaseItemLabelPaint(letra);
            }
            if (posicion.equals("out")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
                renderer.setBaseItemLabelPaint(letra);
            }
            renderer.setItemMargin(0.03); // Espaciado entre barras de una misma Categoria (en forma porcentual)
            dominio.setCategoryMargin(0.04); // Espaciado entre la ultima barra y la primera barra entre Categorias (en forma porcentual)
            dominio.setLowerMargin(0.01); // Espaciado margen izquierdo con la primera barra (en forma porcentual)
            dominio.setUpperMargin(0.01); // Espaciado margen derecho con la ultima barra (en forma porcentual)
            if ("png".equals(formato)) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, ancho, alto);
            }
            if ("jpeg".equals(formato)) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, ancho, alto);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void barraLineV_2D_Sub(HttpServletRequest request, HttpServletResponse response, DefaultCategoryDataset objDataset,
            DefaultCategoryDataset dataLine, String[] Leyenda, String titulo, String subtitulo, String fase, String tituloX, String tituloY,
            int ancho, int alto, int font_size, double bar_width, String formato, Paint fondo, Paint letra, String posicion)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {
            JFreeChart objChart = ChartFactory.createBarChart(
                    titulo, //Titulo   BarChartDemo
                    tituloX, //Titulo del Dominio (eje X)
                    tituloY, //Titulo del Rango (eje Y)
                    objDataset, //Datos
                    PlotOrientation.VERTICAL, // orientacion "HORIZONTAL" O "VERTICAL"
                    true, // incluir leyenda?
                    true, // incluir tooltips?
                    false // incluir URLs?
            );

            TextTitle t1 = new TextTitle(subtitulo, new Font("Tahoma", Font.BOLD, 14), azul_titu, RectangleEdge.TOP, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, RectangleInsets.ZERO_INSETS);
            objChart.addSubtitle(t1);
            TextTitle t2 = new TextTitle("En blanco", new Font("Tahoma", Font.BOLD, 14), blanco, RectangleEdge.TOP, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, RectangleInsets.ZERO_INSETS);
            objChart.addSubtitle(t2);
            TextTitle t3 = new TextTitle("Fase : " + fase, new Font("Tahoma", Font.BOLD, 14), azul, RectangleEdge.TOP, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, RectangleInsets.ZERO_INSETS);
            objChart.addSubtitle(t3);
            CategoryPlot plot = (CategoryPlot) objChart.getPlot();
            objChart.setBackgroundPaint(fondo);//<------
            LegendTitle legTitle = objChart.getLegend();
            legTitle.setBorder(0, 0, 0, 0);
            legTitle.setItemFont(new Font("Tahoma", Font.PLAIN, 12));
            legTitle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            legTitle.setItemPaint(negro);
            legTitle.setBackgroundPaint(fondo);
            CategoryItemRenderer lineRenderer = new LineAndShapeRenderer();
            plot.setDataset(1, dataLine);
            plot.setRenderer(1, lineRenderer);
            plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
            lineRenderer.setSeriesPaint(0, rojo);
            float lineWidth = 0.7f;
            float dot[] = {lineWidth};
            float dash[] = {5.0f};
            lineRenderer.setSeriesStroke(0, new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
            TextTitle title = objChart.getTitle();
            title.setFont(new Font("Tahoma", Font.BOLD, 14));
            title.setPaint(azul_titu);

            CategoryAxis dominio = plot.getDomainAxis();
            dominio.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            dominio.setLabelPaint(azul);
            ValueAxis rango = plot.getRangeAxis();
            rango.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            rango.setLabelPaint(azul);
            plot.setBackgroundPaint(fondo);//<------
            plot.setRangeGridlinePaint(gris_suave);
            plot.setOutlineVisible(false);
            BarRenderer renderer = ((BarRenderer) plot.getRenderer());
            int size = Leyenda.length;
            if (size == 1) {
                Paint[] color = new Paint[]{azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setMaximumBarWidth(bar_width);
                }
            }
            if (size == 2) {
                Paint[] color = new Paint[]{naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setMaximumBarWidth(bar_width);
                }
            }
            if (size == 3) {
                Paint[] color = new Paint[]{rojo, naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setMaximumBarWidth(bar_width);
                }
            }
            renderer.setBarPainter(new StandardBarPainter());
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("##0.00", simbolos);
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator(
                    "{2}", formateador);
            renderer.setBaseItemLabelGenerator(labelGen);
            renderer.setBaseItemLabelsVisible(true);
            if (posicion.equals("in")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
                renderer.setBaseItemLabelPaint(letra);
            }
            if (posicion.equals("out")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
                renderer.setBaseItemLabelPaint(letra);
            }
            renderer.setItemMargin(0.03); // Espaciado entre barras de una misma Categoria (en forma porcentual)
            dominio.setCategoryMargin(0.04); // Espaciado entre la ultima barra y la primera barra entre Categorias (en forma porcentual)
            dominio.setLowerMargin(0.01); // Espaciado margen izquierdo con la primera barra (en forma porcentual)
            dominio.setUpperMargin(0.01); // Espaciado margen derecho con la ultima barra (en forma porcentual)
            if ("png".equals(formato)) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, ancho, alto);
            }
            if ("jpeg".equals(formato)) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, ancho, alto);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void barraLineV_2D_Sub_pdf(HttpServletRequest request, HttpServletResponse response, DefaultCategoryDataset objDataset,
            DefaultCategoryDataset dataLine, String[] Leyenda, String titulo, String subtitulo, String fase, String tituloX, String tituloY,
            int ancho, int alto, int font_size, double bar_width, String formato, Paint fondo, Paint letra, String posicion)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {
            JFreeChart objChart = ChartFactory.createBarChart(
                    titulo, //Titulo   BarChartDemo
                    tituloX, //Titulo del Dominio (eje X)
                    tituloY, //Titulo del Rango (eje Y)
                    objDataset, //Datos
                    PlotOrientation.VERTICAL, // orientacion "HORIZONTAL" O "VERTICAL"
                    true, // incluir leyenda?
                    true, // incluir tooltips?
                    false // incluir URLs?
            );
            TextTitle t1 = new TextTitle("Fase : " + fase, new Font("Tahoma", Font.BOLD, 14), azul, RectangleEdge.TOP, HorizontalAlignment.CENTER, VerticalAlignment.CENTER, RectangleInsets.ZERO_INSETS);
            objChart.addSubtitle(t1);
            CategoryPlot plot = (CategoryPlot) objChart.getPlot();
            objChart.setBackgroundPaint(fondo);//<------
            LegendTitle legTitle = objChart.getLegend();
            legTitle.setBorder(0, 0, 0, 0);
            legTitle.setItemFont(new Font("Tahoma", Font.PLAIN, 12));
            legTitle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            legTitle.setItemPaint(negro);
            legTitle.setBackgroundPaint(fondo);
            CategoryItemRenderer lineRenderer = new LineAndShapeRenderer();
            plot.setDataset(1, dataLine);
            plot.setRenderer(1, lineRenderer);
            plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
            lineRenderer.setSeriesPaint(0, rojo);
            float lineWidth = 0.7f;
            float dot[] = {lineWidth};
            float dash[] = {5.0f};
            lineRenderer.setSeriesStroke(0, new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
            TextTitle title = objChart.getTitle();
            title.setFont(new Font("Tahoma", Font.BOLD, 14));
            title.setPaint(azul_titu);
            CategoryAxis dominio = plot.getDomainAxis();
            dominio.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            dominio.setLabelPaint(azul);
            ValueAxis rango = plot.getRangeAxis();
            rango.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            rango.setLabelPaint(azul);
            plot.setBackgroundPaint(fondo);//<------
            plot.setRangeGridlinePaint(gris_suave);
            plot.setOutlineVisible(false);
            BarRenderer renderer = ((BarRenderer) plot.getRenderer());
            int size = Leyenda.length;
            if (size == 1) {
                Paint[] color = new Paint[]{azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setMaximumBarWidth(bar_width);
                }
            }
            if (size == 2) {
                Paint[] color = new Paint[]{naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setMaximumBarWidth(bar_width);
                }
            }
            if (size == 3) {
                Paint[] color = new Paint[]{rojo, naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setMaximumBarWidth(bar_width);
                }
            }
            renderer.setBarPainter(new StandardBarPainter());
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("##0.00", simbolos);
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator(
                    "{2}", formateador);
            renderer.setBaseItemLabelGenerator(labelGen);
            renderer.setBaseItemLabelsVisible(true);
            if (posicion.equals("in")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
                renderer.setBaseItemLabelPaint(letra);
            }
            if (posicion.equals("out")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_CENTER));
                renderer.setBaseItemLabelPaint(letra);
            }
            renderer.setItemMargin(0.03); // Espaciado entre barras de una misma Categoria (en forma porcentual)
            dominio.setCategoryMargin(0.04); // Espaciado entre la ultima barra y la primera barra entre Categorias (en forma porcentual)
            dominio.setLowerMargin(0.01); // Espaciado margen izquierdo con la primera barra (en forma porcentual)
            dominio.setUpperMargin(0.01); // Espaciado margen derecho con la ultima barra (en forma porcentual)
            if ("png".equals(formato)) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, ancho, alto);
            }
            if ("jpeg".equals(formato)) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, ancho, alto);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void barraLineH_2D(HttpServletRequest request, HttpServletResponse response,
            DefaultCategoryDataset objDataset, DefaultCategoryDataset dataLine, String[] Leyenda, String titulo, String tituloX, String tituloY,
            int ancho, int alto, int font_size, double bar_width, String formato, Paint fondo, Paint letra, String posicion)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {
            JFreeChart objChart = ChartFactory.createBarChart(
                    titulo, //Titulo   BarChartDemo
                    tituloX, //Titulo del Dominio (eje X)
                    tituloY, //Titulo del Rango (eje Y)
                    objDataset, //Datos
                    PlotOrientation.HORIZONTAL, // orientacion "HORIZONTAL" O "VERTICAL"
                    true, // incluir leyenda?
                    true, // incluir tooltips?
                    false // incluir URLs?
            );

            CategoryPlot plot = (CategoryPlot) objChart.getPlot();
            objChart.setBackgroundPaint(fondo);//<------
            LegendTitle legTitle = objChart.getLegend();
            legTitle.setBorder(0, 0, 0, 0);
            legTitle.setItemFont(new Font("Tahoma", Font.PLAIN, 12));
            legTitle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            legTitle.setItemPaint(negro);
            legTitle.setBackgroundPaint(fondo);
            CategoryItemRenderer lineRenderer = new LineAndShapeRenderer();
            plot.setDataset(1, dataLine);
            plot.setRenderer(1, lineRenderer);
            plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
            lineRenderer.setSeriesPaint(0, rojo);
            lineRenderer.setSeriesStroke(0, new BasicStroke(1.3f));
            TextTitle title = objChart.getTitle();
            title.setFont(new Font("Tahoma", Font.BOLD, 14));
            title.setPaint(azul_titu);
            CategoryAxis dominio = plot.getDomainAxis();
            dominio.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            dominio.setLabelPaint(azul);
            ValueAxis rango = plot.getRangeAxis();
            rango.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            rango.setLabelPaint(azul);
            plot.setBackgroundPaint(fondo);//<------
            plot.setRangeGridlinePaint(gris_suave);
            plot.setOutlineVisible(false);
            BarRenderer renderer = ((BarRenderer) plot.getRenderer());
            int size = Leyenda.length;
            if (size == 1) {
                Paint[] color = new Paint[]{azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setMaximumBarWidth(bar_width);
                }
            }
            if (size == 2) {
                Paint[] color = new Paint[]{naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setMaximumBarWidth(bar_width);
                }
            }
            if (size == 3) {
                Paint[] color = new Paint[]{rojo, naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setMaximumBarWidth(bar_width);
                }
            }
            renderer.setBarPainter(new StandardBarPainter());
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("##0.00", simbolos);
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator(
                    "  {2}", formateador);
            renderer.setBaseItemLabelGenerator(labelGen);
            renderer.setBaseItemLabelsVisible(true);
            if (posicion.equals("in")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER_RIGHT));
                renderer.setBaseItemLabelPaint(letra);
            }
            if (posicion.equals("out")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.CENTER_LEFT));
                renderer.setBaseItemLabelPaint(letra);
            }
            renderer.setItemMargin(0.03); // Espaciado entre barras de una misma Categoria (en forma porcentual)
            dominio.setCategoryMargin(0.04); // Espaciado entre la ultima barra y la primera barra entre Categorias (en forma porcentual)
            dominio.setLowerMargin(0.01); // Espaciado margen izquierdo con la primera barra (en forma porcentual)
            dominio.setUpperMargin(0.01); // Espaciado margen derecho con la ultima barra (en forma porcentual)
            if ("png".equals(formato)) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, ancho, alto);
            }
            if ("jpeg".equals(formato)) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, ancho, alto);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////   PARA PDF  /////////////////////////////////////////////////////////////////////////////////////
    public void barraSimpleV_X2_2D_pdf(HttpServletRequest request, HttpServletResponse response,
            DefaultCategoryDataset objDataset, DefaultCategoryDataset objDataset2, String[] Leyenda, String titulo, String tituloX, String tituloY,
            int ancho, int alto, int font_size, double bar_width, String formato, Paint fondo, Paint letra2)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {
            JFreeChart objChart = ChartFactory.createBarChart(
                    titulo, //Titulo   BarChartDemo
                    tituloX, //Titulo del Dominio (eje X)
                    tituloY, //Titulo del Rango (eje Y)
                    objDataset, //Datos
                    PlotOrientation.VERTICAL, // orientacion "HORIZONTAL" O "VERTICAL"
                    true, // incluir leyenda?
                    true, // incluir tooltips?
                    false // incluir URLs?
            );
            CategoryPlot plot = (CategoryPlot) objChart.getPlot();
            objChart.setBackgroundPaint(fondo);
            LegendTitle legTitle = objChart.getLegend();
            legTitle.setBorder(0, 0, 0, 0);
            legTitle.setItemFont(new Font("Tahoma", Font.PLAIN, 11));
            legTitle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            legTitle.setItemPaint(negro);
            legTitle.setBackgroundPaint(fondo);
            TextTitle title = objChart.getTitle();
            title.setFont(new Font("Tahoma", Font.BOLD, 11));
            title.setPaint(azul_titu);
            CategoryAxis dominio = plot.getDomainAxis();
            dominio.setLabelFont(new Font("Tahoma", Font.BOLD, 11));
            dominio.setLabelPaint(azul);
            dominio.setTickLabelFont(new Font("Tahoma", Font.PLAIN, 11));
            dominio.setTickLabelPaint(azul);
            ValueAxis rango = plot.getRangeAxis();
            rango.setLabelFont(new Font("Tahoma", Font.BOLD, 11));
            rango.setLabelPaint(azul);
            plot.setBackgroundPaint(fondo);
            plot.setRangeGridlinePaint(gris_suave);
            plot.setOutlineVisible(false);
            BarRenderer renderer = ((BarRenderer) plot.getRenderer());
            CategoryItemRenderer rendererBack = new BarRenderer();
            plot.setDataset(1, objDataset2);
            plot.setRenderer(1, rendererBack);
            plot.setDatasetRenderingOrder(DatasetRenderingOrder.REVERSE);
            BarRenderer renderer2 = ((BarRenderer) plot.getRenderer(1));
            int size = Leyenda.length;
            if (size == 1) {
                Paint[] color = new Paint[]{azul_barra};
                Paint[] colorfont = new Paint[]{blanco};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setSeriesItemLabelPaint(i, colorfont[i]);
                    renderer2.setSeriesPaint(i, color[i]);
                    renderer2.setMaximumBarWidth(bar_width);
                    renderer2.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesVisibleInLegend(i, false);
                }
            }
            if (size == 2) {
                Paint[] color = new Paint[]{gris_suave, azul_barra};
                Paint[] colorfont = new Paint[]{negro, blanco};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setSeriesItemLabelPaint(i, colorfont[i]);
                    renderer2.setSeriesPaint(i, color[i]);
                    renderer2.setMaximumBarWidth(bar_width);
                    renderer2.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesVisibleInLegend(i, false);
                }
            }
            if (size == 3) {
                Paint[] color = new Paint[]{gris_suave, azul_barra, naranja};
                Paint[] colorfont = new Paint[]{negro, blanco, negro};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setSeriesItemLabelPaint(i, colorfont[i]);
                    renderer2.setSeriesPaint(i, color[i]);
                    renderer2.setMaximumBarWidth(bar_width);
                    renderer2.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesVisibleInLegend(i, false);
                }
            }
            if (size == 10) {
                Paint[] color = new Paint[]{gris_suave, azul_barra};
                Paint[] colorfont = new Paint[]{negro, blanco};
                for (int i = 0; i < color.length; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setSeriesItemLabelPaint(i, colorfont[i]);
                    renderer2.setSeriesPaint(i, color[i]);
                    renderer2.setMaximumBarWidth(bar_width);
                    renderer2.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer2.setSeriesVisibleInLegend(i, false);
                }
            }
            renderer.setBarPainter(new StandardBarPainter());
            renderer2.setBarPainter(new StandardBarPainter());
            renderer2.setShadowVisible(false);
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("##0.00", simbolos);
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator(
                    "{2}", formateador);
            renderer.setBaseItemLabelGenerator(labelGen);
            renderer.setBaseItemLabelsVisible(true);
            renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
            StandardCategoryItemLabelGenerator labelGen2 = new StandardCategoryItemLabelGenerator(
                    "{0}", formateador);
            renderer2.setBaseItemLabelGenerator(labelGen2);
            renderer2.setBaseItemLabelsVisible(true);
            renderer2.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
            renderer2.setBaseItemLabelPaint(letra2);
            renderer.setItemMargin(0.03); // Espaciado entre barras de una misma Categoria (en forma porcentual)
            renderer2.setItemMargin(0.03); // Espaciado entre barras de una misma Categoria (en forma porcentual)
            dominio.setCategoryMargin(0.04); // Espaciado entre la ultima barra y la primera barra entre Categorias (en forma porcentual)
            dominio.setLowerMargin(0.01); // Espaciado margen izquierdo con la primera barra (en forma porcentual)
            dominio.setUpperMargin(0.01); // Espaciado margen derecho con la ultima barra (en forma porcentual)
            if ("png".equals(formato)) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, ancho, alto);
            }
            if ("jpeg".equals(formato)) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, ancho, alto);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void barraSimpleV_2D_pdf(HttpServletRequest request, HttpServletResponse response,
            DefaultCategoryDataset objDataset, String[] Leyenda, String titulo, String tituloX, String tituloY,
            int ancho, int alto, int font_size, double bar_width, String formato, Paint fondo, Paint letra, String posicion)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {
            JFreeChart objChart = ChartFactory.createBarChart(
                    titulo, //Titulo   BarChartDemo
                    tituloX, //Titulo del Dominio (eje X)
                    tituloY, //Titulo del Rango (eje Y)
                    objDataset, //Datos
                    PlotOrientation.VERTICAL, // orientacion "HORIZONTAL" O "VERTICAL"
                    true, // incluir leyenda?
                    true, // incluir tooltips?
                    false // incluir URLs?
            );
            CategoryPlot plot = (CategoryPlot) objChart.getPlot();
            objChart.setBackgroundPaint(fondo);
            LegendTitle legTitle = objChart.getLegend();
            legTitle.setBorder(0, 0, 0, 0);
            legTitle.setItemFont(new Font("Tahoma", Font.PLAIN, 11));
            legTitle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            legTitle.setItemPaint(negro);
            legTitle.setBackgroundPaint(fondo);
            TextTitle title = objChart.getTitle();
            title.setFont(new Font("Tahoma", Font.BOLD, 11));
            title.setPaint(azul_titu);
            CategoryAxis dominio = plot.getDomainAxis();
            dominio.setLabelFont(new Font("Tahoma", Font.BOLD, 11));
            dominio.setLabelPaint(azul);
            dominio.setTickLabelFont(new Font("Tahoma", Font.PLAIN, 11));
            dominio.setTickLabelPaint(azul);
            dominio.setMaximumCategoryLabelLines(2);
            ValueAxis rango = plot.getRangeAxis();
            rango.setLabelFont(new Font("Tahoma", Font.BOLD, 11));
            rango.setLabelPaint(azul);
            plot.setBackgroundPaint(fondo);
            plot.setRangeGridlinePaint(gris_suave);
            plot.setOutlineVisible(false);
            BarRenderer renderer = ((BarRenderer) plot.getRenderer());
            int size = Leyenda.length;
            if (size == 1) {
                Paint[] color = new Paint[]{azul_barra};
                Paint[] colorfont = new Paint[]{blanco};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    if (posicion.equals("in")) {
                        renderer.setSeriesItemLabelPaint(i, colorfont[i]);
                    }
                    if (posicion.equals("out")) {
                        renderer.setSeriesItemLabelPaint(i, letra);
                    }
                }
            }
            if (size == 2) {
                Paint[] color = new Paint[]{gris_suave, azul_barra};
                Paint[] colorfont = new Paint[]{negro, blanco};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    if (posicion.equals("in")) {
                        renderer.setSeriesItemLabelPaint(i, colorfont[i]);
                    }
                    if (posicion.equals("out")) {
                        renderer.setSeriesItemLabelPaint(i, letra);
                    }
                }
            }
            if (size == 3) {
                Paint[] color = new Paint[]{naranja, gris_suave, azul_barra};
                Paint[] colorfont = new Paint[]{blanco, negro, blanco};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    if (posicion.equals("in")) {
                        renderer.setSeriesItemLabelPaint(i, colorfont[i]);
                    }
                    if (posicion.equals("out")) {
                        renderer.setSeriesItemLabelPaint(i, letra);
                    }
                }
            }
            if (size == 10) {
                Paint[] color = new Paint[]{gris_suave, azul_barra};
                Paint[] colorfont = new Paint[]{negro, blanco};
                for (int i = 0; i < color.length; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setMaximumBarWidth(bar_width);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    if (posicion.equals("in")) {
                        renderer.setSeriesItemLabelPaint(i, colorfont[i]);
                    }
                    if (posicion.equals("out")) {
                        renderer.setSeriesItemLabelPaint(i, letra);
                    }
                }
            }
            renderer.setBarPainter(new StandardBarPainter());
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("##0.00", simbolos);
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator("{2}", formateador);
            renderer.setBaseItemLabelGenerator(labelGen);
            renderer.setBaseItemLabelsVisible(true);
            if (posicion.equals("in")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
            }
            if (posicion.equals("out")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
            }
            renderer.setItemMargin(0.03); // Espaciado entre barras de una misma Categoria (en forma porcentual)
            dominio.setCategoryMargin(0.04); // Espaciado entre la ultima barra y la primera barra entre Categorias (en forma porcentual)
            dominio.setLowerMargin(0.01); // Espaciado margen izquierdo con la primera barra (en forma porcentual)
            dominio.setUpperMargin(0.01); // Espaciado margen derecho con la ultima barra (en forma porcentual)
            if ("png".equals(formato)) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, ancho, alto);
            }
            if ("jpeg".equals(formato)) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, ancho, alto);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void barraLineV_2D_pdf(HttpServletRequest request, HttpServletResponse response,
            DefaultCategoryDataset objDataset, DefaultCategoryDataset dataLine, String[] Leyenda, String titulo, String tituloX, String tituloY,
            int ancho, int alto, int font_size, double bar_width, String formato, Paint fondo, Paint letra, String posicion)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {
            JFreeChart objChart = ChartFactory.createBarChart(
                    titulo, //Titulo   BarChartDemo
                    tituloX, //Titulo del Dominio (eje X)
                    tituloY, //Titulo del Rango (eje Y)
                    objDataset, //Datos
                    PlotOrientation.VERTICAL, // orientacion "HORIZONTAL" O "VERTICAL"
                    true, // incluir leyenda?
                    true, // incluir tooltips?
                    false // incluir URLs?
            );

            CategoryPlot plot = (CategoryPlot) objChart.getPlot();
            objChart.setBackgroundPaint(fondo);//<------
            LegendTitle legTitle = objChart.getLegend();
            legTitle.setBorder(0, 0, 0, 0);
            legTitle.setItemFont(new Font("Tahoma", Font.PLAIN, 12));
            legTitle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            legTitle.setItemPaint(negro);
            legTitle.setBackgroundPaint(fondo);
            CategoryItemRenderer lineRenderer = new LineAndShapeRenderer();
            plot.setDataset(1, dataLine);
            plot.setRenderer(1, lineRenderer);
            plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
            lineRenderer.setSeriesPaint(0, rojo);
            lineRenderer.setSeriesStroke(0, new BasicStroke(1.3f));
            TextTitle title = objChart.getTitle();
            title.setFont(new Font("Tahoma", Font.BOLD, 14));
            title.setPaint(azul_titu);
            CategoryAxis dominio = plot.getDomainAxis();
            dominio.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            dominio.setLabelPaint(azul);
            ValueAxis rango = plot.getRangeAxis();
            rango.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            rango.setLabelPaint(azul);
            plot.setBackgroundPaint(fondo);//<------
            plot.setRangeGridlinePaint(gris_suave);
            plot.setOutlineVisible(false);
            BarRenderer renderer = ((BarRenderer) plot.getRenderer());
            int size = Leyenda.length;
            if (size == 1) {
                Paint[] color = new Paint[]{azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setMaximumBarWidth(bar_width);
                }
            }
            if (size == 2) {
                Paint[] color = new Paint[]{naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setMaximumBarWidth(bar_width);
                }
            }
            if (size == 3) {
                Paint[] color = new Paint[]{rojo, naranja, azul_barra};
                for (int i = 0; i < size; i++) {
                    renderer.setSeriesPaint(i, color[i]);
                    renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, font_size));
                    renderer.setMaximumBarWidth(bar_width);
                }
            }
            renderer.setBarPainter(new StandardBarPainter());
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("##0.00", simbolos);
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator(
                    "{2}", formateador);
            renderer.setBaseItemLabelGenerator(labelGen);
            renderer.setBaseItemLabelsVisible(true);
            if (posicion.equals("in")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER));
                renderer.setBaseItemLabelPaint(letra);
            }
            if (posicion.equals("out")) {
                renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
                renderer.setBaseItemLabelPaint(letra);
            }
            renderer.setItemMargin(0.03); // Espaciado entre barras de una misma Categoria (en forma porcentual)
            dominio.setCategoryMargin(0.04); // Espaciado entre la ultima barra y la primera barra entre Categorias (en forma porcentual)
            dominio.setLowerMargin(0.01); // Espaciado margen izquierdo con la primera barra (en forma porcentual)
            dominio.setUpperMargin(0.01); // Espaciado margen derecho con la ultima barra (en forma porcentual)
            if ("png".equals(formato)) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, ancho, alto);
            }
            if ("jpeg".equals(formato)) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, ancho, alto);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void lineChart_2D(HttpServletRequest request, HttpServletResponse response, DefaultCategoryDataset dataLine1,
            String titulo, String tituloX, String tituloY, int ancho, int alto, String formato, Paint fondo, Paint letra)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {
            JFreeChart objChart = ChartFactory.createLineChart(
                    titulo, //Titulo   BarChartDemo
                    tituloX, //Titulo del Dominio (eje X)
                    tituloY, //Titulo del Rango (eje Y)
                    dataLine1, //Datos
                    PlotOrientation.VERTICAL, // orientacion "HORIZONTAL" O "VERTICAL"
                    true, // incluir leyenda?
                    true, // incluir tooltips?
                    false // incluir URLs?
            );

            CategoryPlot plot = (CategoryPlot) objChart.getPlot();
            objChart.setBackgroundPaint(fondo);//<------
            LegendTitle legTitle = objChart.getLegend();
            legTitle.setBorder(0, 0, 0, 0);
            legTitle.setItemFont(new Font("Tahoma", Font.PLAIN, 12));
            legTitle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            legTitle.setItemPaint(negro);
            legTitle.setBackgroundPaint(fondo);
            TextTitle title = objChart.getTitle();
            title.setFont(new Font("Tahoma", Font.BOLD, 14));
            title.setPaint(naranja);
            CategoryAxis dominio = plot.getDomainAxis();
            dominio.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            dominio.setLabelPaint(azul);
            ValueAxis rango = plot.getRangeAxis();
            rango.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            rango.setLabelPaint(azul);
            plot.setBackgroundPaint(fondo);//<------
            plot.setRangeGridlinePaint(gris_suave);
            plot.setOutlineVisible(false);
            LineAndShapeRenderer renderer = new LineAndShapeRenderer();
            plot.setRenderer(renderer);
            renderer.setSeriesPaint(0, azul);
            renderer.setSeriesStroke(0, new BasicStroke(1.3f));
            renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, 10));
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("##0.00", simbolos);
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator(
                    "  {2} %  ", formateador);
            renderer.setBaseItemLabelGenerator(labelGen);
            renderer.setBaseItemLabelsVisible(true);
            renderer.setBaseItemLabelPaint(letra);
            //renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.TOP_LEFT), true);
            dominio.setLowerMargin(0.04); // Espaciado margen izquierdo con la primera barra (en forma porcentual)
            dominio.setUpperMargin(0.04); // Espaciado margen derecho con la ultima barra (en forma porcentual)
            if ("png".equals(formato)) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, ancho, alto);
            }
            if ("jpeg".equals(formato)) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, ancho, alto);
            }
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }

    public void lineChartX2_2D(HttpServletRequest request, HttpServletResponse response,
            DefaultCategoryDataset dataLine1, DefaultCategoryDataset dataLine2, String titulo,
            String tituloX, String tituloY, int ancho, int alto, String formato, Paint fondo, Paint letra)
            throws ServletException, IOException {
        try (OutputStream out = response.getOutputStream()) {
            JFreeChart objChart = ChartFactory.createLineChart(
                    titulo, //Titulo   BarChartDemo
                    tituloX, //Titulo del Dominio (eje X)
                    tituloY, //Titulo del Rango (eje Y)
                    dataLine1, //Datos
                    PlotOrientation.VERTICAL, // orientacion "HORIZONTAL" O "VERTICAL"
                    true, // incluir leyenda?
                    true, // incluir tooltips?
                    false // incluir URLs?
            );

            CategoryPlot plot = (CategoryPlot) objChart.getPlot();
            objChart.setBackgroundPaint(fondo);//<------
            LegendTitle legTitle = objChart.getLegend();
            legTitle.setBorder(0, 0, 0, 0);
            legTitle.setItemFont(new Font("Tahoma", Font.PLAIN, 12));
            legTitle.setHorizontalAlignment(HorizontalAlignment.CENTER);
            legTitle.setItemPaint(negro);
            legTitle.setBackgroundPaint(fondo);
            CategoryItemRenderer lineRenderer = new LineAndShapeRenderer();
            plot.setDataset(1, dataLine2);
            plot.setRenderer(1, lineRenderer);
            lineRenderer.setSeriesPaint(0, rojo);
            float lineWidth = 0.5f;
            float dot[] = {lineWidth};
            float dash[] = {5.0f};
            lineRenderer.setSeriesStroke(0, new BasicStroke(lineWidth, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
            lineRenderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, 10));
            TextTitle title = objChart.getTitle();
            title.setFont(new Font("Tahoma", Font.BOLD, 14));
            title.setPaint(azul_titu);
            CategoryAxis dominio = plot.getDomainAxis();
            dominio.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            dominio.setLabelPaint(azul);
            ValueAxis rango = plot.getRangeAxis();
            rango.setLabelFont(new Font("Tahoma", Font.BOLD, 14));
            rango.setLabelPaint(azul);
            plot.setBackgroundPaint(fondo);//<------
            plot.setRangeGridlinePaint(gris_suave);
            plot.setOutlineVisible(false);
            LineAndShapeRenderer renderer = new LineAndShapeRenderer();
            plot.setRenderer(renderer);
            renderer.setSeriesPaint(0, azul);
            renderer.setSeriesStroke(0, new BasicStroke(1.3f));
            renderer.setBaseItemLabelFont(new Font("Tahoma", Font.BOLD, 10));
            DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
            simbolos.setDecimalSeparator('.');
            DecimalFormat formateador = new DecimalFormat("##0.00", simbolos);
            StandardCategoryItemLabelGenerator labelGen = new StandardCategoryItemLabelGenerator(
                    "  {2} %  ", formateador);
            renderer.setBaseItemLabelGenerator(labelGen);
            renderer.setBaseItemLabelsVisible(true);
            lineRenderer.setBaseItemLabelGenerator(labelGen);
            lineRenderer.setBaseItemLabelsVisible(true);
            renderer.setBaseItemLabelPaint(letra);
            lineRenderer.setBaseItemLabelPaint(gris);
            renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.TOP_LEFT), true);
            lineRenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.BOTTOM_RIGHT));
            dominio.setLowerMargin(0.04); // Espaciado margen izquierdo con la primera barra (en forma porcentual)
            dominio.setUpperMargin(0.04); // Espaciado margen derecho con la ultima barra (en forma porcentual)
            if ("png".equals(formato)) {
                response.setContentType("image/png");
                ChartUtilities.writeChartAsPNG(out, objChart, ancho, alto);
            }
            if ("jpeg".equals(formato)) {
                response.setContentType("image/jpeg");
                ChartUtilities.writeChartAsJPEG(out, objChart, ancho, alto);
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
