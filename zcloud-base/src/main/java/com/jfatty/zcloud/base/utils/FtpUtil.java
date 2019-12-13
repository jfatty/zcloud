package com.jfatty.zcloud.base.utils;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * ftp上传下载工具类
 * <p>Title: FtpUtil</p>
 * <p>Description: </p>
 */
public class FtpUtil implements Serializable {


    /**
     * 获取文件类型
     * @param fileName
     * @return
     */
    public static String getPictureType(String fileName){
        if(fileName.endsWith(".jpg") || fileName.endsWith(".jepg")){
            return ".jpg";
        }else if(fileName.endsWith(".png") || fileName.endsWith(".PNG")){
            return ".png";
        } else{
            return "application/octet-stream";
        }
    }

    /**
     * Description: 向FTP服务器上传文件
     * @param host 主机IP必须传入
     *  FTP服务器端口  默认使用 21
     *   FTP登录账号  默认使用 ftpser
     *   FTP登录密码  默认使用 ftpuser
     *   /opt/httpd/htdocs/ FTP服务器基础目录
     * @param filePath  /2015/01/01
     * @param filename  上传到FTP服务器上的文件名
     * @param input 输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(String host, String filePath, String filename, InputStream input){
        return uploadFile(host, 21, "ftpser", "ftpuser", "/opt/httpd/htdocs/", filePath, filename, input);
    }

    /**
     * Description: 向FTP服务器上传文件
     * @param host FTP服务器hostname
     * @param port FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param basePath FTP服务器基础目录
     * @param filePath FTP服务器文件存放路径。例如分日期存放：/2015/01/01。文件的路径为basePath+filePath
     * @param filename 上传到FTP服务器上的文件名
     * @param input 输入流
     * @return 成功返回true，否则返回false
     */
    public static boolean uploadFile(String host, int port, String username, String password, String basePath, String filePath, String filename, InputStream input) {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            /**
             * 主机和端口号
             */
            ftp.connect(host, port);// 连接FTP服务器
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            ftp.setControlEncoding("UTF-8");
            ftp.enterLocalPassiveMode();
            //切换到上传目录
            if (!ftp.changeWorkingDirectory(basePath+filePath)) {
                //如果目录不存在创建目录
                String[] dirs = filePath.split("/");
                String tempPath = basePath;
                for (String dir : dirs) {
                    if (null == dir || "".equals(dir)) continue;
                    tempPath += "/" + dir;
                    if (!ftp.changeWorkingDirectory(tempPath)) {
                        if (!ftp.makeDirectory(tempPath)) {
                            return result;
                        } else {
                            ftp.changeWorkingDirectory(tempPath);
                        }
                    }
                }
            }
            /**
             * 很重要
             * 设置上传文件的类型为二进制类型
             */
            ftp.setFileType(FTP.BINARY_FILE_TYPE);
            //上传文件
            if (!ftp.storeFile(filename, input)) {
                return result;
            }
            input.close();
            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * Description: 从FTP服务器下载文件
     * @param host FTP服务器hostname
     * @param port FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param remotePath FTP服务器上的相对路径
     * @param fileName 要下载的文件名
     * @param localPath 下载后保存到本地的路径
     * @return
     */
    public static boolean downloadFile(String host, int port, String username, String password, String remotePath, String fileName, String localPath) {
        boolean result = false;
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(host, port);
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return result;
            }
            ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录
            FTPFile[] fs = ftp.listFiles();
            for (FTPFile ff : fs) {
                if (ff.getName().equals(fileName)) {
                    File localFile = new File(localPath + "/" + ff.getName());

                    OutputStream is = new FileOutputStream(localFile);
                    ftp.retrieveFile(ff.getName(), is);
                    is.close();
                }
            }

            ftp.logout();
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return result;
    }


    /**
     * Description: 从FTP服务器删除文件
     * @param host FTP服务器hostname
     * @param port FTP服务器端口
     * @param username FTP登录账号
     * @param password FTP登录密码
     * @param imageUrlPrefix 文件路径前缀
     * @param ids 系统中保存的文件 ID 集合
     * @param paths 文件路径集合
     * @return
     */
    public static List<String> deleteFile(String host, int port, String username, String password,String imageUrlPrefix, List<String> ids, List<String> paths) {
        List<String> delIds = new ArrayList<String>();
        FTPClient ftp = new FTPClient();
        try {
            int reply;
            ftp.connect(host, port);
            // 如果采用默认端口，可以使用ftp.connect(host)的方式直接连接FTP服务器
            ftp.login(username, password);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                return delIds ;
            }
            int end = ids.size() ;
            for( int i = 0 ; i < end ; i++ ){
                String path = paths.get(i) ;
                path = path.substring(imageUrlPrefix.length(),path.length());
                if (ftp.deleteFile(path))
                    delIds.add(ids.get(i));
            }
            ftp.logout();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return delIds;
    }


    public static void main(String[] args) {
        try {
            FileInputStream in=new FileInputStream(new File("D:\\weixin.png"));
            boolean flag = uploadFile("192.168.126.153", 23, "ftpuser", "ftpuser", "/","/", "_a110.png", in);
            System.out.println(flag);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
