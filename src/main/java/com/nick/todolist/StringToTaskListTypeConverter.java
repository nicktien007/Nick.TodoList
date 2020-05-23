package com.nick.todolist;

import com.nick.todolist.enums.TaskListType;
import org.springframework.core.convert.converter.Converter;

public class StringToTaskListTypeConverter implements Converter<String, TaskListType> {
    @Override
    public TaskListType convert(String source) {
        return TaskListType.valueOf(source.toUpperCase());
    }
}