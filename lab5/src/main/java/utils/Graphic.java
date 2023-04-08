package utils;


import equations.Equation;
import methods.TableOfDots;
import methods.interpolation.Spline;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;
import org.knowm.xchart.style.markers.SeriesMarkers;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Graphic {
    private static final Color WHITE = new Color(255, 180, 180);
    private static final Color Purple = new Color(152, 91, 201, 147);
    public static List<Double> xExact = new ArrayList<>();
    public static List<Double> yExact = new ArrayList<>();
    static double[] xData = new double[10000];
    static double[] ySplineData = new double[10000];
    public static void drawChart(TableOfDots table, Equation equation, Spline spline,String add) {
        XYChart chart = new XYChartBuilder().width(1000).height(1000).title("Numerical differentiation of "+equation.toString()+add).xAxisTitle("x").yAxisTitle("F(x)").build();
        chart.getStyler().setLegendPosition(Styler.LegendPosition.OutsideE);
        chart.getStyler().setChartBackgroundColor(WHITE);
        chart.getStyler().setPlotGridLinesColor(WHITE);

        makeSplineGraph(spline);
        XYSeries series = chart.addSeries("Numerical answer", xData, ySplineData);
        series.setMarker(SeriesMarkers.NONE);
        series.setLineColor(Purple);

        ArrayList<Double> xs = table.getXs();
        ArrayList<Double> ys = table.getYs();
        XYSeries series1 = chart.addSeries("Numerical dots", xs, ys);
        series1.setMarkerColor(Purple);
        series1.setXYSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Scatter);

        makeExactGraph(table, equation);
        XYSeries exactSeries = chart.addSeries("Analytical answer", xExact, yExact);
        exactSeries.setMarker(SeriesMarkers.NONE);
        exactSeries.setMarkerColor(Color.BLUE);
        exactSeries.setLineColor(Color.DARK_GRAY);
        new SwingWrapper(chart).displayChart();
    }


    public static void makeExactGraph(TableOfDots table, Equation equation) {
        double right = table.getXs().get(table.getXs().size() - 1);
        double left = table.getXs().get(0);
        double step = (right - left) / 100;
        for (double i = left - step * 5; i <= right + step * 5; i += step) {
            xExact.add(i);
            yExact.add(equation.exactValueFunction(i));

        }

    }

    public static void makeSplineGraph(Spline spline){
        int i = 0, k = 0;
        double x = spline.getX().get(0);
        xData[0] = x;
        ySplineData[0] = spline.f(x, 0);

        double currentX = x;
        while (x < spline.getX().get(spline.getX().size() - 1)) {
            x += (spline.getX().get(spline.getX().size() - 1) - spline.getX().get(0)) / 100;
            if (k < spline.getX().size() - 1 && x > currentX) {
                k++;
                currentX = spline.getX().get(k);
            }

            i++;
            xData[i] = x;
            ySplineData[i] = spline.f(x, k);
        }
        xData = Arrays.copyOfRange(xData,0,i+1);
        ySplineData = Arrays.copyOfRange(ySplineData,0,i+1);
    }
}
