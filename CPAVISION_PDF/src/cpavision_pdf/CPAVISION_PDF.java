package cpavision_pdf;

import java.util.List;

public class CPAVISION_PDF {

    public static void main(String[] args) {
        
        // Llama al método readxml() para obtener el contenedor con todas las listas
        cfdi_xml_lists_datas container = cfdi_xml_read.readxml();
        List<cfdi_xml_data> xml_data = container.getXmlData();
        List<cfdi_xml_data_receptor> xml_data_receptor = container.getXmlDataReceptor();
        List<cfdi_xml_data_uuid> xml_data_uuid = container.getXmlDataUuid();
        List<cfdi_xml_data_hdr_tbl> xml_data_hdr_tbl = container.getXmlDataHdrTbl();
        List<cfdi_xml_data_conceptos> xml_data_conceptos = container.getXmlDataConceptos();
        List<cfdi_xml_data_pedimentos> xml_data_pedimentos = container.getXmlDataPedimentos();
        
        
        // Instancia un objeto de la clase cfdi_to_pdf, pasando xml_data como argumento al constructor
        cfdi_to_pdf convert = new cfdi_to_pdf(xml_data,xml_data_receptor, xml_data_uuid, xml_data_hdr_tbl, xml_data_conceptos, xml_data_pedimentos);
        
        // Llama al método plantilla() en el objeto convert
        convert.plantilla();
    }
}
