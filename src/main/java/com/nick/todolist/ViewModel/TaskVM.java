package com.nick.todolist.ViewModel;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskVM {

    private final Long id;

    private final String title;

    private final String description;

    private final LocalDateTime deadLine ;

    private final LocalDateTime createDate ;

    private final Boolean done ;

    public boolean getIsWarning(){
        return this.deadLine.isBefore(LocalDateTime.now());
    }
}
