package com.kkbpro.terminal.utils;


/**
 * 字符串相关工具类
 */
public class StringUtil {

    /**
     * 判断是否为空
     */
    public static boolean isEmpty(String str) {
        if (null == str || "".equals(str) || "null".equals(str) || "\u0000".equals(str)) {
            return true;
        } else if ("".equals(str.trim())) {
            return true;
        }
        return false;
    }

    /**
     * 判断参数1是否为参数2的前缀
     */
    public static boolean isPrefix(String a, String b) {
        if(a == null) return true;
        if(b == null) return false;

        int len_a = a.length();
        int len_b = b.length();

        if(len_a > len_b) return false;

        for(int i=len_a-1;i>=0;i--) if(a.charAt(i) != b.charAt(i)) return false;

        return true;
    }

    /**
     *  将字符串的'@'转为'/'
     */
    public static String changeStr(String str) {
        StringBuilder result = new StringBuilder();
        for (int i=0;i<str.length();i++) {
            if(str.charAt(i) != '@') result.append(str.charAt(i));
            else result.append('/');
        }

        return result.toString();
    }

    /**
     * 判断分片文件名
     */
    public static Boolean isFileChunk(String chunkFileName, Integer chunks, String originFileName) {
        int index = chunkFileName.lastIndexOf("-");
        if(index != -1) {
            String fileName = chunkFileName.substring(0,index);
            if(!originFileName.equals(fileName)) return false;
            try {
                int chunk = Integer.parseInt(chunkFileName.substring(index + 1));
                if(chunk < 1 || chunk > chunks) return false;
            } catch (Exception e) {
                return false;
            }
            return true;
        }

        return false;
    }

    /**
     * 获取文件片片号
     */
    public static Integer getFileChunkIndex(String chunkFileName) {
        int index = chunkFileName.lastIndexOf("-");
        if(index != -1) {
            return Integer.parseInt(chunkFileName.substring(index + 1));
        }

        return 1;
    }

}
