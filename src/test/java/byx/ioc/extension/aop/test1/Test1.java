package byx.ioc.extension.aop.test1;

import byx.ioc.core.Container;
import byx.ioc.extension.aop.Flag;
import byx.ioc.factory.AnnotationContainerFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * 增强一个对象
 */
public class Test1 {
    @Test
    public void test() {
        Container container = new AnnotationContainerFactory(Test1.class).create();
        for (String id : container.getObjectIds()) {
            System.out.println(id);
        }

        A a = container.getObject(A.class);

        Flag.f1 = Flag.f2 = false;
        a.f(123);
        assertTrue(Flag.f1);
        assertTrue(Flag.f2);

        Flag.f1 = Flag.f2 = false;
        a.g();
        assertFalse(Flag.f1);
        assertTrue(Flag.f2);
    }
}
