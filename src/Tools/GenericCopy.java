package Tools;

import java.io.*;

/**
 * @author 肖瑜
 */
public class GenericCopy {
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
