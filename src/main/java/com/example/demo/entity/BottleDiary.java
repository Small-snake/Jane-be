package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author smallsnake
 * @since 2022-05-22
 */
@TableName("bottle_diary")
public class BottleDiary implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String username;

    private String diaryId;

    private String content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getDiaryId() {
        return diaryId;
    }

    public void setDiaryId(String diaryId) {
        this.diaryId = diaryId;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "BottleDiary{" +
            "id=" + id +
            ", username=" + username +
            ", diaryId=" + diaryId +
            ", content=" + content +
        "}";
    }
}
