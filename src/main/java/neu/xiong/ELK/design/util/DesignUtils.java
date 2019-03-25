package neu.xiong.ELK.design.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DesignUtils {
	/**
	 * 序列化对象
	 * @return
	 */
	public static  String serialize(Object obj){
		
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos;
			String result =null;
			try {
				oos = new ObjectOutputStream(bos);
				oos.writeObject(obj);
				result = bos.toString("ISO-8859-1");
				oos.close();
				bos.close();
			} catch (IOException e) {
				System.out.println("序列化对象失败！");
				e.printStackTrace();
			}	
		return result;
	}
	
	/**
	 * 反序列对象
	 */
	public static Object deserialize(String str){
		Object object= null ;
		try {
			ByteArrayInputStream bis = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));
			ObjectInputStream ois = new ObjectInputStream(bis);
			object  = ois.readObject();
			ois.close();
			bis.close();
		} catch (Exception e) {
			System.out.println("反序列化错误！");
			e.printStackTrace();
		}
		return object;
	}
}
