package com.helloweenvsfei.jfreechart;

import java.awt.BasicStroke;
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
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;

public class TimeChartServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public TimeChartServlet() {
		super();
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

	   doPost(request,response);
	   
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
		
		XYDataset dataset = createDataset();  // ��o��ƶ��ﹳ
		
		// �إ߹ϧιﹳ
		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("�ɧǹ�","POLO���v����", "����", dataset, false, false, false);
		XYPlot xyplot = (XYPlot) jfreechart.getPlot();
		
		XYLineAndShapeRenderer xylineandshaperenderer = new XYLineAndShapeRenderer(); // ��o��u��ܹﹳ
		xylineandshaperenderer.setBaseShapesVisible(false); // �]�w����ܧ�u
		xylineandshaperenderer.setSeriesStroke(0, new BasicStroke(0.5F, 1, 1, 5F, new float[] { 5F, 10F }, 0.0F)); // �]�w��u���ʲ�
		xyplot.setRenderer(xylineandshaperenderer);
		
		// �N�Ϫ�w��Ƭy���覡�Ǧ^���Ȥ��
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart,500, 270);

		try{
		  ChartUtilities.saveChartAsPNG(new File("E:\\EclipseDeveloper\\MyEclipse Bling Edition 9\\�����k�� Java Web ��X�}�o\\workspace\\JFreeChart\\generatorIMG\\time.png"),jfreechart,500,270);
		}catch(Exception e){
		  e.printStackTrace();  
	    }

	}


	
	/**
	 * �Ǧ^��ƶ�
	 * 
	 * @return
	 */
	private static XYDataset createDataset() {
		TimeSeries timeseries = new TimeSeries("JAVA"); //�إ߮ɧǹﹳ
		Day day = new Day(1, 1, 1990); //��l�Ƥ����1990�~1��1��
		double d = 100000D;
		
		// �W�[1000�����
		for(int i = 0; i < 4000; i++)
		  try{
		    // �H�����X100�����
		    d = (d + Math.random()) - 0.5D;
			// �W�[��ɧǹﹳ
			timeseries.add(day, new Double(d));
			// ���᪺�@��
			day = (Day) day.next();
		  } catch (SeriesException seriesexception){}
		// �Ǧ^XYDataset��ƶ�
		return new TimeSeriesCollection(timeseries);
	}
	
}
