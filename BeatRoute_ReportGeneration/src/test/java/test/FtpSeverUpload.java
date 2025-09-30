package test;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;
import org.testng.annotations.Test;

public class FtpSeverUpload {

	@Test
	public void ftp() {
		FTPClient ftp = new FTPClient();
		try {
            ftp.connect("10.9.111.212");
            ftp.login("powerbi.admin", "Pbianalyts@456#");
            
            FileOutputStream fos = new FileOutputStream("C:\\Users\\testing.engineer\\git\\Reporting\\BeatRoute_ReportGeneration\\Reports\\Overall_Liquidation_30-09-2025@10_29_10.1010.xlsx");
            ftp.retrieveFile("/Powerbi_Analytics/MD_Dashboards/CPB", fos);
            fos.close();
            
            ftp.logout();
            ftp.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
	}
}
