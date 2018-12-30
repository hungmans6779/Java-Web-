package com.helloweenvsfei.jfreechart;

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
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

public class BarChartServlet extends HttpServlet {

	private static final long serialVersionUID = 227116552657325813L;
	
	/**
	 * Constructor of the object.
	 */
	public BarChartServlet() {
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

		CategoryDataset dataset = createDataset(); // ��o��ƶ��ﹳ
		
		// �إ߹ϧιﹳ
		JFreeChart jfreechart = ChartFactory.createBarChart3D("08�~�ϮѾP��q�ƦW","���u��", "�P�q", dataset, PlotOrientation.VERTICAL, true, true,false);
		
		CategoryPlot categoryPlot = (CategoryPlot) jfreechart.getPlot(); // ��o�Ϫ�ϰ�ﹳ
		categoryPlot.setDomainGridlinesVisible(true); // �]�w����u�i��
		
		CategoryAxis categoryAxis = categoryPlot.getDomainAxis(); // ��ox�b�ﹳ
		
		// �]�wx�b��ܪ������W�٪���ܦ�m�A�p�G���]�w�h�������
		// �]�w��A�i�H�׹���ܡA���������סA�Ϫ��Ŷ������ɡA��ĳ�ĥ�
		categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.39269908169872414D));
		categoryAxis.setCategoryMargin(0.0D);
		
		BarRenderer3D barRenderer3d = (BarRenderer3D) categoryPlot.getRenderer(); // ����ܹϧιﹳ		
		barRenderer3d.setDrawBarOutline(false); // �]�w�������ؽu
		
		 // �N�Ϫ�w��Ƭy���覡�Ǧ^���Ȥ��
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart,500, 270);
		
		try{
		  ChartUtilities.saveChartAsPNG(new File("E:\\EclipseDeveloper\\MyEclipse Bling Edition 9\\�����k�� Java Web ��X�}�o\\workspace\\JFreeChart\\generatorIMG\\bar1.png"),jfreechart,500,270);
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
		
		// �ɶ�����
		String [] category1 = { "�Ĥ@�u��", "�ĤG�u��", "�ĤT�u��", "�ĥ|�u��" };
		
		// ��������
		String [] category2 = { "JAVA", "C/C++", "PHP" };
		
		DefaultCategoryDataset defaultdataset = new DefaultCategoryDataset();
		for(int i = 0; i < category1.length; i++) {
		  String category = category1[i];
		  for(int j = 0; j < category2.length; j++) {
			String cat = category2[j];
			// ����W�[���
			defaultdataset.addValue(DataUtils.getRandomData(),cat,category);
		  } // end for(int j = 0; j < category2.length; j++) {
		}
		return defaultdataset;
	}

	
	
	
	
	
	
	


}
