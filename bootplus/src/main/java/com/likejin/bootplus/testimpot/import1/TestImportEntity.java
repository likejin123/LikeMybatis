package com.likejin.bootplus.testimpot.import1;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author 李柯锦
 * @Date 2023/5/30 21:14
 * @Description 测试@Import用到的实体类
 */
public class TestImportEntity implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        System.out.println("调用该方法");
        return new String[]{"com.likejin.bootplus.testimpot.import1.Person"};
    }
}
