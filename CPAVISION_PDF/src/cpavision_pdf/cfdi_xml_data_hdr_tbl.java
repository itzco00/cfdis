package cpavision_pdf;

public class cfdi_xml_data_hdr_tbl {
    
    private String certificado;
    private String fecha;
    private String lugarexp;
    private String moneda;
    private String tipocomprobante;
    private String serie;
    private String folio;
    private String formapago;
    private String metodopago;
    private String tipocambio;
    private String total;
    private String subtotal;

    // Constructor
    public cfdi_xml_data_hdr_tbl(
            String certificado,
            String fecha,
            String lugarexp,
            String moneda,
            String tipocomprobante,
            String serie,
            String folio,
            String formapago,
            String metodopago,
            String tipocambio,
            String total,
            String subtotal
    ) {
        this.certificado = certificado;
        this.fecha = fecha;
        this.lugarexp = lugarexp;
        this.moneda = moneda;
        this.tipocomprobante = tipocomprobante;
        this.serie = serie;
        this.folio = folio;
        this.formapago = formapago;
        this.metodopago = metodopago;
        this.tipocambio = tipocambio;
        this.total = total;
        this.subtotal = subtotal;
    }

    // Getters y Setters
    public String getcertificado() { return certificado; }
    public void setcertificado(String certificado) { this.certificado = certificado; }
    
    public String getfecha() { return fecha; }
    public void setfecha(String fecha) { this.fecha = fecha; }
    
    public String getlugarexp() { return lugarexp; }
    public void setlugarexp(String lugarexp) { this.lugarexp = lugarexp; }
    
    public String getmoneda() { return moneda; }
    public void setmoneda(String moneda) { this.moneda = moneda; }
    
    public String gettipocomprobante() { return tipocomprobante; }
    public void settipocomprobante(String tipocomprobante) { this.tipocomprobante = tipocomprobante; }
    
    public String getserie() { return serie; }
    public void setserie(String serie) { this.serie = serie; }
    
    public String getfolio() { return folio; }
    public void setfolio(String folio) { this.folio = folio; }
    
    public String getformapago() { return formapago; }
    public void setformapago(String formapago) { this.formapago = formapago; }
    
    public String getmetodopago() { return metodopago; }
    public void setmetodopago(String metodopago) { this.metodopago = metodopago; }
    
    public String gettipocambio() { return tipocambio; }
    public void settipocambio(String tipocambio) { this.tipocambio = tipocambio; }
    
    public String gettotal() { return total; }
    public void settotal(String total) { this.total = total; }
    
    public String getsubtotal() { return subtotal; }
    public void setsubtotal(String subtotal) { this.subtotal = subtotal; }
}
