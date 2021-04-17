package byx.ioc.extension.aop.test4;

import byx.ioc.annotation.Autowired;
import byx.ioc.annotation.Component;
import byx.ioc.extension.aop.annotation.AdviceBy;

@Component
@AdviceBy(Advice.class)
public class A {
    @Autowired
    private B b;

    public B getB() {
        return b;
    }

    public int f() {
        return 2002;
    }
}
