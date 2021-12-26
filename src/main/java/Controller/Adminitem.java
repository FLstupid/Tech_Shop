package Controller;

import DAO.CartIO;
import DAO.CartItemIO;
import Model.Cart;
import Model.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Adminitem", value = "/Adminitem")
public class Adminitem extends HttpServlet {
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
            String action = req.getParameter("action");
            if (action == null){
                action = "bill";

            }
            if (action.trim().equals("bill")){
                String id = req.getParameter("id");
//                long id1 = Long.parseLong(id);
                System.out.println("khong chay vao day");
                try {
                    ArrayList<CartItem> listCartItem = CartItemIO.getListCartItemByCartId(id);
                    //                System.out.println(id);
                    req.setAttribute("listCartItem",listCartItem);


                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                url = "/AdminCartItem.jsp";

            }else if (action.trim().equals("confirm")){
                String id = req.getParameter("id");
                Cart cart = CartIO.getCartById(id);
                if (cart == null){
//                    url = "/report.jsp";
                    url = "/index.jsp";
                    status = "lỗi hệ thống";
                }else {
                    CartIO.deleteCart(cart);
                    url = "/AdminBill.jsp";
                }

            }
        }
        req.setAttribute("status", status);
        getServletContext().getRequestDispatcher(url).forward(req, resp);
    }
}
