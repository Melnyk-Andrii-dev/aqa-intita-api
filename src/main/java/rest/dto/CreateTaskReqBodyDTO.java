package rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CreateTaskReqBodyDTO {

    CreateTaskBody createTaskBody;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    @Builder
    public static class CreateTaskBody {
        private Task task;
        private ArrayList<Object> attachedFiles;
        private long tempUid;
        private Object taskId;
        private Assignee assignee;
        private ArrayList<Watcher> watcher;
        private ArrayList<Collaborator> collaborator;
        private Creator creator;

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public static class Task {
            private String name;
            private String body;
            private int type;
            private int priority;
            private String deadline;
            private String expected_time;
            private String startTask;
            private String endTask;
            private int id;
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public static class Collaborator {
            private int id;
            private String firstName;
            private String full_name;
            private Object middleName;
            private Object secondName;
            private Object nickname;
            private Object birthday;
            private String email;
            private String corporate_mail;
            private Object facebook;
            private Object googleplus;
            private Object linkedin;
            private Object twitter;
            private Object phone;
            private Object address;
            private Object education;
            private int educform;
            private Object interests;
            private Object aboutUs;
            private Object aboutMy;
            private String avatar;
            private int role;
            private String reg_time;
            private String skype;
            private Object country;
            private Object city;
            private Object prev_job;
            private Object current_job;
            private Object education_shift;
            private String title;
            private String shortTitle;
            private Object userStatus;
            private String label;
            private String type;
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public static class Watcher{
            private int id;
            private String firstName;
            private String full_name;
            private Object middleName;
            private Object secondName;
            private Object nickname;
            private Object birthday;
            private String email;
            private String corporate_mail;
            private Object facebook;
            private Object googleplus;
            private Object linkedin;
            private Object twitter;
            private Object phone;
            private Object address;
            private Object education;
            private int educform;
            private Object interests;
            private Object aboutUs;
            private Object aboutMy;
            private String avatar;
            private int role;
            private String reg_time;
            private String skype;
            private Object country;
            private Object city;
            private Object prev_job;
            private Object current_job;
            private Object education_shift;
            private String title;
            private String shortTitle;
            private Object userStatus;
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public static class Creator{
            private int id;
        }

        @AllArgsConstructor
        @NoArgsConstructor
        @Data
        @Builder
        public static class Assignee{
            private int id;
        }
    }
}
