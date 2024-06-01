package com.example.oop_lr7n;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/nav"})
@MultipartConfig
public class HelloServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        int pageNumber = Integer.parseInt(request.getParameter("page"));

        switchPageTo(pageNumber, request, response);
    }

    private void switchPageTo(int pageNumber, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String path = "";
        switch (pageNumber)
        {
            case 2 -> path = "index2.html";
            case 3 -> path = "index3.html";
            case 4 -> path = "index4.html";
            case 5 -> path = "index5.html";
            default -> response.sendError(HttpServletResponse.SC_NOT_FOUND, "Страница не найдена");
        }

        if (path.isEmpty())
            return;

        RequestDispatcher view = request.getRequestDispatcher(path);
        view.forward(request, response);
    }
}




