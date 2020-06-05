package com.xiazhi.scan;

import com.xiazhi.scan.bean.ScanClass;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Service;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/28
 **/
@ComponentScan( useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = MyFilter.class)})
public class ScanDemo {
}
