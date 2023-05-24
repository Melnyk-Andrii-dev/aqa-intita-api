package cache;

import lombok.Getter;

public enum TestCacheKey {
    TASK_ID("id"),
    TASK_NAME("taskName"),
    EMAIL("email"),
    SESSION_ID("sessionId"),
    TOKEN("token"),
    CREATED_TASK_DTO("createdTaskDto"),
    LOGGEDIN_COOKIES("loggedInCookies"),
    COURSE_NICKNAME("courseNickname"),
    LESSON_ID("lessonId"),
    PART_ID("partId"),
    PART_TEXT("partText"),
    EXERCISE_ID("exerciseId"),
    RIGHT_ANSWER_ID("rightAnswerId"),
    WRONG_ANSWER_ID("wrongAnswerId"),
    MODULE_NAME("moduleName");

    @Getter
    private final String key;

    TestCacheKey(String key) {
        this.key = key;
    }
}
