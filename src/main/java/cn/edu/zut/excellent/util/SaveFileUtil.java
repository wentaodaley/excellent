package cn.edu.zut.excellent.util;

import java.io.*;


public class SaveFileUtil {

    public static void SaveFileFromInputStream(InputStream stream, String path, String filename) throws IOException {

        File f = new File(path + "/");
        if (!f.exists()) {
            f.mkdirs();
        }
        FileOutputStream fs = new FileOutputStream(path + "/" + filename);
        byte[] buffer = new byte[1024];
        int bytesum = 0;
        int byteread;
        while ((byteread = stream.read(buffer)) != -1) {
            bytesum += byteread;
            fs.write(buffer, 0, byteread);
            fs.flush();
        }
        fs.close();
        stream.close();
    }

    public static void down(String path, OutputStream outputStream) throws IOException {
        BufferedInputStream bis = null;
//        System.out.println(path+"*--*");
        File file = new File(path);
        if (!file.exists()) {
        	System.out.println("新建文件夹");
            return;
        }
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            byte[] buff = new byte[1024*1024];
            int bytesRead;
            while (-1 != (bytesRead = bis.read(buff, 0, buff.length))) {
            	System.out.println("222222");
                outputStream.write(buff, 0, bytesRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (bis != null)
                bis.close();
            if (outputStream != null)
                outputStream.close();
        }
    }

}
