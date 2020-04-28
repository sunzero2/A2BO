package common.vo;

import com.oreilly.servlet.MultipartRequest;

public class UploadFile {
   private boolean isSuccess = false;
   private String orginalFileName;
   private String renameFileName;
   private String savePath;
   private MultipartRequest mRequest;

   public UploadFile() {
      super();
   }

   public UploadFile(boolean isSuccess, String orginalFileName, String renameFileName, String savePath,
         MultipartRequest mRequest) {
      super();
      this.isSuccess = isSuccess;
      this.orginalFileName = orginalFileName;
      this.renameFileName = renameFileName;
      this.savePath = savePath;
      this.mRequest = mRequest;
   }

   public boolean isSuccess() {
      return isSuccess;
   }

   public void setSuccess(boolean isSuccess) {
      this.isSuccess = isSuccess;
   }

   public String getOrginalFileName() {
      return orginalFileName;
   }

   public void setOrginalFileName(String orginalFileName) {
      this.orginalFileName = orginalFileName;
   }

   public String getRenameFileName() {
      return renameFileName;
   }

   public void setRenameFileName(String renameFileName) {
      this.renameFileName = renameFileName;
   }

   public String getSavePath() {
      return savePath;
   }

   public void setSavePath(String savePath) {
      this.savePath = savePath;
   }

   public MultipartRequest getmRequest() {
      return mRequest;
   }

   public void setmRequest(MultipartRequest mRequest) {
      this.mRequest = mRequest;
   }

   @Override
   public String toString() {
      return "UploadFile [isSuccess=" + isSuccess + ", orginalFileName=" + orginalFileName + ", renameFileName="
            + renameFileName + ", savePath=" + savePath + ", mRequest=" + mRequest + "]";
   }
}