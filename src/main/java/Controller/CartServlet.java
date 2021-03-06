package Controller;

import DAO.CartIO;
import DAO.CartItemIO;
import Model.Cart;
import Model.CartItem;
import Model.User;

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
        switch (action) {
            case "cart": {
                if (session.getAttribute("account") == null) {
                    url = "/login.jsp";
                    getServletContext()
                            .getRequestDispatcher(url)
                            .forward(request, response);
                }
                User acc = (User) session.getAttribute("account");
                long Id = acc.getId();
                Cart cart = (Cart) CartIO.selectCart(Id);
                List<?> listcart;

                if (cart == null) {
                    cart = new Cart(acc);
                    CartIO.insert(cart);
                    listcart = CartItemIO.getListCartItemByCartId(cart.getId().toString());
                }else {
                    listcart = CartItemIO.getListCartItemByCartId(cart.getId().toString());
                }
                session.setAttribute("listcart", listcart);
                url = "/cart.jsp";
                getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
            }
            case "update": {
                long itemId = Long.parseLong(request.getParameter("id"));
                long productCode = Long.parseLong(request.getParameter("productCode"));
                int amount = Integer.parseInt(request.getParameter("amount"));

                CartItem item = (CartItem) CartItemIO.selectItem(productCode, itemId);
                if (item != null) {
                    item.setAmount(amount);
                    CartItemIO.update(item);
                }
                url = "/cart.jsp";
                getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
                break;
            }
            case "remove": {
                long itemId = Long.parseLong(request.getParameter("id"));
                long productCode = Long.parseLong(request.getParameter("productCode"));
                CartItem item = (CartItem) CartItemIO.selectItem(productCode, itemId);
                CartItemIO.delete(item);
                url = "/cart.jsp";
                getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
                break;
            }
            case "add": {
                long itemId = Long.parseLong(request.getParameter("id"));
                long productCode = Long.parseLong(request.getParameter("productCode"));
                CartItem item = (CartItem) CartItemIO.selectItem(productCode, itemId);
                CartItemIO.insert(item);
                url = "/cart.jsp";
                getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
