package controller;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import util.DbConnection;

import javax.swing.*;
import java.sql.*;

public class Pic {
   

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JFreeChart Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            // 生成圖表
            JFreeChart barChart = createBarChart();
            JFreeChart pieChart = createPieChart();

            // 顯示圖表
            panel.add(new ChartPanel(barChart));
            panel.add(new ChartPanel(pieChart));

            frame.add(panel);
            frame.setVisible(true);
        });
    }

    /**
     * 建立長條圖
     */
    private static JFreeChart createBarChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        try (Connection conn = DbConnection.getDb();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT category, sales FROM sales_data")) {

            while (rs.next()) {
                String category = rs.getString("category");
                int sales = rs.getInt("sales");
                dataset.addValue(sales, "Sales", category);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ChartFactory.createBarChart(
                "Sales Data",           // 圖表標題
                "Category",             // X 軸標籤
                "Sales",                // Y 軸標籤
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);
    }

    /**
     * 建立餅狀圖
     */
    private static JFreeChart createPieChart() {
        DefaultPieDataset dataset = new DefaultPieDataset();

        try (Connection conn = DbConnection.getDb();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT category, sales FROM sales_data")) {

            while (rs.next()) {
                String category = rs.getString("category");
                int sales = rs.getInt("sales");
                dataset.setValue(category, sales);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ChartFactory.createPieChart(
                "Sales Distribution",   // 圖表標題
                dataset,
                true, true, false);
    }
}