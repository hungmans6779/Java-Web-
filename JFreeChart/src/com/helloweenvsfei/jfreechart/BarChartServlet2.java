package com.helloweenvsfei.jfreechart;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.data.xy.XYBarDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class BarChartServlet2 extends HttpServlet {

	private static final long serialVersionUID = 935480272440185396L;
	
	/**
	 * Constructor of the object.
	 */
	public BarChartServlet2() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	
	
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		response.setContentType("image/png"); // �]�w�Ǧ^�������Ϥ�
	
		IntervalXYDataset dataset = createDataset(); // ��o��ƶ��ﹳ
		
		// �إ߹ϧιﹳ
		JFreeChart jfreechart = ChartFactory.createXYBarChart("08�~�ϮѾP��q", null,false, "�P�q", dataset, PlotOrientation.VERTICAL, true, false,false);
		jfreechart.setBackgroundPaint(Color.white); // �]�w�I�����զ�
		
		XYPlot xyplot = (XYPlot) jfreechart.getPlot(); // ��o�Ϫ�ϰ�ﹳ
		xyplot.setBackgroundPaint(Color.lightGray);    // �]�w�ϰ�ﹳ�I�����Ǧ�
		xyplot.setDomainGridlinePaint(Color.white);    // �]�w�ϰ�ﹳ����u�լ��զ�
		xyplot.setRangeGridlinePaint(Color.white);
		
		XYBarRenderer xybarrenderer = (XYBarRenderer) xyplot.getRenderer(); // ����ܹϧιﹳ
		xybarrenderer.setDrawBarOutline(false); // �]�w�������ؽu

		// �N�Ϫ�w��Ƭy���覡�Ǧ^���Ȥ��
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart,500, 270);
		
		try{
		  ChartUtilities.saveChartAsPNG(new File("E:\\EclipseDeveloper\\MyEclipse Bling Edition 9\\�����k�� Java Web ��X�}�o\\workspace\\JFreeChart\\generatorIMG\\bar2.png"),jfreechart,500,270);
		}catch(Exception e){
		  e.printStackTrace();  
	    }
		    
	}


	

	/**
	 * �Ǧ^��ƶ�
	 * 
	 * @return
	 */
	private static IntervalXYDataset createDataset() {
		// �إ߰򥻸��
		XYSeries xyseries = new XYSeries("JAVA");
		XYSeries xyseries1 = new XYSeries("PHP");
		for (int i = 1; i <= 12; i++) {
		  // �W�[���
		  xyseries.add(i,DataUtils.getRandomData());
		  xyseries1.add(i,DataUtils.getRandomData());
		}
		
		XYSeriesCollection xyseriescollection = new XYSeriesCollection();
		xyseriescollection.addSeries(xyseries);
		xyseriescollection.addSeries(xyseries1);
		return new XYBarDataset(xyseriescollection, 0.90000000000000002D);
	}
	
	
	
	
}
