package cpavision_pdf;

import com.itextpdf.text.BaseColor;
import java.awt.Color;
import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import com.itextpdf.text.Image;
import java.util.List;

public class cfdi_to_pdf {

    private List<cfdi_xml_data> xml_data;
    private List<cfdi_xml_data_receptor> xml_data_receptor;
    private List<cfdi_xml_data_uuid> xml_data_uuid;
    private List<cfdi_xml_data_hdr_tbl> xml_data_hdr_tbl;
    private List<cfdi_xml_data_conceptos> xml_data_conceptos;
    private List<cfdi_xml_data_pedimentos> xml_data_pedimentos;

    // Constructor que acepta la lista xml_data
    public cfdi_to_pdf(
            List<cfdi_xml_data> xml_data,
            List<cfdi_xml_data_receptor> xml_data_receptor,
            List<cfdi_xml_data_uuid> xml_data_uuid,
            List<cfdi_xml_data_hdr_tbl> xml_data_hdr_tbl,
            List<cfdi_xml_data_conceptos> xml_data_conceptos,
            List<cfdi_xml_data_pedimentos> xml_data_pedimentos
    ) {
        this.xml_data = xml_data;
        this.xml_data_receptor = xml_data_receptor;
        this.xml_data_uuid = xml_data_uuid;
        this.xml_data_hdr_tbl = xml_data_hdr_tbl;
        this.xml_data_conceptos = xml_data_conceptos;
        this.xml_data_pedimentos = xml_data_pedimentos;
    }

    public void plantilla() {
        String rutaGuardado = "C:\\cfdi_uuid\\2024\\pdfs\\Plantilla_CFDI.pdf";

        try {

            // Crear un documento PDF
            Document document = new Document(PageSize.A4);

            // Inicializar la salida del PDF
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(rutaGuardado));
            document.open();
            PdfContentByte cb = writer.getDirectContent();

            // Definir la fuente
            BaseFont baseFont = BaseFont.createFont("c:/windows/fonts/brlnsr.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            Font font = new Font(baseFont, 10);
            Font fontTableh = new Font(baseFont, 8);
            Font fontTablecfdis = new Font(baseFont, 6);

            // Obtiene datos de la lista
            String rfcEmisor = xml_data.get(0).getrfcEmisor();
            String nombreEmisor = xml_data.get(0).getnombreEmisor();
            String regFiscalEmisor = xml_data.get(0).getregFiscalEmisor();

            // Escribir detalles del Emisor
            cb.setRGBColorFillF(0, 0, 1); // Azul
            writeText(cb, baseFont, "Datos del Emisor:", 35, 800, font);
            cb.resetRGBColorFill(); // Restablecer el color a negro
            writeText(cb, baseFont, nombreEmisor, 35, 790, font);
            writeText(cb, baseFont, "RFC: " + rfcEmisor + " Régimen Fiscal: " + regFiscalEmisor, 35, 780, font);

            // Obtiene datos de la lista
            String rfcReceptor = xml_data_receptor.get(0).getrfcReceptor();
            String nombreReceptor = xml_data_receptor.get(0).getnombreReceptor();
            String regFiscalReceptor = xml_data_receptor.get(0).getregFiscalReceptor();
            String domFiscalReceptor = xml_data_receptor.get(0).getdomfisReceptor();
            String usoCfdiReceptor = xml_data_receptor.get(0).getusocfdiReceptor();

            // Escribir detalles del Receptor
            cb.setRGBColorFillF(0, 0, 1); // Azul
            writeText(cb, baseFont, "Datos del Receptor:", 35, 760, font);
            cb.resetRGBColorFill(); // Restablecer el color a negro
            writeText(cb, baseFont, nombreReceptor, 35, 750, font);
            writeText(cb, baseFont, "RFC: " + rfcReceptor + " Uso CFDI: " + usoCfdiReceptor, 35, 740, font);
            writeText(cb, baseFont, "Domicilio Fiscal: " + domFiscalReceptor, 35, 730, font);
            writeText(cb, baseFont, "Regimen Fiscal: " + regFiscalReceptor, 35, 720, font);

            // Crear una tabla
            PdfPTable tableh = new PdfPTable(1);
            tableh.setTotalWidth(170); // Establecer la anchura total de la tabla en puntos
            tableh.setLockedWidth(true); // Bloquear la anchura de la tabla
            float[] columnWidthsh = {2}; // Ancho de las columnas
            tableh.setWidths(columnWidthsh);

            // Obtiene datos de la lista
            String uuid = xml_data_uuid.get(0).getuuid();

            String certificado = xml_data_hdr_tbl.get(0).getcertificado();
            String fechaexp = xml_data_hdr_tbl.get(0).getfecha();
            String lugarexp = xml_data_hdr_tbl.get(0).getlugarexp();
            String monedafol = xml_data_hdr_tbl.get(0).getmoneda();
            String tipocomprobante = xml_data_hdr_tbl.get(0).gettipocomprobante();
            String serie = xml_data_hdr_tbl.get(0).getserie();
            String folio = xml_data_hdr_tbl.get(0).getfolio();

            // Variables para guardar los textos
            String folioFiscal = "Folio Fiscal: \n" + uuid;
            String noSerieCSD = "No de Serie del CSD: " + certificado;
            String fechaHoraEmision = "Fecha y hora de emisión: " + fechaexp;
            String lugarEmision = "Lugar de emisión: " + lugarexp;
            String moneda = "Moneda: " + monedafol;
            String efectoComprobante = "Efecto del Comprobante: " + tipocomprobante;
            String serieFolio = "Serie y Folio: " + serie + " " + folio;

            // Textos para cada celda en la fila adicional
            String[] textsh = {folioFiscal, noSerieCSD, fechaHoraEmision, lugarEmision, moneda, efectoComprobante, serieFolio};

            // Agregar una fila con los textos especificados
            for (String text : textsh) {
                PdfPCell cell = new PdfPCell(new Phrase(text, fontTableh));
                tableh.addCell(cell);
            }

            // Agregar la tabla al documento en la coordenada Y 700
            tableh.writeSelectedRows(0, -1, 380, 800, writer.getDirectContent());

            // Crear una tabla
            PdfPTable table = new PdfPTable(8);
            table.setTotalWidth(520); // Establecer la anchura total de la tabla en puntos
            table.setLockedWidth(true); // Bloquear la anchura de la tabla
            float[] columnWidths = {0.8f, 0.8f, 0.7f, 0.5f, 0.7f, 3, 0.8f, 0.8f}; // Ancho de las columnas
            table.setWidths(columnWidths);

            // Textos para cada celda en la fila adicional
            String[] texts = {"ClaveProducto o Servicio", "Numero de Identificacion", "cantidad", "Clave Unidad", "Unidad", "Descripcion", "Valor Unitario", "Importe"};

            // Agregar una fila con los textos especificados
            for (String text : texts) {
                PdfPCell cell = new PdfPCell(new Phrase(text, fontTableh));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER); // Centrar el texto horizontalmente
                table.addCell(cell);
            }

            // Suponiendo que tienes los datos para la nueva fila en un arreglo
            //String[] rowData = {"Dato 1", "Dato 2", "Dato 3", "Dato 4", "Dato 5", "Dato 6", "Dato 7", "Dato 8"};
            // Agregar una fila con los datos especificados
            for (cfdi_xml_data_conceptos concepto : xml_data_conceptos) {
                // Agregar una fila para el concepto actual
                table.addCell(new PdfPCell(new Phrase(concepto.getClaveProdServ(), fontTableh)));
                table.addCell(new PdfPCell(new Phrase(concepto.getNoIdentificacion(), fontTableh)));
                table.addCell(new PdfPCell(new Phrase(concepto.getCantidad(), fontTableh)));
                table.addCell(new PdfPCell(new Phrase(concepto.getClaveUnidad(), fontTableh)));
                table.addCell(new PdfPCell(new Phrase(concepto.getUnidad(), fontTableh)));
                table.addCell(new PdfPCell(new Phrase(concepto.getDescripcion(), fontTableh)));
                table.addCell(new PdfPCell(new Phrase(concepto.getValorUnitario(), fontTableh)));
                table.addCell(new PdfPCell(new Phrase(concepto.getImporte(), fontTableh)));

                // Agregar una fila adicional al final de la tabla por cada concepto
                PdfPCell finalCell = new PdfPCell(new Phrase(concepto.getCadenarow(), fontTableh));
                finalCell.setColspan(8); // Unificar todas las columnas en una sola celda
                table.addCell(finalCell);

                for (cfdi_xml_data_pedimentos pedimento : xml_data_pedimentos) {
                    PdfPCell infoaduana = new PdfPCell(new Phrase(pedimento.getnumeroPedimento(), fontTableh));
                    infoaduana.setColspan(8); // Unificar todas las columnas en una sola celda
                    table.addCell(infoaduana);
                }

            }

            // Agregar la tabla al documento en la coordenada Y 700
            table.writeSelectedRows(0, -1, 35, 700, writer.getDirectContent());

            PdfPTable tabletotal = new PdfPTable(2); // 2 columnas
            tabletotal.setTotalWidth(115); // Establecer la anchura total de la tabla en puntos
            tabletotal.setLockedWidth(true); // Bloquear la anchura de la tabla
            float[] columnWidthstotal = {1f, 1f}; // Ancho de las columnas
            tabletotal.setWidths(columnWidthstotal);

            // Definir los anchos de las columnas en proporciones
            float[] columnTotals = {2, 3}; // por ejemplo, una proporción de 2:3
            tabletotal.setWidths(columnTotals);

            // Datos para llenar la tabla (2 columnas x 3 filas)
            String[] cellTexts = {"Subtotal", "28805.72",
                "IVA Tra 16.00%", "28805.72",
                "Total", "28805.72"};

            // Agregar datos a la tabla
            for (String text : cellTexts) {
                PdfPCell cell = new PdfPCell(new Phrase(text, fontTableh));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER); // Centrar el texto horizontalmente
                tabletotal.addCell(cell);
            }

            // Agregar la tabla al documento en la coordenada Y 498 (ajuste si es necesario)
            tabletotal.writeSelectedRows(0, -1, 440, 285, writer.getDirectContent());

            // Escribir detalles del Receptor
            cb.setRGBColorFillF(0, 0, 1); // Azul
            writeText(cb, baseFont, "Forma de Pago: ", 35, 275, font);
            cb.resetRGBColorFill(); // Restablecer el color a negro
            writeText(cb, baseFont, "30 Aplicación de anticipos", 115, 275, font);

            cb.setRGBColorFillF(0, 0, 1); // Azul
            writeText(cb, baseFont, "Moneda: ", 35, 265, font);
            cb.resetRGBColorFill(); // Restablecer el color a negro
            writeText(cb, baseFont, "MXN Peso Mexicano", 115, 265, font);

            cb.setRGBColorFillF(0, 0, 1); // Azul
            writeText(cb, baseFont, "Tipo de Cambio: ", 35, 255, font);
            cb.resetRGBColorFill(); // Restablecer el color a negro
            writeText(cb, baseFont, "1", 115, 255, font);

            cb.setRGBColorFillF(0, 0, 1); // Azul
            writeText(cb, baseFont, "Metodo de Pago: ", 35, 245, font);
            cb.resetRGBColorFill(); // Restablecer el color a negro
            writeText(cb, baseFont, "30 Aplicación de anticipos", 115, 245, font);

            cb.setRGBColorFillF(0, 0, 1); // Azul
            writeText(cb, baseFont, "Total con Letra: ", 35, 235, font);
            cb.resetRGBColorFill(); // Restablecer el color a negro
            writeText(cb, baseFont, "(Treinta y tres mil cuatrocientos catorce pesos 64/100 MXN)", 115, 235, font);

            writeText(cb, baseFont, "CFDI Ralacionado: (267B0924-6C63-4118-8D69-0098E5A39C94)", 35, 215, font);

            cb.setRGBColorFillF(0, 0, 1); // Azul
            writeText(cb, baseFont, "Relacion: ", 35, 205, font);
            cb.resetRGBColorFill(); // Restablecer el color a negro
            writeText(cb, baseFont, "07 CFDI por aplicación de anticipo", 115, 205, font);

            cb.setRGBColorFillF(0, 0, 1); // Azul
            writeText(cb, baseFont, "Sello Digital del CFDI: ", 35, 185, font);
            cb.resetRGBColorFill(); // Restablecer el color a negro
            // Crear una tabla
            PdfPTable tablecfdi = new PdfPTable(1);
            tablecfdi.setTotalWidth(254); // Establecer la anchura total de la tabla en puntos
            tablecfdi.setLockedWidth(true); // Bloquear la anchura de la tabla
            tablecfdi.setWidths(columnWidthsh);

            // Variables para guardar los textos con color azul
            String sellocfdi = "Wf41WXX7MHw10ThrW9rsa3ow7KpVGWX9oVH9s/+FHoYFs4MwwZYYhLfTNgEdk4POqvizcavKh\n"
                    + "9ohvmaOg8m8NCu4NH2NdN5+HnXget54ol2imO2bWHF8w+U0+SDKwqk8fZimxb1HsLcnqfcL8AnX\n"
                    + "+Oy31UDfJgvRylTlzgIw5seH2vLhdAfv98uLpn7vVoWD8uY4htPqzof61Cq4fnGpkqJ3RU+433jylU4nJ\n"
                    + "/nkTLz05Ezy0eS7duQvbJKehHHoh8Sz7Ogd/0BgAh3jYLvPVVyur1rCGXekiukSKKs2X7sq8z5WzdA\n"
                    + "nDjumiUPOVS/ItO12Ia7pmp2ogWw4P0U+aQ==";

            // Textos para cada celda en la fila adicional
            String[] textcfdi = {sellocfdi};

            // Agregar una fila con los textos especificados
            for (String text : textcfdi) {
                PdfPCell cell = new PdfPCell(new Phrase(text, fontTablecfdis));
                tablecfdi.addCell(cell);
            }

            // Agregar la tabla al documento en la coordenada Y 700
            tablecfdi.writeSelectedRows(0, -1, 35, 180, writer.getDirectContent());

            cb.setRGBColorFillF(0, 0, 1); // Azul
            writeText(cb, baseFont, "Sello del SAT: ", 300, 185, font);
            cb.resetRGBColorFill(); // Restablecer el color a negro
            // Crear una tabla
            PdfPTable tablesellosat = new PdfPTable(1);
            tablesellosat.setTotalWidth(254); // Establecer la anchura total de la tabla en puntos
            tablesellosat.setLockedWidth(true); // Bloquear la anchura de la tabla
            tablesellosat.setWidths(columnWidthsh);

            // Variables para guardar los textos con color azul
            String sellosat = "MWJ4GirNwhBrt8jXidD++KabX4C7uBpeDh23/WA2NW7HeUgXFU/9Aa3BCRPI66yRWbhgcTnSem\n"
                    + "cn4neL/w9JpaLzfxzvIDiz4M290mZwiKuyaqU47jjCh+yajbvlIlengzNRa+3k5pDJC+gY+v9IMaWu4Mi4\n"
                    + "bs22PbAifQeKoxX3c+CNzXpDq8mGZqLyaHhdhzlSfrGNUGKbs0NraeQbxQbrhE7eTDLIS4a+DzPNl\n"
                    + "fFM59QHvGBvdkdNJjEqpxS0hB5wH2xOaDnzggAjEcxX9k3AWrm2isfwEyB9O3AbJ1YeaJJCst5/5fK\n"
                    + "yqngHommjwcEfpE/sRuf1v3W0b35xaQ==";

            // Textos para cada celda en la fila adicional
            String[] textsellosat = {sellosat};

            // Agregar una fila con los textos especificados
            for (String text : textsellosat) {
                PdfPCell cell = new PdfPCell(new Phrase(text, fontTablecfdis));
                tablesellosat.addCell(cell);
            }

            // Agregar la tabla al documento en la coordenada Y 700
            tablesellosat.writeSelectedRows(0, -1, 300, 180, writer.getDirectContent());

            cb.setRGBColorFillF(0, 0, 1); // Azul
            writeText(cb, baseFont, "Cadena Original del Complemento de Certificacion Digital del SAT: ", 160, 135, font);
            cb.resetRGBColorFill(); // Restablecer el color a negro
            // Crear una tabla
            PdfPTable tablecods = new PdfPTable(1);
            tablecods.setTotalWidth(395); // Establecer la anchura total de la tabla en puntos
            tablecods.setLockedWidth(true); // Bloquear la anchura de la tabla
            tablecods.setWidths(columnWidthsh);

            // Variables para guardar los textos con color azul
            String cods = "||1.1|0AF1BC34-C867-4CE1-B780-E0A73DAE9697|2024-04-04T10:20:41|SFE0807172W8|Wf41WXX7MHw10ThrW9rsa3ow7KpVGWX9oVH9s/+FHoYFs4MwwZ\n"
                    + "YYhLfTNgEdk4POqvizcavKh9ohvmaOg8m8NCu4NH2NdN5+HnXget54ol2imO2bWHF8w+U0+SDKwqk8fZimxb1HsLcnqfcL8AnX+Oy31UDfJgvRylTlzgIw5seH2vL\n"
                    + "hdAfv98uLpn7vVoWD8uY4htPqzof61Cq4fnGpkqJ3RU+433jylU4nJ/nkTLz05Ezy0eS7duQvbJKehHHoh8Sz7Ogd/0BgAh3jYLvPVVyur1rCGXekiukSKKs2X7sq8z5W\n"
                    + "zdAnDjumiUPOVS/ItO12Ia7pmp2ogWw4P0U+aQ==|00001000000505619865||";

            // Textos para cada celda en la fila adicional
            String[] textcods = {cods};

            // Agregar una fila con los textos especificados
            for (String text : textcods) {
                PdfPCell cell = new PdfPCell(new Phrase(text, fontTablecfdis));
                tablecods.addCell(cell);
            }

            // Agregar la tabla al documento en la coordenada Y 700
            tablecods.writeSelectedRows(0, -1, 160, 130, writer.getDirectContent());

            cb.setRGBColorFillF(0, 0, 1); // Azul
            writeText(cb, baseFont, "No de Serie del Certificado del SAT: ", 160, 80, font);
            cb.resetRGBColorFill(); // Restablecer el color a negro
            writeText(cb, baseFont, "00001000000505619865", 320, 80, font);

            cb.setRGBColorFillF(0, 0, 1); // Azul
            writeText(cb, baseFont, "Fecha y Hora de Certificación: ", 160, 70, font);
            cb.resetRGBColorFill(); // Restablecer el color a negro
            writeText(cb, baseFont, "2024-04-04T10:20:41", 320, 70, font);

            cb.setRGBColorFillF(0, 0, 1); // Azul
            writeText(cb, baseFont, "RFC del Proveedor de Certificación: ", 160, 60, font);
            cb.resetRGBColorFill(); // Restablecer el color a negro
            writeText(cb, baseFont, "SFE0807172W8", 320, 60, font);

            cfdi_qr_pdf.generate_qr();
            Image qr = Image.getInstance("C:/cfdi_uuid/2024/qrs/codigo_qr.png");
            qr.setAbsolutePosition(35, 30);
            document.add(qr);

            document.close();

            System.out.println("Plantilla PDF generada exitosamente en: " + rutaGuardado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para escribir texto directamente en el contenido del PDF
    private void writeText(PdfContentByte cb, BaseFont baseFont, String text, float x, float y, Font font) {
        cb.beginText();
        cb.setFontAndSize(baseFont, font.getSize());
        cb.setTextMatrix(x, y);
        cb.showText(text);
        cb.endText();
    }
}
