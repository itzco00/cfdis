package cpavision_pdf;

public class cfdi_xml_data_conceptos {
    private String claveProdServ;
    private String noIdentificacion;
    private String cantidad;
    private String claveUnidad;
    private String unidad;
    private String descripcion;
    private String valorUnitario;
    private String importe;
    private String cadenarow;
    
    public cfdi_xml_data_conceptos(String claveProdServ, String noIdentificacion, String cantidad, String claveUnidad, String unidad, String descripcion, String valorUnitario, String importe, String cadenarow) {
        this.claveProdServ = claveProdServ;
        this.noIdentificacion = noIdentificacion;
        this.cantidad = cantidad;
        this.claveUnidad = claveUnidad;
        this.unidad = unidad;
        this.descripcion = descripcion;
        this.valorUnitario = valorUnitario;
        this.importe = importe;
        this.cadenarow = cadenarow;
    }

    public String getClaveProdServ() {
        return claveProdServ;
    }

    public void setClaveProdServ(String claveProdServ) {
        this.claveProdServ = claveProdServ;
    }

    public String getNoIdentificacion() {
        return noIdentificacion;
    }

    public void setNoIdentificacion(String noIdentificacion) {
        this.noIdentificacion = noIdentificacion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getClaveUnidad() {
        return claveUnidad;
    }

    public void setClaveUnidad(String claveUnidad) {
        this.claveUnidad = claveUnidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(String valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }
    
    public String getCadenarow() {
        return cadenarow;
    }

    public void setCadenarow(String cadenarow) {
        this.cadenarow = cadenarow;
    }
}
