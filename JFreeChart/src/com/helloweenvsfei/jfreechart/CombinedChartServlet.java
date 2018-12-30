package com.helloweenvsfei.jfreechart;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class CombinedChartServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CombinedChartServlet() {
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
		
		CategoryDataset categorydataset = createDataset(); // �إ߲Ĥ@�Ӹ�ƶ�
		
		NumberAxis numberaxis = new NumberAxis("�P�q");
		numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
		
		LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
		CategoryPlot categoryplot = new CategoryPlot(categorydataset, null,numberaxis, lineandshaperenderer);
		categoryplot.setDomainGridlinesVisible(true);
		
		
		CategoryDataset categorydataset1 = createDataset();  // �إ߲ĤG�Ӹ�ƶ�
		NumberAxis numberaxis1 = new NumberAxis("�P�q");
		BarRenderer barrenderer = new BarRenderer();
		barrenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
		CategoryPlot categoryplot1 = new CategoryPlot(categorydataset1, null,numberaxis1, barrenderer);
		categoryplot1.setDomainGridlinesVisible(true);
		
		// �إ߲զX��ƶ�
		CategoryAxis categoryaxis = new CategoryAxis();
		CombinedDomainCategoryPlot combineddomaincategoryplot = new CombinedDomainCategoryPlot(categoryaxis);
		combineddomaincategoryplot.add(categoryplot, 2);
		combineddomaincategoryplot.add(categoryplot1, 1);
		
		// �إ߹Ϫ�ﹳ
		JFreeChart jfreechart = new JFreeChart("�զX��", null,combineddomaincategoryplot, true);

		// �N�Ϫ�w��Ƭy���覡�Ǧ^���Ȥ��
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart,500, 270);

		try{
		  ChartUtilities.saveChartAsPNG(new File("E:\\EclipseDeveloper\\MyEclipse Bling Edition 9\\�����k�� Java Web ��X�}�o\\workspace\\JFreeChart\\generatorIMG\\comb.png"),jfreechart,500,270);
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
		
		String [] category1 = { "�Ĥ@�u��", "�ĤG�u��", "�ĤT�u��", "�ĥ|�u��" }; // �ɶ�����		
		String [] category2 = { "JAVA", "C/C++", "PHP" };     // ��������
		
		DefaultCategoryDataset defaultdataset = new DefaultCategoryDataset();
		for(int i = 0; i < category1.length; i++) {
		  String category = category1[i];
		  for(int j = 0; j < category2.length; j++) {
			String cat = category2[j];
			// ����W�[���
			defaultdataset.addValue(DataUtils.getRandomData(),cat,category);
		  }
	    }
	  return defaultdataset;
	}



}
