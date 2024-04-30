package cpavision_pdf;

public class cfdi_xml_data {

    private String rfcEmisor;
    private String nombreEmisor;
    private String regFiscalEmisor;

    // Constructor
    public cfdi_xml_data(
            String rfcEmisor,
            String nombreEmisor,
            String regFiscalEmisor
    ) {
        this.rfcEmisor = rfcEmisor;
        this.nombreEmisor = nombreEmisor;
        this.regFiscalEmisor = regFiscalEmisor;
    }

    // Getters y Setters
    public String getrfcEmisor() { return rfcEmisor; }
    public void setrfcEmisor(String rfcEmisor) { this.rfcEmisor = rfcEmisor; }
    public String getnombreEmisor() { return nombreEmisor; }
    public void setnombreEmisor(String nombreEmisor) { this.nombreEmisor = nombreEmisor; }
    public String getregFiscalEmisor() { return regFiscalEmisor; }
    public void setregFiscalEmisor(String regFiscalEmisor) { this.regFiscalEmisor = regFiscalEmisor; }
}
