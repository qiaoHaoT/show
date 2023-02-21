package org.qiaoHaoTing.show.serialization.factory;

import com.caucho.hessian.io.HessianProtocolException;
import com.caucho.hessian.io.Serializer;
import com.caucho.hessian.io.SerializerFactory;
import org.qiaoHaoTing.show.serialization.java8.*;

import java.time.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ShowHessianSerializerFactory extends SerializerFactory {

    public static Map<Class, Serializer> JAVA8_SERIALIZER_MAP = new ConcurrentHashMap<>();

    static {
        JAVA8_SERIALIZER_MAP.put(LocalDateTime.class, Java8TimeSerializer.create(LocalDateTimeHandle.class));
        JAVA8_SERIALIZER_MAP.put(LocalDate.class, Java8TimeSerializer.create(LocalDateHandle.class));
        JAVA8_SERIALIZER_MAP.put(LocalTime.class, Java8TimeSerializer.create(LocalTimeHandle.class));

        JAVA8_SERIALIZER_MAP.put(Instant.class, Java8TimeSerializer.create(InstantHandle.class));
        JAVA8_SERIALIZER_MAP.put(Duration.class, Java8TimeSerializer.create(DurationHandle.class));
        JAVA8_SERIALIZER_MAP.put(Period.class, Java8TimeSerializer.create(PeriodHandle.class));

        JAVA8_SERIALIZER_MAP.put(MonthDay.class, Java8TimeSerializer.create(MonthDayHandle.class));
        JAVA8_SERIALIZER_MAP.put(Year.class, Java8TimeSerializer.create(YearHandle.class));
        JAVA8_SERIALIZER_MAP.put(YearMonth.class, Java8TimeSerializer.create(YearMonthHandle.class));

        JAVA8_SERIALIZER_MAP.put(ZonedDateTime.class, Java8TimeSerializer.create(ZonedDateTimeHandle.class));
        JAVA8_SERIALIZER_MAP.put(ZoneOffset.class, Java8TimeSerializer.create(ZoneOffsetHandle.class));
        JAVA8_SERIALIZER_MAP.put(OffsetDateTime.class, Java8TimeSerializer.create(OffsetDateTimeHandle.class));
        JAVA8_SERIALIZER_MAP.put(OffsetTime.class, Java8TimeSerializer.create(OffsetTimeHandle.class));

        JAVA8_SERIALIZER_MAP.put(ZoneId.class, ZoneIdSerializer.getInstance());

    }


    @Override
    protected Serializer loadSerializer(Class cl) throws HessianProtocolException {
        if(JAVA8_SERIALIZER_MAP.containsKey(cl)) {
            return JAVA8_SERIALIZER_MAP.get(cl);
        }
        return super.loadSerializer(cl);
    }
}
