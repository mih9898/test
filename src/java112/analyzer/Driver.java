package java112.analyzer;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Driver {
    public static void main(String[] args) throws IOException {
        new FileAnalysis().analyze(args);

    }
}
