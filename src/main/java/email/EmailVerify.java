package email;

import Data.accountIO;
import Model.Account;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Emailverify", value = "/Emailverify")
public class EmailVerify extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            if (request.getCharacterEncoding() == null) {
                request.setCharacterEncoding("UTF-8");
            }
            String url="/verify.jsp";
            String action = request.getParameter("action");

            if (action == null) {
                action = "join";  // default action
            }
            else if(action.equals("confirm")){
                HttpSession session = request.getSession();
                Account user= (Account) session.getAttribute("account");
                String message;
                String code = request.getParameter("authcode1");
                String verifycode = (String)request.getSession().getAttribute("code");;

                if(code.equals(verifycode)){
                    accountIO.insert(user);
                    session.setAttribute("account", user);
                    url="/login.jsp";
                }else{
                    message="Mã xác thực không đúng";
                    session.setAttribute("message", message);
                    url="/verify.jsp";
                }
            }

            getServletContext()
                    .getRequestDispatcher(url).forward(request, response);
        }catch (Exception e)
        {

        }

    }

}
