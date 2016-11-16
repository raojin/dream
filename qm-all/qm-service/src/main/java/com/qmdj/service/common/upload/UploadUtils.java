package com.qmdj.service.common.upload;


import main.java.com.UpYun;
import org.apache.commons.lang.StringUtils;


import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

/**
 * 文件上传
 */
public class UploadUtils {

    // 获取图片的域名
    public static final String DOMAIN = "http://qmdjpicture.b0.upaiyun.com";

    private static final String IMAGE_DIR = "/qmdj/images";

    private static final String FILE_DIR = "/qmdj/file";

    private static final String FILE_SECRET = "qmdj";
/**
 * 
 * 
 upyun.bucket.name=uhuimage
upyun.operator.name=uhuimage
upyun.operator.pwd=!uhu@1024
upyun.domain.url=http://uhuimage.b0.upaiyun.com
 * 
 * 
 * */
    // 间隔标识符 用于分隔文件 URL 和文件参数
    private static final String SEPARATOR = "!";

    private static final Random R = new Random();

    // 声明并初始化友护云工具类
    private static UpYun upyun;
    
    private static String bucket="qmdjpicture";//qmdjpicture
    private static String username="quan123";//quan123
    private static String password="quan1234"; //quan1234

    static {

        upyun = new UpYun(bucket, username,password);
    }

    /**
     * 图片上传
     *
     * @param file
     *            文件对象
     * @param isSecret
     *            是否设置访问秘钥 是：true
     * @return
     * @throws IOException
     * @author ShenQuan 2016年8月22日 上午11:08:55
     */
    public static String imageUpload(File file, Boolean isSecret) throws IOException {

        if (file == null) {

            return "";
        }

        String path = getFilePath(file.getName(), "img");

        upyun.setContentMD5(UpYun.md5(file));

        if (isSecret) {

            upyun.setFileSecret(FILE_SECRET);
        }

        Boolean flag = upyun.writeFile(path, file, true);

        if (flag) {

            if (isSecret) {

                return path + SEPARATOR + FILE_SECRET;
            }
            return DOMAIN+path;
        }

        return "";
    }

    /**
     * 图片上传
     *
     * @param file
     *            文件对象
     * @param isSecret
     *            是否设置访问秘钥 是：true
     * @return
     * @throws IOException
     * @author ShenQuan 2016年8月22日 上午11:08:55
     */
    public static String imageUpload(String fileName, byte[] file, Boolean isSecret) throws IOException {

        if (fileName == null) {

            return "";
        }

        String path = getFilePath(fileName, "img");

         //upyun.setContentMD5(UpYun.md5(file));

        if (isSecret) {

            upyun.setFileSecret(FILE_SECRET);
        }

        Boolean flag = upyun.writeFile(path, file, true);

        if (flag) {

            if (isSecret) {

                return path + SEPARATOR + FILE_SECRET;
            }
            return DOMAIN+path;
        }

        return "";
    }

    /**
     * 文件存储位置及文件名称生成规则
     *
     * @param fileName
     *            文件的名称
     * @param type
     *            上传文件的类型，图片:"img"，其他暂无
     * @author ShenQuan
     * @return
     */
    private static String getFilePath(String fileName, String type) {

        if (StringUtils.isBlank(fileName)) {

            return "";
        }

        StringBuilder path = new StringBuilder();

        if ("img".equals(type)) {
            // 图片所属的文件夹
            path.append(IMAGE_DIR);

            // 文件名称生成规则 img+时间戳+三位随机数+文件后缀
            path.append("/img").append(System.currentTimeMillis());
            path.append("_");
            path.append(R.nextInt(10)).append(R.nextInt(10)).append(R.nextInt(10));

            int index = fileName.indexOf(".");

            if (index > -1) {
                String suffix = StringUtils.substring(fileName, index);
                path.append(suffix);
            }

        } else {
            // 非图片文件使用原始名称
            path.append(FILE_DIR).append("/").append(fileName);
        }
        return path.toString();
    }
    
    public static byte[] File2byte(String filePath) throws IOException  
    {  
        byte[] buffer = null;  
            File file = new File(filePath);  
            FileInputStream fis = new FileInputStream(file);  
            ByteArrayOutputStream bos = new ByteArrayOutputStream();  
            byte[] b = new byte[1024];  
            int n;  
            while ((n = fis.read(b)) != -1)  
            {  
                bos.write(b, 0, n);  
            }  
            fis.close();  
            bos.close();  
            buffer = bos.toByteArray();  
        return buffer;  
    }  
    
    
    public static void main(String[] args) {
		File file=new File("/Users/chenjin/Downloads/9C264ED1-4E5D-4C1A-BBCE-6BE77D9664E3.png");
		try {
			System.out.println("fileName="+UploadUtils.imageUpload(file,false));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

