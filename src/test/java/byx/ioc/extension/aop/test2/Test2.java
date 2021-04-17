package byx.ioc.extension.aop.test2;

import byx.ioc.core.Container;
import byx.ioc.factory.AnnotationContainerFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

/**
 * 注入增强对象，产生一个对象的循环依赖
 */
public class Test2 {
    @Test
    public void test() {
        Container container = new AnnotationContainerFactory(Test2.class).create();
        for (String id : container.getObjectIds()) {
            System.out.println(id);
        }

        A a = container.getObject(A.class);
        A aa = a.getA();

        assertSame(a, aa);
        assertEquals(889, a.f());
        assertEquals(889, a.f());
    }
}
