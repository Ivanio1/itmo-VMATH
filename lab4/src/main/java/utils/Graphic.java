package utils;

import functions.Function;
import methods.Spline;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYSplineRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import java.awt.*;
import java.awt.geom.Ellipse2D;


public class Graphic {
    Spline spline;
    String function;

    public Graphic(Spline spline, String function) {
        this.function = function;
        this.spline = spline;
    }


    public void drawGraph(Function function) {
        int i = 0, k = 0;
        double[] xData = new double[100000];
        double[] ySplineData = new double[100000];
        double[] yOriginalData = new double[100000];
        XYSeries xySeries1 = new XYSeries("splineGraph");
        XYSeries xySeries2 = new XYSeries("originalFunction");
        XYSeriesCollection collection = new XYSeriesCollection();

        double x = spline.getX()[0];
        xData[0] = x;
        ySplineData[0] = spline.f(x, 0);
        yOriginalData[0] = function.f(x);
        double currentX = x;

        while (x < spline.getX()[spline.getX().length - 1]) {
            x += (spline.getX()[spline.getX().length - 1] - spline.getX()[0]) / 10000;
            if (k < spline.getX().length - 1 && x > currentX) {
                k++;
                currentX = spline.getX()[k];
            }

            i++;
            xData[i] = x;
            ySplineData[i] = spline.f(x, k);
            yOriginalData[i] = function.f(x);
            xySeries1.add(xData[i], ySplineData[i]);
            xySeries2.add(xData[i], yOriginalData[i]);
        }

        collection.addSeries(xySeries1);
        collection.addSeries(xySeries2);
        JFreeChart chart = ChartFactory.createXYLineChart("Interpolation", "x", "y", collection, PlotOrientation.VERTICAL, true, false, false);
        XYPlot plot = chart.getXYPlot();

        plot.setDataset(0, collection);
        plot.getRenderer().setSeriesPaint(0, Color.RED);
        plot.getRenderer().setSeriesPaint(1, Color.BLACK);

        XYSplineRenderer renderer = new XYSplineRenderer(10000);
        renderer.setSeriesPaint(0, Color.BLACK);
        renderer.setSeriesStroke(0, new BasicStroke(5.0f));
        renderer.setSeriesShape(0, new Ellipse2D.Double(-3, -3, 6, 6));

        for (int j = 0; j < spline.getX().length; j++) {
            int n = j + 1;
            XYSeries xySeries3 = new XYSeries("dot" + n);
            XYSeriesCollection pointCollection = new XYSeriesCollection();
            pointCollection.addSeries(xySeries3);
            xySeries3.add(spline.getX()[j], spline.getY()[j]);
            plot.setDataset(j + 1, pointCollection);
            plot.setRenderer(j + 1, renderer);
        }
        ChartFrame frame = new ChartFrame("", chart);
        frame.pack();
        frame.setVisible(true);
    }
}
