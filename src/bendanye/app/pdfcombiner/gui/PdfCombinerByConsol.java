package bendanye.app.pdfcombiner.gui;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import bendanye.app.pdfcombiner.PdfCombinerByDirectory;

public class PdfCombinerByConsol {
	
	public static void main(String[] args) throws IOException, ParseException {
		
		Options options = new Options();

        Option directoryOpt = new Option("d", "directory", true, "directory of the pdf files");
        directoryOpt.setRequired(false);
        options.addOption(directoryOpt);

        Option outputOpt = new Option("o", "output file", true, "output combine pdf name");
        outputOpt.setRequired(false);
        options.addOption(outputOpt);

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse(options, args);
        
        try (Scanner reader = new Scanner(System.in)) {
        	String directory = cmd.getOptionValue("directory");
            
            if (directory == null) {
            	System.out.println("Enter directory where pdf files are located: ");
            	directory = reader.nextLine();
            }
    		
    		String outputFileName = cmd.getOptionValue("output file");
    		if (outputFileName == null) {
            	System.out.println("Enter output file name: ");
            	outputFileName = reader.next();
    		}
    		
    		PdfCombinerByDirectory pdfCombinerByDirectory = new PdfCombinerByDirectory(directory);
    		
    		List<String> pdfFiles = pdfCombinerByDirectory.retrievePdfFiles();
    		
    		pdfCombinerByDirectory.combine(outputFileName, pdfFiles);
        }
		
	}
}
