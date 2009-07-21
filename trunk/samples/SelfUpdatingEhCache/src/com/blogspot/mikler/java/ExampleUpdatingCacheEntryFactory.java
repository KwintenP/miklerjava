package com.blogspot.mikler.java;

import net.sf.ehcache.constructs.blocking.UpdatingCacheEntryFactory;
import net.sf.ehcache.constructs.blocking.CacheEntryFactory;

public class ExampleUpdatingCacheEntryFactory implements CacheEntryFactory {
    public void updateEntryValue(Object key, Object value) throws Exception {
        System.out.println("~~~~~~UPDATING entry for key = " + key);
        final StringBuffer stringBuffer = (StringBuffer) value;
        stringBuffer.append(stringBuffer.length()- ((String) key).length());
    }

    public Object createEntry(Object key) throws Exception {
        System.out.println("++++++creating entry for key = " + key);
        return new StringBuffer(key+"0");
    }
}
