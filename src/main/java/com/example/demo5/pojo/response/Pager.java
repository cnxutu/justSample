package com.example.demo5.pojo.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Pager<DATA> implements Serializable {
    int index;
    int size;
    int total;
    List<DATA> list;

    public Pager(int index, int size) {
        this.index = index;
        this.size = size;
    }

    public Pager() {
    }

    @JsonIgnore
    public int getStart() {
        return index * size;
    }

    @JsonIgnore
    public int getEnd() {
        return (index + 1) * size;
    }
}
