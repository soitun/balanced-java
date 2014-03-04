package com.balancedpayments.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.balancedpayments.Balanced;
import com.balancedpayments.errors.HTTPError;

public class ResourcePage<T> {
    
    private Client client = Balanced.getInstance().getClient();
    
    public String uri;
    
    private Class<T> cls;
    private ArrayList<T> items;
    private Integer total;
    private String first_uri;
    private String previous_uri;
    private String next_uri;
    private String last_uri;
    
    public ResourcePage(
            Class<T> cls,
            String uri,
            ArrayList<T> items,
            int total,
            String first_uri,
            String previous_uri,
            String next_uri,
            String last_uri)
    {
        this.cls = cls;
        this.uri = uri;
        this.items = items;
        this.total = total;        
        this.first_uri = first_uri;
        this.previous_uri = previous_uri;
        this.next_uri = next_uri;
        this.last_uri = last_uri;
        
    }
    
    public ResourcePage(
            Class<T> cls,
            String uri)
    {
        this.cls = cls;
        this.uri = uri;
    }
    
    public int getSize() throws HTTPError {
        return getItems().size();
    }
    
    public ArrayList<T> getItems() throws HTTPError {
        if (items == null) 
            load();
        return items;
    }
    
    public String getFirstUri() throws HTTPError {
        if (items == null) 
            load();
        return first_uri;
    }
    
    public ResourcePage<T> getFirst() throws HTTPError {
        return new ResourcePage<T>(cls, getFirstUri());
    }
    
    public String getPreviousUri() throws HTTPError {
        if (items == null) 
            load();
        return previous_uri;
    }
    
    public ResourcePage<T> getPrevious() throws HTTPError {
        return new ResourcePage<T>(cls, getPreviousUri());
    }
    
    public String getNextUri() throws HTTPError {
        if (items == null) 
            load();
        return next_uri;
    }
    
    public ResourcePage<T> getNext() throws HTTPError {
        return new ResourcePage<T>(cls, getNextUri());
    }
    
    public String getLastUri() throws HTTPError {
        return last_uri;
    }
    
    public ResourcePage<T> getLast() throws HTTPError {
        return new ResourcePage<T>(cls, getLastUri());
    }

    
    public Integer getTotal() throws HTTPError {
        if (items == null) 
            load();
        return total;
    }
    
    private void load() throws HTTPError {
        Map<String, Object> page = client.get(uri);
        Map<String, Object> meta = (Map<String, Object>) page.get("meta");
        uri = (String) meta.get("href");
        total = ((Double) meta.get("total")).intValue();
        first_uri = (String) meta.get("first");
        previous_uri = (String) meta.get("previous");
        next_uri = (String) meta.get("next");
        last_uri = (String) meta.get("last");

        Map<String, String> hyperlinks = (Map<String, String>) page.remove("links");
        Map<String, String> resourceMeta = (Map<String, String>) page.remove("meta");

        List<Map<String, Object>> objs = (List<Map<String, Object>>) page.get(Utils.classNameToResourceKey(cls.getSimpleName()));
        if (objs != null) {
            items = new ArrayList<T>(objs.size());
            try {
                for (Map<String, Object> obj: objs) {
                    T t = cls.newInstance();
                    ((Resource) t).hydrate(hyperlinks, resourceMeta, obj);
                    ((Resource) t).constructFromResponse(obj);
                    items.add(t);
                }
            }
            catch (InstantiationException e) {
                throw new RuntimeException(e);
            }
            catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
