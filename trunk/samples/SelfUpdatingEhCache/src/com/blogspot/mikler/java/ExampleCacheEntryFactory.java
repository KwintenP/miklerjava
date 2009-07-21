package com.blogspot.mikler.java;

import net.sf.ehcache.constructs.blocking.UpdatingCacheEntryFactory;
import net.sf.ehcache.constructs.blocking.CacheEntryFactory;

public class ExampleCacheEntryFactory implements CacheEntryFactory {

    public Object createEntry(Object key) throws Exception {
        System.out.println("++++++creating entry for key = " + key);
        return new StringBuffer(key+"0");
    }
}
