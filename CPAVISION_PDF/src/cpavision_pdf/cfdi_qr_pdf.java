package cpavision_pdf;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter; // Importa la clase MatrixToImageWriter
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.util.HashMap;
import java.util.Map;
//https://intranetcorporativo.avantetextil.com/

public class cfdi_qr_pdf {

    public static void generate_qr() {
        String url = "https://intranetcorporativo.avantetextil.com"; // Aquí colocas tu URL

        int width = 120;
        int height = 120;
        String format = "png";
        String folderPath = "C:\\cfdi_uuid\\2024\\qrs"; // Ruta de la carpeta

        get_code(url, width, height, format, folderPath);
    }

    private static void get_code(String text, int width, int height, String format, String folderPath) {
        try {
            // Crear objeto QRCodeWriter
            QRCodeWriter writer = new QRCodeWriter();

            // Configurar hints para el formato del código QR
            Map<EncodeHintType, Object> hints = new HashMap<>();
            hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");

            // Generar el código QR
            BitMatrix matrix = writer.encode(text, BarcodeFormat.QR_CODE, width, height, hints);

            // Crear la carpeta si no existe
            Path folder = FileSystems.getDefault().getPath(folderPath);
            java.nio.file.Files.createDirectories(folder);

            // Construir la ruta del archivo
            Path filePath = folder.resolve("codigo_qr.png");

            // Guardar el código QR en un archivo
            MatrixToImageWriter.writeToPath(matrix, format, filePath);

            System.out.println("Se generó exitosamente el código QR en el archivo: " + filePath);
        } catch (WriterException | java.io.IOException e) {
            System.out.println("Error al generar el código QR: " + e.getMessage());
        }
    }
}
