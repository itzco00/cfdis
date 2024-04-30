package cpavision_pdf;

public class cfdi_xml_data_receptor {

    private String rfcReceptor;
    private String nombreReceptor;
    private String domfisReceptor;
    private String regFiscalReceptor;
    private String usocfdiReceptor;

    public cfdi_xml_data_receptor(
            String rfcReceptor,
            String nombreReceptor,
            String domfisReceptor,
            String regFiscalReceptor,
            String usocfdiReceptor
    ) {
        this.rfcReceptor = rfcReceptor;
        this.nombreReceptor = nombreReceptor;
        this.domfisReceptor = domfisReceptor;
        this.regFiscalReceptor = regFiscalReceptor;
        this.usocfdiReceptor = usocfdiReceptor;
    }
    
    public String getrfcReceptor() { return rfcReceptor; }
    public void setrfcReceptor(String rfcReceptor) { this.rfcReceptor = rfcReceptor; }
    public String getnombreReceptor() { return nombreReceptor; }
    public void setnombreReceptor(String nombreReceptor) { this.nombreReceptor = nombreReceptor; }
    public String getdomfisReceptor() { return domfisReceptor; }
    public void setdomfisReceptor(String domfisReceptor) { this.domfisReceptor = domfisReceptor; }
    public String getregFiscalReceptor() { return regFiscalReceptor; }
    public void setregFiscalReceptor(String regFiscalReceptor) { this.regFiscalReceptor = regFiscalReceptor; }
    public String getusocfdiReceptor() { return usocfdiReceptor; }
    public void setusocfdiReceptor(String usocfdiReceptor) { this.usocfdiReceptor = usocfdiReceptor; }
}
