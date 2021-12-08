package email;

import DAO.UserIO;
import Model.UserEntity;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EmailverifyResetPass", value = "/EmailverifyResetPass")
public class EmailVerifyResetPass extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EmailVerifyResetPass() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
            doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
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
            UserEntity user= (UserEntity) session.getAttribute("account");
            String message = null;
            String code = request.getParameter("authcode");
            String verifycode = (String)request.getSession().getAttribute("code");
            String url;
            if(code.equals(verifycode)){
                UserIO.insert(user);
                session.setAttribute("account", user);
                url="/resetpassworddetail.jsp";
            }else{
                message="Mã xác thực không đúng";

                url="/verifyresetpass.jsp";
            }
            session.setAttribute("message", message);
            getServletContext()
                    .getRequestDispatcher(url).forward(request, response);
        }catch (Exception ignored)
        {

        }
    }
}
