package ifsuldeminas.pas.bcc.helloworld.controler;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalendarController {
    private Calendar calendar;

    public CalendarController(){
        calendar = Calendar.getInstance();
    }
@GetMapping("/calendar/today")
    public String today(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = calendar.getTime();
        String formattedDate = dateFormat.format(currentDate);
        return "Hoje e " + formattedDate;
    }
@GetMapping("/calendar/tomorrow")
    public String tomorrow(){
        calendar.add(Calendar.DAY_OF_MONTH,1);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
        Date tomorrowDate = calendar.getTime();
        String formattedTomorrow = dateFormat.format(tomorrowDate);
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        return "Amanha sera " + formattedTomorrow;
    }
}
