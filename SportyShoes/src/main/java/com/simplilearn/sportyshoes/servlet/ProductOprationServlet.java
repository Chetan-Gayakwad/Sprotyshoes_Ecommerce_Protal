package com.simplilearn.sportyshoes.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.management.loading.PrivateClassLoader;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.hibernate.boot.archive.internal.FileInputStreamAccess;

import com.simplilearn.sportyshoes.helper.FactoryProvider;
import com.smplilearn.sportyshoes.Dao.CategoryDao;
import com.smplilearn.sportyshoes.Dao.ProductDao;
import com.smplilearn.sportyshoes.entities.Category;
import com.smplilearn.sportyshoes.entities.Product;

@MultipartConfig
public class ProductOprationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductOprationServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("operation");

		if (op.trim().equals("addcategory")) {

			String title = request.getParameter("title");
			String description = request.getParameter("desc");

			Category category = new Category();
			category.setCategoryTitle(title);
			category.setCategoryDecs(description);

			CategoryDao dao = new CategoryDao(FactoryProvider.getFactory());
			int catId = dao.savaCategory(category);

			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("message", "Category Added Successfully!!");
			response.sendRedirect("admin.jsp");
			return;

		} else if (op.trim().equals("addproduct")) {

			String pName = request.getParameter("title");
			String pDescription = request.getParameter("desc");
			int pPrice = Integer.parseInt(request.getParameter("price"));

			int pDiscount = Integer.parseInt(request.getParameter("discount"));

			int pQuantity = Integer.parseInt(request.getParameter("quantity"));
			int catId = Integer.parseInt(request.getParameter("catId"));
			Part part = request.getPart("img");

			Product p = new Product();
			p.setpName(pName);
			p.setpDesc(pDescription);
			p.setpDiscount(pDiscount);
			p.setpPrice(pPrice);
			p.setpQuantity(pQuantity);
			p.setpPhoto(part.getSubmittedFileName());

			CategoryDao cdao = new CategoryDao(FactoryProvider.getFactory());
			Category category = cdao.getCategoryById(catId);

			p.setCategory(category);

			ProductDao pdao = new ProductDao(FactoryProvider.getFactory());
			 pdao.saveProduct(p);

			String path = request.getRealPath("img") + File.separator + "products" + File.separator
					+ part.getSubmittedFileName();
			System.out.println(path);

			try {
				FileOutputStream fos = new FileOutputStream(path);

				InputStream is = part.getInputStream();

				byte[] Data = new byte[is.available()];

				is.read(Data);

				fos.write(Data);

				fos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("message", "Product Added Successfully!!");
			response.sendRedirect("admin.jsp");
			return;

		}

	}

}
