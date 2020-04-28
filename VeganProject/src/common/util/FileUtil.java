package common.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletConfig;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.vo.UploadFile;

public class FileUtil {

   public UploadFile fileUpload(String uploadFolder, HttpServletRequest request) {
      UploadFile uploadFile = new UploadFile();
      int maxSize = 1024 * 1024 * 10;
      String originFileName = "";
      String renameFileName = "";

      String root = request.getServletContext().getRealPath("/");
      String savePath = root + uploadFolder;
      MultipartRequest mRequest = null;
      try {
         mRequest = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
         originFileName = mRequest.getFilesystemName("noticeFile");
         if (originFileName != null) {
            String fileName = String.valueOf(new Date().getTime());
            renameFileName = fileName + originFileName.substring(originFileName.lastIndexOf("."));
            
            File originFile = new File(savePath + "\\" + originFileName);
            File renameFile = new File(savePath + "\\" + renameFileName);
            
            originFile.renameTo(renameFile);
         }
         
         uploadFile.setSuccess(true);
         uploadFile.setOrginalFileName(originFileName);
         uploadFile.setRenameFileName(renameFileName);
         uploadFile.setSavePath(savePath);
         uploadFile.setmRequest(mRequest);
      } catch (IOException e) {
         e.printStackTrace();
         uploadFile.setSuccess(false);
         uploadFile.setOrginalFileName(originFileName);
      }

      return uploadFile;
   }
   
   public boolean fileDownload(ModelAndView mav, HttpServletResponse response) {
	
	   boolean res = false;
	   File downFile = new File((String) mav.getData().get("path"));
	   String ofname = (String) mav.getData().get("ofname");
	   
	   try {
		response.setHeader("Content-Disposition", "attachment; filename="+URLEncoder.encode(ofname,"UTF-8"));
	} catch (UnsupportedEncodingException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   ServletOutputStream downOutput;
	   try {
		downOutput = response.getOutputStream();
		BufferedInputStream bin = new BufferedInputStream(
				new FileInputStream(downFile));
		int read=0;
		while((read = bin.read())!=-1) {
			downOutput.write(read);
			downOutput.flush();
		}
		downOutput.close();
		bin.close();
		res = true;
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	   
	   return false;
	   
   }
   
   
}