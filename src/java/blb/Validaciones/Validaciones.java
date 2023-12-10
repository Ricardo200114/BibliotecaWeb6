package blb.Validaciones;

import java.text.ParseException;
import java.util.Date;

public class Validaciones {

//    public static String fechaActual() {
//        Date ahora = new Date();
//        SimpleDateFormat formateador = new SimpleDateFormat("yyyy/MM/dd");
//        return formateador.format(ahora);
//    }

    public static java.sql.Date fecha() {
        
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        return sqlDate;
    }

    public static int calcularDias(Date fInicial, Date fFinal) throws ParseException {

        int milisecondsByDay = 86400000;
        int dias = (int) ((fFinal.getTime() - fInicial.getTime()) / milisecondsByDay);

        return dias;
    }

}
