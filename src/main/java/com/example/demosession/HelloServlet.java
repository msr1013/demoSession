package com.example.demosession;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/login")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name=req.getParameter("userName");
        String pass=req.getParameter("password");

        if (name.equals("admin") && pass.equals("admin")){
            HttpSession session = req.getSession(true);
            session.setAttribute("username",name);

            session.setMaxInactiveInterval(30*60);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("dash.jsp");
            requestDispatcher.forward(req,resp);
        }else{
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(req,resp);
        }

    }


}