package Controller;

import DAO.CartIO;
import DAO.CartItemIO;
import Model.CartEntity;
import Model.CartItemEntity;
import Model.UserEntity;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@MultipartConfig
@WebServlet(name = "cart", value = "/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding("UTF-8");}
        ServletContext sc = getServletContext();
        String action = request.getParameter("action");
        String url;
        HttpSession session = request.getSession();

        if (action == null) {
            action = "cart";
        }
        if (action.equals("cart")) {
            if (session.getAttribute("account") == null) {
                url = "/login.jsp";
                getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
            }
            UserEntity acc = (UserEntity) session.getAttribute("account");
            long Id = acc.getId();
            CartEntity cart = (CartEntity) CartIO.selectCart(Id);
            List<?> listcart = null;
            if (cart != null) {
                listcart = CartItemIO.selectItems(cart.getId());
            }
            session.setAttribute("listcart", listcart);
            url = "/cart.jsp";
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
        }
        else  if(action.equals("update")) {
            long itemId = Long.parseLong(request.getParameter("id"));
            long productCode = Long.parseLong(request.getParameter("productCode"));
            int amount = Integer.parseInt(request.getParameter("amount"));

            CartItemEntity item = (CartItemEntity) CartItemIO.selectItem(productCode, itemId);
            if (item != null) {
                item.setId((int) itemId);
                item.setAmount((short) amount);
                CartItemIO.update(item);
            }
            UserEntity acc = (UserEntity) session.getAttribute("account");
            long Id = acc.getId();
            CartEntity cart = (CartEntity) CartIO.selectCart(Id);
            List<?> listcart = null;

            if (cart != null) {
                listcart = CartItemIO.selectItems(cart.getId());
            }
            session.setAttribute("listcart", listcart);
            url = "/cart.jsp";
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);
        }
        else if(action.equals("remove")) {
            long itemId = Long.parseLong(request.getParameter("id"));
            long productCode = Long.parseLong(request.getParameter("productCode"));
            CartItemEntity item = (CartItemEntity) CartItemIO.selectItem(productCode, itemId);
            CartItemIO.delete(item);
            UserEntity acc = (UserEntity) session.getAttribute("account");
            long Id = acc.getId();
            CartEntity cart = (CartEntity) CartIO.selectCart(Id);
            List<?> listcart = null;

            if (cart != null) {
                listcart = CartItemIO.selectItems(cart.getId());
            }
            session.setAttribute("listcart", listcart);
            url = "/cart.jsp";
            getServletContext()
                    .getRequestDispatcher(url)
                    .forward(request, response);

        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
