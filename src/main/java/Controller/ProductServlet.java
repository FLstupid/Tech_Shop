package Controller;

import DAO.CategoryIO;
import DAO.ProductIO;
import Model.Category;
import Model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "product", value = "/product")
public class ProductServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding("UTF-8");
        }
        String url = "/product.jsp";

        String action = request.getParameter("action");
        if(action==null)
        {
            action = "product";
        }
        if (action.equals("addproduct"))
        {
            String productcontent = request.getParameter("productcontent");
            String productName = request.getParameter("productName");
            String productprice1 = request.getParameter("productprice");
            String productnsx1 = request.getParameter("productnsx");
            String productimage = request.getParameter("productimage");
            Double productprice = Double.parseDouble(productprice1);
            String categoryname = request.getParameter("categoryname");
            Object category = CategoryIO.SelectCategoryByName(categoryname);
            Product p = new Product(productName,productimage,productprice,productcontent,
                    productnsx1, (Category) category);
            ProductIO.insert(p);
        }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
