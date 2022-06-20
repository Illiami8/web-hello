package Cherepovski;

import com.cherepovski.Teacher;
import com.cherepovski.logic.Statistic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@WebServlet(urlPatterns = "/avarage-salary")
public class Accounting extends HttpServlet {

    private List<Teacher> teachers;

    private Statistic statictic;



    @Override
    public void init() throws ServletException {
        statictic= new Statistic();
        unitModel();
    }
 private BigDecimal averegeSalary(List<Teacher> teachers){
       List<Integer> salaries = teachers.stream()
                .map(Teacher :: getAge)
                .collect(Collectors.toList());
       return statictic.averege(salaries);
 }

    private void unitModel() {
        teachers = new ArrayList<>();
        teachers.add(new Teacher("Alex",29,1000));
        teachers.add(new Teacher("Vasia",32,1200));
        teachers.add(new Teacher("Igor",38,1900));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     resp.setContentType("text/html");
     resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("<h2>Список преподов" + averegeSalary(teachers));
teachers.forEach(teacher -> writer.write(teacher + "<p>"));
}
public OptionalDouble avarage(List<Teacher> teachers){
return teachers.stream()
        .mapToInt(Teacher :: getAge)
        .average();
}
    }


