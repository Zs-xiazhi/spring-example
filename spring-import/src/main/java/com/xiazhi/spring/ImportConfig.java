package com.xiazhi.spring;

import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;

import javax.xml.ws.Service;

/**
 * @author ZhaoShuai
 * @date Create in 2020/5/29
 **/

@Import(ServiceImportSelector.class)
public class ImportConfig {
}
