package Controller;

import DAO.UserIO;
import Model.User;
import email.Utility;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "reset_password" , value = "/reset_password")
public class ResetPasswordServlet extends HttpServlet {
    private String host;
    private String port;
    private String username;
    private String pass;

    public void init() {
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        username = context.getInitParameter("username");
        pass = context.getInitParameter("pass");

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding("UTF-8");
        }
        String action = request.getParameter("action");
        String url = "/resetpassword.jsp";
        if (action == null) {
            action = "join";  // default action
        }
        if (action.equals("join")) {
            action = "changingpassword"; // default action
        }
        String message5 = "";
        if (action.equals("resetpass"))
        {
            String email = request.getParameter("email");
            if(UserIO.selectAcc(email) != null)
            {
                User i = (User) UserIO.selectAcc(email);
                String code = Utility.getRandom();
                request.getSession().setAttribute("code", code);
                request.getSession().setAttribute("account", i);
                boolean test;
                try {
                    test = Utility.sendEmail(host, port, username, pass, email, "Mã Xác Thực",
                            "Xin hãy nhập đoạn mã này vào trang Verify để có thể đặt mật khẩu mới: " +code);
                } catch (MessagingException e) {
                    e.printStackTrace();
                    test = false;
                }


                if(test){
                    url="/verifyresetpass.jsp";
                    message5 = "Chúng tôi đã gửi cho bạn 1 mã xác thực ở trong email.";
                } else{
                    message5 = "Đã có lỗi xảy ra. Xin hãy thử lại!";
                    url="/resetpassword.jsp";
                }
            }
            else {
                message5 = "tài khoản không tồn tại";
            }


        }
        request.setAttribute("message5", message5);
        getServletContext()
                .getRequestDispatcher(url).forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding("UTF-8");
        }

            doGet(request,response);
}}
