package co.develhope.esercizio2.Interceptors;

import co.develhope.esercizio2.Entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    public List<Month> monthsList(){
        List<Month> monthsList = new ArrayList<>();

        monthsList.add(new Month(1, "Genuary", "Gennaio", "Genken"));
        monthsList.add(new Month(2, "February", "Febbraio", "Febbren"));
        monthsList.add(new Month(3, "March", "Marzo", "Marzz"));
        monthsList.add(new Month(4, "April", "Aprile", "Aprkil"));
        monthsList.add(new Month(5, "May", "Maggio", "Maken"));
        monthsList.add(new Month(6, "June", "Giugno", "Junken"));
        return monthsList;

    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       String monthNumberString = request.getHeader("monthNumber");
       if (monthNumberString == null || monthNumberString.isEmpty()) {
           response.sendError(HttpStatus.BAD_REQUEST.value());
           return false;
       }
       for (Month month : monthsList()){
           if (month.getMonthNumber()==Integer.parseInt(monthNumberString)){
               request.setAttribute("selectMonth", month);
               return true;
           }
       }
       Month emptyMonth = new Month(0,"nop", "nop","nop");
       request.setAttribute("selectMonth", emptyMonth);
       return true;
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
