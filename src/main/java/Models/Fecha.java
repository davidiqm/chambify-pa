
package Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Fecha {
    public static String fechaHoy()
    {
        Date fecha = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(fecha);
    }
    public static String horaHoy()
    {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
