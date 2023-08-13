package com.taba.taxProject.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(name="taxinfo")
public class taxInfo {


    @Id
    private int id;
    @Column("description")
    private String description;
    @Column("funcstatus")
    private boolean funcStatus;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFuncStatus() {
        return funcStatus;
    }

    public void setFuncStatus(boolean funcStatus) {
        this.funcStatus = funcStatus;
    }



    public taxInfo() {

    }

    public taxInfo(String description, boolean published) {
        this.description = description;
        this.funcStatus = published;
    }
}
