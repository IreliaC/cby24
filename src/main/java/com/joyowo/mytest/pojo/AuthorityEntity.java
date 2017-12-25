package com.joyowo.mytest.pojo;

import javax.persistence.*;
import java.util.Arrays;

/**
 * Author: chenby
 * Date: 2017-12-15
 */
@Entity
@Table(name = "authority", schema = "test", catalog = "")
public class AuthorityEntity {
    private long id;
    private byte[] createTime;
    private byte[] updateTime;
    private String name;
    private String value;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "create_time")
    public byte[] getCreateTime() {
        return createTime;
    }

    public void setCreateTime(byte[] createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "update_time")
    public byte[] getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(byte[] updateTime) {
        this.updateTime = updateTime;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthorityEntity that = (AuthorityEntity) o;

        if (id != that.id) return false;
        if (!Arrays.equals(createTime, that.createTime)) return false;
        if (!Arrays.equals(updateTime, that.updateTime)) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + Arrays.hashCode(createTime);
        result = 31 * result + Arrays.hashCode(updateTime);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
