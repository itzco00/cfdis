package cpavision_pdf;

import java.util.List;

public class cfdi_xml_lists_datas {
    
    private List<cfdi_xml_data> xmlData;
    private List<cfdi_xml_data_receptor> xmlDataReceptor;
    private List<cfdi_xml_data_uuid> XmlDataUuid;
    private List<cfdi_xml_data_hdr_tbl> XmlDataHdrTbl;
    private List<cfdi_xml_data_conceptos> XmlDataConceptos;
    private List<cfdi_xml_data_pedimentos> XmlDataPedimentos;
    
    public cfdi_xml_lists_datas(
            List<cfdi_xml_data> xmlData,
            List<cfdi_xml_data_receptor> xmlDataReceptor,
            List<cfdi_xml_data_uuid> XmlDataUuid,
            List<cfdi_xml_data_hdr_tbl> XmlDataHdrTbl,
            List<cfdi_xml_data_conceptos> XmlDataConceptos,
            List<cfdi_xml_data_pedimentos> XmlDataPedimentos
    ) {
        this.xmlData = xmlData;
        this.xmlDataReceptor = xmlDataReceptor;
        this.XmlDataUuid = XmlDataUuid;
        this.XmlDataHdrTbl = XmlDataHdrTbl;
        this.XmlDataConceptos = XmlDataConceptos;
        this.XmlDataPedimentos = XmlDataPedimentos;
    }
    public List<cfdi_xml_data> getXmlData() {
        return xmlData;
    }

    public List<cfdi_xml_data_receptor> getXmlDataReceptor() {
        return xmlDataReceptor;
    }
    
    public List<cfdi_xml_data_uuid> getXmlDataUuid() {
        return XmlDataUuid;
    }
    
    public List<cfdi_xml_data_hdr_tbl> getXmlDataHdrTbl() {
        return XmlDataHdrTbl;
    }
    
    public List<cfdi_xml_data_conceptos> getXmlDataConceptos() {
        return XmlDataConceptos;
    }
    
    public List<cfdi_xml_data_pedimentos> getXmlDataPedimentos() {
        return XmlDataPedimentos;
    }
}
