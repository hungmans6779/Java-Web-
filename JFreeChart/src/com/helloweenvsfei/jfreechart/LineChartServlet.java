package com.helloweenvsfei.jfreechart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;

public class LineChartServlet extends HttpServlet {

	private static final long serialVersionUID = 1585397081043433662L;
	
	
	/**
	 * Constructor of the object.
	 */
	public LineChartServlet() {
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

		
		// �]�w�Ǧ^�������Ϥ�
		response.setContentType("image/png");

		CategoryDataset dataset = createDataset(); // ��o��ƶ��ﹳ
		
		// �إ߹ϧιﹳ
		JFreeChart jfreechart = ChartFactory.createLineChart("08�~�ϮѾP��q",null, "�P��q", dataset, PlotOrientation.VERTICAL, false, true,false);
		jfreechart.addSubtitle(new TextTitle("�����")); // �]�w�Ϫ��l���D
	  
		TextTitle texttitle = new TextTitle("���: " + new Date());   // �إߤ@�Ӽ��D
		texttitle.setFont(new Font("����", 0, 10));                   // �]�w���D�r��
		texttitle.setPosition(RectangleEdge.BOTTOM);                  // �]�w���D�V�U���
		texttitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);  // �]�w���D�V�k���
		
		jfreechart.addSubtitle(texttitle);                            // �W�[�Ϫ��l���D
		jfreechart.setBackgroundPaint(Color.white);                   // �]�w�Ϫ��I���⬰�զ�
		
		
		CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot(); // ��o�Ϫ�ϰ�ﹳ
		categoryplot.setBackgroundPaint(Color.lightGray);
		categoryplot.setRangeGridlinesVisible(false);
		
		
		// ����ܽu���ﹳ
		LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer) categoryplot.getRenderer();
		lineandshaperenderer.setBaseShapesVisible(true);
		lineandshaperenderer.setDrawOutlines(true);
		lineandshaperenderer.setUseFillPaint(true);
		lineandshaperenderer.setBaseFillPaint(Color.white);
		lineandshaperenderer.setSeriesStroke(0, new BasicStroke(3F)); // �]�w��u�[��
		lineandshaperenderer.setSeriesOutlineStroke(0, new BasicStroke(2.0F));
		lineandshaperenderer.setSeriesShape(0,new java.awt.geom.Ellipse2D.Double(-5D, -5D, 10D, 10D)); // �]�w��u���I
		
		
		// �N�Ϫ�w��Ƭy���覡�Ǧ^���Ȥ��
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart,500, 270);

		try{
		  ChartUtilities.saveChartAsPNG(new File("E:\\EclipseDeveloper\\MyEclipse Bling Edition 9\\�����k�� Java Web ��X�}�o\\workspace\\JFreeChart\\generatorIMG\\line.png"),jfreechart,500,270);
		}catch(Exception e){
		  e.printStackTrace();  
	    }
		    		
		
	}


	
	
	
	/**
	 * �Ǧ^��ƶ�
	 * 
	 * @return
	 */
	private static CategoryDataset createDataset() {
		DefaultCategoryDataset defaultdataset = new DefaultCategoryDataset();
		for (int i = 1; i <= 12; i++) {
			defaultdataset.addValue(DataUtils.getRandomData(), "JAVA", i + "��");
			defaultdataset.addValue(DataUtils.getRandomData(), "PHP", i + "��");
		}
		return defaultdataset;
	}

}
