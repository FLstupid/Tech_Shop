package Controller;

import DAO.UserIO;
import Model.UserEntity;
import email.Utility;

import javax.mail.MessagingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private String host;
    private String port;
    private String username;
    private String pass;

    public void init() {
        // reads SMTP server setting from web.xml file
        ServletContext context = getServletContext();
        host = context.getInitParameter("host");
        port = context.getInitParameter("port");
        username = context.getInitParameter("username");
        pass = context.getInitParameter("pass");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String url = "/login.jsp";
        String action = request.getParameter("action");
        String message = null;
        String t=null;
        UserEntity temp = null;
        if (action == null) {
            action = "join";  // default action
        }
        if (action.equals("join")) {
            action = "login";
        }
        else if(action.equals("add")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            String confirmpassword = request.getParameter("confirmpassword");

            String code = Utility.getRandom();
            request.getSession().setAttribute("code", code);
            if (email == null || email.equals("") || password == null || password.equals("")) {
                message = "Xin hãy nhập tài khoản và mật khẩu";
            }else if(!password.equals(confirmpassword))
            {
                message = "Mật khẩu xác nhận không đúng";
            }
            else {

                if (UserIO.userExist(email)) {
                    message = "Tài khoản đã tồn tại";
                } else {
                    boolean test;
                    try {
                        test = Utility.sendEmail(host, port, username, pass, email, "Mã Xác Thực",
                                "Đăng ký thành công! Mời bạn nhập mã xác thực bên dưới vào trang xác thực để đăng ký tài khoản mới: " +code);
                    } catch (MessagingException e) {
                        e.printStackTrace();
                        test = false;
                    }

                    if(test){
                        HttpSession session  = request.getSession();
                        temp = new UserEntity(email, password);
                        session.setAttribute("account", temp);
                        url="/verify.jsp";
                        message = "We already send a verification  code to your email.";
                        getServletContext()
                                .getRequestDispatcher(url).forward(request, response);
                    } else{
                        message = "There were an error. Please try again!";
                    }

                }
            }
            url = "/login.jsp";
        }
        if (action.equals("signin")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            if (email == null || email.equals("") || password==null || password.equals("")) {
                message = "Xin hãy nhập tài khoản và mật khẩu";
                url = "/login.jsp";
            }
            else if (UserIO.userExist(email)) {
                temp = UserIO.selectAcc(email);
                assert temp != null;
                if (temp.getPassword().equals(password)) {
                    message = "Đăng nhập thành công";
                    HttpSession session = request.getSession();
                    session.setAttribute("loggedInUser", temp);
                    request.setAttribute("account", temp);
                    request.getSession().setAttribute("account", temp);
                    t = temp.getUserName();
                    url = "/Home.jsp";
                } else {
                    message = "Mật khẩu không trùng khớp";
                }
            } else {
                message = "Tài khoản chưa tồn tại";
            }
        }
        request.getSession().setAttribute("loggedInUser", temp);
        request.setAttribute("message", message);
        if(request.getParameter("message")!=null)
        {request.setAttribute("message", message);

        }
        request.getSession().setAttribute("username", t);
        getServletContext()
                .getRequestDispatcher(url).forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
