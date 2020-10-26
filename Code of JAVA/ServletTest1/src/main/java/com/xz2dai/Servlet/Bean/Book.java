package com.xz2dai.Servlet.Bean;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;

    public Book(){

    }

    public Book(String m_id,String m_name){
        this.id = m_id;
        this.name = m_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
