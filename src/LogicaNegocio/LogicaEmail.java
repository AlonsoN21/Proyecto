package LogicaNegocio;

import AccesoDatos.AccesoDatos;
import Entidades.DeduccionesAumentos;
import Entidades.Nomina;
import Entidades.DeduccionesPatrono;
import Entidades.Empleado;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.*;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Popi1
 */
public class LogicaEmail {


////Atributos de la clase, ejemplo servidor profe:
    private final String host = "securemail.comredcr.com"; //Tipo: smtp.example.com
    private final String username = "curso_progra2@comredcr.com";
    private final String password = "u6X1h1p9@";
    private final Properties props = new Properties();
    private static AccesoDatos objAccesoDatos;


    
public File GenerartablaAPDF(ArrayList<String[]> listaUsuarios) throws IOException, DocumentException {
        // Crear un nuevo documento PDF
        Document document = new Document();
        // Crear un archivo temporal para el PDF
        File pdfFile = File.createTempFile("tabla_nomina_", ".pdf");

        try (FileOutputStream fos = new FileOutputStream(pdfFile)) {
            PdfWriter.getInstance(document, fos);
            document.open();

            // Crear la tabla en el PDF
            String[] columnNames = {"Nombre", "Cédula", "Aporte SS Empleado", "Aporte SS Patrón", "Renta", "Salario Neto"};
            PdfPTable pdfTable = new PdfPTable(columnNames.length);

            // Configurar anchos de columna
            float[] columnWidths = new float[]{3f, 2f, 2f, 2f, 2f, 2f}; // Ajustar los valores según sea necesario
            pdfTable.setWidths(columnWidths);

            // Agregar encabezado de la tabla
            for (String columnName : columnNames) {
                PdfPCell cell = new PdfPCell(new Phrase(columnName));
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setPadding(5f); // Ajustar el padding si es necesario
                pdfTable.addCell(cell);
            }

            // Variables para acumular los totales
            double totalAporteEmpleado = 0;
            double totalAportePatrono = 0;
            double totalRenta = 0;
            double totalSalarioNeto = 0;

            // Agregar filas de la tabla
            for (String[] usuarioData : listaUsuarios) {
                // Asegúrate de que los índices estén correctos para cada campo
                String nombre = usuarioData[2]; // Suponiendo que el nombre está en la primera posición
                String cedula = usuarioData[3]; // Suponiendo que la cédula está en la segunda posición

                // Verificar que los siguientes elementos son numéricos antes de convertirlos
                try {
                    double aporteEmpleado = Double.parseDouble(usuarioData[10]); // Aporte SS Empleado
                    double aportePatrono = Double.parseDouble(usuarioData[11]);  // Aporte SS Patrón
                    double renta = Double.parseDouble(usuarioData[9]);          // Renta
                    double salarioNeto = Double.parseDouble(usuarioData[12]);    // Salario Neto

                    // Acumular los totales
                    totalAporteEmpleado += aporteEmpleado;
                    totalAportePatrono += aportePatrono;
                    totalRenta += renta;
                    totalSalarioNeto += salarioNeto;

                    // Agregar celdas a la tabla PDF
                    pdfTable.addCell(nombre); // Nombre
                    pdfTable.addCell(cedula); // Cédula
                    pdfTable.addCell(String.valueOf(aporteEmpleado)); // Aporte SS Empleado
                    pdfTable.addCell(String.valueOf(aportePatrono)); // Aporte SS Patrón
                    pdfTable.addCell(String.valueOf(renta)); // Renta
                    pdfTable.addCell(String.valueOf(salarioNeto)); // Salario Neto
                } catch (NumberFormatException e) {
                    // Manejar la excepción si no se puede convertir un valor a double
                    System.err.println("Error al convertir uno de los valores a número: " + e.getMessage());
                }
            }

            // Agregar fila de totales
            PdfPCell emptyCell = new PdfPCell(new Phrase("")); // Celda vacía para Nombre
            emptyCell.setBackgroundColor(new BaseColor(173, 216, 230)); // Color celeste ligero
            emptyCell.setPadding(5f);
            pdfTable.addCell(emptyCell); // Columna de Nombre

            PdfPCell totalLabelCell = new PdfPCell(new Phrase("TOTAL ₡"));
            totalLabelCell.setBackgroundColor(new BaseColor(173, 216, 230)); // Color celeste ligero
            totalLabelCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            totalLabelCell.setPadding(5f);
            pdfTable.addCell(totalLabelCell); // Columna de Cédula

            // Crear y agregar celdas con los totales con color celeste
            PdfPCell totalCell = new PdfPCell(new Phrase(String.format("%.2f", totalAporteEmpleado)));
            totalCell.setBackgroundColor(new BaseColor(173, 216, 230)); // Color celeste ligero
            totalCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            totalCell.setPadding(5f);
            pdfTable.addCell(totalCell); // Columna de Aporte SS Empleado

            totalCell = new PdfPCell(new Phrase(String.format("%.2f", totalAportePatrono)));
            totalCell.setBackgroundColor(new BaseColor(173, 216, 230)); // Color celeste ligero
            totalCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            totalCell.setPadding(5f);
            pdfTable.addCell(totalCell); // Columna de Aporte SS Patrón

            totalCell = new PdfPCell(new Phrase(String.format("%.2f", totalRenta)));
            totalCell.setBackgroundColor(new BaseColor(173, 216, 230)); // Color celeste ligero
            totalCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            totalCell.setPadding(5f);
            pdfTable.addCell(totalCell); // Columna de Renta

            totalCell = new PdfPCell(new Phrase(String.format("%.2f", totalSalarioNeto)));
            totalCell.setBackgroundColor(new BaseColor(173, 216, 230)); // Color celeste ligero
            totalCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            totalCell.setPadding(5f);
            pdfTable.addCell(totalCell); // Columna de Salario Neto

            document.add(pdfTable);
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
            throw new DocumentException("Error al crear el PDF", e);
        }

        return pdfFile;
    }

    //Metodo que genera el formato del correo(recibe elementos de la clase usuario(no todos) y el documento adjunto que en este caso es un pdf
    public void enviarCorreo(String correoDestino, String asunto, String mensaje, Object archivoAdjunto) throws MessagingException, IOException, DocumentException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        // Convertir archivo de texto a PDF
        String pdfFilePath = "Usuario.pdf";

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(correoDestino));
            message.setSubject(asunto);

            // Cuerpo del mensaje
            MimeBodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setContent(mensaje, "text/plain");

            // Adjuntar archivo PDF
            MimeBodyPart attachmentPart = new MimeBodyPart();
            DataSource source = new FileDataSource(pdfFilePath);
            attachmentPart.setDataHandler(new DataHandler(source));
            attachmentPart.setFileName(source.getName());

            // Combinar cuerpo del mensaje y archivo adjunto
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            multipart.addBodyPart(attachmentPart);

            // Establecer el contenido del mensaje
            message.setContent(multipart);

            // Enviar el mensaje
            Transport.send(message);

            // Eliminar el archivo PDF después de enviar el correo
            File pdfFile = new File(pdfFilePath);
            if (pdfFile.exists()) {
                pdfFile.delete();
            }

        } catch (MessagingException e) {
            throw new MessagingException("Error al enviar el correo: " + e.getMessage());
        } finally {
            // Asegurarse de eliminar el archivo PDF en caso de excepción
            File pdfFile = new File(pdfFilePath);
            if (pdfFile.exists()) {
                pdfFile.delete();
            }
        }
    }

    public Document crearPDF(Empleado objUsuario, Nomina objNomina, DeduccionesAumentos objDeducciones, DeduccionesPatrono objPatrono) throws IOException, DocumentException {
        // Ruta donde se guardará el archivo PDF
        String pdfFilePath = "Usuario.pdf";

        // Crear el documento PDF
        Document document;
        document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, new FileOutputStream(pdfFilePath));

        // Abrir el documento para comenzar a escribir contenido
        document.open();

        // Establecer fuente y estilos personalizados
        Font fontTitulo = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
        Font fontNormal = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.NORMAL);
        Font fontNormalBold = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
        Font fontPequ = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD);
        Font fontNormalBoldNeto = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLD);

        // Título del documento
        Paragraph titulo = new Paragraph("Nombre Empresa", fontTitulo);
        titulo.setAlignment(Paragraph.ALIGN_CENTER);
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedNow = now.format(formatter);
        PdfPTable table = new PdfPTable(2);
        PdfPTable table2 = new PdfPTable(2);

        // Ajustar el espaciado entre las celdas (cell spacing)
        table2.setSpacingBefore(5f);
        table2.setSpacingAfter(5f);
        Paragraph hora = new Paragraph("""
                                         Hora de envio 
                                         """ + formattedNow, fontPequ);
        Paragraph plantillaAdmi = new Paragraph("""
                                         Plantilla Administrativa de Julio
                                         """, fontPequ);
        Paragraph linea = new Paragraph("________________________________________________________________________");
        //creamos lo parrafos con la informacion del usuario
        Paragraph nombre = new Paragraph("Nombre", fontNormalBold);
        Paragraph nombre2 = new Paragraph(objUsuario.getNombre(), fontNormal);
        Paragraph cedula = new Paragraph("Cedula", fontNormalBold);
        Paragraph cedula2 = new Paragraph(objUsuario.getCedula(), fontNormal);
        Paragraph correo = new Paragraph("Correo", fontNormalBold);
        Paragraph correo2 = new Paragraph(objUsuario.getCorreo(), fontNormal);
        Paragraph salarioBruto = new Paragraph("Salario Bruto", fontNormalBold);
        Paragraph salarioBruto2 = new Paragraph(String.valueOf(objUsuario.getSalario()), fontNormal);
        Paragraph valorHoraOrdinaria = new Paragraph("Valor Hora Ordinaria", fontNormalBold);
        Paragraph valorHoraOrdinaria2 = new Paragraph(String.valueOf(objDeducciones.getValorHoraOrdinaria()), fontNormal);
        Paragraph diasRebajar = new Paragraph("Días Rebajados", fontNormalBold);
        Paragraph diasRebajar2 = new Paragraph(String.valueOf(objNomina.getDiasNoLaborados()), fontNormal);
        Paragraph horasExtra = new Paragraph("Horas Extras (x1.5)", fontNormalBold);
        Paragraph horasExtra2 = new Paragraph(String.valueOf(objDeducciones.getHorasExtra()), fontNormal);
        Paragraph renta = new Paragraph("Rebajo de Renta", fontNormalBold);
        Paragraph renta2 = new Paragraph(String.valueOf(objDeducciones.getRenta()), fontNormal);
        Paragraph aporteCCSS = new Paragraph("Rebajo CCSS (10,67%)", fontNormalBold);
        Paragraph aporteCCSS2 = new Paragraph(String.valueOf(objPatrono.getCcssPagarIndividual()), fontNormal);
        Paragraph salarioNeto = new Paragraph("Salario Neto", fontNormalBoldNeto);
        Paragraph salarioNeto2 = new Paragraph(String.valueOf(objNomina.getSalarioNeto()), fontNormalBoldNeto);

        // Crear celdas para los párrafos
        PdfPCell cell1 = new PdfPCell(hora);
        PdfPCell cell2 = new PdfPCell(plantillaAdmi);
        PdfPCell cell21 = new PdfPCell(nombre);
        PdfPCell cell22 = new PdfPCell(nombre2);
        PdfPCell cell3 = new PdfPCell(cedula);
        PdfPCell cell4 = new PdfPCell(cedula2);
        PdfPCell cell5 = new PdfPCell(correo);
        PdfPCell cell6 = new PdfPCell(correo2);
        PdfPCell cell7 = new PdfPCell(salarioBruto);
        PdfPCell cell8 = new PdfPCell(salarioBruto2);
        PdfPCell cell9 = new PdfPCell(diasRebajar);
        PdfPCell cell10 = new PdfPCell(diasRebajar2);
        PdfPCell cell11 = new PdfPCell(horasExtra);
        PdfPCell cell12 = new PdfPCell(horasExtra2);
        PdfPCell cell13 = new PdfPCell(renta);
        PdfPCell cell14 = new PdfPCell(renta2);
        PdfPCell cell15 = new PdfPCell(aporteCCSS);
        PdfPCell cell16 = new PdfPCell(aporteCCSS2);
        PdfPCell cell17 = new PdfPCell(salarioNeto);
        PdfPCell cell18 = new PdfPCell(salarioNeto2);
        PdfPCell cell19 = new PdfPCell(valorHoraOrdinaria);
        PdfPCell cell20 = new PdfPCell(valorHoraOrdinaria2);

        // Configurar celdas (opcional)
        cell1.setBorder(0); // Sin borde
        cell2.setBorder(0); // Sin borde
        cell3.setBorder(0); // Sin borde
        cell4.setBorder(0); // Sin borde
        cell5.setBorder(0); // Sin borde
        cell6.setBorder(0); // Sin borde
        cell7.setBorder(0); // Sin borde
        cell8.setBorder(0); // Sin borde
        cell9.setBorder(0); // Sin borde
        cell10.setBorder(0); // Sin borde
        cell11.setBorder(0); // Sin borde
        cell12.setBorder(0); // Sin borde
        cell13.setBorder(0); // Sin borde
        cell14.setBorder(0); // Sin borde
        cell15.setBorder(0); // Sin borde
        cell16.setBorder(0); // Sin borde
        cell17.setBorder(0); // Sin borde
        cell18.setBorder(0); // Sin borde
        cell19.setBorder(0); // Sin borde
        cell20.setBorder(0); // Sin borde
        cell21.setBorder(0); // Sin borde
        cell22.setBorder(0); // Sin borde

        // Añadir celdas a la tabla
        table.addCell(cell1);
        table.addCell(cell2);
        table2.addCell(cell21);
        table2.addCell(cell22);
        table2.addCell(cell3);
        table2.addCell(cell4);
        table2.addCell(cell5);
        table2.addCell(cell6);
        table2.addCell(cell7);
        table2.addCell(cell8);
        table2.addCell(cell19);
        table2.addCell(cell20);
        table2.addCell(cell9);
        table2.addCell(cell10);
        table2.addCell(cell11);
        table2.addCell(cell12);
        table2.addCell(cell13);
        table2.addCell(cell14);
        table2.addCell(cell15);
        table2.addCell(cell16);
        table2.addCell(cell17);
        table2.addCell(cell18);

        // Añadir  al documento
        document.add(titulo);
        document.add(new Paragraph(" "));
        document.add(linea);
        document.add(new Paragraph(" "));
        document.add(table);
        document.add(new Paragraph(" "));
        document.add(new Paragraph(" "));
        document.add(table2);
        document.add(linea);
        // Agregar contenido del archivo de texto (Datos del empleado)
        /* BufferedReader br = new BufferedReader(new FileReader(archivoTxt));
        String linea;
        while ((linea = br.readLine()) != null) {
            document.add(new Paragraph(linea, fontNormal));
        }
        br.close();
         */

        // Cerrar el documento
        document.close();

        System.out.println("PDF generado correctamente en: " + pdfFilePath);
        return document;

    }

    public void enviarCorreo2(String destinatario, String asunto, String mensaje, String archivoAdjunto) throws MessagingException {
        // Configuración del servidor SMTP para Gmail
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        // Autenticación
        String usuario = "matarritasmtp@gmail.com";
        String contrasena = "miia quyf qtgy wmuv";
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, contrasena);
            }
        });

        // Crear el mensaje de correo
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(usuario));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
        message.setSubject(asunto);

        // Crear el contenido del correo
        BodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setText(mensaje);

        // Crear el multipart
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        // Añadir archivo adjunto
        if (archivoAdjunto != null && !archivoAdjunto.isEmpty()) {
            messageBodyPart = new MimeBodyPart();
            File file = new File(archivoAdjunto);
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(file.getName());
            multipart.addBodyPart(messageBodyPart);
        }

        // Enviar el mensaje
        message.setContent(multipart);
        Transport.send(message);
    }

   

}
