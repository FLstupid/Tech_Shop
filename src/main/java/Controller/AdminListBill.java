package Controller;

import DAO.CartIO;
import DAO.UserIO;
import Model.Cart;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdminListBill", value = "/AdminListBill")
public class AdminListBill extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=UTF-8");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        HttpSession httpSession = req.getSession();
        String status = "";
        String url = "/login.jsp";
        String admin = (String) httpSession.getAttribute("admin");
        if (admin == null || !admin.equals("19110204")) {
            url = "/login.jsp";


        } else {
//            ArrayList<User> UseridName = UserIO.getAllAccIDName();
            ArrayList<Cart> CartID = CartIO.getAllAccCart();
            req.setAttribute("ListCart", CartID);
//            req.setAttribute("ListUseridName", UseridName);
            url = "/AdminBill.jsp";
        }
        req.setAttribute("status", status);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
