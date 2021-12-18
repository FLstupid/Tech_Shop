package Controller;

import DAO.UserIO;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "resetpassworddetail" , value = "/resetpassworddetail")
public class ResetPasswordDetail extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doPost(request,response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding("UTF-8");
        }
            HttpSession session = request.getSession();
            User user= (User) request.getSession().getAttribute("account");
            String message4 = null;
            String newpass = request.getParameter("newpass");
            String confirmnewpasss = request.getParameter("confirmnewpasss");
            request.setAttribute("newpass",newpass);
            String url;
            if(newpass.equals("")||confirmnewpasss.equals(""))
            {
                message4="Xin nhập đủ các giá trị";
                url = "/resetpassworddetail.jsp";
            }else if(newpass.equals(confirmnewpasss)){
                user.setPassword(newpass);
                UserIO.update(user);
                session.setAttribute("account", user);
                url = "/login.jsp";
            }else{
                message4="Mật khẩu xác thực không đúng";
                url = "/resetpassworddetail.jsp";
            }session.setAttribute("message4", message4);
            request.getServletContext().getRequestDispatcher(url).forward(request, response);
    }
}

