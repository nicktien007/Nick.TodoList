package com.nick.todolist.ViewModel;

import lombok.Builder;
import lombok.Data;
import net.bytebuddy.implementation.bytecode.assign.TypeCasting;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskVM {

    private final Long id;

    private final String title;

    private final String description;

    private final String deadLine ;

    private final String createDate ;

    private final boolean done ;

    private final Boolean isWarning;

}
