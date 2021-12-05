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

@WebServlet(name = "EmailverifyResetPass", value = "/EmailverifyResetPass")
public class EmailVerifyResetPass extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmailVerifyResetPass() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try  {
            if (request.getCharacterEncoding() == null) {
                request.setCharacterEncoding("UTF-8");
            }
            String action = request.getParameter("action");
            if (action == null) {
                action = "join";  // default action
            }
            if (action.equals("join")) {
                action = "login";
            }
            HttpSession session = request.getSession();
            Account user= (Account) session.getAttribute("account");
            String message = null;
            String code = request.getParameter("authcode");
            String verifycode = (String)request.getSession().getAttribute("code");;
            String url;
            if(code.equals(verifycode)){
                accountIO.insert(user);
                session.setAttribute("account", user);
                url="/resetpassworddetail.jsp";
            }else{
                message="Mã xác thực không đúng";

                url="/verifyresetpass.jsp";
            }
            session.setAttribute("message", message);
            getServletContext()
                    .getRequestDispatcher(url).forward(request, response);
        }catch (Exception e)
        {

        }
    }
}
