package com.likejin.bootplus.testimpot.import1;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @Author 李柯锦
 * @Date 2023/5/30 21:15
 * @Description 测试@Import
 */

@Configuration
@Import(TestImportEntity.class)
public class TestImport1 {
}
