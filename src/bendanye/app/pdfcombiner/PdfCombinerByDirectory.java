package bendanye.app.pdfcombiner;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class PdfCombinerByDirectory {
	
	private final String directory;
	
	public PdfCombinerByDirectory(String directory) {
		Objects.requireNonNull(directory);
		
		this.directory = directory;
	}
	
	public List<String> retrievePdfFiles() throws IOException {

		List<String> fileNames = new ArrayList<>();
		
		try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directory), "*.pdf")) {
            for (Path path : directoryStream) {
                fileNames.add(path.toString());
                
            }
        }
		
		return fileNames;
	}

	public void combine(String outputFileName, List<String> fileNames) throws FileNotFoundException, IOException {
		
		Objects.requireNonNull(outputFileName);
		Objects.requireNonNull(fileNames);
		
		if (fileNames.size() > 0) {
			PDFMergerUtility ut = new PDFMergerUtility();
			
			for(String fileName : fileNames) {
				System.out.println("Adding: " + fileName.toString());
				ut.addSource(fileName);	
			}
			
			ut.setDestinationFileName(outputFileName);
			ut.mergeDocuments();
			
			System.out.println("Successfully combine into " + outputFileName);
		}
		
		else {
			System.out.println("No pdf files to combine");
		}
		
		
	}

}
