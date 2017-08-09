package com.coffee.share.common.spring;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * 
 * @author and04
 *
 */
public class ResourceUtil implements ResourceLoaderAware {

    private static ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        ResourceUtil.resourceLoader = resourceLoader;
    }

    /**
     * 根据url获取输入流
     * 
     * @param url
     * @return
     * @throws IOException
     */
    public static InputStream getResourceAsStream(String url) throws IOException {
        Resource resource = resourceLoader.getResource(url);
        if (resource == null) {
            return null;
        }
        return resource.getInputStream();
    }

}
