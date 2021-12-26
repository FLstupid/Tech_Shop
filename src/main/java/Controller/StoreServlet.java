package Controller;

import DAO.ProductIO;
import Model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "store", value = "/store")
public class StoreServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String url="/store.jsp";
        if(action == null){
            action = "index";
        }
        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding("UTF-8");
        }
        HttpSession session = request.getSession();
        List<?> listproduct = ProductIO.selectListProduct();
        String Total = (String) session.getAttribute("Total");
        if (Total == null) {
            Total = "0";
            session.setAttribute("Total", Total);
        }
        String numberproduct = (String) session.getAttribute("numberproduct");
        if(numberproduct == null) {
            numberproduct = "0";
            session.setAttribute("numberproduct", numberproduct);
        }

        if (listproduct != null) {
            session.setAttribute("listproduct", listproduct);
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
