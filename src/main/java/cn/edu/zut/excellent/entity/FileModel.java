package cn.edu.zut.excellent.entity;

import org.springframework.web.multipart.MultipartFile;


public class FileModel {
	private String id;
	private long createTime;
	private long updateTime;
	private String realName;// 初始名称
	private String saveName;// 保存名称
	private int maxSize;// 文件大小
	private String fileType;// 文件类型
	private String fileAddrss;// 文件物理地址
	private MultipartFile file;// 文件
	private int view;
	private int sta;
	
	  public int getSta() {
			return sta;
		}

		public void setSta(int sta) {
			this.sta = sta;
		}

		public int getView() {
			return view;
		}

		public void setView(int view) {
			this.view = view;
		}

		public FileModel() {
	    }

	    public FileModel(String realName, MultipartFile file) {
	        this.realName = realName;
	        this.file = file;
	    }

	    @Override
	    public String toString() {
	        return "FileModel{" +
	                "createTime=" + createTime +
	                ", id='" + id + '\'' +
	                ", updateTime=" + updateTime +
	                ", realName='" + realName + '\'' +
	                ", saveName='" + saveName + '\'' +
	                ", maxSize=" + maxSize +
	                ", fileType='" + fileType + '\'' +
	                ", fileAddrss='" + fileAddrss + '\'' +
	                '}';
	    }

	    public long getCreateTime() {
	        return createTime;
	    }

	    public void setCreateTime(long createTime) {
	        this.createTime = createTime;
	    }

	    public MultipartFile getFile() {
	        return file;
	    }

	    public void setFile(MultipartFile file) {
	        this.file = file;
	    }

	    public String getFileAddrss() {
	        return fileAddrss;
	    }

	    public void setFileAddrss(String fileAddrss) {
	        this.fileAddrss = fileAddrss;
	    }

	    public String getFileType() {
	        return fileType;
	    }

	    public void setFileType(String fileType) {
	        this.fileType = fileType;
	    }

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public int getMaxSize() {
	        return maxSize;
	    }

	    public void setMaxSize(int maxSize) {
	        this.maxSize = maxSize;
	    }

	    public String getRealName() {
	        return realName;
	    }

	    public void setRealName(String realName) {
	        this.realName = realName;
	    }

	    public String getSaveName() {
	        return saveName;
	    }

	    public void setSaveName(String saveName) {
	        this.saveName = saveName;
	    }

	    public long getUpdateTime() {
	        return updateTime;
	    }

	    public void setUpdateTime(long updateTime) {
	        this.updateTime = updateTime;
	    }

	   
}
