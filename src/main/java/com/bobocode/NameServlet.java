package com.bobocode;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

import static com.bobocode.AppConfig.SPRING_APP_CONTEXT;


@WebServlet("/name")
public class NameServlet extends HttpServlet {


    @Override
    public void init(ServletConfig config) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        config.getServletContext().setAttribute(SPRING_APP_CONTEXT, appContext);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        AnnotationConfigApplicationContext appContext = (AnnotationConfigApplicationContext) req.getServletContext().getAttribute(SPRING_APP_CONTEXT);
        NameProvider bean = appContext.getBean(NameProvider.class);
        resp.getWriter().println(bean.getName());
    }
}
