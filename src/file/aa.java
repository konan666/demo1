package file;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.TextAnchor;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

/**
 * @author ：konan
 * @date ：2020/12/8 16:19
 */
public class aa {
    int count=0;
    private aa() {

        // A网站的访问量统计
        TimeSeries timeSeries1 = new TimeSeries("A", Month.class);
        // 添加数据
        timeSeries1.add(new Month(1, 2016), 1540);
        timeSeries1.add(new Month(2, 2016), 2560);
        timeSeries1.add(new Month(3, 2016), 3120);
        timeSeries1.add(new Month(4, 2016), 4890);
        timeSeries1.add(new Month(5, 2016), 5630);
        timeSeries1.add(new Month(6, 2016), 5550);
        timeSeries1.add(new Month(7, 2016), 3590);
        timeSeries1.add(new Month(8, 2016), 2910);
        timeSeries1.add(new Month(9, 2016), 1230);
        timeSeries1.add(new Month(10, 2016), 4038);
        timeSeries1.add(new Month(11, 2016), 2806);

        // A网站的访问量统计
        TimeSeries timeSeries2 = new TimeSeries("A", Month.class);
        // 添加数据
        timeSeries2.add(new Month(1, 2016), 124);
        timeSeries2.add(new Month(2, 2016), 326);
        timeSeries2.add(new Month(3, 2016), 12);
        timeSeries2.add(new Month(4, 2016), 567);
        timeSeries2.add(new Month(5, 2016), 546);
        timeSeries2.add(new Month(6, 2016), 123);
        timeSeries2.add(new Month(7, 2016), 222);
        timeSeries2.add(new Month(8, 2016), 545);
        timeSeries2.add(new Month(9, 2016), 56);
        timeSeries2.add(new Month(10, 2016), 543);
        timeSeries2.add(new Month(11, 2016), 221);

        // 定义时间序列的集合
        TimeSeriesCollection lineDataset = new TimeSeriesCollection();
        lineDataset.addSeries(timeSeries1);
        lineDataset.addSeries(timeSeries2);


        //         JFreeChart chart = ChartFactory.createXYStepChart("Time line graph", "M", "F", xySeriesCollection, PlotOrientation.HORIZONTAL, false, false, false);
        JFreeChart chart = ChartFactory.createTimeSeriesChart("Time line graph", "M", "F", lineDataset, false, false, false);
        //设置主标题
        chart.setTitle(new TextTitle("A,B网站访问量统计对比图"));
        //设置子标题
        TextTitle subtitle = new TextTitle("2016年度", new Font("宋体", Font.BOLD, 12));
        chart.addSubtitle(subtitle);

        chart.setAntiAlias(true);

        //设置时间轴的范围。
        XYPlot plot = (XYPlot) chart.getPlot();
        DateAxis dateaxis = (DateAxis) plot.getDomainAxis();
        dateaxis.setDateFormatOverride(new SimpleDateFormat("M"));
        dateaxis.setTickUnit(new DateTickUnit(DateTickUnit.MONTH, 1));

        //设置曲线是否显示数据点
        XYLineAndShapeRenderer xylinerenderer = (XYLineAndShapeRenderer) plot.getRenderer();
        xylinerenderer.setBaseShapesVisible(true);

        //设置曲线显示各数据点的值
        XYItemRenderer xyitem = plot.getRenderer();
        xyitem.setBaseItemLabelsVisible(true);
        xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));
        xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
        xyitem.setBaseItemLabelFont(new Font("Dialog", Font.BOLD, 12));
        plot.setRenderer(xyitem);

        JPanel jPanel = new ChartPanel(chart);


        JFrame frame = new JFrame("JFreechart Test");
        frame.add(jPanel);
        frame.setBounds(0, 0, 800, 600);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        aa timeSeriesChart = new aa();
    }
}
