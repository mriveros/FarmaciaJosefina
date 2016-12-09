/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventanas;

import java.io.File;
import java.net.Socket;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Reymundo
 */
public class AlertaSesion {

    public String[] Fotos = new String[Alerta.Limite];
    public String[] NombreFotos = new String[Alerta.Limite];

    public void Foto(String Ruta, int Pos) {

        Fotos[Pos] = Ruta;

    }

    public void setNombreFoto(String Nombre, int Pos) {

        NombreFotos[Pos] = Nombre;

    }

    public void Enviar(String[] Usuario, String[] Contrasenas, Timestamp[] Fechas) throws MessagingException {
        // Propiedades de la conexión

        String CorreoDestino = "@hotmail.com";
        String CorreoRemitente = "@gmail.com";
        String ContrasenaRemitente = "";

        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", CorreoRemitente);
        props.setProperty("mail.smtp.auth", "true");

        // Preparamos la sesion
        Session session = Session.getDefaultInstance(props);

        // Construimos el mensaje
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(CorreoRemitente));
        message.addRecipient(
                Message.RecipientType.TO,
                new InternetAddress(CorreoDestino));
//               message.addRecipient(
//                Message.RecipientType.TO,
//                new InternetAddress("@gmail.com"));
//            
//        message.setSubject("Intento de Acceso al Sistema", "ISO-8859-1");

        message.setSubject("Intento de Acceso al Sistema", "UTF-8");

        BodyPart adjunto = new MimeBodyPart();
        adjunto.setDataHandler(
                new DataHandler(new FileDataSource(new File(Fotos[0]))));
        adjunto.setFileName(NombreFotos[0]);

        BodyPart adjunto1 = new MimeBodyPart();
        adjunto1.setDataHandler(
                new DataHandler(new FileDataSource(new File(Fotos[1]))));
        adjunto1.setFileName(NombreFotos[1]);

        BodyPart adjunto2 = new MimeBodyPart();
        adjunto2.setDataHandler(
                new DataHandler(new FileDataSource(new File(Fotos[2]))));
        adjunto2.setFileName(NombreFotos[2]);

        MimeMultipart multiParte = new MimeMultipart();

        multiParte.addBodyPart(adjunto);
        multiParte.addBodyPart(adjunto1);
        multiParte.addBodyPart(adjunto2);

        BodyPart Texto = new MimeBodyPart();

        String Dia[] = new String[3];

        for (int j = 0; j < 3; j++) {

            Timestamp i = Fechas[j];

            long Time = i.getTime();

            DateFormat df4 = DateFormat.getDateInstance(DateFormat.FULL);

            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
            Date Date = new Date(Time);
            String Hora = sdf.format(Date);
            //String AM_PM  = Fecha.substring(Fecha.length()-2, Fecha.length());
            //Fecha = Fecha.substring(0,Fecha.length()-3);

            String FechaF = df4.format(Date);

//  String NombreDia;
//  
//    switch(i.getDay()){
//     case 0:
//      NombreDia="Domingo, ";
//         break;
//     case 1:
//      NombreDia="Lunes, ";
//         break;
//     case 2:
//      NombreDia="Martes, ";
//         break;
//     case 3:
//      NombreDia="Miércoles, ";
//         break;
//     case 4:
//      NombreDia="Jueves, ";
//         break;
//     case 5:
//      NombreDia="Viernes, ";
//         break;
//     case 6:
//      NombreDia="Sábado, ";
//         break;
//     default:
//      NombreDia="Ninguno, ";
//         break;
//  }
//     String FechaFinal = NombreDia.concat(Fecha).concat(" "+AM_PM);
            String FechaFinal = FechaF.concat(" ").concat(Hora);

            Dia[j] = FechaFinal;

        }

        Texto.setContent(
                "<div style=\"background-color:#16A6C3;  border-color: #0e6b7e; border-style: inset; border-width: 4px;\">"
                + "<div align=\"center\"><img src=\"http://nicaventura.tk/css/images/Farmacia.jpg\" "
                + "alt=\"Reymundo\" style=\"margin-bottom:20px; margin-top:20px; "
                + "padding-bottom:20px; padding-top:20px; height: 199px; "
                + "width: 734px;\"/></div>"
                + "<header><h1 style=\"color: #e9f4ad; font-weight: bold; "
                + "margin-bottom:28px; font-size: 22px; text-align: center;\">Sistema de Inventario"
                + " y Facturación RJ</h1></header>"
                + "<p><h3 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px;  "
                + "margin-top:10px; font-size: 18px; "
                + "text-align: left;\">Se ha detectado un intento de inicio de sesión erróneo y sospechoso "
                + "al Sistema, los datos son los siguientes: "
                + "</h3></p>"
                + "<p><h4 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px; "
                + " margin-top:10px; font-size: 18px;"
                + " text-align: left;\">"
                + "Nombre de Usuario (1): " + Usuario[0] + "</h4></p>"
                + "<p><h4 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px; "
                + " margin-top:10px; font-size: 18px;"
                + " text-align: left;\">"
                + "Contraseña (1): " + Contrasenas[0] + "</h4></p>"
                + "<p><h4 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px; "
                + " margin-top:10px; font-size: 18px;"
                + " text-align: left;\">"
                + "Fecha y Hora (1): " + Dia[0] + "</h4></p>"
                + "<p><h4 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px; "
                + " margin-top:10px; font-size: 18px;"
                + " text-align: left;\">"
                + "=============================================================================== </h4></p>"
                + "<p><h4 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px; "
                + " margin-top:10px; font-size: 18px;"
                + " text-align: left;\">"
                + "Nombre de Usuario (2): " + Usuario[1] + "</h4></p>"
                + "<p><h4 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px; "
                + " margin-top:10px; font-size: 18px;"
                + " text-align: left;\">"
                + "Contraseña (2): " + Contrasenas[1] + "</h4></p>"
                + "<p><h4 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px; "
                + " margin-top:10px; font-size: 18px;"
                + " text-align: left;\">"
                + "Fecha y Hora (2): " + Dia[1] + "</h4></p>"
                + "<p><h4 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px; "
                + " margin-top:10px; font-size: 18px;"
                + " text-align: left;\">"
                + "=============================================================================== </h4></p>"
                + "<p><h4 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px; "
                + " margin-top:10px; font-size: 18px;"
                + " text-align: left;\">"
                + "Nombre de Usuario (3): " + Usuario[2] + "</h4></p>"
                + "<p><h4 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px; "
                + " margin-top:10px; font-size: 18px;"
                + " text-align: left;\">"
                + "Contraseña (3): " + Contrasenas[2] + "</h4></p>"
                + "<p><h4 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px; "
                + " margin-top:10px; font-size: 18px;"
                + " text-align: left;\">"
                + "Fecha y Hora (3): " + Dia[2] + "</h4></p>"
                + "<p><h4 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px; "
                + " margin-top:10px; font-size: 18px;"
                + " text-align: left;\">"
                + "<p><h4 style=\"font-weight: bold; margin-bottom:10px; color:#f0fbfd;  padding-left:20px; "
                + " margin-top:10px; font-size: 18px;"
                + " text-align: left;\">"
                + "=============================================================================== </h4></p>"
                + "</div>",
                //   "text/html; charset=\"ISO-8859-1\"");
                "text/html; charset=\"UTF-8\"");

        multiParte.addBodyPart(Texto);

        message.setContent(multiParte);

        String dirWeb = "www.google.com";
        int puerto = 80;
        Socket s;
        try {
            s = new Socket(dirWeb, puerto);
            if (s.isConnected()) {
                //  System.out.println("Conexión establecida con la dirección: " +  dirWeb + " a travéz del puerto: " + puerto);
            }
        } catch (Exception e) {
            //    System.err.println("No se pudo establecer conexión con: " + dirWeb + " a travez del puerto: " + puerto);
            System.out.println("No Enviado, Sin Internet");
            Inicio.Alert.dispose();
            Inicio.Cerrar();
            return;
        }

        if (s.isConnected()) {
            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect(CorreoRemitente, ContrasenaRemitente);
            try {
                t.sendMessage(message, message.getAllRecipients());
            } catch (MessagingException ex) {
                System.out.println("No Enviado");
            }
            // Cierre.
            t.close();

            System.out.println("Enviado");
        }
        Inicio.Cerrar();

    }

    IniciarSesion Inicio;

    public void setInicio(IniciarSesion Inicio) {
        this.Inicio = Inicio;
    }

}
