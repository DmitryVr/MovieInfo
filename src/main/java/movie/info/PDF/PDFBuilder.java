package movie.info.PDF;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import movie.info.model.impl.Movie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class PDFBuilder extends AbstractPdfView{
    @Override
    protected void buildPdfDocument(Map<String, Object> var1, Document var2, PdfWriter var3, HttpServletRequest var4, HttpServletResponse var5) throws Exception {
        Movie movie = (Movie) var1.get("movie");

        var2.add(new Paragraph(movie.getNameOriginal()));
        var2.add(new Phrase());

        PdfPTable table = new PdfPTable(2);
//        PdfPCell header1 = new PdfPCell(new Phrase("Name"));
//        PdfPCell header2 = new PdfPCell(new Phrase("Weight"));
//        PdfPCell header3 = new PdfPCell(new Phrase("Color"));
//        header1.setHorizontalAlignment(Element.ALIGN_LEFT);
//        header2.setHorizontalAlignment(Element.ALIGN_LEFT);
//        header3.setHorizontalAlignment(Element.ALIGN_LEFT);
//        table.addCell(header1);
//        table.addCell(header2);
//        table.addCell(header3);

        table.addCell("Year");
        table.addCell(movie.getYear());

        var2.add(table);
        var2.add(new Phrase());

        Image image = Image.getInstance(movie.getImage());
        image.scalePercent(40f);
        var2.add(image);
    }
}
