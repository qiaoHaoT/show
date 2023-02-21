package org.qiaoHaoTing.show.serialization;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.SerializerFactory;
import org.qiaoHaoTing.show.domain.Cat;
import org.qiaoHaoTing.show.serialization.factory.ShowHessianSerializerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.LocalDateTime;

public class SerializerUtil {

    private static SerializerFactory serializerFactory = new ShowHessianSerializerFactory();
    //private static SerializerFactory serializerFactory = new SerializerFactory();

    public static byte[] serialize(Object obj) throws Exception{
        ByteArrayOutputStream os = new ByteArrayOutputStream();

        try {
            Hessian2Output output = new Hessian2Output(os);
            output.setSerializerFactory(serializerFactory);

            output.writeObject(obj);
            output.flush();
            return os.toByteArray();
        } finally {
            os.close();
        }
    }

    public static Object deSerialize(byte[] bytes) throws Exception{
        ByteArrayInputStream is = new ByteArrayInputStream(bytes);
        try {
            Hessian2Input hessian2Input = new Hessian2Input(is);
            hessian2Input.setSerializerFactory(serializerFactory);
            return hessian2Input.readObject();
        } finally {
            is.close();
        }
    }

    public static void main(String[] args) throws Exception{
        Cat cat = new Cat();
        cat.setAge(2);
        cat.setName("招财猫");
        cat.setBirthday(LocalDateTime.now());

        byte[] bytes = serialize(cat);

        Object obj = deSerialize(bytes);

        int i = 0;
    }


}
