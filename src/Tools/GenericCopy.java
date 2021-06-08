package Tools;

import java.io.*;

/**
 * @author 肖瑜
 */
public class GenericCopy {
    /**
     * 使用序列化深拷贝
     * @param target 待拷贝对象
     * @param <E> 对象类型
     * @return 拷贝后对象
     * @throws IOException 异常
     * @throws ClassNotFoundException 异常
     */
    public static <E> E deepCopy(E target) throws IOException, ClassNotFoundException {
        //将对象写入流中
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(target);
        objectOutputStream.flush();
        objectOutputStream.close();

        //从流中取出
        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        return (E) objectInputStream.readObject();
    }
}
