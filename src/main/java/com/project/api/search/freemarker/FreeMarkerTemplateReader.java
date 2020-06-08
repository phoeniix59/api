package com.project.api.search.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.ui.freemarker.FreeMarkerTemplateUtils.processTemplateIntoString;

@Component
public class FreeMarkerTemplateReader {

    private Configuration freemarkerConfiguration;

    @PostConstruct
    public void init() {
        this.freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
        this.freemarkerConfiguration.setDefaultEncoding("UTF-8");
        this.freemarkerConfiguration.setClassLoaderForTemplateLoading(Thread.currentThread().getContextClassLoader(), "freemarker");
    }

    public String readTemplate(String templateName, Map<String, Object> templateParameters) {
        try {
            Template requestBodyTemplate = freemarkerConfiguration.getTemplate(templateName);
            return processTemplateIntoString(requestBodyTemplate, templateParameters);
        } catch (IOException | TemplateException e) {
            throw new RuntimeException(e);
        }
    }

    public String readTemplate(String templateName) {
        return this.readTemplate(templateName, new HashMap<>());
    }
}

