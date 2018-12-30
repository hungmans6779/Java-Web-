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
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

public class AreaChartServlet extends HttpServlet {

	private static final long serialVersionUID = 5852523271721922574L;
	
	/**
	 * Constructor of the object.
	 */
	public AreaChartServlet() {
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
		JFreeChart jfreechart = ChartFactory.createAreaChart("08�~�ϮѾP��q�ƦW","���u��", "�P�q", dataset, PlotOrientation.VERTICAL, true, true,false);
		
		
		CategoryPlot categoryplot = (CategoryPlot) jfreechart.getPlot();      // ��o�Ϫ�ϰ�ﹳ
		categoryplot.setForegroundAlpha(0.5F);                                // �]�w�e���⬰50%�z��
		categoryplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));      // �]�wX�b�����q
		categoryplot.setBackgroundPaint(Color.lightGray);                     // �]�w�_���⬰�L�Ǧ�
		categoryplot.setDomainGridlinesVisible(true);                         // �]�w��ܺ���u		
		categoryplot.setDomainGridlinePaint(Color.white);                     // �]�w����u���զ�
		categoryplot.setRangeGridlinesVisible(true);                          // �]�w�����ɽu		
		categoryplot.setRangeGridlinePaint(Color.white);                      // �]�w�����ɽu���զ�
		CategoryAxis categoryaxis = categoryplot.getDomainAxis();             // ��oX�b�ﹳ		
		categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45); // �]�wX�b���Ҧ�m��45�ר�
		categoryaxis.setLowerMargin(0.0D); 	                                  // �]�w�PX�b���ɥլ�0
		categoryaxis.setUpperMargin(0.0D);
		
		// �N�Ϫ�w��Ƭy���覡�Ǧ^���Ȥ��
		ChartUtilities.writeChartAsPNG(response.getOutputStream(), jfreechart,500, 270);
		

		try{
		  ChartUtilities.saveChartAsPNG(new File("E:\\EclipseDeveloper\\MyEclipse Bling Edition 9\\�����k�� Java Web ��X�}�o\\workspace\\JFreeChart\\generatorIMG\\area.png"),jfreechart,500,270);
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
		String[] category1 = { "�Ĥ@�u��", "�ĤG�u��", "�ĤT�u��", "�ĥ|�u��" };
		// ��������
		String[] category2 = { "JAVA", "C/C++", "PHP" };
		DefaultCategoryDataset defaultdataset = new DefaultCategoryDataset();
		for (int i = 0; i < category1.length; i++) {
			String category = category1[i];
			for (int j = 0; j < category2.length; j++) {
				String cat = category2[j];
				// ����W�[���
				defaultdataset.addValue(DataUtils.getRandomData(), cat, category);
			}
		}
		return defaultdataset;
	}



}
