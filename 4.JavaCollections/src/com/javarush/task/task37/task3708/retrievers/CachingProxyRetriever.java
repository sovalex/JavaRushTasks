package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

/**
 * Created by work on 24.02.2017.
 */
public class CachingProxyRetriever  implements Retriever {
    LRUCache<Long,Object> lruCache;
    OriginalRetriever originalRetriever;
    Storage storage;

    public CachingProxyRetriever(Storage storage) {
        lruCache = new LRUCache<>(10);
        this.storage = storage;
        this.originalRetriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object o = null;
       if ((o=lruCache.find(id))!=null){
           return o;
       }else {
           o =  originalRetriever.retrieve(id);
           if (lruCache.find(id)==null) {
               lruCache.set(id, o);
           }
           return o;
       }
    }
}
