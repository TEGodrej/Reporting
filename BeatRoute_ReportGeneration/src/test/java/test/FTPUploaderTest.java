package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.testng.annotations.Test;

/**
 *@author DivyaPrakashAmar
 */
public class FTPUploaderTest {
	
    @Test
    public void upload(){
        // Local folder where reports are stored

    	String localFolder = "C:\\Users\\testing.engineer\\git\\Reporting\\BeatRoute_ReportGeneration\\Reports" ;
    	
        // Get all files starting with "Liquidation_Log" and ending with ".xlsx"
        File folder = new File(localFolder);
        File[] files = folder.listFiles((dir, name) -> name.startsWith("Liquidation_Log") && name.endsWith(".xlsx"));

        if (files == null || files.length == 0) {
            System.out.println("No report file found in folder: " + localFolder);
            return;
        }

        // Sort by last modified to pick the latest file
        Arrays.sort(files, Comparator.comparingLong(File::lastModified).reversed());
        File reportFile = files[0];  // Latest file
        String localFilePath = reportFile.getAbsolutePath();
        String remoteFilePath = "/Powerbi_Analytics/MD_Dashboards/CPB/" + reportFile.getName();
        String userId ="powerbi.admin";
        String password ="Pbianalyts@456#";

        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect("10.9.111.212");
            boolean login = ftpClient.login(userId, password);

            if (login) {
                System.out.println("Connected to FTP server");

                ftpClient.enterLocalPassiveMode(); // Passive mode
                ftpClient.setFileType(FTP.BINARY_FILE_TYPE); // For Excel file

                try (FileInputStream inputStream = new FileInputStream(localFilePath)) {
                    boolean done = ftpClient.storeFile(remoteFilePath, inputStream);
                    if (done) {
                        System.out.println("File uploaded successfully to " + remoteFilePath);
                    } else {
                        System.out.println("Failed to upload file.");
                    }
                }

                ftpClient.logout();
            } else {
                System.out.println("Failed to login to FTP server.");
            }

            ftpClient.disconnect();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
