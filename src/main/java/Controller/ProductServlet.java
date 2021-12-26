package Controller;

import DAO.CartIO;
import DAO.CartItemIO;
import DAO.ProductIO;
import Model.Cart;
import Model.CartItem;
import Model.Product;
import Model.User;

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
        String action = request.getParameter("action");
        String url = "/Product.jsp";
        if(action == null)
        {
            action = "detail";
        }
        request.getSession();

        Product product=null;
        String productid = request.getParameter("productCode");
        if(productid!=null)
        {
            long id = Long.parseLong(productid);
            product = ProductIO.selectProductByid(id);
        }
        int amount = 1;

        switch (action) {
            case "detail": {
                request.getSession().setAttribute("product", product);
                request.getSession().setAttribute("amount",amount);
                assert productid != null;
                getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
                break;
            }
            case "checkUser": {
                url = "/login.jsp";
                getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
                break;
            }
            case "add":
                AddItem(request);
                getServletContext()
                        .getRequestDispatcher(url)
                        .forward(request, response);
                break;
        }

    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    private void AddItem (HttpServletRequest request) {
        User acc = (User) request.getSession().getAttribute("account");
        String amount1 = request.getParameter("sl");
        int amount = Integer.parseInt(amount1);
        long productCode = Long.parseLong(request.getParameter("productCode"));
        Cart cart = (Cart) CartIO.selectCart(acc.getId());
        Product product = ProductIO.selectProductByid(productCode);
        ProductIO.update(product);
        CartItem cartItem = null;
        if (cart != null) {
            cartItem = (CartItem) CartItemIO.selectItemincart(productCode,cart.getId());
        }
        if (cartItem == null) {
            CartItem Item = new CartItem();
            Item.setAmount(amount);
            Item.setProductId(product);
            Item.setCartId(cart);
            CartItemIO.insert(Item);
        }
        else {
            cartItem.setAmount(amount);
            assert product != null;
            cart.setPrice(amount*product.getPrice());
            CartItemIO.update(cartItem);
            CartIO.update(cart);
        }
    }
}
