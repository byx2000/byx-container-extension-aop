package byx.ioc.extension.aop.test3;

import byx.ioc.annotation.Component;
import byx.ioc.extension.aop.annotation.AdviceBy;

@Component
@AdviceBy(Advice.class)
public class A {
    public int f() {
        return 1001;
    }
}
