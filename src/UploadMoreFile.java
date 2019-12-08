import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.time.Instant;

@MultipartConfig(location = "/home/xzwb/")
@WebServlet(
        name = "UploadMoreFile",
        urlPatterns = {"/UploadMoreFile"}
)

public class UploadMoreFile extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.getParts()
                .stream()
                .filter(part -> part.getName().startsWith("file"))
                .forEach(this::write);
    }

    private void write(Part part) {
        String submittedFileName = part.getSubmittedFileName();
        String ext = submittedFileName.substring(submittedFileName.lastIndexOf('.'));
        try {
            part.write(String.format("%s%s", Instant.now().toEpochMilli(), ext));
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
