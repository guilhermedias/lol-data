package br.psc.guilherme.lol.data;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import picocli.CommandLine.IFactory;

@Component
public class CommandFactory implements IFactory, ApplicationContextAware {
    private ApplicationContext applicationContext;

    @Override
    public <T> T create(Class<T> cls) {
        return applicationContext.getBean(cls);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
