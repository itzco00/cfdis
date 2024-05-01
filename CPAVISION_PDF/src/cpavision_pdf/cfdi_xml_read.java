package cpavision_pdf;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class cfdi_xml_read {

    public static cfdi_xml_lists_datas readxml() {
        List<cfdi_xml_data> xml_data = new ArrayList<>();
        List<cfdi_xml_data_receptor> xml_data_receptor = new ArrayList<>();
        List<cfdi_xml_data_uuid> xml_data_uuid = new ArrayList<>();
        List<cfdi_xml_data_hdr_tbl> xml_data_hdr_tbl = new ArrayList<>();
        List<cfdi_xml_data_conceptos> xml_data_conceptos = new ArrayList<>();
        try {
            // Ruta del archivo XML
            String rutaArchivo = "C:\\cfdi_uuid\\2024\\tst\\48691869-1d6a-4c28-95aa-f7f03d8286bf.xml";

            // Crear un DocumentBuilderFactory
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

            // Crear un DocumentBuilder
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Parsear el archivo XML y obtener el documento
            Document document = builder.parse(new File(rutaArchivo));

            // Obtener las etiquetas
            NodeList emisorList = document.getElementsByTagName("cfdi:Emisor");
            NodeList receptorList = document.getElementsByTagName("cfdi:Receptor");
            NodeList timfiscalList = document.getElementsByTagName("tfd:TimbreFiscalDigital");
            NodeList comprobanteList = document.getElementsByTagName("cfdi:Comprobante");
            NodeList impuestosList = document.getElementsByTagName("cfdi:Impuestos");
            NodeList cfdiRelacionadoList = document.getElementsByTagName("cfdi:CfdiRelacionados");
            NodeList conceptosList = document.getElementsByTagName("cfdi:Conceptos");
            NodeList TimbreFiscalDigitalList = document.getElementsByTagName("tfd:TimbreFiscalDigital");

            // Buscar las etiquetas en el XML
            Node emisorNode = emisorList.item(0);
            Node receptorNode = receptorList.item(0);
            Node timfiscalNode = timfiscalList.item(0);
            Node comprobanteNode = comprobanteList.item(0);
            Node impuestosNode = impuestosList.item(1);
            Node TimbreFiscalDigitalNoed = TimbreFiscalDigitalList.item(0);

            Node cfdiRelacionadosNode = cfdiRelacionadoList.item(0);

            if (emisorNode != null && emisorNode.getNodeType() == Node.ELEMENT_NODE) {
                Element object = (Element) emisorNode;

                // Obtener atributos
                String rfcEmisor = object.getAttribute("Rfc");
                String nombreEmisor = object.getAttribute("Nombre");
                String regFiscalEmisor = object.getAttribute("RegimenFiscal");

                switch (regFiscalEmisor) {
                    case "601":
                        regFiscalEmisor = "601 General de Ley Personas Morales";
                        break;
                    case "603":
                        regFiscalEmisor = "603 Personas Morales con Fines no Lucrativos";
                        break;
                    case "605":
                        regFiscalEmisor = "605 Sueldos y Salarios e Ingresos Asimilados a Salarios";
                        break;
                    case "606":
                        regFiscalEmisor = "606 Arrendamiento";
                        break;
                    case "607":
                        regFiscalEmisor = "607 Régimen de Enajenación o Adquisición de Bienes";
                        break;
                    case "608":
                        regFiscalEmisor = "608 Demás ingresos";
                        break;
                    case "609":
                        regFiscalEmisor = "609 Consolidación";
                        break;
                    case "610":
                        regFiscalEmisor = "610 Residentes en el Extranjero sin Establecimiento Permanente en México";
                        break;
                    case "611":
                        regFiscalEmisor = "611 Ingresos por Dividendos (socios y accionistas)";
                        break;
                    case "612":
                        regFiscalEmisor = "612 Personas Físicas con Actividades Empresariales y Profesionales";
                        break;
                    case "614":
                        regFiscalEmisor = "614 Ingresos por intereses";
                        break;
                    case "615":
                        regFiscalEmisor = "615 Régimen de los ingresos por obtención de premios";
                        break;
                    case "616":
                        regFiscalEmisor = "616 Sin obligaciones fiscales";
                        break;
                    case "620":
                        regFiscalEmisor = "620 Sociedades Cooperativas de Producción que optan por diferir sus ingresos";
                        break;
                    case "621":
                        regFiscalEmisor = "621 Incorporación Fiscal";
                        break;
                    case "622":
                        regFiscalEmisor = "622 Actividades Agrícolas, Ganaderas, Silvícolas y Pesqueras";
                        break;
                    case "623":
                        regFiscalEmisor = "623 Opcional para Grupos de Sociedades";
                        break;
                    case "624":
                        regFiscalEmisor = "624 Coordinados";
                        break;
                    case "625":
                        regFiscalEmisor = "625 Régimen de las Actividades Empresariales con ingresos a través de Plataformas Tecnológicas";
                        break;
                    case "626":
                        regFiscalEmisor = "626 Régimen Simplificado de Confianza";
                        break;
                    case "628":
                        regFiscalEmisor = "628 Hidrocarburos";
                        break;
                    case "629":
                        regFiscalEmisor = "629 De los Regímenes Fiscales Preferentes y de las Empresas Multinacionales";
                        break;
                    case "630":
                        regFiscalEmisor = "630 Enajenación de acciones en bolsa de valores";
                        break;
                    default:
                        regFiscalEmisor = "";
                        break;
                }

                System.out.println("RFC del emisor: " + rfcEmisor);
                System.out.println("Nombre del emisor: " + nombreEmisor);
                System.out.println("Regimen Fiscal del emisor: " + regFiscalEmisor);

                // Crear un nuevo objeto cfdi_xml_data con los datos obtenidos
                cfdi_xml_data emisorData = new cfdi_xml_data(rfcEmisor, nombreEmisor, regFiscalEmisor);

                // Agregar el objeto emisorData a la lista xml_data
                xml_data.add(emisorData);
            }

            if (receptorNode != null && receptorNode.getNodeType() == Node.ELEMENT_NODE) {
                Element object = (Element) receptorNode;

                // Obtener atributos
                String rfcReceptor = object.getAttribute("Rfc");
                String nombreReceptor = object.getAttribute("Nombre");
                String domFiscalReceptor = object.getAttribute("DomicilioFiscalReceptor");
                String regFiscalReceptor = object.getAttribute("RegimenFiscalReceptor");
                String usoCfdiReceptor = object.getAttribute("UsoCFDI");

                switch (regFiscalReceptor) {
                    case "601":
                        regFiscalReceptor = "601 General de Ley Personas Morales";
                        break;
                    case "603":
                        regFiscalReceptor = "603 Personas Morales con Fines no Lucrativos";
                        break;
                    case "605":
                        regFiscalReceptor = "605 Sueldos y Salarios e Ingresos Asimilados a Salarios";
                        break;
                    case "606":
                        regFiscalReceptor = "606 Arrendamiento";
                        break;
                    case "607":
                        regFiscalReceptor = "607 Régimen de Enajenación o Adquisición de Bienes";
                        break;
                    case "608":
                        regFiscalReceptor = "608 Demás ingresos";
                        break;
                    case "609":
                        regFiscalReceptor = "609 Consolidación";
                        break;
                    case "610":
                        regFiscalReceptor = "610 Residentes en el Extranjero sin Establecimiento Permanente en México";
                        break;
                    case "611":
                        regFiscalReceptor = "611 Ingresos por Dividendos (socios y accionistas)";
                        break;
                    case "612":
                        regFiscalReceptor = "612 Personas Físicas con Actividades Empresariales y Profesionales";
                        break;
                    case "614":
                        regFiscalReceptor = "614 Ingresos por intereses";
                        break;
                    case "615":
                        regFiscalReceptor = "615 Régimen de los ingresos por obtención de premios";
                        break;
                    case "616":
                        regFiscalReceptor = "616 Sin obligaciones fiscales";
                        break;
                    case "620":
                        regFiscalReceptor = "620 Sociedades Cooperativas de Producción que optan por diferir sus ingresos";
                        break;
                    case "621":
                        regFiscalReceptor = "621 Incorporación Fiscal";
                        break;
                    case "622":
                        regFiscalReceptor = "622 Actividades Agrícolas, Ganaderas, Silvícolas y Pesqueras";
                        break;
                    case "623":
                        regFiscalReceptor = "623 Opcional para Grupos de Sociedades";
                        break;
                    case "624":
                        regFiscalReceptor = "624 Coordinados";
                        break;
                    case "625":
                        regFiscalReceptor = "625 Régimen de las Actividades Empresariales con ingresos a través de Plataformas Tecnológicas";
                        break;
                    case "626":
                        regFiscalReceptor = "626 Régimen Simplificado de Confianza";
                        break;
                    case "628":
                        regFiscalReceptor = "628 Hidrocarburos";
                        break;
                    case "629":
                        regFiscalReceptor = "629 De los Regímenes Fiscales Preferentes y de las Empresas Multinacionales";
                        break;
                    case "630":
                        regFiscalReceptor = "630 Enajenación de acciones en bolsa de valores";
                        break;
                    default:
                        regFiscalReceptor = "";
                        break;
                }
                switch (usoCfdiReceptor) {
                    case "G01":
                        usoCfdiReceptor = "G01 Adquisición de mercancías.";
                        break;
                    case "G02":
                        usoCfdiReceptor = "G02 Devoluciones, descuentos o bonificaciones.";
                        break;
                    case "G03":
                        usoCfdiReceptor = "G03 Gastos en general.";
                        break;
                    case "I01":
                        usoCfdiReceptor = "I01 Construcciones.";
                        break;
                    case "I02":
                        usoCfdiReceptor = "I02 Mobiliario y equipo de oficina por inversiones.";
                        break;
                    case "I03":
                        usoCfdiReceptor = "I03 Equipo de transporte.";
                        break;
                    case "I04":
                        usoCfdiReceptor = "I04 Equipo de computo y accesorios.";
                        break;
                    case "I05":
                        usoCfdiReceptor = "I05 Equipo de computo y accesorios.";
                        break;
                    case "I06":
                        usoCfdiReceptor = "I06 Comunicaciones telefónicas.";
                        break;
                    case "I07":
                        usoCfdiReceptor = "I07 Comunicaciones satelitales.";
                        break;
                    case "I08":
                        usoCfdiReceptor = "I08 Otra maquinaria y equipo.";
                        break;
                    case "D01":
                        usoCfdiReceptor = "D01 Honorarios médicos, dentales y gastos hospitalarios.";
                        break;
                    case "D02":
                        usoCfdiReceptor = "D02 Gastos médicos por incapacidad o discapacidad.";
                        break;
                    case "D03":
                        usoCfdiReceptor = "D03 Gastos funerales.";
                        break;
                    case "D04":
                        usoCfdiReceptor = "D04 Donativos.";
                        break;
                    case "D05":
                        usoCfdiReceptor = "D05 Intereses reales efectivamente pagados por créditos hipotecarios (casa habitación).";
                        break;
                    case "D06":
                        usoCfdiReceptor = "D06 Aportaciones voluntarias al SAR.";
                        break;
                    case "D07":
                        usoCfdiReceptor = "D07 Primas por seguros de gastos médicos.";
                        break;
                    case "D08":
                        usoCfdiReceptor = "D08 Gastos de transportación escolar obligatoria.";
                        break;
                    case "D09":
                        usoCfdiReceptor = "D09 Depósitos en cuentas para el ahorro, primas que tengan como base planes de pensiones.";
                        break;
                    case "D10":
                        usoCfdiReceptor = "D10 Pagos por servicios educativos (colegiaturas).";
                        break;
                    case "S01":
                        usoCfdiReceptor = "S01 Sin efectos fiscales.";
                        break;
                    case "CP01":
                        usoCfdiReceptor = "CP01 Pagos";
                        break;
                    case "CN01":
                        usoCfdiReceptor = "CN01 Nómina";
                        break;
                    default:
                        regFiscalReceptor = "";
                        break;
                }

                System.out.println("RFC del receptor: " + rfcReceptor);
                System.out.println("Nombre del receptor: " + nombreReceptor);
                System.out.println("Domicilio Fiscal del receptor: " + domFiscalReceptor);
                System.out.println("Regimen Fiscal del receptor: " + regFiscalReceptor);
                System.out.println("Uso CDFI receptor: " + usoCfdiReceptor);

                // Crear un nuevo objeto con los datos obtenidos y pasarlos a la lista
                cfdi_xml_data_receptor emisorDatareceptor = new cfdi_xml_data_receptor(rfcReceptor, nombreReceptor, domFiscalReceptor, regFiscalReceptor, usoCfdiReceptor);

                // Agregar el objeto a la lista
                xml_data_receptor.add(emisorDatareceptor);
            }

            if (timfiscalNode != null && timfiscalNode.getNodeType() == Node.ELEMENT_NODE) {
                Element object = (Element) timfiscalNode;

                // Obtener atributos
                String uuid = object.getAttribute("UUID");

                System.out.println("UUID: " + uuid);

                // Crear un nuevo objeto con los datos obtenidos y pasarlos a la lista
                cfdi_xml_data_uuid Datauuid = new cfdi_xml_data_uuid(uuid);

                // Agregar el objeto a la lista
                xml_data_uuid.add(Datauuid);
            }
            if (comprobanteNode != null && comprobanteNode.getNodeType() == Node.ELEMENT_NODE) {
                Element object = (Element) comprobanteNode;

                // Obtener atributos
                String certificado = object.getAttribute("NoCertificado");
                String fecha = object.getAttribute("Fecha");
                String lugarexp = object.getAttribute("LugarExpedicion");
                String moneda = object.getAttribute("Moneda");
                String tipocomprobante = object.getAttribute("TipoDeComprobante");
                if (tipocomprobante.equals("E")) {
                    tipocomprobante = "E Egreso";
                } else if (tipocomprobante.equals("I")) {
                    tipocomprobante = "I Ingreso";
                } else {
                    tipocomprobante = "";
                }
                String serie = object.getAttribute("Serie");
                String folio = object.getAttribute("Folio");
                String formapago = object.getAttribute("FormaPago");
                switch (formapago) {
                    case "01":
                        formapago = "01 Efectivo";
                        break;
                    case "02":
                        formapago = "02 Cheque nominativo";
                        break;
                    case "03":
                        formapago = "03 Transferencia electrónica de fondos";
                        break;
                    case "04":
                        formapago = "04 Tarjeta de crédito";
                        break;
                    case "05":
                        formapago = "05 Monedero electrónico";
                        break;
                    case "06":
                        formapago = "06 Dinero electrónico";
                        break;
                    case "08":
                        formapago = "08 Vales de despensa";
                        break;
                    case "12":
                        formapago = "12 Dación de pago";
                        break;
                    case "13":
                        formapago = "13 Pago por subrogación";
                        break;
                    case "14":
                        formapago = "14 Pago por consignacion";
                        break;
                    case "15":
                        formapago = "15 Condonación";
                        break;
                    case "17":
                        formapago = "17 Compensación";
                        break;
                    case "23":
                        formapago = "23 Novación";
                        break;
                    case "24":
                        formapago = "24 Confusión";
                        break;
                    case "25":
                        formapago = "25 Remisión de deuda";
                        break;
                    case "26":
                        formapago = "26 Prescripcion o caducidad";
                        break;
                    case "27":
                        formapago = "27 A satisfacción del acreedor";
                        break;
                    case "28":
                        formapago = "28 Tarjeta de débito";
                        break;
                    case "29":
                        formapago = "29 Tarjeta de servicios";
                        break;
                    case "30":
                        formapago = "30 Aplicacion de anticipos";
                        break;
                    case "99":
                        formapago = "99 Por definir";
                        break;
                    default:
                        formapago = "";
                        break;
                }
                String metodopago = object.getAttribute("MetodoPago");
                switch (metodopago) {
                    case "PUE":
                        metodopago = "PUE Pago en una sola Exhibición";
                        break;
                    case "PPD":
                        metodopago = "PPD Pago en parcialidades o diferido";
                        break;
                    default:
                        metodopago = "";
                        break;
                }
                String tipocambio = object.getAttribute("TipoCambio");
                String total = object.getAttribute("Total");
                String subtotal = object.getAttribute("SubTotal");

                System.out.println("Numero certificado: " + certificado);
                System.out.println("Fecha: " + fecha);
                System.out.println("Lugar de emision: " + lugarexp);
                System.out.println("Moneda: " + moneda);
                System.out.println("Tipo De Comprobante: " + tipocomprobante);
                System.out.println("Serie y Folio: " + serie + " " + folio);
                System.out.println("Forma De pago: " + formapago);
                System.out.println("Metodo De pago: " + metodopago);
                System.out.println("Tipo De cambio: " + tipocambio);
                System.out.println("Total: " + total);
                System.out.println("Subtotal: " + subtotal);

                // Crear un nuevo objeto con los datos obtenidos y pasarlos a la lista
                cfdi_xml_data_hdr_tbl hdr_tbl = new cfdi_xml_data_hdr_tbl(certificado, fecha, lugarexp, moneda, tipocomprobante, serie, folio, formapago, metodopago, tipocambio, total, subtotal);

                // Agregar el objeto a la lista
                xml_data_hdr_tbl.add(hdr_tbl);

            }
            if (impuestosNode != null && impuestosNode.getNodeType() == Node.ELEMENT_NODE) {
                Element object = (Element) impuestosNode;

                // Obtener atributos
                String iva = object.getAttribute("TotalImpuestosTrasladados");

                System.out.println("IVA Tra 16.00%: " + iva);
            }

            if (cfdiRelacionadoList.getLength() > 0) {
                Node relacionadosNode = cfdiRelacionadoList.item(0);
                NodeList cfdiRelacionadoListArray = ((Element) relacionadosNode).getElementsByTagName("cfdi:CfdiRelacionado");

                // Construir la cadena de salida
                StringBuilder uuids = new StringBuilder();

                // Iterar sobre cada nodo <cfdi:CfdiRelacionado>
                for (int i = 0; i < cfdiRelacionadoListArray.getLength(); i++) {
                    Node cfdiRelacionadoNode = cfdiRelacionadoListArray.item(i);

                    if (cfdiRelacionadoNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element cfdiRelacionadoElement = (Element) cfdiRelacionadoNode;

                        // Obtener el atributo UUID del nodo <cfdi:CfdiRelacionado>
                        String uuid = cfdiRelacionadoElement.getAttribute("UUID");

                        // Añadir al StringBuilder en el formato deseado
                        uuids.append("(").append(uuid).append(") ");
                    }
                }
                String uuidsarray = uuids.toString().trim();

                // Imprimir todos los UUIDs en el formato especificado
                System.out.println("CFDI Relacionados UUIDs: " + uuidsarray);
            }
            if (cfdiRelacionadosNode != null && cfdiRelacionadosNode.getNodeType() == Node.ELEMENT_NODE) {
                Element object = (Element) cfdiRelacionadosNode;

                // Obtener atributos
                String tiporelacion = object.getAttribute("TipoRelacion");

                switch (tiporelacion) {
                    case "01":
                        tiporelacion = "01 Nota de crédito de los documentos relacionados";
                        break;
                    case "02":
                        tiporelacion = "02 Nota de débito de los documentos relacionados";
                        break;
                    case "03":
                        tiporelacion = "03 Devolución de mercancía sobre facturas o traslados previos";
                        break;
                    case "04":
                        tiporelacion = "04 Sustitución de CFDI previos";
                        break;
                    case "05":
                        tiporelacion = "05 Traslados de mercancías facturadas previamente";
                        break;
                    case "06":
                        tiporelacion = "06 Factura generada por los traslados previos";
                        break;
                    case "07":
                        tiporelacion = "07 CFDI por aplicación de anticipo";
                        break;
                    default:
                        tiporelacion = "";
                        break;
                }

                System.out.println("Tipo Relacion: " + tiporelacion);
            }
            if (TimbreFiscalDigitalNoed != null && TimbreFiscalDigitalNoed.getNodeType() == Node.ELEMENT_NODE) {
                Element object = (Element) TimbreFiscalDigitalNoed;

                // Obtener atributos
                String sellocfd = object.getAttribute("SelloCFD");
                String sellosat = object.getAttribute("SelloSAT");
                String version = object.getAttribute("Version");
                String uuid = object.getAttribute("UUID");
                String fechatimbrado = object.getAttribute("FechaTimbrado");
                String rfcprovcertif = object.getAttribute("RfcProvCertif");
                String nocertificadosat = object.getAttribute("NoCertificadoSAT");

                String cadenaorigial = "||" + version + "|" + uuid + "|" + fechatimbrado + "|" + rfcprovcertif + "|" + sellocfd + "|" + nocertificadosat + "||";

                System.out.println("Sello Digital del CFDI: " + sellocfd);
                System.out.println("Sello del SAT: " + sellosat);
                System.out.println("Cadena Original del Complemento de Certificación Digital del SAT: " + cadenaorigial);
                System.out.println("Numero de serie del certificado del SAT: " + nocertificadosat);
                System.out.println("Fecha y Hora de Certificacion: " + fechatimbrado);
                System.out.println("RFC del proveedor de certificacion: " + rfcprovcertif);
            }

            cfdi_xml_data_conceptos concepto = null;
            // Iterar sobre cada elemento <cfdi:Concepto>
            for (int i = 0; i < conceptosList.getLength(); i++) {
                Node conceptosNode = conceptosList.item(i);

                if (conceptosNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element conceptosElement = (Element) conceptosNode;

                    // Obtener todos los elementos <cfdi:Concepto> dentro de <cfdi:Conceptos>
                    NodeList conceptoList = conceptosElement.getElementsByTagName("cfdi:Concepto");

                    // Iterar sobre cada elemento <cfdi:Concepto>
                    for (int j = 0; j < conceptoList.getLength(); j++) {
                        Node conceptoNode = conceptoList.item(j);

                        if (conceptoNode.getNodeType() == Node.ELEMENT_NODE) {
                            Element conceptoElement = (Element) conceptoNode;

                            // Obtener los atributos del elemento <cfdi:Concepto>
                            String claveprodserv = conceptoElement.getAttribute("ClaveProdServ");
                            String noidentificacion = conceptoElement.getAttribute("NoIdentificacion");
                            String cantidad = conceptoElement.getAttribute("Cantidad");
                            String claveunidad = conceptoElement.getAttribute("ClaveUnidad");
                            String unidad = conceptoElement.getAttribute("Unidad");
                            String descripcion = conceptoElement.getAttribute("Descripcion");
                            String valorunitario = conceptoElement.getAttribute("ValorUnitario");
                            String importe = conceptoElement.getAttribute("Importe");

                            // Imprimir los atributos del elemento <cfdi:Concepto>
                            System.out.println("Concepto " + (j + 1));
                            System.out.println("ClaveProdServ: " + claveprodserv);
                            System.out.println("Numero de Identificacion: " + noidentificacion);
                            System.out.println("Cantidad: " + cantidad);
                            System.out.println("Clave Unidad: " + claveunidad);
                            System.out.println("Unidad: " + unidad);
                            System.out.println("Descripcion: " + descripcion);
                            System.out.println("Valor Unitario: " + valorunitario);
                            System.out.println("Importe: " + importe);

                            // Obtener el elemento <cfdi:Traslado> dentro de <cfdi:Impuestos>
                            NodeList trasladosinfoList = conceptoElement.getElementsByTagName("cfdi:Traslado");
                            for (int l = 0; l < trasladosinfoList.getLength(); l++) {
                                Node trasladoNode = trasladosinfoList.item(l);
                                if (trasladoNode.getNodeType() == Node.ELEMENT_NODE) {
                                    Element trasladoElement = (Element) trasladoNode;
                                    String base = trasladoElement.getAttribute("Base");
                                    String importeTraslado = trasladoElement.getAttribute("Importe");
                                    String impuesto = trasladoElement.getAttribute("Impuesto");
                                    String objetoimpuesto = "";
                                    String tasaocuotatraslado = trasladoElement.getAttribute("TasaOCuota");
                                    String tipofactortraslado = trasladoElement.getAttribute("TipoFactor");
                                    switch (impuesto) {
                                        case "NA":
                                            impuesto = "Ninguno";
                                            objetoimpuesto = "";
                                            break;
                                        case "001":
                                            impuesto = "Retencion ISR";
                                            objetoimpuesto = "No objeto de impuesto";
                                            break;
                                        case "002":
                                            impuesto = "IVA";
                                            objetoimpuesto = "Si objeto de impuesto";
                                            break;
                                        case "003":
                                            impuesto = "IEPS";
                                            objetoimpuesto = "Si objeto de impuesto no obligado a desglose";
                                            break;
                                        default:
                                            impuesto = "Impuesto Local";
                                            break;
                                    }

                                    String cadenarow = objetoimpuesto + "   Impuesto Trasladado.    Base: " + base + "  Impuesto: " + impuesto + "   Tipo factor: " + tipofactortraslado + "     Tasa o Cuota: " + tasaocuotatraslado + "    Importe: " + importeTraslado;
                                    System.out.println(cadenarow);

                                    concepto = new cfdi_xml_data_conceptos(claveprodserv, noidentificacion, cantidad, claveunidad, unidad, descripcion, valorunitario, importe, cadenarow);
                                    xml_data_conceptos.add(concepto);
                                }
                            }

                            // Obtener todos los elementos <cfdi:InformacionAduanera> dentro de <cfdi:Concepto>
                            NodeList informacionAduaneraList = conceptoElement.getElementsByTagName("cfdi:InformacionAduanera");

                            // Iterar sobre cada elemento <cfdi:InformacionAduanera>
                            for (int k = 0; k < informacionAduaneraList.getLength(); k++) {
                                Node informacionAduaneraNode = informacionAduaneraList.item(k);
                                if (informacionAduaneraNode.getNodeType() == Node.ELEMENT_NODE) {
                                    Element informacionAduaneraElement = (Element) informacionAduaneraNode;
                                    String numeroPedimento = informacionAduaneraElement.getAttribute("NumeroPedimento");
                                    System.out.println("Informacion Aduanera.  Numero de Pedimento: " + numeroPedimento);
                                    
                                    concepto.agregarPedimento(numeroPedimento);
                                }
                            }
                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new cfdi_xml_lists_datas(xml_data, xml_data_receptor, xml_data_uuid, xml_data_hdr_tbl, xml_data_conceptos);
    }
}
